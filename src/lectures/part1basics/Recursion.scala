package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      return result
    }

  println(factorial(10))
  //println(factorial(5000))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x < 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }

  /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factHelper(2, 3... 8 * 9 * 10 * 1)
    = factHelper(1, 2... 8 * 9 * 10 * 1)
    = 2... 8 * 9 * 10 * 1
  */
  println(anotherFactorial(20000))

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION.

  /*
    1. Concatenate a string n times
    2. IsPrime function tail recursive
    3. Fibonacci function, tail recursive.
   */

  def concatenate(s: String, n: Int): String = {
    @tailrec
    def helper(i: Int, acc: String): String =
      if (i == 1) acc
      else helper(i - 1, acc + s)

    helper(n, s)
  }

  println(concatenate("Jordan", 3))

  @tailrec
  def concatenateTailrec(aString: String, n: Int, accumulator: String): String =
    if(n <= 0) accumulator
    else concatenateTailrec(aString, n - 1, aString + accumulator)

  println(concatenateTailrec("hello", 3, ""))

  @tailrec
  def isPrime(n: Int): Boolean =
    if (n == 1 || n % 2 != 0) true
    else n % 2 != 0 && isPrime(n - 1)

  println(isPrime(104743))

  def isPrime2(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailRec(n / 2, true)
  }

  println(isPrime2(2003))
  println(isPrime2(629))

  def fibonacci(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacci(8))
}
