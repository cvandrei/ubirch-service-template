# ubirch-template-service


## General Information

This project can be used as a template for ubirch-services. To actually use it please copy it and replace all
occurrences of the string "template" with the name of your new service.


## Release History

### Version 1.0.1 (2017-07-23)

* add `props()` method to actors
* fixed problem with missing logs and ignored log levels
* update logging dependencies
* minor refactoring of dependency group names

### Version 1.0.0 (2017-06-23)

* initial release


## Scala Dependencies

### `cmdtools`

```scala
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
)
libraryDependencies ++= Seq(
  "com.ubirch.template" %% "cmdtools" % "1.0.1"
)
```

### `config`

```scala
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
)
libraryDependencies ++= Seq(
  "com.ubirch.template" %% "config" % "1.0.1"
)
```

### `core`

```scala
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.bintrayRepo("hseeberger", "maven")
)
libraryDependencies ++= Seq(
  "com.ubirch.template" %% "core" % "1.0.1"
)
```

### `model-db`

```scala
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
)
libraryDependencies ++= Seq(
  "com.ubirch.template" %% "model-db" % "1.0.1"
)
```

### `model-rest`

```scala
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.bintrayRepo("hseeberger", "maven")
)
libraryDependencies ++= Seq(
  "com.ubirch.template" %% "model-rest" % "1.0.1"
)
```

### `server`

```scala
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.bintrayRepo("hseeberger", "maven")
)
libraryDependencies ++= Seq(
  "com.ubirch.template" %% "server" % "1.0.1"
)
```

### `test-tools`

```scala
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.bintrayRepo("hseeberger", "maven")
)
libraryDependencies ++= Seq(
  "com.ubirch.template" %% "test-tools" % "1.0.1"
)
```

### `util`

```scala
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
)
libraryDependencies ++= Seq(
  "com.ubirch.template" %% "util" % "1.0.1"
)
```


## REST Methods

### Welcome / Health / Check

    curl localhost:8092/
    curl localhost:8092/api/templateService/v1
    curl localhost:8092/api/templateService/v1/check

If healthy the server response is:

    200 {"version":"1.0","status":"OK","message":"Welcome to the ubirchTemplateService ( $GO_PIPELINE_NAME / $GO_PIPELINE_LABEL / $GO_PIPELINE_REVISION )"}

If not healthy the server response is:

    400 {"version":"1.0","status":"NOK","message":"$ERROR_MESSAGE"}

### Deep Check / Server Health

    curl localhost:8092/api/templateService/v1/deepCheck

If healthy the response is:

    200 {"status":true,"messages":[]}

If not healthy the status is `false` and the `messages` array not empty:

    503 {"status":false,"messages":["unable to connect to the database"]}


## Configuration

TODO


## Deployment Notes

TODO


## Automated Tests

run all tests

    ./sbt test

### generate coverage report

    ./sbt coverageReport

more details here: https://github.com/scoverage/sbt-scoverage


## Local Setup

TODO


## Create Docker Image

    ./goBuild.sh assembly
