package com.homework.scalatutorial

import java.io._
import scala.io.Source

object IODemo {
  def main(args: Array[String]) {
    val writer = new PrintWriter(new File("test.txt"))

    writer.write("Hello Scala")
    writer.close()

    println("Following is the content read:")

    Source.fromFile("test.txt").foreach {
      print
    }

    print("Please enter your input : ")
  //  val line = Console.readLine

    println("Thanks, you just typed: ")
  }
}