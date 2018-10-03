package Weapon;
import java.util.Scanner;
import java.util.Random;
import Weapon.Weapon;
public class weaponList
{
   public static Weapon checkWeapon(String name)
   {
      String type = "",affliction = "",element = "";
      Random r = new Random();
      int base = 0, crit = 0, rate = 0;
      boolean projectile = false, magical = false;
      if(name.contains("throw"))
      {
         projectile = true;
         name = name.replace("throw","").trim();
      }
       switch(name){
      //---------------------------------------- Axe ----------------------------------------
      case "battle axe":
         {
            type = "Axe";
            base = 30;
            crit = 4;
            break;
         }
      case "dane axe":
      {
         type = "Axe";
         base = 39;
         crit = 4;
         break;
      }
      case "ono":
         {
            type = "Axe";
            base = 21;
            crit = 3;
            break;
         }
         case "shepherd's axe":
         {
            type = "Axe";
            base = 18;
            crit = 2;
            break;
         }
      //---------------------------------------- Bizzare ----------------------------------------
      case "boomerang sword":
         {
            type = "Bizzare";
            base = 26;
            crit = 7;
            break;
         }
       case "flying fist":
         {
            type = "Bizarre";
            base = 21;
            projectile = true;
            crit = 7;
            break;
         }
       case "iron bolas shot":
       {
         type = "Bizarre";
         base = 15;
         crit = 2;
         break;
       }
       case "mugger's mug of mugging":
       {
         type = "Bizzare";
         base = 20;
         affliction = "Steal";
         rate = 50;
         crit = 0;
         break;
       }
       case "party cannon":
       {
         type = "Bizzare";
         base = 36;
         crit = 8;
         break;
       }
       case "sickle":
         {
            type = "Bizarre";
            base = 23;
            crit = 1;
            break;
         }
      case "steel yoyo":
      {
         type = "Bizarre";
         base = 19;
         crit = 5;
         break;
      }
      case "toy crossbow":
      {
         type = "Bizarre";
         base = 16;
         affliction = special.weapons.toyCrossbowAffliction(new Random());
         rate = 10000;
         crit = 0;
         break;
      }
      case "wand of oak with dragon heartstring":
      {
         type = "Bizzare";
         String wandEffect = special.weapons.wandOfOakEffects(r);
         System.out.println("Attack: " + wandEffect);
         base = r.nextInt(15)+15;
         element = special.weapons.wandOfOakElement(wandEffect);
         affliction = special.weapons.wandOfOakAffliction(element);
         rate = r.nextInt(100);
         crit = 3;
         break;
      }
      //---------------------------------------- Blowgun ----------------------------------------
      case "regular blowgun":
      {
         type = "Blowgun";
         Weapon wpn = special.weapons.blowgunInfo(new Scanner (System.in));
         base = wpn.getBase() + 5;
         affliction = wpn.getAffliction();
         rate = wpn.getRate() + 5;
         element = wpn.getElement();
         projectile = true;
         magical = wpn.getMagical();
         crit = wpn.getCritRange() + 1; 
         break;
      }
      case "bamboo blowgun":
      {
         type = "Blowgun";
         Weapon wpn = special.weapons.blowgunInfo(new Scanner(System.in));
         base = wpn.getBase() + 15;
         affliction = wpn.getAffliction();
         rate = wpn.getRate() + 15;
         element = wpn.getElement();
         projectile = true;
         magical = wpn.getMagical();
         crit = wpn.getCritRange() + 3;
         break;
      }
      //---------------------------------------- Blunt ----------------------------------------
      case "sledgehammer":
         {
            type = "Blunt";
            base = 23;
            crit = 6;
            break;
         }
      case "baseball bat":
         {
            type = "Blunt";
            base = 22;
            crit = 1;
            break;
         }
      case "iron mallet":
      {
         type = "Blunt";
         base = 15;
         crit = 0;
         break;
      }
      //---------------------------------------- Bow ----------------------------------------
      case "recurve bow":
      {
         type = "Bow";
         Weapon wpn = special.weapons.crossbowInfo(new Scanner (System.in));
         base = (int)(wpn.getBase() * 1.25);
         affliction = wpn.getAffliction();
         rate = wpn.getRate() + 5;
         element = wpn.getElement();
         projectile = true;
         magical = wpn.getMagical(); 
         crit = wpn.getCritRange() - 2;
         break;
      }
      //---------------------------------------- Chakram ----------------------------------------
      case "basic chakram":
      {
         type = "Chakram";
         base = 18;
         crit = 1;
         break;
      }
      case "frost chakram":
      {
         type = "Chakram";
         crit = 3;
         base = 34;
         element = "Ice";
         affliction = "Frozen";
         rate = 45;
         break;
      }
      case "jagged chakram":
      {
         type = "Chakram";
         base = 31;
         crit = 3;
         break;
      }
      case "razoried chakram":
         {
            type = "Chakram";
            base = 33;
            affliction = "Latch";
            rate = 45;
            crit = 3;
            break;
         }
      case "shock chakram":
         {
            type = "Chakram";
            base = 31;
            crit = 12;
            element = "Electricity";
            affliction = "Paralyzed";
            rate = 40;
            crit = 4;
            break;
         }
      //---------------------------------------- Crossbow ----------------------------------------
      case "hunting crossbow":
      {
         type = "Crossbow";
         Weapon wpn = special.weapons.crossbowInfo(new Scanner (System.in));
         base = wpn.getBase() + 7;
         affliction = wpn.getAffliction();
         rate = wpn.getRate() + 5;
         element = wpn.getElement();
         projectile = true;
         magical = wpn.getMagical(); 
         crit = wpn.getCritRange() + 2;
         break;
      }
      case "regular crossbow":
      {
         type = "Crossbow";
         Weapon wpn = special.weapons.crossbowInfo(new Scanner (System.in));
         base = wpn.getBase();
         affliction = wpn.getAffliction();
         rate = wpn.getRate();
         element = wpn.getElement();
         projectile = true;
         magical = wpn.getMagical();
         crit = wpn.getCritRange(); 
         break;
      }
      case "heavy crossbow":
      {
         type = "Crossbow";
         Weapon wpn = special.weapons.crossbowInfo(new Scanner (System.in));
         base = wpn.getBase() + 5;
         affliction = wpn.getAffliction();
         rate = wpn.getRate();
         element = wpn.getElement();
         projectile = true;
         magical = wpn.getMagical();
         crit = wpn.getCritRange();  
         break;
      }
      //---------------------------------------- Flail ----------------------------------------
      case "chigiriki":
         {  
            type = "Flail";
            base = 24;
            crit = 7;
            break;
         }
      case "frost flail":
         {
            type = "Flail";
            base = 31;
            affliction = "Frozen";
            rate = 45;
            crit = 3;
            break;
         }
      //---------------------------------------- Gauntlet ----------------------------------------
      case "automail claws":
      {
         type = "Gauntlet";
         base = 24;
         element = special.weapons.automailClawsElement(new Scanner(System.in));
         affliction = special.weapons.automailClawsAffliction(element);
         rate = 50;
         crit = 6;
         break;
      }
      case "cesteus":
         {
            type = "Gauntlet";
            base = 30;
            crit = 4;
            break;
         }
      case "cleric gauntlet":
      {
         type = "Gauntlet";
         crit = 1;
         base = 29;
         break;
      }
      case "kreuger claws":
      {
         type = "Gauntlet";
         base = 32;
         crit = 3;
         break;
      }
      case "magic harnesser gauntlet":
       {
         return special.weapons.magicHarnesser(new Scanner(System.in));
       }
      case "roman scissor":
      {
         type = "Gauntlet";
         base = 36;
         crit = 5;
         break;
      }
      case "silver gauntlet":
         {
            type = "Gauntlet";
            base = 21;
            crit = 2;
            break;
         }
      //---------------------------------------- Item ----------------------------------------
      case "light bomb":
         {
            type = "Item";
            element = "Holy";
            base = 30;
            affliction = "Blinded";
            rate = 50;
            projectile = true;
            break;
         }
      case "leech":
      {
         type = "Item";
         affliction = "Drain";
         rate = 10000;
         projectile = true;
         break;
      }
      case "bomb potion":
      {
         type = "Item";
         base = 60;
         element = "Fire";
         projectile = true;
         break;
      }
      case "dyanmite":
      {
         type = "Item";
         base = 50;
         element = "Fire";
         projectile = true;
         break;
      }
      case "molotov cocktail":
      {
         type = "Item";
         base = 15;
         element = "Fire";
         affliction = "Burning";
         rate = 10000;
         break;
      }
      case "smoke bomb":
      {
         type = "Item";
         base = 0;
         affliction = "Smoke Bomb";
         rate = 200;
         break;
      }
      //---------------------------------------- Knife ----------------------------------------
      case "arkanasas toothpick":
      {
         type = "Knife";
         base = 36;
         crit = 2;
         break;
      }
      case "bronze knife":
      {
         type = "Knife";
         base = 23;
         crit = 2;
         break;
      }
      case "dream guard knife":
      {
         type = "Knife";
         base = 20;
         crit = 1;
         break;
      }
      case "holy dagger":
         {
            type = "Knife";
            base = 20;
            element = "Holy";
            affliction = "Blind";
            rate = 60;
            crit = 2;
            break;
         }
      case "kukri":
         {
            type = "Knife";
            base = 22;
            crit = 1;
            break;
         }
      case "parrying dagger":
      {
         type = "Knife";
         base = 21;
         crit = 5;
         break;
      }
      case "push dagger":
      {
         type = "Knife";
         base = 23;
         break;
      }
      case "pyro knife":
         {
            type = "Knife";
            base = 18;
            element = "Fire";
            affliction = "Burn";
            rate = 10000;
            crit = 1;
            break;
        }
      case "speedy stabby knife":
      {
         type = "Knife";
         base = 24;
         crit = 3;
         break;
      }
      case "stilletto":
      {
         type = "Knife";
         base = 29;
         crit = 1;
         break;
      }
      //Abilities
      case "chuck knives":
      {
         type = "Knife";
         base = 15 + ((5 * r.nextInt(6))/2);
         crit = r.nextInt(6)+1;
         projectile = true;
         break;
      }
      //---------------------------------------- Nunchuck ----------------------------------------
      case "steel nunchuck":
      {
         type = "Nunchuck";
         base = 32;
         break;
      }
      //---------------------------------------- One Handed Sword ----------------------------------------
      case "archangel blade":
      {
         type = "One Handed Sword";
         base = 34;
         element = "Holy";
         crit = 2;
         break;
      }
      case "basket hilt":
      {
         type = "One Handed Sword";
         base = 32;
         crit = 3;
         break;
      }
      case "cutlass":
      {
         type = "One Handed Sword";
         base = 30;
         crit = 1;
         break;
      }
      case "falchion":
         {
            type = "One Handed Sword";
            base = 35;
            crit = 7;
            break;
         }
      case "ida":
      {
         type = "One Handed Sword";
         base = 33;
         crit = 3;
         break;
      }
      case "jian":
      {
         type = "One Handed Sword";
         base = 31;
         crit = 5;
         break;  
      }
      case "katzbalger":
      {
         type = "One Handed Sword";
         base = 42;
         crit = 10;
         break;
      }
      case "rapier":
         {
            type = "One Handed Sword";
            base = 21;
            crit = 1;
            break;
         }
      case "razoried rapier":
      {
         type = "One Handed Sword";
         base = 31;
         affliction = "Latch";
         rate = 45;
         crit = 2;
         break;
      }
      case "sabre":
         {
            type = "One Handed Sword";
            base = 20;
            crit = 2;
            break;
         }
      //---------------------------------------- Shield ----------------------------------------
      case "studded tower shield":
      {
         type = "Shield";
         base = 15;
         affliction = "Stunned";
         rate = 30;
         break;
      }
      //---------------------------------------- Staves ----------------------------------------
      case "assegai":
      {
         type = "Staves";
         base = 24;
         crit = 5;
         break;
      }
      case "dark wood staff":
      {
         type = "Staves";
         base = 21;
         crit = 2;
         break;
      }
      case "fauchard":
      {
         type = "Staves";
         base = 31;
         crit = 5;
         break;
      }
      case "regular spear":
      {
         type = "Staves";
         base = 17;
         break;
      }
      case "bo staff":
         {
            type = "Staves";
            base = 28;
            crit = 1;
            break;
         }
      case "frost spear":
         {
            type = "Staves";
            base = 29;
            element = "Ice";
            affliction = "Frozen";
            rate = 45;
            crit = 2;
            break;
         }
      case "halberd":
      {
         type = "Staves";
         base = 17;
         break;
      }
      case "iron staff":
      {
         type = "Staves";
         base = 20;
         crit = 1;
         break;
      }
      case "harpoon":
         {
            type = "Staves";
            base = 30;
            crit = 15;
            affliction = "Latch";
            rate = 60;
            crit = 4;
            break;
         }
      
      case "razorized quarterstaff":
         {
            type = "Staves";
            base = 35;
            affliction = "Latch";
            rate = 40;
            crit = 3;
            break;
         }
      case "willow spear":
      {
         type = "Staves";
         base = 23;
         affliction = "Cursed and Burned";
         rate = 40;
         element = "Other"; //Curse + Fire
         crit = 5;
         break;
      }
      //---------------------------------------- Two Handed Sword ----------------------------------------
      case "accursed blade":
         {
            type = "Two Handed Sword";
            base = 31;
            element = "Curse";
            affliction = "Cursed";
            rate = 55;
            crit = 1;
            break;
         }
      case "acidic blade":
      {
         type = "Two Handed Sword";
         base = 29;
         element = "Acid";
         affliction = element;
         rate = 100;
         crit = 4;
         break;
      }
      case "claymore":
      {
         type = "Two Handed Sword";
         base = 37;
         crit = 3;
         break;
      }
      case "dotanuki":
      {
         type = "Two Handed Sword";
         base = 36;
         crit = 2;
         break;
      }
      case "katana":
         {
            type = "Two Handed Sword";
            base = 37;
            crit = 5;
            break;
         }
      case "longsword":
         {
            type = "Two Handed Sword";
            base = 17;
            break;
         }
      case "shockingly deadly katana":
      {
         type = "Two Handed Sword";
         base = 22;
         affliction = "Paralyzed";
         rate = 30;
         element = "Electricity";
         crit = 6;
         break;
      }
      case "zweihander":
      {
         type = "Two Handed Sword";
         base = 41;
         crit = 5;
         break;
      }
      //---------------------------------------- Whip ----------------------------------------
      case "basic whip":
         {
            type = "Whip";
            base = 21;
            break;
         }
      case "buntot pagi":
      {
         type = "Whip";
         base = 33;
         break;
      }
         case "electric whip":
         {
            type = "Whip";
            base = 25;
            element = "Electricity";
            affliction = "Paralyzed";
            rate = 35;
            crit = 3;
            break;
         }
         case "thorny whip":
         {
            type = "Whip";
            base = 19;
            affliction = "Latch";
            rate = 50;
            crit = 5;
            break;
         }
      }
      return new Weapon(name,type,base,crit,element,affliction,rate,projectile,magical);
   }
   public static int damageRoll(final String type)
   {
      switch(type)
      {
         case "Axe": return 12;
         case "Ballista": return 12;
         case "Bizarre": return 12;
         case "Blowgun": return 8;
         case "Blunt": return 12;
         case "Bow": return 12;
         case "Chakram": return 8;
         case "Crossbow": return 8;
         case "Items": return 8;
         case "Flail": return 12;
         case "Gauntlet": return 12;
         case "Knife": return 8;
         case "Nunchuck": return 8;
         case "One Handed Sword": return 8;
         case "Shield": return 6;
         case "Staves": return 8;
         case "Two Handed Sword": return 12;
         case "Whip": return 8;
      }
      return 8;
   }
}