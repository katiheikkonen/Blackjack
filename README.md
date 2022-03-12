# Blackjack

This project implements Blackjack game with the following features:

## Rules

- Players' goal is to beat the dealer’s hand without going over 21. 
- Player will receive 2 cards at the beginning of each round, and values of these cards adds up. The dealer also draws two cards. Dealer second card is face down and only revealed after player turn.
- Cards 2-10 have face value; King, Queen, Jack are worth 10; and Aces are either a 1 or an 11 — it’s up to the player to decide.
- 21 is called Blackjack and means immediate win. 
- The aim of the game is to beat dealer hand (have a higher hand) without going over 21. 
- Player turn is always first
- If you would like the dealer to deal you another card, you tell him “hit”
- If you do not want to be dealt another card, you “stand”
- “Busting” is when the sum of your hand is over 21.
- In Dealer turn face down card is revealed. Dealer will continue playing until 17 and then stand.

The winner of the round is whoever has the highest hand without going bust.

## Usage

After familiarizing with the rules, new game can be started by running Main.java which initiates new Blackjack game from the Blackjack class.

When starting player can decide to either start a new game or download existing game. 

When choosing to start new game, you always start with 10 chips for betting. When finishing game player will be asked if they want to save their player. 

If player has played before and chooses to download existing game, game remembers player name and account total chips and you can continue to play with those. 

You can only have one game saved at a time and when account chips are down to zero, you need to start a new game.