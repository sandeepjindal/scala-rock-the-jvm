//Day 2

// Learned - collections have parents,
// you can choose right depend the use case - day x.(Advanced)

// Monads basics 101 - re cover the fold.
val number: Option[Int] = Some(3)
val noNumber: Option[Int] = None
val result1 = number.fold(2)(_ * 3)
val result2 = noNumber.fold(2)(_ * 3)
val result3 = noNumber.map(_ * 3).getOrElse(2)


////Options
//val someValue: Option[Double] = Some(20.0)
//// pattern matching
//
//val value = someValue match {
//  case Some(v) => v
//  case None => 0.0
////  case _ => "Ant"
//}

// Exception case
//val noneVal = None
//
//val sadAnt = None.get

//val noValue: Option[Double] = None
//val value1 = noValue match {
//  case Some(v) ⇒ v
//  case None ⇒ 0.0
//}
//value1

// map of None
//val number: Option[Int] = Some(3)
//val noNumber: Option[Int] = None
//val result1 = number.map(_ * 1.5)
//val result2 = noNumber.map(_ * 1.5)

// flatMap and flatten

