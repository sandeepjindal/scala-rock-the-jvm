//Day 3,8

//object Planets extends Enumeration {
//  val Mercury = Value
//  val Venus = Value
//  val Earth = Value
//  val Mars = Value
//  val Jupiter = Value
//  val Saturn = Value
//  val Uranus = Value
//  val Neptune = Value
//  val Pluto = Value
//}
//
//Planets.Mercury.id
//Planets.Venus.id
//
//Planets.Mercury
//Planets.Venus.toString
//
//(Planets.Earth == Planets.Earth)
//(Planets.Neptune == Planets.Jupiter)
////
//

def t = 2

val t1 = 1



//object GreekPlanets extends Enumeration {
//
//  val Mercury = Value(10, "Hermes")
//  val Venus = Value(2, "Aphrodite")
//  //Fun Fact: Tellus is Roman for (Mother) Earth
//  val Earth = Value(3, "Gaia")
//  val Mars = Value(4, "Ares")
//  val Jupiter = Value(5, "Zeus")
//  val Saturn = Value(6, "Cronus")
//  val Uranus = Value(7, "Ouranus")
//  val Neptune = Value(8, "Poseidon")
//  val Pluto = Value(9, "Hades")
//}
//
//GreekPlanets.Mercury
//
//object PlanetsOneLine extends Enumeration {
////  type PlanetsOneLine = Value
//  val Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune, Pluto = Value
//}
////
////object GreekPlanetsString extends Enumeration {
////
////  val Mercury = Value("Hermes")
////  val Venus = Value("Aphrodite")
////  val Earth = Value("Gaia")
////  val Mars = Value("Ares")
////  val Jupiter = Value("Zeus")
////  val Saturn = Value("Cronus")
////  val Uranus = Value("Ouranus")
////  val Neptune = Value("Poseidon")
////  val Pluto = Value("Hades")
////}
////
////
////GreekPlanets.Mercury.id
////GreekPlanets.Venus.id
////
////GreekPlanets.Mercury.toString
////GreekPlanets.Venus.toString
////
////(GreekPlanets.Earth == GreekPlanets.Earth)
////(GreekPlanets.Neptune == GreekPlanets.Jupiter)
//
//
//object Planet extends Enumeration {
//  protected case class Val(mass: Double, radius: Double) extends super.Val {
//    def surfaceGravity: Double = Planet.G * mass / (radius * radius)
//    def surfaceWeight(otherMass: Double): Double = otherMass * surfaceGravity
//  }
//  import scala.language.implicitConversions
//  implicit def valueToPlanetVal(x: Value): Val = x.asInstanceOf[Val]
//
//  val G: Double = 6.67300E-11
//  val Mercury = Val(3.303e+23, 2.4397e6)
//  val Venus   = Val(4.869e+24, 6.0518e6)
//  val Earth   = Val(5.976e+24, 6.37814e6)
//  val Mars    = Val(6.421e+23, 3.3972e6)
//  val Jupiter = Val(1.9e+27, 7.1492e7)
//  val Saturn  = Val(5.688e+26, 6.0268e7)
//  val Uranus  = Val(8.686e+25, 2.5559e7)
//  val Neptune = Val(1.024e+26, 2.4746e7)
//}
//
//println(Planet.values.map(x => x.toString).toList)
//
//
//println(Planet.values.filter(_.radius > 7.0e6))
//
////homework why value is needed?
//
//// implicit conversion day 9
//
//
////import enumeratum._
////
////sealed trait Weekday extends EnumEntry
////object Weekday extends Enum[Weekday] {
////  val values = findValues // mandatory due to Enum extension
////
////  case object Monday extends Weekday
////  case object Tuesday extends Weekday
////  case object Wednesday extends Weekday
////  case object Thursday extends Weekday
////  case object Friday extends Weekday
////  case object Saturday extends Weekday
////  case object Sunday extends Weekday
////}
////
