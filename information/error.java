package information;
import java.io.*;
import java.util.*;
public class error
{
   public static String checkFileName(String name,final Scanner kb)
   {
      //Designed to check for file's existance in the proper character directory
      File file = new File(name);
      String dir = file.getAbsolutePath();
      String [] split = dir.split(name);
      file = new File(split[0] + "\\Character\\sheet\\" + name + ".txt");
      while(!(file.exists()))
      {
         System.out.print("ERROR: File Name Does Not Exist!\nPlease enter the name: ");
         name = kb.nextLine();
         file = new File(name);
         dir = file.getAbsolutePath();
         split = dir.split(name);
         file = new File(split[0] + "\\Character\\sheet\\" + name + ".txt");
      }
      return name;
   }
   public static int attributeCheck(int pts)
   {
      //Simply checks to make sure no Attribute Points are below 0.
      if(pts <= -1)
         return 0;
      else
         return pts;
   }
}