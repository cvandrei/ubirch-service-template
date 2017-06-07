package com.ubirch.template.core.actor

import com.ubirch.util.model.DeepCheckResponse

import akka.actor.{Actor, ActorLogging}

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
      Future(DeepCheckResponse()) map (sender ! _) // TODO check server health

    case _ => log.error("unknown message")

  }

}

case class DeepCheckRequest()
