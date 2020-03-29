//package akka
//
//import akka.actor.ActorSystem
//import akka.stream.ActorMaterializer
//import akka.stream.scaladsl.{Keep, Sink, Source}
//
//object AkkaMaterializerRunGraph extends App {
//
//  // The start of our simple graph. It provides elements, integers in our case
//  val source = Source(1 to 10)
//
//  // The end of our graph. It processes the source's elements
//  val sink = Sink.fold[Int, Int](0)(_ + _)
//
//  /*
//   * Connect source and sink.
//   * Keep only the output values (i.e., the graph's right side).
//   * Note that this is declarative: no result is computed until we run the graph.
//   */
//  val graph = source.toMat(sink)(Keep.right)
//
//  // The system coordinates actors and provides threads for them
//  implicit val actorSystem = ActorSystem()
//  // The materializer makes actors execute graphs
//  implicit val materializer = ActorMaterializer()
//
//  // Running the graph means that the materializer assigns actors to execute
//  // the graph from start (source) to end (sink)
//  val futureResult = graph.run()
//
//  // Use the actor system's execution context, which provides threads,
//  // to print the result of running the graph
//  implicit val executionContext = actorSystem.dispatcher
//  futureResult.foreach(res => println(s"Result of running the graph: $res"))
//
//  actorSystem.terminate().foreach(_ => println("System is shut down"))
//}