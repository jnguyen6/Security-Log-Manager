 package edu.ncsu.csc316.security_log.data;

/**
 * Class that stores the username, timestamp, action, and resource
 * from a log entry. The class also keeps track of the number of log
 * entries that are the same. This class is reused from the LogEntry
 * class from CSC316 project 1, with minor updates.
 * 
 * @author Jimmy Nguyen
 */
public class LogEntry implements FrequencyCounter {

	/** The name of the user from the log entry. */
	private String username;
	/** The time the log entry was recorded. */
	private Timestamp timestamp;
	/** The action performed by the user. */
	private String action;
	/** The resource used by the user. */
	private String resource;
	/** The number of log entries that are the same. */
	private int frequency;
	
	/**
	 * Constructor that initializes the username, timestamp, action,
	 * and resource fields to the values passed as parameters. Also
	 * initializes the frequency field to 1.
	 * 
	 * @param username the name of the user
	 * @param timestamp the time and date the log entry was recorded
	 * @param action the action performed by the user
	 * @param resource the resource used by the user
	 */
	public LogEntry(String username, String timestamp, String action, String resource) {
		setUsername(username);
		setTimestamp(timestamp);
		setAction(action);
		setResource(resource);
		frequency = 1;
	}
	
	/**
	 * Returns the name of the user.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets the name of the user from the log entry. Throws an IllegalArgumentException
	 * if the given username is null or has a length less than 3.
	 *
	 * @param username the username to set
	 * @throws IllegalArgumentException if the given username is null or has a length less
	 * than 3
	 */
	public void setUsername(String username) {
		if (username == null || username.length() < 3) {
			throw new IllegalArgumentException("The username " + username + " is not valid. "
					+ "Quitting program.");
		}
		this.username = username;
	}
	
	/**
	 * Returns the time stamp of the log entry.
	 * 
	 * @return the time stamp of the log entry
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	/**
	 * Sets the time and date the user activity log was recorded.
	 * 
	 * @param timestamp the time and date the user activity log was recorded
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = new Timestamp(timestamp.substring(0, 10), timestamp.substring(11, 21));
	}
	
	/**
	 * Returns the action performed by the user.
	 * 
	 * @return the user action
	 */
	public String getAction() {
		return action;
	}
	
	/**
	 * Sets the action performed by the user. Throws an IllegalArgumentException if
	 * the given action is null or an empty String.
	 * 
	 * @param action the action performed by the user
	 * @throws IllegalArgumentException if the given action is null or an empty String
	 */
	public void setAction(String action) {
		if (action == null || action.length() == 0) {
			throw new IllegalArgumentException("The action " + action + " is invalid. "
					+ "Quitting program.");
		}
		this.action = action;
	}
	
	/**
	 * Returns the resource used by the user.
	 * 
	 * @return the resource used by the user
	 */
	public String getResource() {
		return resource;
	}
	
	/**
	 * Sets the resource used by the user. Throws an IllegalArgumentException if
	 * the given resource is null or an empty String.
	 * 
	 * @param resource the resource used by the user
	 * @throws IllegalArgumentException if the given resource is null or an empty String
	 */
	public void setResource(String resource) {
		if (resource == null || resource.length() == 0) {
			throw new IllegalArgumentException("The resource " + resource + " is invalid. "
					+ "Quitting program.");
		}
		this.resource = resource;
	}
	
	/**
	 * Returns the number of user activity logs that have the same user
	 * action and resource.
	 * 
	 * @return the number of user activity logs that have the same user
	 * action and resource
	 */
	public int getFrequency() {
		return frequency;
	}
	
	/**
	 * Increases the number by 1 for each user activity log found to have the
	 * same user action and resource.
	 */
	public void incrementFrequency() {
		frequency++;
	}
	
	/**
	 * Creates and returns a String representation of a log entry, 
	 * which consists of the username, timestamp, action, and resource.
	 * 
	 * @return the String representation of a log entry
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getUsername());
		sb.append(", ");
		sb.append(getTimestamp().toString());
		sb.append(", ");
		sb.append(getAction());
		sb.append(", ");
		sb.append(getResource());
		return sb.toString();
	}
	
	/**
	 * Calculates and returns the hash code of the LogEntry object. This
	 * hash code is the action and resource of the LogEntry object, which
	 * specifically serves as the key value for a hash table. The hashing
	 * function that is used to create this specific hash code is cyclic-
	 * shift hashing. The cyclic-shift hashing function is referenced from
	 * the Hash Tables: Hash Functions lecture slides on page 27 provided
	 * by Jason King.
	 * 
	 * @return the hash code of the LogEntry object, which consists of the
	 * action and resource
	 */
	@Override
	public int hashCode() {
		int result = 0;
		String s = getAction() + " " + getResource();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			result = (result << 5) | (result >>> 27);
			result += s.charAt(i);
		}
		return result;
	}

	/**
	 * Compares two LogEntry objects to determine if both of them are 
	 * equal on all fields.
	 * 
	 * @param obj the LogEntry object used for comparison
	 * @return true if the two LogEntry objects are equal or false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogEntry other = (LogEntry) obj;
		if (!action.equals(other.action))
			return false;
		if (frequency != other.frequency)
			return false;
		if (!resource.equals(other.resource))
			return false;
	    if (!timestamp.equals(other.timestamp))
			return false;
	    if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
