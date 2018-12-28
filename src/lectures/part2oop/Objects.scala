package lectures.part2oop

object Objects {

  // SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY ("static")
  object Person { // type + its only instance
    // "static"/"class" level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method (it builds Persons)
    // def from(mother: Person, father: Person): Person = new Person("Bobby")
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  class Person (val name: String) {
    // instance-level functionality
  }
  // COMPANIONS (object and class in the same scope with the same name)

  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john)

    val person1 = Person
    val person2 = Person
    println(person1 == person2)

    // val bobbie = Person.from(mary, john)
    val bobbie = Person(mary, john)
  }

  // Scala Applications = a Scala object with
  // def main(args: Array[String]): Unit

}
