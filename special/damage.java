package special;
import java.util.*;
import java.io.*;
import Character.Playable;
public class damage
{
   public static int damageBonus(final Playable attacker, final Playable target, final int DMG, final Scanner kb)
   {
      String archetype = target.getArchetype(), atk = attacker.getName(), name = target.getName();
      switch(atk)
      {
         case "Willie":
         {
            if(archetype.contains("Rider") || name.contains("Rider"))
            {
               int choice = -1;
               //Willie has Animal Empathy, which allows him to deal x1.25 damage to the rider, but x0.75 to the animal itself.
               do
               {
                  System.out.print("1. Rider\n2. Animal\nEnter your choice: ");
                  choice = kb.nextInt(); kb.nextLine();
               }while(choice >= 3 || choice <= 0);
               if(choice == 1)
                  return (int)(DMG * 0.75);
               else
                  return (int)(DMG * 1.25);
           }//end of Animal Empathy Loop
         }//end of Willie's case
         case "Shepherd":
         {
            if(archetype.contains("Raider") || name.contains("Raider"))//Burden of the Crystals deals x1.25 damage to all Raiders
               return (int)(DMG * 1.25);
         }
      }
      return DMG;
   }
}
