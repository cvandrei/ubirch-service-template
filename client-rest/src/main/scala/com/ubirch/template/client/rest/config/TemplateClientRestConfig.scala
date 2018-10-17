package com.ubirch.template.client.rest.config

import com.ubirch.template.util.server.TemplateServiceRouteConstants
import com.ubirch.util.config.ConfigBase

/**
  * author: cvandrei
  * since: 2018-10-17
  */
object TemplateClientRestConfig extends ConfigBase {

  private def host = config.getString(TemplateClientRestConfigKeys.HOST)

  val urlCheck = s"$host${TemplateServiceRouteConstants.pathCheck}"

  val urlDeepCheck = s"$host${TemplateServiceRouteConstants.pathDeepCheck}"

}
