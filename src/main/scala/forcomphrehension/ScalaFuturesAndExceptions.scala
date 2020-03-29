package forcomphrehension

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object ScalaFuturesAndExceptions extends App {

  val startTime = currentTime

  val f1 = Future {
    sleep(2000)
    1
  }

//  f1

  f1.onComplete {
    case Success(x) => {
      System.out.print("hey")
      println(s"\nresult = $x")
    }
    case Failure(e) => {
      // the code comes here because of the intentional exception
      val finishTime = currentTime
      val delta = finishTime - startTime
      System.err.println(s"delta = $delta")
      System.err.println("Failure happened!")
      // just a short message; i don't care about the full exception
      System.err.println(e.getMessage)
    }
  }
//  val f2 = Future {
//    sleep(550)
////    throw new Exception("Ka-boom!")
//    2
//  }
//  val f3 = Future {
//    sleep(1000)
//    3
//  }
//val result2 = for {
//  r1 <- Future {
//    sleep(2000)
//    1
//  }
//  r4 <- result
//} yield (r4 + r1)
//
//  val result = for {
//    r1 <- Future {
//      sleep(2000)
//      1
//    }
//    r2 <- Future {
//      sleep(550)
////      throw new Exception("Ka-boom!")
//      2
//    }
//  } yield (r1 + r2)
//
//
//
//  result2.onComplete {
//    case Success(x) => {
//      // the code won't come here
//      println(s"\nresult = $x")
//    }
//    case Failure(e) => {
//      // the code comes here because of the intentional exception
//      val finishTime = currentTime
//      val delta = finishTime - startTime
//      System.err.println(s"delta = $delta")
//      System.err.println("Failure happened!")
//      // just a short message; i don't care about the full exception
//      System.err.println(e.getMessage)
//    }
//  }

//   important for a little parallel demo: keep the main
//   thread of the jvm alive
  sleep(4000)

  def sleep(time: Long) = Thread.sleep(time)
  def currentTime = System.currentTimeMillis()

}