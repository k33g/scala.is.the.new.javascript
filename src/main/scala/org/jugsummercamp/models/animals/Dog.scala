package org.jugsummercamp.models.animals

class Dog(name: String) extends Animal(name) {
  def wouaf() = {
    println("wouaf I'm a 🐶")
  }

}