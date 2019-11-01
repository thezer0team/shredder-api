[![GitHub issues](https://img.shields.io/github/issues/Naereen/StrapDown.js.svg)](https://GitHub.com/Naereen/StrapDown.js/issues/)

[![Heroku CI Status](https://shredder-api.herokuapp.com/last.svg)](https://dashboard.heroku.com/pipelines/{32ef58f9-aa9b-4ed9-8e42-3993a66d22dc}/tests)


# Shredder API

MVP Development api for shredder application. Designed to receive and serve data for Shredder application.


## Getting Started

This will take you through setting up the shredder-api project on your own machine. This is for Windows.

### Prerequisites

- Java 11
- Groovy
- Git
- Gradle
- Chocolatey (or other package management CLI)

### Installing / Setup

[Chocolatey](https://chocolatey.org/docs/installation#installing-chocolatey) - (Optional) For Chocolatey package management

[GCP_Emulator](https://cloud.google.com/datastore/docs/tools/datastore-emulator) - (Optional) for local development

[Gradle](https://gradle.org/install/) - Use link or Choco install below

```
choco install gradle
```

[Heroku-CLI](https://devcenter.heroku.com/articles/heroku-cli#download-and-install) - Use link or Choco install below

```
choco install heroku-cli
```

### Running

Test that the application builds

```
gradlew.bat clean build
```

Run Heroku locally

```
heroku local web
```

Application should be running on http://localhost:8080

View swagger on http://localhost:8080/swagger-ui.html

## Deployment

* [Heroku](https://dashboard.heroku.com/apps) - Hosting and deployment
* [GoogleCloudPlatform](https://cloud.google.com/) - Data services with GCP Datastore

## Built With

* [Springboot](https://spring.io/projects/spring-boot) - Dependency Management 
* [SpringWeb](https://spring.io/projects/spring-framework) - The web framework used
* [Groovy](https://groovy-lang.org/documentation.html) - Primary language
* [SpringCloudGCP](https://spring.io/projects/spring-cloud-gcp) - Data framework
* [SwaggerUI](https://swagger.io/tools/swagger-ui/) - API Spec

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Authors

* **Nick Williams** 

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.



