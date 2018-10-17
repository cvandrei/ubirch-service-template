package com.ubirch.template.client.rest

import com.typesafe.scalalogging.slf4j.StrictLogging

import com.ubirch.template.client.rest.config.TemplateClientRestConfig
import com.ubirch.util.deepCheck.model.DeepCheckResponse
import com.ubirch.util.deepCheck.util.DeepCheckResponseUtil
import com.ubirch.util.json.MyJsonProtocol
import com.ubirch.util.model.JsonResponse

import org.json4s.native.Serialization.read

import akka.http.scaladsl.HttpExt
import akka.http.scaladsl.model.{HttpRequest, HttpResponse, StatusCode, StatusCodes}
import akka.stream.Materializer
import akka.util.ByteString

import scala.concurrent.{ExecutionContextExecutor, Future}

/**
  * author: cvandrei
  * since: 2018-10-17
  */
object TemplateServiceClientRest extends MyJsonProtocol
  with StrictLogging {

  def check()(implicit httpClient: HttpExt, materializer: Materializer): Future[Option[JsonResponse]] = {

    implicit val ec: ExecutionContextExecutor = materializer.executionContext
    val url = TemplateClientRestConfig.urlCheck
    httpClient.singleRequest(HttpRequest(uri = url)) flatMap {

      case HttpResponse(StatusCodes.OK, _, entity, _) =>

        entity.dataBytes.runFold(ByteString(""))(_ ++ _) map { body =>
          Some(read[JsonResponse](body.utf8String))
        }

      case res@HttpResponse(code, _, _, _) =>

        res.discardEntityBytes()
        Future(
          logErrorAndReturnNone(s"check() call to template-service failed: url=$url code=$code, status=${res.status}")
        )

    }

  }

  def deepCheck()(implicit httpClient: HttpExt, materializer: Materializer): Future[DeepCheckResponse] = {

    implicit val ec: ExecutionContextExecutor = materializer.executionContext
    val statusCodes: Set[StatusCode] = Set(StatusCodes.OK, StatusCodes.ServiceUnavailable)

    val url = TemplateClientRestConfig.urlDeepCheck
    httpClient.singleRequest(HttpRequest(uri = url)) flatMap {

      case HttpResponse(status, _, entity, _) if statusCodes.contains(status) =>

        entity.dataBytes.runFold(ByteString(""))(_ ++ _) map { body =>
          read[DeepCheckResponse](body.utf8String)
        }

      case res@HttpResponse(code, _, _, _) =>

        res.discardEntityBytes()
        val errorText = s"deepCheck() call to key-service failed: url=$url code=$code, status=${res.status}"
        logger.error(errorText)
        val deepCheckRes = DeepCheckResponse(status = false, messages = Seq(errorText))
        Future(
          DeepCheckResponseUtil.addServicePrefix("template-service", deepCheckRes)
        )

    }

  }

  private def logErrorAndReturnNone[T](errorMsg: String,
                                       t: Option[Throwable] = None
                                      ): Option[T] = {
    t match {
      case None => logger.error(errorMsg)
      case Some(someThrowable: Throwable) => logger.error(errorMsg, someThrowable)
    }

    None

  }

}
