package rockthejvm

object Expressions extends App {

  // mathematical expression
  val x = 1 + 2

  println(x)

  //relational expression
  println(1 == x)

  // Instructions(DO) vs Expressions(have some value)

  val aCondition = true

  val aConditionValue = if(aCondition) 5 else 3 // IF expression

  println(aConditionValue)

  println(if(aCondition) 5 else 3)


  // Golden Rule everything in scala is expression.
  var aVariable =1

  val aWierdValue = (aVariable = 3)
  println(aWierdValue) // return units

  // Anything expression that returns UNIT is a side effect


  //codeBlock Expressions
  val codeBlock = {
    val y =1
    val z = y+1
    if(z>1) "frost" else "sandeep"
  }

}
