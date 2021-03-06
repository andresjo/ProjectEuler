package utilities;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Andre
 *
 */
public class PrimeNumbersGenerator {

	
	/**
	 * @param max
	 * @return Returns an array of prime numbers from 0 up to a maxmimum of the input value.
	 */
	public static Integer[] generatePrimesWhoseValueDoesNotExceedN(int max){
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
		Boolean[] a = new Boolean[max+1];
		Arrays.fill(a, true);
		
		for (int i = 2; i < Math.sqrt(max+1); i++){
			if (a[i] == true){
				int j = i*i;
				int iterator = 1;
				while (j < max+1){
					a[j] = false;
					j = i*i + iterator*i;
					iterator++;
				}
			}
			
		}
		
		for (int i = 2; i < a.length; i++){
			if (a[i] == true) primeNumbers.add(i);
		}
		
		Integer[] primeNumbersArray = primeNumbers.toArray(new Integer[primeNumbers.size()]);
		return primeNumbersArray;
		
	}
	
	/**
	 * @param n
	 * @return Returns the n-th prime number. Is super slow.
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
			}
			else if (iterator == number) {		// is prime
				iterator = 3;
				numbersFound++;
				if (numbersFound == n){
					return number;
				}
				number+=2;
			} 
			else {
				iterator++;
			}
		}
		
		return 0;
	}
	
}
