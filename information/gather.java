package information;
import java.io.*;
import java.util.*;
import Character.Playable;
import Character.Initiative;
public class gather
{
   public static Playable [] partyNames(final Scanner kb) throws FileNotFoundException
   {
      int amount;
      Playable [] names;
      System.out.print("How many characters are there: ");
      amount = kb.nextInt(); kb.nextLine();
      names = new Playable[amount];
      for(int x = 0; x < names.length; x++)
      {
         System.out.print("Enter their name: ");
         names[x] = new Playable(information.error.checkFileName(kb.nextLine(),kb));
      }
      return names;
   }
   public static String [] getCharacterName(final Scanner kb)
   {
      int amount;
      String [] names;
      System.out.print("How many characters are there: ");
      amount = kb.nextInt(); kb.nextLine();
      names = new String[amount];
      for(int x = 0; x < names.length; x++)
      {
         System.out.print("Enter their name: ");
         names[x] = kb.nextLine();
      }
      return names;
   }
   public static Playable getAttacker(final String name, final Playable [] characters)
   {
      for(int x = 0; characters.length > x; x++)
      {
         String charName = characters[x].getName();
         if(name.equals(charName))
            return characters[x];
      }
      return null;
   }
   public static Playable [] getTargets(String [] targets, Playable [] list)
   {
      Playable [] result = new Playable[targets.length];
      for(int x = 0; x < targets.length; x++)
      {
         String name = targets[x];
         for(int y = 0; y < list.length; y++)
         {
            String charName = list[x].getName();
            if(name.equals(charName))
               result[x] = list[y];
         }
      }
      return result;
   }
   public static Playable [] theRest(final Playable [] winners, final Playable [] list)
   {
      if(list.length == 1)
         return list;
      ArrayList <Playable> theRest = new ArrayList();
      for(int x = 0; x < list.length; x++)
      {
         boolean isLoser = true;
         String listName = list[x].getName();
         for(int y = 0; y < winners.length; y++)
         {
            String winnerName = winners[y].getName();
            if(winnerName.equals(listName))
               isLoser = false;
         }
         if(isLoser == true)
         {
            theRest.add(list[x]);
         }
      }
      theRest.trimToSize();
      return information.gather.toPlayableArray(theRest);
   }
   public static Playable isInBattle(Playable name, final Playable [] list)
   {
      String atk = name.getName();
      for(int x = 0; x < list.length; x++)
      {
         String nam = list[x].getName();
         if(atk.equals(nam))
         {
            name = list[x];
            break;
         }
      }
      return name;
   }
   public static Playable [] areInBattle(final Playable [] targets, final Playable [] list)
   {
      ArrayList <Playable> info = new ArrayList<Playable>();
      for(int x = 0; x < targets.length; x++)
      {
         for(int y = 0; y < list.length; y++)
         {
            if(list[y].getName().equals(targets[x].getName()))
            {
               info.add(list[y]);
            }
         }
      }
      info.trimToSize();
      return toPlayableArray(info);
   }
   public static int [] partyRolls(final Playable[] names, final Scanner kb)
   {
      int [] roll = new int[names.length];
      for(int x = 0; x < names.length; x++)
      {
         System.out.print("Enter " + names[x].getName() + "'s Roll: ");
         roll[x] = kb.nextInt(); kb.nextLine();
      }
      return roll;
   }
   public static int [] calculateRolls(final Playable[] names, final int [] rolls,final String att)
   {
      for(int x = 0; x < names.length;x++)
         rolls[x] += names[x].getAttribute(att);
      return rolls;
   }
   public static String [] toStringArray(final ArrayList <String> info)
   {
      String [] result = new String[info.size()];
      for(int x = 0; x < info.size(); x++)
      {
         result[x] = info.get(x);
      }
      return result;
   }
   public static Initiative [] toInitiativeArray(final ArrayList <Initiative> info)
   {
      Initiative [] result = new Initiative[info.size()];
      for(int x = 0; x < info.size(); x++)
      {
         result[x] = info.get(x);
      }
      return result;
   }
   public static Playable [] toPlayableArray(final ArrayList <Playable> info)
   {
      Playable [] result = new Playable[info.size()];
      for(int x = 0; x < info.size(); x++)
      {
         result[x] = info.get(x);
      }
      return result;
   }
   public static Playable [] changeCharacterInfo(final Playable target, Playable [] characters)
   {
      String name = target.getName();
      for(int x = 0; x < characters.length; x++)
      {
         String characterName = characters[x].getName();
         if(name.equals(characterName))
         {
            characters[x] = target;
            break;
         }
      }
      return characters;
   }
}