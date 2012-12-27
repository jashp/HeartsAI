package game;

public class Trick extends CardPile {
	private int leadId;
	
	public Trick(int leadId) {
		super();
		this.leadId = leadId;
	}
	
	public void add(int playerId, Card card) {
		add(card);
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

	public int getLeadId() {
		return leadId;
	}
	
	public int getTakerId() {
		int takerOrder = 0;
		for (int i = 1; i < 4; i++) {
			if (get(i).getSuit() == baseSuit() && get(i).compareTo(get(takerOrder)) > 0)
				takerOrder = i;
		}
		
		return (takerOrder+leadId)%4;
	}

}