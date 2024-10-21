package com.homework.scalatutorial

import scala.util.matching.Regex

object RegexDemo {
  def main(args: Array[String]) {
    val pattern = "Scala".r
    val pattern1 = "Scala1".r
    val str = "Scala is Scalable and cool"

    //Finds out word Scala from a statement.
    println(pattern findFirstIn str)
    println("\n");
    println(pattern1 findFirstIn str)
    println("\n");

    val regexContructor = new Regex("(S|s)cala")
    println((regexContructor findAllIn str).mkString(","))
    println("\n");

    val patternWithrMethod = "(S|s)cala".r
    println(patternWithrMethod replaceFirstIn (str, "Java"))
    println(patternWithrMethod replaceAllIn (str, "Java"))
    println("\n");

    val patternFormatting = new Regex("abl[ae]\\d+") //Match a digit: [0-9]
    val str1 = "ablaw is able1 and cool"

    println((patternFormatting findAllIn str1).mkString(","))
  }
}