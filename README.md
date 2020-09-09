# Who Am I?
Simple Micronaut "whoami" microservice

Executing an HTTP request to / will return the hostname of the server

# Development
```bash
skaffold dev --port-forward
```

# HTTP Request
Perform http request using HTTPie

```bash
http :8080 "Host:whoami-mn.dev.fitfit.dk"
```

# Release Docker image
Update version in build.gradle

```bash
./gradlew jib
```

# Release Helm chart
Update version (or versions) in src/main/helm/Chart.yaml

```bash
helm push src/main/helm tons --username $CHARTMUSEUM_AUTH_USER --password $CHARTMUSEUM_AUTH_PASS
```
