package lectures.part2oop

object Inheritance extends App {

  // single class inheritance
  sealed class Animal {
    // private def eat = println("nomnom")
    // Public:
    // def eat = println("nomnom")
    // protected allows the method to be used in the subclass
    def eat = println("nomnom")
    val creatureType = "wild"
  }

  // Animal is a superclass of Cat
  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  /*class Dog(override val creatureType: String) extends Animal {
    override def eat = println("crunch, crunch")
    // override val creatureType = "domestic"
  }*/

  class Dog(val dogType: String) extends Animal {
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)
  println(dog.dogType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overRIDING vs overLOADING

  // super

  // preventing overrides
  // 1 - use final on member
  // 2 - use on the entire class
  // 3 - seal the class = extend classes in THIS FILE, prevent extension in other files

}
