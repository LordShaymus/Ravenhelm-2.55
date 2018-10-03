package Weapon;
import Weapon.SupportMagic;
import Character.Playable;
import java.util.*;
public class supportMagicList
{
   public static SupportMagic spellList(final String spell)
   {
      int base = 0,roll = 0;
      double percentage = 0.00;
      String type = "";
      switch(spell){
         case "Live Dammit": base = 16;
                             roll = 6;
                             percentage = 0.50;
                             type = "Heal";
                             break;
         case "Healing Circle": base = 15; roll = 6; percentage = 0.15; type = "Heal"; break;
         case "Soothe Spirit": type = "Cure";
                               break;
         case "Pain Suppressor": type = "Buff";
                                 break;
         case "Dampen Harm": type = "Buff";
                                    break;
         case "Protect": type = "Buff"; break;
         case "Strengthen Might": type = "Buff"; break;
         case "Cure Panic": type = "Cure"; break;
         case "Porxy Effect": type = "Buff"; break;
         case "Shell": type = "Buff"; break;
         case "Curing Song": type = "Buff"; break;
         case "Hastesong": type = "Buff"; break;
         case "Battle Hymns": type = "Buff"; break;
         case "Holy Chant": type = "Cure"; break;
         case "Aspiring Tune": type = "Buff"; break;
         case "Water Barricade": type = "Buff"; break;
         case "Base": type = "Cure"; break;
         case "Flex": type = "Buff"; break;
         case "Stretch": type = "Buff"; break;
         case "Harden": type = "Buff"; break;
         case "Repel": type = "Cure"; break;
         case "Angel's Call": type = "Blessed"; break;
         case "Bone Armor": type = "Buff"; break;
                                    
      }
      return new SupportMagic(spell,type,percentage,base,roll);
   }
   public static Playable [] useSpell(SupportMagic spell,Playable subject,Playable [] list)
   {
      String type = spell.getType();
      String name = spell.getName();
      int HP = 0;
      Random r = new Random();
      if(type.equals("Heal"))
      {  
         HP = spell.Heal(subject.getAttribute("Max HP"),r);
         subject.recoverHP(HP);
         System.out.println(subject.getName() + " has recovered " + HP + " HP!");
      }
      return applySpell(name,type,subject,list);
   }
   public static Playable [] applySpell(String spell,String type,Playable subject,Playable[] list)
   {
      String subName = subject.getName();
      for(int x = 0; x < list.length; x++)
      {
         String name = list[x].getName();
         if(name.equals(subName))
         {
            if(type.equals("Heal"))
               list[x] = subject;
         
         else
         {
            switch(spell){
            
            case "Soothe Spirit": list[x].applyAffliction(list[x],"Panicking",true); list[x].applyAffliction(list[x],"Exhaustion",true); 
            System.out.println(subject.getName() + " is cured of Panicking and Exhaustion");break;
            case "Pain Suppressor": list[x].applyAffliction(list[x],"Pain Suppress",false);
            System.out.println(subject.getName() + " Defense has increased by 5!"); break;
            case "Dampen Harm": System.out.println("Adric takes 50% of " + subject.getName() + "'s damage"); break;
            case "Protect": list[x].applyAffliction(list[x],"Protect",false); System.out.println(list[x].getName() + "'s Defense has increased by 5!"); break;
            case "Strengthen Might": list[x].changeBonus("Strength",5,false); System.out.println(list[x].getName() + "'s Strength has increased by 5!"); break;
            case "Cure Panic": list[x].applyAffliction(list[x],"Panicking",true);System.out.println(list[x].getName() + " is cured of Panic!"); break;
            case "Shell": list[x].applyAffliction(list[x],"Shell",false);System.out.println(list[x].getName() + " is covered in a protective shell!"); break;
            case "Curing Song": list[x].applyAffliction(list[x],"Blessed",false);System.out.println(list[x].getName() + " is blessed by the tune!"); break;
            case "Hastesong": list[x].applyAffliction(list[x],"Haste",false);System.out.println(list[x].getName() + "'s Speed increased by 10 thanks to the song!"); break;
            case "Battle Hymns": list[x].changeBonus("Strength",3,false); System.out.println(list[x].getName() + "'s Strength has increased by 3 thanks to the song!"); break;
            case "Holy Chant": list[x].applyAffliction(list[x],"Cursed",true); System.out.println(list[x].getName() + " is freed from this terrible curse!"); break;
            case "Aspiring Music": list[x].applyAffliction(list[x],"Inspired",false); System.out.println(list[x].getName() + " is inspired thanks to the song!"); break;
            case "Water Barricade": list[x].applyAffliction(list[x],"Water Barricade",false); System.out.println(list[x].getName() + "'s resistance towards Fire has slightly increased"); break;
            case "Base": list[x].applyAffliction(list[x],"Acid",true); System.out.println(list[x].getName() + " is cured of Acid!"); break;
            case "Flex": list[x].changeBonus("Defense",10,false); System.out.println(list[x].getName() + "'s Defense has increased by 10!"); break;
            case "Stretch": list[x].changeBonus("Resistance",5,false); System.out.println(list[x].getName() + "'s Resistance has increased by 5!"); break;
            case "Harden": list[x].changeBonus("Defense",5,false); list[x].changeBonus("Resistance",5,false); list[x].changeBonus("Constitution",20,false); System.out.println(list[x].getName() + "'s Defense and Resistance increased by 5! Constitution has increased by 20!");
            case "Repel": list[x].changeResistance("Curse",50,false); list[x].applyAffliction(list[x],"Cursed",true); list[x].applyAffliction(list[x],"Bind Circle",true); System.out.println(list[x].getName() + " is repeled of the terrible curse!"); break;
            case "Angel's Call": list[x].applyAffliction(list[x],"Blessed",false); System.out.println(list[x].getName() + " is Blessed!"); break;
            case "Bone Armor": list[x].changeBonus("Strength", 10, false); list[x].changeBonus("Resistance", 15, false); System.out.println(list[x].getName() + "'s Defense has increased by 10 and Resistance increased by 15!"); break;
            case "Pure Suppression": list[x].applyAffliction(list[x],"Protect",false); list[x].applyAffliction(list[x],"Barrier",false); System.out.println(list[x].getName() + " is highly resistant to physical and magical attacks"); break;
            }//End of switch
         
         }//end of else statement
         }
      }//end of for loop
      return list;
   }
}