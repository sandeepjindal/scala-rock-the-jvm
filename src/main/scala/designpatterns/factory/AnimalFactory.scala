package designpatterns.factory

object AnimalFactory {

  private class Dog extends Animal {
    override def speak(): String = {
      return "woof woof";
    }
  }

  private class Cat extends Animal {
    override def speak(): String = {
      return "Meow";
    }
  }

  private class Duck extends Animal {
    override def speak(): String = {
      return "Quack Quack";
    }
  }

  def apply(animalName: String): Animal = {
    animalName match {
      case "dog" => new Dog
      case "cat" => new Cat
      case _ => new Duck
    }
  }
}


