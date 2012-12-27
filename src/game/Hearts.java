package game;
import java.util.Collections;

import players.DumbPlayer;
import players.SmartPlayer;

public class Hearts {	
	
	public static void main(String[] args) {
		Player[] player = new Player[4];

		player[0] = new DumbPlayer(0);
		player[1] = new DumbPlayer(1);
		player[2] = new DumbPlayer(2);
		player[3] = new DumbPlayer(3);
		Manager manager = Manager.getInstance();
		
		int leadId = dealDeck(player);


		
		//for (int k = 0; k < 1000; k++) {
			for (int i = 0; i < 13; i++) {
				Trick trick = new Trick(leadId);
				for (int j = 0; j < 4; j++) {
					Player currentPlayer = player[(j+leadId)%4];
					Card played = currentPlayer.play((Trick)trick.clone(), (CardPile)currentPlayer.hand.clone());
					currentPlayer.hand.remove(played);
					trick.add(currentPlayer.getId(), played);
					System.out.println(currentPlayer.getName() + " played " + played.getRank() + " of " + played.getSuit());
				}
				leadId = trick.getTakerId();	
				player[leadId].addScore(trick.totalPoints());
				manager.setTrick(trick);
				System.out.println(player[leadId].getName() + " took the hand.\n");
			}
			manager.reset();
			leadId = dealDeck(player);
		//}
		
		for (int i = 0; i < 4; i++) {
			System.out.println(player[i].getName() + ": " + player[i].getScore() + " points");
		}
	}
	
	
	public static int dealDeck(Player[] player) {
		CardPile deck = new CardPile();
		
		for(Card.Rank rank : Card.Rank.values()) {
			for(Card.Suit suit : Card.Suit.values()) {
				deck.add(new Card(rank, suit));
			}
		}
		
		Collections.shuffle(deck);
		
		int leadId = -1;
		for (int i = 0; i < 4; i++) {
			player[i].hand = new CardPile(deck.subList(i*13, i*13+13));
			if (player[i].hand.find(Card.Rank.TWO, Card.Suit.CLUBS) != null)
				leadId = i;
		}
		
		return leadId;
	}
	
}
