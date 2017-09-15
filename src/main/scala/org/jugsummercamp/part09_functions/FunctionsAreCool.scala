package org.jugsummercamp.part09_functions

// see http://www.artima.com/pins1ed/functions-and-closures.html

object tools {
  // this is a method
  def addition(a: Int, b: Int): Int = { a + b }
}

object FunctionsAreCool extends App {

  println(tools.addition(4,5))

  // this is a function aka lambda
  val multiplication = (a: Int, b: Int) => a * b
  
  println(multiplication(4,5))


}