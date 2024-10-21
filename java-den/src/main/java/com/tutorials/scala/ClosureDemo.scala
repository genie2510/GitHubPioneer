package com.homework.scalatutorial

object ClosureDemo {
  def main(args: Array[String]) {
    println("multiplier(1) value = " + multiplier(1))
    println("multiplier(2) value = " + multiplier(2))

    println("multiMultiplier(5,10) value = " + multiMultiplier(5, 10))
  }
  var factor = 3
  //Anonymous function
  val multiplier = (i: Int) => i * factor

  //Anonymous function
  val multiMultiplier = (i: Int, i1: Int) => { i * i1 * factor + 1 }
}