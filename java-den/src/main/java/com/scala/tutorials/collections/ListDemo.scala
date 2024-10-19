package com.homework.scalatutorial.collections

object ListDemo {
  def main(args: Array[String]) {
    //oneDimensionList
    //alterateList
    //listOperations
    //uniformList
    tabulateFunction
    
  }

  def oneDimensionList: Unit = {

    // List of Strings
    val fruit: List[String] = List("apples", "oranges", "pears")

    // List of Integers
    val nums: List[Int] = List(1, 2, 3, 4)

    // Empty List.
    val empty: List[Nothing] = List()

    // Two dimensional list
    val dim: List[List[Int]] =
      List(
        List(1, 0, 0),
        List(0, 1, 0),
        List(0, 0, 1))

    for (i <- dim) println(i)
    for (i <- dim) for (j <- i) println(j)
  }

  def alterateList: Unit = {
    // List of Strings
    val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))

    // List of Integers
    val nums = 1 :: (2 :: (3 :: (4 :: Nil)))

    // Empty List.
    val empty = Nil

    // Two dimensional list
    val dim = (1 :: (0 :: (0 :: Nil))) ::
      (0 :: (1 :: (0 :: Nil))) ::
      (0 :: (0 :: (1 :: Nil))) :: Nil
  }

  def listOperations: Unit = {
    val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
    val nums = Nil

    println("Head of fruit : " + fruit.head)
    println("Tail of fruit : " + fruit.tail)
    println("Check if fruit is empty : " + fruit.isEmpty)
    println("Check if nums is empty : " + nums.isEmpty)
  }

  def uniformList: Unit = {
    val fruit = List.fill(3)("apples") // Repeats apples three times.
    println("fruit : " + fruit)
    println("reverse fruit : " + fruit.reverse )

    val num = List.fill(10)(2) // Repeats 2, 10 times.
    println("num : " + num)
  }

  def tabulateFunction: Unit = {
    // Creates 5 elements using the given function.
    val squares = List.tabulate(9)(n => n * n)
    println("squares : " + squares)

    val mul = List.tabulate(4, 5)(_ * _)
    println("mul : " + mul)
  }
}