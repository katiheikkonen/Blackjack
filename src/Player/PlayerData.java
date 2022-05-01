package src.Player;
import java.io.*;

/**
* Manages saving, downloading and deleting of player data
*/
public class PlayerData {

   /**
   * Saves player data to location /tmp/player.ser
   * @param player object of the Player to be saved
   * @throws java.io.IOException - Signals that an I/O exception of some sort has occurred. Exceptions are produced by failed or interrupted I/O operations.
   */
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

   /**
   * Downloads player data from location /tmp/player.ser
   * @throws java.lang.ClassNotFoundException - Signals that an I/O exception of some sort has occurred. Exceptions are produced by failed or interrupted I/O operations.
   * @throws java.io.IOException - No saved Player class found
   * @return player Player data of the saved player
   */
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

   /**
   * Deletes player data from location /tmp/player.ser if it exists
   */
   public static void deletePlayerData() {
      File file = new File("/tmp/player.ser");
      if (file.delete()) { 
         return;
       } else {
         return;
       }
   }
}