package com.ubirch.template.core.actor

import com.ubirch.template.config.TemplateServiceConfig
import com.ubirch.template.core.manager.DeepCheckManager
import com.ubirch.util.deepCheck.model.{DeepCheckRequest, DeepCheckResponse}

import akka.actor.{Actor, ActorLogging, Props}
import akka.routing.RoundRobinPool

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * author: cvandrei
  * since: 2017-06-07
  */
class DeepCheckActor extends Actor
  with ActorLogging {

  override def receive: Receive = {

    case _: DeepCheckRequest =>
      val sender = context.sender()
      deepCheck() map (sender ! _)

  }

  override def unhandled(message: Any): Unit = {
    log.error(s"received from ${context.sender().path} unknown message: ${message.toString} (${message.getClass})")
    //context.sender() ! JsonErrorResponse(errorType = "ServerError", errorMessage = "we're sorry but the server has a problem")
  }

  private def deepCheck(): Future[DeepCheckResponse] = DeepCheckManager.connectivityCheck()

}

object DeepCheckActor {
  def props(): Props = new RoundRobinPool(TemplateServiceConfig.akkaNumberOfWorkers).props(Props(new DeepCheckActor()))
}