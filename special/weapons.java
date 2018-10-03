package special;
import java.util.*;
import Weapon.Weapon;
public class weapons
{
   public static Weapon crossbowInfo(Scanner kb)
   {
      String type = "", affliction = "", element = "";
      int base = 0, crit = 1, rate = 0;
      boolean magical = false, projectile = false;
      Random r = new Random();
      
      System.out.print("Enter the arrow type: ");
      String arrow = kb.nextLine();
      switch(arrow.toLowerCase())
      {
      case "acid arrow":
      {
         type = "Crossbow";
         base = 16;
         element = "Acid";
         affliction = "Acid";
         rate = 200;
         break;
      }
      case "explosive arrow":
         {
            type = "Crossbow";
            base = 26;
            element = "Fire";
            affliction = "Burning";
            rate = 10;
            break;
         }
       case "electric arrow":
         {
            type = "Crossbow";
            element = "Electric";
            base = 20;
            affliction = "Paralyzed";
            rate = 50;
            projectile = true;
            break;
         }
      case "regular arrow":
         {
            type = "Crossbow";
            base = 25;
            projectile = true;
            break;
         }
      case "ricochet arrow":
      {
         type = "Crossbow";
         base = 15 + (r.nextInt(5)+1 *5);
         projectile = true;
         break;
      }
         case "slag arrow":
         {
            type = "Crossbow";
            base = 20;
            affliction = "Slag";
            element = "Slag";
            rate = 200;
            projectile = true;
            break;
         }
         case "poison arrow":
         {
            type = "Crossbow";
            element = "Poison";
            base  = 15;
            affliction = "Poisoned";
            rate = 200;
            projectile = true;
            break;
         }
         }
      return new Weapon(arrow,type,base,crit,element,affliction,rate,projectile,magical);
   }
   public static Weapon blowgunInfo(final Scanner kb)
   {
      String type = "", affliction = "", element = "";
      int base = 0, crit = 1, rate = 0;
      boolean magical = false, projectile = false;
      
      System.out.print("Enter the dart type: ");
      String dart = kb.nextLine();
      switch(dart.toLowerCase())
      {
         case "acid dart":
         {
            type = "Blowgun";
            base = 15;
            element = "Acid";
            affliction = element;
            rate = 200;
            projectile = true;
            break;
         }
      case "frost dart":
         {
            type = "Blowgun";
            element = "Ice";
            base = 16;
            affliction = "Frozen";
            rate = 50;
            projectile = true;
            break;
         }   
      case "regular dart":
         {
            type = "Blowgun";
            base = 15;
            projectile = true;
            break;
         }
         case "poison dart":
         {
            type = "Blowgun";
            base = 13;
            element = "Poison";
            affliction = "Poisoned";
            rate = 200;
            projectile = true;
            break;
         }
      }
      return new Weapon(dart,type,base,crit,element,affliction,rate,projectile,magical);
   }
   public static String wandOfOakEffects(final Random r)
   {
      String [] effects = {"Firework","Thunder","Water Gun","Blizzard"};
      return effects[r.nextInt(effects.length)];
   }
   public static String wandOfOakElement(final String effect)
   {
      switch(effect)
      {
         case "Firework": return "Fire";
         case "Thunder": return "Electricity";
         case "Water Gun": return "Water";
         case "Blizzard": return "Ice";
      }
      return "";
   }
   public static String wandOfOakAffliction(final String element)
   {
      switch(element){
      case "Fire": return "Burning";
      case "Electricity": return "Paralyzed";
      case "Ice": return "Frozen";
      }
      return "";
   }
   public static Weapon magicHarnesser(final Scanner kb)
   {
      String answer;
      do
      {
         System.out.print("Is the attack a blast? (Y/N): ");
         answer = kb.nextLine();
         answer = answer.substring(0,1).toLowerCase().trim();
      }while(answer.equals("y") || answer.equals("n"));
      boolean blast = answer.equals("y"), magical = true, projectile = false;
      String type = "Gauntlet", affliction = "",name = "magic harnesser gauntlet", element = "";
      int base = 0, rate = 0, crit = 200;
      if(blast == true)
      {
         base = 30;
         crit = 8;
         projectile = true;
      }
      else
      {
         base = 21;
         crit = 4;
         magical = false;
      }
      return new Weapon(name,type,base,crit,element,affliction,rate,projectile,magical);
   }
   public static String automailClawsElement(final Scanner kb)
   {
      int choice = 0;
      while(choice >= 5 || choice <= 0)
      {  
         System.out.println("1. Poison\n2. Fire\n3. Curse\n4. Ice");
         System.out.print("Enter your choice: ");
         choice = kb.nextInt(); kb.nextLine();
      }
      switch(choice)
      {
         case 1: return "Poison";
         case 2: return "Fire";
         case 3: return "Curse";
         case 4: return "Ice";
      }
      return "";
   }
   public static String automailClawsAffliction(String element)
   {
      switch(element)
      {
         case "Poison": return "OG Poisoned";
         case "Fire": return "Burning";
         case "Curse": return "Cursed";
         case "Ice": return "Frozen";
      }
      return "";
   }
   public static String toyCrossbowAffliction(Random r)
   {
      String [] afflictions = {"Acid","Burning","Cursed","Poisoned","Paralyzed","Possessed","Frozen","Drain","Intoxciated","Stasis","Slag"};
      int choice = r.nextInt(afflictions.length);
      return afflictions[choice];
   }
   public static int hammerOfDusk(Scanner kb)
   {
      System.out.print("How many orbs are fired: ");
      int orbs = kb.nextInt(); kb.nextLine();
      int base = 30 * (int)(1 + (orbs * 0.5));
      return base;
   }
   public static int hammerOfDuskCrit(int base){return base/20;}//It is divided by 20 so 1 orb with have a crit of 1 (since it's base is 30) and 8 will have a crit of 7. and 
}