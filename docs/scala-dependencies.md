## Scala Dependencies

### `client-rest`

```scala
resolvers ++= Seq(
  Resolver.sonatypeRepo("release")
)
libraryDependencies ++= Seq(
  "com.ubirch.template" %% "client-rest" % "4.0.0"
)
```

#### Configuration
   
| Config Item                             | Mandatory  | Description            |
|:----------------------------------------|:-----------|:-----------------------|
| ubirchTemplateService.client.rest.host  | yes        | template-service host  |

#### Usage

See `com.ubirch.template.client.rest.TemplateServiceClientRestSpec` for an example usage.

The REST client class is `TemplateServiceClientRest` and the host it connects to needs to be configured:

    ubirchTemplateService.client.rest.host = "http://localhost:8118"

It depends on a `akka-http` client. Please refer to the setup of `TemplateServiceClientRestSpec` for further details.

### `cmdtools`

```scala
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
)
libraryDependencies ++= Seq(
  "com.ubirch.template" %% "cmdtools" % "4.0.0"
)
```

### `config`

```scala
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
)
libraryDependencies ++= Seq(
  "com.ubirch.template" %% "config" % "4.0.0"
)
```

### `core`

```scala
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.bintrayRepo("hseeberger", "maven")
)
libraryDependencies ++= Seq(
  "com.ubirch.template" %% "core" % "4.0.0"
)
```

### `model-db`

```scala
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
)
libraryDependencies ++= Seq(
  "com.ubirch.template" %% "model-db" % "4.0.0"
)
```

### `model-rest`

```scala
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.bintrayRepo("hseeberger", "maven")
)
libraryDependencies ++= Seq(
  "com.ubirch.template" %% "model-rest" % "4.0.0"
)
```

### `server`

```scala
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.bintrayRepo("hseeberger", "maven")
)
libraryDependencies ++= Seq(
  "com.ubirch.template" %% "server" % "4.0.0"
)
```

### `test-tools`

```scala
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.bintrayRepo("hseeberger", "maven")
)
libraryDependencies ++= Seq(
  "com.ubirch.template" %% "test-tools" % "4.0.0"
)
```

### `util`

```scala
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
)
libraryDependencies ++= Seq(
  "com.ubirch.template" %% "util" % "4.0.0"
)
```
