package com.homework.scalatutorial

object DemoStringFormat {
  def main(args: Array[String]) {
      var floatVar = 12.456
      var intVar = 2000
      var stringVar = "Hello, Scala!"
      
      //var fs = printf("The value of the float variable is " + "%f, while the value of the integer " + "variable is %d, and the string" + "is %s", floatVar, intVar, stringVar);
       var fs = printf("The value of the float variable is %f \n while the value of the integer variable is %d \n and the string is %s", floatVar, intVar, stringVar);
      println(fs)
   }
}