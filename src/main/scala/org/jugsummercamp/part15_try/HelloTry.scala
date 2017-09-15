package org.jugsummercamp.part15_try

import scala.io.Source._

import scala.util.{Try, Failure, Success}

object HelloTry extends App  {
  def getPage(url: String): Try[String] = Try(fromURL(url).mkString)

  getPage("http://www.scala-lang.org") match { 
    case Failure(err) => println(s"😡 ${err.getMessage}")
    case Success(html) => println(html)
  }
} 