package com.homework.scalatutorial.collections

object MapDemo {
  def main(args: Array[String]) {
    val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")

    val nums: Map[Int, Int] = Map()

    println("Keys in colors : " + colors.keys)
    println("Values in colors : " + colors.values)
    println("Check if colors is empty : " + colors.isEmpty)
    println("Check if nums is empty : " + nums.isEmpty)

    println("\n \n");

    colors.keys.foreach { i =>
      print("Key = " + i)
      println(" Value = " + colors(i))
    }

    println("\n \n");

    if (colors.contains("red")) {
      println("Red key exists with value :" + colors("red"))
    } else {
      println("Red key does not exist")
    }
  }
}