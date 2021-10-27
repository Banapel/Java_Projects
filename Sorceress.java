  /*
* TCSS 143 - Winter 2021
* Instructor: Tom Capual
*
*/
  import java.util.Random;
   /**
  * Sets the variables from which character will have 
  * 
  * @author Jasper Jung jjung13@uw.edu
  * @version 2/2/21
  */
   public class Sorceress extends Hero{

   

      protected Sorceress(){
         super(75, 5, 25, 45, .7, .3, "Heal");     //super whcih callst the Hero class
    
    
      }


      /**
       * special ability for Sorceress healing for a min of 10 and max of 60
       * 
       */
      protected final void specialAbility(DungeonCharacter monster){
         int minHeal = 10;
         int maxHeal = 60;
         Random MY_RAND = new Random();
    
         int heal = MY_RAND.nextInt(maxHeal - minHeal) + minHeal;
    
         System.out.println("You heal yourself for " + heal + " hp");
         this.hp += heal;
      }





   }