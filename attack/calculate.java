package attack;
import java.io.*;
import java.util.*;
import Character.Playable;
import Weapon.Weapon;
import Weapon.handToHand;
import Weapon.AttackMagic;
import Weapon.Force;
public class calculate
{
   public static Playable [] afflictionDamage(Playable [] characters, final Scanner kb) throws FileNotFoundException
   {
      System.out.print("Enter the character's name: ");
      Playable name = information.gather.isInBattle(new Playable(kb.nextLine()),characters);
      System.out.print("Enter the affliction: ");
      String effect = kb.nextLine();
      System.out.print("Enter the severity for " + effect + ": ");
      int severity = kb.nextInt(); kb.nextLine();
      int DMG = 0,DMGRES = 0, Max_HP = name.getAttribute("Max HP"), Constitution = name.getAttribute("Constitution");
      String element = "";
      System.out.println("\n--- Result ---\n");
      //All effects follow this formula ((Max HP * percentage) * severity) - (Constitution/5)
      switch (effect)
      {
         case "Burning": DMG = (int)(Max_HP * 0.15) * severity; element = "Fire"; break;
         case "Poisoned": DMG = (int)(Max_HP * 0.10) * severity; element = "Poison"; break;
         case "OG Poisoned": DMG = (int)(Max_HP * 0.15) * severity; element = "Poison"; break;
         case "Acid": DMG = (int)(Max_HP * 0.20) * severity;  element = effect; break;
         case "Frozen": DMG = (int)(Max_HP * 0.05) * severity; element = "Ice"; break;
         case "Blessed": DMG = (int)(Max_HP * 0.07) * severity; element = ""; break;
         case "Drain": DMG = (int)(Max_HP * 0.10)* severity; element = ""; break;
      }
      int elementResistance = name.getElementalResistance(element);
      if(elementResistance != 0)
         DMGRES = (int)(DMG * (elementResistance * 0.01));
      DMG = DMG - DMGRES;
      if(effect.equals("Blessed"))
      {
         DMG += Constitution;
         System.out.println(name.getName() + " recovers " + DMG + " HP!");
      }
      else
      {
         DMG = DMG - (Constitution /5);
         System.out.println(name.getName() + " takes " + DMG + " damage!");
      }
      return characters;
      
   }
   public static boolean [] physicalAccuracy(final Playable attacker, final int atkRoll, final Playable [] targets, final int [] defRoll, final Weapon weapon)
   {
      //Accuracry is determined by atkRoll + atkSkill + atkLuck + atkBonus vs. defRoll + defSpeed + defLuck + defBonus
      boolean [] hits = new boolean[targets.length];
      Random r = new Random();
      int atkSkill = attacker.getAttribute("Skill"), atkLuck = attacker.getAttribute("Luck"), atkBonus = attacker.getAttribute("Bonus");
      int atk = atkRoll + atkSkill + atkLuck + atkBonus;
      if(attacker.checkBlind() == true)//If a character is blind, their total is reduced by 50%
         atk = atk/2;
      if(attacker.checkParalyzed() == true)//If a character is paralyzed, they have a 40% chance of doing nothing
      {
         int paralyzedRoll = r.nextInt(100)+1;
         if(paralyzedRoll > 60)
         {
            System.out.println(attacker.getName() + " is unable to attack...");
            atk = 0;
         }
      }
      if(attacker.checkFrozen() == true)//A character cannot attack if they are frozen.
         atk = 0;
      System.out.println(attacker.getName() + ": " + atk);
      for(int x = 0; x < targets.length; x++)
      {
         int defSpeed = targets[x].getAttribute("Speed"), defLuck = targets[x].getAttribute("Luck"), defBonus = targets[x].getAttribute("Bonus");
         int def = defRoll[x] + defSpeed + defLuck + defBonus;
         if(targets[x].checkFrozen() == true) //A target cannot move when frozen
            def = 0;
         System.out.println(targets[x].getName() + ": " + def);
         if(weapon.getProjectile() == true)
         {
            def += special.dodge.evasion(targets[x],weapon.getMagical(),weapon.getProjectile());
         }
         if(atk > def || atkRoll == 20)
            hits[x] = true;
         else if(atk < def || defRoll[x] == 20)
            hits[x] = false;
      }
      return hits;
   }
   public static boolean [] physicalAccuracy(final Playable attacker, final int atkRoll, final Playable [] targets, final int [] defRoll) //For handToHand combat
   {
      //Accuracry is determined by atkRoll + atkSkill + atkLuck + atkBonus vs. defRoll + defSpeed + defLuck + defBonus
      boolean [] hits = new boolean[targets.length];
      Random r = new Random();
      int atkSkill = attacker.getAttribute("Skill"), atkLuck = attacker.getAttribute("Luck"), atkBonus = attacker.getAttribute("Bonus");
      int atk = atkRoll + atkSkill + atkLuck + atkBonus;
      if(attacker.checkParalyzed() == true || attacker.checkFrozen() == true)//A paralyzed or frozen character cannot preform hand to hand attacks
         atk = 0;
      if(attacker.checkBlind() == true)//If a character is blind, their total is reduced by 50%
         atk = atk/2;
      System.out.println(attacker.getName() + ": " + atk);
      for(int x = 0; x < targets.length; x++)
      {
         int defSpeed = targets[x].getAttribute("Speed"), defLuck = targets[x].getAttribute("Luck"), defBonus = targets[x].getAttribute("Bonus");
         int def = defRoll[x] + defSpeed + defLuck + defBonus;
         if(targets[x].checkFrozen() == true) //A target cannot move when frozen
            def = 0;
         System.out.println(targets[x].getName() + ": " + def);
         if(atk > def || atkRoll == 20)
            hits[x] = true;
         else if(atk < def || defRoll[x] == 20)
            hits[x] = false;
      }
      return hits;
   }
   public static boolean [] forceAccuracy(final Playable attacker, final int atkRoll, final Playable [] targets, final int [] defRoll, final Force force)
   {
      //Force attacks are determined by atkRoll + Force + Magic vs defRoll + Speed + Luck
      boolean [] hits = new boolean[targets.length];
      Random r = new Random();
      int Force = attacker.getAttribute("Force"), Luck = attacker.getAttribute("Luck");
      int atk = atkRoll + Force + Luck;
      if(attacker.checkBlind() == true)//If a character is blind, their total is reduced by 50%
         atk = atk/2;
      if(attacker.checkParalyzed() == true || attacker.checkFrozen() == true)//A non-magic user cannot preform force abilities if they are frozen or paralyzed
      {   
         System.out.println(attacker.getName() + " is unable to attack...");
         atk = 0;
      }
      System.out.println(attacker.getName() + ": " + atk);
      for(int x = 0; x < targets.length; x++)
      {
         int Speed = targets[x].getAttribute("Speed"), defLuck = targets[x].getAttribute("Luck");
         int def = defRoll[x] + Speed + defLuck;
         if(targets[x].checkFrozen() == true) //A target cannot move when frozen
            def = 0;
         System.out.println(targets[x].getName() + ": " + def);
         if(atk > def || atkRoll == 20)
         {
            hits[x] = true;
         }
         else if(atk < def || defRoll[x] == 20)
            hits[x] = false;
      }
      return hits;
   }
   public static boolean [] magicAccuracy(final Playable attacker, final int atkRoll, final Playable [] targets, final int [] defRoll, final AttackMagic spell)
   {
      //Spell accuaracy are determined by atkRoll + Magic + Luck vs defRoll + Speed + Luck
      boolean [] hits = new boolean[targets.length];
      Random r = new Random();
      int Magic = attacker.getAttribute("Magic"), Luck = attacker.getAttribute("Luck");
      int atk = atkRoll + Magic + Luck;
      if(attacker.checkBlind() == true)//If a character is blind, their total is reduced by 50%
         atk = atk/2;
      if(attacker.checkParalyzed() == true)//If a character is paralyzed, they have a 40% chance of doing nothing
      {
         int paralyzedRoll = r.nextInt(99)+1;
         if(paralyzedRoll > 60)
         {
            System.out.println(attacker.getName() + " is unable to attack...");
            atk = 0;
         }
      }
      if(attacker.checkFrozen() == true)//A character cannot attack if they are frozen.
         atk = 0;
      System.out.println(attacker.getName() + ": " + atk);
      for(int x = 0; x < targets.length; x++)
      {
         int Speed = targets[x].getAttribute("Speed"), defLuck = targets[x].getAttribute("Luck");
         int def = defRoll[x] + Speed + defLuck;
         if(spell.getProjectile() == true)
         {
            def += special.dodge.evasion(targets[x],true,spell.getProjectile());
         }
         if(targets[x].checkFrozen() == true) //A target cannot move when frozen
            def = 0;
         System.out.println(targets[x].getName() + ": " + def);
         if(atk > def || atkRoll == 20)
         {
            hits[x] = true;
         }
         else if(atk < def || defRoll[x] == 20)
            hits[x] = false;
      }
      return hits;
   }
   public static boolean instinctRate(Playable character,boolean counter)
   {
      if(counter == true)//An enemy being counter cannot counter the attacker who is counter... redundant much?
         return false;
      //Counter's mimimum is determined by 100 - (Instinct + (Instinct/4 or 125%)) vs d100
      //Dice Roll must beat the Instinct pts to activate
      Random r = new Random();
      int Instinct = character.getAttribute("Instinct");
      int mimimum = 100 - (Instinct + (Instinct/4));
      int roll = r.nextInt(99)+1;
      if(roll >= mimimum && character.checkFrozen() == false)//Frozen characters cannot counter
         return true;
      else
         return false;
   }
   public static Playable [] getPhysicalDamage(Playable [] characters, final Playable attacker, final int atkRoll, Playable target, final int defRoll, final Weapon weapon, final boolean Instinct)
   {
      //Damage is calculated by (Strength/Skill + DiceRoll + Base - Defense) * (elementalResistance * 0.01)
      Random r = new Random();
      int Strength = attacker.getAttribute("Strength"), Skill = attacker.getAttribute("Skill"), Luck = attacker.getAttribute("Luck"), Defense = target.getAttribute("Defense"), defLuck = target.getAttribute("Luck");
      int DiceRoll = r.nextInt(weapon.getTypeRoll())+1, DMG = 0, Base = weapon.getBase(); 
      boolean projectile = weapon.getProjectile();
      if(projectile == true)
         DMG = Skill + DiceRoll + Base - Defense;
      else
         DMG = Strength + DiceRoll + Base - Defense; 
      if(attacker.checkSapped() == true && projectile == false)//Sapped reduces Strength to 0.
         DMG = DMG - Strength;
      if(attacker.checkEnraged() == true)//Enraged, while causing characters only to attack with melee, deals additional 1/4 of total damage.
         DMG = (int)(DMG * 1.25);
      DMG = special.damage.damageBonus(attacker,target,DMG,new Scanner(System.in));//There's a few attacks that are based on enemy types
      int elementResistance = target.getElementalResistance(weapon.getElement()), DMGRES = 0;
      if(elementResistance != 0)
         DMGRES = (int)(DMG * (elementResistance * 0.01));
      DMG = DMG - DMGRES;
      //The affliction Protect allows the target to take half damage of any phyiscal attack.
      if(target.checkProtect() == true)
         DMG = DMG/2;
      if(Instinct == true)//All Instinct attacks deal half damage
         DMG = DMG/2;
      if(target.getArmor().equals("Arrow-Proof Vest") && (weapon.getWeaponType().equals("Crossbow") || weapon.getWeaponType().equals("Bow")))//The armor Arrow-Proof Vest reduces arrow damage by 75%
      {
         DMGRES = (int)(DMG * 0.75);
         DMG = DMG - DMGRES;
      }
      if(target.checkFrozen() == true)//Frozen foes take only 1 damage per hit
         DMG = 1;
      DMG = calculateCrits(attacker,atkRoll,target,defRoll,DMG,weapon);
      //Affliction Check
      //Constitution Checks are determined by d100 - constitution >= 100 - rate
      if(!(weapon.getAffliction().isEmpty()) && special.dodge.afflictionSave(target,weapon.getAffliction()) == false)
      {
         int Constitution = target.getAttribute("Constitution"), rate = weapon.getRate(), roll = r.nextInt(99)+1;
         int mimimum = 100 - rate, total = roll - Constitution;
         if(total >= mimimum || rate >= 100)//This should negate bosses that have +100 Constitution with effects that are 100% guaranteed to happen
         {
            target.applyAffliction(target,weapon.getAffliction(),false);
            System.out.println(target.getName() + " is afflicted with " + weapon.getAffliction());
         }
      }
      if(DMG <= 0)//If the damage is too low, it'll always be 1.
         DMG = 1;
      //Print the results 
      System.out.println(target.getName() + " takes " + DMG + " damage!");
      if(DMGRES != 0)
         System.out.println(target.getName() + " resisted " + DMGRES + " damage!");
         
      characters = information.gather.changeCharacterInfo(target,characters); //Applies all changes to current characters.
      return characters;
   }
   public static Playable [] getPhysicalDamage(Playable [] characters, final Playable attacker, final int atkRoll, Playable target, final int defRoll, final handToHand handToHand, final boolean Instinct)
   {
      //Damage is calculated by (Strength/Skill + d8 + Base - Defense) * (elementalResistance * 0.01)
      Random r = new Random();
      int Strength = attacker.getAttribute("Strength"), Skill = attacker.getAttribute("Skill"), Luck = attacker.getAttribute("Luck"), Defense = target.getAttribute("Defense"), defLuck = target.getAttribute("Luck");
      int DMG = 0, Base = handToHand.getBase(), DiceRoll = r.nextInt(Base/2)+1; 
      boolean martial = handToHand.getMartial();
      if(martial == true)//Martial Arts attacks deal Skill Damage whereas others deal Strength damage
         DMG = Skill + DiceRoll + Base - Defense;
      else
         DMG = Strength + DiceRoll + Base - Defense;
      if(attacker.checkSapped() == true && martial == false)//Sapped takes away Strength
         DMG = DMG - Strength; 
      if(attacker.checkEnraged() == true)//Enraged, while causing characters only to attack with melee, deals additional 1/4 of total damage.
         DMG = (int)(DMG * 1.25);
      DMG = special.damage.damageBonus(attacker,target,DMG,new Scanner(System.in));//There's a few attacks that are based on enemy types
      //The affliction Protect allows the target to take half damage of any phyiscal attack.
      if(target.checkProtect() == true)
         DMG = DMG/2;
      if(Instinct == true)//All Instinct attacks deal half damage
         DMG = DMG/2;
      if(target.checkFrozen() == true)//Frozen foes take only 1 damage per hit
         DMG = 1;
      DMG = calculateCrits(attacker,atkRoll,target,defRoll,DMG,handToHand);
      //Affliction Check
      //No attacks deal affliction that aren't percentage.
      //Print the results 
      System.out.println(target.getName() + " takes " + DMG + " damage!");
      characters = information.gather.changeCharacterInfo(target,characters); //Applies all changes to current characters.
      return characters;
   }
   public static Playable [] getMagicDamage(Playable [] characters, final Playable attacker, final int atkRoll, Playable target, final int defRoll, final AttackMagic spell)
   {
      //Magic damage is calculated by (d12 + Magic + Base - Resistance)*(ElementalResistance * 0.01)
      Random r = new Random();
      int Magic = attacker.getAttribute("Magic"), Base = spell.getBase(), Roll = r.nextInt(Base/2)+1, Resistance = target.getAttribute("Resistance");
      int DMG = Roll + Magic + Base - Resistance;
      //The affliction Barrier allows characters to take half damage from all magical attacks
      if(target.checkBarrier() == true)
         DMG = DMG/2;
      int elementResistance = target.getElementalResistance(spell.getElement()), DMGRES = 0;
      if(elementResistance != 0)
         DMGRES = (int)(DMG * (elementResistance * 0.01));
      DMG = DMG - DMGRES;
      if(target.checkFrozen() == true)
      {
         if(spell.getElement().equals("Fire"))//Fire will remove Frozen entirely but deal only half damage
            {
               target.applyAffliction(target,"Frozen",true);
               DMG = DMG/2;
            }
         else //All other elements deals just 1 damage
            DMG = 1;
      }
      DMG = calculateCrits(attacker,atkRoll,target,defRoll,DMG,spell);
      //No spells are able to be countered.
      //Affliction Check
      //Constitution Checks are determined by d100 - constitution >= 100 - rate
      if(!(spell.getAffliction().isEmpty()) && special.dodge.afflictionSave(target,spell.getAffliction()) == false)
      {
         int Constitution = target.getAttribute("Constitution"), rate = spell.getRate(), roll = r.nextInt(99)+1;
         int mimimum = 100 - rate, total = roll - Constitution;
         if(total >= mimimum || rate >= 100)//This should negate bosses that have +100 Constitution with effects that are 100% guaranteed to happen
         {
            target.applyAffliction(target,spell.getAffliction(),false);
            System.out.println(target.getName() + " is afflicted with " + spell.getAffliction());
         }
      } //Print the results 
      System.out.println(target.getName() + " takes " + DMG + " damage!");
      if(DMGRES != 0)
         System.out.println(target.getName() + " resisted " + DMGRES + " damage!");
      characters = information.gather.changeCharacterInfo(target,characters); //Applies all changes to current characters.
      return characters;
   }
   public static Playable [] getForceDamage(Playable [] characters, final Playable attacker, final int atkRoll, Playable target, final int defRoll, final Force force)
   {
      //Damage is calculated by (Force + d8 + Base - Resistance/Defense) * (elementalResistance * 0.01)
      Random r = new Random();
      int Force = attacker.getAttribute("Force"), Skill = attacker.getAttribute("Skill"), Luck = attacker.getAttribute("Luck"), Resistance = target.getAttribute("Resistance"), defLuck = target.getAttribute("Luck"), Defense = target.getAttribute("Defense");
      int DMG = 0, Base = force.getBase(), DiceRoll = r.nextInt(Base/2)+1; 
      //Force's damage is based on whether or not it is physical or not, unlike Magic
      if(force.getNonPhysical() == true) 
         DMG = Force + DiceRoll + Base - Resistance;
      else
         DMG = Force + DiceRoll + Base - Defense; 
      if(attacker.checkEnraged() == true)//Enraged, while causing characters only to attack with melee, deals additional 1/4 of total damage.
         DMG = (int)(DMG * 1.25);
      DMG = special.damage.damageBonus(attacker,target,DMG,new Scanner(System.in));//There's a few attacks that are based on enemy types
      //The affliction Protect allows the target to take half damage of any phyiscal attack.
      if(target.checkProtect() == true && force.getNonPhysical() == false)
         DMG = DMG/2;
     else if(target.checkBarrier() == true && force.getNonPhysical() == true)
         DMG = DMG/2;
     if(target.checkFrozen() == true)//Force attacks only deal 1 damage when frozen
         DMG = 1;
      DMG = calculateCrits(attacker,atkRoll,target,defRoll,DMG,force);
      //Affliction Check
      if(!(force.getAffliction().isEmpty()) && special.dodge.afflictionSave(target,force.getAffliction()) == false)
      {
         int Constitution = target.getAttribute("Constitution"), rate = force.getRate(), roll = r.nextInt(99)+1;
         int mimimum = 100 - rate, total = roll - Constitution;
         if(total >= mimimum || rate >= 100)//This should negate bosses that have +100 Constitution with effects that are 100% guaranteed to happen
         {
            target.applyAffliction(target,force.getAffliction(),false);
            System.out.println(target.getName() + " is afflicted with " + force.getAffliction());
         }
      }
      //Print the results 
      System.out.println(target.getName() + " takes " + DMG + " damage!");
      characters = information.gather.changeCharacterInfo(target,characters); //Applies all changes to current characters.
      return characters;
   }
   public static int calculateCrits(final Playable attacker, final int atkRoll, final Playable target, final int defRoll, int DMG, Weapon weapon)
   {
      //Weapons
      int Luck = attacker.getAttribute("Luck"), defLuck = target.getAttribute("Luck");
      //OLD: Crits are determined by weaponCrit + (Luck/2) * atkModifier vs. 5 + Luck * evaModifier
      //Modifiers are created by 1 + (attackRoll/defenseRoll * 3%)
      //A critical hit is made when criticalRange is higher (not equal to) evasionRange
      //Inspired a bit by Fallout 3's and Fire Emblem's Critical Range concept
      double attackModifier = 1 + (atkRoll * 0.03), evasionModifier = 1 + (defRoll * 0.03);
      double criticalRange = weapon.getCritRange() + (Luck/2) * attackModifier;
      if(attacker.checkBullCall() == true)//The affliction Bull Call causes critical hit range to double when afflicted
         criticalRange = criticalRange * 2;
      double evasionRange = defLuck * evasionModifier;
      //OLD: int atkLuck = (atkRoll + Luck)/2, targetLuck = defRoll + defLuck;
      int tempDMG = DMG;//Used in case we need it for additional multipliers.
      double multiplier = 1.0;
      if(criticalRange > evasionRange || atkRoll == 20)
     {
            System.out.println("Critical Hit!");
            multiplier = 2.0;
            if(attacker.getName().equals("Soren") && weapon.checkSteel() == true)//Soren's lightning blade allows him to deal x3 damage on all bladed weapons
         {
            multiplier = 3.0;
         }
         if(weapon.getName().equals("boomerang sword"))//Boomerang Sword deals x3 damage when it crits
         {
            multiplier += 3.0;
         }
      }
      if(target.checkFrozen() == true)//Frozen foes are immune to crits
         multiplier = 1.0; 
      return (int)(DMG * multiplier);
   }
   public static int calculateCrits(final Playable attacker, final int atkRoll, final Playable target, final int defRoll, int DMG, handToHand handToHand)
   {
      //Hand To Hand
      int Luck = attacker.getAttribute("Luck"), defLuck = target.getAttribute("Luck");
      //OLD: Crits are determined by handToHandCrit + (Luck/2) * atkModifier vs. 5 + Luck * evaModifier
      //Modifiers are created by 1 + (attackRoll/defenseRoll * 3%)
      double attackModifier = 1 + (atkRoll * 0.03), evasionModifier = 1 + (defRoll * 0.03);
      double criticalRange = handToHand.getCritRange() + (Luck/2) * attackModifier;
      if(attacker.checkBullCall() == true)//The affliction Bull Call causes critical hit range to double when afflicted
         criticalRange = criticalRange * 2;
      double evasionRange = defLuck * evasionModifier;
      //OLD: int atkLuck = (atkRoll + Luck)/2, targetLuck = defRoll + defLuck;
      int tempDMG = DMG;//Used in case we need it for additional multipliers.
      double multiplier = 1.0;
      if(criticalRange > evasionRange || atkRoll == 20)
      {
            System.out.println("Critical Hit!");//Criticals makes 2.0 for crits
            multiplier += 1.0;
      } 
      if(target.checkFrozen() == true)//Frozen foes are immune to crits
         multiplier = 1.0; 
      return (int)(DMG * multiplier);
   }
   public static int calculateCrits(final Playable attacker, final int atkRoll, final Playable target, final int defRoll, int DMG, AttackMagic AttackMagic)
   {
      //Magic
      int Luck = attacker.getAttribute("Luck"), defLuck = target.getAttribute("Luck");
      //OLD: Crits are determined by AttackMagicCrit + (Luck/2) * atkModifier vs. 5 + Luck * evaModifier
      //Modifiers are created by 1 + (attackRoll/defenseRoll * 3%)
      double attackModifier = 1 + (atkRoll * 0.03), evasionModifier = 1 + (defRoll * 0.03);
      double criticalRange = AttackMagic.getCritRange() + (Luck/2) * attackModifier;
      if(attacker.checkBullCall() == true)//The affliction Bull Call causes critical hit range to double when afflicted
         criticalRange = criticalRange * 2;
      double evasionRange = defLuck * evasionModifier;
      //OLD: int atkLuck = (atkRoll + Luck)/2, targetLuck = defRoll + defLuck;
      int tempDMG = DMG;//Used in case we need it for additional multipliers.
      double multiplier = 1.0;
      if(criticalRange > evasionRange || atkRoll == 20)
      {
            System.out.println("Critical Hit!");
            multiplier = 2.0;
      }
      if(target.checkFrozen() == true)//Frozen foes are immune to crits
         multiplier = 1.0;  
      return (int)(DMG * multiplier);
   }
   public static int calculateCrits(final Playable attacker, final int atkRoll, final Playable target, final int defRoll, int DMG, Force force)
   {
      //Force
      int Luck = attacker.getAttribute("Luck"), defLuck = target.getAttribute("Luck");
      //OLD: Crits are determined by AttackMagicCrit + (Luck/2) * atkModifier vs. 5 + Luck * evaModifier
      //Modifiers are created by 1 + (attackRoll/defenseRoll * 3%)
      double attackModifier = 1 + (atkRoll * 0.03), evasionModifier = 1 + (defRoll * 0.03);
      double criticalRange = force.getCrit() + (Luck/2) * attackModifier;
      if(attacker.checkBullCall() == true)//The affliction Bull Call causes critical hit range to double when afflicted
         criticalRange = criticalRange * 2;
      double evasionRange = defLuck * evasionModifier;
      //OLD: int atkLuck = (atkRoll + Luck)/2, targetLuck = defRoll + defLuck;
      int tempDMG = DMG;//Used in case we need it for additional multipliers.
      double multiplier = 1.0;
      if(criticalRange > evasionRange || atkRoll == 20)
      {
            System.out.println("Critical Hit!");
            multiplier = 2.0;
      }
      if(target.checkFrozen() == true)//Frozen foes are immune to crits
         multiplier = 1.0;  
      return (int)(DMG * multiplier);
   }
   public static void limitCheck(final Playable [] character, final Scanner kb) throws FileNotFoundException
   {
      /*Limits are calculated for outright living by 100 - (Limit * (1.25))
        If a character fails to outright live, they'll roll a d100 to see if they are knockedout or dead.
        A character who succeeds the first roll has only 1 HP, and this only works once per battle.
      */
      Playable [] names = information.gather.partyNames(kb);
      names = information.gather.areInBattle(names,character);
      for(int x = 0; x < names.length; x++)
      {
         int Limit = names[x].getAttribute("Limit");
         int requirement = 100 - (int)(Limit * (1.25));
         System.out.print("Enter " + names[x].getName() + "'s roll: ");
         int roll = kb.nextInt(); kb.nextLine();
         if(roll >= requirement)
         {
            System.out.println(names[x].getName() + " survives with 1 HP!");
         }
         else
         {
            System.out.print("Enter another d100 roll: ");
            int finalRoll = kb.nextInt(); kb.nextLine();
            if(finalRoll > 50)
               System.out.println(names[x].getName() + " is knocked out!");
            else
               System.out.println(names[x].getName() + " suffers a final death...");
         }
      }
   }
}