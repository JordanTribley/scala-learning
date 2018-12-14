package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.age)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  val writer = new Writer("Jordan", "Tribley", 2001)
  println(writer.fullName)

  val novel = new Novel("aNovel", 2018, writer)
  println(novel.authorAge)
  val novel2 = novel.copy(2017)
  println(novel2.authorAge)

  val counter = new Counter(10)
  println(counter.count)
  println(counter.decrement(6).count)
  println(counter.increment.count)

  val counter2 = new Counter2(0)
  counter2.inc.print
  counter2.inc(10).print
  counter2.dec(10).print
}

// constructor
class Person(name:String, val age:Int = 0) {
  // body
  val x = 2

  println(1 + 3)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name") // "this." is implied with $name

  // multiple constructors or overloading constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

/*
  Implement a Novel and a Writer class

  Writer: first name, surname, year of birth
    - method called fullname, returns concat first name and surname

  Novel: name, year of release, author (an instance of type Writer)
    - authorAge (age of the author at the year of release
    - isWrittenBy (Author)
    - copy (new year of release) = new instance of Novel with a new year of release
 */

class Writer(firstName: String, surname: String, val yearOfBirth: Int) {
  def fullName: String = firstName + " " + surname
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge: Int = yearOfRelease - author.yearOfBirth
  def isWrittenBy: String = author.fullName
  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)
}

class Writer2(firstName: String, surname: String, val year: Int) {
  def fullName: String = firstName + " " + surname
}

class Novel2(name: String, year: Int, author: Writer2) {
  def authorAge = year - author.year
  def isWrittenBy(author: Writer2) = author == this.author
  def copy(newYear: Int): Novel2 = new Novel2(name, newYear, author)
}

/* Counter class
  - receives an int value
  - method: returns current count
  - method: to increment and decrement the counter by 1, returns a new counter
  - overload the inc/dec methods to receive a param: the amount by which to inc/dec, result is a new counter
 */

class Counter(currentCount: Int) {
  def count: Int = currentCount
  def increment: Counter = new Counter(currentCount + 1)
  def decrement: Counter = new Counter(currentCount - 1)
  def increment(amount: Int): Counter = new Counter(currentCount + amount)
  def decrement(amount: Int): Counter = new Counter(currentCount - amount)
}

class Counter2(val count: Int) {
  def inc = {
    println("incrementing")
    new Counter2(count + 1) // immutability
  }
  def dec = {
    println("decrementing")
    new Counter2(count - 1)
  }

  def inc(n: Int): Counter2 = {
    if (n <= 0) this
    else inc.inc(n-1)
  }
  def dec(n: Int): Counter2 = {
    if (n <= 0) this
    else dec.dec(n-1)
  }

  def print = println(count)
}
// class parameters are NOT FIELDS
