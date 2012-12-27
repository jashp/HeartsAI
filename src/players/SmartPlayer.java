package players;

import game.Card;
import game.CardPile;
import game.Player;
import game.Trick;

public class SmartPlayer extends Player{

	public SmartPlayer(int id) {
		super(id);
	}

	@Override
	public Card play(Trick onTable, CardPile hand) {
		Card r = null;

		r = hand.find(Card.Rank.TWO, Card.Suit.CLUBS);
		if (r != null)
			return r;
		
		if (hand.contains(onTable.baseSuit())) {
			for (Card c : hand) {
				if (c.getSuit() == onTable.baseSuit() && (r == null || r.compareTo(c) < 0)) {
					r = c;
				}
			}
			return r;
		}
		
		r = hand.find(Card.Rank.QUEEN, Card.Suit.SPADES);
		if (r != null)
			return r;
		
		for (Card c : hand) {
			if (r == null || r.compareTo(c) < 0) {
				r = c;
			}
		}
		return r;
	}

	@Override
	public String getName() {
		return "Jash" + getId(); // Put your name here. I used Yadav (aka DumbPlayer) for this example cause he's the only non-programmer in SS.
	}

}
