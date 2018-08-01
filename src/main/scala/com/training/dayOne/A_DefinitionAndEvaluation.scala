package com.training.dayOne

/**
  * Scala Day One
  * by rumesh
  */
object A_DefinitionAndEvaluation {


  /**
    * Definition
    * ----------
    *
    * Three types -> val, var and def
    */
  // immutable
  val x: Int = 10

  // mutable
  var y: Double = 10.4

  // function definition
  def z: Double = 12.34 // without parameter
  def sum(x: Int, y: Int): Int = x + y // Definition can have parameters
  // Primitive types are as in Java, but are written Capitalized

  /**
    * Evaluation
    * ----------
    *
    * A non-primitive expression is evaluated as follows.
    * 1. Take the leftmost operator (with respective precedence)
    * 2. Evaluate its operands (left before right / left -> right)
    * 3. Apply the operator to the operands
    *
    * A name is evaluated by replacing it with the right hand side of its definitions.
    * The evaluation process stops once it results in a value.
    *
    **/
  //Listed in increasing order of precedence:
  //----------------------------------------
  // (all letters)
  // |
  // ^
  // &
  // = !
  // < >
  // :
  // + -
  // * / %
  // (all other special characters)
  /**
    * Evaluation:
    * -----------
    * (2 * pi) * radius
    * = (2 * 3.14159) * radius
    * = 6.28318 * radius
    * = 6.28318 * 10
    * = 62.8318
    */
  val pi: Double = 3.14159
  val radius: Int = 10
  val result: Double = (2 * pi) * radius

  /**
    * Evaluation of function applications
    *
    * Applications of parameterized functions are evaluated in a similar way as operators.
    * 1. Evaluate all function arguments from left to right
    * 2. Replace the function application by the function's right-hand side and at the same time
    * 3. Replace the formal parameters of the function by the actual arguments
    */
  def square(x: Int): Int = x * x

  def sumOfSquare(x: Int, y: Int): Int = square(x) + square(y)

  /**
    * Evaluation:   (Call-by-Value)
    * -----------
    * sumOfSquare(3, 2 + 2)
    * = sumOfSquare(3, 4)
    * = square(3) + square(4)
    * = 3 * 3 + square(4)
    * = 9 + square(4)
    * = 9 + 4 * 4
    * = 9 + 16 = 25
    */
  val result2: Int = sumOfSquare(3, 2 + 2)

  /**
    * The substitution model
    * ----------------------
    *
    * This scheme of expression evaluation is called the substitution model.
    * The idea underlying this model is that all evaluation does is reduce an expression to a value.
    * It can be applied to all expressions, as long as they have no side effects.
    *
    * The substitution model is formalized in the lambda calculus, which gives a foundation of functional programming.
    *
    */


  /**
    * Termination
    * -----------
    * Does every expression reduce to a value (in a finite number of steps)?
    *
    * No.
    */
  def loop: Int = loop

  // call the function
  // loop -> loop -> ...
  // loop

  /**
    * Changing the evaluation strategy
    *
    * The interpreter reduces function arguments to values before rewriting the function application.
    * One could alternatively apply the function to unreduced arguments.
    */

  /**
    * Evaluation:  (Call-by-Name)
    * -----------
    * sumOfSquare(3, 2 + 2)
    * = square(3) + square(2 + 2)
    * = 3 * 3 + square(2 + 2)
    * = 9 + square(2 + 2)
    * = 9 + (2 + 2) * (2 + 2)
    * = 9 + 4 * (2 + 2)
    * = 9 + 4 * 4
    * = 9 + 16
    * = 25
    */
  def squareN(x: => Int): Int = x * x

  def sumOfSquareN(x: Int, y: => Int): Int = squareN(x) + squareN(y)

  val result3: Int = sumOfSquareN(3, 2 + 2)

  /**
    * Both strategies reduce to the same final value as long as
    * 1. the reduced expression consists of pure functions and
    * 2. both evaluations terminate
    *
    * * Call-by-value has the advantage that it evaluates every function arguments only once.
    * * Call-by-name has the advantage that a function arguments is not evaluated
    * if the corresponding parameter is unused in the evaluation of the function body.
    *
    */

  /**
    * Termination
    *
    * what if termination is not guaranteed?
    *
    * we have :
    * if CBV evaluation of an expression `e` terminates, then CBN evaluation of `e` terminates too.
    * The other direction is not true.
    */
  def callByValue(x: Int, y: Int): Int = x * x

  def callByName(x: Int, y: => Int): Int = x * x

  def next: Int = next

  // difference
  callByValue(10, next) // end up with , infinite loop
  callByName(10, next) // return 100

  /**
    * Scala normally uses call-by-value.
    * But if the type of a function parameter starts with => it uses call-by-name.
    */

  /**
    * Example :
    * ---------
    *
    *
    */
  def test(x: Int, y: Int): Int = x * x

  /**
    * For each of the following function application, indicate which
    * evaluation strategy is fastest (has the fewest reduction steps)
    */
  test(2, 3)
  test(3 + 4, 8)
  test(7, 2 * 4)
  test(3 + 4, 2 * 4)

}
