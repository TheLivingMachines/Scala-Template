package com.training.dayThree

object D_ClassHierarchies {

  /**
    * Abstract Classes
    * ----------------
    *
    * Consider the task of writing a class for sets of integers with the
    * following operations.
    *
    *
    */
  abstract class IntSet {
    def incl(x: Int): IntSet

    def contains(x: Int): Boolean
  }

  // IntSet is an abstract class

  /**
    * Abstract classes can contain members which are missing an
    * implementation (in our case, incl and contains).
    *
    * Consequently, no instances of an abstract class can be
    * created with the operator new
    */

  /**
    * Class Extensions:
    * -----------------
    *
    * Let's consider implementing sets as binary trees.
    *
    * There are two types of possible trees; a tree for `the empty set`
    * and a tree consisting of an integer and two sub-trees.
    *
    * Here are their implementations:
    */
  class Empty extends IntSet {
    override def contains(x: Int): Boolean = false

    override def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

    override def toString: String = "."
  }

  class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
    override def contains(x: Int): Boolean =
      if (x < elem) left contains x
      else if (x > elem) right contains x
      else true

    override def incl(x: Int): IntSet =
      if (x < elem) new NonEmpty(elem, left incl x, right)
      else if (x > elem) new NonEmpty(x, left, right incl x)
      else this

    override def toString: String = "{" + left + elem + right + "}"
  }

  /**
    * Empty and NonEmpty both extend the class IntSet.
    *
    * This implies that the types Empty and NonEmpty conform to the
    * type IntSet.
    *
    * An object of type Empty pr NonEmpty can be used whenever an object
    * of type type IntSet is required.
    *
    */

  /**
    * IntSet is called the superclass of Empty and NonEmpty
    *
    * Empty and NonEmpty are subclasses of IntSet.
    *
    * In Scala, any user-defined class extends another class.
    *
    * If no superclass is given, the standard `class Object` in the Java,
    * package java.lang is assumed
    *
    * The direct or indirect superclasses of a class C are called `base classes` of C.
    *
    * So, the base classes of NonEmpty are IntSet and Object.
    */

}
