//package monix
//
//import monix.eval.Task
//
//import scala.concurrent.Future
//import scala.concurrent.duration._
//import scala.io.StdIn
//
//object Cancellation extends App {
//
//  // Cancellation?
//  import scala.concurrent.ExecutionContext.Implicits.global
//  def future(x: Int) = Future {
//    Thread.sleep(1000)
//    println(x)
//  }
//  (1 to 10).foreach(future(_))
//
//  StdIn.readLine()
//}
//
//object CancellationTask extends App {
//  implicit val scheduler = monix.execution.Scheduler.Implicits.global
//
//  (1 to 100).map(x =>
//    Future {
//      //Call something
//      x
//  })
//
//  def task(x: Int) =
//    Task {
//      println(x)
//    }.delayExecution(1.second)
//
//  val running = Task.sequence((1 to 10).map(task(_))).runAsync
//  Thread.sleep(3000)
//  running.cancel()
//
//  StdIn.readLine()
//
//  Task.deferFuture(Future(1))
//}