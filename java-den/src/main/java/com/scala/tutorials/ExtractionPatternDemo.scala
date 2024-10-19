package com.homework.scalatutorial

object ExtractionPatternDemo {
  def main(args: Array[String]) {
    val x = ExtractionPatternDemo(5)
     val x1 = ExtractionPatternDemo(51)
    println(x)
    println(x==x1)

    x match {
      case ExtractionPatternDemo(num) => println(x + " is bigger two times than " + num)

      //unapply is invoked
      case _         => println("i cannot calculate")
    }
  }
  def apply(x: Int) = x * 2
  def unapply(z: Int): Option[Int] = if (z % 2 == 0) Some(z / 2) else None
}