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

	@Override
	public Object clone() {
		return (CardPile) super.clone();
	}
	public boolean contains(Card.Suit suit) {
		for (Card card : this)
			if (card.getSuit() == suit) 
				return true;
		return false;
	}
	
	public boolean contains(Card.Rank rank, Card.Suit suit) {
		for (Card card : this)
			if (card.getRank() == rank && card.getSuit() == suit) 
				return true;
		return false;
	}

	public void print() {
		for (Card card : this) {
			System.out.print(card.getRank() + " " + card.getSuit() + ", ");
		}
		System.out.println();
	}
}
