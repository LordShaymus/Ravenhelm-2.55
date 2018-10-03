package enemy;
import java.io.*;
import java.util.*;
public class enemyCreator
{
   //Enemy Creator is outside of the program that creates enemies for the RP.
   public static void main(String [] args)
   {
      Scanner kb = new Scanner(System.in);
      Random r = new Random();
      int choice = -1
      while(choice != 0)
      {
         System.out.println("1. Raider Grunt\n2. Raider Spellcaster \n3. Raider Berserker \n4. Raider Guards\n0. Quit");
         System.out.print("Enter your choice: ");
         choice = kb.nextInt(); kb.nextLine();
         switch(choice)
         {
            case 1: raiderGrunt(r,kb);
         }
      }
   }
   public static void raiderGrunt(Random r, Scanner kb)
   {
      String archetype = "Grunt Raider";
      int HP = 200, STR = 15, DEF = 13, MGC = 0, RES = 13, CON = 13, SPD = 10, SKL = 15, LMT = 10, INT = 5, INS = 10, LCK = 10;
      int Fire = 0, Water = 0, Earth = 0, Wind = 0, Electricity = 0, Ice = 0, Holy = 0, Curse = 0, Poison = 0, Acid = 0, Slag = 0, Other = 0;
      //Below are additional Attribute Points that are added to "Randomize" the enemy
      STR += r.nextInt(7)+1, DEF = r.nextInt(10)+1;
      
   }
}
/*
int HP, STR, DEF, MGC, RES, CON, SPD, SKL, LMT, INT, INS, LCK;
      int Fire, Water, Earth, Wind, Electricity, Ice, Holy, Curse, Poison, Acid, Slag, Other;
*/