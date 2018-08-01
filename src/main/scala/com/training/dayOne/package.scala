package com.training

package object dayOne {
  import common._

  def timeComplexity[R](block: => R): R = time(block)
}
