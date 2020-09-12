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
http :8080 "Host:whoami-mn.dev.fitfit.dk"
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

Just tag don't merge to /release

# Release plugin
* Test
* Build image
* Security scan
* Build helm
* Tag current commit

CI
* Test
* Build image
* Security scan
* Build helm

CD
	if /master
		deploy to dev... Skaffold?
	if /release
		run deploy plugin

# Deploy plugin?
* ./gradlew deploy $env [release git tag]
Update helmfile.yaml version under $env
helmfile sync

# CD... The following isn't continuous
Find all releases

Select release

Update helmfile

for each env in environments
    helmfile -e $env sync
