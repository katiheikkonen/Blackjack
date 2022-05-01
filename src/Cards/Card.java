package src.Cards;

/**
* Class that depicts card in deck
* Card has always suit and rank
* Hidden card boolean is used to hide dealer second card before dealer turn
*/
public class Card {
    private Ranks rank;
    private Suits suit;
    private boolean hiddenCard;

    /**
    * Constructor for class
    */
    public Card(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
        this.hiddenCard = false;
    }

    /**
    * Constructor for class
    * Used for dealer hidden card logic
    */
    public Card(Suits suit, Ranks rank, boolean hiddenCard) {
        this.suit = suit;
        this.rank = rank;
        this.hiddenCard = true;
    }

    /**
    * @return value of the card using Ranks enum method
    */
    public int getValue() {
        if (hiddenCard) {
            return 0;
        }
        else {
            return rank.getValue();
        }
    }

    /**
    * @return String format for the card 
    * Used for informing the player on the current cards in hand
    */
    public String getCard() {
        if (hiddenCard) {
            return "[Hidden Card]\n";
        }
        else {
            return (rank.toString()).charAt(0) + 
            (rank.toString().substring(1).toLowerCase()) + 
            " of" +  suit.getSuit() + "\n";
        }
    }

    /**
    * Set card as hidden (does not show value)
    */
    public void setHidden() {
        this.hiddenCard = true;
    }

    /**
    * Set card as hidden (does not show card value in getValue() method)
    */
    public boolean isHidden() {
        return this.hiddenCard;
    }

    /**
    * Set hidden card as public (shows card value in getValue() method)
    */
    public void showHidden() {
        this.hiddenCard = false;
    }
}
