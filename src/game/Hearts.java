package game;
import java.util.Collections;

import players.Yadav;

public class Hearts {
	
	
	
	public static void main(String[] args) {
		Player[] player = new Player[4];
		player[0] = new Yadav(0);
		player[1] = new Yadav(1);
		player[2] = new Yadav(2);
		player[3] = new Yadav(3);
		int leadId = -1;

		CardPile deck = new CardPile();
		Manager manager = Manager.getInstance();
		
		for(Card.Rank rank : Card.Rank.values()) {
			for(Card.Suit suit : Card.Suit.values()) {
				deck.add(new Card(rank, suit));
			}
		}
		
		Collections.shuffle(deck);
		
		for (int i = 0; i < 4; i++) {
			player[i].hand = new CardPile(deck.subList(i*13, i*13+13));
			if (player[i].hand.contains(Card.Rank.TWO, Card.Suit.CLUBS))
				leadId = i;
		}
		
		for (int i = 0; i < 13; i++) {
			Trick onTable = new Trick();
			for (int j = 0; j < 4; j++) {
				Player currentPlayer = player[(j+leadId)%4];
				Card played = currentPlayer.play((Trick)onTable.clone());
				currentPlayer.hand.remove(played);
				onTable.add(played);
				System.out.println(currentPlayer.getName() + " played " + played.getRank() + " of " + played.getSuit());
			}
			leadId = manager.collectRound(leadId, onTable);
			System.out.println(player[leadId].getName() + " took the hand.\n");
		}
		
	}
	
	
}
