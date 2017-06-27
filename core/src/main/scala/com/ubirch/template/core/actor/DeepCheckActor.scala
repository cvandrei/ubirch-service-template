package com.ubirch.template.core.actor

import com.ubirch.template.config.Config
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

    case _ => log.error("unknown message")

  }

  private def deepCheck(): Future[DeepCheckResponse] = DeepCheckManager.connectivityCheck()

}

object DeepCheckActor {
  def props(): Props = new RoundRobinPool(Config.akkaNumberOfWorkers).props(Props(new DeepCheckActor()))
}