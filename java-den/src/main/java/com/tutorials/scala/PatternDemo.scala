package com.homework.scalatutorial

object PatternDemo {
  def main(args: Array[String]) {
    println(matchTest(3))
    println(matchTest(1))
    println(matchTest(2))
    println(matchTest(99))

    println("\n")

    println(matchTestAnoter(99))
    println(matchTestAnoter("two"))

    println("\n")

    println(matchCaseClasses)
  }

  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }

  def matchTestAnoter(x: Any): Any = x match {
    case 1      => "one"
    case "two"  => 2
    case y: Int => "scala.Int"
    case _      => "many"
  }

  def matchCaseClasses: Any = {
    val alice = new Person("Alice", 25)
    val bob = new Person("Bob", 32)
    val charlie = new Person("Charlie", 32)
    val ravi = new Person("ravi", 56)

    for (person <- List(alice, bob, charlie, ravi)) {
      person match {
        case Person("Alice", 25) => println("Hi Alice!")
        case Person("Bob", 32)   => println("Hi Bob!")
        case Person(name, age) => println(
          "Age: " + age + " year, name: " + name + "?")
      }
    }
  }

  case class Person(val name: String, var age: Int)
}