public class NonEmptyTree<K extends Comparable<K>, V> extends Tree<K, V> {

	private K key;
	private V value;
	private Tree<K,V> left;
	private Tree<K,V> right;

	/*
	 *  constructor that assigns key and value to current NonEmptyTree
	 *  and set left and right to EmptyTree.
	 */
	public NonEmptyTree(K key, V value) {
		this.key = key;
		this.value = value;
		left = EmptyTree.getInstance();
		right = EmptyTree.getInstance();
	}

	/*
	 * Attempts to add a new NonEmptyTree with key: keyIn and value: valueIn
	 * to the current Tree object. If a key: keyIn already exists in the 
	 * Tree, then it replaces the original value associated with that
	 * key to valueIn.
	 * Returns the modified NonEmptyTree object with the keyIn and valueIn
	 * added.
	 */
	public NonEmptyTree<K, V> insertKeyValuePair(K keyIn, V valueIn) {

		//checks to see if either arguments are null
		if (keyIn == null || valueIn == null)
			throw new IllegalArgumentException();

		//indicates that the keyIn is already present in the tree so it
		//sets the value to valueIn.
		else if (key.compareTo(keyIn) == 0) {
			value = valueIn;
			return this;
		}

		//indicates the keyIn must be looked up for/inserted in 
		//the left subtree.
		else if (key.compareTo(keyIn) > 0) {
			left = left.insertKeyValuePair(keyIn, valueIn);
			return this;
		}

		//indicates the keyIn must be looked up for/inserted in 
		//the right subtree.
		else {
			right = right.insertKeyValuePair(keyIn, valueIn);
			return this;
		}
	}

	/*
	 * Returns the number of key/value pairs present in current object tree.
	 */
	public int size() {
		return 1 + left.size() + right.size();
	}

	/*
	 * Returns the value associated with key: keyIn in the current object tree.
	 * Returns null if the key: keyIn isn't present in the tree.
	 */
	public V getValueForKey(K keyIn) {
		
		//checks to see if the argument is null
		if (keyIn == null)
			throw new IllegalArgumentException();

		//indicates that keyIn in found and returns the value associated
		else if (key.compareTo(keyIn) == 0)
			return value;

		//indicates the keyIn, if present, must be in left subtree
		else if (key.compareTo(keyIn) > 0)
			return left.getValueForKey(keyIn);

		//indicates the keyIn, if present, must be in right subtree
		else 
			return right.getValueForKey(keyIn);
	}

	/*
	 * Returns the depth of the key: keyIn in the current tree.
	 * Returns -1 if key: keyIn isn't present in the tree.
	 */
	public int depthOfKey(K keyIn) {
		
		//checks to see if the argument is null
		if (keyIn == null)
			throw new IllegalArgumentException();

		//indicates that keyIn in found and returns 0 without looking 
		//any further in the tree
		else if (key.compareTo(keyIn) == 0)
			return 0;

		//indicates keyIn, if present, must be in left subtree increasing
		//the depth by 1 and starts looking for it in left subtree.
		else if (key.compareTo(keyIn) > 0)
			return (left.depthOfKey(keyIn) > -1 ? left.depthOfKey(keyIn) + 1 : -1);

		//indicates keyIn, if present, must be in right subtree increasing
		//the depth by 1 and starts looking for it in right subtree.
		else 
			return (right.depthOfKey(keyIn) > -1 ? right.depthOfKey(keyIn) + 1 : -1);
	}

	/*
	 * Returns an identical copy of the current object Tree with the copy 
	 * being independent of original Tree.
	 */
	public Tree<K, V> copyOfTree() {

		NonEmptyTree<K,V> copy = new NonEmptyTree<K, V>(key, value);
		copy.left = left.copyOfTree();
		copy.right = right.copyOfTree();
		return copy;
	}

	/*
	 * Returns a reference to the largest key in the current object Tree.
	 * Throws an EmptyTreeException if called on an EmptyTree.
	 */
	public K max() throws EmptyTreeException {
		
		//the maximum value in a BST in present in the right-most subtree 
		try {
			return right.max();
		}
		
		//Exception being caught indicates we reached an EmptyTree 
		//so returns the right-most key before the exception
		catch (EmptyTreeException exp) {
			return key;
		}
	}

	/*
	 * Returns a reference to the smallest key in the current object Tree.
	 * Throws an EmptyTreeException if called on an EmptyTree.
	 */
	public K min() throws EmptyTreeException {

		//the minimum value in a BST in present in the left-most subtree 
		try {
			return left.min();
		}
		
		//Exception being caught indicates we reached an EmptyTree 
		//so returns the left-most key before the exception
		catch (EmptyTreeException exp) {
			return key;
		}
	}

	/*
	 * Deletes the key and its associated value with the key: keyIn from 
	 * the current object tree by replacing it with either the largest key
	 * and its associated value pair in the left subtree or the smallest key
	 * and its associated value in the right subtree and then removing that
	 * from the tree. 
	 * Returns a reference to the modified object Tree.
	 */
	public Tree<K, V> deleteKeyValuePair(K keyIn) {
		
		//checks if the argument is null
		if (keyIn == null)
			throw new IllegalArgumentException();
		
		//Indicates that keyIn is found in the current tree so it tries
		//to replace it with the largest key in the left subtree
		else if (key.compareTo(keyIn) == 0) {
			
			try {
				key = left.max();
				value = left.getValueForKey(key);
				left = left.deleteKeyValuePair(key);
			}
			
			//Exception being caught here indicates the current tree
			//doesn't have any left subtree so it tries to replace the 
			//current tree with the smallest key in its right subtree
			catch (EmptyTreeException exp) {
				
				try {
					key = right.min();
					value = right.getValueForKey(key);
					right = right.deleteKeyValuePair(key);
				} 
				
				//Exception being caught here indicates the current
				//tree doesn't have any left or right subtrees so it
				//just replaces it with an EmptyTree
				catch (EmptyTreeException e) {
					return EmptyTree.getInstance();
				}
			}
			
		}
		
		//Indicates that keyIn, if present, must be in left subtree 
		//so recursively calls this method on the left subtree
		else if (key.compareTo(keyIn) > 0)
			left = left.deleteKeyValuePair(keyIn);

		//Indicates that keyIn, if present, must be in right subtree 
		//so recursively calls this method on the right subtree
		else 
			right = right.deleteKeyValuePair(keyIn); 

		return this;
		
	}

	/*
	 * Returns a String representation of the current object tree
	 * in the following format:
	 * "key->value_" where '_' represents a space and all the key/value
	 */
	public String toString() {
		return left.toString() + key + "->" + value + " " + right.toString();
	}

}
