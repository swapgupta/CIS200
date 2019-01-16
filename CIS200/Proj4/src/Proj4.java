/**
 * <Proj4.java>
 * 
 * <Swapnil Gupta / Thurday 6pm / Atef Khan>
 *
 * <Poker hand dealer>
*/
import java.util.*;

public class Proj4 {

	public static void main(String[] args) {
		char again = 'y';
		while (again == 'y') {
		String[] valueTotal = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		String[] suitTotal = {"Hearts", "Spades", "Clubs", "Diamonds"};
		int[] value = new int[5];
		int[] suit = new int[5];
		String[][] deck = new String [valueTotal.length][suitTotal.length];
		Scanner s = new Scanner(System.in);
		
		Random randValue = new Random();
		Random randSuit = new Random();
		
		System.out.println("** Welcome to the 2017 Las Vegas Poker Festival! **");
		System.out.println("(Application developed by Swapnil Gupta)");
		
		System.out.println("\nShuffling cards...");
		for (int i = 0; i < valueTotal.length; i++) { 
			for (int j = 0; j < suitTotal.length; j++) {  
				deck[i][j] = (valueTotal[i]) + " of " + (suitTotal[j]);
			}			
		}
		
		
		String [] card = new String[5];
		int count = 0;

		
		for (int i = 0; i < card.length; i++) {
			value[i] = randValue.nextInt(valueTotal.length) + 2;
			suit[i] = randSuit.nextInt(suitTotal.length) + 1;
		}
		// Royal Flush   
		//int[] value = {10, 12, 14, 13, 11};   
		//int[] suit = {1,1,1,1,1};
		
		// Straight Flush   
		//int[] value = {9, 7, 8, 6, 5};   
		//int[] suit = {1,1,1,1,1};
		
		// 4 of kind  
		//int[] value = {9, 7, 9, 9, 9};   
		//int[] suit = {1,2,3,4,1};
		
		// Full House  
		//int[] value = {9, 7, 9, 7, 9};   
		//int[] suit = {1,2,3,4,1};
		
		// Flush  
		//int[] value = {9, 10, 8, 6, 5}; 
		//int[] suit = {1,1,1,1,1};
		
		// Straight  
		//int[] value = {9, 7, 8, 6, 5};
		//int[] suit = {1,2,4,3,1};
		
		// 3 of kind  
		//int[] value = {9, 7, 9, 2, 9}; 
		//int[] suit = {1,2,3,4,1};
		
		// Two Pair   
		//int[] value = {9, 7, 9, 2, 7}; 
		//int[] suit = {1,2,3,4,1};
		
		// One Pair
		//int[] value = {9, 7, 8, 2, 7};  
		//int[] suit = {1,2,3,4,1};
		
		// High Card (Ace)
		//int[] value = {9, 7, 8, 14, 11};   
		//int[] suit = {1,2,3,4,1};
		
		System.out.println("Dealing cards...");
		
		Arrays.sort(value);
		Arrays.sort(suit);
		System.out.print("\nHere are your five cards...\n");
		for (int i = 0; i < card.length; i++) {
		card[i] = deck[value[i] - 2][suit[i]- 1];
		System.out.println	(card[i]);		
		}
		
		for (int j=1; j<card.length; j++) {
		    if (card[j-1].equals(card[j])) count += 1;
		}
		//System.out.print(count);
		
		boolean isRoyalFlush = false;
		boolean isStraightFlush = false;
		boolean isFourOfAKind = false;
		boolean isFullHouse = false;
		boolean isFlush = false;
		boolean isStraight = false;
		boolean isThreeOfAKind = false;
		boolean isTwoPairs = false;
		boolean isPair = false;
		int valueCount = 0;
		int suitCount = 0;
		
		for (int i = 0; i < card.length; i++) {
		    for (int k = i + 1; k < card.length; k++) {
		        if (value[i] == value[k]) {
		            valueCount += 1;
		        }
		    }
		}
		for (int i = 0; i < card.length; i++) {
		    for (int k = i + 1; k < card.length; k++) {
		        if (suit[i] == suit[k]) {
		            suitCount += 1;
		        }
		    }
		}
		
		//System.out.println(valueCount);
		//System.out.println(suitCount);
		
		
		int royalFlushCount = 0;
		for (int i = 0; i < card.length; i++) 
		{
			for(int j = 10; j < 15; j++)
			{
		         if(value[i] == j)  royalFlushCount += 1;
			}
		}
		if (suitCount == 10 && royalFlushCount == 5) 
		{
			isRoyalFlush = true;
		}
		if (isRoyalFlush == true) 
		{
			System.out.println("\nYou were dealt a Royal Flush");
		}
		
		
		
		int straightCount = 0;
		for (int i = 0; i < card.length - 1; i++) 
		{
			  if (value[i] + 1 == value[i + 1]) 
			  {
			    straightCount += 1;
			  }
		}
		if (suitCount == 10 && straightCount == 4) 
		{
			isStraightFlush = true;
		}
		if (isStraightFlush == true) 
		{
			System.out.println("\nYou were dealt a Straight Flush");
		}
		
		
		
		if (valueCount == 6) isFourOfAKind = true;
		if (isFourOfAKind == true) System.out.println("\nYou were dealt a Four of a Kind");
		
		
		
		int fullHouseCount = 0;
		isFullHouse=false;
		
		for (int i = 0; i < card.length; i++) {
		     for (int j = i + 1 ; j < card.length; j++) {
		          if (card[i].equals(card[j])  && (i != j)) {
		        	  fullHouseCount += 1;
		          }
		     }
		 }
		//System.out.print(fullHouseCount);
		
		
		
		if (suitCount == 10) 
		{
			isFlush = true;
		}
		if (isFlush == true) 
		{
			System.out.println("\nYou were dealt a Flush");
		}
		
		
		
		if (straightCount == 4) 
		{
			isStraight = true;
		}
		if (isStraight == true) 
		{
			System.out.println("\nYou were dealt a Straight");
		}
		
		
		
		if (valueCount == 3) isThreeOfAKind = true;
		if (isThreeOfAKind == true) System.out.println("\nYou were dealt a Three of a Kind");
		
		
		
		if (valueCount == 2) isTwoPairs = true;
		if (isTwoPairs == true) System.out.println("\nYou were dealt Two Pair");
		
		
		
		if (valueCount == 1) isPair = true;
		if (isPair == true) System.out.println("\nYou were dealt a Pair");
		
		
		
		if (isPair == false && isTwoPairs == false && isThreeOfAKind == false) System.out.println("\nHigh Card is a(n) " + valueTotal[value[4] - 2]);
		
		
		
		
		System.out.print("Play Again (y or n)?");
		again = s.nextLine().charAt(0);
		if (again == 'n') break;
		else continue;
	}
	}

}
