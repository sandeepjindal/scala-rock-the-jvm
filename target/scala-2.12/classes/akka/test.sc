Object Routes {
  path("basicauthtest"){
    authenticateBasic(realm = "secure  site", BasicAuthenticator.myUserPassAuthenticator) { user =>
      complete {
        HttpResponse(entity = HttpEntity("SUCCESS"))
      }
    }
  }
}

Object BasicAuthenticator {
  private val hardCodedPassword = "qwerty"  //For example purposes only

  def myUserPassAuthenticator(credentials: Credentials): Option[String] = credentials match {
    case p@Credentials.Provided(id) if p.verify(hardCodedPassword) => Some(id)
    case _ => None
  }
}