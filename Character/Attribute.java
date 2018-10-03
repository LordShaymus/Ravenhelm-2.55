package Character;
import java.io.*;
import Character.Equipment;
public class Attribute
{
   private int HP,Max_HP,Strength,Defense,Magic,Resistance,Constitution,Speed,Skill,Limit,Intelligence,Instinct,Luck,Force;
   public Attribute(String name) throws FileNotFoundException
   {
      this.HP = setAttribute("HP",this.HP,name);
      this.Max_HP = setAttribute("Max HP",this.Max_HP,name);
      this.Strength = setAttribute("Strength",this.Strength,name);
      this.Defense = setAttribute("Defense",this.Defense,name);
      this.Magic = setAttribute("Magic",this.Magic,name);
      this.Resistance = setAttribute("Resistance",this.Resistance,name);
      this.Constitution = setAttribute("Constitution",this.Constitution,name);
      this.Speed = setAttribute("Speed",this.Speed,name);
      this.Skill = setAttribute("Skill",this.Skill,name);
      this.Limit = setAttribute("Limit",this.Limit,name);
      this.Intelligence = setAttribute("Intelligence",this.Intelligence,name);
      this.Instinct = setAttribute("Instinct",this.Instinct,name);
      this.Luck = setAttribute("Luck",this.Luck,name);
      this.Force = setAttribute("Force",this.Force,name);
      
   }
   public int setAttribute(String att,int pts,final String name) throws FileNotFoundException
   {
      if(pts == 0)
          return files.getStat(name,att);
      else
         return pts;
   }
   public void changeAttribute(String att,int rate)
   {
      switch(att)
      {
         case "HP": this.HP =  this.HP + rate; break;
         case "Strength":  this.Strength = this.Strength + rate; break;
         case "Defense": this.Defense = this.Defense + rate;  break;
         case "Magic": this.Magic = this.Magic + rate; break;
         case "Resistance": this.Resistance = this.Resistance + rate; break;
         case "Constitution": this.Constitution = this.Constitution + rate; break;
         case "Speed": this.Speed = this.Speed + rate; break;
         case "Skill": this.Skill = this.Skill + rate; break;
         case "Limit": this.Limit = this.Limit + rate; break;
         case "Intelligence": this.Intelligence = this.Intelligence + rate; break;
         case "Instinct": this.Instinct = this.Instinct + rate; break;
         case "Luck": this.Luck = this.Luck + rate; break;
         case "Force": this.Force = this.Force + rate; break;  
      }
   }
   public int getMaxHP(){return this.Max_HP;}
   public void survived(){this.HP = 1;}
   public int getAttribute(String att){
      switch(att)
      {
         case "HP":  return this.HP;
         case "Max HP": return this.Max_HP;
         case "Strength":  return this.Strength;
         case "Defense": return this.Defense;
         case "Magic": return this.Magic;
         case "Resistance": return this.Resistance;
         case "Constitution": return this.Constitution;
         case "Speed": return this.Speed;
         case "Skill": return this.Skill;
         case "Limit": return this.Limit;
         case "Intelligence": return this.Intelligence;
         case "Instinct": return this.Instinct;
         case "Luck": return this.Luck;
         case "Force": return this.Force;
      }
      return 0;
   }
   public void takeDamage(int damage){this.HP = this.HP - damage;}
   public void recoverHP(int HP){this.HP = this.HP + HP;}
   public String printHP(){return this.HP + "/" + this.Max_HP;}
   public int dodgeAttack(){return this.Luck + this.Luck;}
   public int physicalAttack(){return this.Skill + this.Luck;}
   public int magicalAttack(){return this.Magic + this.Luck;}
}