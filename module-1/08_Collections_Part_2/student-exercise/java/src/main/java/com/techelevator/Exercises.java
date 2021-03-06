package com.techelevator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {
		
		String groupName = "";
		
		if (animalName == null) {
			return "unknown";
		}
		
		// Set up a Map to associate the animal name to the group name
		// key - animal name in lowercase
		// value - group name
		
		Map<String, String> animalGroups = new HashMap(); // Key & value both Strings
		
		animalGroups.put("rhino", "Crash");
		animalGroups.put("giraffe", "Tower");
		animalGroups.put("elephant", "Herd");
		animalGroups.put("lion", "Pride");
		animalGroups.put("crow", "Murder");
		animalGroups.put("pigeon","Kit");
		animalGroups.put("flamingo", "Pat");
		animalGroups.put("deer", "Herd");
		animalGroups.put("dog", "Pack");
		animalGroups.put("crocodile", "Float");
		
		// Look to see if the animal given is in the map - case insensitivity
		
		groupName = animalGroups.get(animalName.toLowerCase()); // convert what is given to lowercase
																// for the search
	
		// Check to be sure the animal was in the Map, if not set the group name to "unknown".
		
		if (groupName == null ) {	// .get() returns null if the key is not in the Map
			groupName = "unknown";
		}
		
		return groupName;
	}

	/*
	 * Given an String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) {
		
		// Declare a storage string
		Double upperCasedItem;
		
		if (itemNumber == null) {
			return 0.00;
		}
		
		// Declare my Map
		Map<String, Double> discountDB = new HashMap();
		
		// Put everything into the Map DB
		
		discountDB.put("KITCHEN4001", 0.20);
		discountDB.put("GARAGE1070", 0.15);
		discountDB.put("LIVINGROOM", 0.10);
		discountDB.put("KITCHEN6073", 0.40);
		discountDB.put("BEDROOM3434", 0.60);
		discountDB.put("BATH0073", 0.15);
		
		// Change the item number to all lower case to avoid confusion
		upperCasedItem = discountDB.get(itemNumber.toUpperCase());
		
		// Check to be sure the animal was in the Map, if not set the group name to "unknown".
		
		if (upperCasedItem == null) {	// .get() returns null if the key is not in the Map
			return 0.00;
		}
		else {	// Do it normally
			return upperCasedItem;
		}
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 *
	 */
		public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
		int petersMoney = peterPaul.get("Peter");
		int paulsMoney = peterPaul.get("Paul");

		if (petersMoney > 0 && paulsMoney < 1000) {
		int moneyToPayPaul = petersMoney / 2;
		peterPaul.put("Paul", moneyToPayPaul + paulsMoney);
		peterPaul.put("Peter", petersMoney - moneyToPayPaul);
		}

		return peterPaul;
		}


	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
		public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
		int petersMoney = peterPaul.get("Peter");
		int paulsMoney = peterPaul.get("Paul");

		if (petersMoney >= 5000 && paulsMoney >= 10000) {
		int paulsContribution = paulsMoney / 4;
			int petersContribution = petersMoney / 4;

			peterPaul.put("Paul", peterPaul.get("Paul") - paulsContribution);
			peterPaul.put("Peter", peterPaul.get("Peter") - petersContribution);
			peterPaul.put("PeterPaulPartnership", paulsContribution + petersContribution);

			}

			return peterPaul;
			}

	/*
	 * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {
		
		// Declare dat HashMap
		Map<String, String> firstAndLast = new HashMap();
		
		// Do the loop and create storage for first & last characters 	
		for(String loopy : words) {
			String firstChar = ("" + loopy.charAt(0));
			String lastChar = ("" + loopy.charAt(loopy.length()-1));
			firstAndLast.put(firstChar, lastChar);
		}
		return firstAndLast;
	
	}
	
	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {
		
		// Declaration of Map-dependence
		Map<String, Integer> howManyNums =  new HashMap();

		// Trying stuff and things that may or may not work
		
		for(int i = 0; i < words.length; i++) {
		
			int count = howManyNums.containsKey(words[i]) ? howManyNums.get(words[i]) : 0;
			howManyNums.put(words[i], count+1);
		}
		return howManyNums;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {
	
		// Definitely didn't copy paste this from above
		// Declaration of Map-dependence
		Map<Integer, Integer> howManyNums =  new HashMap();

		// Trying stuff and things that may or may not work
		
		for(int i = 0; i < ints.length; i++) {
		
			int count = howManyNums.containsKey(ints[i]) ? howManyNums.get(ints[i]) : 0;
			howManyNums.put(ints[i], count+1);
		}
		return howManyNums;
	}

	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {

	return null;
	}

	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse) {
		
		// Declaring my new HasahhahMap
		Map<String, Integer> mergedInventories = new HashMap();
		
		// Moved all of mainWarehouse into mergedInventories for comparison.
		mergedInventories.putAll(mainWarehouse);
		
		// Merge Maps and sum values for identical keys
		remoteWarehouse.forEach((k, v) -> mergedInventories.merge(k, v, Integer::sum));
		
		return mergedInventories;
	}	

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
	 * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
	 *
	 * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end subString, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {
		return null;
	}

}
