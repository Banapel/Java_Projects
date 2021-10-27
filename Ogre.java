/*
* TCSS 143 - Winter 2021
* Instructor: Tom Capual
*
*/

/**
 * Sets the variables from which character will have 
 * 
 * @author Jasper Jung jjung13@uw.edu
 * @version 2/2/21
 */
public class Ogre extends Monster{

    protected Ogre(){
       super(200, 2, 30, 60, .6, .1, 30, 60, "Ogre");       //super which calls the Monster class
      

   }

   /**
    * Special attack for Ogre with club dealing 40 damage
    */
   public void specialAttack(DungeonCharacter hero){
       System.out.println("Ogre special attack!");
       System.out.println("Ogre swings his Club dealing 40 damage!");
       hero.hp -= 40;

       if(hero.hp < 1)      //checks if the hero health is not below 1
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