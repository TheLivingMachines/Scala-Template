package com.training.dayThree

object C_ClassesAndSubstitutions {

  /**
    * We previously defined the meaning of a function application using a
    * computation model based on substitution. Now we extend this model
    * to classes and objects
    *
    * Question: How is an instantiation of the class `new C(e1,..,en)` evaluated ?
    *
    * Ans: The expressions arguments e1,...,en are evaluated like the arguments
    * of a normal functions. That's it.
    *
    * The resulting expression, say `new C(v1,...vn)` is already a value
    *
    */


  /**
    * Classes and Substitutions:
    * --------------------------
    *
    * Now suppose that we have a class definitions:
    *
    * > class C(x1,...,xm) { ... def f(y1,...,yn) = b ... }
    *
    * where,
    * > The formal parameters of the class are x1,...,xm
    * > The class defines a method `f` with formal parameters y1,...,yn
    *
    * (The list of function parameters can be absent, For simplicity , we
    * have omitted the parameters types.)
    *
    * Question:  How is the following expression evaluated ?
    *
    * > new C(v1,...,vm).f(w1,...,wn)
    *
    * Answer:
    *
    * > [w1/y1,....,wn/yn][v1/x1,....,vm/xm][new C(v1,...,vm)/this]b
    *
    * There are three substitutions at work here,
    *
    * > The substitution of the formal parameters y1,...yn of the function
    * `f` by the arguments w1,...wn
    * > The substitution of the formal parameters x1,...xm of the class C
    * by the class arguments v1,...vm
    * > The substitution of the self reference this by the value of the
    * object new C(v1,...vn)
    *
    *
    */

  // new Rational(1, 2).numer

  /**
    * new Rational(1, 2).numer
    * -> [1/x, 2/y][][new Rational(1,2)/this]x
    *
    * -> 1
    *
    *
    * new Rational(1, 2).less(new Rational(2, 3))
    * -> [1/x, 2/y][new Rational(2, 3)/that][new Rational(1,2)/this]
    *     this.numer * that.denom < that.numer * this.denom
    *
    * -> new Rational(1, 2).numer * new Rational(2, 3).denom <
    * new Rational(2, 3).numer * new Rational(1, 2).denom
    *
    * ->> 1 * 3 < 2 * 2
    *
    * ->> true
    */

  /**
    * Operators:
    * ----------
    *
    * In principle, the rational numbers defined by Rational are as
    * natural as integers.
    *
    * But for the user of these abstractions, there is a noticeable
    * difference:
    *
    * > We write x + y, if x and y are integers, but
    * > We write r.add(s) if r and s are rational numbers
    *
    * In Scala, we can eliminate this difference. In two step, we ca write
    *
    */

  /**
    * Step1: Infix Notations:
    * -----------------------
    *
    * Any method with a parameter can be used like an infix operator.
    * It is therefore possible to write.
    *
    *
    * r add s              ->           r.add(s)
    * r less s             ->           r.less(s)
    * r max s              ->           r.max(s)
    */
  /**
    * Step2: Relaxed Identifiers:
    * ---------------------------
    *
    * Operators can be used as identifiers.
    *
    * Thus, an identifiers can be.
    *
    * > Alphanumeric: starting with a letter, followed by a sequence of
    * letters or numbers.
    * > Symbolic: starting with an operator symbol, followed by other
    * operator symbols
    * > The underscore character `_` counts as a letter
    * > Alphanumeric identifiers can also end in an underscore, followed by
    * some operator symbols
    *
    * Examples:
    * x1, *, +?%&, vector_++, counter_=
    *
    *
    * // unary_-
    */

  /**
    * Precedence Rules:
    * -----------------
    *
    * The precedence of an operator is determined by its first character.
    * The following table lists the characters in increasing order of
    * priority precedence.
    */
  //Listed in increasing order of precedence:
  //----------------------------------------
  // (all letters)
  // |
  // ^
  // &
  // = !
  // < >
  // :
  // + -
  // * / %
  // (all other special characters)

  /**
    * Exercise:
    * ---------
    *
    * Provide a fully parenthesized version of.
    *
    * (Note: Every binary operation needs to be put into parentheses,
    *  but the structure of the expressions should not change.)
    */
  //  a + b ^? c ?* d less a ==> b | c

  // Ans: ((a + b) ^? (c ?* d)) less ((a ==> b) | c)
}
