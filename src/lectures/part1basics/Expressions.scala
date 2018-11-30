package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // Expression
  println(x)

  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // -+ *= /= ..... side effects
  println(aVariable)

  // Instructions (DO [executed]) vs Expressions (VALUE [evaluated])

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)

  var i = 0
  val aWhile = while (i < 10) {
    println(i)
    i += 1
  }

  // NEVER WRITE THIS AGAIN (IMPERATIVE!)

  // Everything in scala is an expression!

  val aWeirdValue = (aVariable = 3) // Unit === void.... side effects are expressions returning Unit!
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  // 1. What is the difference between "hello world" vs println("hello world")?
  //    "hello world" is a string literal
  //    println("hello world") is an expression with a side effect (unit)
  // 2. What is the value of

  val someValue = {
    2 < 3
  }
  // true

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  // 42
}
