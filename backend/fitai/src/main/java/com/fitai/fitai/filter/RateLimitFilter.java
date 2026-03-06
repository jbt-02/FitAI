package com.fitai.fitai.filter;

import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RateLimitFilter extends OncePerRequestFilter {

  // One bucket per client IP
  private final Map<String, Bucket> bucketCache = new ConcurrentHashMap<>();

  /**
   * Creates a new bucket: 100 requests per minute (greedy refill).
   */
  private Bucket createNewBucket() {
    return Bucket.builder()
        .addLimit(limit -> limit
            .capacity(100)
            .refillGreedy(100, Duration.ofMinutes(1)))
        .build();
  }

  private Bucket resolveBucket(String clientKey) {
    return bucketCache.computeIfAbsent(clientKey, k -> createNewBucket());
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request,
      HttpServletResponse response,
      FilterChain filterChain)
      throws ServletException, IOException {

    String clientIp = resolveClientIp(request);
    Bucket bucket = resolveBucket(clientIp);

    // tryConsumeAndReturnRemaining gives us probe info for headers
    ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);

    if (probe.isConsumed()) {
      // Attach standard rate-limit headers
      response.addHeader("X-Rate-Limit-Remaining",
          String.valueOf(probe.getRemainingTokens()));
      filterChain.doFilter(request, response);
    } else {
      long waitSeconds = probe.getNanosToWaitForRefill() / 1_000_000_000;
      response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
      response.setContentType(MediaType.APPLICATION_JSON_VALUE);
      response.addHeader("X-Rate-Limit-Retry-After-Seconds",
          String.valueOf(waitSeconds));
      response.getWriter().write(
          "{\"error\": \"Too many requests. Please retry after "
              + waitSeconds + " seconds.\"}");
    }
  }

  /**
   * Resolves the real client IP, respecting X-Forwarded-For for proxied requests.
   */
  private String resolveClientIp(HttpServletRequest request) {
    String forwarded = request.getHeader("X-Forwarded-For");
    if (forwarded != null && !forwarded.isBlank()) {
      return forwarded.split(",")[0].trim();
    }
    return request.getRemoteAddr();
  }
}
