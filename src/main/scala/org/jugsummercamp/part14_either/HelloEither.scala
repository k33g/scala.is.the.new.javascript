package org.jugsummercamp.part14_either

import scala.io.Source._
import scala.util.{Either, Left, Right}


object HelloEither extends App  {
  
  def getPage(url: String): Either[String, String] = {
    try {
      Right(fromURL(url).mkString)
    } catch {
      case e: Exception => Left(s"😡 ${e.toString}")
    }
  }

  getPage("http://www.scala-lang.org") match {
    case Left(message) => println(message)
    case Right(html) => println(html)
  }

} 