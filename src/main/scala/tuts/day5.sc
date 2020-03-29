//Day 5
/***
 * Scala’s “for comprehensions” are equivalent to Haskell’s “do” notation, and
 * it is nothing more than a syntactic sugar for composition of multiple monadic operations.
 * As this statement will most likely not help anyone who needs help, let’s try again…
 */



//for (i <- 1 to 5) yield i
//
////count
//
val a = Array(1, 2, 3, 4, 5)
////

for (e <- a) yield {
  println(e)
  e
}

//for {
//  e <- a
//} yield e+2


//var count = 0
//for (i <- 1 to 5){
//  count = count + 1
//}

//var sum= 0
//
//for(i <- a) {
//  sum = sum + i
//}
//
//sum
//
//a.reduce(_ + _)