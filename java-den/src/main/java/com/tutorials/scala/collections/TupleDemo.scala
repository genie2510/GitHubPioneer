package com.homework.scalatutorial.collections

object TupleDemo {
  def main(args: Array[String]) {
    val t = (4, 3, 2, 1)

    t.productIterator.foreach { i => println("Value = " + i) }

    val t1 = new Tuple3(1, "hello", Console)
    println("Concatenated String: " + t1.toString())

    val t2 = new Tuple2("Scala", "hello")
    println("Swapped Tuple: " + t2.swap)
  }
}