package org.jugsummercamp.part04_traits

import org.jugsummercamp.models.people._

object HelloSpeedster extends App {

  val flash = new Speedster("Barry Allen", "The Flash") // a class and more...

  flash.run()
  
  flash.fastForward()

}
