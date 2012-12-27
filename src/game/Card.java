package game;

public class Card implements Comparable {
	public enum Suit {
		CLUBS(0), DIAMONDS(1), SPADES(2), HEARTS(3);
		public int value;
		private Suit(int value) {
			this.value = value;  
		}
		public int getValue() {
			return value;
		}
	};
	public enum Rank {
		TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);
		private int value;
		private Rank(int value) {
			this.value = value;  
		}	
		public int getValue() {
			return value;
		}
	};
	private Rank rank;
	private Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public int getPoints() {
		if (rank == Rank.QUEEN && suit == Suit.SPADES) {
			return 13;
		} else if (suit == Suit.HEARTS) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int compareTo(Object object) {
		Card card = (Card) object;
		// 100 is used as an arbitrary number to prioritze the value of suits before ranks
		return (this.suit.value*100 + this.rank.value) - (card.suit.value*100 + card.rank.value);

	}
}