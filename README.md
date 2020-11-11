# Table of contents
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
- [Introduction](#introduction)
- [Run using Gradle](#run-using-gradle)
  - [HTTP Request](#http-request)
- [Development](#development)
  - [HTTP Request](#http-request-1)
- [Release](#release)
  - [Release Docker image](#release-docker-image)
  - [Release Helm chart](#release-helm-chart)
<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# Introduction
Simple Micronaut "Who Am I" microservice

Executing an HTTP request to / will return the hostname of the server

# Run using Gradle
```bash
./gradlew run
```

## HTTP Request
Perform a http request using HTTPie

```bash
http :8080
```

# Development
```bash
skaffold dev
```

## HTTP Request
Perform a http request using HTTPie

```bash
http whoami-mn.127.0.0.1.nip.io
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
helm package --sign --key 'sj' src/main/helm

curl --user $CHARTMUSEUM_AUTH_USER:$CHARTMUSEUM_AUTH_PASS \
  -F "chart=@surf-screenshotter-$version.tgz" \
  -F "prov=@surf-screenshotter-$version.tgz.prov" \
  https://helm-charts.fitfit.dk/api/charts
```

Commit and tag commit: RELEASE-$version

# Deploy
Update version, for the given environment, in `helmfile.yaml`

```bash
helmfile -e $env sync
```
