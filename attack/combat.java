package attack;
import java.io.*;
import java.util.*;
import Character.Playable;
import Character.Initiative;
import Character.files;
import Weapon.Weapon;
import Weapon.weaponList;
import Weapon.handToHand;
import Weapon.handToHandList;
import Weapon.AttackMagic;
import Weapon.attackMagicList;
import Weapon.SupportMagic;
import Weapon.supportMagicList;
import Weapon.Force;
import Weapon.forceList;
public class combat
{
   public static void initiative(final Scanner kb) throws FileNotFoundException
   {
      System.out.println("\n--- Roll For Initative! ---\n");
      Playable [] names = information.gather.partyNames(kb);
      int [] rolls = information.gather.calculateRolls(names,information.gather.partyRolls(names,kb),"Speed");
      Initiative [] init = new Initiative[names.length];
      System.out.println("\n--- Avare Command ---\n!multiline");
      for(int x = 0; x < names.length; x++)
      {
         init[x] = new Initiative(names[x].getName(),rolls[x]);
         System.out.println("!init add " + rolls[x] + " " + names[x].getName().replaceAll(" ","_") + " -hp "  + names[x].getAttribute("Max HP") + " -p -h");
      }
      init = sort(init);
      tankard(new Random());
      combat(names,init,kb);
   }
   public static void tankard(final Random r)//Move to Special Folder
   {
      int roll = r.nextInt(100)+1;
      if(roll >= 75)
         System.out.println("Tankard casts The God's Blessing - Apply Blessing When Possible");
   }
   public static Initiative [] checkOrder(final Playable [] names, Initiative [] order,final Scanner kb)
   {
      ArrayList <Initiative> result = new ArrayList<Initiative>();
      if(names.length == order.length || order.length == 0)
      {
         for(int x = 0; x < names.length; x++)
         {
            String name = names[x].getName();
            for(int y = 0; y < order.length; y++)
            {
               String orderName = order[y].getName();
               if(name.equals(orderName))
                result.add(order[y]);
            }
         }
         result.trimToSize();
         return sort(information.gather.toInitiativeArray(result));
      }
      else if(order.length <= names.length)//If we added a character
      {
         for(int x = 0; x < names.length; x++)
         {
            String name = names[x].getName();
            boolean isOrder = false;
            for(int y = 0; y < order.length; y++)
            {
               String orderName = order[y].getName();
               if(name.equals(orderName))
               {
                  isOrder = true;
                  result.add(order[x]);
                  break;
               }
            }
            if(isOrder == false)
            {
               System.out.print("Enter " + names[x].getName() + "'s Roll: ");
               int roll = kb.nextInt(); kb.nextLine();
               roll += names[x].getAttribute("Speed");
               result.add(new Initiative(names[x].getName(),roll));
               
            }
         }
         result.trimToSize();
         return sort(information.gather.toInitiativeArray(result));
      }
      return order;
   }
   public static void combat(Playable [] names, Initiative [] order, final Scanner kb) throws FileNotFoundException
   {
      int choice = -1;
      do
      {   
        howManyAttacks(names);
         do
         {
            //names = affliction.afflictionInfo.isAlive(names,kb);
            //printHP(names);
            printOrder(order);
            choice = menu(kb);
            switch(choice){
            case 1: names = attackMenu(names,kb); break;
            case 2: names = changeMenu(names,kb);
                    order = checkOrder(names,order,kb); break;
            case 3: printStats(names,kb); break;
            case 4: attribute.rolls.basicRolls(kb);break;
            case 5: calculate.limitCheck(names,kb); break;
            }
            if(choice == 6 || choice == 0)
               break;
         }while(choice != 0);
         if(choice == 0)
            break;
            
         order = moveUp(order);
      }while(choice != 0);
      attribute.EXP.gainEXP(names,kb);
   }
   public static int menu(final Scanner kb)
   {
      System.out.println("\n--- Battle Menu ---\n1. Attack\n2. Manual Changes\n3. Check Status\n4. Basic Rolls\n5. Limit Check\n6. End Turn\n0. End Battle");
      System.out.print("Enter your choice: ");
      int choice = kb.nextInt(); kb.nextLine();
      return choice;
   }
   public static Playable [] changeMenu(Playable [] names,final Scanner kb) throws FileNotFoundException
   {
      System.out.println("\n--- Change Menu ---\n1. Add/Remove Affliction\n2. Change Stat\n3. Add/Remove Equipment\n4. Add/Remove Character\n5. Make New Enemy");
      System.out.print("Enter your choice: ");
      int choice = kb.nextInt(); kb.nextLine();
      switch(choice)
      {
         case 1: names = changeStat(names,kb); break;
         case 2: names = changeAttribute(names,kb); break;
         case 3: names = addRemoveEquipment(names,kb); break;
         case 4: names = addRemoveCharacters(names,kb); break;
         case 5: enemy.create.createEnemy(kb); break;
         
      }
      return names;
   }
   public static Playable [] attackMenu(Playable [] names, final Scanner kb) throws FileNotFoundException
   {
      System.out.println("\n--- Attack Menu ---\n");
      System.out.println("1. Weapon\n2. Hand To Hand\n3. Attack Magic\n4 Force Attack\n5. Healing\n6. Limit Attacks\n7. Affliction Check");
      System.out.print("Enter your choice: ");
      int choice = kb.nextInt(); kb.nextLine();
      switch(choice)
      {
            case 1: names = weaponAttack(names,false,kb);
                    break;
            case 2: names = handCombat(names,false,kb);
                    break;
            case 3: names = attackMagic(names,kb);
                    break;
            case 4: names = forceAttack(names,kb);
                    break;
            case 5: names = healing(names,kb);
                    break;
            case 6: names = limits(names,kb);
                    break;
            case 7: names = affliction.afflictionInfo.afflictionMenu(names,kb);
                    break;
      }
      return names;
   }
   public static Playable [] weaponAttack(Playable [] characters,boolean instinct,final Scanner kb) throws FileNotFoundException
   {
      int atkRoll;
      Playable [] targets;
      int [] defRoll;
      boolean pro;
      boolean [] hits, crits;
      System.out.println("\n--- Weapon Attack ---\n");
      
      System.out.print("Who is attacking: ");
      Playable attacker = information.gather.isInBattle(new Playable(kb.nextLine()),characters);
      System.out.print("Enter " + attacker.getName() + "'s Weapon: ");
      Weapon weapon = weaponList.checkWeapon(kb.nextLine().toLowerCase().trim());
      pro = weapon.checkPro(attacker.getWeaponPro());
      
      System.out.print("Enter " + attacker.getName() + "'s Roll: ");
      atkRoll = kb.nextInt(); kb.nextLine();
      
      //Done on seperate lines so that areInBattle is not taking the incorrect Playable variables and then not able to print the respective character
      targets = information.gather.partyNames(kb);
      targets = information.gather.areInBattle(targets,characters);
      defRoll = information.gather.partyRolls(targets,kb);
      hits = new boolean[targets.length];
      boolean [] strikeAgain = new boolean[targets.length];
      System.out.println("\n--- Result ---\n");
      hits = attack.calculate.physicalAccuracy(attacker,atkRoll,targets,defRoll,weapon);
      for(int x = 0; x < hits.length; x++)
      {
         if(hits[x] == true)
            characters = attack.calculate.getPhysicalDamage(characters, attacker,atkRoll,targets[x],defRoll[x],weapon,instinct);
         else
         {
            System.out.println(targets[x].getName() + " dodged " + attacker.getName() + "'s attack!");
            boolean counter = attack.calculate.instinctRate(targets[x],instinct);
            if(counter == true)
            {
               System.out.println(targets[x].getName() + " can counter " + attacker.getName() + "'s attack!");
               strikeAgain[x] = true;
            }
         }
      }
      /*for(int x = 0; x < targets.length; x++)
      {
         hits = Playable.accuracy(atkRoll,defRoll,targets,false);
         if(hits[x] == true)
         {
            crits[x] = attacker.checkPhysicalCrit(attacker,targets[x],atkRoll,defRoll[x]);
            int DMG = weapon.calculateDamage(attacker,targets[x],crits[x]);
            characters = dealDamage(targets[x],characters,DMG);
            characters = afflictionCheck(targets[x],characters,weapon);
            System.out.print(targets[x].getName() + " takes "  + DMG + " damage");
            if(crits[x] == true)
               System.out.println(" and takes critical damage!");
            else
               System.out.println("!"); 
         }
         else
         {
            hits[x] = false;
            crits[x] = false;
            if(weapon.getProjectile() == false)
               characters = instinctCounter(targets[x],attacker,characters,new Random(),kb);
         }
      }*/
      for(int x = 0; x < strikeAgain.length; x++)
      {
         if(strikeAgain[x] == true)
         {
            System.out.println("Countering for " + targets[x].getName());
            characters = counterMenu(characters,kb);
         }
      }
      return characters;
   }
   public static Playable [] counterMenu(Playable [] characters, final Scanner kb) throws FileNotFoundException
   {
      System.out.println("\n--- Counter Menu ---\n\n1. Weapon\n2. Hand To Hand");
      System.out.print("Enter your choice: ");
      int choice = kb.nextInt(); kb.nextLine();
      switch(choice)
      {
         case 1: characters = weaponAttack(characters,true,kb); break;
         case 2: characters = handCombat(characters,true,kb); break;
      }
      return characters;
   }
   public static Playable [] handCombat(Playable [] characters, final boolean Instinct, final Scanner kb) throws FileNotFoundException
   {
      int atkRoll;
      Playable [] targets;
      int [] defRoll;
      boolean pro;
      boolean [] hits, crits;
      System.out.println("\n--- Hand To Hand Attack ---\n");
      
      System.out.print("Who is attacking: ");
      Playable attacker = information.gather.isInBattle(new Playable(kb.nextLine()),characters);
      System.out.print("Enter the style: ");
      String style = kb.nextLine();
      System.out.print("Enter the move: ");
      String attack = kb.nextLine();
      handToHand move = handToHandList.attackInfo(style,attack);
      pro = move.checkPro(attacker.getHandtoHand());
      System.out.print("Enter " + attacker.getName() + "'s Roll: ");
      atkRoll = kb.nextInt(); kb.nextLine();
      
      targets = information.gather.partyNames(kb);
      targets = information.gather.areInBattle(targets,characters);
      hits = new boolean[targets.length];

      defRoll = information.gather.partyRolls(targets,kb);
      boolean [] strikeAgain = new boolean[targets.length];
      System.out.println("\n--- Result ---\n");
      hits = calculate.physicalAccuracy(attacker,atkRoll,targets,defRoll);
      for(int x = 0; hits.length > x; x++)
      {
         if(hits[x] == true)
            characters = calculate.getPhysicalDamage(characters, attacker,atkRoll,targets[x],defRoll[x],move,Instinct);
         else
         {
            System.out.println(targets[x].getName() + " dodged " + attacker.getName() + "'s attack!");
            boolean counter = calculate.instinctRate(targets[x],Instinct);
            if(counter == true)
            {
               System.out.println(targets[x].getName() + " can counter " + attacker.getName() + "'s attack!");
               strikeAgain[x] = true;
            }
         }
      }
      /*
      System.out.println("\n--- Result ---\n");
      for(int x = 0; x < targets.length; x++)
      {
         defRoll[x] += targets[x].dodgeAttack();
         if(atkRoll >= defRoll[x])
         {
            hits[x] = true;
            crits[x] = attacker.checkPhysicalCrit(attacker,targets[x],atkRoll,defRoll[x]);
            int DMG = move.calculateDamage(attacker,targets[x],crits[x]);
            characters = dealDamage(targets[x],characters,DMG);
            System.out.print(targets[x].getName() + " takes "  + DMG + " damage");
            if(crits[x] == true)
               System.out.print(" and takes critical damage!");
            else
               System.out.print("!"); 
         }
         else
         {
            hits[x] = false;
            crits[x] = false;
            //characters = instinctCounter(targets[x],attacker,characters,new Random(),kb);
         }
      }*/
      for(int x = 0; x < strikeAgain.length; x++)
      {
         if(strikeAgain[x] == true)
         {
            System.out.println("Countering for " + targets[x].getName());
            characters = counterMenu(characters,kb);
         }
      }
      return characters;
   }
   public static Playable [] attackMagic(Playable [] characters, final Scanner kb) throws FileNotFoundException
   {
      int atkRoll;
      Playable [] targets;
      int [] defRoll;
      boolean pro;
      boolean [] hits, crits;
      
      System.out.println("\n--- Magic Attack ---\n");
      
      System.out.print("Who is attacking: ");
      Playable attacker = information.gather.isInBattle(new Playable(kb.nextLine()),characters);
      System.out.print("Enter the move: ");
      String spell = kb.nextLine();
      AttackMagic magic = attackMagicList.spellList(spell);
      pro = magic.checkPro(attacker.getMagicType());
      System.out.print("Enter " + attacker.getName() + "'s Roll: ");
      atkRoll = kb.nextInt(); kb.nextLine();
      targets = information.gather.partyNames(kb);
      targets = information.gather.areInBattle(targets,characters);
      defRoll = information.gather.partyRolls(targets,kb);
      boolean [] strikeAgain = new boolean[targets.length];
      System.out.println("\n--- Result ---\n");
      hits = calculate.magicAccuracy(attacker,atkRoll,targets,defRoll,magic);
      for(int x = 0; hits.length > x; x++)
      {
         if(hits[x] == true)
            characters = calculate.getMagicDamage(characters, attacker,atkRoll,targets[x],defRoll[x],magic);
         else
         {
            System.out.println(targets[x].getName() + " dodged " + attacker.getName() + "'s attack!");
         }
      }
      /*
      if(magic.getLimit() == false)
      {
         atkRoll += attacker.magicalAttack();
         targets = information.gather.partyNames(kb);
         targets = information.gather.areInBattle(targets,characters);
         defRoll = information.gather.partyRolls(targets,kb);
      }
      else
      {
         atkRoll = 10;
         targets = information.gather.partyNames(kb);
         targets = information.gather.areInBattle(targets,characters);
         defRoll = new int[targets.length];
         for(int x = 0; x < targets.length; x++)
            defRoll[x] = 0;
         
      }
      hits = new boolean[targets.length];crits = new boolean[targets.length];
      System.out.println("\n--- Result ---\n");
      for(int x = 0; x < targets.length; x++)
      {
         defRoll[x] += targets[x].dodgeAttack();
         if(atkRoll >= defRoll[x] || magic.getLimit() == true)
         {
            hits[x] = true;
            if(magic.getLimit() == false)//Limit attacks do not crit
               crits[x] = attacker.checkMagicCrit(attacker,targets[x],atkRoll,defRoll[x]);
            int DMG = magic.calculateDamage(attacker,targets[x],crits[x]);
            characters = dealDamage(targets[x],characters,DMG);
            characters = afflictionCheck(targets[x],characters,magic);
            System.out.print(targets[x].getName() + " takes "  + DMG + " damage");
            if(crits[x] == true)
               System.out.print(" and takes critical damage!\n");
            else
               System.out.print("!\n"); 
         }
         else
         {
            hits[x] = false;
            crits[x] = false;
         }
      }*/
      return characters;
   }
   public static Playable [] forceAttack(Playable [] characters, final Scanner kb) throws FileNotFoundException
   {
      int atkRoll;
      Playable [] targets;
      int [] defRoll;
      boolean pro;
      boolean [] hits, crits;
      
      System.out.println("\n--- Force Attack ---\n");
      
      System.out.print("Who is attacking: ");
      Playable attacker = information.gather.isInBattle(new Playable(kb.nextLine()),characters);
      System.out.print("Enter the move: ");
      String move = kb.nextLine();
      Force force = forceList.forceList(move);
      System.out.print("Enter " + attacker.getName() + "'s Roll: ");
      atkRoll = kb.nextInt(); kb.nextLine();
      targets = information.gather.partyNames(kb);
      targets = information.gather.areInBattle(targets,characters);
      defRoll = information.gather.partyRolls(targets,kb);
      boolean [] strikeAgain = new boolean[targets.length];
      System.out.println("\n--- Result ---\n");
      hits = calculate.forceAccuracy(attacker,atkRoll,targets,defRoll,force);
      for(int x = 0; hits.length > x; x++)
      {
         if(hits[x] == true)
            characters = calculate.getForceDamage(characters, attacker,atkRoll,targets[x],defRoll[x],force);
         else
         {
            System.out.println(targets[x].getName() + " dodged " + attacker.getName() + "'s attack!");
         }
      }
      return characters;
   }
   public static Playable [] healing(Playable [] characters, final Scanner kb) throws FileNotFoundException
   {
      Playable [] subjects;
      int healed;
      boolean pro;
      System.out.print("\n--- Healing Moves ---\n");
      Playable [] targets;
      System.out.print("Who is healing: ");
      Playable healer = information.gather.isInBattle(new Playable(kb.nextLine()),characters);
      System.out.print("Enter the spell: ");
      SupportMagic spell = supportMagicList.spellList(kb.nextLine());
      subjects = information.gather.areInBattle(information.gather.partyNames(kb),characters);
      System.out.println("\n--- Result ---\n");
      //pro = spell.checkPro(healer.getMagicType());
      //if(pro == false)
         //return characters;
      for(int x = 0; x < subjects.length; x++)
         characters = supportMagicList.useSpell(spell,subjects[x],characters);
      return characters;
      
   }
   public static Playable[] limits(Playable [] characters, final Scanner kb) throws FileNotFoundException
   {
      Playable [] targets;
      System.out.print("Who is attacking: ");
      Playable attacker = information.gather.isInBattle(new Playable(kb.nextLine()),characters);
      System.out.print("Enter the move: ");
      String spell = kb.nextLine();
      return limit.limitList(characters,attacker,spell,kb);
   }
   public static Playable[] afflictionCheck(Playable target, Playable [] character, Weapon weapon)
   {
      String name = target.getName();
      for(int x = 0; x < character.length; x++)
      {
         String list = character[x].getName();
         if(name.equals(list))
            character[x] = weapon.afflictionCheck(character[x]);
      }
      return character;
   }
   
   public static Playable[] afflictionCheck(Playable target, Playable [] character, AttackMagic Spell)
   {
      for(int x = 0; x < character.length; x++)
      {
         if(target.getName().equals(character[x].getName()))
            character[x] = Spell.afflictionCheck(character[x]);
      }
      return character;
   }
   public static Playable[] dealDamage(Playable target, Playable [] character, final int DMG)
   {
      for(int x = 0; x < character.length; x++)
      {
         if(target.getName().equals(character[x].getName()))
            character[x].takeDamage(DMG);
      }
      return character;
   }
   /*public static Playable [] instinctCounter(Playable target, Playable attacker,Playable[] characters, Random r, final Scanner kb) throws FileNotFoundException
   {
      int roll = r.nextInt(100)+1 + target.getAttribute("Instinct");
      if(roll >= 60)
      {
         System.out.println(target.getName() + " can attack " + attacker.getName());
         System.out.println("\n--- Counter Menu ---\n\n1. Weapon\n2. Hand To Hand");
         System.out.print("Enter your choice: ");
         int choice = kb.nextInt(); kb.nextLine();
         if(choice == 1)
         {
            int atkRoll;
            Playable [] targets;
            int [] defRoll;
            boolean pro;
            boolean [] hits, crits;
            System.out.println("\n--- Weapon Attack ---\n");
      
            System.out.print("Who is attacking: ");
            attacker = new Playable(kb.nextLine());
            System.out.print("Enter " + attacker.getName() + "'s Weapon: ");
            Weapon weapon = weaponList.checkWeapon(kb.nextLine().toLowerCase());
            pro = weapon.checkPro(attacker.getWeaponPro());
            
            System.out.print("Enter " + attacker.getName() + "'s Roll: ");
            atkRoll = kb.nextInt(); kb.nextLine();
            atkRoll += attacker.physicalAttack();
            
            targets = information.gather.partyNames(kb);
            targets = information.gather.areInBattle(targets,characters);
            defRoll = information.gather.partyRolls(targets,kb);
            hits = new boolean[targets.length];crits = new boolean[targets.length];
            System.out.println("\n--- Result ---\n");
            for(int x = 0; x < targets.length; x++)
            {//
               defRoll[x] += targets[x].dodgeAttack();
               if(atkRoll >= defRoll[x])
               {
                  hits[x] = true;
                  crits[x] = weapon.checkWeaponCrit(attacker,targets[x],atkRoll,defRoll[x]);
                  int DMG = (weapon.calculateDamage(attacker,targets[x],crits[x]))/2;
                  characters = dealDamage(targets[x],characters,DMG);
                  characters = afflictionCheck(targets[x],characters,weapon);
                  System.out.print(targets[x].getName() + " takes "  + DMG + " damage");
                  if(crits[x] == true)
                     System.out.print(" and takes critical damage!");
                  else
                     System.out.print("!"); 
               }
               else
               {
                  hits[x] = false;
                  crits[x] = false;
               }
            }
            }else if(choice == 2)
            {
               int atkRoll;
               Playable [] targets;
               int [] defRoll;
               boolean pro;
               boolean [] hits, crits;
               System.out.println("\n--- Hand To Hand Attack ---\n");
      
               System.out.print("Who is attacking: ");
               attacker = new Playable(kb.nextLine());
               System.out.print("Enter the style: ");
               String style = kb.nextLine();
               System.out.print("Enter the move: ");
               String attack = kb.nextLine();
               handToHand move = handToHandList.attackInfo(style,attack);
               pro = move.checkPro(attacker.getHandtoHand());
               System.out.print("Enter " + attacker.getName() + "'s Roll: ");
               atkRoll = kb.nextInt(); kb.nextLine();
               atkRoll += attacker.physicalAttack();
               
               targets = information.gather.partyNames(kb);
               targets = information.gather.areInBattle(targets,characters);
               defRoll = information.gather.partyRolls(targets,kb);
               hits = new boolean[targets.length];crits = new boolean[targets.length];
               System.out.println("\n--- Result ---\n");
               for(int x = 0; x < targets.length; x++)
               {
                  defRoll[x] += targets[x].dodgeAttack();
                  if(atkRoll >= defRoll[x])
                  {
                     hits[x] = true;
                     crits[x] = move.checkHandCrit(attacker,targets[x],atkRoll,defRoll[x]);
                     int DMG = move.calculateDamage(attacker,targets[x],crits[x])/2;
                     characters = dealDamage(targets[x],characters,DMG);
                     System.out.println(targets[x].getName() + " takes "  + DMG + " damage");
                     if(crits[x] == true)
                        System.out.print(" and takes critical damage!");
                     else
                        System.out.print("!"); 
                  }
                  else
                  {
                     hits[x] = false;
                     crits[x] = false;
                  }
               }
            }
      }//end of roll success;
      return characters;
   }*/
   public static Playable[] changeAttribute(Playable [] characters, final Scanner kb) throws FileNotFoundException
   {
      System.out.println("\n--- Attribute Change ---\n");
      System.out.print("Enter the attribute you are changing: ");
      String att = kb.nextLine();
      System.out.print("1. Add\n2. Subtract\nEnter your choice: ");
      int choice = kb.nextInt(); kb.nextLine();
      boolean remove = false;
      if(choice == 2)
         remove = true;
      System.out.print("Enter the rate: ");
      
      int rate = kb.nextInt(); kb.nextLine();
      if(remove == true)
         rate = rate * -1;
      Playable [] names = information.gather.partyNames(kb);
      names = information.gather.areInBattle(names,characters);
      for(int x = 0; x < names.length; x++)
      {
         String changeName = names[x].getName();
         for(int y = 0; y < characters.length; y++)
         {
            String characterName = characters[y].getName();
            if(characterName.equals(changeName))
            {
               characters[y].changeBonus(att,rate,remove);
               System.out.println(characterName + "'s " + att + " has been changed by " + rate);
               break;
            }
         }
      }
      /*String playerName = name.getName();
      if(att.equals("HP"))
      {
         for(int x = 0; x < characters.length;x++)
         {
            String listName = characters[x].getName();
            if(listName.equals(playerName))
            {
               if(remove == true)
                  characters[x].takeDamage(rate);
               else
                  characters[x].recoverHP(rate);  
            }
         }
      }
      else
      {
      for(int x = 0; x < characters.length; x++)
      {
         String listName = characters[x].getName();
         if(listName.equals(playerName))
            characters[x].changeBonus(att,rate,remove);
      }
      }*/
      return characters;
   }
   public static Playable [] changeStat(Playable [] characters, final Scanner kb) throws FileNotFoundException
   {
      System.out.println("\n--- Stat Change ---\n");
      System.out.print("1. Add\n2. Remove\nEnter your choice: ");
      int choice = kb.nextInt(); kb.nextLine();
      boolean remove = choice != 1;
      System.out.println("\n--Select Your Affliction--\nAcid,Blind,Bound,Burning,Cursed,Dead Magic,Doomed\nDrained,Enraged,Exhaustion,Frozen,Intoixcated,Panicking,Paralyzed\nPoisoned,OG Poisoned,Possessed,Silenced,Slag,Slow,Stasis\nTime Freeze,Blessed,Haste,Inspired,Leech,Relaxed,Protect,Pain Supress");
      String affliction = kb.nextLine();
      /*String chara = name.getName();
      for(int x = 0; x < characters.length; x++)
      {
         String matching = characters[x].getName();
         if(chara.equals(matching))
            characters[x].applyAffliction(characters[x],affliction,remove);
      }*/
      Playable [] names = information.gather.partyNames(kb);
      names = information.gather.areInBattle(names,characters);
      for(int x = 0; x < names.length; x++)
      {
         String afflictedName = names[x].getName();
         for(int y = 0; y < characters.length; y++)
         {
            String characterName = characters[y].getName();
            if(afflictedName.equals(characterName))
            {
               characters[y].applyAffliction(characters[y],affliction,remove);
               if(remove == true)
                  System.out.println(characterName + " is cured of " + affliction);
               else
                  System.out.println(characterName + " now has " + affliction);
               break;
            }
         }
      }
      return characters;
   }
   public static Playable [] addRemoveEquipment(Playable [] names, final Scanner kb) throws FileNotFoundException
   {
      System.out.print("What character are you changing: ");
      Playable character = information.gather.isInBattle(new Playable(kb.nextLine()),names);
      System.out.println("\n1. Add\n2. Remove");
      System.out.print("Enter your choice: ");
      int option = kb.nextInt(); kb.nextLine();
      System.out.println(character.printEquipment());
      if(option == 1)
      {
         System.out.print("\n1. Hat\n2. Armor\n3. Accessory 1\n4. Accessory 2\n5. Accessory 3\nWhat do you wish to add: ");
         int choice = kb.nextInt(); kb.nextLine();
         System.out.print("Enter the name of the item: ");
         String equip = kb.nextLine();
            switch(choice)
            {
               case 1: character.addHat(equip); break;
               case 2: character.addArmor(equip); break;
               case 3: character.addAccessory1(equip); break;
               case 4: character.addAccessory2(equip); break;
               case 5: character.addAccessory3(equip); break;
            }
         
      }else if(option == 2)
      {
         System.out.print("\n1. Hat\n2. Armor\n3. Accessory 1\n4. Accessory 2\n5. Accessory 3\nWhat do you wish to remove: ");
         int choice = kb.nextInt(); kb.nextLine();
            switch(choice)
            {
               case 1: character.removeHat(); break;
               case 2: character.removeArmor(); break;
               case 3: character.removeAccessory1(); break;
               case 4: character.removeAccessory2(); break;
               case 5: character.removeAccessory3(); break;
            }
      }
      String cName = character.getName();
      for(int x = 0; x < names.length; x++)
      {
         String lName = names[x].getName();
         if(cName.equals(lName))
            names[x] = character;
      }
      return names;  
   }
   public static Playable [] addRemoveCharacters(Playable [] characters,final Scanner kb) throws FileNotFoundException
   {
      System.out.println("1. Add\n2. Remove\n");
      int choice = kb.nextInt(); kb.nextLine();
      if(choice == 1)
      {
         System.out.print("Enter the name of the character you are adding: ");
         Playable newCharacter = new Playable(kb.nextLine());
         Playable [] result = new Playable[characters.length + 1];
         for(int x = 0; x < characters.length; x++)
         {
            result[x] = characters[x];
         }
         result[result.length - 1] = newCharacter;
         return result;
      }
      else if(choice == 2)
      {
         ArrayList <Playable> result = new ArrayList <Playable>();
         System.out.print("Enter the name of the character you are removing: ");
         String name = kb.nextLine();
         for(int x = 0; x < characters.length; x++)
         {
            String characterName = characters[x].getName();
            if(!(characterName.equals(name)))
               result.add(characters[x]);
         }
         result.trimToSize();
         return information.gather.toPlayableArray(result);
      }
      System.out.println("Invalid Choice");
      return characters;
         
   }
   public static Initiative [] sort(Initiative [] init)
   {
      for(int x = 0; x < init.length; x++)
      {
         for(int y = 0; y < init.length; y++)
         {
            if(init[x].getInitPTS() >= init[y].getInitPTS() && x != y)
            {
               Initiative temp = new Initiative(init[x].getName(),init[x].getInitPTS());
               init[x] = new Initiative(init[y].getName(),init[y].getInitPTS());
               init[y] = temp;
            }
         }
      }
      return init;
   }
   public static Initiative [] moveUp(Initiative [] order)
   {
      Initiative [] result = new Initiative[order.length];
      for(int x = 0; x < order.length - 1; x++)
      {
         result[x] = order[x+1];
      }
      result[order.length - 1] = order[0];
      return result;
   }
   public static void printOrder(Initiative [] order)
   {
      System.out.println("\n--- Battle Order ---\n");
      System.out.println("--" + order[0].getName());
      for(int x = 1; x < order.length; x++)
      {
         System.out.println(order[x].getName());
      }
      System.out.println("\nIt is " + order[0].getName() + "'s Turn.");
      if(order.length > 1)
         System.out.println("\nOn Deck: " + order[1].getName());
   }
   public static void printHP(Playable [] names)
   {
      System.out.println("\n--- Health ---\n");
      for(int x = 0; x < names.length; x++)
      {
         System.out.println(names[x].getName() + ": " + names[x].printHP());
      }
   }
   public static void printStats(Playable [] characters, final Scanner kb) throws FileNotFoundException
   {
      System.out.print("What character are you checking: ");
      Playable name = information.gather.isInBattle(new Playable(kb.nextLine()),characters);
      String selected = name.getName();
      name.printStat(kb);      
   }
   public static void howManyAttacks(final Playable [] names) throws FileNotFoundException
   {
      ArrayList <String> pc = files.pcFinder(), attackinfo = new ArrayList <String>();
      for(int x = 0; x < names.length; x++)
      {
         String str = "";
         for(int y = 0; y < names.length; y++)
         {

            int atkSpeed = names[x].getAttribute("Speed");
            int defSpeed = names[y].getAttribute("Speed"), counter = 1;
            //PC1 and PC2 check for if the Archetype of the characters are "Playable"
            boolean enemies = checkEnemies(names[x],names[y]);
            if(y != x)
            {
               while(atkSpeed - 10 >= defSpeed)
               {
                  counter++;
                  atkSpeed = atkSpeed - 10;
               }
               if(counter >= 2 && enemies == true)
               {
                  str += "x" + counter + " " + names[y].getName() + " ||";
               }
               if((!(str.isEmpty())) && y == names.length - 1)
               {
                  System.out.println("!init note " + names[x].getName().replace(" ","_") + " || " + str);
               }
            }
         }
      }
      
   }
   public static boolean checkEnemies(Playable player1, Playable player2)
   {
      //This method will check for different archetypes and determine if they are considered friends or foe.
      String archetype1 = player1.getArchetype(), archetype2 = player2.getArchetype();
      boolean PC = archetype1.equals("PC") && archetype2.equals("PC");
      if(PC == true)
         return false;
      else
      {
         PC = !(archetype1.equals("PC")) && !(archetype2.equals("PC"));
         if(PC == false)
         {
            return true;
         }
         else
         {
            return false;
         }
      }
   }
}