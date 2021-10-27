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

public class Warrior extends Hero{


    protected Warrior(){
       super(125, 4, 35,60,.8, .2, "Crushing Blow" );       //super whichs calls the hero class

   }
  
   /**
    * special ability for Warrior which has a change to deal increased damage
    *
    */
    protected void specialAbility(DungeonCharacter monster){
       Random MY_RAND = new Random();
       double crushingBlowChance = .40;
      
       if(MY_RAND.nextDouble() < crushingBlowChance){
           int damage = MY_RAND.nextInt(100) + 75;
           System.out.println("Crushing blow hit! You deal " + damage + " damage");
           monster.hp -= damage;
          
           if(monster.hp < 1)
               monster.hp = 0;
       } else{
           System.out.println("Crushing blow missed");
       }
      
   }


}