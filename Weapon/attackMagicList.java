package Weapon;
import Weapon.AttackMagic;
import Weapon.handToHand;
import Weapon.Weapon;
import java.util.*;
public class attackMagicList
{
   public static AttackMagic spellList(final String name)
   {
      int base = 0,crit = 0,rate = 0;
      String element = "",affliction = "";
      boolean projectile = false, limit = false;
      switch(name){
      // ------------------------------- Acid -------------------------------
       case "Acid Swipe": base = 20;
                               crit = 2;
                               element = "Acid";
                               affliction = "Acid";
                               rate = 10000;
                               break;
            case "Acid Breath": base = 24;
                                crit = 1;
                                element = "Acid";
                                affliction = "Acid";
                                rate = 10000;
                                projectile = true;
                                break;
        case "Acid Sting": affliction = "Acid";
                               rate = 10000;
                               base = 1;
                               break;
         case "Acid Fog": affliction = "Acid";
                             rate = 10000;
                             break;
         case "Reflux": element = "Acid"; base = 27; crit = 3; affliction = "Acid"; rate = 10000; projectile = true; break;       
         case "Lead Bubble": element = "Acid"; affliction = "Weakened"; rate = 10000; break;  
      // ------------------------------- Curse -------------------------------
      case "Nosferatu": base = 30;
                           element = "Curse";
                           projectile = true;
                           break;
         case "Bind Circle": element = "Curse";
                             affliction = "Frozen";
                             rate = 200;
                             projectile = true;
                             break;
         case "Drain Circle": element = "Curse";
                              affliction = "Drain";
                              rate = 200;
                              projectile = true;
                              break;                                         
         case "Dead": element = "Curse";
                         crit = 3;
                         base = 20;
                         break;
         case "Possession": element = "Curse";
                            affliction = "Possessed";
                            rate = 10000;
                            break;
         case "Drain Soul": element = "Curse";
                            crit = 2;
                            affliction = "Drain";
                            rate = 10000;
                            break;
                            
         case "Dark Blast": base = 25;
                            crit = 5;
                            crit = 16;
                            element = "Curse";
                            break;
         case "Voodoo": element = "Curse";
                        affliction = "Cursed";
                        rate = 10000;
                        break;
                        
         case "Curse": element = "Curse";
                          affliction = "Cursed";
                           rate = 10000;
                           break;
         case "Imprisonment": element = "Curse";
                                 affliction = "Bound";
                                 rate = 100; 
                                 break;
            case "Darken View": element = "Curse";
                                affliction = "Blind";
                                rate = 100;
                                break; 
      case "Deathly Fog": affliction = "Drain";
                          element = "Curse";
                                rate = 10000;
                                break;
            case "Dreadful Thoughts": affliction = "Panicking";
                                      element = "Curse";
                                      rate = 10000;
                                      break;
         case "Leech Life": base = 19;
                            crit = 1;
                            element = "Curse";
                            break;
      case "Nightmare Projections": element = "Curse";
                                    affliction = "Panicking";
                                    rate = 10000;
                                    break;
      case "Vampiric Energy": base = 29; element = "Curse"; break;
      case "Hateful Visions": element = "Curse"; affliction = "Enraged"; rate = 10000; break;
      case "Deterioration": element = "Curse"; affliction = "Weakened"; rate = 10000; break;
      case "Flux Elogy": element = "Curse"; affliction = "Stasis"; rate = 10000; break;
      case "Hammer of Dusk": element = "Curse"; base = special.weapons.hammerOfDusk(new Scanner(System.in)); crit = special.weapons.hammerOfDuskCrit(base); projectile = true; break;
      case "Cursed Affinity":
      {
         //Cursed Affinity turns any Spell into Cursed, but they lose their properties as a Fire Spell (affliction,rate).
         AttackMagic spell = getCustomSpell(new Scanner(System.in));
         base = spell.getBase(); crit = spell.getCritRange();
         element = "Curse";
      }
      case "Hex": affliction = "Hexed"; rate = 200; element = "Curse"; break;
      case "Bone Spear": element = "Curse"; base = 35; break;
      case "Decrepify": element = "Curse"; affliction = "Decrepify"; rate = 200; break;
      case "Sap Circle": element = "Curse"; affliction = "Sapped"; rate = 200; break;
      // ------------------------------- Earth -------------------------------
      case "Earthquake": element = "Earth";
                         crit = 4;
                               base = 35;
                               break;
      case "Stalagmite": element = "Earth"; crit = 3; base = 30; break;
      case "Boulder Punch": element = "Earth"; crit = 1; base = 60; break;
      case "Rock Shower": element = "Earth"; crit = 3; base = 35; break;
      // ------------------------------- Electricity -------------------------------
      case "Lightning Bolt": base = 15;
                             crit = 1;
                                   element = "Electricity";
                                   affliction = "Paralyzed";
                                   rate = 30;
                                   break;
            case "Shockwave": element = "Electricity";
                              affliction = "Paralyzed";
                              rate = 10000;
                              break;
                              
            case "Defibrillator Hands": base = 50;
                                        crit = 6;
                                        element = "Electricity";
                                        break;
      // ------------------------------- ESP -------------------------------
      case "Mind Halt": element = "ESP";
                              affliction = "Stun";
                              rate = 10000;
                              break;
            case "Mind Possession": element = "ESP";
                                    affliction = "Possessed";
                                    rate = 10000; 
                                    break;
      case "Telepathic Whisper": element = "ESP";
                                 affliction = "Panicking";
                                 rate = 10000;
                                 break;
      // ------------------------------- Fire -------------------------------
               case "Yoga Fire": base = 20;
                           crit = 1;
                           element = "Fire";
                           affliction = "Burning";
                           rate = 20;
                           projectile = true;
                           break;
         case "Yoga Flame": base = 25;
                            crit = 1;
                            element = "Fire";
                            affliction = "Burning";
                            rate = 40;
                            projectile = true;
                            break;
         case "Smog": element = "Fire";
                      affliction = "Blind";
                      rate = 10000;
                      projectile = true;
                      break;
         case "Starstorm Alpha": base = 20;
                                 crit = 1;
                                 element = "Fire";
                                 affliction = "Burning";
                                 rate = 10;
                                 projectile = true;
                                 break;
         case "Starstorm Beta": base = 25;
                                crit = 1;
                                element = "Fire";
                                affliction = "Burning";
                                rate = 10;
                                projectile = true;
                                break;
         case "Starstorm Gamma": base = 30;
                                 crit = 1;
                                 affliction = "Burning";
                                 rate = 10;
                                 projectile = true;
                                 break;
         case "Starstorm Delta": base = 35;
                                 crit = 2;
                                 element = "Fire";
                                 affliction = "Burning";
                                 rate = 20;
                                 projectile = true;
                                 break;
         case "Starstorm Eplison": base = 40;
                                   crit = 2;
                                   element = "Fire";
                                   affliction = "Burning";
                                   rate = 20;
                                   projectile = true;
                                   break;
         case "Starstorm Zeta": base = 45;
                               crit = 2;
                               element = "Fire";
                               affliction = "Burning";
                               rate = 20;
                               projectile = true;
                               break;
         case "Starstorm Eta": base = 50;
                               crit = 3;
                               element = "Fire";
                               affliction = "Burning";
                               rate = 30;
                               projectile = true;
                               break;
         case "Starstorm Theta": base = 55; crit = 3; element = "Fire"; affliction = "Burning"; rate = 30; break;
         case "Starstorm Iota": base = 60; crit = 3; element = "Fire"; affliction = "Burning"; rate = 30; break;
         case "Starstorm Kappa": base = 65; crit = 3; element = "Fire"; affliction = "Burning"; rate = 30; break;
         case "Starstorm Lambda": base = 70; crit = 3; element = "Fire"; affliction = "Burning"; rate = 40; break;
         case "Starstorm Mu": base = 75; crit = 3; element = "Fire"; affliction = "Burning"; rate = 40; break;
         case "Myraid Arrows": base = 45;
                               crit = 6;
                               element = "Fire";
                               affliction = "Burning";
                               rate = 45;
                               projectile = true;
                               break;
                               
         case "Light Star": base = 45;
                            crit = 5;
                            element = "Fire";
                            affliction = "Burning";
                            rate = 10000;
                            projectile = true;
                            limit = true;
                            break;
                            
         case "Fire Breath": base = 20;
                             crit = 1;
                             element = "Fire";
                             affliction = "Burning";
                             rate = 30;
                             projectile = true;
                             break;
        case "Fireball": base = 15;
                         crit = 1;
                         element = "Fire";
                         affliction = "Burning";
                         rate = 25;
                         projectile = true;
                         break;
        case "Self Destruction": base = 100;
                                 crit = 20;
                                 element = "Fire";
                                 break;  
        case "Fiery Kick": base = getHandAttack("Close Quarter Combat","Kick") + 20;
                               element = "Fire";
                               crit = 3;
                               affliction = "Burning";
                               rate = 40;
                               break;
            case "Melee Fire Affinity": base = getCustomHandAttack(new Scanner(System.in)) + 10;
                                        crit = 2;                                        
                                        element = "Fire";
                                        affliction = "Burning";
                                        rate = 20;
                                        break;
            case "Weapon Enchant": base = getCustomWeaponAttack(new Scanner(System.in)) + 10;
                                   crit = 3;                               
                                   element = "Fire";
                                   affliction = "Burning";
                                   rate = 40;
                                   break;   
          case "Flame Touch": affliction = "Burning";
                                rate = 100;
                                element = "Fire";
                                base = 23;
                                break; 
         case "Doga Fire": element = "Fire"; crit = 5; base = 35; affliction = "Burning"; rate = 45; projectile = true; break;
         case "Fire Blast": element = "Fire"; crit = 1; base  = 30; affliction = "Burning"; rate = 25; projectile = true; break;
         case "Fire Surge": element = "Fire"; crit = 1; base = 35; affliction = "Burning"; rate = 40; projectile = true; break;
      // ------------------------------- Holy -------------------------------
      case "Holy Blast": element = "Holy";
                                crit = 2;
                                base = 25;
                                affliction = "Blind";
                                rate = 35;
                                break;
             case "Blinding Light": element = "Holy";
                                    affliction = "Blind";
                                    rate = 55;
                                    break;      
      // ------------------------------- Ice -------------------------------
      case "Flurry": element = "Ice";
                         affliction = "Flurry";
                         rate = 10000;
                         break;
          case "Frost": base = 15;
                        crit = 2;
                        element = "Ice";
                        affliction = "Frozen";
                        rate = 30;
                        projectile = true;
                        break;
           case "Slush": base = 30;
                         crit = 3;
                         element = "Ice";
                         projectile = true;
                         break;
            case "Blizzard": base = 15;
                             crit = 1;
                             element = "Ice";
                             affliction = "Frozen";
                             rate = 15;
                             projectile = true;
                             break;
             case "Freeze Touch": base = 5;
                                  crit = 1;
                                  element = "Ice";
                                  affliction = "Frozen";
                                  rate = 85;
                                  break;      
            case "Dry Burn": element = "Ice"; affliction = "Burning"; rate = 10000; break;
            case "Ice Breath": element = "Ice"; crit = 2; affliction = "Frozen"; base = 35; rate = 30; break;
      // ------------------------------- Poison -------------------------------      
      case "Spit Up": base = 25;
                         crit = 2;
                         element = "Poison";
                         affliction = "OG Poisoned";
                         rate = 35;
                         projectile = true;
                         break;
         case "Venom": element = "Poison";
                       affliction = "OG Poisoned";
                       rate = 200;
                       projectile = true;
                       break;
         case "Stun Claws": base = 20;
                            crit = 4;
                            element = "Poison";
                            affliction = "Paralyzed";
                            rate = 10000;
                            break;
          case "Dread Gas": element = "Poison";
                            affliction = "Panicking";
                            rate = 10000;
                            projectile = true;
                            break;
          case "Eyesore Claw": base = 22;
                               crit = 4;
                               element = "Poison";
                               affliction = "Blind";
                               rate = 10000;
                               break;      
         case "Laughing Gas": element = "Poison"; affliction = "Knock Out"; rate = 10000; break;
         case "Toxic Pin": element = "Poison"; base = 32; crit = 5; affliction = "Exhaustion"; rate = 10000; break;
      // ------------------------------- Slag -------------------------------      
      case "Vomit Slag": element = "Slag";
                               affliction = element;
                               rate = 10000;
                               break;
      // ------------------------------- Water -------------------------------
        case "Water Blast": base = 17;
                            crit = 3;
                            element = "Water";
                            break;  
         case "Water Tentacle": base = 25;
                                crit = 2;
                                   element = "Water";
                                   break;
            case "Water Bomb": base = 28;
                               crit = 2;
                               element = "Water";
                               break;    
         case "Water Trap": base = 25; element = "Water"; affliction = "Bound"; rate = 200; break;
      // ------------------------------- Wind -------------------------------
         case "Tornado": element = "Wind";
                         crit = 8;
                         base = 30;
                         break;
            case "Blow": base = 20;
                         element = "Wind";
                         break;
            case "Wind Bomb": base = 25; crit = 3;
                              element = "Wind";
                              break;
            case "Mini Tornado": base = 27;
                                 crit = 4;
                                 element = "Wind";
                                 break;
            case "Air Slash": base = 19;
                              crit = 2;
                              element = "Wind";
                              break;
       // ------------------------------- Miscellaneous -------------------------------                 
                        
            case "Alluring Tune": affliction = "Possessed";
                                  rate = 10000;
                                  break;
            
                               
                                
      }
      return new AttackMagic(name,element,base,crit,affliction,rate,projectile,limit);
   }
  public static int getHandAttack(String name,String style)
  {
      handToHand atk = handToHandList.attackInfo(style,name);
      return atk.getBase();
  }
  public static int getCustomHandAttack(Scanner kb)
  {
      System.out.println("Enter your style: ");
      String style = kb.nextLine();
      System.out.println("Enter the attack: ");
      String attack = kb.nextLine();
      handToHand atk = handToHandList.attackInfo(style,attack);
      return atk.getBase();
  }
  public static int getCustomWeaponAttack(Scanner kb)
  {
      System.out.println("Enter your weapon: ");
      Weapon weapon = weaponList.checkWeapon(kb.nextLine());
      return weapon.getBase();
  }
  public static AttackMagic getCustomSpell(Scanner kb)
  {
   System.out.println("Enter your spell: ");
   AttackMagic spell = spellList(kb.nextLine());
   return spell;
  }
}