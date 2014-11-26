package problems;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import utilities.TriangleFileReader;

public class ProblemsMainClass {

	public static void main(String[] args) throws NumberFormatException, IOException {	
		long startTime = System.nanoTime();
		
		System.out.println("Problem 1. Sum of multiples of 3 and 5 from 0 to 1000: " 
				+ ProjectEuler.problem1_sumMultiplesOfThreeAndFive(1000));
		
		System.out.println("Problem 2. Sum of all even Fibonacci-numbers whose "
				+ "value does not exceed four millions: " + ProjectEuler.problem2_sumOfEvenFibNumbers(4000000));
		
		System.out.println("Problem 3. Largest prime factor of 600851475143 is: " 
				+ ProjectEuler.problem3_findLargestPrimeFactor(600851475143L));
		
		System.out.println("Problem 4. Largest palindrome product of two three-digit numbers is: " 
				+ ProjectEuler.problem4_findLargestPalindromeProduct(999));

		System.out.println("Problem 5. Smallest integer divisible by all numbers from 1 to 20 is: " 
				+ ProjectEuler.problem5_leastCommonMultiple(20));
		
		System.out.println("Problem 6. The sum square difference of the first 100 natural numbers is: " + 
				+ ProjectEuler.problem6_sumSquareDifference(100));
		
		System.out.println("Problem 7. The 10 001st prime number is: " + 
				+ ProjectEuler.problem7_nThPrime(10001));
		
		String num = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		System.out.println("Problem 8. Largest product of 5 consecutive numbers: " + ProjectEuler.problem8_largestProductOfFiveConsecutiveNumbers(num));
		
		System.out.println("Problem 9. Product of pytagorean triple whose sum = 1000: "+ ProjectEuler.problem9_pythagoreanTriple(1000));
		
		System.out.println("Problem 10. Sum of primes whose value does not exceed two million: " + ProjectEuler.problem10_sumOfPrimes(2000000));
				
		int[][] grid = new int[][] {
				{8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8}, 
				{49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0}, 
				{81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65}, 
				{52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91}, 
				{22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80},
				{24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50},
				{32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70},
				{67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21},
				{24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72},
				{21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95},
				{78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92},
				{16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 5},
				{86, 56, 0, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58},
				{19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40},
				{4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66},
				{88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69},
				{4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36},
				{20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16},
				{20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54},
				{1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48}
				};
		
		System.out.println("Problem 11. Largest product of four adjecent numbers in the grid: "+ProjectEuler.problem11_largestProductInGrid(grid));
		
		System.out.println("Problem 12. First triangle number with 500 divisors is: "+ProjectEuler.problem12_firstTriangularNumberWithMoreThanNDivisors(500));

		
		List<String> numbers = new ArrayList<String>();
		try {
			numbers = Files.readAllLines(Paths.get("src/inputFiles/problem13_numbers"), Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println( "Problem 13. First 10 digits of the sum of the 100 50-digit numbers: " + ProjectEuler.problem13_first10DigitsOfSumOfOneHundredFiftyDigitNumbers(numbers));

		
		System.out.println("Problem 14. The number below 1 million with the longest Collatz Sequence  is: "+ProjectEuler.problem14_longestCollatzSequence(1000000));
		
		System.out.println("Problem 15. The number of Lattice Paths from the top-left to the bottom-right of a 20x20 grid is: "+ProjectEuler.problem15_latticePaths(20));
		
		System.out.println("Problem 16. The sum of the digits is: "+ProjectEuler.problem16_powerDigitSum(1000));
		
		System.out.println("Problem 17. Letters used when writing all nums between 1 and 1000 out in words: "+ProjectEuler.problem17_numberLetterCounts(1000));
		
		List<Integer[]> triangle = TriangleFileReader.getTriangleFromFile("src/inputFiles/problem18_triangle");
		System.out.println("Problem 18. Maximum total from top to bottom of the triangle is: " + ProjectEuler.problem18_maximumPathSumOftriangle(triangle));
		
		System.out.println("Problem 25. First term in the Fibonacci sequence to contain 1000 numbers is: "+ProjectEuler.problem25_firstFibonacciOfLenghtN(1000));
		
		triangle = TriangleFileReader.getTriangleFromFile("src/inputFiles/problem67_triangle");
		System.out.println("Problem 67. Maximum total from top to bottom of the triangle is: " + ProjectEuler.problem18_maximumPathSumOftriangle(triangle));
		
		long endTime = System.nanoTime();
		long elapsed = endTime - startTime;
		double seconds = (double) elapsed / 1000000000.0;
		System.out.println("\nAll calculations took: " +seconds+ " seconds.");				
		

	}
	

}
