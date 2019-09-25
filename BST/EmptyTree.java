public class EmptyTree<K extends Comparable<K>, V> extends Tree<K, V> {

	// the single unique instance of emptyTree
	private static EmptyTree emptyTree= new EmptyTree();
	
	/*
	 * private constructor so the EmptyTree can't be instantiated outside 
	 * this class. If any class needs a EmptyTree object, it should 
	 * call the static getInstance() method.
	 */
	private EmptyTree() {	
	}
	
	// returns a single unique instance of this EmptyTree every time
	public static EmptyTree getInstance() {
		return emptyTree;
	}

	// returns a NonEmptyTree with key keyIn and value valueIn
	public NonEmptyTree<K, V> insertKeyValuePair(K keyIn, V valueIn) {
		return new NonEmptyTree<K,V>(keyIn, valueIn);
	}

	/*
	 *  Returns the size of the tree.
	 *  Since this is an EmptyTree, it always returns 0.
	 */
	public int size() {
		return 0;
	}

	/*
	 * Returns the value associated with the key keyIn.
	 * Since this is an EmptyTree, it always returns 0.
	 */
	public V getValueForKey(K keyIn) {
		
		if (keyIn == null)
			throw new IllegalArgumentException();
		
		return null;
	}

	/*
	 * Returns the depth of key keyIn.
	 * Since this is an EmptyTree, it always returns -1.
	 */
	public int depthOfKey(K keyIn) {
		
		if (keyIn == null)
			throw new IllegalArgumentException();
		
		return -1;
	}

	/*
	 * Just returns the single unique instance of the EmptyTree
	 */
	public Tree<K, V> copyOfTree() {
		return getInstance();
	}

	/*
	 * Throws EmptyTreeException since an EmptyTree doesn't have any elements
	 */
	public K max() throws EmptyTreeException {
		throw new EmptyTreeException();
	}

	/*
	 * Throws EmptyTreeException since an EmptyTree doesn't have any elements
	 */
	public K min() throws EmptyTreeException {
		throw new EmptyTreeException();
	}

	/*
	 * Deletes the tree element with key keyIn and then returns the tree.
	 * Since this is an EmptyTree, it just returns the instance of EmptyTree.
	 */
	public Tree<K, V> deleteKeyValuePair(K keyIn) {
		return getInstance();
	}

	/*
	 * Returns the String representation of the current tree.
	 * Since this is an EmptyTree, it just returns an empty string.
	 */
	public String toString() {
		return "";
	}

}
