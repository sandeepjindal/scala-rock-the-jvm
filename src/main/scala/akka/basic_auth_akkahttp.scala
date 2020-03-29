//package akka
//
//import akka.http.scaladsl.model.{HttpEntity, HttpResponse, StatusCodes}
//import akka.http.scaladsl.server.Directives._
//import akka.http.scaladsl.server.Route
//import akka.http.scaladsl.server.directives.Credentials
//import akka.stream.Materializer
//
//object Routes {
//  path("basicauthtest") {
//    authenticateBasic(realm = "secure  site", BasicAuthenticator.myUserPassAuthenticator) { user =>
//      complete {
//        HttpResponse(entity = HttpEntity("SUCCESS"))
//      }
//    }
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