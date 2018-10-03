package attack;
import java.util.*;
import java.io.*;
import Weapon.Weapon;
import Weapon.weaponList;
import Character.Playable;
public class limit
{
   public static Playable [] limitList(Playable [] characters, Playable attacker, final String ability,final Scanner kb) throws FileNotFoundException
   {
      System.out.println("\n--- Result ---");
      switch(ability)
      {
         //Willie
         case "Light Star": characters = lightStar(characters,attacker); break;
         case "Dark Star": characters = darkStar(characters,attacker); break;
         //Oguma
         case "Mire": characters = mire(characters,attacker,kb); break;
         case "Desolate Cold": characters = desolateCold(characters,attacker,kb); break;
         //Mordecai
         case "Tempest Roar": characters = tempestRoar(characters, attacker); break;
         case "Fissure": characters = fissure(characters,attacker,kb); break;
         //Adric
         case "Mega Leech": characters = megaLeech(characters, attacker, kb); break;
         //Agon
         case "Acid Tsunami": characters = acidTsunami(characters,attacker,kb);break;
         //Soren
         case "Electric Drive": characters = electricDrive(characters,attacker); break;
         //Bruce
         case "Death Mountain": characters = deathMountain(characters,attacker,kb); break;
         case "The Reaper": characters = theReaper(characters,attacker,kb); break;
         //Miscellaneous
         case "Zatetsuken": characters = zatetsuken(characters,attacker,kb); break;
         case "Mark of Death": characters = markOfDeath(characters,attacker,kb);break;
         case "Skull Fracturing Nightmare": characters = skullFracturingNightmare(characters,attacker,kb);break;
      }
      return characters;
   }
   public static Playable [] lightStar(Playable [] characters, Playable attacker) throws FileNotFoundException
   {
      Random r = new Random();
      Playable [] targets = information.gather.areInBattle(information.gather.partyNames(new Scanner(System.in)),characters);
      int roll = r.nextInt(12)+1, MGC = attacker.getAttribute("Magic"), LMT = attacker.getAttribute("Limit"), BASE = 45;
      for(int x = 0; x < targets.length; x++)
      {
         int RES = targets[x].getAttribute("Resistance");
         int DMG = roll + MGC + LMT - RES;
         int elementResistance = targets[x].getElementalResistance("Fire"), DMGRES = 0;
         if(elementResistance != 0)
            DMGRES = (int)(DMG * (elementResistance * 0.01));
         DMG = DMG - DMGRES;
         //Affliction Check for blind, burn is instantly afflicted
         targets[x].applyAffliction(targets[x],"Burning",false);
         System.out.println(targets[x].getName() + " is afflicted with Burning");
         int Constitution = targets[x].getAttribute("Constitution"), rate = 50;
         roll = r.nextInt(99)+1;
         int mimimum = 100 - rate, total = roll - Constitution;
         if(total >= mimimum || rate >= 100)//This should negate bosses that have +100 Constitution with effects that are 100% guaranteed to happen
         {
            targets[x].applyAffliction(targets[x],"Blind",false);
            System.out.println(targets[x].getName() + " is afflicted with Blind");
         }
         System.out.println(targets[x].getName() + " takes " + DMG + " damage!");
      }
      return characters;
   }
   public static Playable [] mire(Playable [] characters, Playable attacker,final Scanner kb) throws FileNotFoundException
   {
      Playable [] targets = information.gather.areInBattle(information.gather.partyNames(kb),characters);
      for(int x = 0; x < targets.length; x++)
      {
         String targetName = targets[x].getName();
         for(int y = 0; y < characters.length; y++)
         {
            String characterName = characters[y].getName();
            if(targetName.equals(characterName))
            {
               characters[y].changeBonus("Speed",-5,false);
               characters[y] = characters[y].applyAffliction(characters[y],"OG Poisoned",false);
               characters[y] = characters[y].applyAffliction(characters[y],"OG Poisoned",false);
               characters[y] = characters[y].applyAffliction(characters[y],"Mire",false);
               System.out.println(characters[y].getName() + " is afflicted with Mire and Poison x2!");
            }//end of if Statement
         }//end of for loop
         
      }//end of other for loop
      return characters;
   }
   public static Playable[] desolateCold(Playable [] characters, Playable attacker,final Scanner kb) throws FileNotFoundException
   {
      Playable [] targets = information.gather.areInBattle(information.gather.partyNames(kb),characters);
      for(int x = 0; x < targets.length; x++)
      {
         String targetName = targets[x].getName();
         for(int y = 0; y < characters.length; y++)
         {
            String characterName = characters[y].getName();
            if(targetName.equals(characterName))
            {
               characters[y].changeBonus("Speed",-10,false);
               System.out.println(characters[y].getName() + " will now deal frozen damage on their turn and their speed has decreased by 10!");
            }
         }
      }
      return characters;
   }      
   public static Playable[] acidTsunami(Playable [] characters, Playable attacker,final Scanner kb) throws FileNotFoundException
   {
      Playable [] targets = information.gather.areInBattle(information.gather.partyNames(kb),characters);
      for(int x = 0; x < targets.length; x++)
      {
         String targetName = targets[x].getName();
         for(int y = 0; y < characters.length; y++)
         {
            String characterName = characters[y].getName();
            if(targetName.equals(characterName))
            {
               int DMG = 50 + attacker.getAttribute("Magic") + attacker.getAttribute("Limit") - characters[x].getAttribute("Resistance");
               characters[y].takeDamage(DMG);
               characters[y] = characters[y].applyAffliction(characters[y],"Acid",false);
               characters[y] = characters[y].applyAffliction(characters[y],"Acid",false);
               System.out.println(characters[y].getName() + " takes " + DMG + " damage and is afflicted with Acid x2!");
            }
         }
      }
      return characters;
   }
   public static Playable [] markOfDeath(Playable [] characters, Playable attacker, final Scanner kb) throws FileNotFoundException
   {
      Playable [] targets = information.gather.areInBattle(information.gather.partyNames(kb),characters);
      for(int x = 0; x < targets.length; x++)
      {
         String targetName = targets[x].getName();
         for(int y = 0; y < characters.length; y++)
         {
            String characterName = characters[y].getName();
            if(targetName.equals(characterName))
            {
               System.out.println(targetName + " has 10 turns left before death.");
            }
         }
      }
      return characters;
   }
   public static Playable [] skullFracturingNightmare(Playable [] characters, Playable attacker, final Scanner kb) throws FileNotFoundException
   {
      Random r = new Random();
      Playable [] targets = information.gather.areInBattle(information.gather.partyNames(kb),characters);
      int STR = attacker.getAttribute("Strength"), BASE = (r.nextInt(5)+20)*5, LMT = attacker.getAttribute("Limit");
      for(int x = 0; x < targets.length; x++)
      {
         String targetName = targets[x].getName();
         for(int y = 0; y < characters.length; y++)
         {
            String characterName = characters[y].getName();
            if(targetName.equals(characterName))
            {
               int DMG = STR + BASE - characters[y].getAttribute("Defense");
               System.out.println(characters[y].getName() + " takes " + DMG + " damage!");
            }
         }
      }
      return characters;
   }
   public static Playable [] deathMountain(Playable [] characters, Playable attacker, final Scanner kb) throws FileNotFoundException
   {
      Playable [] targets = information.gather.areInBattle(information.gather.partyNames(kb),characters);
      int DMG = 100 + attacker.getAttribute("Magic") + attacker.getAttribute("Limit");
      for(int x = 0; x < targets.length; x++)
      {
         String targetName = targets[x].getName();
         for(int y = 0; y < characters.length; y++)
         {
            String characterName = characters[y].getName();
            if(targetName.equals(characterName))
            {
               System.out.println(targetName + " takes " + (DMG - characters[y].getAttribute("Resistance")) + " damage!");
            }
         }
      }
      return characters;
   }
   public static Playable [] theReaper(Playable [] characters, Playable attacker, final Scanner kb) throws FileNotFoundException
   {
      Playable [] targets = information.gather.areInBattle(information.gather.partyNames(kb),characters);
      int DMG = 100 + attacker.getAttribute("Magic") + attacker.getAttribute("Limit");
      for(int x = 0; x < targets.length; x++)
      {
         String targetName = targets[x].getName();
         for(int y = 0; y < characters.length; y++)
         {
            String characterName = characters[y].getName();
            if(targetName.equals(characterName))
            {
               System.out.println(targetName + " is afflicted with Drain");
               characters[y].applyAffliction(characters[y],"Drain",false);
            }
         }
      }
      return characters;
   }
   public static Playable [] darkStar(Playable [] characters, Playable attacker) throws FileNotFoundException
   {
      Random r = new Random();
      Playable [] targets = information.gather.areInBattle(information.gather.partyNames(new Scanner(System.in)),characters);
      int roll = r.nextInt(12)+1, MGC = attacker.getAttribute("Magic"), LMT = attacker.getAttribute("Limit"), BASE = 45;
      for(int x = 0; x < targets.length; x++)
      {
         int RES = targets[x].getAttribute("Resistance");
         int DMG = roll + MGC + LMT - RES;
         int elementResistance = targets[x].getElementalResistance("Curse"), DMGRES = 0;
         if(elementResistance != 0)
            DMGRES = (int)(DMG * (elementResistance * 0.01));
         DMG = DMG - DMGRES;
      }
      return characters;
   }
   public static Playable [] tempestRoar(Playable [] characters, Playable attacker) throws FileNotFoundException
   {
      Random r = new Random();
      int Force = attacker.getAttribute("Force"), Limit = attacker.getAttribute("Limit"), DiceRoll = r.nextInt(20)+1, Base = 50;
      Playable [] targets = information.gather.areInBattle(information.gather.partyNames(new Scanner(System.in)),characters);
      for(int x = 0; x < targets.length; x++)
      {
         String targetName = targets[x].getName();
         for(int y = 0; y < characters.length; y++)
         {
            String characterName = characters[y].getName();
            if(targetName.equals(characterName))
            {  
               int Resistance = characters[y].getAttribute("Resistance");
               int DMG = Force + Limit + DiceRoll + Base - Resistance;
               characters[y].applyAffliction(characters[y],"Paralyzed",false);
               System.out.println(characters[y].getName() + " takes " + DMG + " damage and is paralyzed!");
            }
         }
      }
      return characters;      
   }
   public static Playable [] fissure(Playable [] characters, final Playable attacker, final Scanner kb) throws FileNotFoundException
   {
      Random r = new Random();
      int Force = attacker.getAttribute("Force"), Limit = attacker.getAttribute("Limit"), DiceRoll = r.nextInt(20)+1, Base = 75;
      Playable [] targets = information.gather.areInBattle(information.gather.partyNames(new Scanner(System.in)),characters);
      for(int x = 0; x < targets.length; x++)
      {
         String targetName = targets[x].getName();
         for(int y = 0; y < characters.length; y++)
         {
            String characterName = characters[y].getName();
            if(targetName.equals(characterName))
            {
               int Resistance = characters[y].getAttribute("Resistance");
               int DMG = Base + DiceRoll + Limit + Force - Resistance;
               characters[y].applyAffliction(characters[y],"Bound",false);
               System.out.println(characters[y].getName() + " takes " + DMG + " damage and is afflicted with Bound!");
            }
         }
      }
      return characters;
   }
   public static Playable [] zatetsuken(Playable [] characters, final Playable attacker, final Scanner kb) throws FileNotFoundException
   {
      //Zatetsuken deals 150% weapon damage + limit + d20 - Defense
      Random r = new Random();
      System.out.print("Enter your weapon for " + attacker + ": ");
      Weapon wpn = weaponList.checkWeapon(kb.nextLine());
      int Base = (int)(wpn.getBase() * 1.5), Strength = attacker.getAttribute("Strength"), Limit = attacker.getAttribute("Limit"), diceRoll = r.nextInt(20)+1;
      Playable [] targets = information.gather.areInBattle(information.gather.partyNames(new Scanner(System.in)),characters);
      for(int x = 0; x < targets.length; x++)
      {
         String targetName = targets[x].getName();
         for(int y = 0; y < characters.length; y++)
         {
            String characterName = characters[x].getName();
            if(targetName.equals(characterName))
            {
               int Defense = characters[x].getAttribute("Defense");
               int DMG = Strength + Limit + Base + diceRoll - Defense;
               System.out.println(characters[x].getName() + " takes " + DMG + " damage!");
            }
         }
      }
      return characters;
   }
   public static Playable [] megaLeech(Playable [] characters, final Playable attacker, final Scanner kb) throws FileNotFoundException
   {
      Random r = new Random();
      int Force = attacker.getAttribute("Force"), Limit = attacker.getAttribute("Limit"), DiceRoll = r.nextInt(20)+1, Base = 50;
      Playable [] targets = information.gather.areInBattle(information.gather.partyNames(new Scanner(System.in)),characters);
      for(int x = 0; x < targets.length; x++)
      {
         String targetName = targets[x].getName();
         for(int y = 0; y < characters.length; y++)
         {
            String characterName = characters[y].getName();
            if(targetName.equals(characterName))
            {
               characters[y].applyAffliction(characters[y],"Drain",false);
               characters[y].applyAffliction(characters[y],"Drain",false);
               characters[y].applyAffliction(characters[y],"Drain",false);
               characters[y].applyAffliction(characters[y],"Panicking",false);
               System.out.println(characters[y].getName() + " is attacked by a mega leech!");
            }
         }
      }
      return characters;
   }
   public static Playable [] electricDrive(final Playable [] characters, final Playable attacker)
   {
      for(int x = 0; x < characters.length; x++)
      {
         String characterName = characters[x].getName();
         if(characterName.equals("Soren"))
         {
            characters[x].changeBonus("Strength",10,false);
            characters[x].changeBonus("Speed",10,false);
            characters[x].changeBonus("Magic",10,false);
            System.out.println(characters[x].getName() + "'s Strength, Speed, and Magic has increased by 10!");
         }
      }
      return characters;
   }
}