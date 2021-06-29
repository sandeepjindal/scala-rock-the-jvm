package rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success}

object ScalaRecap extends App {
  val acondition: Boolean = true

  def myFunction(x: Int) = {
    if(x < 4) 42 else 65
  }

  // instruction vs expressions[evaluated]

  //types and type inferences

  // OO features
  class Animal
  trait Carnivore {
    def eat(a: Animal): Unit
  }

  object Carnivore

  // generics
  abstract class MyList[+A]

  // method notations
  1.+(2)

  //FP

  val anIncrementer:Int => Int = (x: Int) => x+1 // anonymous function

  // function as first class citizen
  anIncrementer(1)

  List(1,2,3).map(anIncrementer)
  // HOF: flatmap , filter
  // for comphre

  // Monads : Option, Try

  val unknown: Any = 2
  val order = unknown match{
    case 1 => "first"
    case 2 => "second"
    case _ => "unknown"
  }

  try{
    throw new RuntimeException
  } catch{
    case e: Exception => println("caught `1")
  }


  /***
   * scala advanced
   */

  // multithreading
  import scala.concurrent.ExecutionContext.Implicits.global
  val future = Future{
    42
  }

  // map, flatmap.filter. recover , recoverWith

  future.onComplete{
    case Success(value) => println(s"i found the meaning of life ${value}")
    case Failure(exception) => println(s"I found exception while searching meaning of life")
  } // on SOME thread

  val partialFunction: PartialFunction[Int,Int] = {
    case 1 => 42
    case 2 => 65
    case _ => 999
  }
  // based on pattern matching

  //type aliases
  type AkkaRecieve = PartialFunction[Any,Unit]
  def recieve: AkkaRecieve = {
    case 1 => println("hello")
    case _ => println("confused...")
  }

  implicit val timeout = 3000
  def setTimeout(f : ()=> Unit)(implicit timeout: Int) = f()

  setTimeout(() => println("timeout"))

  // conversions
  // implicit method
  case class Person(name: String){
    def greet : String = s"my name is ${name}"
  }

  implicit def fromStringToPerson(name:String) = Person(name)

  "peter".greet
  // fromStringToPerson("peter").greet

  // 2) implicit classes
  implicit class Dog(name:String){
    def bark = println("bark")
  }

  "lassie".bark

  // implicit organization
  //local scope
  implicit val numberOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _ )
  List(1,2,3).sorted

  //imported scope

  // companion objects of types involved in the call

  object Person {
    implicit val personOrdering: Ordering[Person] = Ordering.fromLessThan((a, b) => a.name.compareTo(b.name) < 0)
  }
  List(Person("Bob"),Person("Alice")).sorted
}
