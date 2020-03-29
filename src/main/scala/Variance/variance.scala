package Variance
class Car {}
class SportsCar extends Car {}
class Ferrari extends SportsCar {}

object morecovariance extends App {

  // Test 1: Works as expected
//functions are contravariant in argument types and covariant in return types.
  def test1( arg: SportsCar => SportsCar ) = {
    new SportsCar
  }

  def foo1(arg: Car): Ferrari = { new Ferrari }
  def foo2(arg: SportsCar): Car = { new Ferrari }
  def foo3(arg: Ferrari): Ferrari = { new Ferrari }

  test1(foo1) // compiles
//  test1(foo2) // Fails due to wrong return type.
//  test1(foo3) // Fails due to wrong parameter type

}