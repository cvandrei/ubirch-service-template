## Release History

### Version 4.0.0 (2018-10-17)

* added REST client template
* update to `com.ubirch.util:deep-check-model:0.3.0`
* update to `com.ubirch.util:oidc-utils:0.8.3`
* update to `com.ubirch.util:response-util:0.4.1`

### Version 3.1.0 (2018-08-16)

* update `DummyCmdTool` to have all logic inside a `run(): Unit` method

### Version 3.1.0 (2018-08-13)

* update to `com.ubirch.util:config:0.2.3`
* update to `com.ubirch.util:date:0.5.3`
* update to `com.ubirch.util:deep-check-model:0.3.0`
* update to `com.ubirch.util:json:0.5.1`
* update to `com.ubirch.util:oidc-utils:0.7.2`
* update to `com.ubirch.util:response-util:0.4.0`

### Version 3.0.0 (2018-07-19)

* update to sbt from `0.13.17` to `1.1.6`
* update to plugin `com.eed3si9n:sbt-assembly:0.14.7`
* update to plugin `se.marcuslonnberg:sbt-docker:1.5.0`
* disabled plugin `com.zavakid.sbt:sbt-one-log` as it's not yet available for sbt `1.1.x`
* update to plugin `org.scoverage:sbt-scoverage:1.5.1`

### Version 2.1.1 (2018-07-19)

* override `unhandled()` in actor 

### Version 2.1.0 (2018-07-18)

* update to `scalaVersion := "2.11.12"`
* update to `com.ubirch.util:config:0.2.1`
* update to `com.ubirch.util:date:0.5.2`
* update to `com.ubirch.util:deep-check-model:0.2.1`
* update to `com.ubirch.util:json:0.4.4`
* update to `com.ubirch.util:oidc-utils:0.6.0`
* update to `com.ubirch.util:response-util:0.3.0`
* update to `com.ubirch.util:rest-akka-http:0.4.0`
* update to `com.ubirch.util:rest-akka-http-test:0.4.0`
* update to `com.ubirch.util:uuid:0.1.3`
* update to `com.typesafe.akka:akka-(actor|slf4j|stream):2.5.11`
* update to `com.typesafe.akka:akka-http(-testkit):10.1.3`
* update to `org.scalatest:scalatest:3.0.5`


### Version 2.0.1 (2018-04-11)

* update to `com.typesafe.akka:akka-(actor|slf4j):2.4.20`
* update to `com.typesafe.akka:akka-http:10.0.11`
* update to `com.ubirch.util:oidc-utils:0.5.6`
* update to `com.ubirch.util:response-util:0.2.5`
* update to `com.ubirch.util:rest-akka-http:0.3.9`
* update to `com.ubirch.util:rest-akka-http-test:0.3.9`

### Version 2.0.0 (2018-04-05)

* upgrade sbt to 0.13.17
* update to `com.ubirch.util:config:0.2.0`
* update to `com.ubirch.util:date:0.5.1`
* update to `com.ubirch.util:json:0.4.3`
* update to `com.ubirch.util:oidc-utils:0.5.4`
* update to `com.ubirch.util:response-util:0.2.4`
* update to `com.ubirch.util:uuid:0.1.2`

### Version 1.0.7 (2017-09-13)

* moved some of README's documentation to separate files in newly created folder _docs_

### Version 1.0.6 (2017-08-10)

* add `com.ubirch.util:oidc-utils:0.4.11` dependency

### Version 1.0.5 (2017-07-31)

* update to `com.ubirch.util:deep-check-model:0.2.0`

### Version 1.0.4 (2017-07-19)

* update Dockerfile.template
* update goBuild.sh

### Version 1.0.3 (2017-07-18)

* update to Akka 2.4.19

### Version 1.0.2 (2017-07-17)

* update Akka HTTP to 10.0.9
* update _com.ubirch.util:rest-akka-http(-test)_ to 0.3.8
* update _com.ubirch.util:response-util_ to 0.2.3

### Version 1.0.1 (2017-07-23)

* add `props()` method to actors
* fixed problem with missing logs and ignored log levels
* update logging dependencies
* minor refactoring of dependency group names

### Version 1.0.0 (2017-06-23)

* initial release
