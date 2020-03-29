//package playws
//
//import scala.concurrent.{Await, ExecutionContext, Future}
//import scala.concurrent.duration._
//import play.api.mvc._
//import play.api.libs.ws._
//import play.api.http.HttpEntity
//import akka.actor.ActorSystem
//import akka.stream.ActorMaterializer
//import akka.stream.scaladsl._
//import akka.util.ByteString
//import javax.inject.Inject
//import play.shaded.ahc.org.asynchttpclient.AsyncHttpClientConfig
//
//import scala.concurrent.ExecutionContext.Implicits.global
//
//
//class PlayWSClient2 @Inject() (ws: WSClient) {
//
//  def test() {
//
//    val request: WSRequest = ws.url("https://bk-qaterra-1001.agoda.local:8001/chargebackapi/version.txt")
//
//
//    val complexRequest: WSRequest =
//      request.addHttpHeaders("Accept" -> "application/json")
//        .withRequestTimeout(10000.millis)
//
//    val futureResponse: Future[WSResponse] = request.get().map {
//      response => {
//        print(response)
//        response
//      }
//
//    }
//  }
//}
