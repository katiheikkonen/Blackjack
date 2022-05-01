package src.Cards;

/**
* Enum for Card ranks, including their values in Blackjack game
* Jack, queen and king always have value 10
* Ace can be either 1 or 11 but this is evaluated in Hand class
*/
public enum Ranks {
    
    ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), 
    SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    JACK(10), QUEEN(10), KING(10);
    
    private final int value;

    /**
    * @param value integet that sets card 
    */

    /**
    * Constructor for card rank
    * @param value value of the card as integer
    */
    private Ranks(int value) {
        this.value = value;
    }

    /**
    * @return value of the card as integer 
    */
    public int getValue() {
        return value;
    }
}
