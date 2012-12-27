package game;

import java.util.ArrayList;
import java.util.List;

public class CardPile extends ArrayList<Card> {
	
	public CardPile() {
		super();
	}
	
	public CardPile(List<Card> list) {
		for (Card card : list) {
			add(card);
		}
	}

	public boolean contains(Card.Suit suit) {
		for (Card card : this)
			if (card.getSuit() == suit) 
				return true;
		return false;
	}
	
	public boolean containsNonHearts() {
		for (Card card : this)
			if (card.getSuit() != Card.Suit.HEARTS) 
				return true;
		return false;
	}
	
	public boolean containsNonPoints() {
		for (Card card : this)
			if (card.getPoints() == 0) 
				return true;
		return false;
	}
	
	public Card find(Card.Rank rank, Card.Suit suit) {
		for (Card card : this)
			if (card.getRank() == rank && card.getSuit() == suit) 
				return card;
		return null;
	}

	public void print() {
		for (Card card : this) {
			System.out.print(card.getRank() + " " + card.getSuit() + ", ");
		}
		System.out.println();
	}
}
