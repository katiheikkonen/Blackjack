import java.util.Scanner;

import java.util.InputMismatchException;
import src.Cards.*;
import src.Player.*;

class BlackjackGame {

    private Scanner sc = new Scanner(System.in);


    public void downloadGame() {

        try {
            Player player = PlayerData.downloadPlayerData();
            Dealer dealer = new Dealer();
            playGame(dealer, player);
        } catch (NullPointerException n) {
            initializeGame();
        }
    }

    public void initializeGame() {

        System.out.print("Type player name: ");
        String playerName = sc.nextLine();

        Player player = new Player(playerName);

        Dealer dealer = new Dealer();

        playGame(dealer, player);
    }

    public void playGame(Dealer dealer, Player player) {

        Deck deck = new Deck();
        deck.shuffle();

        boolean playing = true;

        while(playing) {

            boolean betting = true;

            while(betting) {
                
                try {
                    System.out.println("Chips in account: " + player.getChips() + ". Please bet chips:");
                    int bet = sc.nextInt();
                        if (bet <= player.getChips()) {
                            player.setBet(bet);
                            break;
                        }
                        else { System.out.println("You don't have enough chips.");
                        }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input");
                    sc.nextLine();
                }
            }

            Hand dealerHand = new Hand();
            dealStartingHand(dealer, dealerHand, deck);
            Hand playerHand = new Hand();
            dealStartingHand(player, playerHand, deck);
            
            boolean playerTurn = true;
            boolean dealerTurn = true;
            System.out.println("Player turn");

            while(playerTurn) {

                if (checkBust(sc, player, playerHand, player)) {
                    dealerTurn = false;
                    break;
                }

                if (checkBlackjack(sc, player, playerHand, player)) {
                    dealerTurn = false;
                    break;
                }

                System.out.println("Hit or Stand? Enter H or S: ");

                Character hitOrStand = sc.next().trim().charAt(0);
             
                if (Character.toUpperCase(hitOrStand) == 'H') {
                    playerHand.addCard(deck.hitCard());
                    System.out.println("Cards:\n" + playerHand.getHand());
                    playerHand.getHandValue();

                    if (checkBust(sc, player, playerHand, player)) {
                        dealerTurn = false;
                        break;
                    }
    
                    if (checkBlackjack(sc, player, playerHand, player)) {
                        dealerTurn = false;
                        break;
                    }
                }
                else if(Character.toUpperCase(hitOrStand) == 'S') {
                    break;
                }
                else {
                    System.out.println("You typed " + hitOrStand + ". Please type H or S");
                }
            }
 
            if (dealerTurn) {
                System.out.println("Dealer turn");
            }

            while(dealerTurn) {

                dealerHand.getLast().showHidden();

                System.out.println(dealer.getName() + "'s cards:\n" + dealerHand.getHand());

                if (checkBust(sc, dealer, dealerHand, player)) {
                    break;
                }

                if (checkBlackjack(sc, player, playerHand, player)) {
                    break;
                }

                if (dealerHand.getHandValue() > Dealer.DEALER_STAND ) {
                    System.out.println("Dealer stands");

                    if (dealerHand.getHandValue() > playerHand.getHandValue()) {
                        System.out.println("Player loses");
                        loseBet(player);
                        continuePlaying(sc, player);
                        break;
                    }
                    else {
                        System.out.println("Player wins");
                        winBet(player);
                        continuePlaying(sc, player);
                        break;
                    }
                }
                else {
                    dealerHand.addCard(deck.hitCard());
                    System.out.println("Dealer cards:\n" + dealerHand.getHand());
                }
            }
        }
    }
    
    public void continuePlaying(Scanner sc, Player player) {
        if (player.getChips() == 0) {
            System.out.println("You have no chips left for playing. Please start a new game.");
            // tyhjennä peliin tallennettu pelaaja pois
            PlayerData.deletePlayerData();
            sc.close();
            System.exit(0);
        }
        System.out.println("Do you want to continue playing?");

        System.out.println("Continue playing: Enter Y.");
        System.out.println("Save and end game. Enter S.");
        System.out.println("End game without saving. Enter N.");

        boolean continuePlaying = true;

        while(continuePlaying) {

            Character continueGame = sc.next().trim().charAt(0);

            if (Character.toUpperCase(continueGame) == 'Y') {
                break;
            }
            else if(Character.toUpperCase(continueGame) == 'S') {
                PlayerData.savePlayerData(player);
                closeGame();
            }
            else if(Character.toUpperCase(continueGame) == 'N') {
                closeGame();
            }
            else {
                System.out.println("You typed " + continueGame + ". Please type Y, S or N");
            }
        }
    }

    public void loseBet(Player player) {
        player.loseChips();
        player.clearBet();
        System.out.println("Total chips: " + player.getChips());
    }

    public void winBet(Player player) {
        player.addChips();
        player.clearBet();
        System.out.println("Total chips: " + player.getChips());
    }

    public void dealStartingHand(BlackjackPlayer currentPlayer, Hand hand, Deck deck) {

        hand.addCard(deck.hitCard());

        if (currentPlayer instanceof Dealer) {
            Card hiddenCard = deck.hitCard();
            hiddenCard.setHidden();
            hand.addCard(hiddenCard);
        }
        else {
            hand.addCard(deck.hitCard());
        }
        System.out.println(currentPlayer.getName() + "'s cards:\n" + hand.getHand());
    }

    public boolean checkBust(Scanner sc, BlackjackPlayer currentPlayer, Hand hand, Player player) {
        if (currentPlayer instanceof Player) {
            if (hand.bust()) {
                System.out.println("You have over 21. You lose");
                loseBet(player);
                continuePlaying(sc, player);
                return true;
            }
            else {
                return false;
            }
        }
        if (currentPlayer instanceof Dealer) {
            if (hand.bust()) {
                System.out.println("Dealer has over 21. You win");
                winBet(player);
                continuePlaying(sc, player);
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public boolean checkBlackjack(Scanner sc, BlackjackPlayer currentPlayer, Hand hand, Player player) {
        if (currentPlayer instanceof Player) {
            if (hand.blackjack()) {
                System.out.println("You have Blackjack! You win");
                winBet(player);
                continuePlaying(sc, player);
                return true;
            }
            else {
                return false;
            }
        }
        if (currentPlayer instanceof Dealer) {
            if (hand.blackjack()) {
                System.out.println("Dealer has Blackjack! You lose");
                loseBet(player);
                continuePlaying(sc, player);
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public void closeGame() {
        System.out.println("Closing game. Thanks for playing!");
        sc.close();
        System.exit(0);
    }
}
