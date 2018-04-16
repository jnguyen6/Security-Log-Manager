package edu.ncsu.csc316.security_log.dictionary;

import edu.ncsu.csc316.security_log.data.LogEntry;

/**
 * Class that represents a hash table used as a data structure.
 * 
 * @author Jimmy Nguyen
 * @param <E> the generic element type
 */
public class HashTable<E> implements Dictionary<E> {

	/** The initial size of the hash table. */
	private static final int INIT_SIZE = 17;
	/** The golden ratio value used by the compression function. */
	private static final double GOLDEN_RATIO = ((1 + Math.sqrt(5)) / 2) - 1;
	/** The threshold value that the load factor is expected to be within. */
	private static final double THRESHOLD_VAL = 0.75;
	/** The collection of buckets that contains elements and corresponding key values. */
	private ArrayBasedList<Node> buckets;
	/** The number of values stored in the hash table. */
	private int size;
	/** The number of buckets currently allocated in the hash table. */
	private int capacity;
	
	
	/**
	 * Constructs a new generic HashTable with
	 * some initial default capacity
	 */
	public HashTable() {
		buckets = new ArrayBasedList<Node>(INIT_SIZE);
		size = 0;
		capacity = INIT_SIZE;
	}
	
	/**
	 * Inserts the generic value E into the hash table.
	 *
	 * @param value - the value to insert into the hash table
	 */
	public void insert(E value) {
		//If the load factor exceeds 0.75, the threshold, then resize
		if (size * 1.0 / (capacity * 1.0) > THRESHOLD_VAL) {
			resize();
		}
		int hashcode = value.hashCode();
	    int index = compress(hashcode);
	    if (buckets.get(index) != null) {
	    	    Node n = new Node(value, hashcode, buckets.get(index));
	    	    buckets.set(index, n);
	    } else {
	    	    Node n = new Node(value, hashcode);
	    	    buckets.set(index, n);
	    }
	    size++;
	}
	
	/**
	 * An algorithm that creates an index to store the element in the
	 * hash table using the golden ratio compression method.
	 * 
	 * @param hashcode the hash code value to compress
	 * @return the index to add the element at as a result of the compression
	 */
	protected int compress(int hashcode) {
		int index = (int) Math.floor(capacity * (hashcode * GOLDEN_RATIO - Math.floor(hashcode * GOLDEN_RATIO)));
		return index;
	}
	
	/**
	 * Creates a new array of buckets for the hash table with increased capacity
	 * and then rehash the previous values from the original array to the new
	 * array. This resize algorithm is referenced from the Hash Tables: Collision
	 * Resolution lecture slides from page 17 provided by Jason King.
	 */
	protected void resize() {
		int originalLen = capacity;
		capacity = capacity * 2 + 1;
		ArrayBasedList<Node> newBuckets = new ArrayBasedList<Node>(capacity);
		int num = 0;
		for (int i = 0; i < originalLen; i++) {
			if (num == size) {
				break;
			}
			if (buckets.get(i) != null) {
				int index = compress(buckets.get(i).key);
				Node n = null;
				if (newBuckets.get(index) != null) {
					n = new Node(buckets.get(i).data, buckets.get(i).key, newBuckets.get(index));
				} else {
				    n = new Node(buckets.get(i).data, buckets.get(i).key);
				}
				newBuckets.set(index, n);
				num++;
				Node current = buckets.get(i).next;
				while (current != null) {
					index = compress(current.key);
					if (newBuckets.get(index) != null) {
						n = new Node(current.data, current.key, newBuckets.get(index));
					} else {
						n = new Node(current.data, current.key);
					}
					newBuckets.set(index, n);
					num++;
					current = current.next;
				}
			}
		}
		buckets = null;
		buckets = newBuckets;
	}
	
	/**
	 * Finds the value E in the hash table. Returns the value E
	 * if the value was found in the hash table. If the value is
	 * not in the hash table, return null.
	 *
	 * @param value - the value to search for in the hash table
	 * @return the reference to the value in the hash table, or null if the value 
	 *              is not in the hash table
	 */
	public E lookUp(E value) {
		int index = compress(value.hashCode());
		Node current = buckets.get(index);
		while (current != null) {
			if (current.data instanceof LogEntry) {
				if (((LogEntry) current.data).getAction().equals(((LogEntry) value).getAction())
						&& ((LogEntry) current.data).getResource().equals(((LogEntry) value).getResource())) {
					return current.data;
				}
			} else {
			    if (current.data.equals(value)) {
				    return current.data;
			    }
			}
			current = current.next;
		}
		return null;
	}
	
	/**
	 * Returns the number of values in the hash table
	 * 
	 * @return the number of values in the hash table
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Returns the length/capacity of the hash table
	 * 
	 * @return the length/capacity of the hash table
	 */
	public int getHashTableLength() {
	    return capacity;
	}
	
	/**
	 * The inner class of the HashTable class that stores an element in
	 * a node and a reference to the next node. This class is reused from
	 * the Node inner class from CSC316 project 1, with minor updates. This
	 * class is used to represent a bucket, and in case of collisions, this
	 * class helps maintain a collection of elements and keys through separate
	 * chaining.
	 * 
	 * @author Jimmy Nguyen
	 */
	private class Node {
		
		/** The element stored in the node. */
		public E data;
		/** The key stored in the node. */
		public int key;
		/** The reference to the next node in the list. */
		public Node next;
		
		/**
		 * Constructor that creates an instance of a Node, initializes the data and
		 * key fields to the given parameter values, and initializes the next field to 
		 * null.
		 * 
		 * @param data the element to set to the node
		 * @param key the key value to set to the node
		 */
		public Node(E data, int key) {
			this(data, key, null);
		}
		
		/**
		 * Constructor that creates an instance of a Node and initializes the
		 * data, key, and next fields to the given parameter values.
		 * 
		 * @param data the element to set to the node
		 * @param key the key value to set to the node
		 * @param next the next node reference to set
		 */
		public Node(E data, int key, Node next) {
			this.data = data;
			this.key = key;
			this.next = next;
		}
	}

}
