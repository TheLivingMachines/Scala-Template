package com.training.dayFour

object F_LazyEvaluation {

  /**
    * Lazy Evaluation:
    * ----------------
    *
    * right hand side expression evaluated when the first time
    * of variable (lazy val) identifier get used.
    *
    */

  // allowed
  lazy val x: Int = 10

  //lazy var y: Int = 10

  //lazy def z: Int = 90


  //Tuple

  val p: (Int, Int) = (10, 30)

}
