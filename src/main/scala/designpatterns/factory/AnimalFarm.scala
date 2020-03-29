package designpatterns.factory

object AnimalFarm extends App {

  val dog = AnimalFactory("dog")
  val duck = AnimalFactory("duck")

  println(duck.speak())
}
