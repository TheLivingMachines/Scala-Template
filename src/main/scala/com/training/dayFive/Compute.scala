package com.training.dayFive

trait Compute {

  def f(i: Int)(implicit imp: Int): Int = i + imp
  def g(i: Int)(implicit imp: Int): Int = i * imp

  def ff(i: Int)(x: Int): Int = i + x
  def gg(i: Int)(x: Int): Int = i * x

}
