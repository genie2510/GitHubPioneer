package com.homework.scalatutorial

class ParentPoint(val xc :Int, val yc :Int) {
   var x :Int = xc
   var y :Int = yc
   
   def move(dx :Int, dy :Int) {
      x = x + dx +100;
      y = y + dy +100;
      println ("ParentPoint x location : " + x);
      println ("ParentPoint y location : " + y);
   }
   
   def justPrint(){
     println("Printed  --->>  "+xc+"  "+yc);
   }
}

class Location(override val xc :Int, override val yc :Int, val zc :Int) extends ParentPoint(xc, yc){
   var z :Int = zc

   def move(dx :Int, dy :Int, dz :Int) {
      x = x + dx
      y = y + dy
      z = z + dz
      println ("Point x location : " + x);
      println ("Point y location : " + y);
      println ("Point z location : " + z);
   }
}

object InheritanceDemo {
   def main(args: Array[String]) {
     
      // Initializes parent class variables also
      val loc = new Location(10, 20, 15);

      // Move to a new location
      loc.move(10, 10, 5);
      loc.move(10, 10);
      loc.justPrint();
   }
}