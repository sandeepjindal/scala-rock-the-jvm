//Day 3

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

val days = Seq("Monday","Tuesday","Friday")
val d = days.map(_.toUpperCase)
d.flatten


//val x = "Monday"
//Seq('M','o')
//
////A,B
////A,CollectionC
////CollectionC = B
//
//
////val numbers = Seq(1,2,3)
////
////numbers.map(_.toString
////
////  numbers.flatMap(_.toString)
//
//val fDays = days.map(_.toUpperCase())
//
////fDays.flatten
////
////
//days.flatMap(_.toUpperCase())

val strings = Seq("1", "2", "foo", "3", "bar")


def toInt(s: String): Option[Int] = {
  try {
    Some(Integer.parseInt(s.trim))
  } catch {
    case e: Exception => None
  }
}

strings.map(toInt)

strings.flatMap(toInt)


//val couples = List(List("kim", "al"), List("julia", "terry"))
//
//
//val people = couples.flatten
//
//
//val x: Future[Int] = Future{
//  34
//}
//
//x
//
//val z = x.map(y => y + 0.34)
//
//z
//
//
//val numF = Future{ 3 }
//
//
//
//val flatStringF = numF.flatMap(n => Future(n.toString))
//
//flatStringF
//
//
//val stringF = numF.map(n => Future(n.toString))
//
//stringF


// want to know why different response.