//package monix
//
//import akka.actor.ActorSystem
//import monix.eval.Task
//import monix.execution.Scheduler
//import monix.reactive.Observable
//
//import scala.concurrent.duration.Duration
//import scala.concurrent.{Await, Future}
//import scala.io.StdIn
//
///**
//  * Created by pkongkietvan on 12/15/2017 AD.
//  */
//object Realife extends App {
//  val system = ActorSystem("testmonix")
//  implicit val ec: Scheduler = Scheduler(scala.concurrent.ExecutionContext.Implicits.global)
//
//  val start = System.currentTimeMillis()
//  val range: Seq[Task[Int]] = (1 to 10).map(x => {
//    Task.deferFuture {
//      Future {
//        Thread.sleep(1000)
//        println(s"[${Thread.currentThread().getName}] $x ${System.currentTimeMillis() - start}")
//        x
//      }(scala.concurrent.ExecutionContext.Implicits.global)
//    }
//  })
//
////  val promise = Promise[List[Int]]
//  val tasks = Observable
//    .fromIterable(range)
//    .mapAsync(4) { x =>
//      x
//    }
//
//  val runningTask = tasks
////    .doOnSubscriptionCancel(() => promise.complete(Failure(new Exception("canceled"))))
//  .toListL.runAsync
//
//  Thread.sleep(500)
//  runningTask.cancel()
//
//  val a = Await.result(runningTask, Duration.Inf)
//  println(a)
////
////  promise.future
////    .map { result =>
////      println(s"[${Thread.currentThread().getName}] result: ${result.mkString(",")}")
////    }
////    .recover {
////      case NonFatal(t) =>
////        println(s"[${Thread.currentThread().getName}] ${t.getMessage}")
////    }getMessage
//
//  StdIn.readLine()
//}
