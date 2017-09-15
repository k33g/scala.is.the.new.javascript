package org.jugsummercamp.part05_traits_again

import org.jugsummercamp.models.people.Human
import org.jugsummercamp.models.people.SuperHero
import org.jugsummercamp.models.people.powers._

object HelloKidFlash extends App {
  
  val kidFlash = new Human("Wally") with NickName with RunFast with GoToTheFuture

  kidFlash.nickName = "Kid Flash"
  
  kidFlash.run
  
  kidFlash.fastForward
  
}