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
public class Thief extends Hero{


    protected Thief(){
       super(75, 6, 20, 40, .8, .4, "Surprise Attack");     //super which calls the Hero Class
      

   }
  
  
   /**
    * Special ability for Thief which grants an extra attack
    *
    */
   public void specialAbility(DungeonCharacter monster){
       double surpriseChance = .4;
       double normalAttackChance = .8;
       Random MY_RAND = new Random();
      
      
       double result = MY_RAND.nextDouble();
       if(result < surpriseChance){

           System.out.println("Extra attack was gained");
           super.attackDamage(monster);
           super.attackDamage(monster);
       }
       else if( result < normalAttackChance){
           super.attackDamage(monster);
       }
       else{
           System.out.println("Surprise Attack missed");
       }
      
   }

}