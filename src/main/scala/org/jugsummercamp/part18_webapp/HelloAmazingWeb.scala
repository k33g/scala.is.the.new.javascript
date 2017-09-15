package org.jugsummercamp.part18_webapp

import io.vertx.core.json.JsonObject
import io.vertx.scala.core.Vertx
import io.vertx.scala.ext.web.Router
import io.vertx.scala.ext.web.handler.StaticHandler

import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler

import scala.concurrent.ExecutionContext.Implicits.global

import scala.util.{Try, Failure, Success}

package object HelloAmazingWeb {

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

      def param(p: String): Option[String] = {rc.request.getParam(p)} 
    }

    implicit class RouterImprovements(val router: Router) {
      def GET(uri: String, handler: Handler[RoutingContext]): Unit = {
        router.get(uri).handler(handler)
      }
    }

    router.GET("/hello", context => context.html("<h1>Hello 🌍</h1>"))

    router.GET("/divide/:a/:b", context => {
      Try(
        context.param("a").get.toInt / context.param("b").get.toInt
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
