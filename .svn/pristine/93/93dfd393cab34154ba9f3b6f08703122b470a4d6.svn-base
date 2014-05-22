package problemsTests;

import static org.junit.Assert.*;
import org.junit.Test;
import problems.ProjectEuler;

public class ProjectEulerTests {
	
	
	@Test
	public void sumMultiplesOfThreeAndFive_Input10_Returns23() {
		int expected = 23;
		int actual = ProjectEuler.sumMultiplesOfThreeAndFive(10);
		assertEquals(expected, actual);
	}
	
	@Test
	public void sumOfEvenFibNumbers_Input10_Returns10() {
		int expected = 10;
		int actual = ProjectEuler.sumOfEvenFibNumbers(10);
		assertEquals(expected, actual);
	}
	
	@Test
	public void findLargestPrimeFactor_Input13195_Returns29(){
		int expected = 29;
		int actual = ProjectEuler.findLargestPrimeFactor(13195);
		assertEquals(expected, actual);
	}
	
	@Test
	public void findLargesPalindromeProduct_Input99_Returns9009(){
		int expected = 9009;
		int actual = ProjectEuler.findLargestPalindromeProduct(99);
		assertEquals(expected, actual);
	}
	
	@Test
	public void findLowestPositiveNumberEvenlyDivisible_Input10_Returns2520(){
		int expected = 2520;
		int actual = ProjectEuler.leastCommonMultiple(10);
		assertEquals(expected, actual);
	}
	
	@Test
	public void sumSquareDifference_Input10_Returns2640(){
		int expected = 2640;
		int actual = ProjectEuler.sumSquareDifference(10);
		assertEquals(expected, actual);
	}
	
	@Test 
	public void nThPrime_Input6_Output13(){
		int expected = 13;
		int actual = ProjectEuler.nThPrime(6);
		assertEquals(expected, actual);
	}
	
	@Test
	public void largestProductOfFiveConsecutiveNmbers_Input123452233445_Output720(){
		int expected = 720;
		int actual = ProjectEuler.largestProductOfFiveConsecutiveNumbers("123452233445");
		assertEquals(expected, actual);
	}
	
	@Test
	public void pythagoreanTriple_Input1000_Output31875000(){
		int expected = 31875000;
		int actual = ProjectEuler.pythagoreanTriple(1000);
		assertEquals(expected, actual);
	}
	
	@Test
	public void sumOfPrimes_Input10_Output17(){
		int expected = 17;
		long actual = ProjectEuler.sumOfPrimes(10);
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void largestProductInGrid_HorizontalLineIsGreatestProduct_Output16(){
		int expected = 16;
		int[][] arrays = new int[][] {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {3, 3, 1, 1, 3}, {1, 2, 2, 2, 2}, {1, 1, 1, 1, 1}};
		int actual = ProjectEuler.largestProductInGrid(arrays);
		assertEquals(expected, actual);
	}
	
	@Test
	public void largestProductInGrid_VertocaøLineIsGreatestProduct_Output18(){
		int expected = 18;
		int[][] arrays = new int[][] {{1, 1, 1, 1, 1}, {3, 1, 1, 1, 1}, {1, 3, 1, 1, 3}, {2, 2, 2, 2, 2}, {3, 1, 1, 1, 1}};
		int actual = ProjectEuler.largestProductInGrid(arrays);
		assertEquals(expected, actual);
	}
	
	@Test
	public void largestProductInGrid_DiagonalDownRightIsGreatestProduct_Output625(){
		int expected = 625;
		int[][] arrays = new int[][] {{1, 2, 3, 4, 5}, {1, 5, 2, 3, 4}, {1, 2, 5, 2, 1}, {1, 1, 2, 5, 3}, {2, 2, 2, 2, 5}};
		int actual = ProjectEuler.largestProductInGrid(arrays);
		assertEquals(expected, actual);
	}
	
	@Test
	public void largestProductInGrid_DiagonalUpRightIsGreatestProduct_Output625(){
		int expected = 625;
		int[][] arrays = new int[][] {{1, 1, 3, 2, 5}, {1, 2, 2, 5, 1}, {1, 2, 5, 3, 1}, {2, 5, 2, 1, 1}, {2, 1, 1, 2, 3}};
		int actual = ProjectEuler.largestProductInGrid(arrays);
		assertEquals(expected, actual);
	}
	
	@Test
	public void firstFbionacciOfLengthN_Input3_Returns12(){
		int expected = 12;
		int actual = ProjectEuler.firstFibonacciOfLenghtN(3);
		assertEquals(expected, actual);
	}
}