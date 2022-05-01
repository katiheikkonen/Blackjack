package src.Player;

import src.Cards.Hand;

/**
* Abstract class for initializing player
* Includes both human player and computer player (dealer)
*/
public abstract class BlackjackPlayer {
    protected String name;
    protected Hand hand;

    /**
    * Constructor for class BlackjackPlayer
    */
    public BlackjackPlayer() {
    }

    /**
    * Constructor for class BlackjackPlayer
    * @param name player name in String format
    */
    public BlackjackPlayer(String name) {
        this.name = name;
    }

    /**
    * @param name Give player name in String format for player identification
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * @return String name for player identification
    */
    public String getName() {
        return name;
    }
}
