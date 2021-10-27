/*
* TCSS 143 - Winter 2021
* Instructor: Tom Capual
* Assignment 2
*
*/
import java.util.Random;
/**
 * Sets the variables from which character will have 
 * 
 * @author Jasper Jung jjung13@uw.edu
 * @version 2/2/21
 */
   /**
    * abstract class which all DungeonCharacter will have
    *
    */
   public  abstract class DungeonCharacter{

      protected String name;
      protected int hp;
      protected int atkSpd;
      protected int minDamage;
      protected int maxDamage;
      protected double hitChance;




   
      protected DungeonCharacter(){     //Default constructor for DungeonCharacter
         name = "Name";
         hp = 1;
         atkSpd = 1;
         minDamage = 13;
         maxDamage = 25;
         hitChance = 0.70;
      }

   
      protected DungeonCharacter(int hp, int atkSpd,int minDmg, int maxDmg, double hitChance){      //explicit value constructor for DungeonCharacter
         this.name = "Name";
         this.hp = hp;
         this.atkSpd = atkSpd;
         this.minDamage = minDmg;
         this.maxDamage = maxDmg;
         this.hitChance = hitChance;
          

      }


    /**
     * this method gets the number of attacks for monster
     * 
     * @param monster
     * @return the number of attacks monster can run
     */
    protected int getNumberAtks(DungeonCharacter monster){
           int temp = this.atkSpd / monster.atkSpd;
          
           if(temp == 0)
               return 1;
           else
               return temp;
       }

      /**
       * 
       * @param character
       */
      protected abstract void attack(DungeonCharacter character);
      
       public abstract boolean canBlock();
       public abstract boolean canHeal();
       public abstract void heal();
      
       /**
        * Methodto return hp

        * @return the amount of health points
        */
       public int getHP(){
           return this.hp;
       }



  
       /**
        * method for characters to deal damage
        *
        */
      protected final void attackDamage(DungeonCharacter character){
         Random MY_RAND = new Random();
         int damage = (MY_RAND.nextDouble() < hitChance ? MY_RAND.nextInt(maxDamage - minDamage) + minDamage : 0);
         if( damage > 0){
            System.out.println(this.name + " deals " + damage + " damage to " + character.name);
            character.hp -= damage;
         
               
               if(character.hp < 1){      //checks if character health is not below 0
               character.hp = 0;
            }
         }
         else{
            System.out.println(this.name + "'s attack missed.");
         }
      }



      /**
       * checks and prints out the health of monster and hero
       * 
       * @param hero
       * @param monster
       */
      protected final static void healthUpdate(DungeonCharacter hero, DungeonCharacter monster){
        System.out.println();
        System.out.println("Current Health Update");     
        System.out.println( hero.name + "'s health: " + hero.hp + "hp");
        System.out.println( monster.name + "'s health: " + monster.hp + "hp");
        System.out.println();
      }



      /**
       * boolean method to check if alive
       * 
       * @return true or false if hp is less than 0
       */
      protected boolean isAlive(){
         if(this.hp > 0)
            return true;
         else
            return false;
      }



   }
