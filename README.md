# Who Am I?
Simple Micronaut "whoami" microservice

Executing an HTTP request to / will return the hostname of the server

# Run using Gradle
```bash
./gradlew run
```

# Development
```bash
skaffold dev
```

# HTTP Request
Perform a http request using HTTPie

```bash
http :8080 "Host:whoami-mn.127.0.0.1.nip.io"
```

# Release
## Release Docker image
Update version in `build.gradle`

```bash
./gradlew jib
```

## Release Helm chart
Update version (or versions) in `src/main/helm/Chart.yaml`

```bash
helm push src/main/helm tons --username $CHARTMUSEUM_AUTH_USER --password $CHARTMUSEUM_AUTH_PASS
```

# Deploy
Update version, for the given environment, in `helmfile.yaml`

```bash
helmfile -e $env sync
```
