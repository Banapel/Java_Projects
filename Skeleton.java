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
public class Skeleton extends Monster{

    protected Skeleton(){
       super(100, 3, 30, 50, .8, .3, 30, 50, "Skeleton");       //super which calls the monster class
  

   }

   /**
    * special attack for skeleton which deals 45 hp
    *
    */
   public void specialAttack(DungeonCharacter hero){
     
       System.out.println("Skeleton special attack!");
       System.out.println("Skeleton shoots a volley of Arrows at you!");
       System.out.println("Arrow volley deals 45 HP!!");
       hero.hp -= 45;
      

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