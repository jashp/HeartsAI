package game;

import java.util.ArrayList;

public class Trick extends CardPile {
	ArrayList<Integer> playerIds = new ArrayList<Integer>();
	
	public void add(int playerId, Card card) {
		add(card);
		playerIds.add(playerId);
	}
	
	public Card.Suit baseSuit() {
		if (size() == 0)
			return null;
					
		return get(0).getSuit();
	}
	

	public int totalPoints() {
		int total = 0;
		for (Card card : this)
			total += card.getPoints();
		return total;
	}
}
