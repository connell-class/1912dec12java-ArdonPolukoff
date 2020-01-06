package com.revature.eval.java.core;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration

		char[] charArray = phrase.toCharArray();

		ArrayList<String> abreviation = new ArrayList<String>();

		String string1 = Character.toString(charArray[0]);
		abreviation.add(string1);

		for (int i = 1; i < charArray.length; i++) {
			if (charArray[i] == ' ' || charArray[i] == '-') {

				String string2 = Character.toString(charArray[i + 1]);
				abreviation.add(string2);
			}

		}

		StringBuffer buffer = new StringBuffer();
		for (String str : abreviation) {
			buffer.append(str);
		}

		String result = buffer.toString();
		String result1 = result.toUpperCase();
		return result1;

	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			if (sideOne == sideTwo && sideOne == sideThree && sideThree == sideTwo) {
				return true;
			} else

				return false;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if (sideOne == sideTwo && sideOne != sideThree && sideTwo != sideThree) {
				return true;
			} else if (sideOne == sideThree && sideOne != sideTwo && sideTwo != sideThree) {
				return true;

			} else if (sideTwo == sideThree && sideTwo != sideOne && sideOne != sideThree) {
				return true;
			}

			return false;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if (sideOne != sideTwo && sideOne != sideThree && sideOne != sideThree) {
				return true;
			}

			return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public static int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration

		String stringLower = string.toLowerCase();
		char[] strArray = stringLower.toCharArray();

		String onePointWords = "aeioulnrst";
		String twoPointWords = "dg";
		String threePointWords = "bcmp";
		String fourPointWords = "fhvwy";
		String fivePointWords = "k";
		String eightPointWords = "x";
		String tenPointWords = "qz";

		int score = 0;

		for (char ele : strArray) {
			if (onePointWords.indexOf(ele) != -1) {
				score += 1;
			}
			if (twoPointWords.indexOf(ele) != -1) {
				score += 2;
			}
			if (threePointWords.indexOf(ele) != -1) {
				score += 3;
			}
			if (fourPointWords.indexOf(ele) != -1) {
				score += 4;
			}
			if (fivePointWords.indexOf(ele) != -1) {
				score += 5;
			}
			if (eightPointWords.indexOf(ele) != -1) {
				score += 8;
			}
			if (tenPointWords.indexOf(ele) != -1) {
				score += 10;
			}
		}

		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public static String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration

		char[] strArray = string.toCharArray();
		String numerals = "0123456789";

		char[] cleanNumber = new char[string.length()];
		
		int counter = 0; //counts where in the clean number index to add an element
		for (char ele : strArray) {
			//sees if the input from the strArray is a numeral
			if (numerals.indexOf(ele) != -1) {
				cleanNumber[counter] = ele;
				counter++;
			} 
		}
		
		String result = new String(cleanNumber);
		String result1 = result.trim();

		
		//System.out.println(result1.length());
		if (result1.length() != 10) {
			throw new IllegalArgumentException();
		}

		return result1;
		
	}

//	public static void main(String[] args) {
//
//		System.out.println(cleanPhoneNumber("(223) 456-6042"));
//
//	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public static Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		
//		System.out.println(string);
		String cleansedOfNewLines = string.replace("\n","");
//		System.out.println(cleansedOfNewLines);
		
		String[] stringArray = cleansedOfNewLines.split("\\s|,");
		
		
		
		Map<String, Integer> wordFreq = new HashMap<String, Integer>();
	    for (int i = 0; i < stringArray.length; i++) {
	       //System.out.println(stringArray[i]);
	       if(wordFreq.containsKey(stringArray[i])) {
	    	   int count = wordFreq.get(stringArray[i]);
	    	   wordFreq.put(stringArray[i], count+1);
	       }else {
	    	   wordFreq.put(stringArray[i],1);
	       }
	       
	    }
//	    System.out.println(wordFreq);
	    
	   
	    
	    
	    return wordFreq;
	}

	

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */

		static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			return sortedList.indexOf(t);
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public static String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		StringBuilder pigWord = new StringBuilder(14);
		String[] str = string.split(" ");
		
		for(int i=0 ; i<str.length;i++) {
			
		String firstThreeLetters = str[i].substring(0, 3);
		String firstTwoLetters = str[i].substring(0, 2);
		String firstLetter = str[i].substring(0, 1);
		
		
		String sh = "sh";
		String ch = "ch";
		String th = "th";
		String qu = "qu";
		String sch = "sch";

	
		if(firstThreeLetters.equals(sch)) {
			pigWord.append(str[i].substring(3)).append(firstThreeLetters).append("ay").append(" ");
		}else if(firstTwoLetters.equals(sh)||firstTwoLetters.equals(ch)||firstTwoLetters.equals(th)||firstTwoLetters.equals(qu)) {
			pigWord.append(str[i].substring(2)).append(firstTwoLetters).append("ay").append(" ");	
		}else if(firstLetter.equals("a")||firstLetter.equals("e")||firstLetter.equals("i")||firstLetter.equals("o")||firstLetter.equals("u")) {
			pigWord.append(str[i]).append("ay").append(" ");	
		}else {
			pigWord.append(str[i].substring(1)).append(firstLetter).append("ay").append(" ");
		}
			
		}

	
		
		
		
		return pigWord.toString().trim();
	}
	

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration

		double sumOfnumbers = 0;
		
		String number = Integer.toString(input);
		int p1 = number.length();
		
		
		
		for(int i = 0; i < number.length();i++) {
			int numberAtIndex = Character.getNumericValue(number.charAt(i));
			//System.out.println(numberAtIndex);
			sumOfnumbers=sumOfnumbers + (Math.pow(numberAtIndex, p1));
		}
		
		if (sumOfnumbers == input) {
			 return true;
		}
		
		return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		
		List<Long> listOfPrimeFactors = new ArrayList<>();
		for (int i = 2; i <= l; i++) {
			while (l % i == 0) {
				listOfPrimeFactors.add((long) i);
				l = l / i;
			}
		}
		return listOfPrimeFactors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration

			char[] inputString = string.toCharArray();
			char[] lowerCase = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
					'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
			char[] upperCase = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
					'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

			if (key!=0 && key!=26) {
				for (int i = 0; i < string.length(); i++) {
					Boolean upCase = Character.isUpperCase(inputString[i]);
					Boolean lowCase =Character.isLowerCase(inputString[i]);
					
					if(upCase==true && (i+key <= 25)) {
						inputString[i] = upperCase[i+key];
					}else if(upCase==true && (i+key > 25)) {
							inputString[i] = upperCase[(i+key)-25];
					}else if(lowCase==true && (i+key <= 25)) {
						inputString[i] = lowerCase[i+key];
					}else if(lowCase==true && (i+key > 25)) {
						inputString[i] = lowerCase[(i+key)-25];
					}

				}
			}

			return inputString.toString();
		}
		
		

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration
		int nth = i;
		int primeCount = 0;
		int number = 1;
		int i1 = 0;

		while (primeCount < nth) {
			number++;
			for (i1 = 2; i1 <= number; i1++) { // Here we will loop from 2 to num
				if (number % i1 == 0) {
					break;
				}
			}
			if (i1 == number) {// if it is a prime number
				primeCount++;
			}
		}
		System.out.println(number);
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			ArrayList<Character> cleansed = new ArrayList<>();
			
			for(int i = 0; i<string.length();i++) {
				switch (string.charAt(i)) {
				case ('A'):
					cleansed.add('z');
					break;

				case ('a'):
					cleansed.add('z');
					break;
					
				case ('B'):
					cleansed.add('y');
					break;

				case ('b'):
					cleansed.add('y');
					break;
					
				case ('C'):
					cleansed.add('x');
					break;

				case ('c'):
					cleansed.add('x');
					break;
					
				case ('D'):
					cleansed.add('w');
					break;

				case ('d'):
					cleansed.add('w');					
				break;
					
				case ('E'):
					cleansed.add('v');
					break;

				case ('e'):
					cleansed.add('v');
					break;
					
				case ('F'):
					cleansed.add('u');
					break;

				case ('f'):
					cleansed.add('u');
					break;
					
				case ('G'):
					cleansed.add('t');
					break;

				case ('g'):
					cleansed.add('t');
					break;
					
				case ('H'):
					cleansed.add('s');
					break;

				case ('h'):
					cleansed.add('s');
					break;
					
				case ('I'):
					cleansed.add('r');
					break;

				case ('i'):
					cleansed.add('r');
					break;
					
				case ('J'):
					cleansed.add('q');
					break;

				case ('j'):
					cleansed.add('q');
					break;
					
				case ('K'):
					cleansed.add('p');
					break;

				case ('k'):
					cleansed.add('p');
					break;
					
				case ('L'):
					cleansed.add('o');
					break;

				case ('l'):
					cleansed.add('o');
					break;
					
				case ('M'):
					cleansed.add('n');
					break;

				case ('m'):
					cleansed.add('n');
					break;
					
				case ('N'):
					cleansed.add('m');
					break;

				case ('n'):
					cleansed.add('m');
					break;
					
				case ('O'):
					cleansed.add('l');
					break;

				case ('o'):
					cleansed.add('l');
					break;
					
				case ('P'):
					cleansed.add('k');
					break;

				case ('p'):
					cleansed.add('k');
					break;
					
				case ('Q'):
					cleansed.add('j');
					break;

				case ('q'):
					cleansed.add('j');
					break;
					
				case ('R'):
					cleansed.add('i');
					break;

				case ('r'):
					cleansed.add('i');
					break;
					
				case ('S'):
					cleansed.add('h');
					break;

				case ('s'):
					cleansed.add('h');
					break;
					
				case ('T'):
					cleansed.add('g');
					break;

				case ('t'):
					cleansed.add('g');
					break;
					
				case ('U'):
					cleansed.add('f');
					break;

				case ('u'):
					cleansed.add('f');
					break;
					
				case ('V'):
					cleansed.add('e');
					break;

				case ('v'):
					cleansed.add('e');
					break;
					
				case ('W'):
					cleansed.add('d');
					break;

				case ('w'):
					cleansed.add('d');
					break;
					
				case ('X'):
					cleansed.add('c');
					break;

				case ('x'):
					cleansed.add('c');
					break;
					
				case ('Y'):
					cleansed.add('b');
					break;

				case ('y'):
					cleansed.add('b');
					break;
					
				case ('Z'):
					cleansed.add('a');
					break;

				case ('z'):
					cleansed.add('a');
					break;
					
				case ('0'):
					cleansed.add('0');
					break;
				case ('1'):
					cleansed.add('1');
					break;
				case ('2'):
					cleansed.add('2');
					break;
				case ('3'):
					cleansed.add('3');
					break;
				case ('4'):
					cleansed.add('4');
					break;
				case ('5'):
					cleansed.add('5');
					break;
				case ('6'):
					cleansed.add('6');
					break;
				case ('7'):
					cleansed.add('7');
					break;
				case ('8'):
					cleansed.add('8');
					break;
				case ('9'):
					cleansed.add('9');
					break;
				}
			}
			
			StringBuffer result = new StringBuffer();
			result.append(cleansed.get(0));
			for (int i = 1; i < cleansed.size(); i++)
			{
			 if(i%5==0) {
				 result.append(' ').append(cleansed.get(i));
			 }else{
				 result.append(cleansed.get(i));
			 }
			}
			
	
			return result.toString();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			
			// TODO Write an implementation for this method declaration
			ArrayList<Character> cleansed = new ArrayList<>();
			
			for(int i = 0; i<string.length();i++) {
				switch (string.charAt(i)) {
				case ('A'):
					cleansed.add('z');
					break;

				case ('a'):
					cleansed.add('z');
					break;
					
				case ('B'):
					cleansed.add('y');
					break;

				case ('b'):
					cleansed.add('y');
					break;
					
				case ('C'):
					cleansed.add('x');
					break;

				case ('c'):
					cleansed.add('x');
					break;
					
				case ('D'):
					cleansed.add('w');
					break;

				case ('d'):
					cleansed.add('w');					
				break;
					
				case ('E'):
					cleansed.add('v');
					break;

				case ('e'):
					cleansed.add('v');
					break;
					
				case ('F'):
					cleansed.add('u');
					break;

				case ('f'):
					cleansed.add('u');
					break;
					
				case ('G'):
					cleansed.add('t');
					break;

				case ('g'):
					cleansed.add('t');
					break;
					
				case ('H'):
					cleansed.add('s');
					break;

				case ('h'):
					cleansed.add('s');
					break;
					
				case ('I'):
					cleansed.add('r');
					break;

				case ('i'):
					cleansed.add('r');
					break;
					
				case ('J'):
					cleansed.add('q');
					break;

				case ('j'):
					cleansed.add('q');
					break;
					
				case ('K'):
					cleansed.add('p');
					break;

				case ('k'):
					cleansed.add('p');
					break;
					
				case ('L'):
					cleansed.add('o');
					break;

				case ('l'):
					cleansed.add('o');
					break;
					
				case ('M'):
					cleansed.add('n');
					break;

				case ('m'):
					cleansed.add('n');
					break;
					
				case ('N'):
					cleansed.add('m');
					break;

				case ('n'):
					cleansed.add('m');
					break;
					
				case ('O'):
					cleansed.add('l');
					break;

				case ('o'):
					cleansed.add('l');
					break;
					
				case ('P'):
					cleansed.add('k');
					break;

				case ('p'):
					cleansed.add('k');
					break;
					
				case ('Q'):
					cleansed.add('j');
					break;

				case ('q'):
					cleansed.add('j');
					break;
					
				case ('R'):
					cleansed.add('i');
					break;

				case ('r'):
					cleansed.add('i');
					break;
					
				case ('S'):
					cleansed.add('h');
					break;

				case ('s'):
					cleansed.add('h');
					break;
					
				case ('T'):
					cleansed.add('g');
					break;

				case ('t'):
					cleansed.add('g');
					break;
					
				case ('U'):
					cleansed.add('f');
					break;

				case ('u'):
					cleansed.add('f');
					break;
					
				case ('V'):
					cleansed.add('e');
					break;

				case ('v'):
					cleansed.add('e');
					break;
					
				case ('W'):
					cleansed.add('d');
					break;

				case ('w'):
					cleansed.add('d');
					break;
					
				case ('X'):
					cleansed.add('c');
					break;

				case ('x'):
					cleansed.add('c');
					break;
					
				case ('Y'):
					cleansed.add('b');
					break;

				case ('y'):
					cleansed.add('b');
					break;
					
				case ('Z'):
					cleansed.add('a');
					break;

				case ('z'):
					cleansed.add('a');
					break;
					
				case ('0'):
					cleansed.add('0');
					break;
				case ('1'):
					cleansed.add('1');
					break;
				case ('2'):
					cleansed.add('2');
					break;
				case ('3'):
					cleansed.add('3');
					break;
				case ('4'):
					cleansed.add('4');
					break;
				case ('5'):
					cleansed.add('5');
					break;
				case ('6'):
					cleansed.add('6');
					break;
				case ('7'):
					cleansed.add('7');
					break;
				case ('8'):
					cleansed.add('8');
					break;
				case ('9'):
					cleansed.add('9');
					break;
				}
			}
			
			StringBuffer result = new StringBuffer();
			result.append(cleansed.get(0));
			for (int i = 1; i < cleansed.size(); i++)
			{
//			 if(i%5==0) {
//				 result.append(' ').append(cleansed.get(i));
//			 }else{
				 result.append(cleansed.get(i));
//			 }
			}
			
	
			return result.toString();
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		
		char[] strArray = string.toCharArray();
		String numeralsAndX = "0123456789X";

		char[] cleanNumber = new char[string.length()];
		
		int counter = 0; //counts where in the clean number index to add an element
		for (char ele : strArray) {
			//sees if the input from the strArray is a numeral
			if (numeralsAndX.indexOf(ele) != -1) {
				cleanNumber[counter] = ele;
				counter++;
			} 
		}
		
		int x1 = Character.getNumericValue(cleanNumber[0]);
		int x2 = Character.getNumericValue(cleanNumber[1]);
		int x3 = Character.getNumericValue(cleanNumber[2]);
		int x4 = Character.getNumericValue(cleanNumber[3]);
		int x5 = Character.getNumericValue(cleanNumber[4]);
		int x6 = Character.getNumericValue(cleanNumber[5]);
		int x7 = Character.getNumericValue(cleanNumber[6]);
		int x8 = Character.getNumericValue(cleanNumber[7]);
		int x9 = Character.getNumericValue(cleanNumber[8]);
		int x10;
		
		if(cleanNumber[9]=='X') {
			x10=10;
		}else if(cleanNumber[9] == '1'||cleanNumber[9] == '2'||cleanNumber[9] == '3'||cleanNumber[9] == '4'
				||cleanNumber[9] == '5'||cleanNumber[9] == '6'||cleanNumber[9] == '7'||cleanNumber[9] == '8'
				||cleanNumber[9] == '9') {
			x10=Character.getNumericValue(cleanNumber[9]);;
		}else {
			return false;
		}
		
		
//		System.out.println(x1);
//		System.out.println(x2);
//		System.out.println(x3);
//		System.out.println(x4);
//		System.out.println(x5);
//		System.out.println(x6);
//		System.out.println(x7);
//		System.out.println(x8);
//		System.out.println(x9);
//		System.out.println(x10);
//		
////		for(int i = 0; i < 11; i++) {
////		System.out.println(cleanNumber[i]);
////		}
		
		if(((x1*10)+(x2*9)+(x3*8)+(x4*7)+(x5*6)+(x6*5)+(x7*4)+(x8*3)+(x9*2)+(x10*1))%11 != 0)  {
			return false;
		}
		
		
		return true;
	}
	
//	public static void main(String[] args) {
//		System.out.println(isValidIsbn("3-598-21507-1"));
//	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		char[] charArray = string.toCharArray();
		
		Boolean isA = false;
		Boolean isB = false;
		Boolean isC = false;
		Boolean isD = false;
		Boolean isE = false;
		Boolean isF = false;
		Boolean isG = false;
		Boolean isH = false;
		Boolean isI = false;
		Boolean isJ = false;
		Boolean isK = false;
		Boolean isL = false;
		Boolean isM = false;
		Boolean isN = false;
		Boolean isO = false;
		Boolean isP = false;
		Boolean isQ = false;
		Boolean isR = false;
		Boolean isS = false;
		Boolean isT = false;
		Boolean isU = false;
		Boolean isV = false;
		Boolean isW = false;
		Boolean isX = false;
		Boolean isY = false;
		Boolean isZ = false;

			for(int i = 0;i<charArray.length;i++) {
				
			switch (charArray[i]) {
			case ('A'):
				isA = true;
				break;

			case ('a'):
				isA = true;
				break;
			case ('B'):
				isB = true;
				break;

			case ('b'):
				isB = true;
				break;
			case ('C'):
				isC = true;
				break;

			case ('c'):
				isC = true;
				break;
			case ('D'):
				isD = true;
				break;

			case ('d'):
				isD = true;
				break;
			case ('E'):
				isE = true;
				break;

			case ('e'):
				isE = true;
				break;
			case ('F'):
				isF = true;
				break;

			case ('f'):
				isF = true;
				break;
			case ('G'):
				isG = true;
				break;

			case ('g'):
				isG = true;
				break;
			case ('H'):
				isH = true;
				break;

			case ('h'):
				isH = true;
				break;
			case ('I'):
				isI = true;
				break;

			case ('i'):
				isI = true;
				break;
			case ('J'):
				isJ = true;
				break;

			case ('j'):
				isJ = true;
				break;
			case ('K'):
				isK = true;
				break;

			case ('k'):
				isK = true;
				break;
			case ('L'):
				isL = true;
				break;

			case ('l'):
				isL = true;
				break;
			case ('M'):
				isM = true;
				break;

			case ('m'):
				isM = true;
				break;
			case ('N'):
				isN = true;
				break;

			case ('n'):
				isN = true;
				break;
			case ('O'):
				isO = true;
				break;

			case ('o'):
				isO = true;
				break;
			case ('P'):
				isP = true;
				break;

			case ('p'):
				isP = true;
				break;
			case ('Q'):
				isQ = true;
				break;

			case ('q'):
				isQ = true;
				break;
			case ('R'):
				isR = true;
				break;

			case ('r'):
				isR = true;
				break;
			case ('S'):
				isS = true;
				break;

			case ('s'):
				isS = true;
				break;
			case ('t'):
				isT = true;
				break;

			case ('T'):
				isT = true;
				break;
			case ('U'):
				isU = true;
				break;

			case ('u'):
				isU = true;
				break;
			case ('V'):
				isV = true;
				break;

			case ('v'):
				isV = true;
				break;
			case ('W'):
				isW = true;
				break;

			case ('w'):
				isW = true;
				break;
			case ('x'):
				isX = true;
				break;

			case ('X'):
				isX = true;
				break;
			case ('y'):
				isY = true;
				break;

			case ('Y'):
				isY = true;
				break;
			case ('Z'):
				isZ = true;
				break;

			case ('z'):
				isZ = true;
				break;

			}
		
				
		}
		
		if(isA == true && isB == true && isC == true && isD == true && isE == true && isF == true && isG == true && isH == true && isI == true && isJ == true &&
				 isK == true && isL == true && isM == true && isN == true && isO == true && isP == true && isQ == true && isR == true && isA == true &&
				 isT == true && isU == true && isV == true && isW == true && isX == true && isY == true && isZ == true) {
			return true;
		}
		
		return false;
	}


	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public static Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		
		if (given instanceof LocalDate) {
			LocalDateTime given2 = ((LocalDate) given).atStartOfDay();
			Duration duration = Duration.ofSeconds(1000000000L);
			Temporal result = duration.addTo(given2);

			return result;
		}

		else {
			Duration duration = Duration.ofSeconds(1000000000L);
			Temporal result = duration.addTo(given);
			return result;
		}
		
		

	}
//	
//	public static void main(String[] args) {
//		
//		System.out.println(getGigasecondDate(LocalDate.of(2011, Month.APRIL, 25)));
//		
//	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public static int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		
		Map<Integer,Integer> sum = new HashMap<Integer,Integer>();
		
		int stop = i;
		int result=0;
		
		//iterate through set of numbers
		
		for(int s1 = 0 ; s1 < set.length; s1++) {
			//System.out.println("number for testing " + set[s1]);
			int answere =0;
			for(int multiple = 1; answere<stop; multiple++) {
				answere = set[s1] * multiple;
				if(answere<stop) {
				sum.put(answere, multiple);
				//System.out.println(answere);
				}
			}
			
		}
		
		for (Map.Entry<Integer, Integer> pair : sum.entrySet())
	    {
	        Integer key = pair.getKey();                  
	        result = result + key;
	    }
		
		
		//System.out.println(result);
		return result;
	}
	
//	public static void main(String[] args) {
//		int[] set = {5,6,8};
//		getSumOfMultiples(150, set);
//	}
	
	
	

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		List<Integer> numberList = new ArrayList<Integer>();
		String numerals = "1234567890";
		int sum = 0;


		for (int i = 0; i < string.length(); i++) {
			if (Character.isLetter(string.charAt(i)) == true || string.charAt(i)=='-'||string.charAt(i)==',') {
				System.out.println(string.charAt(i));
				break;
				
			} else if (numerals.indexOf(string.charAt(i)) != -1) {
				numberList.add(Character.getNumericValue(string.charAt(i)));
			}
		}

		System.out.println(numberList);
		
		for(int i = 1; i <numberList.size();i=i+2) {
			//System.out.println(numberList.indexOf((i)));
			//System.out.println(numberList.get(i));
			int change = numberList.get(i)*2;
			if(change > 9) {
				change = change - 9;
			}
			
			numberList.set(i, change);
			System.out.println(change);
			
		}
		
		for (Integer i : numberList)
	    {
	        sum = sum + i;
	    }
		
		if(sum%10 == 0) {
			return true;
		}
		
		return false;
	}

//	public static void main(String[] args) {
//		
//		System.out.println(isLuhnValid("055-444-285"));
//	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		//char[] charArray = string.toCharArray();

		
		
		int spaceIndex1 = 0;
		int spaceIndex2 = 0;
		int spaceIndex3 = 0;
		int questionMark = 0;
		int number1;
		int number2; 
		int answere = 0;
		String operator;
		
		
		int spaceCounter = 0;
		
		//this for loops finds the spaces and the Question mark
		for (int i = 7; i < string.length(); i++) {
			if (string.charAt(i) == ' ') {
				if(spaceCounter==0) {
					spaceIndex1=i;
				}else if(spaceCounter==1) {
					spaceIndex2=i;
				}else if(spaceCounter==2) {
					spaceIndex3=i;
				}
				
				spaceCounter++;
			}
			if(string.charAt(i) == '?') {
				questionMark = i;
			}
			
		}
		
		
		
	
		System.out.println(spaceIndex1);
		System.out.println(spaceIndex2);
		System.out.println(spaceIndex3);
		System.out.println(questionMark);

		number1 = Integer.parseInt(string.substring(spaceIndex1 + 1, spaceIndex2));
		operator = string.substring(spaceIndex2 + 1, spaceIndex3);
		
		if(operator.equals("multiplied") || operator.equals("divided")) {
			spaceIndex3=spaceIndex3+3;
		}
		number2 = Integer.parseInt(string.substring(spaceIndex3 + 1, questionMark));

//		System.out.println(number1);
//		System.out.println(operator);
//		System.out.println(number2);
//		System.out.println(number1 + number2);

		switch (operator) {
		case "plus":
			answere = number1 + number2;
			break;
		case "minus":
			answere = number1 - number2;
			break;
		case "multiplied":
			answere = number1 * number2;
			break;
		case "divided":
			answere = number1 / number2;
			break;

		}
		
		
		
		return answere;
	}

}
