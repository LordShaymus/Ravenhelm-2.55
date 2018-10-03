package Character;
import Character.files;
import java.io.*;
import Character.Equipment;
public class Resistance
{
   private int Fire,Water,Earth,Wind,Ice,Electricity,Acid,Poison,Slag,Holy,Curse,ESP,Other,Projectile;
   public Resistance(String [] Equipment,String name) throws FileNotFoundException
   {
      this.Fire = setResistance(this.Fire,"Fire",Equipment, name);
      this.Water = setResistance(this.Water,"Water",Equipment, name);
      this.Earth = setResistance(this.Earth,"Earth",Equipment, name);
      this.Wind = setResistance(this.Wind,"Wind",Equipment, name);
      this.Ice = setResistance(this.Ice,"Ice",Equipment, name);
      this.Electricity = setResistance(this.Electricity,"Electricity",Equipment, name);
      this.Acid = setResistance(this.Acid,"Acid",Equipment, name);
      this.Poison = setResistance(this.Poison,"Poison",Equipment, name);
      this.Slag = setResistance(this.Slag,"Slag",Equipment, name);
      this.Holy = setResistance(this.Holy,"Holy",Equipment, name);
      this.Curse = setResistance(this.Curse,"Curse",Equipment, name);
      this.ESP = setResistance(this.ESP,"ESP",Equipment, name);
      this.Other = setResistance(this.Other,"Other",Equipment, name);
      //this.Projectile = setResistance(this.Other,"Projectile",Equipment,name);
   }
   public int setResistance(int pts, String att,String [] Equipment,String name) throws FileNotFoundException
   {  
      String Hat = Equipment[0];
      String Armor = Equipment[1];
      String Accessory1 = Equipment[2];
      String Accessory2 = Equipment[3];
      String Accessory3 = Equipment[4];
      if(pts == 0)
         return affliction.resistance.equipResistance(Hat,Armor,Accessory1,Accessory2,Accessory3,att,0,pts) + files.getResistanceBouns(name,att);
      else
         return pts;
   }
   public int damageResistance(int DMG, String element)
   {
      double percentage = 0;
      int base = 0;
      switch (element)
      {
         case "Fire": base = this.Fire; break;
         case "Water": base = this.Water; break;
         case "Earth": base = this.Earth; break;
         case "Wind": base = this.Wind; break;
         case "Ice": base = this.Ice; break;
         case "Electricity": base = this.Electricity; break;
         case "Acid": base = this.Acid; break;
         case "Poison": base = this.Poison; break;
         case "Slag": base = this.Slag; break;
         case "Holy": base = this.Holy; break;
         case "Curse": base = this.Curse; break;
         case "ESP": base = this.ESP; break;
         case "Other": base = this.Other; break;
         case "Projectile": base = this.Projectile; break;
         
      }
      percentage = base * 0.01;
      return (int)(DMG * percentage);
   }
   public void changeResistance(String element, int rate, boolean remove)
   {
      if(remove == true)
      {
         rate = rate * -1;
      }
      switch(element){
         case "Fire": this.Fire = this.Fire + rate; break;
         case "Water": this.Water = this.Water + rate; break;
         case "Earth": this.Earth = this.Earth + rate; break;
         case "Wind": this.Wind = this.Wind + rate; break;
         case "Ice": this.Ice = this.Ice + rate; break;
         case "Electricity": this.Electricity = this.Electricity + rate; break;
         case "Acid":  this.Acid = this.Acid = rate; break;
         case "Poison": this.Poison = this.Poison + rate; break;
         case "Slag": this.Slag = this.Slag + rate; break;
         case "Holy": this.Holy = this.Holy + rate; break;
         case "Curse": this.Curse = this.Curse + rate; break;
         case "ESP": this.ESP = this.ESP + rate; break;
         case "Other": this.Other = this.Other + rate; break;
      }
   }
   public int getElementalResistance(final String element)
   {
      switch(element){
         case "Fire": return this.Fire;
         case "Water": return this.Water;
         case "Earth": return this.Earth;
         case "Wind": return this.Wind;
         case "Ice": return this.Ice;
         case "Electricity": return this.Electricity;
         case "Acid":  return this.Acid;
         case "Poison": return this.Poison;
         case "Slag": return this.Slag;
         case "Holy": return this.Holy;
         case "Curse": return this.Curse;
         case "ESP": return this.ESP;
      }
      return 0;
      
   }
}