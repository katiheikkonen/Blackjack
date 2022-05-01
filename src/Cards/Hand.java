package src.Cards;
import java.util.LinkedList;

/**
* Class that depicts player card hand
* Contains LinkedList of Card objects
* Hidden card boolean is used to hide dealer second card before dealer turn
*/
public class Hand {
    private LinkedList<Card> cards;
    public static final int BLACKJACK = 21;

    /**
    * Constructor for Hand object
    * Creates empty LinkedList for cards
    */
    public Hand() {
        this.cards = new LinkedList<>();
    }

    /**
    * @return hand all cards in player hand in String format
    * @see src.Cards.Card#getCard()
    */
    public String getHand() {
        String hand = "";
        for (Card card: cards) {
            hand += card.getCard();
        }
        return hand;
    }

    /**
    * @return hand all cards in player hand in String format
    * @see java.util.LinkedList#getLast()
    * Gives last element in list
    */
    public Card getLast() {
        return cards.getLast();
    }

    /**
    * @return total hand value 
    * Contains Ace logic for giving ace either value 1 or 11
    * Ace value is determined by whether value of hand would go over 21 or not
    */
    public int getHandValue() {
        int total = 0;
        boolean ace = false;
        
        for (Card card: cards) {
            if (!card.isHidden());
                int value = card.getValue();
                if (value == 1) {
                    ace = true;
                }
                total += value;
        }
        if (ace && total + 10 <= BLACKJACK) {
			total += 10;
		}
        return total;
    }

    /**
    * @param card object to add to player hand
    */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
    * @return true if player hand value is 21 (Blackjack)
    */
    public boolean blackjack() {
        return this.getHandValue() == BLACKJACK;
    }

    /**
    * @return true if player hand value is over 21 (Player is bust)
    */
    public boolean bust() {
        return this.getHandValue() > BLACKJACK;
    }
}
