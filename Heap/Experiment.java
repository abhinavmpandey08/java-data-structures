/**
 * @author Abhinav Pandey
 * Runner class to setup an experiment to test number of calculations in heap creation
 * and insertions and save the results in 'Permutation.csv' file.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Experiment {
	public static void main(String args[]) throws FileNotFoundException {
		PermutationGenerator pg = new PermutationGenerator(new Random());
		File f = new File("Permutation.csv");
		PrintWriter writer = new PrintWriter(f);
		for(int n = 1000; n < 1000000; n+=1000){
			int[] a = pg.nextPermutation(n);
			MartianOracle o = new MartianOracle(n);
			for (int i = 0; i < n; i++) {
				o.process(a[i]);
			}
			writer.println(n + "," + o.getComparisons());
		}
	}

}
