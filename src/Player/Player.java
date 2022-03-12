package src.Player;

import java.io.Serializable;

public class Player extends BlackjackPlayer implements Serializable {

    private int chips;
    private int bet;
    private String name;
    private static final long serialVersionUID = 1L;

    public Player(String name) {
        this.name = name;
        this.bet = 0;
        this.chips = 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public void clearBet() {
        this.bet = 0;
    }

    public void addChips() {
        this.chips += bet;
    }

    public void loseChips() {
        this.chips -= bet;
    }

    public int getChips() {
        return chips;
    }
}
