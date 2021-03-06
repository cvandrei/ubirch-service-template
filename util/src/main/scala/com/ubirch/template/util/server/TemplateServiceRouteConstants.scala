package com.ubirch.template.util.server

/**
  * author: cvandrei
  * since: 2017-03-22
  */
object TemplateServiceRouteConstants {

  final val apiPrefix = "api"
  final val serviceName = "templateService"
  final val currentVersion = "v1"

  final val check = "check"
  final val deepCheck = "deepCheck"

  val pathPrefix = s"/$apiPrefix/$serviceName/$currentVersion"

  val pathCheck = s"$pathPrefix/$check"
  val pathDeepCheck = s"$pathPrefix/$deepCheck"

}
