//package monix
//
//import akka.actor.ActorSystem
//import monix.eval.Task
//import monix.execution.Scheduler
//
//import scala.concurrent.{Future, Promise}
//import scala.io.StdIn
//import scala.util.control.NonFatal
//
///**
//  * Created by pkongkietvan on 12/15/2017 AD.
//  */
//object RealifeSliding extends App {
//  val system = ActorSystem("testmonix")
//  implicit val ec: Scheduler = Scheduler(system.dispatcher)
//
//  val start = System.currentTimeMillis()
//  val range = (1 to 4).map(x => {
//    Task.deferFuture {
//      Future {
//        Thread.sleep(x * 1000)
//        println(
//          s"[${Thread.currentThread().getName}] $x ${System.currentTimeMillis() - start}")
//        x
//      }(scala.concurrent.ExecutionContext.Implicits.global)
//    }
//  })
//
//  val batchs = range.sliding(2, 2).map(Task.gather(_))
//  val aggregate = Task.sequence(batchs).map(_.flatten.toList)
//
//  val promise = Promise[List[Int]]
//  aggregate.runOnComplete(result => promise.complete(result))
//
//  promise.future
//    .map { result =>
//      println(
//        s"[${Thread.currentThread().getName}] result: ${result.mkString(",")}")
//    }
//    .recover {
//      case NonFatal(t) =>
//        println(s"[${Thread.currentThread().getName}] ${t.getMessage}")
//    }
//
//  StdIn.readLine()
//}
