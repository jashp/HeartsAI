package players;

import game.Card;
import game.CardPile;
import game.Player;
import game.Trick;

/*************************
 * DumbPlayer keeps picking random cards until it finds a one that is a valid move. 
 * You can name your player whatever you want. (e.g. SuperAwesomeUnbeatablePlayer)
 * You can add whatever fields you want to your player and they will persist.
 * Your player class MUST:
 *  - extend Player
 *  - be a part of the players package
 *  - have the following 3 methods below (constructor, play, and getName)
 * Feel free to fork the rest of the project to make improvements and I'll pull them in.
 */
// You can name your player
public class DumbPlayer extends Player{

	public DumbPlayer(int id) {
		super(id);
	}

	/*************************
	 * This is where all the logic happens. 
	 * In addition to your hand and the cards on the table, you have access to:
	 *  - the nth trick that was played in the game: Trick trick = manager.getPastTrick(n); 
	 *  - whether hearts has been broken: boolean broken = manager.isHeartsBroken();
	 *  - whether its the first round: boolean firstRound = manager.isFirstRound();
	 *  - whether a card is a valid move: boolean isValid = isValidMove(card);
	 *  
	 */
	@Override
	public Card play(Trick onTable, CardPile hand) {
		int i;
		do { // Keeps picking a random card till one works
			i = (int)(Math.random() * (hand.size()));
		} while (!isValidPlay(onTable, hand.get(i)));
		
		return hand.get(i);
	}

	@Override
	public String getName() {
		return "Yadav" + getId(); // Put your name here. I used Yadav (aka DumbPlayer) for this example cause he's the only non-programmer in SS.
	}

}
