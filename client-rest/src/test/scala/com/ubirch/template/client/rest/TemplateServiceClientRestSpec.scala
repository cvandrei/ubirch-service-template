package com.ubirch.template.client.rest

import com.ubirch.template.config.TemplateServiceConfig
import com.ubirch.util.deepCheck.model.DeepCheckResponse
import com.ubirch.util.model.JsonResponse

import org.scalatest.{AsyncFeatureSpec, BeforeAndAfterAll, Matchers}

import akka.actor.ActorSystem
import akka.http.scaladsl.{Http, HttpExt}
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContextExecutor

/**
  * author: cvandrei
  * since: 2018-10-17
  */
class TemplateServiceClientRestSpec extends AsyncFeatureSpec
  with Matchers
  with BeforeAndAfterAll {

  implicit val system: ActorSystem = ActorSystem()
  implicit val ec: ExecutionContextExecutor = system.dispatcher
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val httpClient: HttpExt = Http()

  override protected def afterAll(): Unit = {
    super.afterAll()
    system.terminate()
    httpClient.shutdownAllConnectionPools()
    Thread.sleep(500)
    System.exit(0)
  }

  feature("check()") {

    scenario("check without errors") {

      // test
      TemplateServiceClientRest.check() map {

        // verify
        case None => fail("expected a result other than None")

        case Some(jsonResponse: JsonResponse) =>
          val goInfo = s"${TemplateServiceConfig.goPipelineName} / ${TemplateServiceConfig.goPipelineLabel} / ${TemplateServiceConfig.goPipelineRevision}"
          val expected = JsonResponse(message = s"Welcome to the ubirchTemplateService ( $goInfo )")
          jsonResponse shouldBe expected

      }

    }

  }

  feature("deepCheck()") {

    scenario("check without errors") {

      // test
      TemplateServiceClientRest.deepCheck() map { deepCheckResponse =>

        // verify
        deepCheckResponse shouldBe DeepCheckResponse()

      }

    }

  }

}
