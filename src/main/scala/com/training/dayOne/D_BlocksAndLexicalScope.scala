package com.training.dayOne

object D_BlocksAndLexicalScope {

  /**
    * Nested functions
    *
    * it is good have multiple functions for the implementation of sqrt not for its usage.
    * Normally we would not like users to access these functions directly.
    *
    * we can achieve this and at the same time avoid "name-space pollution" by putting
    * auxiliary functions inside `sqrt`.
    */
  def abs(x: Double): Double = if (x < 0) -x else x

  def sqrt(x: Double): Double = {

    def improve(guess: Double, x: Double): Double = (guess + (x / guess)) / 2

    def isGoodEnough(guess: Double, x: Double): Boolean = abs(guess * guess - x) / x < 0.001

    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)

    sqrtIter(1, x)
  }

  /**
    * Blocks in Scala
    * ---------------
    *
    * A block is delimited by braces { ... }
    *
    * {
    * val x = f(3)
    * x * x
    * }
    * or
    * { val y = f(4)
    * y
    * }
    *
    * It contains a sequence of definitions and expressions.
    * The last element of a block is an expression that defines its value. (return )
    * This return expression can be preceded by auxiliary definitions.
    * Blocks are themselves expressions; a block may appear everywhere as expression can.
    *
    */

  /**
    * Blocks and Visibility
    * ---------------------
    * 1. The definitions inside a block are only visible from within the block.
    * 2. The definitions inside a block shadow definitions of the same names outside the block.
    */
  val x = 0

  def f(y: Int): Int = y + 1

  val result: Int = {
    val x: Int = f(3)
    x * x
  }

  /**
    * Lexical Scoping
    * ---------------
    * Definitions of outer blocks are visible inside a block unless they are shadowed.
    *
    * Therefore, we can simplify `sqrt` function.
    */

  def sqrtLexicalScoping(x: Double): Double = {

    def improve(guess: Double): Double = (guess + (x / guess)) / 2

    def isGoodEnough(guess: Double): Boolean = abs(guess * guess - x) / x < 0.001

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    sqrtIter(1)
  }

  /**
    * Semicolons:
    * -----------
    * In Scala, semicolons at the end of lines are in most cases optional.
    *
    * On the other hand, if there are more than one statements on a line,
    * we need to be separated by semicolons.
    *
    * val y = x + 1; y * y
    */

  /**
    * Semicolons and infix operators:
    * -------------------------------
    * One issue with Scala's semicolons conventions is how to write expressions that span several lines.
    * For instance:
    *     someLongExpressions
    *     + someOtherExpressions
    *
    * this interpreted as two expressions:
    *     someLongExpressions;
    *     + someOtherExpressions
    *
    * Solutions:
    * ----------
    *     (someLongExpressions
    *      + someOtherExpressions)
    *
    *     or
    *
    *     someLongExpressions +
    *     someOtherExpressions
    *
    */
}