package com.training.dayTwo

object SampleTwo extends App {

  var i: Int = 1

  /**
    *
    */
  /*val convertIntToDouble: Int => Double = {
    println("i : " + i)
    i = i + 1
    (x: Int) => i + x.toDouble
  }*/

  /**
    *
    * @return
    */
  def funOne: Int => Double = {
    i = i + 1
    println("i : " + i)
    (x: Int) => i + x.toDouble
  }

  /**
    *
    * @param x
    * @return
    */
  def funTwo(x: Int): Double = {
    println("i : " + i)
    i = i + 1
    x.toDouble
  }

  /**
    * Execute
    */
  println(funOne(10))
  println(funOne(11))
  println(funOne(12))

}
