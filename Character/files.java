package Character;
import java.util.*;
import java.io.*;
public class files
{
   public static File getCharacter(String name) throws FileNotFoundException
   {
      File file = new File(name);
      String dir = file.getAbsolutePath();
      String [] split = dir.split(name);
      file = new File(split[0] + "\\Character\\sheet\\" + name + ".txt");
      return file;
   }
   public static int getStat(final String name, final String att) throws FileNotFoundException
   {
      File file = getCharacter(name);
      Scanner fin = new Scanner(file);
      String str = "";
      while(fin.hasNextLine() && !(str.contains(att)))
      {
         str = fin.nextLine();
      }
      if(str.contains(att))
      {
         return Integer.parseInt(str.replace(att + ": ","").trim());
      }
      return 0;
   }
   public static String getType(final String name) throws FileNotFoundException
   {
      File file = getCharacter(name);
      Scanner fin = new Scanner(file);
      String str = "";
      while(fin.hasNextLine() && !(str.contains("Archetype")))
      {
         str = fin.nextLine();
      }
      if(str.contains("Archetype"))
      {
         return str.replace("Archetype: ","").trim();
      }
      return "";
   }
   public static String[] getPro(final String name, final String type) throws FileNotFoundException
   {
      File file = getCharacter(name);
      Scanner fin = new Scanner(file);
      String str = "";
      ArrayList <String> pro = new ArrayList <String>();
      while(fin.hasNextLine() && !(str.equals("-- " + type + " --")))
      {
         str = fin.nextLine();
      }
      if(str.equals("-- " + type + " --"))
      {
         while(!(str.isEmpty()))
         {
            str = fin.nextLine();
            if(!(str.isEmpty()))
            {
               pro.add(str);
            }//end of if statement
         }//end of while loop
      }//end of if statement
      pro.trimToSize();
      return information.gather.toStringArray(pro);
   }//end of method
   public static String [] getEquipment(final String name) throws FileNotFoundException
   {
      File file = getCharacter(name);
      Scanner fin = new Scanner(file);
      String str = "";
      String [] equip = new String[5];
      while(fin.hasNextLine() && !(str.equals("-- Equipment --")))
      {
         str = fin.nextLine();
      }
      if(str.equals("-- Equipment --"))
      {
         equip[0] = fin.nextLine().replace("Hat:","").trim();
         equip[1] = fin.nextLine().replace("Armor:","").trim();
         equip[2] = fin.nextLine().replace("Accessory 1:","").trim();
         equip[3] = fin.nextLine().replace("Accessory 2:","").trim();
         equip[4] = fin.nextLine().replace("Accessory 3:","").trim();
      }
      return equip;
   }
   public static int getResistanceBouns(final String name, final String att)throws FileNotFoundException
   {
      File file = getCharacter(name);
      Scanner fin = new Scanner(file);
      String str = "";
      String [] equip = new String[5];
      while(fin.hasNextLine() && !(str.equals("-- Resistance --")))
      {
         str = fin.nextLine();
      }
      if(str.equals("-- Resistance --"))
      {
         while(!(str.contains(att)) && fin.hasNextLine())
         {
            str = fin.nextLine();
            if(str.contains(att))
               return Integer.parseInt(str.replace(att + ": ","").trim());
         }
      }
      return 0;
   }
   public static ArrayList <String> pcFinder() throws FileNotFoundException
   {
      //This program will find a list of Playable characters to search for other methods to use.
      File file = getCharacter("PC List");
      Scanner fin = new Scanner(file);
      ArrayList <String> pc = new ArrayList <String> ();
      while(fin.hasNextLine())
      {
         pc.add(fin.nextLine());
      }
      pc.trimToSize();
      return pc;
   }
}