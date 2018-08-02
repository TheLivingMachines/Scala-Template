package com.training.dayTwo

import scala.annotation.tailrec

object B_HigherOrderFunctions {

  /**
    * Higher Order Functions:
    * -----------------------
    *
    * Functional languages treat functions as first-class values.
    *
    * This means that, like any other value, a function can be passed as a
    * parameter and returned as a result.
    *
    * This provides a flexible way to compose programs.
    *
    * Functions
    *   1. that take other functions as parameters or
    *   2. that return functions as results
    * are called higher order functions.
    */

  /**
    * Example 1:
    *
    * Take the sum of the integers between a and b:
    */
  def sumInts(a: Int, b: Int): Int =
    if (a > b) 0 else a + sumInts(a + 1, b)

  /**
    * Example 2:
    *
    * Take the sum of the cubes of all the integers between a and b:
    */
  def cube(x: Int): Int = x * x * x

  def sumCubes(a: Int, b: Int): Int =
    if (a > b) 0 else cube(a) + sumCubes(a + 1, b)

  /**
    * Example 3:
    *
    * Take the sum of the factorials of all the integers between a and b:
    */
  def fact(x: Int): Int = if (x == 0) 1 else x * fact(x - 1)

  def sumFactorials(a: Int, b: Int): Int =
    if (a > b) 0 else fact(b) + sumFactorials(a + 1, b)

  /**
    * These are special cases of
    *
    * Sum of F(n) where n between a and b for different values of `f`.
    *
    */
  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)

  /**
    * we can then write
    */
  def sumIntsHO(a: Int, b: Int): Int = sum(id, a, b)

  def sumCubesHO(a: Int, b: Int): Int = sum(cube, a, b)

  def sumFactHO(a: Int, b: Int): Int = sum(fact, a, b)

  // identity function , it takes input and return the same as output
  def id(x: Int): Int = x


  /**
    * Function Type:
    * --------------
    *
    * The type A => B is the type of a function that takes an argument of
    * type `A` and returns a result of type `B`.
    *
    * So, Int => Int is the type of function that map integers to integers.
    */

  /**
    * Anonymous Functions
    * -------------------
    *
    * Passing functions as parameters leads to the creation of many small functions.
    *
    * Sometimes it is difficult to have to define (and name) these functions using def.
    *
    * Compare to Strings: We do not need to define a string using def, or val, or var.
    *
    * Instead of :
    *
    * > def str = "abc"; println(str)
    *
    * We can directly write :
    *
    * > println("abc")
    *
    * because strings exist as `literals`.
    *
    * Using this literals, which let us write a function without giving it a name.
    */

  /**
    * Example: A func raises its arguments to a cube:
    *
    * > (x: Int) => x * x * x
    *
    * Here, (x: Int) is the parameter of the function, and x * x * x is it's body.
    *
    * The type of parameter can be omitted if it can be inferred by the compiler from the context.
    *
    * If there are several parameters, they are separated by commas:
    *
    * > (x: Int, y: Int) => x + y
    */

  def sumIntsHOA(a: Int, b: Int): Int = sum(x => x, a, b)

  def sumCubesHOA(a: Int, b: Int): Int = sum(x => x * x * x, a, b)

  /**
    * Exercise:
    * ---------
    *
    * The sum function uses linear recursion. Write a tail-recursive version by replaying the ???s.
    */
  /*def sum(s: Int => Int)(a: Int, b: Int): Int = {
    @tailrec
    def loop(a: Int, acc: Int): Int = {
      if (???) ???
      else loop(???, ???)
    }

    loop(???, ???)
  }*/
}
