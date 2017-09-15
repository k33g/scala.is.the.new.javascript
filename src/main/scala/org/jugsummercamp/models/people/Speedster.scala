package org.jugsummercamp.models.people

import org.jugsummercamp.models.people.powers._

class Speedster(name: String, nickName: String) 
  extends SuperHero(name, nickName) 
  // add super powers
  with RunFast 
  with GoToTheFuture {

}
