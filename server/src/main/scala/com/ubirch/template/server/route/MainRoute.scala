package com.ubirch.template.server.route

import com.ubirch.template.util.server.TemplateServiceRouteConstants

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

/**
  * author: cvandrei
  * since: 2017-03-22
  */
class MainRoute {

  val welcome = new WelcomeRoute {}
  val deepCheck = new DeepCheckRoute {}

  val myRoute: Route = {

    pathPrefix(TemplateServiceRouteConstants.apiPrefix) {
      pathPrefix(TemplateServiceRouteConstants.serviceName) {
        pathPrefix(TemplateServiceRouteConstants.currentVersion) {

          pathEndOrSingleSlash {
            welcome.route
          } ~ path(TemplateServiceRouteConstants.check) {
            welcome.route
          } ~ deepCheck.route

        }
      }
    } ~
      pathSingleSlash {
        welcome.route
      }

  }

}
