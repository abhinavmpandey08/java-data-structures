public abstract class Tree<K extends Comparable<K>, V> {

  abstract public NonEmptyTree<K, V> insertKeyValuePair(K keyIn, V valueIn);
  abstract public int size();
  abstract public V getValueForKey(K keyIn);
  abstract public int depthOfKey(K keyIn);
  abstract public Tree<K, V> copyOfTree();
  abstract public K max() throws EmptyTreeException;
  abstract public K min() throws EmptyTreeException;
  abstract public Tree<K, V> deleteKeyValuePair(K keyIn);
}
