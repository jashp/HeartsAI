package game;

public class Manager {
	private static final Manager instance = new Manager();
	private Trick[] pastTricks = new Trick[13];
	private boolean heartsBroken;
	private int currentTrick;
	
	private Manager() {
		heartsBroken = false;
		currentTrick = 0;
	}
	
    public static Manager getInstance() {
        return instance;
    }
		
	public CardPile getPastTricks(int trickNumber) {
		return pastTricks[trickNumber];
	}

	public boolean isHeartsBroken() {
		return heartsBroken;
	}
	
	public boolean isFirstRound() {
		return currentTrick == 0;
	}
		
	void setTrick(Trick trick) {
		if (!isHeartsBroken() && trick.contains(Card.Suit.HEARTS)) 
			heartsBroken = true;
				
		pastTricks[currentTrick] = trick;
		currentTrick++;
	}
	

}
