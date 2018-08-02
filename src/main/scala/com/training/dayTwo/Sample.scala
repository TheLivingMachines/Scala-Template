package com.training.dayTwo

object Sample extends App {

  def sumInts(a: Int, b: Int): Int =
    if (a > b) 0 else a + sumInts(a + 1, b)

  def cube(x: Int): Int = x * x * x

  def sumCubes(a: Int, b: Int): Int =
    if (a > b) 0 else cube(a) + sumCubes(a + 1, b)

  def fact(x: Int): Int = if (x == 0) 1 else x * fact(x - 1)

  def sumFactorials(a: Int, b: Int): Int =
    if (a > b) 0 else fact(a) + sumFactorials(a + 1, b)

  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)

  def sumIntsHO(a: Int, b: Int): Int = sum(id, a, b)

  def sumCubesHO(a: Int, b: Int): Int = sum(cube, a, b)

  def sumFactHO(a: Int, b: Int): Int = sum(fact, a, b)

  // identity function , it takes input and return the same as output
  def id(x: Int): Int = x


  val a: Int = 5
  val b: Int = 7

  val sumOfAandB: Int = sumInts(a, b)
  val sumOfCubesAandB: Int = sumCubes(a, b)
  val sumOfFactAandB: Int = sumFactorials(a, b)

  println("a : " + a + ", b : " + b)
  println(sumOfAandB == sumIntsHO(a, b))
  println(sumOfCubesAandB == sumCubesHO(a, b))
  println(sumOfFactAandB == sumFactHO(a, b))


  val convertIntToDouble = {
    println("")
    (x: Int) => x.toDouble
  }

  def fun1(a: Int) = {

  }


  convertIntToDouble(12)

}
