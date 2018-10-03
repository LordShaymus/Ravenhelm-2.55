package Character;
import Character.Resistance;
import Character.Bonus;
import java.io.*;
public class Equipment
{
   private String Hat,Armor,Accessory1,Accessory2,Accessory3;
   private Bonus Bonus;
   private Resistance Resistance;
   public Equipment(final String [] equipment, final String name) throws FileNotFoundException
   {  
      this.Hat = equipment[0];
      this.Armor = equipment[1];
      this.Accessory1 = equipment[2];
      this.Accessory2 = equipment[3];
      this.Accessory3 = equipment[4];
      String [] Equipment = {this.Hat,this.Armor,this.Accessory1,this.Accessory2,this.Accessory3};
      this.Resistance = new Resistance(Equipment,name);
      this.Bonus = new Bonus(Equipment);
   }
   public String getHat(){return this.Hat;}
   public void removeHat(){
   removeEquipment(this.Hat);
   this.Hat = "";
   }
   public void addHat(String name)
   {
      removeEquipment(this.Hat);
      this.Hat = name;
      addEquipment(name);
   }
   public String getArmor(){return this.Armor;}
   public void removeArmor(){
   removeEquipment(this.Armor);
   this.Armor = "";
   }
   public void addArmor(String name)
   {
      removeEquipment(this.Armor);
      this.Armor = name;
      addEquipment(name);
   }
   public String getAccessory1(){return this.Accessory1;}
   public void removeAccessory1(){
   removeEquipment(this.Accessory1);
   this.Accessory1 = "";
   }
   public void addAccessory1(String name)
   {
      removeEquipment(this.Accessory1);
      this.Accessory1 = name;
      addEquipment(name);
   }
   public String getAccessory2(){return this.Accessory2;}
   public void removeAccessory2(){
   removeEquipment(this.Accessory2);
   this.Accessory2 = "";
   }
   public void addAccessory2(String name)
   {
      removeEquipment(this.Accessory2);
      this.Accessory2 = name;
      addEquipment(name);
   }
   public String getAccessory3(){return this.Accessory3;}
   public void removeAccessory3(){
      removeEquipment(this.Accessory3);
      this.Accessory3 = "";
   }
   public void addAccessory3(String name)
   {
      removeEquipment(this.Accessory3);
      this.Accessory3 = name;
      addEquipment(name);
   }
   public int damageResistance(int DMG, String Element){return Resistance.damageResistance(DMG,Element);}
   public int getBonus(String att){return Bonus.getBonus(att);}
   public void changeBonus(String att,int rate,boolean remove){Bonus.changeBonus(att,rate,remove);}
   public String printEquipment(){return "Hat: " + this.Hat + "\nArmor: " + this.Armor + "\nAccessory 1: " + this.Accessory1 + "\nAccessory 2: " + this.Accessory2 + "\nAccessory 3: " + this.Accessory3;}
   public void removeEquipment(final String name)
   {
      String [] att = affliction.resistance.equipStatChange(name);
      String [] ele = affliction.resistance.equipResistanceChange(name);
      for(int x = 0; x < att.length;x++)
         Bonus.changeBonus(att[x],affliction.resistance.equipStat(name,"","","","",att[x],0,0),true);
      for(int x = 0; x < ele.length;x++)
         Resistance.changeResistance(ele[x],affliction.resistance.equipResistance(name,"","","","",ele[x],0,0),true);
   }
   public void addEquipment(final String name)
   {
      String [] att = affliction.resistance.equipStatChange(name);
      String [] ele = affliction.resistance.equipResistanceChange(name);
      for(int x = 0; x < att.length;x++)
         Bonus.changeBonus(att[x],affliction.resistance.equipStat(name,"","","","",att[x],0,0),false);
      for(int x = 0; x < ele.length;x++)
         Resistance.changeResistance(ele[x],affliction.resistance.equipResistance(name,"","","","",ele[x],0,0),false);
   }
   public void changeResistance(String element,int rate, boolean remove){Resistance.changeResistance(element,rate,remove);}
   public int getElementalResistance(String resistance){return Resistance.getElementalResistance(resistance);}
}