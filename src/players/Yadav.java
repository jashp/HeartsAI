package players;

import game.Card;
import game.CardPile;
import game.Player;
import game.Trick;

public class Yadav extends Player{

	public Yadav(int id) {
		super(id);
	}

	/*************************
	 * This is where all the logic happens. In from this method, you have access to:
	 *   - your hand: CardPile hand = getHand();
	 *   - what each 
	 * 
	 * 
	 * 
	 */
	@Override
	public Card play(Trick onTable) {
		CardPile hand = getHand();
		
		int i;
		do {
			i = (int)(Math.random() * (hand.size()));			
		} while (!isValidPlay(onTable, hand.get(i)));
		
		return hand.get(i);
	}

	@Override
	public String getName() {
		return "Yadav" + getId();
	}

}
