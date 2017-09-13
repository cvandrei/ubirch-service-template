# ubirch-template-service


## General Information

This project can be used as a template for ubirch-services. To actually use it please copy it and replace all
occurrences of the string "template" with the name of your new service.


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



## Create Docker Image

    ./goBuild assembly && ./goBuild containerbuild
