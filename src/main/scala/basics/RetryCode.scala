//package basics
//
//
//import java.io.IOException
//
//import akka.actor.ActorSystem
//import akka.stream.ActorMaterializer
//import akka.pattern._
//import com.sun.tools.corba.se.idl.EnumEntry
//
//import scala.concurrent.ExecutionContext.Implicits.global
//import scala.concurrent.duration._
//import scala.util.Random
//import scala.concurrent.Future
//
//class RetryCode {
//
//  implicit val system = ActorSystem()
//
//  implicit val materializer = ActorMaterializer()
//
//  object NetworkException extends Throwable
//
//  def networkRequest(): Future[String] = {
//    // let's assume a high rate of failure to make our examples
//    // more interesting
//    if ((Random.nextFloat * 100) < 80)
//      Future.failed(NetworkException)
//    else
//      Future.successful("<data>")
//  }
//
////  def networkRequestWithRetries(factor: Float = 1.5f, init: Int = 1, cur: Int = 0)
////                               (implicit as: ActorSystem): Future[String] = {
////    networkRequest().recoverWith {
////      case NetworkException => {
////        val next: Int =
////          if (cur == 0) init
////          else Math.ceil(cur * factor).toInt
////
////        println(s"retrying after ${next} ms")
////        after(next.milliseconds, as.scheduler, global, Future.successful(1)).flatMap { _ =>
////          networkRequestWithRetries(factor, init, next)
////        }
////      }
////
////      case t: Throwable         => throw t
////    }
////  }
//
//  def networkRequestWithRetries(): Future[String] = {
//    networkRequest().recoverWith {
//      case NetworkException =>
//        println("retrying")
//        networkRequestWithRetries()
//      case t: Throwable         => throw t
//    }
//  }
//
//
//}
//
//
//object test extends App{
//  val rc = new RetryCode
//  rc.networkRequestWithRetries()
//}