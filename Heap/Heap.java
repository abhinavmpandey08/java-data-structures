/**
 * @author Abhinav Pandey
 * Heap implementation in Java to calculate the number of comparisons during different heap operations.
 */

public class Heap {
	
	private int [] heap;
	private int size;
	private int comparisons;

	/**
	 * Constructor which initializes heap of size n.
	 * This heap implementation has a sentinal (-1) at index 0.
	 * @param n Number of elements in the Heap.
	 */
	public Heap(int n) {
		heap = new int[n+1];
		heap[0] = -1;
		size = 1;
		comparisons = 0;
	}

	/**
	 * Inserts a value in the heap.
	 * @param a Integer value to be inserted in the heap.
	 */
	public void insert(int a) {
		if (size < heap.length)
			heap[size++] = a;
	}

	/**
	 * Returns the size of the heap.
	 * @return Size of the heap.
	 */
	public int getSize() {
		return size-1;
	}

	/**
	 * Checks if heap has k elements.
	 * @param k Number of elements to check in the heap.
	 * @return True if heap has exactly k elements. False otherwise.
	 */
	public boolean isFullWith(int k) {
		return (size == k);
	}

	/**
	 * Sifting function which sifts max value all the way up to maintain MaxHeap property.
	 * Only to be used when implementing MaxHeap.
	 */
	public void siftUpMax() {
		int c = size-1;
		while (c > 1) {
			int p = c / 2;
			comparisons++;
			if (heap[c] > heap[p]) {
				swap(c,p);
				c = p;
			}
			else break;
		}
	}

	/**
	 * Sifting function which sifts min value all the way up to maintain MinHeap property.
	 * Only to be used when implementing MinHeap.
	 */
	public void siftUpMin() {
		int c = size-1;
		while (c > 1) {
			int p = c / 2;
			comparisons++;
			if (heap[c] < heap[p]) {
				swap(c,p);
				c = p;
			}
			else break;
		}
	}

	/**
	 * Heapify function to be used only for MaxHeap.
	 */
	public void siftDownMax() {
		int p = 1;
		int c = 2*p;
		int m = size - 1;
		while (c <= m) {
			if (c < m) {
				if (heap[c+1] > heap [c]) 
					c = c+1;
				comparisons++;
			}
			if (heap[c] > heap[p]) {
				swap(c,p);
				p = c;
				c = 2*p;
			}
			else return;
		}
	}

	/**
	 * Heapify function to be used only for MinHeap.
	 */
	public void siftDownMin() {
		int p = 1;
		int c = 2*p;
		int m = size - 1;
		while (c <= m) {
			if (c < m) {
				if (heap[c+1] < heap [c]) 
					c = c+1;
				comparisons++;
			}
			if (heap[c] < heap[p]) {
				swap(c,p);
				p = c;
				c = 2*p;
			}
			else return;
		}
	}

	/**
	 * Replaces root with k.
	 * @param k Integer value to replace root with.
	 */
	public void replaceRoot(int k) {
		heap[1] = k;
	}

	/**
	 * Returns the root of the heap.
	 * @return Root of the heap, or -1 if heap is empty.
	 */
	public int getRoot() {
		int root = -1;
		if (!isEmpty())
			root = heap[1];
		return root;
	}

	/**
	 * Checks if the heap is empty.
	 * @return True if heap is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return (size == 1);
	}

	/**
	 * Swaps element at index a and b in the heap array.
	 * @param a	Index of the first element.
	 * @param b Index of the second element.
	 */
	public void swap (int a, int b) {
		int t = heap[a];
		heap[a] = heap[b];
		heap[b] = t;
	}

	/**
	 * Returns the number of comparisons used during Sifting and Heapify operations.
	 * @return Number of comparisons.
	 */
	public int getComparions() {
		return comparisons;
	}

	/**
	 * Prints out the heap array in a nice format.
	 */
	public void printArray() {
		int a[] = heap;
		System.out.print("[");
		for (int i = 1; i < a.length - 1; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.println(a[a.length-1] + "]");
	}
}
