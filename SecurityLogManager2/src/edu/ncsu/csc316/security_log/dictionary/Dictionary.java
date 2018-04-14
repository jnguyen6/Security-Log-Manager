package edu.ncsu.csc316.security_log.dictionary;

/**
 * Interface class that represents the Dictionary abstract data type.
 * This interface class is reused from the other Dictionary interface
 * classes from three previous CSC316 projects.
 * 
 * @author Jimmy Nguyen
 * @param <E> the generic element type
 */
public interface Dictionary<E> {

	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param e the element to add to the list
	 */
	void insert(E e);
	
	/**
	 * Returns the element from the list based on the given key value.
	 * 
	 * @param k the key value to search for
	 * @return the element found or null if the element was not found
	 */
	E lookUp(E k);
	
	/**
	 * Returns the size of the list.
	 * 
	 * @return the size of the list
	 */
	int size();
}
