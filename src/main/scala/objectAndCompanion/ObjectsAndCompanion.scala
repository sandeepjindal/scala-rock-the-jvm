package objectAndCompanion

object ObjectsAndCompanion {
  // OO + FO
  class Person(firstName: String, lastName: String){
    // fields and methods
  }

  //OO design patterns

  // singleton pattern => only one instance of a type is present in entire codebase

  object MySingleton

  object ClusterSingleton {
    val MAX_NODES = 20
    def getNumberOfNodes(): Int = {
      MAX_NODES
    }
  }

  val maxNodes = ClusterSingleton.MAX_NODES

  // class + object same name in same file


  class Kid(name: String, age: Int){
      def greet = s"My name is ${name} and my age is ${age}, Do i like vegetables ${Kid.LIKES_VEGETABLE}"
  }

  object Kid{ // companion object

    private val LIKES_VEGETABLE: Boolean = false

//    def apply(name: String): Unit ={
//
//    }
//    def unApply() = {
//    }
  }

  // instance-independent code = "static"
  // Companion object are for static fields/methods


  def main(args: Array[String]): Unit = {

  }
}
