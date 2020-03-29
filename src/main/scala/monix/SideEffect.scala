//package monix
//
//import monix.eval.Task
//
//import scala.concurrent.Future
//import scala.io.StdIn
//
//object SideEffect extends App {
//  import scala.concurrent.ExecutionContext.Implicits.global
//
//  // Side effect?
//  for {
//    x <- Future { println("Foo") }
//    y <- Future { println("Foo") }
//  } yield ()
//
//  def printFuture = Future { println("Foo2") }
//  for {
//    x <- printFuture
//    y <- printFuture
//  } yield ()
//
//  StdIn.readLine()
//}
//
//object SideEffectTask extends App {
//  implicit val scheduler = monix.execution.Scheduler.Implicits.global
//  val task = for {
//    x <- Task { println("Foo") }
//    y <- Task { println("Foo") }
//  } yield ()
//  task.runAsync
//
//  val printFuture = Task { println("Foo2") }
//  val task2 = for {
//    x <- printFuture
//    y <- printFuture
//  } yield ()
//  task2.runAsync
//
//  StdIn.readLine()
//}
