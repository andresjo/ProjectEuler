package utilities;

public class UtilitiesMainClass {

	public static void main(String[] args) {
		/*
		 * See output from fibonacci generator
		 */
		FibonacciGenerator fibGen = new FibonacciGenerator();
		int a = fibGen.bottomUpFib(10);
		System.out.println(a);
		
		/*
		 * See output from primes generator
		 */
		PrimeNumbersGenerator primeGen = new PrimeNumbersGenerator();
		Integer[] array = primeGen.generatePrimesWhoseValueDoesNotExceedN(100);
		String outStr = "Primes: ";
		for (int number : array){
			outStr += number+ " ";
		}		
		System.out.println(outStr);
	
	}

}
