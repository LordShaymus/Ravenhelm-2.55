package Character;
import Character.Playable;
import java.util.*;
public class Affliction
{
   private boolean Acid,Blind,Bound,Burning,Cursed,Dead_Magic,Doomed,Enraged,Frozen,Intoxicated,Panicking,Paralyzed,Possessed,Barrier,Stasis,Time_Freeze,Inspired,Protect,Mire,Weakened,BullCall,Confusion,Sapped;
   private int Drain,Exhaustion,Leech,Poisoned,OG_Poisoned,Slag,Slow,Blessed,Haste,Relaxed,Flurry;
   public Affliction()
   {
      this.Acid = setAffliction(this.Acid);
      this.Blind = setAffliction(this.Blind);
      this.Bound = setAffliction(this.Bound);
      this.Burning = setAffliction(this.Burning);
      this.Cursed = setAffliction(this.Cursed);
      this.Dead_Magic = setAffliction(this.Dead_Magic);
      this.Doomed = setAffliction(this.Doomed);
      this.Drain = setAffliction(this.Drain);
      this.Enraged = setAffliction(this.Enraged);
      this.Exhaustion = setAffliction(this.Exhaustion);
      this.Frozen = setAffliction(this.Frozen);
      this.Intoxicated = setAffliction(this.Intoxicated);
      this.Panicking = setAffliction(this.Panicking);
      this.Paralyzed = setAffliction(this.Paralyzed);
      this.OG_Poisoned = setAffliction(this.OG_Poisoned);
      this.Poisoned = setAffliction(this.Poisoned);
      this.Possessed = setAffliction(this.Possessed);
      this.Barrier = setAffliction(this.Barrier);
      this.Slag = setAffliction(this.Slag);
      this.Slow = setAffliction(this.Slow);
      this.Stasis = setAffliction(this.Stasis);
      this.Time_Freeze = setAffliction(this.Time_Freeze);
      this.Blessed = setAffliction(this.Blessed);
      this.Haste = setAffliction(this.Haste);
      this.Inspired = setAffliction(this.Inspired);
      this.Leech = setAffliction(this.Leech);
      this.Relaxed = setAffliction(this.Relaxed);
      this.Protect = setAffliction(this.Protect);
      this.Blessed = setAffliction(this.Blessed);
      this.Weakened = setAffliction(this.Weakened);
      //Special Conditions
      this.Mire = setAffliction(this.Mire);
      this.Flurry = setAffliction(this.Flurry);
      this.BullCall = setAffliction(this.BullCall);
      this.Confusion = setAffliction(this.Confusion);
      this.Sapped = setAffliction(this.Sapped);
   }
   public int setAffliction(int count)
   {
      if(count == 0)
         return 0;
      else
         return count;
   }
   public boolean setAffliction(boolean aff)
   {
      if(aff == false)
         return false;
      else
         return true;
   }
   public String checkAffliction()
   {
      ArrayList <String> aff = new ArrayList();
      String str = "";
      if(this.Acid == true)
         aff.add("Acid");
      if(this.Blind == true)
         aff.add("Blind");
      if(this.Bound == true)
         aff.add("Bound");
      if(this.Burning == true)
         aff.add("Burning");
      if(this.Cursed == true)
         aff.add("Cursed");
      if(this.Dead_Magic == true)
         aff.add("Dead Magic");
      if(this.Doomed == true)
         aff.add("Doomed");
      if(this.Drain != 0)
         aff.add("Drain: " + getSeverity("Drain"));
      if(this.Enraged == true)
         aff.add("Enraged");
      if(this.Exhaustion != 0)
         aff.add("Exhaustion: " + getSeverity("Exhaustion"));
      if(this.Frozen == true)
         aff.add("Frozen");
      if(this.Intoxicated == true)
         aff.add("Intoxicated");
      if(this.Panicking == true)
         aff.add("Panicking");
      if(this.Paralyzed == true)
         aff.add("Paralyzed");
      if(this.Poisoned != 0)
         aff.add("Poisoned: " + getSeverity("Poisoned"));
      if(this.OG_Poisoned != 0)
         aff.add("Oguma Poisoned: " + getSeverity("OG Poisoned"));
      if(this.Possessed == true)
         aff.add("Possessed");
      if(this.Barrier == true)
         aff.add("Barrier");
      if(this.Slag != 0)
         aff.add("Slag: " + getSeverity("Slag"));
      if(this.Slow != 0)
         aff.add("Slow: " + getSeverity("Slow"));
      if(this.Stasis == true)
         aff.add("Stasis");
      if(this.Time_Freeze == true)
         aff.add("Time Freeze");
      if(this.Blessed != 0)
         aff.add("Blessed:  " + getSeverity("Blessed"));
      if(this.Haste != 0)
         aff.add("Haste: " + getSeverity("Haste"));
      if(this.Inspired == true)
         aff.add("Inspired");
      if(this.Leech != 0)
         aff.add("Leech: " + getSeverity("Leech"));
      if(this.Relaxed != 0)
         aff.add("Relaxed: " + getSeverity("Relaxed"));
      if(this.Protect == true)
         aff.add("Protect");
      if(this.Mire == true)
         aff.add("Mire");
      if(this.Flurry != 0)
         aff.add("Flurry: " + getSeverity("Flurry"));
      if(this.Weakened == true)
         aff.add("Weakened");
      if(this.BullCall == true)
         aff.add("Bull Call");
      if(this.Confusion == true)
         aff.add("Confusion");
      if(this.Sapped == true)
         aff.add("Sapped");
      
      aff.trimToSize();
      if(aff.size() == 0)
      {
         return "Normal";
      }
      else if(aff.size() == 1)
      {
         return aff.get(0);
      }
      else
      {
         String [] affliction = information.gather.toStringArray(aff);
         for(int x = 0; x < affliction.length; x++)
         {
            if(x == 0)
               str += affliction[x];
            else
               str += ", " + affliction[x];
         }
      }
      return str;
    
   }
   public boolean checkBlessed()
   {
      if(this.Blessed != 0)
         return true;
      return false;
   }
   public boolean checkProtect(){return this.Protect;}
   public boolean checkBarrier(){return this.Barrier;}
   public boolean checkEnraged(){return this.Enraged;}
   public boolean checkParalyzed(){return this.Paralyzed;}
   public boolean checkBlind(){return this.Blind;}
   public boolean checkBullCall(){return this.BullCall;}
   public boolean checkFrozen(){return this.Frozen;}
   public boolean checkSapped(){return this.Sapped;}
   public void applyIntAffliction(String name,boolean remove)
   {
      //Acid,Exhaustion,Poisoned,Slag,Slow,Blessed,Haste,Relaxed
      if(remove == false)
      {
         switch(name)
         {
            case "Drain": this.Drain++; break;
            case "Exhaustion": this.Exhaustion++; break;
            case "Leech": this.Leech++;
            case "Poisoned": this.Poisoned++; break;
            case "OG Poisoned": this.OG_Poisoned++; break;
            case "Slag": this.Slag++; break;
            case "Slow": this.Slow++; break;
            case "Blessed": this.Blessed++; break;
            case "Haste": this.Haste++; break;
            case "Relaxed": this.Relaxed++; break;
            case "Flurry": this.Flurry++; break;
         }
      }else
      {
         switch(name)
         {
            case "Drain": this.Drain = 0; break;
            case "Exhaustion": this.Exhaustion = 0; break;
            case "Leech": this.Leech = 0; break;
            case "Poisoned": this.Poisoned = 0; break;
            case "OG Poisoned": this.OG_Poisoned = 0; break;
            case "Slag": this.Slag = 0; break;
            case "Slow": this.Slow = 0; break;
            case "Blessed": this.Blessed = 0; break;
            case "Haste": this.Haste = 0; break;
            case "Relaxed": this.Relaxed = 0; break;
            case "Flurry": this.Flurry = 0; break;
         }
      }
      
   }
   public int getSeverity(String affliction)
   {  
      switch(affliction)
      {
         case "Burning": return 1;
         case "Drain": return this.Drain;
         case "Exhaustion": return this.Exhaustion;
         case "Frozen": return 1;
         case "Poisoned": return this.Poisoned;
         case "OG Poisoned": return this.OG_Poisoned;
         case "Slag": return this.Slag;
         case "Slow": return this.Slow;
         case "Blessed": return this.Blessed;
         case "Haste": return this.Haste;
         case "Leech": return this.Leech;
         case "Relaxed": return this.Relaxed;
      }
      return 0;
   }
   public boolean [] checkDamageAffliction(int x,boolean [] result)
   {
      if(x >= 6 || x <= -1)
         return result;
      //Check for Acid,Burning,Drain,Frozen,OG Poison, and OG Poisoned
      switch(x)
      {
         case 0: if(this.Acid == true) result[0] = true; break; //Is there Acid?
         case 1: if(this.Burning == true) result[1] = true; break; //Is there Burning?
         case 2: if(this.Drain != 0) result[2] = true; break; //Is there Drain?
         case 3: if(this.Frozen == true)result [3] = true; break; //Is there Frozen?
         case 4: if(this.Poisoned != 0)result[4] = true; break; //Is there Poisoned?
         case 5: if(this.OG_Poisoned != 0)result[5] = true; break; //Is there OG Poisoned;
      }
      return checkDamageAffliction(x+1,result);
   }
   public void applyBooleanAffliction(String name, boolean remove)
   {
      //Barrier,Stasis,Time_Freeze,Inspired,Leech,Protect; 
      if(remove == false)
      {
         switch(name)
         {  
            case "Acid": this.Acid = true; break;
            case "Blind": this.Blind = true; break;
            case "Bound": this.Bound = true; break;
            case "Burning": this.Burning = true; break;
            case "Cursed": this.Cursed = true; break;
            case "Dead Magic": this.Dead_Magic = true; break;
            case "Doomed": this.Doomed = true; break;
            case "Enrage": this.Enraged = true; break;
            case "Frozen": this.Frozen = true; break;
            case "Intoxicated": this.Intoxicated = true; break;
            case "Panicking": this.Panicking = true; break;
            case "Paralyzed": this.Paralyzed = true;break;
            case "Possessed": this.Possessed = true; break;
            case "Barrier": this.Barrier = true; break;
            case "Stasis": this.Stasis = true; break;
            case "Time_Freeze": this.Time_Freeze = true; break;
            case "Inspired": this.Inspired = true; break;
            case "Protect": this.Protect = true; break;
            case "Mire": this.Mire = true; break;
            case "Weakened": this.Weakened = true; break;
            case "Bull Call": this.BullCall = true; break;
            case "Confusion": this.Confusion = true; break;
            case "Sapped": this.Sapped = true; break;
         }
      }else
      {
         switch(name){   
            case "Acid": this.Acid = false; break;
            case "Blind": this.Blind = false; break;
            case "Bound": this.Bound = false; break;
            case "Burning": this.Burning = false; break;
            case "Cursed": this.Cursed = false; break;
            case "Dead Magic": this.Dead_Magic = false; break;
            case "Doomed": this.Doomed = false; break;
            case "Enrage": this.Enraged = false; break;
            case "Frozen": this.Frozen = false; break;
            case "Intoxicated": this.Intoxicated = false; break;
            case "Panicking": this.Panicking = false; break;
            case "Paralyzed": this.Paralyzed = false; break;
            case "Possessed": this.Possessed = false; break;
            case "Barrier": this.Barrier = false; break;
            case "Stasis": this.Stasis = false; break;
            case "Time_Freeze": this.Time_Freeze = false; break;
            case "Inspired": this.Inspired = false; break;
            case "Protect": this.Protect = false; break;
            case "Mire": this.Mire = false; break;
            case "Weakened": this.Weakened = false; break;
            case "Bull Call": this.BullCall = false; break;
            case "Confusion": this.Confusion = false; break;
            case "Sapped": this.Sapped = false; break;
      }
      }
   }
}