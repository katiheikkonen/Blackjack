package src.Player;

import src.Cards.Hand;

public abstract class BlackjackPlayer {
    protected String name;
    protected Hand hand;

    public BlackjackPlayer() {
    }

    public BlackjackPlayer(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
