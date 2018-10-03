package attribute;
import Character.Playable;
import java.io.*;
import java.util.*;
public class EXP
{
   public static void gainEXP(final Playable [] characters, final Scanner kb) throws FileNotFoundException
   {
      Playable [] winners = information.gather.areInBattle(information.gather.partyNames(kb),characters);
      Playable [] enemies = information.gather.theRest(winners,characters);
      int Base_EXP = getBaseEXP(kb);
      System.out.println("\n--- EXP Awarded ---\n");
      for(int x = 0; winners.length > x; x++)
      {
         double mod = winners[x].getAttribute("Intelligence") * 0.5;
         mod = mod *3;
         mod = mod * 0.01;
         mod = mod + 1;
         int exp = (int)(Base_EXP * mod);
         System.out.println(winners[x].getName() + " gains " + exp + " expeirence points!");
      }
   }
   public static int getBaseEXP(final Scanner kb)
   {
      System.out.print("Enter the base EXP: ");
      int exp = kb.nextInt(); kb.nextLine();
      return exp;
      
   }
   public static int findEnemyType(int value,String type)
   {
      switch(type)
      {
         case "Raider": value += 100; break;
         case "Raider Spellcaster": value += 175; break;
         case "Raider Berserker": value += 150; break;
         case "Dragon Raiders": value += 450; break;
         case "Raider Lord": value += 500; break;
         case "Raider Heads": value += 750; break;
         case "Raider Master": value += 1500; break;
         case "Sphere": value += 75; break;
         case "Ice Wraith": value += 125; break;
         case "Ice Elemental": value += 150; break;
         case "Frost Troll": value += 150; break;
         case "Bullymong": value += 175; break;
         case "Tautnaun Rider": value += 200; break;
         case "Green Nekron": value += 130; break;
         case "Orange Nekron": value += 190; break;
         case "Purple Nekron": value += 210; break;
         case "Ballista": value += 400; break;
         case "Glaidator": value += 500; break;
         case "PC": value += 1000; break;
         
      }
      return value;
   }
}