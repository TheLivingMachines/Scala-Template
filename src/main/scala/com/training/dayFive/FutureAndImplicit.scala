package com.training.dayFive

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util._

object FutureAndImplicit
  extends App
    with Compute{

  /**
    * Scala Future and Implicit
    */

  val x: Future[Int] =
    Future {
      println("i am inside x at beginning")
      val temp = 10   // some expression
      println("i am inside x at ending")
      temp
    }

  val y: Future[Int] =
    Future {
      println("i am inside y at beginning")
      val temp = throw new Exception("error")
      println("i am inside y at ending")
      temp
    }

  x.onComplete{
    case Success(result) =>
      println(result)
    case Failure(error) =>
      println(error.getMessage)
  }

  y.onComplete{
    case Success(result) =>
      println(result)
    case Failure(error) =>
      println(error.getMessage)
  }


  /**
    * implicit
    */
  implicit val imp: Int = 10
  val j: Int = f(15) + g(15)

  /**
    * Non implicit
    */
  val ii: Int = 10
  val jj: Int = ff(15)(ii) + gg(15)(ii)

}
