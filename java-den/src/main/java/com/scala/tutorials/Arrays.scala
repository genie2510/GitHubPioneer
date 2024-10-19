package com.homework.scalatutorial
import Array._

object Arrays {
  def main(args: Array[String]) {
    //singleDimArrays;
    //multiDimArrays;
    //concatArrays;
    rangeArrays
  }

  def singleDimArrays: Unit = {
    var z: Array[String] = new Array[String](3)
    // or
    var z1 = new Array[String](3)

    z(0) = "Zara"; z(1) = "Nuha"; z(4 / 2) = "Ayan"
    // or
    z1 = Array("Zara", "Nuha", "Ayan")

    var myList = Array(1.9, 2.9, 3.4, 3.5)

    //override def foreach[U](f: A => U): Unit
    // Print all the array elements
    for (x <- myList) {
      println(x)
    }
    // or
    for (i1 <- 0 to myList.length - 1) {
      println("Data   " + myList(i1));
    }

    // Summing all elements
    var total = 0.0;

    for (i <- 0 to (myList.length - 1)) {
      total += myList(i);
    }
    println("Total is " + total);

    // Finding the largest element
    var max = myList(0);

    for (i <- 1 to (myList.length - 1)) {
      if (myList(i) > max) max = myList(i);
    }

    println("Max is " + max);
  }

  def multiDimArrays: Unit = {
    var myMatrix = ofDim[Int](3, 3)

    // build a matrix
    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        myMatrix(i)(j) = j;
      }
    }

    // Print two dimensional array
    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        print(" " + myMatrix(i)(j));
      }
      println();
    }
  }

  def concatArrays: Unit = {
    var myList1 = Array(1.9, 2.9, 3.4, 3.5)
    var myList2 = Array(8.9, 7.9, 0.4, 1.5)

    var myList3 = concat(myList1, myList2)

    // Print all the array elements
    for (x <- myList3) {
      println(x)
    }
  }
  
  def rangeArrays :Unit = {
    var myList1 = range(10, 20, 2)
      var myList2 = range(10,20)

      // Print all the array elements
      for ( x <- myList1 ) {
         print( " " + x )
      }
      
      println()
      for ( x <- myList2 ) {
         print( " " + x )
      }
  }
}