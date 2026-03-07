const BASE_URL = "http://localhost:8080/";

const client = async (endpoint: string, options?: RequestInit) => {
  const response = await fetch(`${BASE_URL}${endpoint}`, {
    headers: {
      "Content-Type": "application/json"
    },
    ...options
  });

  if (!response.ok) throw new Error(await response.text());

  return response.json();
};

export default client;
