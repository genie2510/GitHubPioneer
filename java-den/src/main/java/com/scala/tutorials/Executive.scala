package com.homework.scalatutorial

package society {
   package professional {
      class Executive {
         private[professional] var workDetails = null//"data"
         private[society] var friends = null
         private[this] var secrets = null

         def help(another :Executive) {
            println(another.workDetails)
            //println(another.secrets) //ERROR
         }
      }
      
      class ProfessionalScope{
       // (new Executive).workDetails
        var nwd = new Executive();
       println(nwd.workDetails)
        println(nwd.friends)
      }
   }
}


object DemoScopeProtection {
   def main(args: Array[String]) {
      val pt = new society.professional.Executive();
      pt.help(pt);
      
      (new society.professional.ProfessionalScope)
   }
}