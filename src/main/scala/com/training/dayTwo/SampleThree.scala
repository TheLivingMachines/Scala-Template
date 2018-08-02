package com.training.dayTwo

import scala.annotation.tailrec

object SampleThree extends App {

  def sumOld(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sumOld(f, a + 1, b)


  def sum(s: Int => Int)(a: Int, b: Int): Int = {
    @tailrec
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, s(a) + acc)
    }

    loop(a, 0)
  }

  def sumIntsHO(a: Int, b: Int): Int = sum((x: Int) => x)(a, b)

  def sumCubesHO(a: Int, b: Int): Int = sum((x: Int) => x * x * x)(a, b)

  def fact(x: Int): Int = if (x == 0) 1 else x * fact(x - 1)

  def sumFactHO(a: Int, b: Int): Int = sum(fact)(a, b)

}
