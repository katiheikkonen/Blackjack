package src.Cards;

public enum Suits {

    HEARTS(" Hearts"),
    SPADES(" Spades"),
    DIAMONDS(" Diamonds"),
    CLUBS(" Clubs");

    private final String suit;
    
    private Suits(String suit){
        this.suit = suit;
    }
    
    public String getSuit(){
        return suit;
    }
}
