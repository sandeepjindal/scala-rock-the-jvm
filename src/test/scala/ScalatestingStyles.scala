import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.propspec.AnyPropSpec
import org.scalatest.refspec.RefSpec
import org.scalatest.wordspec.AnyWordSpec

object ScalaTestingStyles

class CalculatorSuite extends AnyFunSuite {
  val calculator = new Calculator

  test("multiplication by 0 should always be zero"){
    assert((calculator multiply(54343, 0)) == 0)
    assert((calculator multiply(-54343, 0)) == 0)
    assert((calculator multiply(0, 0)) == 0)
  }

  test("deividing by 0 should return some math erroe"){
    assertThrows[ArithmeticException](calculator.divide(123,0))
  }
}

// BDD
class CalculatorSpec extends AnyFunSpec {
  val calculator = new Calculator

  describe("multiplication"){
//    describe("some other test"){
//
//    }
    it("should give back 0 if multiplying by zero"){
      assert((calculator multiply(54343, 0)) == 0)
      assert((calculator multiply(-54343, 0)) == 0)
      assert((calculator multiply(0, 0)) == 0)
    }
  }

  describe("division"){
    it("should throw a math error if divide by 0"){
      assertThrows[ArithmeticException](calculator.divide(123,0))
    }
  }
}

// BDD natural language
class CalculatorWordSpec extends AnyWordSpec {
  val calculator = new Calculator

  "A calculator" should {
    "give back 0 if multiplying by 0 " in {
      assert((calculator multiply(54343, 0)) == 0)
      assert((calculator multiply(-54343, 0)) == 0)
      assert((calculator multiply(0, 0)) == 0)
    }

    "throw a math exception when divide by 0" in {
      assertThrows[ArithmeticException](calculator.divide(123,0))
    }
  }
}


class CalculatorFreeSpec extends AnyFreeSpec {
  val calculator = new Calculator

  "A calculator" - { // anything you want
    "give back 0 if multiplying by 0 " in {
      assert((calculator multiply(54343, 0)) == 0)
      assert((calculator multiply(-54343, 0)) == 0)
      assert((calculator multiply(0, 0)) == 0)
    }

    "throw a math exception when divide by 0" in {
      assertThrows[ArithmeticException](calculator.divide(123,0))
    }
  }
}

// property-style checking
class CalculatorPropSpec extends AnyPropSpec {
  val calculator = new Calculator

  val multiplyByZeroExamples = List((6443,0),(-6443,0),(0,0),(0,43243))

  property("Calculator multiply by 0 should be 0"){
    assert(multiplyByZeroExamples.forall{
      case (a,b) => calculator.multiply(a,b) == 0
    })
  }


  property("Calculator divide by 0 should be 0"){
    assertThrows[ArithmeticException](calculator.divide(123,0))
  }
}

// wonky testing style
class CalculatorRefSpec extends RefSpec { // based on reflection
  object `A calculator` {
    // test suite
    val calculator = new Calculator

    def `multiply by 0 should be 0`: Unit = {
      assert((calculator multiply(54343, 0)) == 0)
      assert((calculator multiply(-54343, 0)) == 0)
      assert((calculator multiply(0, 0)) == 0)
    }

    def `throw a math exception when divide by 0`: Unit = {
        assertThrows[ArithmeticException](calculator.divide(123,0))
    }
  }
}

class Calculator{
  def add(a: Int, b: Int): Int = {
    a+b
  }

  def subtract(a: Int, b: Int): Int = {
    a - b
  }

  def multiply(a: Int, b: Int): Int = {
    a * b
  }
  def divide(a: Int, b: Int): Double = {
    a / b
  }
}