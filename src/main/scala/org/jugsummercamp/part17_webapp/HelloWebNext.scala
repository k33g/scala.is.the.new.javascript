package org.jugsummercamp.part17_webapp

import io.vertx.core.json.JsonObject
import io.vertx.scala.core.Vertx
import io.vertx.scala.ext.web.Router
import io.vertx.scala.ext.web.handler.StaticHandler

import io.vertx.scala.ext.web.RoutingContext

import scala.concurrent.ExecutionContext.Implicits.global

import scala.util.{Try, Failure, Success}

package object HelloWebNext {

  val vertx = Vertx.vertx()

  def main(args: Array[String]): Unit = {
    val server = vertx.createHttpServer()
    val router = Router.router(vertx)

    val httpPort = sys.env.getOrElse("PORT", "8080").toInt

    implicit class RoutingContextImprovements(val rc: RoutingContext) {
      def json(j: JsonObject): Unit = { 
        rc.response()
          .putHeader("content-type", "application/json;charset=UTF-8")
          .end(j.encodePrettily())
      }
      def html(c: String): Unit = { 
        rc.response()
          .putHeader("content-type", "text/html;charset=UTF-8")
          .end(c)
      }
    }

    router.get("/hello").handler(context => 
      context.html("<h1>Hello 🌍</h1>")
    )

    router.get("/divide/:a/:b").handler(context => {
      Try(
        context.request.getParam("a").get.toInt / context.request.getParam("b").get.toInt
      ) match {
        case Failure(e) => context.json(new JsonObject().put("message", e.getMessage))
        case Success(result) => context.json(new JsonObject().put("result", result))                            
      } 
    })

    router.route("/*").handler(StaticHandler.create())

    println(s"🌍 Listening on $httpPort  - Enjoy 😄")
    server.requestHandler(router.accept _).listen(httpPort)
  }
}
