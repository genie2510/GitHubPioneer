package com.homework.scalatutorial.collections

object IteratorDemo {
  def main(args: Array[String]) {
    val it = Iterator("a", "number", "of", "words")

    while (it.hasNext) {
      println(it.next())
    }

    val ita = Iterator(20, 40, 2, 50, 69, 90)
    val itb = Iterator(20, 40, 2, 50, 69, 90)

    println("Maximum valued element " + ita.max)
    println("Minimum valued element " + itb.min)

    val ita1 = Iterator(20, 40, 2, 50, 69, 90)
    val itb1 = Iterator(20, 40, 2, 50, 69, 90)
    println("Value of ita.size : " + ita1.size)
    println("Value of itb.length : " + itb1.length)

  }
}