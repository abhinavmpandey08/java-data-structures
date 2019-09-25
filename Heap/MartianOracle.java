/**
 * @author Abhinav Pandey
 */

public class MartianOracle {
	final private int m_totalSize;
	
	private Heap min;
	private Heap max;
	private int k;
	private int comparisons;
	
	/**
	 * constructor of the class
	 * @param size The first number in the stream, denoting the total number of positive integers
	 */
	public MartianOracle(int size) {
		m_totalSize = size;
		k = 0;
		max = new Heap(size/3);
		min = new Heap(size-size/3);
		comparisons = 0;
	}
	
	/**
	 * process a positive integer
	 * @param value The new positive integer to process
	 */
	public void process(int value) {
		
		if (max.isEmpty() && min.isEmpty()) {
			min.insert(value);
		}
		else if (k % 3 == 2) {
			comparisons++;
			if (value > min.getRoot()) {
				max.insert(min.getRoot());
				min.replaceRoot(value);
				max.siftUpMax();
				min.siftDownMin();
			}
			else {
				max.insert(value);
				max.siftUpMax();
			}
				
		}
		else {
			comparisons++;
			if (value < max.getRoot()) {
				min.insert(max.getRoot());
				max.replaceRoot(value);
				min.siftUpMin();
				max.siftDownMax();
			}
			else {
				min.insert(value);
				min.siftUpMin();
			}
		}
		k++;
	}
	
	public int getComparisons() {
		return comparisons + min.getComparions() + max.getComparions();
	}
	
	/**
	 * query the \lfloor \frac{k+2}{3} \rfloor-rd smallest value
	 * @return The current \lfloor \frac{k+2}{3} \rfloor-rd smallest value
	 */
	public int query() {
		int val = min.getRoot();
		if ((k+2)/3 == max.getSize())
			val = max.getRoot();
		return val;
	}
}
