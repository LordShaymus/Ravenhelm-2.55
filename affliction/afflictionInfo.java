package affliction;
import java.io.*;
import java.util.*;
import Character.Playable;
import Character.Affliction;
import Character.Resistance;
import Character.files;
public class afflictionInfo
{
   public static Playable applyAffliction(final Playable character,final String affliction,boolean remove)
   {
      Random r = new Random();
      int STR = character.getAttribute("Strength"), DEF = character.getAttribute("Defense"),MGC = character.getAttribute("Magic"),RES = character.getAttribute("Resistance"),CON = character.getAttribute("Constitution");
      int SPD = character.getAttribute("Speed"), SKL = character.getAttribute("Skill"), LMT = character.getAttribute("Limit"), INT = character.getAttribute("Intelligence"), INS = character.getAttribute("Instinct"), LCK = character.getAttribute("Luck");
      switch(affliction)
      {
         case "Acid": character.applyBooleanAffliction("Acid",remove);
                      break;
         case "Blind": character.applyBooleanAffliction("Blind",remove);
                       break;
         case "Bound": character.applyBooleanAffliction("Bound",remove);
                       break;       
         case "Burning": character.changeBonus("Strength", (int)(STR * -0.25), remove);
                         character.changeBonus("Skill", (int)(SKL * -0.25), remove);
                         character.applyBooleanAffliction("Burning",remove);
                         break;
         case "Cursed": character.applyBooleanAffliction("Cursed",remove);
                        break;
                        
         case "Dead Magic": character.changeBonus("Magic",character.getAttribute("Magic") * (-1),remove);
                            character.applyBooleanAffliction("Dead Magic",remove);
                            break;
         case "Doomed":  character.applyBooleanAffliction("Doomed",remove);
                         break;
         case "Drain":   character.applyIntAffliction("Drain",remove);
                         break;
         case "Enraged": character.applyBooleanAffliction("Enraged",remove);
                         break;
         case "Exhaustion": character.changeBonus("Strength",(int)(character.getAttribute("Strength") * -0.15),remove);
                            character.changeBonus("Defense",(int)(character.getAttribute("Defense") * -0.15),remove); 
                            character.changeBonus("Magic",(int)(character.getAttribute("Magic") * -0.15),remove);
                            character.changeBonus("Resistance",(int)(character.getAttribute("Resistance") * -0.15),remove);
                            character.changeBonus("Constitution",(int)(character.getAttribute("Constitution") * -0.15),remove);
                            character.changeBonus("Speed",(int)(character.getAttribute("Speed") * -0.15),remove);
                            character.changeBonus("Skill",(int)(character.getAttribute("Skill") * -0.15),remove);
                            character.changeBonus("Limit",(int)(character.getAttribute("Limit") * -0.15),remove);
                           character.changeBonus("Intelligence",(int)(character.getAttribute("Intelligence") * -0.15),remove);
                            character.changeBonus("Instinct",(int)(character.getAttribute("Instinct") * -0.15),remove);
                            character.changeBonus("Luck",(int)(character.getAttribute("Luck") * -0.15),remove);
                            character.applyIntAffliction("Exhaustion",remove);
                            break;                       
         case "Frozen":character.applyBooleanAffliction("Frozen",remove); break;
         case "Intoxicated":character.changeBonus("Bonus",-7,remove);
                            character.applyBooleanAffliction("Intoxicated",remove);
                            break;
         case "Panicking": character.applyBooleanAffliction("Panicking",remove);
                            break;
         case "Paralyzed": character.applyBooleanAffliction("Paralyzed",remove);
                           break;
         case "OG Poisoned": character.applyIntAffliction("OG Poisoned",remove);
                             break;
         case "Poisoned": character.applyIntAffliction("Poisoned",remove);
                          break;
         case "Possessed": character.applyBooleanAffliction("Possessed",remove);
                           break;
         case "Slag": character.applyIntAffliction("Slag",remove);
                      break;     
        case "Slow": character.changeBonus("Speed",(int)(SPD * -0.5),remove);
                     character.applyIntAffliction("Slow",remove);
                      break;
        case "Stasis": character.applyBooleanAffliction("Stasis",remove);
                       break;
        case "Time Freeze": character.changeBonus("Speed",character.getAttribute("Speed") * (-1),remove);
                            character.applyBooleanAffliction("Time Freeze",remove);
                            break;
        case "Blessed": character.applyIntAffliction("Blessed",remove);
                        break;
        case "Haste": character.changeBonus("Speed",10,remove);
                      character.applyIntAffliction("Haste",remove);
                      break;
        case "Inspired": character.changeBonus("Bonus",3,remove);
                         character.applyBooleanAffliction("Inspired",remove);
                         break;
        case "Leech": character.changeBonus("Constitution",5,remove);
                      character.applyIntAffliction("Leech",remove);
                      break;
        case "Protect": character.applyBooleanAffliction("Protect",remove);
                        break;
         case "Barrier": character.applyBooleanAffliction("Barrier",remove); break;
        
        case "Relaxed": character.changeBonus("Bonus",2,remove);
                        character.applyIntAffliction("Relaxed",remove);
                        break;
        case "Weakened": character.changeBonus("Defense",(int)(DEF * -0.5),remove); character.changeBonus("Resistance",(int)(RES * -0.5),remove); character.changeBonus("Constitution",(int)(CON * -0.5),remove);
                         character.applyBooleanAffliction("Weakened",remove);
                         break;
        //Special Conditions
        case "Pain Suppress": character.changeBonus("Defense",5,remove);
                              break;
        
        case "Mire": character.applyBooleanAffliction("Mire",remove);
                     break;
        case "Flurry": character.changeBonus("Speed",-10,remove);
                       break;
        case "Latch": int DMG = r.nextInt(20)+1;
                      character.takeDamage(DMG);
                      System.out.println(character.getName() + " takes " + DMG + " from the latch");
                      break;
        case "Shell": String [] str = {"Fire","Water","Earth","Wind","Ice","Electricity","Acid","Poison","Slag","Holy","Curse","ESP","Other"};
                      for(int x = 0; x < str.length; x++)
                        character.changeResistance(str[x],50,remove);
                      break;
        case "Water Barricade": character.changeResistance("Fire",25,remove);
                                character.changeResistance("Water",100,remove);
                                break;
        case "Cursed and Burned": applyAffliction(character,"Burning",remove);
                                  applyAffliction(character,"Cursed",remove);
                                  break; 
        case "Smoke Bomb": character.changeBonus("Bonus",-10,remove); break;
        case "Decrepify": character.changeBonus("Strength",(int)(STR * -0.5),remove); character.changeBonus("Speed",(int)(SPD * -0.5),remove); break;
        case "Hexed":  character.changeBonus(attribute.rolls.selectAttribute(new Scanner(System.in)), -10, remove); break;
        case "Bull Call": character.applyBooleanAffliction("Bull Call",remove); 
                          int total = r.nextInt(100)+1 - INT;
                          if(total >= 50)
                          {
                           character.applyBooleanAffliction("Enraged",remove);
                           System.out.println("Bull Call caused Enraged!");
                          } 
                          else
                          {
                           character.applyBooleanAffliction("Confusion",remove);
                           System.out.println("Bull Call caused Confusion!");
                          }
                          break;
         case "Sapped": character.applyBooleanAffliction("Sapped",remove); break;           
      }   
      return character;
   }
   public static Playable [] isAlive(Playable[] characters, final Scanner kb)
   {
      for(int x = 0; x < characters.length; x++)
      {
         String str = characters[x].printHP();
         String [] split = str.split("/");
         int HP = Integer.parseInt(split[0]);
         int Max_HP = Integer.parseInt(split[1]);
         if(HP <= 0)
         {
            characters[x].limitCheck(new Random(),kb);
         }
      }
      return alive(characters);
   }
   public static Playable [] afflictionMenu(Playable [] names, final Scanner kb) throws FileNotFoundException
   {
      System.out.println("\n-- Affliction Menu --\n1. Affliction Damage/Heal\n2. Panicking Chart");
      System.out.print("Enter your choice: ");
      int choice = kb.nextInt(); kb.nextLine();
      switch(choice)
      {
         case 1: names = attack.calculate.afflictionDamage(names,kb); break;
         case 2: names = panicChoice(names,new Random(), kb); break;
      }
      return names;
   }
   public static Playable [] panicChoice(Playable [] names, final Random r, final Scanner kb) throws FileNotFoundException
   {
      System.out.print("Enter the victim: ");
      String victim = kb.nextLine();
      int roll = r.nextInt(99)+1;
      if(roll <= 20)
         System.out.println(victim + " is petrified!");
      else if(roll >= 20 && roll <= 40)
         System.out.println(victim + " attacks " + names[r.nextInt(names.length)].getName() + " with a spell!");
      else if(roll >= 40 && roll <= 60)
         System.out.println(victim + " attacks " + names[r.nextInt(names.length)].getName() +" with an abililty!");
      else if(roll >= 60 && roll <= 80)
         System.out.println(victim + " attacks " + names[r.nextInt(names.length)].getName() + " with an unarmed attack!");
      else
         System.out.println(victim + " attacks " + names[r.nextInt(names.length)].getName() + " wi th a melee weapon!");
      return names;
   }
   public static Playable [] alive(Playable [] characters)
   {
      int dead = 0;
      for(int x = 0; x < characters.length; x++)
      {
         if(characters[x].checkAlive() == false)
            dead++;
      }
      Playable [] alive = new Playable[characters.length - dead];
      for(int x = 0; x < alive.length; x++)
      {
         if(characters[x].checkAlive() == true)
          alive[x] = characters[x];
         else
            x--;
      }
      return alive;
   }
}
  