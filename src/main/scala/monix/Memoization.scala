//package monix
//
//import monix.eval.Task
//import monix.execution.atomic.Atomic
//
//import scala.concurrent.duration.Duration
//import scala.concurrent.{Await, Future}
//import scala.io.StdIn
//import scala.util.Try
//
//object Memoization extends App {
//
//  import scala.concurrent.ExecutionContext.Implicits.global
//  // Memorization
//  val total = Future {
//    println("Computing 2 + 2")
//    2 + 2
//  }
//
//  println(Await.result(total, Duration.Inf))
//  println(Await.result(total, Duration.Inf))
//
//  StdIn.readLine()
//}
//
//object MemoizationTask extends App {
//  implicit val scheduler = monix.execution.Scheduler.Implicits.global
//  val total = Task.eval {
//    println("Computing 2 + 2")
//    2 + 2
//  }.memoize
//  println(Await.result(total.runAsync, Duration.Inf))
//  println(Await.result(total.runAsync, Duration.Inf))
//
//  val effect = Atomic(0)
//  val source = Task {
//    val current = effect.incrementAndGet()
//    if (current >= 3) current
//    else throw new RuntimeException("test")
//  }
//  source.memoizeOnSuccess
//
//  println(Try(Await.result(source.runAsync, Duration.Inf)).getOrElse("Error"))
//  println(Try(Await.result(source.runAsync, Duration.Inf)).getOrElse("Error"))
//  println(Try(Await.result(source.runAsync, Duration.Inf)).getOrElse("Error"))
//
//  StdIn.readLine()
//}
