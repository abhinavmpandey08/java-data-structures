/**
 * @author Abhinav Pandey
 * A class to generate a pseudo-random permutation of {1, 2, 3, ... , n}.
 */

import java.util.Random;

public class PermutationGenerator {

	final private Random m_random;
	
	/**
	 * Constructor to initialize the random source.
	 * @param random The random source.
	 */
	PermutationGenerator(Random random) {
		m_random = random;
	}
	
	/**
	 * Generate a new random permutation of {1, 2, 3, ... , n}.
	 * @param n The size of the permutation.
	 * @return The new random permutation.
	 */
	public int[] nextPermutation(int n) {
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = i+1;
		}
		
		for (int i = 0; i < n; i++) {
			int rand = m_random.nextInt(n);
			swap(a,i,rand);
		}
		
		return a;
	}

	/**
	 * Swaps element at index x and index y in array a[].
	 * @param a Array in which the elements need to be swapped.
	 * @param x Index of the first element.
	 * @param y Index of the second element.
	 */
	private void swap(int[] a, int x, int y) {
		int t = a[x];
		a[x] = a[y];
		a[y] = t;
	}
}
