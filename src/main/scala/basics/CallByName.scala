package basics

object CallByName extends App {

  def time() = {
    println("Entered time() ...")
    System.nanoTime
  }

  // `t` is now defined as a by-name parameter
  def exec(t: => Long) = {
    println("Entered exec, calling t ...")
    println("t = " + t)
    println("Calling t again ...")
    t
  }

  println(exec(time()))

}
