package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Integer = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!" // must have a space before colon
    def isAlive: Boolean = true
    def apply(): String = s"Hi my name is $name and I like $favoriteMovie"

    def +(nickname: String): Person = new Person(s"${this.name} ($nickname)", favoriteMovie)
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def learns(what: String): String = s"${this.name} learns $what"
    def learnsScala: String = learns("Scala")
    def apply(times: Integer) = s"${this.name} watched ${this.favoriteMovie} $times times"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation (or operator notation) (an example of syntactic sugar) Only works with methods with one parameter

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS.
  // Akka actors have operators like ! ?

  // prefix notation
  val x = -1 // - is a unary operator; equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)

  // postfix notation (functions with no parameters)
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent

  /*
    1. Overload the plus operator returns a new person with a nickname
    mary + "the rockstar" => new Person "Mary (the rockstar)"
   */

  val maryTheRockstar = mary + "the rockstar"
  println(maryTheRockstar.name)
  println((mary + "the rockstar").apply())

  /*
    2. Add an age to the Person class with default zero value
       Add a unary + operator that increments the value of age and returns a new Person with the value of age + 1
       +mary => mary with the age incremented (mimicks ++)
   */

  val oldMary = +mary
  println(oldMary.age)
  println((+mary).age)

  /*
    3. Add a "learns" method in the Person class => "Mary learns Scala"
       Add a learnsScala method (no params), calls the learns method with "Scala".
       Use it in postfix notation.
   */

  println(mary.learns("Scala"))
  println(mary learnsScala)

  /*
    4. Overload the apply method to receive a number and return a string
       mary.apply(2) => "Mary watched Inception 2 times"
   */

  println(mary(2))
}
