package com.training

package object common {

  /**
    * find the time complexity for given block of execution
    *
    * @param block user defined block
    * @tparam R return type
    * @return
    */
  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block // call-by-name
    val t1 = System.nanoTime()
    println("** Elapsed time: " + (t1 - t0) + "ns")
    result
  }

  /**
    * find the space complexity at the time of function call
    *
    * @param t type
    * @param p all / used memory details
    */
  def spaceUsed(t: String = "mb", p: String = "used"): Unit = {
    // memory info
    val size = t match {
      case s if s.toLowerCase == "bytes" => 1
      case s if s.toLowerCase() == "kb" => 1024
      case s if s.toLowerCase() == "mb" => 1024 * 1024
      case s if s.toLowerCase() == "gb" => 1024 * 1024 * 1024
      case _ => 1024 * 1024
    }
    val runtime = Runtime.getRuntime
    p match {
      case s if s.toLowerCase() == "used" =>
        println("** Used Memory:  " + (runtime.totalMemory - runtime.freeMemory) / size + s" $t")
      case _ =>
        println("** Used Memory:  " + (runtime.totalMemory - runtime.freeMemory) / size + s" $t")
        println("** Free Memory:  " + runtime.freeMemory / size + s" $t")
        println("** Total Memory: " + runtime.totalMemory / size + s" $t")
        println("** Max Memory:   " + runtime.maxMemory / size + s" $t")
    }
  }

}
