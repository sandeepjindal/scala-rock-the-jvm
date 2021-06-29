package rockthejvm

object Functions extends App {

  def aFunction(aParam1:Int,aParam2:String):String = {
    aParam1.toString + aParam2
  }

  println(aFunction(3," No. frost"))

  def aParameterlessFunction() = 42

  println(aParameterlessFunction())

  //beating the loops


  // return type of function for recursion
  def aRepeatedFunction(aParam: String, count:Int): String = {
      if(count == 1){
        aParam
      } else{
        aParam + aRepeatedFunction(aParam,count-1)
      }
  }
  println(aRepeatedFunction("sandy",3))


  // tail recursion => []
//
//
  def aInlinedFunction(n: Int): Int = {

    def aInlineFunction(a: Int, b:Int) = {
      a+b
    }

    aInlineFunction(n,n-1)
  }

  println(aInlinedFunction(3))
//

  def greeting(name: String, age: Int) = {
    "Hi, my name is " + name + " and I am " + age.toString + "years old."
  }

  println(greeting("sandy",18))

  def factorial(n : Int):Int = {
    if(n == 0 || n == 1){
      1
    } else{
      n * factorial(n-1)
    }
  }

  println(factorial(4))

  def fibonacci(n : Int):Int = {
    if(n == 1 || n == 2){
      1
    } else{
      fibonacci(n-1) + fibonacci(n-2)
    }
  }

  println(fibonacci(5))

  def isPrime(n : Int):Boolean = {

    def isPrimeHelper(counter: Int):Boolean = {
      if(counter <= 1){
        true
      } else {
        if(n%counter == 0){
          false
        } else{
          isPrimeHelper(counter-1)
        }
      }
    }
    isPrimeHelper(n/2)
  }

  println(isPrime(2))

}
