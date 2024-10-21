package com.homework.scalatutorial

object Variable {

  //variable declaration

  var myInt: Int = 10;
  var myInt1: Int = 10;
  val myString: String = "class variable";

  //Multiple assignments
  val (myVar1: Int, myVar2: String) = Pair(40, "Foo")

  def main(args: Array[String]) {

    var myVar: String = "Foo can be changed" // Mutable
    println(myVar);

    val myVal: String = "Foo cannot be changed" // Immutable
    println(myVal);

    println(myInt + "   " + myInt1);
    println(myString);

    println("Multiple assignments  " + myVar1 + "   " + myVar2);

    var myVarWithDT: Int = 10;
    val myValWithDT: String = "Hello Scala with datatype declaration.";
    var myVar1WithoutDT = 20;
    val myVal1WithoutDT = "Hello Scala new without datatype declaration.";

    println(myVarWithDT); println(myValWithDT); println(myVar1WithoutDT);
    println(myVal1WithoutDT)
  }
}