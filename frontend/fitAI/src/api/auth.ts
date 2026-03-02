import client from "./client";

export const register = (data) =>
  client("/auth/register", {
    method: "POST",
    body: JSON.stringify(data)
  });

export const login = (email: string, password: string) =>
  client("/auth/login", {
    method: "POST",
    body: JSON.stringify({ email, password })
  });
