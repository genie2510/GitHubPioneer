package com.homework.scalatutorial.ImplicitObject

class Interpolators {

  def executeStringInterpolator(): Unit = {
    var name = "Ravi"
    println(s"Hello, $name")
    println(s"1 + 1 = ${1 + 1}")
  }

  def executeFloatInterpolator(): Unit = {
    val height = 1.9d
    val name = "James"
    println(f"$name%s is $height%2.2f meters tall")
    // println(f"$name%s is $height%2.2 meters tall") error
  }

  def executeRawInterpolator(): Unit = {
    println(s"Result = \n a \n b")
    println("Result = \n a \n b")
    println(raw"Result = \n a \n b")
  }
}

object StringInterpolatorObject {
  def main(args: Array[String]) {
    var si = new Interpolators();
    si.executeStringInterpolator();
    println("\n")
    si.executeFloatInterpolator();
    println("\n")
    si.executeRawInterpolator();
  }
}