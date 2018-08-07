package com.training.dayFour

object B_ApplyAndUnApply extends App {

  /**
    * Case class has apply and unapply method definition implicitly.
    *
    */

  case class C(a: Int, b: Double)

  class B(val x: Int)

  val c: C = C.apply(10, 100l) // C(10)
  val b: B = new B(10)

  /**
    * extract information using unapply method
    */
  c match {
    case C(x, _) => println(x)
    //case B(y) => println(y)  // wrong not works
    case _ => println("nothing")
  }

  /**
    * Pattern matching
    */
  c match {
    case y: B => println(y.a)
    case x: C => println(x.a)
  }

  b match {
    case x: C => println(x.a)
    case y: B => println(y.x)
  }
}
