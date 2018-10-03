package Character;
import java.io.*;
public class Capability
{
   private String [] Weapon_Training;
   private String [] Hand_to_Hand_Training;
   private String [] Magic_Type;
   public Capability(final String name) throws FileNotFoundException
   {
      this.Weapon_Training = files.getPro(name,"Weapon Training");
      this.Hand_to_Hand_Training = files.getPro(name,"Hand To Hand Training");
      this.Magic_Type = files.getPro(name,"Magic Type");
   }
   public String [] getWeaponPro(){return this.Weapon_Training;}
   public String [] getHandtoHand(){return this.Hand_to_Hand_Training;}
   public String [] getMagicType(){return this.Magic_Type;}
}