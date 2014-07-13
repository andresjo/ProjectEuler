package problems;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import utilities.PrimeNumbersGenerator;

/**
 * @author Andre
 *
 */
public class ProjectEuler {
	private static HashMap<Long, Integer> collatzSequenceLengths = new HashMap<Long, Integer>();
	
	private static HashMap<Integer, String> numberDictionairy = new HashMap<Integer, String>();
	
	/**
	 * Problem 1, Find the sum of all the multiples of 3 or 5 below 1000.
	 * @param limit
	 * @return Returns the sum of all numbers from 0 to limit dividible by three or five
	 */
	public static int problem1_sumMultiplesOfThreeAndFive(int limit){
		int sum = 0;
		for (int i = 0; i < limit; i++){
			if (i%3 == 0 || i%5 == 0){
				sum +=i;
			}
		}
		return sum;
	}
	
	
	/**
	 * Problem 2, By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
	 * @param maxFibValue
	 * @return Returns the sum of all even fibonacci numbers whose value does not exceed maxFibValue
	 */
	public static int problem2_sumOfEvenFibNumbers(int maxFibValue) {
		int sum = 0;
		int previousFib = 0;
		int currentFib = 1;
		int newFib = 0;
		
		while (currentFib < maxFibValue){
			newFib = previousFib + currentFib;
			if (newFib % 2 == 0){
				sum += newFib;
			}
			previousFib = currentFib;
			currentFib = newFib;
		}		
		return sum;
	}
	
	
	/**
	 * Problem 3, What is the largest prime factor of the number 600851475143 ?
	 * @param number
	 * @return Returns the largest prime factor of the input number
	 */
	public static int problem3_findLargestPrimeFactor(double number) {
		for (double i = 2; i < Math.sqrt(number); i++){			
			if (number % i == 0){
				return problem3_findLargestPrimeFactor(number/i);
			}
		}
		return (int) number;
	}
	
	
	/**
	 * Problem 4, Find the largest palindrome made from the product of two 3-digit numbers.
	 * @param startFactor
	 * @return Returns the largest palindrome product of two numbers whose value is from 1 to input.
	 */
	public static int problem4_findLargestPalindromeProduct(int startFactor) {
		int max = 0;
		for (int i = 0; i < startFactor; i++){
			for (int j = 0; j < startFactor; j++){				
				int product = (startFactor - i) * (startFactor - j);
				if (isPalindrome(Integer.toString(product)) && product > max){
					max = product;
				}			
			}			
		}
		
		return max;
	}
	
	private static boolean isPalindrome(String str){
		for (int i = 0; i < str.length()/2; i++){		
			if (str.charAt(i) != str.charAt(str.length()-1-i)){
				return false;
			}
		}		
		return true;
	}
	
	
	/**
	 * Problem 5, What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
	 * @param highestDivisor
	 * @return Returns the lowest positive integer divisible by all numbers from 1 to n.
	 */
	public static int problem5_leastCommonMultiple(int highestDivisor) {		
		int candidate = 1;
		int divisor = highestDivisor;
		Integer[] primeFactorsOfHighestDivisor = PrimeNumbersGenerator.generatePrimesWhoseValueDoesNotExceedN(highestDivisor);
		
		for (int value : primeFactorsOfHighestDivisor){
			candidate *= value;
		}	
		
		int productOfPrimes = candidate;
		
		while (divisor > 1){
			if (candidate % divisor == 0){
				divisor--;
			} else {
				candidate += productOfPrimes;
				divisor = highestDivisor;
			}
		}
		
		return candidate;
	}
	
	
	/**
	 * Problem 6, Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
	 * @param n
	 * @return Returns the difference of the sum of the squares of the n first natural numbers, and the square of the sum of the first n natural numbers.
	 */
	public static int problem6_sumSquareDifference(int n) {
		int sumOfNFirstNumbers = ((n+1)*n)/2;
		int squareOfSum = (sumOfNFirstNumbers * sumOfNFirstNumbers);
		int sumOfSquares = 0;
		
		for (int i = 0; i < n+1; i++) {
			sumOfSquares += i*i;
		}
		
		return squareOfSum - sumOfSquares;
	}
	
	
	/**
	 * Problem 7, find the 10001st prime
	 * @param n
	 * @return Returns the n-th prime number
	 */
	public static int problem7_nThPrime(int n) {
		if (n == 1){
			return 2;
		}
		
		int divisor = 3;
		int primeCandidate = 3;
		int numbersFound = 1;
		
		while (numbersFound < n) {
			 if (primeCandidate != divisor  && primeCandidate % divisor == 0 ){		// is not prime
				divisor = 3;
				primeCandidate += 2;
			} else if (divisor == primeCandidate) {		// is prime
				divisor = 3;
				numbersFound++;
				if (numbersFound == n){
					return primeCandidate;
				}
				primeCandidate+=2;
			} else {
				divisor++;
			}
		}
		
		return 0;
	}	
	
	
	/**
	 * Problem 8, Find the five adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
	 * @param inString
	 * @return Returns the largest product of five consecutive numbers in the input-string.
	 */
	public static int problem8_largestProductOfFiveConsecutiveNumbers(String inString){
		int maxFound = 0;
		
		for (int i = 0; i < inString.length() - 4; i++) {
			String subString = inString.substring(i, i+5);
			int number = 1;
			
			for (int j = 0; j < 5; j++) {
				number *= Character.getNumericValue(subString.charAt(j));
			}
			
			if (number > maxFound){
				maxFound = number;
			}
		}
		
		return maxFound;		
	}
	
	
	/**
	 * Problem 9, There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc
	 * @param n
	 * @return Returns the product of a pythagorean triple whose sum is equal to the input
	 */
	public static int problem9_pythagoreanTriple(int n) {		
		for (int a = 0; a < n/4; a++) {
			for (int b = a+1; b < n/2; b++) {
				int c = n - a - b;
				if (c*c == a*a + b*b){		// Is a Pythagorean triplet
					return a*b*c;
				}
			}
		}
		return 0;
	}
	

	/**
	 * Problem 10, Find the sum of all the primes below two million.
	 * @param n
	 * @return Returns the sum of all primes up to and including n
	 */
	public static long problem10_sumOfPrimes(int n) {
		Integer[] primes = PrimeNumbersGenerator.generatePrimesWhoseValueDoesNotExceedN(n);
		long sum = 0;
		
		for (int prime : primes) {
			sum += prime;
		}
		
		return sum;
	}
	
	
	/**
	 * Problem 11, What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?
	 * @param grid
	 * @return Returns the greatest product of four adjacent numbers in a grid, in the same direction.
	 */
	public static int problem11_largestProductInGrid(int[][] grid) {
		int max = 0;
		
		max = searchRows(grid, max);
		
		max = searchColumns(grid, max);
		
		max = searchDiagonallyUpperLeftToBottomRight(grid, max);
		
		max = searchDiagonallyBottomLeftToUpperRight(grid, max);
		
		return max;
	}


	private static int searchDiagonallyBottomLeftToUpperRight(int[][] grid, int max) {
		for (int row = grid.length-1; row > 2; row--) { 
			for (int column = 0; column < grid[row].length-3; column++) {
				int value = 1;
				for (int i = 0; i < 4; i++){
					value *= grid[row-i][column+i];	
				}
				if (value > max){
					max = value;
				}
			}			
		}
		return max;
	}

	private static int searchDiagonallyUpperLeftToBottomRight(int[][] grid, int max) {
		for (int row = 0; row < grid.length-3; row++) { //then diagonay downards
			for (int column = 0; column < grid[row].length-3; column++) {
				int value = 1;
				for (int i = 0; i < 4; i++){
					value *= grid[row+i][column+i];	
				}
				if (value > max){
					max = value;
				}
			}			
		}
		return max;
	}

	private static int searchColumns(int[][] grid, int max) {
		for (int row = 0; row < grid.length-3; row++) { //then down
			for (int column = 0; column < grid[row].length; column++) {
				int value = 1;
				for (int i = 0; i < 4; i++){
					value *= grid[row+i][column];	
				}
				if (value > max){
					max = value;
				}
			}	
		}
		return max;
	}

	private static int searchRows(int[][] grid, int max) {
		for (int row = 0; row < grid.length; row++) { //let's start by going sideways
			for (int column = 0; column < grid[row].length-3; column++) {
				int value = 1;
				for (int i = 0; i < 4; i++){
					value *= grid[row][column+i];	
				}
				if (value > max){
					max = value;
				}
			}		
		}
		return max;
	}


	/**
	 * Problem 25, What is the first term in the Fibonacci sequence to contain 1000 digits?
	 * @param n
	 * @return Returns which fibonacci number is the first one of length n.
	 */
	public static int problem25_firstFibonacciOfLenghtN(int n) {
		int counter = 1;
		BigInteger previousFib = new BigInteger("0");
		BigInteger currentFib = new BigInteger("1");
		BigInteger newFib;
		
		while (currentFib.toString().length() < n){
			newFib = previousFib.add(currentFib);
			previousFib = currentFib;
			currentFib = newFib;
			counter++;
		}
		
		return counter;
	}


	/**
	 * Problem 12, What is the value of the first triangle number to have over five hundred divisors?
	 * @param n
	 * @return Returns the first triangular number with more than n divisors
	 */
	public static int problem12_firstTriangularNumberWithMoreThanNDivisors(int n) {
		int triangleNumber;
		int counter;
		
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			counter = 2;
			triangleNumber = (i*(i+1)) / 2;
			
			for (int j = 2; j <= Math.sqrt(triangleNumber); j++) {
				if (triangleNumber%j == 0) {
					counter+=2;				
					if (counter > n) {
						return triangleNumber;
					}
				}
			}
			
		}
		
		return 0;
	}	
	
	/**
	 * Problem 13, Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
	 * @return Reads the numbers from file, sums them and returns the first 10 digits of the result.
	 */
	public static String problem13_first10DigitsOfSumOfOneHundredFiftyDigitNumbers() throws IOException{
		
		List<String> numbers = new ArrayList<String>();
		
		try {
			numbers = Files.readAllLines(Paths.get("src/inputFiles/problem13_numbers.txt"), Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	    BigInteger sum = new BigInteger("0");
	    
	    for (String number : numbers) {
			sum = sum.add(new BigInteger(number));
		}
	    
	    String returnString = sum.toString().substring(0, 10);
		
		return returnString;
	}


	/**
	 * Problem 14, The following iterative sequence is defined for the set of positive integers:
	 * 		n -> n/2 (n is even)
	 * 		n -> 3n + 1 (n is odd)
	 * Which starting number, under one million, produces the longest chain?
	 * @param n
	 * @return Returns the starting number between 1 and n which produces the longest Collatz Sequence
	 */
	public static int collatzSequenceLength(long n) {
		collatzSequenceLengths.put((long) 1, 1);
		
		if (collatzSequenceLengths.containsKey(n)){
			return collatzSequenceLengths.get(n);
		}else{
			int sequenceLength;
			if (n%2 == 0){
				sequenceLength = collatzSequenceLength(n/2) + 1;
				
			}else{
				sequenceLength = collatzSequenceLength(3*n +1) + 1;
			}
			collatzSequenceLengths.put(n, sequenceLength);
			return sequenceLength;
		}
		
	}
	
	public static int problem14_longestCollatzSequence(int n){
		int longestSequenceFound = 1;
		int numberWithLongestSequence = 1;
		
		for (int i=1; i<n; i++){
			if (collatzSequenceLength(i) > longestSequenceFound){
				longestSequenceFound = collatzSequenceLength(i);
				numberWithLongestSequence =  i;
			}
		}
		
		return numberWithLongestSequence;
	}


	/**
	 * Problem 15, Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
	 * How many such routes are there through a 20×20 grid?
	 * @param gridSize
	 * @return Returns the number of Lattice Paths in a n by n grid.
	 */
	public static long problem15_latticePaths(int gridSize) {
		BigInteger a = factorial(gridSize+gridSize);
		BigInteger b = factorial(gridSize);
		BigInteger c = factorial((gridSize+gridSize) - gridSize) ;
		BigInteger result = a.divide(b.multiply(c));
		return Long.parseLong(result.toString());
	}


	private static BigInteger factorial(int n) {
		BigInteger factorial = new BigInteger("1");
		
		for (int i=2; i < n+1; i++){
			factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
		}
		
		return factorial;
	}


	/**
	 * Problem 16, 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
	 * What is the sum of the digits of the number 2^1000?
	 * @param n
	 * @return Returns the sum of the digits of 2 raised to the power of n
	 */
	public static int problem16_powerDigitSum(int n) {
		BigInteger num = new BigInteger("2");
		num = num.pow(n);
		String numString = num.toString();
		int sum = 0;
		
		for ( int i=0; i<numString.length(); i++){
			sum += Character.getNumericValue( numString.charAt(i));
		}
		
		return sum;
	}


	/**Problem 17, If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
	 * @param n
	 * @return Returns the number of letters used to write out every number from 1 to n
	 */
	public static int problem17_numberLetterCounts(int n) {
		int sum = 0;
		for (int i = 1; i < n+1; i++) {
			sum += numberAsWords(i).length();
		}
		return sum;
	}


	private static String numberAsWords(int n) {
		String numberAsWords = "";
		
		//Use hashmap as dictionairy
		numberDictionairy.put(1, "one");
		numberDictionairy.put(2, "two");
		numberDictionairy.put(3, "three");
		numberDictionairy.put(4, "four");
		numberDictionairy.put(5, "five");
		numberDictionairy.put(6, "six");
		numberDictionairy.put(7, "seven");
		numberDictionairy.put(8, "eight");
		numberDictionairy.put(9, "nine");
		numberDictionairy.put(10, "ten");
		numberDictionairy.put(11, "eleven");
		numberDictionairy.put(12, "twelwe");
		numberDictionairy.put(13, "thirteen");
		numberDictionairy.put(14, "fourteen");
		numberDictionairy.put(15, "fifteen");
		numberDictionairy.put(16, "sixteen");
		numberDictionairy.put(17, "seventeen");
		numberDictionairy.put(18, "eighteen");
		numberDictionairy.put(19, "nineteen");
		numberDictionairy.put(20, "twenty");
		numberDictionairy.put(30, "thirty");
		numberDictionairy.put(40, "forty");
		numberDictionairy.put(50, "fifty");
		numberDictionairy.put(60, "sixty");
		numberDictionairy.put(70, "seventy");
		numberDictionairy.put(80, "eighty");
		numberDictionairy.put(90, "ninety");
		numberDictionairy.put(100, "hundred");
		numberDictionairy.put(1000, "thousand");		
	
		int[] number = new int[4];
		int digitsInNumber = Integer.toString(n).length();
		
		//Put thousands, hundreds and tens in an array
		for (int i = 0; i < digitsInNumber; i++) {
			int value = Character.getNumericValue(Integer.toString(n).charAt(digitsInNumber - i - 1));
			number[number.length - i - 1] = value;
		}
		
		//see how many thousands, hundretds, etc. there are
		if (number[0] > 0){																				//Number is 1000 or above
			numberAsWords += numberDictionairy.get(number[0]);
			numberAsWords += numberDictionairy.get(1000);
		}
		
		if (number[1] > 0){																				//Number is 100 or above
			numberAsWords += numberDictionairy.get(number[1]);
			numberAsWords += numberDictionairy.get(100);
		}
			
		if (number[2] > 0 && number[1] > 0 || number[3] > 0 && number[1] > 0){							// number is 100 or above but not exactly a hundred
			numberAsWords += "and";							
		}
			
		if (number[2] == 1){																			// Between 10 and 20
			String twoLastDigitsString = Integer.toString(number[2]) + Integer.toString(number[3]); 
			numberAsWords += numberDictionairy.get( Integer.parseInt(twoLastDigitsString) );
		}
		
		else{																							// 20 or greater
			if (number[2] >= 2){
				String value = Integer.toString(number[2]) + "0";			
				numberAsWords += numberDictionairy.get(Integer.parseInt(value));
			}
			
			if (number[3] > 0){
				numberAsWords += numberDictionairy.get(number[3]);
			}
		}
		
		return numberAsWords;
	}
	
	

}
