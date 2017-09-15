package org.jugsummercamp.part11_monads

object MyPersonalDefinitionOfMonad extends App  {
  
  // this is a sample of functor
  case class FunctorOfString(val value: String) {
    def map(fn: String => String) = {
      val res = fn(this.value);
      FunctorOfString(res) // implicit return
    }
    // 🤔
  }

  // functions
  val bold = (txt: String) => s"<b>$txt</b>"
  val italic = (txt: String) => s"<i>$txt</i>"
  val h1 = (txt: String) => s"<h1>$txt</h1>"

  val title = (txt: String) => FunctorOfString(txt).map(bold).map(h1).value
  // italic???

  val text = FunctorOfString("Hello 🌍").map(title)

  println(text.value)

} 