package com.training.dayOne

object Exercise {

  /**
    * Exercise 1 : Pascal’s Triangle
    * ------------------------------
    *
    * The following pattern of numbers is called Pascal’s triangle.
    *     1
    *    1 1
    *   1 2 1
    *  1 3 3 1
    * 1 4 6 4 1
    *    ...
    *
    * The numbers at the edge of the triangle are all `1`, and each number inside
    * the triangle is the sum of the two numbers above it. Write a function that
    * computes the elements of Pascal’s triangle by means of a recursive process.
    *
    * which takes a column c, a row r, counting from 0 and returns the number at
    * that spot in the triangle.
    *
    * For example, pascal(0,2)=1,pascal(1,2)=2 and pascal(1,3)=3.
    *
    * Testing:
    */
  def pascal(c: Int, r: Int): Int = ???

  /**
    * Exercise 2 : Parentheses Balancing
    * ----------------------------------
    *
    *
    * Write a recursive function which verifies the balancing of parentheses in a string,
    * which we represent as a List[Char] not a String. For example, the function should
    * return true for the following strings:
    *
    * 1. (if (zero? x) max (/ 1 x))
    * 2. I told him (that it’s not (yet) done). (But he wasn’t listening)
    *
    * The function should return false for the following strings:
    *
    * 1. :-)
    * 2. ())(
    *
    * The last example shows that it’s not enough to verify that a string contains the
    * same number of opening and closing parentheses.
    *
    * There are three methods on List[Char] that are useful for this exercise:
    *
    * 1. chars.isEmpty: Boolean returns whether a list is empty
    * 2. chars.head: Char returns the first element of the list
    * 3. chars.tail: List[Char] returns the list without the first element
    *
    * Hint: you can define an inner function if you need to pass extra parameters to your function.
    *
    * Testing:
    */
  def balance(chars: List[Char]): Boolean = ???

  /**
    * Exercise 3 : Counting Change
    * ----------------------------
    *
    * Write a recursive function that counts how many different ways you can make
    * change for an amount, given a list of coin denominations. For example, there
    * are 3 ways to give change for 4 if you have coins with denomination 1 and 2:
    * 1+1+1+1, 1+1+2, 2+2.
    *
    * This function takes an amount to change, and a list of unique denominations for the coins.
    *
    * Once again, you can make use of functions isEmpty, head and tail on the list of integers coins.
    *
    * Hint: Think of the degenerate cases. How many ways can you give change for 0 CHF(swiss money)?
    *       How many ways can you give change for >0 CHF, if you have no coins?
    *
    * Testing:
    */
  def countChange(money: Int, coins: List[Int]): Int = ???

}
