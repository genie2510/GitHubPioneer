package com.homework.scalatutorial

class Super {

  protected def f() {
    println("f")
  }
}

class Sub extends Super {
  f()
}

object ProtectedDemo {
  def main(args: Array[String]) {
    // var o = new Sub(); // prints f
    (new Sub) // prints f
    //(new Super).f() // Error: f is not accessible
  }
}