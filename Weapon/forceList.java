package Weapon;
import Weapon.Force;
import java.io.*;
import java.util.*;
public class forceList
{
   public static Force forceList(final String name)
   {
      int Base = 0, Rate = 0,Crit = 0;
      boolean nonphysical = false;
      String Affliction = "";
      switch(name)
      {
         case "Texas Smash": Base = 45; Crit = 2; break;
         case "Bolt Rush": Base = 30; Crit = 2; break;
         case "Whirlwind Fist": Base = 35; Crit = 3; break;
         case "Shockwave": Base = 25; Crit = 4; nonphysical = true; break;
         case "Wavedash": Base = 21; Crit = 2; break;
         case "Iron Knuckle": Base = 30; Affliction = "Intoxication"; Crit = 5; Rate = 35; break;
         case "Sheer Force": Base = 35; Crit = 2; nonphysical = true; break;
         case "Artery Crusher": Base = 30; Crit = 5; nonphysical = true; break;
         case "Shrapnel Fire": Base = 25; Crit = 2; nonphysical = true; break;
      }
      return new Force(name,Base,Affliction,Rate,Crit, nonphysical);
   }
}