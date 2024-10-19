package com.homework.scalatutorial

class Outer {
  class Inner {
    /*private*/ def f() { println("f") }

    class InnerMost {
      f() 
      f() // OK
    }
  }
  (new Inner).f() // Error: f is not accessible
}

object OuterDemo {
  def main(args: Array[String]) {
    var o = new Outer();
    var o1 :Outer = new Outer();
  }
}