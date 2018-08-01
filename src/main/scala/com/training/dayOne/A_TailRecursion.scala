package com.training.dayOne

object A_TailRecursion extends App {

  /**
    * greatest common divisor between two number
    *
    * Euclid's Algorithm:
    *
    * @param a first number
    * @param b second number
    * @return
    */
  def gcd(a: Int, b: Int): Int =
    if (b == 0) a
    else gcd(b, a % b)

  /**
    * Evaluation:
    * -----------
    * gcd(14, 21)
    * -> if (21 == 0) 14 else gcd(21, 14 % 21)
    * -> if (false) 14 else gcd(21, 14 % 21)
    * -> gcd(21, 14 % 21)
    * -> gcd(21, 14)
    * -> if (14 == 0) 21 else gcd(14, 21 % 14)
    * ->> gcd(14, 7)
    * ->> gcd(7, 0)
    * -> if (0 == 0) 7 else gcd(0, 7 % 0)
    * -> 7
    */


  /**
    * classical algorithm of factorial
    *
    * @param n given input
    * @return
    */
  def factorial(n: Long): Long = {
    if (n == 0) 1
    else n * factorial(n - 1)
  }

  /**
    * Evaluation:
    * -----------
    * factorial(4)
    * -> if (4 == 0) 1 else 4 * factorial(4 - 1)
    * ->> 4 * factorial(3)
    * ->> 4 * (3 * factorial(2))
    * ->> 4 * (3 * (2 * factorial(1))
    * ->> 4 * (3 * (2 * (1 * factorial(0)))
    * ->> 4 * (3 * (2 * (1 * 1)))
    * ->> 24
    */

  /**
    * What is the difference between the `gcd` and `factorial` evaluation
    */


  /**
    * Tail Recursion
    * --------------
    *
    * If the function calls itself as its last action, the function's stack frame can be reused.
    * This is called tail recursion.
    *
    * Tail recursive functions are iterative processes.
    *
    * In scala, only directly recursive calls to the current function are optimized.
    * One can require that a function is tail-recursive using a @tailrec annotation:
    *
    * If the annotation is given, and the implementation is gcd were not tail recursive, an error would be issed.
    */


  /**
    * recursive function
    *
    * @param n value
    * @return
    */
  def recursiveFun(n: Long): Long = {
    if (n == 0) 1
    else n * recursiveFun(n - 1)
  }

  /**
    * tail recursive function
    *
    * @param n value
    * @param v accumulator
    */
  //@tailrec
  def tailRecursiveFun(n: Long, v: Long = 1): Long = {
    if (n == 0) v
    else tailRecursiveFun(n - 1, v * n)
  }

  /**
    * find the time complexity
    */
  val n: Int = 1000

  def f2: Long = recursiveFun(n)

  def f3: Long = tailRecursiveFun(n)

  val r2: Long = timeComplexity(f2)
  val r3: Long = timeComplexity(f3)

}
