package utilities;

public class FibonacciGenerator {
	
	/*
	 * Naive recursive approach
	 */
	public int naiveFib(int n){
		if (n == 0) return 0;
		if (n == 1) return 1;
		return naiveFib (n-1) + naiveFib (n-2);
	}

	/*
	 * Bottom up approach
	 */
	public int bottomUpFib(int n){
		if (n==0){
			return 0;
		}else{
			int previousFib = 0, currentFib = 1;
			for (int i=0; i<n-1; i++){
				int newFib = previousFib + currentFib;
				previousFib = currentFib;
				currentFib = newFib;
			}
			return currentFib;
		}
	}

}
