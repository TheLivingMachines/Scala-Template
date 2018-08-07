package com.training.dayFour

import com.training.dayThree.B_DataAbstraction._
import com.training.dayThree.D_ClassHierarchies.{Empty, IntSet}
import com.training.dayThree.G_CaseClass.One

object A_ImportExample extends App{
  /**
    * Three different forms of imports:
    *
    * > first two forms are called named imports.
    * > the last form is called a wildcard import.
    *
    * you can import from either a package or an object.
    */

  val findGcd: Int = gcd(10, 20)

  val tree: IntSet = (new Empty).incl(10)

  val o: One = One(10, 20)

  /**
    * Automatic Imports:
    * ------------------
    *
    * Some entities are automatically imported in any scala program.
    *
    * There are:
    * > All members of package scala
    * > All members of package java.lang
    * > All members of the singleton object scala.Predef
    *
    * Here are the fully qualified names of some types and functions
    * which you have seen so far:
    *
    * Int                 ->              scala.Int
    * Boolean             ->              scala.Boolean
    * Object              ->              java.lang.Object
    * require             ->              scala.Predef.require
    * assert              ->              scala.Predef.assert
    */

  /**
    * For more scala package details:
    *
    * https://www.scala-lang.org/api/current/
    *
    */



}
