package Character;
import java.io.*;
import java.util.*;
import information.error;
import Character.Attribute;
import Character.Equipment;
import Character.Capability;
import Character.Affliction;
import affliction.afflictionInfo;
public class Playable
{
   private String Name,Type;
   private Attribute Attribute;
   private Capability Capability;
   private Equipment Equipment;
   private Affliction Affliction;
   private boolean alive,knockedout;
   public Playable(String name) throws FileNotFoundException
   {
      this.Name = information.
      error.checkFileName(name,new Scanner(System.in));
      this.Type = files.getType(this.Name);
      this.alive = true;
      this.knockedout = false;
      this.Attribute = new Attribute(this.Name);
      this.Affliction = new Affliction();
      this.Capability = new Capability(this.Name);
      this.Equipment = new Equipment(files.getEquipment(this.Name),this.Name);
   }
   public String getArchetype(){return this.Type;}
   public void limitCheck(Random r,Scanner kb)
   {
      if(this.alive == true || this.knockedout == true)
      {
         int minimum = 100 - (getAttribute("Limit")/2);//If a Limit is at 50, it'll be 25... meaning the player must roll a 75 or higher to survive.
         System.out.println(this.Name + " is about to die, roll d100: ");
         int roll = kb.nextInt(); kb.nextLine();
         roll += getAttribute("Limit");
         if(minimum <= roll)
         {
            System.out.println(this.Name + " survives with 1 HP");
            survived();
         }
         else
         {
            System.out.println(this.Name + " has failed the first d100 roll, please roll one last time: ");
            roll = kb.nextInt(); kb.nextLine();
            if(roll >= 50)
            {
               System.out.println(this.Name + " is knocked out...");
               this.knockedout = true;
            }
            else
            {
               System.out.println(this.Name + " has suffered a final death...");
               this.alive = false;
            }
         }
      }
   }
   public int getElementalResistance(String resistance){return Equipment.getElementalResistance(resistance);}
   public boolean checkAlive(){return this.alive;}
   public boolean checkKnockedOut(){return this.knockedout;}
   public String getType(){return this.Type;}
   public void takeDamage(int damage){Attribute.takeDamage(damage);}
   public void recoverHP(int HP){Attribute.recoverHP(HP);}
   public void survived(){Attribute.survived();}
   public String getName(){return this.Name;}
   public int getAttribute(String att){return information.error.attributeCheck(Attribute.getAttribute(att) + Equipment.getBonus(att));}
   public Playable applyAffliction(Playable character,String affliction,boolean remove){return afflictionInfo.applyAffliction(character,affliction,remove);}
   public void changeAttribute(String attribute, int rate){Attribute.changeAttribute(attribute,rate);}
   public int getBonus(String attribute){return Equipment.getBonus(attribute);}
   public void changeBonus (String attribute,int rate,boolean remove){Equipment.changeBonus(attribute,rate,remove);}
   public String[] getWeaponPro(){return Capability.getWeaponPro();}
   public String[] getHandtoHand(){return Capability.getHandtoHand();}
   public String[] getMagicType(){return Capability.getMagicType();}
   public String printHP(){return Attribute.printHP();}
   public int dodgeAttack(){return Attribute.dodgeAttack() + Equipment.getBonus("Speed") + Equipment.getBonus("Luck");}
   public int physicalAttack(){return Attribute.physicalAttack() + Equipment.getBonus("Skill") + Equipment.getBonus("Luck");}
   public int magicalAttack(){return Attribute.magicalAttack() + Equipment.getBonus("Magic") + Equipment.getBonus("Luck");}
   public int damageResistance(int DMG, String Element){return Equipment.damageResistance(DMG,Element);}
   public void applyIntAffliction(String name, boolean remove){Affliction.applyIntAffliction(name,remove);}
   public void applyBooleanAffliction(String name, boolean remove){Affliction.applyBooleanAffliction(name,remove);}
   public String checkAffliction(){return Affliction.checkAffliction();}
   public boolean [] checkDamageAffliction(int x, boolean [] type){return Affliction.checkDamageAffliction(x,type);}
   public boolean checkProtect(){return Affliction.checkProtect();}
   public boolean checkBarrier(){return Affliction.checkBarrier();}
   public boolean checkEnraged(){return Affliction.checkEnraged();}
   public boolean checkParalyzed(){return Affliction.checkParalyzed();}
   public boolean checkBlind(){return Affliction.checkBlind();}
   public boolean checkBullCall(){return Affliction.checkBullCall();}
   public boolean checkFrozen(){return Affliction.checkFrozen();}
   public boolean checkSapped(){return Affliction.checkSapped();}
   public int getSeverity(String name){return Affliction.getSeverity(name);}
   public void removeHat(){Equipment.removeHat();}
   public void removeArmor(){Equipment.removeArmor();}
   public void removeAccessory1(){Equipment.removeAccessory1();}
   public void removeAccessory2(){Equipment.removeAccessory2();}
   public void removeAccessory3(){Equipment.removeAccessory3();}
   public void addHat(String name){Equipment.addHat(name);}
   public void addArmor(String name){Equipment.addArmor(name);}
   public void addAccessory1(String name){Equipment.addAccessory1(name);}
   public void addAccessory2(String name){Equipment.addAccessory2(name);}
   public void addAccessory3(String name){Equipment.addAccessory3(name);}
   public void changeResistance(String element,int rate,boolean remove){Equipment.changeResistance(element,rate,remove);}
   public String printEquipment(){return Equipment.printEquipment();}
   public void removeEquipment(final String name){Equipment.removeEquipment(name);}
   public void addEquipment(final String name){Equipment.addEquipment(name);}
   public void printStat(Scanner kb)
   {
      
      System.out.println("\n--- " + this.Name + " Status ---\n");
      System.out.println("HP: " + printHP());
      System.out.println("Condition: " + checkAffliction());
      if(getAttribute("Force") == 0)
      { 
         System.out.println("Strength: " + getAttribute("Strength") + " || Defense: " + getAttribute("Defense") + " || Magic: " + getAttribute("Magic") + " || Resistance: " + getAttribute("Resistance"));
         System.out.println("Constituiton: " + getAttribute("Constitution") + " || Speed: " + getAttribute("Speed") + " || Skill: " + getAttribute("Skill") + " || Limit: " + getAttribute("Limit"));
         System.out.println("Intelligence: " + getAttribute("Intelligence") + " || Instinct: " + getAttribute("Instinct") + " || Luck: " + getAttribute("Luck"));
      }
      else
      {
         System.out.println("Strength: " + getAttribute("Strength") + " || Defense: " + getAttribute("Defense") + " || Force: " + getAttribute("Force") + " || Resistance: " + getAttribute("Resistance"));
         System.out.println("Constituiton: " + getAttribute("Constitution") + " || Speed: " + getAttribute("Speed") + " || Skill: " + getAttribute("Skill") + " || Limit: " + getAttribute("Limit"));
         System.out.println("Intelligence: " + getAttribute("Intelligence") + " || Instinct: " + getAttribute("Instinct") + " || Luck: " + getAttribute("Luck"));
      }
      System.out.println("\n--- Equipment ---");
      System.out.println(printEquipment());
      System.out.println("\n Enter any key to exit");
      kb.nextLine();
   }
   public String getArmor(){return Equipment.getArmor();}
   public boolean checkPhysicalCrit(Playable attacker, Playable target, int atkRoll, int defRoll)
   {
      if(atkRoll - attacker.getAttribute("Skill") - attacker.getAttribute("Luck") == 20)
         return true;
      else
      {
         int atk = (atkRoll - attacker.getAttribute("Skill"))/2;
         int def = defRoll - attacker.getAttribute("Speed");
         return atk > def;
      }
   }
   public boolean checkMagicCrit(Playable attacker, Playable target, int atkRoll, int defRoll)
   {
      if(atkRoll - attacker.getAttribute("Magic") - attacker.getAttribute("Luck") == 20)
         return true;
      else
      {
         int atk = (atkRoll - attacker.getAttribute("Magic"))/2;
         int def = defRoll - attacker.getAttribute("Speed");
         return atk > def;
      }
   }
   public boolean checkBlessed(){return Affliction.checkBlessed();}
}