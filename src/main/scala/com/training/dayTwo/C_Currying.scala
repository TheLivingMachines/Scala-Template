package com.training.dayTwo

object C_Currying {

  /**
    * Currying:
    * --------
    *
    *
    */

  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)

  def fact(n: Int): Int = if (n == 0) 1 else n * fact(n - 1)

  def sumInts(a: Int, b: Int): Int = sum(x => x, a, b)

  def sumCubes(a: Int, b: Int): Int = sum(x => x * x * x, a, b)

  def sumFacts(a: Int, b: Int): Int = sum(fact, a, b)

  /**
    * Question :
    *
    * Note that a and b get passed unchanged from sumInts and sumCubes into sum function.
    *
    * Can we be even shorter by getting rid of those parameters ?
    *
    */

  def sumN(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)

    sumF
  }

  /**
    * sumN is now a function that returns another function
    *
    * The returned function sumF applies the given function parameter f and sums the result
    */

  /**
    * We can then define:
    */
  val sumIntsN: (Int, Int) => Int = sumN(x => x)

  val sumCubesN: (Int, Int) => Int = sumN(x => x * x * x)

  val sumFactsN: (Int, Int) => Int = sumN(fact)

  /**
    * These functions can in turn be applied like any other function:
    *
    */

  val x1: Int = sumCubes(1, 10)
  val x2: Int = sumCubesN(1, 10)
  val y1: Int = sumFacts(10, 20)
  val y2: Int = sumFactsN(10, 20)

  //In the above example, can we avoid the sumInts, sumCubes ?
  val z: Int = sumN(fact)(1, 10)

  /**
    * sumN(fact) applies sumN to fact and returns the sum of facts function
    *
    * sumN(fact) is therefore equivalent to sumFactsN
    *
    * This function is next applied to the arguments (1, 10)
    *
    * sumN(cube)(1, 10) == (sumN(cube))(1, 10)
    */

  def sumSimplified(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sumSimplified(f)(a + 1, b)


  /**
    * What is the type of sum ?
    *
    *   > def sum(f: Int => Int)(a: Int, b: Int): Int = ???
    *
    */

  /**
    * Exercise:
    * ---------
    *
    * 1. Write a product function that calculates the product of the values of a function
    *    for the points on a given interval ?
    *
    * 2. Write factorial in terms of product ?
    *
    * 3. Can you write a more general function, which generalized both sum and product ?
    */


  val x: (Int) => (Int => Int) =
    (x: Int) => (y: Int) => x + y
}
