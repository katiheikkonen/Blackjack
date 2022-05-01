package src.Cards;

/**
* Enum for Card suits, including their String format
*/
public enum Suits {

    HEARTS(" Hearts"),
    SPADES(" Spades"),
    DIAMONDS(" Diamonds"),
    CLUBS(" Clubs");

    private final String suit;
    
    /**
    * Constructor for card suit
    * @param suit String format of the suit
    */
    private Suits(String suit){
        this.suit = suit;
    }

    /**
    * @return suit of the card in String format
    */
    public String getSuit(){
        return suit;
    }
}
