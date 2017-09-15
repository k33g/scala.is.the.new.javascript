package org.jugsummercamp.part02_first_class

import org.jugsummercamp.models.animals._

/**
 * First class
 * See org/jugsummercamp/models/animals
 */

object HelloDog extends App {

  var wolf = new Dog("wolf")

  println(wolf.name)

  wolf.hello 
  wolf.wouaf 
}
