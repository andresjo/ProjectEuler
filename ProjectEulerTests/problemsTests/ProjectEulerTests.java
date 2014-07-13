package problemsTests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import problems.ProjectEuler;

public class ProjectEulerTests {

	

	
	@Test
	public void problem1_sumMultiplesOfThreeAndFive_Input10_Returns23() {
		int expected = 23;
		int actual = ProjectEuler.problem1_sumMultiplesOfThreeAndFive(10);
		assertEquals(expected, actual);
	}
	
	@Test
	public void problem2_sumOfEvenFibNumbers_Input10_Returns10() {
		int expected = 10;
		int actual = ProjectEuler.problem2_sumOfEvenFibNumbers(10);
		assertEquals(expected, actual);
	}
	
	@Test
	public void problem3_findLargestPrimeFactor_Input13195_Returns29(){
		int expected = 29;
		int actual = ProjectEuler.problem3_findLargestPrimeFactor(13195);
		assertEquals(expected, actual);
	}
	
	@Test
	public void problem4_findLargesPalindromeProduct_Input99_Returns9009(){
		int expected = 9009;
		int actual = ProjectEuler.problem4_findLargestPalindromeProduct(99);
		assertEquals(expected, actual);
	}
	
	@Test
	public void problem5_findLowestPositiveNumberEvenlyDivisible_Input10_Returns2520(){
		int expected = 2520;
		int actual = ProjectEuler.problem5_leastCommonMultiple(10);
		assertEquals(expected, actual);
	}
	
	@Test
	public void problem6_sumSquareDifference_Input10_Returns2640(){
		int expected = 2640;
		int actual = ProjectEuler.problem6_sumSquareDifference(10);
		assertEquals(expected, actual);
	}
	
	@Test 
	public void problem7_nThPrime_Input6_Output13(){
		int expected = 13;
		int actual = ProjectEuler.problem7_nThPrime(6);
		assertEquals(expected, actual);
	}
	
	@Test
	public void problem8_largestProductOfFiveConsecutiveNmbers_Input123452233445_Output720(){
		int expected = 720;
		int actual = ProjectEuler.problem8_largestProductOfFiveConsecutiveNumbers("123452233445");
		assertEquals(expected, actual);
	}
	
	@Test
	public void problem9_pythagoreanTriple_Input1000_Output31875000(){
		int expected = 31875000;
		int actual = ProjectEuler.problem9_pythagoreanTriple(1000);
		assertEquals(expected, actual);
	}
	
	@Test
	public void problem10_sumOfPrimes_Input10_Output17(){
		int expected = 17;
		long actual = ProjectEuler.problem10_sumOfPrimes(10);
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void problem11_largestProductInGrid_HorizontalLineIsGreatestProduct_Output16(){
		int expected = 16;
		int[][] arrays = new int[][] {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {3, 3, 1, 1, 3}, {1, 2, 2, 2, 2}, {1, 1, 1, 1, 1}};
		int actual = ProjectEuler.problem11_largestProductInGrid(arrays);
		assertEquals(expected, actual);
	}
	
	@Test
	public void problem11_largestProductInGrid_VerticaLineIsGreatestProduct_Output18(){
		int expected = 18;
		int[][] arrays = new int[][] {{1, 1, 1, 1, 1}, {3, 1, 1, 1, 1}, {1, 3, 1, 1, 3}, {2, 2, 2, 2, 2}, {3, 1, 1, 1, 1}};
		int actual = ProjectEuler.problem11_largestProductInGrid(arrays);
		assertEquals(expected, actual);
	}
	
	@Test
	public void problem11_largestProductInGrid_DiagonalDownRightIsGreatestProduct_Output625(){
		int expected = 625;
		int[][] arrays = new int[][] {{1, 2, 3, 4, 5}, {1, 5, 2, 3, 4}, {1, 2, 5, 2, 1}, {1, 1, 2, 5, 3}, {2, 2, 2, 2, 5}};
		int actual = ProjectEuler.problem11_largestProductInGrid(arrays);
		assertEquals(expected, actual);
	}
	
	@Test
	public void problem11_largestProductInGrid_DiagonalUpRightIsGreatestProduct_Output625(){
		int expected = 625;
		int[][] arrays = new int[][] {{1, 1, 3, 2, 5}, {1, 2, 2, 5, 1}, {1, 2, 5, 3, 1}, {2, 5, 2, 1, 1}, {2, 1, 1, 2, 3}};
		int actual = ProjectEuler.problem11_largestProductInGrid(arrays);
		assertEquals(expected, actual);
	}
	
	@Test
	public void problem12_firstTriangularNumberWithNDivisors_Input5_Returns28(){
		int expected = 28;
		int actual = ProjectEuler.problem12_firstTriangularNumberWithMoreThanNDivisors(5);
		assertEquals(expected, actual);
	}
	
	@Test
	public void problem13_first10DigitsOfSumOfOneHundredAndFiftyDigitNumberTest(){
		String expected = "5537376230";
		String actual = null;
		try {
			actual = ProjectEuler.problem13_first10DigitsOfSumOfOneHundredFiftyDigitNumbers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(expected, actual);		
	}
	
	@Test
	public void problem14_firstFbionacciOfLengthN_Input3_Returns12(){
		int expected = 12;
		int actual = ProjectEuler.problem25_firstFibonacciOfLenghtN(3);
		assertEquals(expected, actual);
	}
	
	@Test
	public void problem15_collatzSequenceLength_Input13_Returns10(){
		int expected = 10;
		int actual = ProjectEuler.collatzSequenceLength(13);
		assertEquals(expected, actual);		
	}
	
	@Test
	public void problem16_latticePathsInGrid_Input2_Returns6(){
		long expected = 6;
		long actual = ProjectEuler.problem15_latticePaths(2);
		assertEquals(expected, actual);		
	}
	
	@Test
	public void problem17_powerDigitSum_Input15_Returns26(){
		int expected = 26;
		int actual = ProjectEuler.problem16_powerDigitSum(15);
		assertEquals(expected, actual);		
	}
	
	@Test
	public void problem18_numberLetterCounts_Input5_Returns19(){
		int expected = 19;
		int actual = ProjectEuler.problem17_numberLetterCounts(5);
		assertEquals(expected, actual);
	}
	
}