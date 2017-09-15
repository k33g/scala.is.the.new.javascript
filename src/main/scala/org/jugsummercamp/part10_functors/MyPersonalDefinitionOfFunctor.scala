package org.jugsummercamp.part10_functors

object MyPersonalDefinitionOfFunctor extends App {

  // this is a sample of functor
  // often I speak about container, it's bad 😡
  
  case class FunctorOfString(val value: String) {
    def map(fn: String => String) = {
      val res = fn(this.value);
      FunctorOfString(res) // implicit return
    }
  }

  val text = FunctorOfString("Hello 🌍")

  // functions
  val bold = (txt: String) => s"<b>$txt</b>"
  val h1 = (txt: String) => s"<h1>$txt</h1>"
  val body = (txt: String) => s"<body>$txt</body>"
  val html = (txt: String) => s"<html>$txt</html>"

  val page = text
              .map(bold)
              .map(h1)
              .map(body)
              .map(html)
              .value

  println(page)


}