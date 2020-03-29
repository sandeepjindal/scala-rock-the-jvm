//package monix
//
//import monix.eval.Task
//
//import scala.concurrent.Future
//import scala.io.StdIn
//import scala.util.{Failure, Success}
//
//object FutureVsTask extends App {
//  import scala.concurrent.ExecutionContext.Implicits.global
//
//  val future = Future { 1 + 1 }
//  future.onComplete {
//    case Success(value) => println(value)
//    case Failure(ex)    => println(ex.getMessage)
//  }
//
//  StdIn.readLine()
//}
//
//object TaskVSFuture extends App {
//  import monix.execution.Scheduler.Implicits.global
//
//  val task = Task { 1 + 1 }
//  task.runAsync(x =>
//    x match {
//      case Success(value) => println(value)
//      case Failure(ex)    => println(ex.getMessage)
//  })
//
//  StdIn.readLine()
//}
