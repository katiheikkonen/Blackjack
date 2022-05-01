package src.Player;

/**
* Concrete implementation of computer player
* Static final variable DEALER_STAND to ensure that Dealer stops playing when his hand value is 17 or more
*/
public class Dealer extends BlackjackPlayer {

    public static final int DEALER_STAND = 17;
    
    /**
    * Constructor that always sets computer player name as Dealer
    */
    public Dealer() {
        this.name = "Dealer";
    }
}
