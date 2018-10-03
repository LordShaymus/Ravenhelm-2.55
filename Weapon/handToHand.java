package Weapon;
import java.util.*;
import Character.Playable;
public class handToHand
{
   private String attack,type;
   private int base,crit;
   private boolean martial;
   public handToHand(String attack,String type,int base, int crit, boolean martial)
   {
      this.attack = attack;
      this.type = type;
      this.base = base;
      this.crit = crit;
      this.martial = martial;
   }
   public int getBase(){return this.base;}
   public int getCritRange(){return this.crit;}
   public boolean getMartial(){return this.martial;}
   public boolean checkPro(String [] handType)
   {
      for(int x = 0; x < handType.length; x++)
      {
         if(handType[x].equals(this.type))
            return true;
      }
      return false;
   }
   public boolean checkHandCrit(final Playable attacker, final Playable target,int atkRoll, int defRoll)
   {
      if(atkRoll - attacker.getAttribute("Skill") - attacker.getAttribute("Luck") >= 20)
         return true;
      int requirement = this.crit;
      int result = (atkRoll - attacker.getAttribute("Skill")) - (defRoll - target.getAttribute("Speed"));
      return result >= requirement;
   }
   public int calculateDamage(final Playable attacker, final Playable target,final boolean crit)
   {
      //Martial Arts move use Skill for damage versus non-martial arts moves
      int DMG;
      Random r = new Random();
      if(this.martial == false)
         DMG = this.base + r.nextInt(handToHandList.damageRoll(this.type))+1 + attacker.getAttribute("Strength") - target.getAttribute("Defense");
      else
          DMG = this.base + r.nextInt(handToHandList.damageRoll(this.type))+1 + attacker.getAttribute("Skill") - target.getAttribute("Defense");
      if(crit == true)
         return DMG * 2;  
      if(attacker.checkEnraged() == true)
         DMG = (int)(DMG * 1.25);
      if(target.checkProtect() == true)
         DMG = DMG/2;
      if(DMG <= 0)
         return 1; 
      return DMG;
   }

}