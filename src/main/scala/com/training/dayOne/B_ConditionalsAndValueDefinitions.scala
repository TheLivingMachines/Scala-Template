package com.training.dayOne

object B_ConditionalsAndValueDefinitions {

  /**
    * Conditional Expression if-else.
    *
    * It looks like a if-else in Java, but is used for expressions not statements.
    *
    * Example:
    * -------
    */
  def abs(x: Int): Int = if(x >= 0) x else -x  // x >= 0 is a predicate, of type boolean

  /**
    * Here are reduction rules for Boolean expression (`e` is an arbitrary expression)
    *
    * ! true -> false
    * ! false -> true
    * true && e -> e
    * false && e -> false
    * true || e -> true
    * false || e -> e
    *
    * Note that && and || do not always need right operand to be evaluated.
    */
  // Exercise : Formulate rewrite rules for if-else
  val one: Int = if(true) 1 else 0
  val two: Int = if(false) 1 else 0


  /**
    * Value Definitions
    */
  def square(x: Int): Int = x * x  // this will evaluate on each time when square(10) called

  val result: Int = square(10) // this right hand side evaluated at the point of definition itself.

  /**
    * Exercise
    *
    * Write functions `and` and `or` such that for all argument expressions x and y:
    * and(x, y) = x && y
    * or(x,y) = x || y
    *
    * do not use || and &&
    */

}
