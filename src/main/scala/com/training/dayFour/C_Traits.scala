package com.training.dayFour

object C_Traits {
  /**
    * In Java, as well as Scala, a class can only have one superclass.
    *
    * But, what if a class has several natural supertypes to which it
    * conforms or from which it wants to inherit code?
    *
    *
    * Here, you could use traits
    *
    * A `trait` is declared like an abstract class. just with trait
    * instead of abstract class.
    *
    *
    */

  trait Planar {
    def height: Int
    def width: Int
    def surface: Int = height * width
  }

  /**
    * Classes and objects and traits can inherit from at most one class
    * but arbitrary many traits.
    *
    * Example:
    *
    *   > class Square extends Shape with Planar with Movable ....
    *
    *
    * Traits resemble interfaces in Java. but are more powerful because,
    * they can contains fields and concrete methods.
    *
    * On the other hand, traits cannot have (value) parameters, only
    * classes can.
    */



}
