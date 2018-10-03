package Weapon;
import java.util.*;
import Character.Playable;
public class SupportMagic
{
   private String name, type;
   private double percentage;
   private int base, roll;
   public SupportMagic(final String name,String type, double percentage,int base,int roll)
   {
      this.name = name;
      this.type = type;
      this.base = base;
      this.roll = roll;
      this.percentage = percentage;
   }
   public boolean checkPro(String [] magicType)
   {
      for(int x = 0; x < magicType.length; x++)
      {
         if(magicType[x].equals(this.type))
            return true;
      }
      return false;
   }
   public String getType(){return this.type;}
   public String getName(){return this.name;}
   public int Heal(int Max_HP,Random r)
   {
      return this.base + r.nextInt(this.roll)+1 + (int)(Max_HP * percentage);
   }
  
}
