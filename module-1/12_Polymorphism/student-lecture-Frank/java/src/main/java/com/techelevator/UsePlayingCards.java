package com.techelevator;

import java.util.ArrayList;

public class UsePlayingCards {

	public static void main(String[] args) {
		
		AmericanPlayingCard aUSACard  = new AmericanPlayingCard(1, "HEARTS");
		System.out.println("aUSACard is :");
		aUSACard.showCard();	

		AmericanPlayingCard aUSACard2 = new AmericanPlayingCard(14, "SPADES");
		System.out.println("aUSACard2 is :" );
		aUSACard2.showCard();
		
		AmericanPlayingCard aUSACard3 = new AmericanPlayingCard(-1, "SPADES");
		System.out.println("aUSACard3 is :");
		aUSACard3.showCard();
			
		AmericanPlayingCard aUSACard4 = new AmericanPlayingCard(11, "JASON");
		System.out.println("aUSACard4 is :");
		aUSACard4.showCard();			// run the showCard() in the AmericanCard class
		
		ItalianPlayingCard anItalianCard1 = new ItalianPlayingCard(13, "SWORDS");
		System.out.println("anItalianCard1 is :");
		anItalianCard1.showCard();		// run the showCard() in the ItalianCard class
		
		ItalianPlayingCard anItalianCard2 = new ItalianPlayingCard(9, "COINS");
		System.out.println("anItalianCard2 is :");
		anItalianCard2.showCard();
		
		ItalianPlayingCard anItalianCard3 = new ItalianPlayingCard(11, "JASON");
		System.out.println("anItalianCard3 is :");  // The class of the object used to run method determines which method is run
		anItalianCard3.showCard();
		
		SwissPlayingCard aSwissCard1 = new SwissPlayingCard(13, "ROSES");
		System.out.println("aSwissCard1 is :");
		aSwissCard1.showCard(); // run the showCard() in the SwissCard class
		
		SwissPlayingCard aSwissCard2 = new SwissPlayingCard(9, "SHIELDS");
		System.out.println("aSwissCard2 is :");
		aSwissCard2.showCard();
			
		SwissPlayingCard aSwissCard3 = new SwissPlayingCard(10, "ACORNS");
		System.out.println("anSwissCard3 is :");
		aSwissCard3.showCard();
			
		SwissPlayingCard aSwissCard4 = new SwissPlayingCard(11, "JASON");
		System.out.println("anSwissCard4 is :");
		aSwissCard4.showCard();		
		
		/***************************************************************************
		 * Start of the Polymorphism examples
		 *************************************************************************** 
		 */
		 
		System.out.println("\n------ Polymorphism examples start here ------\n");
		
		PlayingCard aCard = null;	// Define a superclass object that is empty
		
		aCard = aUSACard;	// Assign a subclass object to a superclass variable.
							// Normally, you cannot assign an object of one class to an object of another class.
							// Inheritance lets you assign a subclass object to a superclass variable
							//		So you take advantage of Polymorphism
		
// PlayingCard.PlayCardMethod() - The compiler thinks it's running the method that belongs to class of the object.		
		
		aCard.showCard();   // Use the superclass object to run a common method in the in Inheritance hierarchy
							// All subclasses have a showCard() method - Polymorphism will decide which one to run
		
		aCard = aSwissCard1;
		aCard.showCard();
		
		aCard = anItalianCard1;
		aCard.showCard();
		
		System.out.println("\n------ Polymorphism examples using an ArrayList ------\n");
		
		// Define a Collections class object or a regular array with the data type of superclass
		// You have a group of superclass objects
		
		ArrayList<PlayingCard> cardList = new ArrayList();
		
		// Add subclass objects to the ArrayList

		cardList.add(aSwissCard1); // add a subclass object
		cardList.add(anItalianCard1); // add a subclass object
		cardList.add(aUSACard); // add a subclass object
		cardList.add(aUSACard2); // add a subclass object
		cardList.add(aSwissCard2); // add a subclass object

		// Loop through the ArrayList displaying the cards using the showCard() method
		for (PlayingCard theCard: cardList) { // use the superclass for the for-each variable
			theCard.showCard();				  // use the for-each variabhle to invoke the method
			
		}
		// Because of Polymorphism, we don't need to know or care what type of object is in the for-loop
		//		variable each time through the loop. 

		
		
		
		
		}
}
