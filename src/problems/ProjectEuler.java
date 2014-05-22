package problems;

import java.math.BigInteger;

import utilities.PrimeNumbersGenerator;

/**
 * @author Andre
 *
 */
public class ProjectEuler {
	
	/**
	 * Problem 1, Find the sum of all the multiples of 3 or 5 below 1000.
	 * @param limit
	 * @return Returns the sum of all numbers from 0 to limit dividible by three or five
	 */
	public static int sumMultiplesOfThreeAndFive(int limit){
		int sum = 0;
		for (int i = 0; i < limit; i++){
			if (i%3 == 0|| i%5 == 0){
				sum +=i;
			}
		}
		return sum;
	}
	
	
	/**
	 * Problem 2, By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
	 * @param maxFibValue
	 * @return Returns sum of all even fibonacci numbers whose value does not exceed maxFibValue
	 */
	public static int sumOfEvenFibNumbers(int maxFibValue) {
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
	public static int findLargestPrimeFactor(double number) {
		for (double i = 2; i < Math.sqrt(number); i++){			
			if (number % i == 0){
				return findLargestPrimeFactor(number/i);
			}
		}
		return (int) number;
	}
	
	
	/**
	 * Problem 4, Find the largest palindrome made from the product of two 3-digit numbers.
	 * @param startFactor
	 * @return Returns the largest palindrome product of two numbers whose value is from 1 to input.
	 */
	public static int findLargestPalindromeProduct(int startFactor) {
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
	 * @param n
	 * @return Returns the lowest positive integer divisible by all numbers from 1 to n.
	 */
	public static int leastCommonMultiple(int n) {		
		int number = 1;
		int divisor = n;
		
		for (int value : PrimeNumbersGenerator.generatePrimesWhoseValueDoesNotExceedN(n)){
			number *= value;
		}	
		
		int productOfPrimes = number;
		
		while (divisor > 1){
			if (number % divisor == 0){
				divisor--;
			} else {
				number += productOfPrimes;
				divisor = n;
			}
		}
		
		return number;
	}
	
	
	/**
	 * Problem 6, Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
	 * @param n
	 * @return Returns the difference of the sum of the squares of the n first natural numbers, and the square of the sum of the first n natural numbers.
	 */
	public static int sumSquareDifference(int n) {
		int squareOfSum = (((n+1)*n)/2) * (((n+1)*n)/2);
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
	public static int nThPrime(int n) {
		if (n == 1){
			return 2;
		}
		
		int iterator = 3;
		int number = 3;
		int numbersFound = 1;
		
		while (numbersFound < n) {
			 if (number != iterator  && number % iterator == 0 ){		// is not prime
				iterator = 3;
				number += 2;
			} else if (iterator == number) {		// is prime
				iterator = 3;
				numbersFound++;
				if (numbersFound == n){
					return number;
				}
				number+=2;
			} else {
				iterator++;
			}
		}
		
		return 0;
	}	
	
	
	/**
	 * Problem 8, Find the five adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
	 * @param inString
	 * @return Returns the largest product of five consecutive numbers in the input-string.
	 */
	public static int largestProductOfFiveConsecutiveNumbers(String inString){
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
	public static int pythagoreanTriple(int n) {		
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
	 * @return Returns the sum of the first n primes
	 */
	public static long sumOfPrimes(int n) {
		Integer[] primes = PrimeNumbersGenerator.generatePrimesWhoseValueDoesNotExceedN(n);
		long sum = 0;
		
		for (int j = 0; j < primes.length; j++) {
			sum+=primes[j];
		}
		
		return sum;
	}
	
	
	/**
	 * Problem 11, What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?
	 * @param grid
	 * @return Returns the greatest product of four adjacent numbers in a grid, in the same direction.
	 */
	public static int largestProductInGrid(int[][] grid) {
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
	public static int firstFibonacciOfLenghtN(int n) {
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

}
