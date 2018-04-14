package edu.ncsu.csc316.security_log.data;

/**
 * Interface class that provides methods for retrieving and 
 * incrementing the frequency of occurrence of an object 
 * 
 * @author Jimmy Nguyen
 */
public interface FrequencyCounter {

	/**
	 * Returns the frequency of occurrence of an object.
	 * 
	 * @return the frequency of occurrence of an object
	 */
	int getFrequency();
	
	/**
	 * Increments the frequency of occurrence of an object
	 * by one
	 */
	void incrementFrequency();
}
