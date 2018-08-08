package com.training.dayFive

import scala.annotation.tailrec

object GenericTypeExample extends App{

  trait NewList[T] {
    def isEmpty: Boolean

    def head: T

    def tail: NewList[T]

    //def reverse: NewList[T]
  }

  class Cons[T](val head: T, val tail: NewList[T]) extends NewList[T] {
    def isEmpty: Boolean = false
  }

  class Nil[T] extends NewList[T] {
    def isEmpty: Boolean = true

    def head: T = throw new NoSuchElementException

    def tail: NewList[T] = throw new NoSuchElementException
  }

  val list: NewList[Int] =
    new Cons(1, new Cons(2, new Cons(3, new Nil[Int])))

  /**
    * find the nth element in the list
    *
    * @param x  n
    * @param xs input list
    * @tparam T output type
    * @return
    */
  @tailrec
  def nth[T](x: Int, xs: NewList[T]): T = {
    if (xs.isEmpty) throw new IndexOutOfBoundsException
    else if (x == 0) xs.head
    else nth(x - 1, xs.tail)
  }

  println(nth(2, list))
  //println(nth(4, list))
}
