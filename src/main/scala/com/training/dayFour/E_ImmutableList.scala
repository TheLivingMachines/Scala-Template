package com.training.dayFour

object E_ImmutableList {
  /**
    * Polymorphism:
    * -------------
    *
    * Cons-Lists:
    *
    * A fundamental data structure is many functional languages is the
    * immutable linked list.
    *
    * It is constructed from two building blocks:
    *
    * `Nil` the empty list
    * `Cons` a cell containing an element and the remainder of the list.
    */

  /**
    * Example:
    * --------
    */

  List(1, 2, 3)

  /**
    * Cons(1, Cons(2, Cons(3, Nil)))
    */

  List(List(true, false), List(3))

  /**
    *
    * 1. Cons(true, Cons(false, Nil))
    * 2. Cons(3, Nil)
    *
    * 3. Cons(Cons(true, Cons(false, Nil)), Cons(Cons(3, Nil), Nil))
    */

  /**
    * Here we go,
    */
  trait IntList
  class Cons(val head: Int, val tail: IntList) extends IntList
  class Nil extends IntList

  /**
    * A List s either
    *
    *   > an empty list new Nil or
    *   > a list new Cons(x, xs) consisting of a head element x
    *     and a tail list xs.
    */

  /**
    * How we can make generic List type
    *
    *
    * Type Parameters:
    * ----------------
    *
    * It seems too narrow to define only lists with Int elements.
    *
    * We need another class hierarchy for Double lists, and so on.
    * one for each possible element type.
    *
    * We can generalize the definition using a type parameters.
    *
    *
    */

  trait List[T]
  class ConsT[T](val head : T, val tail: List[T]) extends List[T]
  class NilT[T] extends List[T]

  // Type parameter are written in square brackets, e.g [T]

  /**
    * add the methods `isEmpty: Boolean`, `head: T` and `tail: List[T]`
    *
    * Note: `NoSuchElementException`
    */


  /**
    * Generic Functions:
    *
    * Like classes, functions can have type parameters.
    *
    * For instances, here is a function that creates a list consisting
    * of a single element
    *
    *
   */
  def singleton[T](elem: T): ConsT[T] =
    new ConsT[T](elem, new NilT[T])

  // singleton object creation
  singleton[Int](1)
  singleton[Boolean](true)


  /**
    * Types and evaluation:
    * ---------------------
    *
    * Type parameters do not affect evaluation in Scala.
    *
    * We can assume that all type parameters and type arguments are
    * removed before evaluating the program.
    *
    * This is called type erasure.
    *
    * Languages that use type erasure include Java, Scala, Haskell, ML, OCaml.
    *
    * Some other languages keep the type parameters around at run time, there
    * include C++, C#, F#.
    *
    */

  /**
    * Polymorphism :
    * --------------
    *
    * Polymorphism means that a function type comes "in many forms"
    *
    * In programming it means that,
    *
    *   > the function can be applied to arguments of many types or
    *   > the type can have instances of many types.
    *
    * We have seen two principal forms of polymorphism
    *
    *   > subtyping : instances of a sub class can be passed to a base class.
    *   > generics : instances of a functions or class are created by type
    *                parameterization.
    */

  /**
    * Exercise:
    *
    * Write a function nth that takes an integer `n` and a list and
    * selects the n'th element of the list.
    *
    * Elements are numbered from 0.
    *
    * If index s outside the range from 0 up the length of the list
    * minus one, a `IndexOutOfBoundsException` should be thrown.
    */

  def nth[T](n: Int, xs: List[T]) = ???

  val list: ConsT[Int] =
    new ConsT(1, new ConsT(2, new ConsT(3, new NilT())))

  // test input:
  // nth(2, list)
  // nth(-1, list)
  // nth(4, list)


}

