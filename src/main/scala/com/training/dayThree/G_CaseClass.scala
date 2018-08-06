package com.training.dayThree

object G_CaseClass {

  case class One(x: Int, y: Int)

  class Two(x: Int, y: Int)


  // create a object
  val o: One = One(1, 2)
  // access the fields
  o.x
  o.y

  // create a object
  val p: Two = new Two(1, 2)
  // not able to access the fields
  //p.x

  // print the object
  println(o)
  println(p)


  // compare the objects
  val o2 = One(1, 2)
  o == o2

}
