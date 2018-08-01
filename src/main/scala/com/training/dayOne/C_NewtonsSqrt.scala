package com.training.dayOne

object C_NewtonsSqrt {

  /**
    * The classical way to achieve this is by successive approximations
    * using Newton's method/
    *
    * @param x input
    * @return
    */
  def sqrt(x: Double): Double = ???

  /**
    * To compute  sqrt(x):
    *   1. start with an initial estimate y (let's pick y = 1)
    *   2. repeatedly improve the estimate by taking the mean of y and x/y
    *
    * Example: sqrt(2)
    *
    * Estimation(y)         Quotient (x/y)           Mean
    * 1                     2 / 1 = 2                1.5
    * 1.5                   2 / 1.5 = 1.333          1.4167
    * 1.4167                2 / 1.4167 = 1.4118      1.4142
    * 1.4142                ...                      ...
    *
    */
  def square(x: Double): Double = x * x

  def abs(x: Double): Double = if (x < 0) -x else x

  // 1. improve the guess by previous guess and x
  //    core of Newton's method
  def improve(guess: Double, x: Double): Double = (guess + (x / guess)) / 2

  // 2. check the we reached the approximate sqrt of x
  def isGoodEnough(guess: Double, x: Double): Boolean = abs(square(guess) - x) < 0.001

  // 3. sqrt iterate function (recursive)
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  // def sqrt(x: Double): Double = sqrtIter(1, x)

  /**
    * Recursive function need as explicit return type in Scala,
    * Non-Recursive function, the return type is optional.
    */

  /**
    * Exercise
    *
    * 1. The `isGoodEnough` test is not very precise for small numbers and can lead to non-termination for very large number.
    * 2. Design a different version of `isGoodEnough` that does not have these problem.
    * 3. Test new version with some very very small and large numbers:
    *    E.g: 0.001, 0.1e-20, 1.0e20, 1.0e50
    */

  // Ans: abs(square(guess) - x) / x < 0.001
}
