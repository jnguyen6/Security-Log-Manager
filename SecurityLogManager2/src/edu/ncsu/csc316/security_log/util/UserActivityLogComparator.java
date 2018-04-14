package edu.ncsu.csc316.security_log.util;

import java.util.Comparator;

import edu.ncsu.csc316.security_log.data.LogEntry;

/**
 * Class that compares two log entries based on the action performed and the 
 * resource accessed. This comparator class is reused from the UserActivityLogComparator
 * class from CSC316 project 1.
 * 
 * @author Jimmy Nguyen
 */
public class UserActivityLogComparator implements Comparator<LogEntry> {

	/**
	 * Compares two log entries based on the user actions performed and the resources 
	 * that were accessed. If the user actions are the same, then the resources are compared.
	 * Returns a negative number if the first user action and/or resource is alphabetically
	 * before the second user action and/or resource, 0 if both actions and/or resources are
	 * the same, or a positive number if the first user action and/or resource is alphabetically
	 * after the second user action and/or resource.
	 * 
	 * @param thisEntry the first log entry used for comparison
	 * @param otherEntry the second log entry used for comparison
	 * @return a negative number, 0, or a positive number if the first user action/resource is before,
	 * equal to, or after the second user action/resource
	 */
	@Override
	public int compare(LogEntry thisEntry, LogEntry otherEntry) {
		if (thisEntry.getAction().compareTo(otherEntry.getAction()) == 0) {
			return thisEntry.getResource().compareTo(otherEntry.getResource());
		}
		return thisEntry.getAction().compareTo(otherEntry.getAction());
	}

	
}
