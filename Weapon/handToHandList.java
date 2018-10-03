package Weapon;
import java.util.*;
import Weapon.handToHand;
public class handToHandList
{
   public static handToHand attackInfo(final String style, final String attack)
   {
      int base = 0,roll, crit = 0;
      boolean martial = false;
      Random r = new Random();
      if(style.equals("Boxing"))
      {
         crit = 3;
         switch(attack){
            case "Punch": base = 15;
                          break;
            case "Gut Punch": base = 17;
                              break;
            case "Hook": base = 16;
                         break;
            case "Uppercut": base = 19;
                             break;
         }
      }else if(style.equals("Chop Suey"))
      {
         crit = 2;
         switch(attack){
               case "Punch": roll = r.nextInt(100)+1;
                                    if(roll >= 90)
                                       base = 1000000000;
                                    else
                                       base = 10;
                                    break;
               case "Throw": base = 13;
                             break;
            }
      }else if(style.equals("Close Quarter Combat"))
      {
         switch(attack){
            case "Punch": base = 10;
                          break;
            case "Kick": base = 12;
                         break;
            case "Throw": base = 15;
                          break;
         }
      }else if(style.equals("Capoeira"))
      {
         crit = 4;
         martial = true;
         switch(attack){
            case "Kick": base = 12;
                         break;
            case "Sweep Kick": base = 15;
                               break;
            case "Punch": base = 7;
                          break;
            case "Throw": base = 10;
                          break;
            case "Breakdance": base = 16;
                               break;
            case "Latch": base = 0;
                          break;
         }
      }else if(style.equals("Ying Zhao Pai"))
      {
         crit = 5;
         martial = true;
         switch(attack){
            case "Punch": base = 10;
                          break;
            case "Jab": base = 19;
                        break;
            case "Bound": base = 11;
                          break;
            case "Takedown": base = 20;
                             break;
            case "Disarm": base = 15;
                           break;
            case "Kick": base = 10;
                         break; 
         }
      }else if(style.equals("Wrestling"))
      {
         crit = 2;
         switch(attack){
            case "Punch": base = 12;
                          break;
            case "Kick": base = 14;
                         break;
            case "Pile Driver": base = 20;
                                break;
            case "Brainbuster": base = 22;
                                break;
            case "Suplex": base = 18;
                           break;
         }
      }else if(style.equals("Ice Elemental"))
      {
         switch (attack){
         case "Swipe": base = 15; break;
         case "Stab": base = 17; break;
         case "Headbutt": base = 13; break;
         }
      }
      else if(style.equals("Green Nekron") || style.equals("Orange Nekron") || style.equals("Purple Nekron"))
      {
         switch(attack)
         {
            case "Kick": base = 11; break;
            case "Bite": base = 19; break;
            case "Swipe": base = 15; break;
            case "Lunge": base = 14; break;
         }
      }
      else if(style.equals("Wicker Man"))
      {
         crit = 3;
         switch(attack)
         {
            case "Slam": base = 16; break;
            case "Stomp": base = 25; break;
            case "Swipe": base = 19; break;
         }
      }
      else if(style.equals("Ice Gryphon"))
      {
         switch(attack)
         {
            case "Peck": base = 21; break;
            case "Swipe": base = 17; break;
         }
      }
      else if(style.equals("Soren"))
      {  
         crit = 5;
         switch(attack)
         {
            case "Loose Cannon": base = 22; break;
         }
      }
      else if(style.equals("Shotokan"))
      {
         crit = 3;
         martial = true;
         switch(attack)
         {
            case "Jab": base = 17; break;
            case "Roundhouse Kick": base = 20; break;
            case "Thrust": base = 21; break;
            case "Elbow": base = 19; break;
         }
      }
      else if(style.equals("Wing Chun"))
      {
         crit = 6;
         martial = true;
         switch(attack)
         {
            case "Jab": base = 20; break;
            case "Beatdown": base = 18; break;
            case "Kick": base = 14; break;
         }
      }
      else if(style.equals("Dirty Fighting"))
      {
         switch(attack)
         {
            case "Punch": base = 10; break;
            case "Kick": base = 12; break;
            case "Kick Balls": base = 17; break;
            case "Sucker Punch": base = 15; break;
         }
      }
      else if(style.equals("Heavy Seal"))
      {
         crit = 3;
         switch(attack)
         {
            case "Texas Smash": base = 30; break;
            case "Punch": base = 25; break;
            case "Elbow": base = 27; break;
            case "Earth Crusher": base = 34; break;
            case "Two Hand Strike": base = 35; break;
            case "Throw": base = 29; break;
         }
      }
      return new handToHand(attack,style,base,crit,martial);
   }
   public static int damageRoll(String type)
   {
      switch(type)
      {
         case "Boxing": return 12;
         case "Chop Suey": return 12;
         case "Wrestling": return 12;
         case "Heavy Seal": return 12;
      }
      return 8;
   }
}