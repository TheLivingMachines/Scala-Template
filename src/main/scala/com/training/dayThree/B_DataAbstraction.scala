package com.training.dayThree

object B_DataAbstraction {

  /**
    * Previous Example:
    *
    * val x = new Rational(1, 3)
    * val y = new Rational(5, 7)
    * y.add(y) //
    */

  /**
    * How we can expect the rational numbers to be simplified ?
    *
    * reduce them to their smallest numerator and denominator by
    * dividing both with a divisor.
    *
    * We could implement this in each rational operation, but it would be
    * easy to forget this division in an operation.
    *
    * A better alternative consists of simplifying the representation in
    * the class when the objects are constructed :
    */

  // use the gcd function to simply the rational number creation


  def gcd(a: Int, b: Int):Int =
    if(b==0) a else gcd(b,a%b)

  /**
    * Implement more rational functions:
    *
    *   1. x1/y1 < x2/y2 = x1 * y2 < x2*y1
    *   2. max(x1/y1, x2/y2) = using step 1.
    */


  // val strange = new Rational(1, 0)
  // strange.add(strange)

  /**
    * Add requirement to the class (Preconditions):
    *
    * Let's say our Rational Class required that the denominator
    * is positive.
    *
    * We can enforce this by calling the require function.
    */
  class Rational(x:Int, y: Int){
    require(y > 0, "denominator must be positive.")
  }

  /**
    * require is a predefined function.
    *
    * It takes a condition and an optional message string.
    *
    * If the conditional passed to require is false, an
    * `illegalArgumentException` is thrown with the given message string.
    */


  /**
    * Assertions:
    * -----------
    *
    * Besides `require`, there is also `assert`.
    *
    * Assert also takes a condition and an optional message string as
    * parameters. E.g.
    *
    *   > val x = sqrt(y)
    *   > assert(x >= 0)
    *
    * Like require, a failing assert will also thrown an exception, but
    * it's a different one:
    *   > AssertionError for assert.
    *   > IllegalArgumentException for require.
    *
    * This reflects a difference in intent,
    *
    *   > require is used to enforce a precondition on the caller of a function
    *   > assert is used as to check the code of the function itself.
    *
    */


  /**
    * Constructors:
    * -------------
    *
    *
    * In scala, a class implicitly introduces a constructor. This one is
    * called the primary constructor of the class.
    *
    * The primary constructor
    *   > takes the parameters of the class
    *   > and executes all statements in the class body
    *     (such as require and so on )
    */


  /**
    * Example: second constructor
    */
}
