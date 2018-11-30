package lectures.part1basics

object Functions extends App {

  /* Implementation of a function is a single expression
    def aFunction(a: String, b: Int): String =
      a + " " + b
   */

  // a code block is also an expression
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParamaterlessFunction(): Int = 42
  println(aParamaterlessFunction())
  println(aParamaterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION.

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  /*
    1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
   */
    def greeting(name: String, age: Int): String = "Hi, my name is " + name + " and I am " + age + " years old"
    println(greeting("Jordan", 34))

    def greetingForKids(name: String, age: Int): String =
      "Hi, my name is " + name + " and I am " + age + " years old"
    println(greetingForKids("David", 12))

  /*
    2. Factorial function 1 * 2 * 3 .. * n
   */
    def factorial(n: Int): Int = if (n > 1) n * factorial(n - 1) else n
    println(factorial(4))

    def factorial2(n: Int): Int =
      if (n <= 0) 1
      else n * factorial2(n - 1)
    println(factorial2(4))

  /*
    3. A Fibonacci function
    f(1) = 1
    f(2) = 1
    f(n) = f(n - 1) + f(n - 2)
    0, 1, 1, 2, 3, 5, 8, 13, 21, 34...
   */
  def fibonacci(n: Int): Int = {
    if (n <= 1) n
    else fibonacci(n - 1) + fibonacci(n - 2)
  }
  println(fibonacci(8))

  def fibonacci2(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci2(n - 1) + fibonacci2(n - 2)
  }
  println(fibonacci2(8))

  /*
    4. Tests if a number is prime
   */
  def isPrime(n: Int): Boolean = {
    def isDivisible(x: Int): Int = {
      if (x <= 1) 1
      else
        if((n % x) == 0) 0
        else isDivisible(x - 1)
    }

    isDivisible(n - 1) > 0
  }
  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))

  def isPrime2(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    isPrimeUntil(n / 2)
  }
  println(isPrime2(37))
  println(isPrime2(2003))
  println(isPrime2(37 * 17))
}
