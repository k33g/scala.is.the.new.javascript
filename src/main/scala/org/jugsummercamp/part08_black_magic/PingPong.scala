package org.jugsummercamp.part08_black_magic

object PingPong extends App {

  // class name + Improvement

  implicit class StringPouetPouet(val string: String) {
    def ping: String = { s"ping ${string}" }
    def pong: String = { s"pong ${string}" }
    def display: Unit = { println(string) }
  }

  "Hello".ping.display
  "Hello".pong.display
  "Hello".ping.pong.display

  // useful to simplify frameworks

}