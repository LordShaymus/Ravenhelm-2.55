package main;
import java.io.*;
import java.util.*;
public class ravenMain
{
   public static void main(String [] args) throws FileNotFoundException
   {
      Scanner kb = new Scanner(System.in);
      Random r = new Random();
      int choice;
      do
      {
         choice = menu(kb);
         switch(choice){
            case 1: attribute.rolls.basicRolls(kb);
                    break;
            case 2: attack.combat.initiative(kb);
                    break;
            case 3: enemy.create.createEnemy(kb);
                    break;
         }
      }while(choice != 0);
   }
   public static int menu(final Scanner kb)
   {
      System.out.println("\n--- Main Menu ---\n1. Basic Checks\n2. Engage Combat\n0. Quit");
      System.out.print("Enter your choice: ");
      int choice = kb.nextInt(); kb.nextLine();
      return choice;
   }
}