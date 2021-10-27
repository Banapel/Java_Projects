/*
* TCSS 143 - Winter 2021
* Instructor: Tom Capual
* Assignment 2
*
*/
import java.util.Scanner;
/**
 * Tester method for DungeonCharacter and the related classes
 * 
 * @author Jasper Jung jjung13@uw.edu
 * @version 2/2/21
 */
public class battleTester{

   public static void main(String[] args){
      DungeonCharacter monster;
      DungeonCharacter hero;
    
     
      System.out.println("Battle Begins between Heroes and Monsters");
     
      while(true){ //uses hero choose and generates a monster to fight
     
         hero = Hero.heroChoose();
         monster = Monster.generateMonster();
    
    
         System.out.println();
         System.out.println();
         System.out.println(hero.name + " goes first");
    
    
      
      
         while(true){      //checks the number of attacks 
         
        
            int numAttacks = hero.getNumberAtks(monster);
          
            while(numAttacks > 0){
               int tempMobHP = monster.getHP();
          
          
            
               System.out.println();
               System.out.println("Number of attacks left: " + numAttacks);
          
            
               hero.attack(monster);
              
               if(!monster.isAlive()){
                  break;
               }
            
               numAttacks--;
          
          
            
               if(tempMobHP > monster.getHP() && monster.hp != 0){
                  if(monster.canHeal()){
                     monster.heal();
                  }
             
               }
          
               if(numAttacks > 0)
                  DungeonCharacter.healthUpdate(hero,monster);
          
            }
           
           
         
            if(hero.canBlock()){    // tests if the hero blocks
               System.out.println(hero.name + " blocked " + monster.name +"'s attack!");
            }
            else{
            
               if(monster.getHP() > 0){      //if monster hp is above zero attack hero
                  monster.attack(hero);
               }
            }      
       
         
            DungeonCharacter.healthUpdate(hero, monster); //checks on hero and monster health
           
            if(!hero.isAlive() || !monster.isAlive())
               break;
           
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Continue game? (y/n)"); // if both are still alive ask if want to continue
            String quit = keyboard.nextLine();
            if(quit.equals("n")){
               break;
            }
         }
      
         
         if(monster.isAlive())      //checks if either monster or hero is dead and states the winner
            System.out.println( monster.name + " has defeated "+hero.name);
       
         else if(hero.isAlive())
            System.out.println( hero.name + " has deafeated "+monster.name);
       
        
        
        
         
        
         Scanner keyboard = new Scanner(System.in);
         String answer;
         while(true){      //check whether player wants to continue playing at the end. 
            System.out.println("Continue Playing? (y/n)");
            answer = keyboard.nextLine();
            if( answer.equals("y") || answer.equals("n")){
               break;
            }
            System.out.println("That choice is not valid, try again");
         }
         if(answer.equals("n")){
            System.out.println("Battle has Ended!");
            break;
         }
      }  
   
 
   }


}
