package affliction;
import java.util.*;
import java.io.*;
public class resistance
{
   public static int equipResistance(String hat,String armor, String access1, String access2, String access3, String att,int x,int value)
   {
      if(x > 4 || x <= -1)
         return value;
         
      String [] equipment = {hat,armor,access1,access2,access3};
      switch(equipment[x]){
         case "XIII+1 Armor":
         {
            if(att.equals("Curse"))
               value += 35;
            break;
         }
         case "Worn Leather Jacket":
         {
            if(att.equals("Ice"))
               value += 10;
            break;
         }
         case "Red Ring":
         {
            if(att.equals("Fire"))
               value += 25;
               break;
         }
         case "Willow Ring":
         {
            if(att.equals("Fire"))
               value += 25;
            else if(att.equals("Curse"))
               value += 40;
            else if(att.equals("Water") || att.equals("Ice"))
               value += 10;
            break;
         }
         case "Leather Raider Vest":
         {
            if(att.equals("Electricity"))
               value += 15;
            break;
         }
         case "Evil Eye Necklace":
         {
            if(att.equals("Curse"))
               value += 50;
               break;
         }
         case "Angel Feather Necklace":
         {
            if(att.equals("Holy"))
               value += 50;
               break;
         }
         case "Zephyrous Cape":
         {
            if(att.equals("Wind"))
               value += 50;
               break;
         }
         case "Flame Retardant Gloves":
         {
            if(att.equals("Fire"))
               value += 75;
               break;
         }
         case "Tin Foil Hat":
         {
            if(att.equals("ESP"))
               value += 100;
               break;
         }
         case "Venom Ring":
         {
            if(att.equals("Poison"))
               value += 25;
               break;
         }
         case "Gladiator Leather Vest":
         {
            if(att.equals("Electricity"))
               value += 75;
               break;
           
         }
         case "Rubber Glove":
         {
            if(att.equals("Electricity"))
               value += 15;
               break;
         }
         case "Venomless Wristband":
         {
            if(att.equals("Poison"))
               value += 30;
               break;
         }
         case "Dreamcatcher Necklace":
         {
            if(att.equals("Curse"))
               value += 30;
               break;
         }
         case "Whale Tooth Necklace":
         {
            if(att.equals("Water"))
               value += 50;
               break;
         }
         case "Shark Tooth Necklace":
         {
            if(att.equals("Water"))
               value += 25;
               break;
         }
         case "Biohazard Suit":
         {
            if(att.equals("Acid"))
               value += 50;
               break;
         }
         case "Sun Hat":
         {
            if(att.equals("Fire"))
               value += 25;
               break;
         }
         case "Lunar Baseball Cap":
         {
            if(att.equals("Curse"))
               value += 25;
               break;
         }
         case "Heli Baseball Cap":
         {
            if(att.equals("Holy"))
               value += 15;
               break;
         }
         case "Macabre Shirt":
         {
            if(att.equals("Curse"))
               value += 15;
               break;
         }
         case "Gaia Necklace":
         {
            if(att.equals("Earth"))
               value += 25;
               break;
         }
         case "LED Necklace":
         {
            if(att.equals("Electricty"))
               value += 25;
               break;
         }
         case "Snowflake Necklace":
         {
            if(att.equals("Ice"))
               value += 25;
               break;
         }
         case "Holy Scarf":
         {
            if(att.equals("Holy"))
               value += 15;
               break;
         }
         case "Dread Scarf":
         {
            if(att.equals("Curse"))
               value += 15;
               break;
         }
         case "Leather Belt":
         {
            if(att.equals("Electricty"))
               value += 40;
               break;
         }
         case "Amber Ring":
         {
            if(att.equals("Fire"))
               value += 35;
               break;
         }
         case "Zircon Ring":
         {
            if(att.equals("Earth"))
               value += 25;
               break;
         }
         case "Fish Necklace":
         {
            if(att.equals("Water"))
               value += 40;
               break;
         }
         case "Zircon Headband":
         {
            if(att.equals("Earth"))
               value += 25;
               break;
         }
         
      }
      return equipResistance(hat,armor,access1,access2,access3,att,x+1,value);
   }
   public static String[] equipResistanceChange(final String equip)
   {
      String str = "";
      switch(equip)
      {
         case "XIII+1 Armor": str = "Curse"; break;
         case "Worn Leather Jacket": str = "Ice"; break;
         case "Red Ring": str = "Fire"; break;
         case "Willow Ring": str = "Fire Curse Water Ice"; break;
         case "Leather Raider Vest": str = "Electricity"; break;
         case "Evil Eye Necklace": str = "Curse"; break;
         case "Angel Feather Necklace": str = "Holy"; break;
         case "Zephyrous Cape": str = "Wind"; break;
         case "Flame Retardant Gloves": str = "Fire"; break;
         case "Tin Foil Hat": str = "ESP"; break;
         case "Venom Ring": str = "Poison"; break;
         case "Gladiator Leather Vest": str = "Electricity"; break;
         case "Rubber Glove": str = "Electricity"; break;
         case "Venomless Wristband": str = "Poison"; break;
         case "Dreamcatcher Necklace": str = "Curse"; break;
         case "Whale Tooth Necklace": str = "Water"; break;
         case "Shark Tooth Necklace": str = "Water"; break;
         case "Biohazard Suit": str = "Acid"; break;
         case "Sun Hat": str = "Fire"; break;
         case "Lunar Baseball Cap": str = "Curse"; break;
         case "Heli Baseball Cap": str = "Holy"; break;
         case "Macabre Shirt": str = "Curse"; break;
         case "Gaia Necklace": str = "Earth"; break;
         case "LED Necklace": str = "Electricity"; break;
         case "Snowflake Necklace": str = "Ice"; break;
         case "Holy Scarf": str = "Holy"; break;
         case "Dread Scarf": str = "Curse"; break;
         case "Leather Belt": str = "Electricity"; break;
         case "Amber Ring": str = "Fire"; break;
         case "Zircon Ring": str = "Earth"; break;
         case "Fish Necklace": str = "Water"; break;
         case "Zircon Headband": str = "Earth"; break;
      }
      return str.split(" ");   
   }
   public static int equipStat(String hat,String armor, String access1, String access2, String access3, String att,int x,int value)
   {
      if(x > 4 || x <= -1)
         return value;
         
      String [] equipment = {hat,armor,access1,access2,access3};
      switch(equipment[x]){
      case "Arrow-Proof Vest":
      {
         if(att.equals("Defense"))
            value += 7;
            break;
      }
      case "Raider Chainmail":
      {
         if(att.equals("Defense"))
            value += 5;
            break;
      }
      case "XIII+1 Armor":
      {
         if(att.equals("Defense"))
            value += 10;
            break;
      }
      case "Red Ring":
      {
         if(att.equals("Strength"))
            value += 3;
            break;
      }
      case "Leather Raider Vest":
      {
         if(att.equals("Defense"))
            value += 3;
            break;
      }
      case "Worn Leather Jacket":
      {
         if(att.equals("Defense"))
            value += 1;
         else if(att.equals("Resistance"))
            value += 2;
            break;
      }
      case "Leather Glove":
      {
         if(att.equals("Skill"))
            value += 2;
            break;
      }
      case "Leather Raider Pads":
      {
         if(att.equals("Defense") || att.equals("Resistance"))
            value += 2;
            break;
      }
      case "Iron Scale Armor":
      {
         if(att.equals("Defense"))
            value += 5;
            break;
      }
      case "Duelist Gloves":
      {
         if(att.equals("Skill"))
            value += 3;
            break;
      }
      case "Evil Eye Necklace":
      {
         if(att.equals("Resistance"))
            value += 3;
            break;
      }
      case "Plate Armor":
      {
         if(att.equals("Defense"))
            value += 7;
            break;
      }
      case "Running Shoes":
      {
         if(att.equals("Speed"))
            value += 3;
            break;
      }
      case "Mich":
      {
         if(att.equals("Defense") || att.equals("Resistance"))
         {
            value += 2;
            break;
         }
      }
      case "Flame Retardant Gloves":
      {
         if(att.equals("Resistance"))
            value += 3;
            break;
      }
      case "Gladiator Leather Vest":
      {
         if(att.equals("Defense"))
            value += 2;
         else if(att.equals("Resistnace"))
            value += 1;
            break;
      }
      case "Track Shoes":
      {
         if(att.equals("Speed"))
            value += 7;
            break;
      }
      case "Rubber Glove":
      {
         if(att.equals("Skill"))
            value += 3;
            break;
      }
      case "Clover Wristband":
      {
         if(att.equals("Luck"))
            value += 3;
            break;
      }
      case "Power Bracelet":
      {
         if(att.equals("Strength"))
            value += 2;
            break;
      }
      case "Metal Shoulder Pads":
      {
         if(att.equals("Defense") || att.equals("Resistance"))
            value += 4;
            break;
      }
      case "Feng Shui Coin":
      {
         if(att.equals("Luck"))
            value += 5;
            break;
      }
      case "Magician Hat":
      {
         if(att.equals("Magic"))
            value += 9;
         else if(att.equals("Resistance"))
            value += 6;
         break;
      }
      case "Dog Tag":
      {
         if(att.equals("Strength"))
            value += 3;
         else if(att.equals("Skill"))
            value += 2;
         break;
      }
      case "Sunglasses":
      {
         if(att.equals("Instinct"))
            value += 3;
            break;
      }
      case "Shark Tooth Necklace":
      {
         if(att.equals("Strength"))
            value += 2;
            break;
      }
      case "Biohazard Suit":
      {
         if(att.equals("Resistance"))
            value += 4;
            break;
      }
      case "Magic Enhancer Glove":
      {
         if(att.equals("Skill"))
            value += 2;
         else if(att.equals("Magic"))
            value += 5;
         break;
      }
      case "Sun Hat":
      {
         if(att.equals("Resistance"))
            value += 4;
            break;
      }
      case "Lunar Baseball Hat":
      {
         if(att.equals("Resistance"))
            value += 3;
            break;
      }
      case "Heli Baseball Cap":
      {
         if(att.equals("Resistance"))
            value += 6;
            break;
      }
      case "Macabre Shirt":
      {
         if(att.equals("Magic"))
            value += 2;
         else if(att.equals("Resistance"))
            value += 1;
         break;
      }
      case "Katz Shirt":
      {
         if(att.equals("Defense"))
            value += 4;
         else if(att.equals("Resistance"))
            value += 3;
         break;
      }
      case "Demin Jacket":
      {
         if(att.equals("Defense"))
            value += 7;
         break;
      }
      case "Rabbit Onsie":
      {
         if(att.equals("Speed"))
            value += 6;
         else if(att.equals("Luck"))
            value += 4;
         break;
      }
      case "Leather Belt":
      {
         if(att.equals("Resistance"))
            value += 1;
            break;
      }
      case "Raider Helmet":
      {
         if(att.equals("Defense"))
            value += 2;
         else if(att.equals("Skill"))
            value += 3;
         break;
      }
      case "Amber Ring":
      {
         if(att.equals("Defense"))
            value += 3;
         break;
      }
      case "Zircon Ring":
      {
         if(att.equals("Resistance"))
            value += 2;
         break;
      }
      case "Fish Necklace":
      {
         if(att.equals("Resistance"))
            value += 4;
         break;
      }
      case "Light Black Robe":
      {
         if(att.equals("Defense"))
            value += 1;
         else if(att.equals("Resistance"))
            value += 3;
         break;
      }
      case "Assassin Headband":
      {
         if(att.equals("Instinct"))
            value += 6;
         else if(att.equals("Skill"))
            value += 7;
         break;
      }
      case "Combat Boots":
      {
         if(att.equals("Strength"))
            value += 6;
         else if(att.equals("Speed"))
            value += 5;
         break;
      }
      case "Assassin Leather Jacket":
      {
         if(att.equals("Defense") || att.equals("Resistance") || att.equals("Skill"))
            value += 3;
         else if(att.equals("Speed"))
            value += 2;
      }
      case "Champion's Brace":
      {
         if(att.equals("Strength"))
            value += 5;
         break;
      }
      case "Trix's Mask":
      {
         switch(att)
         {
            case "Max HP": value += 197; break;
            case "Strength": value += 7; break;
            case "Defense": value += 7; break;
            case "Magic": value += 0; break;
            case "Force": value += 6; break;
            case "Resistance": value += 6; break;
            case "Constitution": value += 7; break;
            case "Speed": value += 12; break;
            case "Limit": value += 7; break;
            case "Intelligence": value += 0; break;
            case "Instinct": value += 6; break;
            case "Luck": value += 10; break;
         }
      }
      }
      return equipStat(hat,armor,access1,access2,access3,att,x+1,value);
   }
   
   public static String[] equipStatChange(final String equip)
   {
      String str = "";
      switch(equip)
      {   case "Arrow-Proof Vest": str = "Defense"; break;
         case "Raider Chainmail": str =  "Defense"; break;
         case "XIII+1 Armor": str = "Defense"; break;
         case "Red Ring": str = "Strength"; break;
         case "Leather Raider Vest": str = "Defense"; break;
         case "Worn Leather Jacket": str = "Defense Resistance";  break;
         case "Leather Glove": str = "Skill"; break;
         case "Leather Raider Pads": str = "Defense Resistance"; break;
         case "Iron Scale Armor": str = "Defense"; break;
         case "Duelist Gloves": str = "Skill"; break;
         case "Evil Eye Necklace": str = "Resistance"; break;
         case "Plate Armor": str = "Defense"; break;
         case "Running Shoes": str = "Speed"; break;
         case "Mich": str = "Defense Resistance"; break;
         case "Flame Retardant Gloves": str = "Resistance"; break;
         case "Gladiator Leather Vest": str = "Defense Resistance"; break;
         case "Track Shoes": str = "Speed"; break;
         case "Rubber Glove": str = "Skill"; break;
         case "Clover Wristband": str = "Luck"; break;
         case "Power Bracelet": str = "Strength"; break;
         case "Shark Tooth Necklace": str = "Strength"; break;
         case "Biohazard Suit": str = "Resistance"; break;
         case "Magic Enhancer Glove": str = "Skill Magic"; break;
         case "Metal Shoulder Pads": str = "Resistance Defense"; break;
         case "Dog Tag": str = "Strength Skill"; break;
         case "Sunglasses": str = "Instinct"; break;
         case "Magician Hat": str = "Magic Resistance"; break;
         case "Feng Shui Coin": str = "Luck"; break;
         case "Sun Hat": str = "Resistance"; break;
         case "Lunar Baseball Cap": str = "Resistance"; break;
         case "Heli Baseball Cap": str = "Resistnace"; break;
         case "Macabre Shirt": str = "Magic Resistance"; break;
         case "Katzy Shirt": str = "Defense Resistance"; break;
         case "Demin Jacket": str = "Defense"; break;
         case "Rabbit Onsie": str = "Speed Luck"; break;
         case "Leather Belt": str = "Resistance"; break;
         case "Raider Helmet": str = "Defense Skill"; break;
         case "Amber Ring": str = "Defense"; break;
         case "Zircon Ring": str = "Resistance"; break;
         case "Fish Necklace": str = "Resistance"; break;
         case "Light Black Robe": str = "Defense Resistance"; break;
         case "Assassin Leather Jacket": str = "Defense Resistance Skill Speed"; break;
         case "Combat Boots": str = "Strength Speed"; break;
         case "Assassin Headband": str = "Instinct Skill"; break;
         case "Champion's Brace": str = "Strength"; break;
         //Huamn's Mask
         case "Trix's Mask": str = "Max HP Strength Defense Magic Force Resistance Constitution Speed Skill Limit Intelligence Instinct Luck"; break;
      }
      return str.split(" ");
   }
}