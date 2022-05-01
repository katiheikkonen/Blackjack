package src.Player;
import java.io.Serializable;

/** Concrete implementation of human player */
public class Player extends BlackjackPlayer implements Serializable {

    private int chips;
    private int bet;
    private String name;
    private static final long serialVersionUID = 1L;

    /**
    * Constructor for player
    * Always sets starting chips for new player to 10 chips and bet to zero until decided
    */
    public Player(String name) {
        this.name = name;
        this.bet = 0;
        this.chips = 10;
    }

    /** {@inheritDoc} */
    public String getName() {
        return name;
    }

    /** {@inheritDoc} */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param bet give bet (number of chips as integer)
     */
    public void setBet(int bet) {
        this.bet = bet;
    }    
    
    /** Set bet to 0 so player can place new bet for next round */
    public void clearBet() {
        this.bet = 0;
    }

    /** Add won chips to player data */
    public void addChips() {
        this.chips += bet;
    }

    /** Remove lost chips from player data */
    public void loseChips() {
        this.chips -= bet;
    }

    /**
     * @return the amount of playing chips left
    */
    public int getChips() {
        return chips;
    }
}
