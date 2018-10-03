package Weapon;
import Character.Playable;
import java.io.*;
import java.util.*;
public class AttackMagic
{
   private String Name, Element, Affliction;
   private int Base, Crit, Rate;
   private boolean projectile,limit;
   public AttackMagic(final String name,String element,int base, int crit, String affliction,int rate,boolean projectile,boolean limit)
   {
      this.Name = name;
      this.Element = element;
      this.Base = base;
      this.Crit = crit;
      this.Affliction = affliction;
      this.Rate = rate;
      this.projectile = projectile;
      this.limit = limit;
   }
   public int getBase(){return this.Base;}
   public int getCritRange(){return this.Crit;}
   public boolean getProjectile(){return this.projectile;}
   public int getRate(){return this.Rate;}
   public String getAffliction(){return this.Affliction;}
   public String getElement(){return this.Element;}
   public boolean checkPro(String [] magicType)
   {
      for(int x = 0; x < magicType.length; x++)
      {
         if(magicType[x].equals(this.Element))
            return true;
      }
      return false;
   }
   public boolean getLimit(){return this.limit;}
   public boolean checkSpellCrit(final Playable attacker, final Playable target,int atkRoll, int defRoll)
   {
      if(atkRoll - attacker.getAttribute("Magic") - attacker.getAttribute("Luck") >= 20)
         return true;
      int requirement = this.Crit;
      int result = (atkRoll - attacker.getAttribute("Magic")) - (attacker.getAttribute("Luck")/2) - (defRoll - target.getAttribute("Speed"));
      return result >= requirement;
   }
   public Playable afflictionCheck(Playable target)
   {
      if(this.Affliction.isEmpty() || this.Rate == 0)
      {} //Do nothing
      else
      {
         Random r = new Random();
         int requirement = 100 - this.Rate + target.getAttribute("Constitution"),roll = r.nextInt(100)+1;
         if(roll >= requirement)
         {
            System.out.println(target.getName() + " is afflicted with " + this.Affliction);
            target = target.applyAffliction(target,this.Affliction,false);
         }
      }
      return target;
   }
   public int calculateDamage(final Playable attacker, final Playable target,final boolean crit)
   {
      Random r = new Random();
      int DMG,BASE = this.Base,MGC = attacker.getAttribute("Magic"),RES = target.getAttribute("Resistance"),roll = r.nextInt(12)+1,LMT = attacker.getAttribute("Limit");
      if(BASE == 0)
         return 0;
      if(this.limit == true)
         DMG = (BASE + MGC + roll + LMT) - RES;
      else
         DMG = (BASE + MGC + roll) - RES; 
      if(crit == true)
         DMG = DMG * 2;
      if(DMG <= 0)
         return 1;
      if(target.checkBarrier() == true)
         DMG = DMG/2;
      return DMG - target.damageResistance(DMG,this.Element);
      
      /*
      DMG = this.Base + r.nextInt(12)+1 + attacker.getAttribute("Magic") - target.getAttribute("Resistance");
      DMG = DMG - target.damageResistance(DMG,this.Element);
      if(this.limit == true)
         DMG += attacker.getAttribute("Limit");
      if(crit == true)
         return DMG * 2;   
      return DMG;*/
   }
   
}