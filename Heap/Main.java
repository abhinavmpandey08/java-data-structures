/**
 * @author Abhinav Pandey
 * Main class to test heap comparisons.
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Create a scanner from stdin
		Scanner scanner = new Scanner(System.in);
		
		// First value is the total number of positive integers
		int totalSize = scanner.nextInt();
		MartianOracle oracle = new MartianOracle(totalSize);
		
		while(scanner.hasNext()) {
			// Read next value
			int value = scanner.nextInt();
			if(value == 0) {
				// Query
				System.out.println(oracle.query());
			}
			else {
				// Process
				oracle.process(value);
			}
		}
		scanner.close();
		System.out.println("done");
	}

}
