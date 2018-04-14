package edu.ncsu.csc316.security_log.dictionary;

/**
 * Interface class that extends from the Dictionary interface class.
 * Represents the List abstract data type. This class is reused from
 * the List interface class from the previous three CSC316 projects.
 * 
 * @author Jimmy Nguyen
 * @param <E> the generic element type
 */
public interface List<E> extends Dictionary<E> {

	/**
	 * Removes and returns an element from the list at a specific index.
	 * 
	 * @param index the index to remove the element at
	 * @return the removed element
	 */
	E remove(int index);
	
	/**
	 * Adds an element at a specific index in the list.
	 * 
	 * @param e the element to add to the list
	 * @param index the index to add the element at
	 */
	void add(int index, E e);
	
	/**
	 * Returns the element accessed from the list at a given index.
	 * 
	 * @param index the index to retrieve the element at
	 * @return the element accessed from the list at a given index
	 */
	E get(int index);
	
	/**
	 * Replaces the element in the list with a new element at a specific index. 
	 * Returns the element that was replaced.
	 * 
	 * @param index the index to set the element at
	 * @param e the element to set in the list
	 * @return the element that was replaced
	 */
	E set(int index, E e);
}
