package src.Player;
import java.io.*;

public class PlayerData {

   public static void savePlayerData(Player player) {
           
      try {
         FileOutputStream fileOut =
         new FileOutputStream("/tmp/player.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(player);
         out.close();
         fileOut.close();
         System.out.printf("Player is saved.\n");
      } catch (IOException i) {
         i.printStackTrace();
      }
   }

   public static Player downloadPlayerData() {
      Player player = null;
      try {
         FileInputStream fileIn = new FileInputStream("/tmp/player.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         player = (Player) in.readObject();
         in.close();
         fileIn.close();
         System.out.println("Player...");
         System.out.println("Name: " + player.getName());
      } catch (IOException i) {
         System.out.println("There is no saved game. Starting new game");
      } catch (ClassNotFoundException c) {
         System.out.println("There is no saved game. Starting new game");
         c.printStackTrace();
   }
      return player;
   }

   public static void deletePlayerData() {
      File file = new File("/tmp/player.ser");
      if (file.delete()) { 
         return;
       } else {
         return;
       }
   }
}