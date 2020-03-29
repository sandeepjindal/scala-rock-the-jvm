package monix

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.control.NonFatal
import scala.util.{Failure, Success}

object Futures1 extends App {
  // used by 'time' method
  implicit val baseTime = System.currentTimeMillis

  // 2 - create a Future
  val f = Future {
    Thread.sleep(500)
throw new IndexOutOfBoundsException("Anty")
  }
//  val a = f
//  print(a)

//  f onComplete {
//    case Success(value) => {
//      print(value)
//    }
//    case Failure(exception) => print(exception.getMessage)
//  }

//  val f1 = Future {f}

  f.map{
    x => print(x)
  }.recover {
    case NonFatal(t) => print(t.getMessage)
  }

  f onComplete {
    case Success(value) => print(value)
    case Failure(exception:IndexOutOfBoundsException) => print(exception.getMessage)
    case Failure(exception: RuntimeException) => print(exception.getMessage)
  }
//  Thread.sleep(1000)
//  print(f1)
  // 3 - this is blocking (blocking is bad)
//  val result = Await.result(f, 2000 millisecond)
//  println(result)
  Thread.sleep(1000)
}