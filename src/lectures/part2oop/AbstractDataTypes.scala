package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract -- fields or methods blank/unimplemented -- class which contain unimplemented fields or methods
  // abstract class should not be instantiated
  // made to be extended later
  abstract class Animal {
    val creatureType: String = "wild" // abstract classes can have non-abstract types
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat" // can also have non-abstract members
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - can only extend one class but can mix in multiple traits (multiple traits may be inherited by the same class)
  // 3 - traits = behavior, abstract class = type of thing

  /* Type hierarchy
    scala.Any
      scala.AnyRef (Object) a.k.a. String, List, Set...
        scala.Null
          scala.Nothing
      scala.AnyVal a.k.a Int, Unit, Boolean, Float
        scala.Nothing
  */
}
