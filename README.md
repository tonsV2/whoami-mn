# Who Am I?
Simple Micronaut "whoami" microservice

Executing a HTTP request to / will return the hostname of the server

# Development
```bash
skaffold dev --port-forward
```

# HTTP Request
```bash
http :8080 "Host:whoami-mn.dev.fitfit.dk"
```
