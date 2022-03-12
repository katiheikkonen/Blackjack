package src.Cards;
public class Card {

    private Ranks rank;
    private Suits suit;
    private boolean hiddenCard;

    public Card() {
    }

    public Card(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
        this.hiddenCard = false;
    }

    public Card(Suits suit, Ranks rank, boolean hiddenCard) {
        this.suit = suit;
        this.rank = rank;
        this.hiddenCard = true;
    }

    public int getValue() {
        if (hiddenCard) {
            return 0;
        }
        else {
            return rank.getValue();
        }
    }

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

    public void setHidden() {
        this.hiddenCard = true;
    }

    public boolean isHidden() {
        return this.hiddenCard;
    }

    public void showHidden() {
        this.hiddenCard = false;
    }
}
