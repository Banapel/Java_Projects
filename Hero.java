/*
* TCSS 143 - Winter 2021
* Instructor: Tom Capual
*
*/
import java.util.Scanner;
import java.util.Random;
/**
 * Sets the variables from which character will have 
 * 
 * @author Jasper Jung jjung13@uw.edu
 * @version 2/2/21
 */

   public abstract class Hero extends DungeonCharacter{


      protected double blockChance;
      protected String specialName;



   //Explicit Value constructor
      protected Hero(int hp, int atkSpd, int minDmg, int maxDmg, double hitChance, double blockChance, String specialName){
         super(hp, atkSpd, minDmg, maxDmg, hitChance);   //super which calls from DungeonCharacter 
    
    
         this.name = chooseName();
         this.blockChance = blockChance;
         this.specialName = specialName;
      }

  

      
      /**
       * this method asks the user to input a name for hero
       * 
       * @return the inputted name 
       */
      protected final static String chooseName(){
         Scanner keyboard = new Scanner(System.in);
         System.out.println("What will the name of your Hero be: ");
         String tempName = keyboard.nextLine();
         return tempName;
      }

  
      /**
       * this methods checks if monster can block
       * 
       * @param monster
       */
      protected abstract void specialAbility(DungeonCharacter monster);

       public boolean canBlock(){
           Random MY_RAND = new Random();
          
           if(MY_RAND.nextDouble() > this.blockChance)
               return false;
           else
               return true;
          
       }
  
  
  
  
       
    @Override
      /**
       * this prompts for the user to use an attack or special attack
       * 
       */
      public void attack(DungeonCharacter monster){
         Scanner keyboard = new Scanner(System.in);
         int choice = 0;
         boolean switchBool = false;
    
    
         do{
               System.out.println();
            System.out.println("Choose an attack");
            System.out.println("1) Attack");
            System.out.println("2) " + this.specialName);
            choice = keyboard.nextInt();
               keyboard.nextLine();
       
            switch(choice){
               case 1:
                  super.attackDamage(monster);
                  break;
               case 2:
                  specialAbility(monster);
                  break;
               default:
                  System.out.println( "Not a valid choice");
                  break;
            }
         }while(switchBool);
      }


      
      
       /**
        * super method to call the attackdamage method 

        * @param monster
        */
       public void AttackDamage(DungeonCharacter monster){
           super.attackDamage(monster);
       }
  

      /**
       * asks the user to choose out of three heroes.
       * 
       * @return the input from the user
       */
      public static DungeonCharacter heroChoose(){
         Scanner keyboard = new Scanner(System.in);
       
         do{
          
            System.out.println("Please select your Spaceship:");
            System.out.println("1. Destroyer");
            System.out.println("2. Interceptor ");
            System.out.println("3. Escort");
               
       
            int choice = keyboard.nextInt();
            switch(choice){
               case 1:
                  System.out.println("Destroyer has been selected");  
                  return new Warrior();
               case 2:
                  System.out.println("Interceptor has been selected");
                  return new Thief();
               case 3:
                  System.out.println("Escort has been selected");
                  return new Sorceress();     
                   default:
                  System.out.println("Invalid Option try again");
                  break;
          
            }
         }while(true);
      }

   
   public void heal(){  
   }
   public boolean canHeal(){
       return false;
      }
   }




