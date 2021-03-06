package com.ubirch.template.config

/**
  * author: cvandrei
  * since: 2017-01-19
  */
object TemplateServiceConfigKeys {

  final val CONFIG_PREFIX = "ubirchTemplateService"

  /*
   * general server configs
   *********************************************************************************************/

  final val INTERFACE = s"$CONFIG_PREFIX.interface"
  final val PORT = s"$CONFIG_PREFIX.port"

  final val GO_PIPELINE_NAME = s"$CONFIG_PREFIX.gopipelinename"
  final val GO_PIPELINE_LABEL = s"$CONFIG_PREFIX.gopipelinelabel"
  final val GO_PIPELINE_REVISION = s"$CONFIG_PREFIX.gopipelinerev"

  /*
   * Akka related configs
   *********************************************************************************************/

  private val akkaPrefix = s"$CONFIG_PREFIX.akka"

  final val ACTOR_TIMEOUT = s"$akkaPrefix.actorTimeout"
  final val AKKA_NUMBER_OF_WORKERS = s"$akkaPrefix.numberOfWorkers"

}
