package Weapon;
import java.util.*;
import Character.Playable;
public class Weapon
{
   private String type,affliction,name,element;
   private int base,crit,rate;
   private boolean projectile, magical;
   public Weapon(final String name,final String type, final int base, final int crit,final String element, final String affliction, final int rate, final boolean projectile, final boolean magical)
   {  
      this.name = name;
      this.type = type;
      this.base = base;
      this.crit = crit;
      this.element = element;
      this.affliction = affliction;
      this.rate = rate;
      this.projectile = projectile;
      this.magical = magical;
   }
   public String getName(){return this.name;}
   public int getBase(){return this.base;}
   public int getCritRange(){return this.crit;}
   public int getTypeRoll()
   {
      switch(this.type){    
         case "Axe": return base*2;
         case "Ballista": return base*2;
         case "Bizarre": return base;
         case "Blowgun": return base/4;
         case "Blunt": return base*2;
         case "Bow": return base/2;
         case "Chakram": return base/2;
         case "Crossbow": return base/2;
         case "Items": return base;
         case "Flail": return base*2;
         case "Gauntlet": return base*2;
         case "Knife": return base/2;
         case "Nunchuck": return base/4;
         case "One Handed Sword": return base/2;
         case "Shield": return base/4;
         case "Staves": return base;
         case "Two Handed Sword": return base;
         case "Whip": return base/2;
      }
      return base/4;
   }
   public int getRate(){return this.rate;}
   public String getElement(){return this.element;}
   public String getAffliction(){return this.affliction;}
   public String getWeaponType(){return this.type;}
   public boolean checkPro(String [] weaponType)
   {
      for(int x = 0; x < weaponType.length; x++)
      {
         if(weaponType[x].equals(this.type))
            return true;
      }
      return false;
   }
   public boolean getProjectile(){return this.projectile;}
   public boolean getMagical(){return this.magical;}
   public boolean checkWeaponCrit(final Playable attacker, final Playable target,int atkRoll, int defRoll)
   {
      int requirement = this.crit;
      if(atkRoll - attacker.getAttribute("Skill") - attacker.getAttribute("Luck") >= 20)
         return true;
      int result = (atkRoll - attacker.getAttribute("Skill")) - (defRoll - target.getAttribute("Speed"));
      return result >= requirement;
   }
   public Playable afflictionCheck(Playable target)
   {
      if(this.affliction.isEmpty() || rate == 0)
      {} //Do nothing
      else
      {
         Random r = new Random();
         int requirement = 100 - this.rate + target.getAttribute("Constitution"),roll = r.nextInt(100)+1;
         if(roll >= requirement || rate >= 200)
         {
            System.out.println(target.getName() + " is afflicted with " + this.affliction);
            target = target.applyAffliction(target,this.affliction,false);
         }
      }
      return target;
   }
   public int calculateDamage(final Playable attacker, final Playable target,final boolean crit)
   {
      Random r = new Random();
      int DMG,BASE = this.base,SKL = attacker.getAttribute("Skill"),STR = attacker.getAttribute("Strength"),DEF = target.getAttribute("Defense"),Roll = r.nextInt(weaponList.damageRoll(this.type))+1;
      
      if(this.projectile == true)
         DMG = (BASE + SKL + Roll) - DEF;
      else
         DMG = (BASE + STR + Roll) - DEF;  
      if(attacker.checkEnraged() == true)
         DMG = (int)(DMG * 1.25);
      if(target.checkProtect() == true)
         DMG = DMG/2;
      DMG = DMG - target.damageResistance(DMG,this.element);
      if(DMG <= 0)
         return 1;
      return DMG;
   }
   public boolean checkSteel()
   {
      if(this.name.contains("Steel"))
         return true;
      switch(this.type)
      {
         case "Axe": return true;
         case "Ballista": return false;
         case "Bizzare": return checkBizzare();
         case "Blowgun": return false;
         case "Blunt": return false;
         case "Bow": return false;
         case "Chakram": return true;
         case "Crossbow": return false;
         case "Gauntlet": return true;
         case "Knife": return true;
         case "Nunchuck": return false;
         case "One Handed Sword": return true;
         case "Staves": return true;
         case "Two Handed Sword": return true;
         case "Whip": return false;
      }
      return false;
   }
   public boolean checkBizzare()
   {
      switch(this.name)
      {
         case "Boomerang Sword": return true;
      }
      return false;
   }
}