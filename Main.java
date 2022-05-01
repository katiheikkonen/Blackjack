import java.util.Scanner;

public class Main{

    /**
    * Used for either starting a new game or downloading existing game
    */
    public static void main(String[] args){
        Blackjack game = new Blackjack();
        boolean startingGame = true;

        Scanner sc = new Scanner(System.in);

        System.out.println("To start a new game: Enter Y.");
        System.out.println("To download existing game: Enter D.");
        System.out.println("To close game: Enter N.");
    
        while(startingGame) {

            Character playGame = sc.next().trim().charAt(0);

            if (Character.toUpperCase(playGame) == 'Y') {
                game.initializeGame();
                break;
            }
            else if(Character.toUpperCase(playGame) == 'D') {
                game.downloadGame();
                break;
            }

            else if(Character.toUpperCase(playGame) == 'N') {
                System.out.println("Closing game");
                sc.close();
                break;
            }
            else {
                System.out.println("You typed " + playGame + ". Please type Y, D or N");
            }
        }
    }
}
    