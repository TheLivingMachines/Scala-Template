package com.training.dayThree

import com.training.dayThree.D_ClassHierarchies.{IntSet, NonEmpty}

object F_ObjectDefinitions {

  /**
    * In the IntSet example, one could argue that there is really only a
    * single empty IntSet.
    *
    * So it seems overKill to have the user create many instances of it.
    *
    * We can express this case better with an object definitions
    *
    */
  object Empty extends IntSet {
    override def contains(x: Int): Boolean = false

    override def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  }

  /**
    * This defines a `Singleton Object` named Empty
    *
    * No other Empty instances can be created.
    *
    * Singleton objects are values, so Empty evaluated to itself.
    *
    */

  /**
    * Exercise:
    *
    * Write a method `union` for forming the union of two sets, You
    * should implement the following in abstract IntSet.
    *
    *
    * > def union(other: IntSet): IntSet
    *
    * Empty:
    * > def union(other: IntSet): IntSet = other
    *
    * NonEmpty:
    * > def union(other: IntSet): IntSet =
    *     ((left union right) union other) incl elem
    */

  /**
    * Dynamic Binding :
    *
    * Object-Oriented languages implement `dynamic method dispatch`
    *
    * This means that the code invoked by a method call depends on the
    * runtime type of the object that contains the method.
    *
    */
  //Example 1:
  // Empty contains 1
  // -> [1/x][Empty/this] false
  // -> false

  //Example 2:
  // (new NonEmpty(7, Empty, Empty)) contains 7
  // -> [7/elem] [7/x] [new NonEmpty(7, Empty, Empty)/ this]
  // -> if (x < elem) this.left contains x
  //     else if (x > elem) this.right contains x  else true
}
