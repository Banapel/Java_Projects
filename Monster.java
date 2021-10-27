  /*
* TCSS 143 - Winter 2021
* Instructor: Tom Capual
*
*/
  import java.util.Random;
  /**
 * Sets the variables from which Monster will have 
 * 
 * @author Jasper Jung jjung13@uw.edu
 * @version 2/2/21
 */


   public abstract class Monster extends DungeonCharacter{


      protected double healChance;
      protected int minHealHP;
      protected int maxHealHP;
      protected double specialAttackChance = .15;

      
      protected Monster(int hp, int atkSpd,int minDmg, int maxDmg, double hitChance,    //constructor for Monster
         double healChance, int minHealHP, int maxHealHP, String name){
         super(hp,atkSpd,minDmg,maxDmg,hitChance);    //super which inherits from DungeonCharacter
    
         this.healChance = healChance;
         this.minHealHP = minHealHP;
         this.maxHealHP = maxHealHP;
         this.name = name;
      }


      /**
       * checks if the monster can heal
       * 
       */
      public boolean canHeal(){
         Random MY_RAND = new Random();
         if( MY_RAND.nextDouble() > this.healChance)
            return false;
         else
            return true;
        
      }
   
   
   
      /**
       * method for the monster to heal
       * 
       */
      public void heal(){
         Random MY_RAND = new Random();
         int heal = MY_RAND.nextInt(maxHealHP - minHealHP) + minHealHP;
         this.hp += heal;
         System.out.println( this.name + " healed for " + heal + " hp.");
      }

  
    /**
     * method that checks the special attack for hero
     * @param hero
     */
    protected abstract void specialAttack(DungeonCharacter hero);
  
      public void attack(DungeonCharacter hero){
         Random MY_RAND = new Random();
       
                  
         if( MY_RAND.nextDouble() > specialAttackChance){
             super.attackDamage(hero);
         }
         else{
             specialAttack(hero);
         }
      }



      /**
       * method that creates a new monster
       * 
       * @return a randomly picked monster
       */
      protected static Monster generateMonster(){
    
         Random MY_RAND = new Random();
    
         while(true){
            switch(MY_RAND.nextInt(3) + 1){
               case 1:
                  System.out.println("Gremlin has appeared!");
                  return new Gremlin();
               case 2:
                  System.out.println("Skeleton has appeared!");
                  return new Skeleton();
               case 3:
                  System.out.println("Ogre has appeared!");
                  return new Ogre();
            }
         }
      }



   }