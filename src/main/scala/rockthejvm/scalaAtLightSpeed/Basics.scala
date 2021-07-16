package rockthejvm.scalaAtLightSpeed

object Basics extends App {
 // define a val
  val meaningOfLife: Int = 42 // const int meaningOfLife = 42

  val aBoolean: Boolean = false

  val aString = "I love scala"

  val aComposedString  = "I" + "love" + "Scala"

  val anInterPolatedString = s"Mweaning of life: ${meaningOfLife}"

  val andExpression = 2+3

  val IfExpression = if(meaningOfLife > 43) 56 else 999
  val aCodeBlock = {
    val codeValue= 3

    codeValue +2
  }

  def myFunction(x: Int, y:String) : String = y + " " + x

}
