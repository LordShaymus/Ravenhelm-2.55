package Character;
import java.io.*;
import Character.Playable;
public class Initiative
{
   private String name;
   private int initPts;
   public Initiative(final String name, final int initPts)
   {
      this.name = name;
      this.initPts = initPts;
   }
   public String getName(){return this.name;}
   public int getInitPTS(){return this.initPts;}
}