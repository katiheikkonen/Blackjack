package src.Cards;
import java.util.LinkedList;

public class Hand {

    private LinkedList<Card> cards;
    public static final int BLACKJACK = 21;

    public Hand() {
        this.cards = new LinkedList<>();
    }

    public String getHand() {
        String hand = "";
        for (Card card: cards) {
            hand += card.getCard();
        }
        return hand;
    }

    public Card getLast() {
        return cards.getLast();
    }

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

    public void addCard(Card card) {
        cards.add(card);
    }

    public void addHiddenCard(Card card) {
        cards.add(card);
    }

    public boolean blackjack() {
        return this.getHandValue() == BLACKJACK;
    }

    public boolean bust() {
        return this.getHandValue() > BLACKJACK;
    }
}
