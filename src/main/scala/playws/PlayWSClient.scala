//package playws
//
//import akka.actor.ActorSystem
//import akka.stream.ActorMaterializer
//import com.typesafe.config.ConfigFactory
//import com.typesafe.scalalogging.{LazyLogging, StrictLogging}
//import play.api.libs.ws.{StandaloneWSClient, WSClientConfig}
//import play.api.libs.ws.ahc.{AhcWSClientConfig, StandaloneAhcWSClient}
//
//import scala.concurrent.duration._
//import play.shaded.ahc.org.asynchttpclient.AsyncHttpClientConfig
//
//import scala.concurrent.Future
//import scala.util.control.NonFatal
//
//object ScalaClient extends StrictLogging {
//  import play.api.libs.ws.DefaultBodyReadables._
//  import scala.concurrent.ExecutionContext.Implicits._
//
//  def main(args: Array[String]): Unit = {
//    // Create Akka system for thread and streaming management
//    implicit val system = ActorSystem()
//    system.registerOnTermination {
//      System.exit(0)
//    }
//    implicit val materializer = ActorMaterializer()
//
//    val config = ConfigFactory.load()
//
//
//    print(config.getInt("test"))
//
//    logger.info("testing now!!!!")
//
//    // Create the standalone WS client
//    // no argument defaults to a AhcWSClientConfig created from
//    // "AhcWSClientConfigFactory.forConfig(ConfigFactory.load, this.getClass.getClassLoader)"
//
//    val playWsConfig = AhcWSClientConfig(WSClientConfig())
//    val wsClient = StandaloneAhcWSClient(playWsConfig)
//
//
//    call(wsClient)
//      .andThen { case _ => wsClient.close() }
//      .andThen { case _ => system.terminate() }
//  }
//
//  def call(wsClient: StandaloneWSClient): Future[Unit] = {
//    wsClient.url("https://google32x.com").withRequestTimeout(10000.millis).get().map ( response ⇒{
//      print(response)
//      val statusText: String = response.statusText
//      val body = response.body[String]
//      println(s"Got a response $statusText")
//    }).recover {
//      case NonFatal(t) =>
//        println(s"Got $t")
//    }
//  }
//}
