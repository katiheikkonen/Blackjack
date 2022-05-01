package src.Cards;
import java.util.ArrayList;
import java.util.Collections;


/**
* Class depicts card deck that contains ArrayList for Card objects
*/
public class Deck {

    private ArrayList<Card> cards;

    /**
    * Constructor for deck, adds a card for every suit and rank combination (total 52)
    */
    public Deck() {
        this.cards = new ArrayList<Card>();
        for (Suits s : Suits.values()) {
            for (Ranks r : Ranks.values()) {
                 Card card = new Card(s,r);
                 cards.add(card);
            }  
        }
    }

    /**
    * Shuffles the cards in deck to random order
    */
    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    /**
    * Removes one card from deck so that it can be added to player hand
    * Used in conjuction with src.Cards.Hand addCard() method
    * @see src.Cards.Hand#addCard(Card card)
    */
    public Card hitCard() {
        return cards.remove(0);
    }
}