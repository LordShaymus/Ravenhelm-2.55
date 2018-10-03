package special;
import java.io.*;
import java.util.*;
import Character.Playable;
public class dodge
{
   public static int evasion(final Playable character, boolean magical, boolean projectile)
   {
      String name = character.getName(), archetype = character.getArchetype();
      int bonus = 0;
      if(projectile == true || (projectile == true && magical == true))
      {
         switch(name)
         {
            case "Shepherd": bonus += 3;
         }
         switch(archetype)
         {
            case "Spellcaster Raider": bonus += 5;
         }
      }
      else if(magical == true)
      {
         switch(archetype)
         {
            case "Spellcaster Raider": bonus += 5;
         }
      }
      return bonus;
   }
   public static boolean afflictionSave(final Playable character, String affliction)
   {
      String name = character.getName();
      Random r = new Random();
      int roll = r.nextInt(99)+1, requirement = 1000;
      switch(name)
      {
         case "Willie":
            if(affliction.equals("Panicking") || affliction.equals("Charmed"))
               requirement = 90;
            break;
         case "Mordecai":
            if(affliction.equals("Blind"))
               requirement = 0;
            break;
         case "Adric":
            if(affliction.equals("Panicking"))
               requirement = 50;
           break;
         case "Agon":
            if(affliction.equals("Panicking"))
               requirement = 50;
           break;
      }
      boolean success = requirement <= roll;
      return success;
   }
}