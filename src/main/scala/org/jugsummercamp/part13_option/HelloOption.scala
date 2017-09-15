package org.jugsummercamp.part13_option

object HelloOption extends App  {
  
  case class Toon(name: String, avatar: String)
  
  /**
   * Option:
   * This class represents optional values.
   * Instances of Option are either 
   *   - instances of case class Some 
   *   - or it is case object None.
   */
  
  def getToon(name: String): Option[Toon]  = { // always return an Option
    val toons = List(
      Toon("po", "🐼"),
      Toon("buster", "🐰"),
      Toon("simba", "🦁")        
    )
    toons.find(toon => toon.name == name) // find always returns an Option
  }

  println(getToon("po"))  // show display
  println(getToon("babs")) // show display

  getToon("simba") match {
    case None => println("😡 not found")
    case Some(toon) => println(s"👋 ${toon.avatar}")
  }

  // Option is a Monad
  // extract the avatar
  println(
    getToon("po").map(toon => toon.avatar).getOrElse("😜")
  )
  println(
    getToon("babs").map(toon => toon.avatar).getOrElse("😜")
  )

  println(Option(getToon("babs")))

} 