package attribute;
import Character.Playable;
import java.io.*;
import java.util.*;
public class rolls
{
   public static void basicRolls(final Scanner kb) throws FileNotFoundException
   {
      String attribute = selectAttribute(kb);
         System.out.print("Enter the difficultly class: ");
         int DC = kb.nextInt(); kb.nextLine();
         Playable [] names = information.gather.partyNames(kb);
         int [] rolls = information.gather.partyRolls(names,kb);
         rolls = information.gather.calculateRolls(names,rolls,attribute);
         System.out.println("\n--- " + attribute + " Check ---\n");
         for(int x = 0; x < names.length; x++)
         {
            System.out.println(names[x].getName() + ": " + rolls[x]);
            if(rolls[x] >= DC)
               System.out.println("Success!\n");
            else
               System.out.println("Failure...\n");  
         }
   }
   public static String selectAttribute(final Scanner kb)
   {
      System.out.println("1. Strength\n2. Defense\n3. Magic\n4. Resistance\n5. Constitution\n6. Speed\n7. Skill\n8. Limit\n9. Intelligence\n10. Instinct\n11. Luck");
      System.out.print("Enter your attribute: ");
      int choice = kb.nextInt(); kb.nextLine();
      if(choice >= 12 || choice <= 0)
         return selectAttribute(kb);
      switch(choice){
         case 1: return "Strength";
         case 2: return "Defense";
         case 3: return "Magic";
         case 4: return "Resistance";
         case 5: return "Constitution";
         case 6: return "Speed";
         case 7: return "Skill";
         case 8: return "Limit";
         case 9: return "Intelligence";
         case 10: return "Instinct";
         case 11: return "Luck";
      }
      return null;
   }
}