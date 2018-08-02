package com.training.dayTwo

object D_FixedPoint {

  /**
    * A number `x` is called a fixed point of a function `f` if
    *
    * f(x) = x
    *
    * For some function `f` we can locate the fixed points by
    * starting with an initial estimate and then by applying
    * `f` in a repetitive way.
    *
    * x, f(x) , f(f(x)), f(f(f(x))), f(f(f(f(x)))), ...
    *
    * until the value does not vary any more.
    * (or the change is sufficiently small)
    */

  /**
    * Example:
    *
    * x => 1 + x/2
    *
    */

  /**
    * Programmatic Solution:
    * ----------------------
    *
    * This leads to the following function for finding a fixed point.
    *
    *
    */

  def abs(x: Double): Double = if (x < 0) -x else x

  val tolerance = 0.0001

  def isCloseEnough(x: Double, y: Double): Boolean =
    abs((x - y) / x) / x < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double): Double = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }

    iterate(firstGuess)
  }

  fixedPoint(x => 1 + x/2)(1)


  /**
    * Return to Square Roots
    * ----------------------
    *
    * Here is a specification of the sqrt function:
    *
    *   sqrt(x) = the number y such that y * y = x
    *
    * Or, by dividing both sides of the equation with y:
    *
    *   sqrt(x) = the number y such that y = x / y
    *
    * Consequently, sqrt(x) is a fixed point of the function (y => x / y)
    *
    */

  /**
    * This suggests to calculate sqrt(x) by iteration
    * towards a fixed point.
    */
  def sqrt(x: Double) =
    fixedPoint(y => x / y)(1.0)

  /**
    * add the println statement.
    *
    *   > println("guess" + guess)
    */

  def sqrtN(x: Double) =
    fixedPoint(y => (y + x/y)/2)(1.0)


  /**
    * Functions as Return Values:
    * ---------------------------
    *
    * The following example shows that functions that
    * return functions can also be very useful.
    *
    * Consider again iteration towards a fixed point
    *
    * We begin by observing that Sqrt(x) is a fixed point
    * of  the function y => x / y
    *
    * Then, the iteration converges by averaging successive
    * values.
    *
    * This technique of stabilizing by averaging is general
    * enough to merit being abstracted into its own function.
    *
    *
    */

  def averageDamp(f: Double => Double)
                 (x: Double): Double = (x + f(x)) / 2


  /**
    * Exercise:
    * ---------
    *
    * Write a square root function using fixedPoint and averageDamp. ?
    *
    */

  def sqrtA(x: Double): Double = ???

}
