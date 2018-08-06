package com.training.dayThree

object A_ClassAndObjects {

  /**
    * How functions create and encapsulate data structures. ?
    *
    */
  /**
    * Example: Rational Numbers
    * -------------------------
    *
    * A rational number x/y is represented by two integers:
    * > its numerator `x` and
    * > its denominator `y`.
    */

  /**
    * Class:
    * ------
    * In Scala, we do this by defining a class:
    */
  class Rational(x: Int, y: Int) {
    // in rational number x/y, get numerator
    def numerator: Int = x

    // in rational number x/y, get denominator
    def denominator: Int = y
  }

  /**
    * This definition introduces two entities:
    * > A new type, named Rational
    * > A constructor Rational to create elements of this type
    *
    * Scala keeps the names of types and values in different namespaces.
    * So there's no conflict between the two definitions of Rational.
    */
  //def Rational = 10
  val r1: Rational = new Rational(10, 20)

  /**
    * Objects:
    * --------
    * We call the elements of a class type objects.
    * We created an object by prefixing an application of the constructor
    * of the class with the operator new.
    *
    * Ex: new Rational(1, 2)
    */
  /**
    * Objects of the class Rational have two members(method) numerator and denominator.
    *
    * We select the members of an object with the infix operator '.' (like in Java)
    */
  r1.denominator
  r1.numerator

  /**
    * Rational Arithmetic
    * -------------------
    *
    * We can now define the arithmetic functions that implements the standard rules.
    *
    * >   n1/d1 + n2/d2 = (n1 * d2 + n2 * d1) / (d1 * d2)
    * >   n1/d1 - n2/d2 = (n1 * d2 - n2 * d1) / (d1 * d2)
    * >   n1/d1 . n2/d2 = (n1 * n2) / (d1 * d2)
    * >   n1/d1 / n2/d2 = (n1 * d2) / (d1 * n2)
    * >   n1/d1 == n2/d2 iff (n1 * d2) == (d1 * n2)
    *
    */

  /**
    * Implementing Rational Arithmetic:
    */

  def addRational(r: Rational, s: Rational): Rational =
    new Rational(
      r.numerator * s.denominator + s.numerator * r.denominator,
      r.denominator * s.denominator
    )

  def makeString(r: Rational): String =
    r.numerator + "/" + r.denominator


  //calling
  makeString(addRational(new Rational(1, 2), new Rational(2, 3))) // Result: 7/6

  /**
    * Methods:
    * --------
    * One can go further and also package functions operating on a data abstraction in the data abstraction itself.
    *
    * Such functions are called `methods`.
    *
    * Example:
    * Rational numbers now would have, in addition to the functions numerator and denominator.
    * the functions add, sub, mul, div, equal, toString.
    *
    */

  class RationalA(x: Int, y: Int) {
    def numerator: Int = x

    def denominator: Int = y

    def add(that: Rational): Rational =
      new Rational(
        numerator * that.denominator + that.numerator * denominator,
        denominator * that.denominator
      )

    override def toString: String =
      numerator + "/" + denominator
  }

  /**
    * Exercise:
    * --------
    *
    * 1. Add a method neg to class Rational that is used like this:
    *     > x.neg       // evaluated  to -x
    *
    * 2. Add a method sub to subtract two rational numbers.
    * 3. With the values of x, y, z as given in the previous slide,
    *    What is the result of x - y - z
    *
    */


  /**
    * Tryout:
    *
    * val x = new Rational(1, 3)
    * val y = new Rational(5, 7)
    * val z = new Rational(3, 2)
    *
    * x.sub(y).sub(z)
    * x.add(y)
    */

}
