//import akka.BasicAuthenticator
//import akka.actor.ActorSystem
//import akka.http.scaladsl.Http
//import akka.http.scaladsl.model._
//import akka.http.scaladsl.server.Directives._
//import akka.http.scaladsl.server.directives.Credentials
//import akka.stream.ActorMaterializer
//
//import scala.io.StdIn
//
//object WebServer {
//  def main(args: Array[String]) {
//
//    implicit val system = ActorSystem("my-system")
//    implicit val materializer = ActorMaterializer()
//    // needed for the future flatMap/onComplete in the end
//    implicit val executionContext = system.dispatcher
//
//    val route =
//      path("hello") {
//        get {
//          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>"))
//        }
//      } ~  path("basicauthtest") {
//        authenticateBasic(realm = "secure  site", BasicAuthenticator.myUserPassAuthenticator) { user =>
//          complete {
//            HttpResponse(entity = HttpEntity("SUCCESS"))
//          }
//        }
//      }
//
//    val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)
//
//    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
//    StdIn.readLine() // let it run until user presses return
//    bindingFuture
//      .flatMap(_.unbind()) // trigger unbinding from the port
//      .onComplete(_ => system.terminate()) // and shutdown when done
//  }
//}
//
//object BasicAuthenticator {
//  private val hardCodedPassword = "qwerty" //For example purposes only
//
//  def myUserPassAuthenticator(credentials: Credentials): Option[String] = credentials match {
//    case p@Credentials.Provided(id) if p.verify(hardCodedPassword) => Some(id)
//    case _ => None
//  }
//}