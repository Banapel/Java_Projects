/*
* TCSS 143 - Winter 2021
* Instructor: Tom Capual
* Assignment 2
*
*/

/**
 * Sets the variables from which character will have 
 * 
 * @author Jasper Jung jjung13@uw.edu
 * @version 2/2/21
 */
public class Gremlin extends Monster{
    protected Gremlin(){
       super(70,5,15,30,.8, .4, 20, 40,"Gremlin");      //super which inherits from Monster
      

   }
  
   /**
    * special attack which deals 15 damage to the hero
    *
    */
   public void specialAttack(DungeonCharacter hero){
      
       System.out.println("Gremlin special attack!");
       System.out.println("Gremlin spits at the hero dealing 15 damage!");
       this.hp -= 15;
       
       if(hero.hp < 1)      //checks hero hp is not below 1
       hero.hp = 0;

   }
  
  

   /**
    * allows the monster to block
    *
    *@return returns true that the monster can block
    */
   public boolean canBlock(){
       return true;
    }
}