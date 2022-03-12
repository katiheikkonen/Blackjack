package src.Cards;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
        for (Suits s : Suits.values()) {
            for (Ranks r : Ranks.values()) {
                 Card card = new Card(s,r);
                 cards.add(card);
            }  
        }
    }
   
    public void shuffle() {
        Collections.shuffle(this.cards);
    }
    
    public Card hitCard() {
        return cards.remove(0);
    }
}