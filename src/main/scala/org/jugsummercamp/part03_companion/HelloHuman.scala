package org.jugsummercamp.part03_companion

import org.jugsummercamp.models.people._

/**
 * No static method 😱
 * - org/jugsummercamp/models/people/Human
 */

object HelloHuman extends App {

  println(Human.message) // see Human.scala

  val bob = Human.create("Bob Morane") // see Human.scala

  bob.say("👋 Hi")

}
