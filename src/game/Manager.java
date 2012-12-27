package game;

public class Manager {
	private static final Manager instance = new Manager();
	private Trick[] takenCards = new Trick[13];
	private boolean heartsBroken;
	private boolean firstRound;
	
	private Manager() {
		heartsBroken = false;
		firstRound = true;
		for (int i = 0; i < 4; i++) {
			takenCards[i] = new Trick();
		}
	}

    public static Manager getInstance() {
        return instance;
    }
	
	public int getScoreForPlayer(int id) {
		if (id >= 0 && id < 4) {
			return takenCards[id].totalPoints();
		} else {
			return -1;
		}
	}
	
	public CardPile getPlayerTaken(int id) {
		if (id >= 0 && id < 4) {
			return takenCards[id];
		} else {
			return null;
		}
	}

	public boolean isHeartsBroken() {
		return heartsBroken;
	}
	
	public boolean isFirstRound() {
		return firstRound;
	}
	
	int collectRound(int leadId, Trick onTable) {
		firstRound = false;
		if (!heartsBroken) {
			heartsBroken = onTable.contains(Card.Suit.HEARTS);
		}
		
		int takerId = 0;
		
		for (int i = 1; i < 4; i++) {
			if (onTable.get(i).getSuit() == onTable.baseSuit() && onTable.get(i).compareTo(onTable.get(takerId)) > 0)
				takerId = i;
		}
		
		takerId = (takerId+leadId)%2;
		takenCards[takerId].addAll(onTable);
		
		return takerId;
	}

}
