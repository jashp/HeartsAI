package game;

public class Manager {
	private static final Manager instance = new Manager();
	private Trick[] pastTricks;
	private boolean heartsBroken;
	private int currentTrick;
	
	private Manager() {
		reset();
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
	
	void reset() {
		pastTricks = new Trick[13];
		heartsBroken = false;
		currentTrick = 0;
	}

}
