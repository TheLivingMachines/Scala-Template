package com.training.dayThree

object E_ImplementationsAndOverriding {

  /**
    * It is also possible to redefine an existing, non-abstract
    * definitions in a sub classes using overrides
    *
    */
  abstract class Base {
    def foo = 1

    def bar: Int
  }

  class Sub extends Base {
    override def foo: Int = 2

    def bar: Int = 3
  }

}
