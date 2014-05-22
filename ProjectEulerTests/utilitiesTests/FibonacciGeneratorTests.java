package utilitiesTests;

import static org.junit.Assert.*;
import org.junit.Test;

import utilities.FibonacciGenerator;

public class FibonacciGeneratorTests {

	FibonacciGenerator fibGen = new FibonacciGenerator();
	
	@Test
	public void bottomUp_Input10_Returns55() {		
		int excpected = 55;
		int actual = fibGen.bottomUpFib(10);
		
		assertEquals(excpected, actual);
	}

	@Test
	public void naiveFib_Input10_Returns55() {		
		int excpected = 55;
		int actual = fibGen.naiveFib(10);
		
		assertEquals(excpected, actual);
	}
}
