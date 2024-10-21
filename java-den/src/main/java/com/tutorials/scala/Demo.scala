package com.homework.scalatutorial
import java.io._

class Point(val xc: Int, val yc: Int) {
  var x: Int = xc
  var y: Int = yc

  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
    println("Point x location : " + x);
    println("Point y location : " + y);
  }

  def this() {
    this(1, 1);
    println("Just");
  }
}

//save the file as Demo.scala or Point.scala
object Demo {
  def main(args: Array[String]) {
    val pt = new Point(10, 20); // Immutable
    var pt1 = new Point(10, 20); // Mutable
    //Invalid - Point p = new Point(10, 20);
    pt.move(10, 10);
    pt1.move(10, 10);

    val d = new Point();
  }
}