package game;

public abstract class Player {
	private int id;
	private Manager manager;
	CardPile hand;
	
	public Player(int id) {
		this.id = id;
		this.manager = Manager.getInstance();
	}
	
	public int getId() {
		return id;
	}
	
	public boolean isValidPlay(Trick onTable, Card card) {
		// First play must be 2 of clubs
		if (manager.isFirstRound() && onTable.size() == 0 && (card.getSuit() != Card.Suit.CLUBS || card.getRank() != Card.Rank.TWO))
			return false;
		
		// No points on first round
		if (manager.isFirstRound() && card.getPoints() != 0)
			return false;
		
		// Hearts cannot be started with until Hearts is broken
		if (onTable.size() == 0 && card.getSuit() == Card.Suit.HEARTS && !manager.isHeartsBroken())
			return false;
		
		// If your hand contains the base suit, you must play it
		if (card.getSuit() != onTable.baseSuit() && hand.contains(onTable.baseSuit()))
			return false;
		
		// The card must be in your hand to play it
		return hand.contains(card);
	}
	
	protected CardPile getHand() {
		return (CardPile) hand.clone();
	}
	
	public abstract Card play(Trick onTable);
	
	public abstract String getName();
}