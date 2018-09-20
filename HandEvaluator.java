package a2;
import java.util.Scanner;

public class HandEvaluator {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			int numOfOpponents = scanner.nextInt();
			
			// End the while loop if the number of opponents is 0
			if (numOfOpponents == 0)
				break;
			
			Card[] cards = new Card[5];
			
			// Use for loop to read user input as the specific hand.
			for(int i = 0; i < 5; i++) {
				int rank = scanner.nextInt();
				String suit = scanner.next();
				switch(suit) {
					case "S": cards[i] = new CardImpl(rank, Card.Suit.SPADES); break;
					case "H": cards[i] = new CardImpl(rank, Card.Suit.HEARTS); break;
					case "D": cards[i] = new CardImpl(rank, Card.Suit.DIAMONDS); break;
					case "C": cards[i] = new CardImpl(rank, Card.Suit.CLUBS); break;
					default: suit = null;
				}	
			}
			for (int z = 0; z < 5; z++) {
			System.out.print(" " + cards[z].getRank() 
					+ " " + cards[z].getSuit());}
			
			// Create a specific hand based on user input.
			PokerHand myHand = new PokerHandImpl(cards);
			
			// Experiment 10000 times to determine how often the specific hand wins.
			int timeOfWins = 0;
			
//			for(int j = 0; j < 10000; j++) {
				// Created a shuffled deck of 52 cards.
				Deck myDeck = new DeckImpl();
				
				// Remove the 5 cards in the specific hand.
				for(int i = 0; i < 5; i++) {
					myDeck.findAndRemove(cards[i]);
				}
				
				// Deal a poker hand for each component.
				PokerHand[] oppHand = new PokerHandImpl[numOfOpponents];
				for(int i = 0; i < numOfOpponents; i++) {
					if(myDeck.hasHand())
						oppHand[i] = myDeck.dealHand();
				}
				
				// Compare the specific hand to the oppHand. 
				// If the specific hand beats all opponents, then tally the experiment as a win.
				// Otherwise, consider the experiment a loss.
				// Use a variable flag to keep track of win and loss, is all win, flag is 1, otherwise -1.
				int flag = 1;
				for (int i = 0; i < numOfOpponents; i++) {
					
					for (int z = 0; z < 5; z++) {
					System.out.print(" " + oppHand[i].getCards()[z].getRank() 
							+ " " + oppHand[i].getCards()[z].getSuit());
					}
					
					System.out.println("\n");
					if(myHand.compareTo(oppHand[i]) < 1)
						flag = -1;	
						System.out.println("lose\n");
					}
				
				if(flag == 1)
					timeOfWins++;
//			}
			
//			System.out.print("\n" + Math.round((float)timeOfWins / 100));
	}
		
	scanner.close();
	}

}
