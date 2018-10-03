package enemy;
import java.io.*;
import java.util.*;
import Character.files;
public class create
{
   public static void createEnemy(final Scanner kb)throws FileNotFoundException
   {
      String name = "",type = "";
      int [] mods,res;
      String [] info,attInfo = {"HP: ","Strength: ","Defense: ","Magic: ","Resistance: ","Constitution: ","Speed: ","Skill: ","Limit: ","Intelligence: ","Instinct: ","Luck: "};
      String [] resInfo = {"Fire: ","Water: ","Earth: ","Wind: ","Ice: ","Electricity: ","Poison: ","Acid: ","Slag: ","Holy: ","Curse: ","ESP: ","Other: "};
      System.out.print("Enter the archetype of the enemy: ");
      type = kb.nextLine();
      System.out.print("Enter the name of the character: ");
      name = kb.nextLine();
      mods = randomizeAtt(findType(type), new Random());
      res = findResType(type);
      info = findInfo(type);
      PrintStream fout = new PrintStream(files.getCharacter(name));
      fout.println("Archetype: " + type);
      for(int x = 0; x < attInfo.length; x++)
      {
         if(x == 0)
         {
            fout.println(attInfo[x] + mods[x] + "\nMax HP: " + mods[x]);
         }
         else
            fout.println(attInfo[x] + mods[x]);
      }
      for(int x = 0; x < info.length; x++)
      {
         fout.println(info[x]);
      }
      fout.println("\n-- Resistance --\n");
      for(int x = 0; x < resInfo.length; x++)
      {
         fout.println(resInfo[x] + res[x]);
      }
      fout.close();
   }
   public static int [] findType(final String type)
   {
      int HP = 0,STR = 0,DEF = 0,MGC = 0,RES = 0,CON = 0,SPD = 0,SKL = 0,LMT = 0,INT = 0,INS = 0,LCK = 0;
      switch(type)
      {
         case "Ice Elemental": HP = 90; STR = 2; RES = 1; CON = 1; SKL = -2; INT = -5; break;
         case "Wicker Man": HP = 100; STR = 5; MGC = -10; CON = 5; SPD = 5; INT = -5; break;
         case "Green Nekron": HP = 70; STR = -5; DEF = -3; MGC = 2; RES = 5; SPD = 5; INT = -8; INS = 3; break;
         case "Orange Nekron": HP = 70; STR = -5; DEF = -3; MGC = 2; RES = 5; SPD = 5; INT = -8; INS = 3; break;
         case "Purple Nekron": HP = 70; STR = -5; DEF = -3; MGC = 2; RES = 5; SPD = 5; INT = -8; INS = 3; break;
         case "Ice Gryphon": HP = 90; STR = 3; DEF = 3; MGC = -10; RES = 2; SPD = 5; SKL = 3; INT = -5; INS = 5; break;
         case "Raider": HP = 100; break;
         case "Zombie": HP = 120; STR = -3; MGC = -20; CON = 10; SPD = -2; SKL = 3; LMT = 15; INT = -10; INS = 3; break;
         case "Spirit": HP = 80; STR = -20; DEF = 100; SPD = 5; break;
         case "Golem": HP = 140; STR = 10; DEF = 10; MGC = -20; RES = -5; SPD = -7; INT = -10; INS = 7; break;
      }
      int [] stat = {HP,STR,DEF,MGC,RES,CON,SPD,SKL,LMT,INT,INS,LCK};
      return stat;
   }
   public static int [] randomizeAtt(int [] att, Random r)
   {
      for(int x = 1; att.length > x; x++)//We don't do this for HP (att[0])
      {
         att[x] += r.nextInt(8)+10;
      }
      att[0] += att[5];
      return att;
   }
   public static int [] findResType(final String type)
   {
      int fire = 0,water = 0, earth = 0,wind = 0, ice = 0, electricity = 0, poison = 0, acid = 0, slag = 0, holy = 0, curse = 0, esp = 0, other = 0;
      switch(type)
      {
         case "Ice Elemental": fire = -100; ice = 100; water = 75; break;
         case "Wicker Man": slag = 100; poison = 100; break;
         case "Green Nekron": holy = -100; curse = 50; acid = 50; break;
         case "Orange Nekron": holy = -100; curse = 50; fire = 50; break;
         case "Purple Nekron": holy = -100; curse = 50; esp = 50; break;
         case "Ice Gryphon": fire = -25; water = 5; ice = 25; wind = 50; break;
         case "Zombie": poison = 100; break;
      }
      int [] res = {fire,water,earth,wind,ice,electricity,poison,acid,slag,holy,curse,esp,other};
      return res;
   }
   public static String [] findInfo(final String type)
   {
      String handToHand = "-- Hand To Hand Training --";
      String weapon = "-- Weapon Training--";
      String magicType = "-- Magic Type --";
      String equipment = "-- Equipment --";
      switch (type)
      {
         case "Ice Elemental": handToHand +=type + "\n\n"; weapon +="\n\n"; magicType +="Ice\n\n"; equipment +="Hat:\nArmor:\nAccessory1:\nAccessory2:\nAccessory3:";break;
         case "Wicker Man": handToHand +=type + "\n\n"; weapon +="\n\n"; magicType +="\n\n"; equipment +="\nHat:\nArmor:\nAccessory1:\nAccessory2:\nAccessory3:";break;
         case "Green Nekron":  handToHand +=type + "\n\n"; weapon +="\n\n"; magicType +="Acid\n\n"; equipment +="\nHat:\nArmor:\nAccessory1:\nAccessory2:\nAccessory3:";break;
         case "Orange Nekron":  handToHand +=type + "\n\n"; weapon +="\n\n"; magicType +="Fire\n\n"; equipment +="\nHat:\nArmor:\nAccessory1:\nAccessory2:\nAccessory3:";break;
         case "Purple Nekron":  handToHand +=type + "\n\n"; weapon +="\n\n"; magicType +="ESP\n\n"; equipment +="\nHat:\nArmor:\nAccessory1:\nAccessory2:\nAccessory3:";break;
         case "Ice Gryphon":  handToHand +=type + "\n\n"; weapon +="\n\n"; magicType +="\n\n"; equipment +="\nHat:\nArmor:\nAccessory1:\nAccessory2:\nAccessory3:";break;
         case "Raider":  handToHand +=type + "\n\n"; weapon +="\n\n"; magicType +="\n\n"; equipment +="\nHat:\nArmor:\nAccessory1:\nAccessory2:\nAccessory3:";break;
         case "Zombie": handToHand +=type + "\n\n"; weapon +="\n\n"; magicType +="\n\n"; equipment +="\nHat:\nArmor:\nAccessory1:\nAccessory2:\nAccessory3:";break;
         case "Spirit": handToHand +=type + "\n\n"; weapon +="\n\n"; magicType +="\n\n"; equipment +="\nHat:\nArmor:\nAccessory1:\nAccessory2:\nAccessory3:";break;
         case "Golem": handToHand +=type + "\n\n"; weapon +="\n\n"; magicType +="\n\n"; equipment +="\nHat:\nArmor:\nAccessory1:\nAccessory2:\nAccessory3:";break;

      }
      String [] str = {handToHand,weapon,magicType,equipment};
      return str;
   }
}