package forcomphrehension

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object ScalaFuturesAndExceptions extends App {

  def sleep(time: Long) = Thread.sleep(time)
  def currentTime = System.currentTimeMillis()
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

  // parallel vs sequential implementation
  import scala.concurrent.Future
  import scala.util.{Failure, Success}
  import scala.concurrent.ExecutionContext.Implicits.global

  def time = System.currentTimeMillis
  def delta = System.currentTimeMillis - startTime

  def slowlyDouble(x: Int, delay: Int, name: String): Future[Int] = Future {
    println(s"entered $name:  $delta")
    sleep(delay)
    println(s"leaving $name:  $delta")
    x * 2
  }

  //  // Future #1
  //  println(s"creating f1:  $delta")
  //  val f1 = slowlyDouble(x=1, delay=1500, name="f1")
  //
  //  // Future #2
  //  Thread.sleep(100)
  //  println(s"\ncreating f2:  $delta")
  //  val f2 = slowlyDouble(x=2, delay=250, name="f2")
  //
  //  // Future #3
  //  Thread.sleep(100)
  //  println(s"\ncreating f3:  $delta")
  //  val f3 = slowlyDouble(x=3, delay=500, name="f3")

  println(s"\nentering `for`: $delta")
  val result1 = for {
    r1 <- slowlyDouble(x = 1, delay = 1500, name = "f1")
    r2 <- slowlyDouble(x = 2, delay = 250, name = "f2")
    r3 <- slowlyDouble(x = 3, delay = 500, name = "f3")
  } yield (r1 + r2 + r3)

  //val result = for {
  //  r1 <- f1
  //  r2 <- f2
  //  r3 <- f3
  //} yield (r1 + r2 + r3)

  println("\nBEFORE onComplete")
  result1.onComplete {
    case Success(x) => {
      println(s"\nresult = $x (delta = $delta)")
      println(
        "note that you don't get the result until the last future completes"
      )
    }
    case Failure(e) => e.printStackTrace
  }
  println("AFTER onComplete\n")
  // important for a little parallel demo: keep the jvm alive
  sleep(6000)

}
