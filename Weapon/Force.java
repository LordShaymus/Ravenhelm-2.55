package Weapon;
import java.io.*;
import java.util.*;
public class Force
{
   private String Name, Affliction;
   int Rate,Base,Crit;
   boolean NonPhysical;
   public Force(final String Name, final int Base, final String Affliction, final int Rate, final int Crit, final boolean nonphysical)
   {
      this.Name = Name;
      this.Base = Base;
      this.Affliction = Affliction;
      this.Rate = Rate;
      this.Crit = Crit;
      this.NonPhysical = nonphysical;
   }
   public String getName(){return this.Name;}
   public int getBase(){return this.Base;}
   public int getRate(){return this.Rate;}
   public String getAffliction(){return this.Affliction;}
   public int getCrit(){return this.Crit;}
   public boolean getNonPhysical(){return this.NonPhysical;}
}