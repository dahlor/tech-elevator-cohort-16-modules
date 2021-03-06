package com.techelevator;

public class UsePlayingCards {

	public static void main(String[] args) {
	// An application program to instantiate and use PlayingCard objects.
		
		System.out.println("\nInstantiating aUSACard as an ace of Hearts");
		AmericanPlayingCard aUSACard  = new AmericanPlayingCard(1, "HEARTS");  // Instantiate an Ace of Hearts
		System.out.println("aUSACard is : \n" + aUSACard);
		
		System.out.println("\nInstantiating aUSACard2 with a value that exceeds maximum");
		AmericanPlayingCard aUSACard2 = new AmericanPlayingCard(14, "SPADES"); // Value exceeds maximum
		System.out.println("aUSACard2 is : \n" + aUSACard2);

		System.out.println("\nInstantiating aUSACard3 with a value that is below minimum");

		AmericanPlayingCard aUSACard3 = new AmericanPlayingCard(-1, "SPADES"); // Value less than minimum
		System.out.println("aUSACard3 is : \n" + aUSACard3);	

		System.out.println("\nComparing aUSACard2 and aUSACard3");
		
		
		// Using a superclass method with a subclass object
		aUSACard2.setValue(4); // Using a superclass method with a subclass object
		System.out.println("aUSACard2 is : \n" + aUSACard2);

		System.out.println("Value in aUSACard3 is: " + aUSACard3.getValue());
		
		if (aUSACard2.equals(aUSACard3)) {
			System.out.println("They are equal");
		}
		else {
			System.out.println("They are NOT equal");
		}
		
		ItalianCard guido = new ItalianCard(); // Instantiate a new ItalianCard
		
		System.out.println("Guido is: " + guido);
		
		guido.setValue(6);
		
		System.out.println("Guido is: " + guido);

		
		
		
		
	}

}
