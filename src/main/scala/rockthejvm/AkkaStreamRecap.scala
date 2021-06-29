package rockthejvm

import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, OverflowStrategy}
import akka.stream.scaladsl.{Flow, Keep, Sink, Source}

import scala.util.{Failure, Success}

object AkkaStreamRecap extends App {
  implicit val system = ActorSystem("AkkaStreamRecap")
  implicit val materializer = ActorMaterializer()
  import system.dispatcher

  val source = Source(1 to 100)
  val sink = Sink.foreach[Int](println)
  val flow = Flow[Int].map(x => x+1)

  val runnableGraph = source.via(flow).to(sink)
  val simpleMaterializedValue = runnableGraph
//    .run() // MATERIALIZATION


  val sumSink = Sink.fold[Int,Int](0)((currentSum,element) => currentSum + element)
//  val sumFuture = source.runWith(sumSink)
//  sumFuture.onComplete{
//    case Success(sum) => println(sum)
//    case Failure(exception) => println(s"something went wrong $exception")
//  }

  val anotherMaterializedValue = source.viaMat(flow)(Keep.right).toMat(sink)(Keep.left)
//    .run()

  /**
   * 1. Materializing a graph means materializing all the components
   * 2. a materialized value can be ANYTHING at all
   */

  /**
   * backpressure
   * -- buffer elements
   * -- appliy strategy in case buffer overflows
   * -- fail the entire stream
   */
  val bufferedFlow = Flow[Int].buffer(10,OverflowStrategy.dropHead)

  source.async.via(bufferedFlow).async.runForeach{
    e => Thread.sleep(100)
    println(e)
  }
}
