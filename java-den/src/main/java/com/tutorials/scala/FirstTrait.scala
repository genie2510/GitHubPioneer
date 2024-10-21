package com.homework.scalatutorial

trait FirstTrait {
  def isEqual(x: Any): Boolean
  def isNotEqual(x: Any): Boolean = !isEqual(x)
}

class PointFirst(xc: Int, yc: Int) extends FirstTrait {
  var x: Int = xc
  var y: Int = yc

  def isEqual(obj: Any) = obj.isInstanceOf[PointFirst] && obj.asInstanceOf[PointFirst].x == y
}

object TraitDemo {
  def main(args: Array[String]) {
    val p1 = new PointFirst(2, 3)
    val p2 = new PointFirst(2, 4)
    val p3 = new PointFirst(3, 3)

    println(p1.isNotEqual(p2))  // 2 == 4
    println(p1.isNotEqual(p3)) // 2 == 3
    println(p1.isNotEqual(2)) //2 == 2
  }
}