package com.ubirch.template.config

import com.ubirch.util.config.ConfigBase

/**
  * author: cvandrei
  * since: 2017-01-19
  */
object TemplateServiceConfig extends ConfigBase {

  /**
    * The interface the server runs on.
    *
    * @return interface
    */
  def interface: String = config.getString(TemplateServiceConfigKeys.INTERFACE)

  /**
    * Port the server listens on.
    *
    * @return port number
    */
  def port: Int = config.getInt(TemplateServiceConfigKeys.PORT)

  def goPipelineName: String = config.getString(TemplateServiceConfigKeys.GO_PIPELINE_NAME)
  def goPipelineLabel: String = config.getString(TemplateServiceConfigKeys.GO_PIPELINE_LABEL)
  def goPipelineRevision: String = config.getString(TemplateServiceConfigKeys.GO_PIPELINE_REVISION)

  /*
   * Akka Related
   ************************************************************************************************/

  /**
    * Default actor timeout.
    *
    * @return timeout in seconds
    */
  def actorTimeout: Int = config.getInt(TemplateServiceConfigKeys.ACTOR_TIMEOUT)

  def akkaNumberOfWorkers: Int = config.getInt(TemplateServiceConfigKeys.AKKA_NUMBER_OF_WORKERS)

}
