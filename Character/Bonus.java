package Character;
import Character.Equipment;
public class Bonus
{
   private int Max_HP,Strength,Defense,Magic,Resistance,Constitution,Speed,Skill,Limit,Intelligence,Instinct,Luck,Bonus,Force;
   public Bonus(String [] equip)
   {
      this.Max_HP = setAtt(this.Max_HP,"Max HP",equip);
      this.Strength = setAtt(this.Strength,"Strength",equip);
      this.Defense = setAtt(this.Defense,"Defense",equip);
      this.Magic = setAtt(this.Magic,"Magic",equip);
      this.Resistance = setAtt(this.Resistance,"Resistance",equip);
      this.Constitution = setAtt(this.Constitution,"Constitution",equip);
      this.Speed = setAtt(this.Speed,"Speed",equip);
      this.Skill = setAtt(this.Skill,"Skill",equip);
      this.Limit = setAtt(this.Limit,"Limit",equip);
      this.Intelligence = setAtt(this.Intelligence,"Intelligence",equip);
      this.Luck = setAtt(this.Luck,"Luck",equip);
      this.Force = setAtt(this.Force,"Force",equip);
      this.Bonus = setAtt(this.Bonus,"Bonus",equip);
   }
   public int setAtt(int pts, String att, String [] Equipment)
   {
      String Hat = Equipment[0];
      String Armor = Equipment[1];
      String Accessory1 = Equipment[2];
      String Accessory2 = Equipment[3];
      String Accessory3 = Equipment[4];
      if(pts == 0)
         return affliction.resistance.equipStat(Hat,Armor,Accessory1,Accessory2,Accessory3,att,0,pts);
      else
         return pts;  
   }
   public int getBonus(String att)
   {
      switch(att){
      case "Max HP": return this.Max_HP;
      case "Strength": return this.Strength;
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
      case "Bonus": return this.Bonus;
      case "Force": return this.Force;
      }
      return 0;
   }
   public void changeBonus(String att, int rate, boolean remove)
   {
      if(remove == true)
      {
         rate = rate * -1;
      }
         switch(att){
         case "Max HP": this.Max_HP = this.Max_HP + rate; break;
         case "Strength": this.Strength = this.Strength + rate; break;
         case "Defense": this.Defense = this.Defense + rate; break;
         case "Magic": this.Magic = this.Magic + rate; break;
         case "Resistance": this.Resistance = this.Resistance + rate; break;
         case "Constitution": this.Constitution =  this.Constitution + rate; break;
         case "Speed": this.Speed =  this.Speed + rate; break;
         case "Skill": this.Skill =  this.Skill + rate; break;
         case "Limit": this.Limit =  this.Limit + rate; break;
         case "Intelligence": this.Intelligence =  this.Intelligence + rate; break;
         case "Instinct": this.Instinct =  this.Instinct + rate; break;
         case "Luck": this.Luck = this.Luck + rate; break;
         case "Bonus": this.Bonus = this.Bonus + rate; break;
         case "Force": this.Force = this.Force + rate; break;
      }
   }
}