package edu.ncsu.csc316.security_log.util;

import java.util.Comparator;

import edu.ncsu.csc316.security_log.data.LogEntry;

/**
 * Class that compares two log entries based on their timestamps.
 * This comparator class is reused from the TimestampComparator
 * class from CSC316 project 1.
 * 
 * @author Jimmy Nguyen
 */
public class TimestampComparator implements Comparator<LogEntry> {

	/**
	 * Compares two log entries based on their timestamps. Specifically,
	 * the two log entries are compared based on their chronological order.
	 * Returns a negative number if the first log entry's timestamp is earlier
	 * than the second log entry's timestamp, 0 if both timestamps are the same,
	 * or a positive number if the first log entry's timestamp is later than the 
	 * second log entry's timestamp.
	 * 
	 * @param thisEntry the first log entry used for comparison
	 * @param otherEntry the second log entry used for comparison
	 * @return a negative number, 0, or a positive number if the first timestamp is earlier 
	 * than, equal to, or later than the second timestamp
	 */
	@Override
	public int compare(LogEntry thisEntry, LogEntry otherEntry) {
		if (thisEntry.getTimestamp().compareTo(otherEntry.getTimestamp()) == 0) {
			Comparator<LogEntry> ualc = new UserActivityLogComparator();
			return ualc.compare(thisEntry, otherEntry);
		}
		return thisEntry.getTimestamp().compareTo(otherEntry.getTimestamp());
	}
	

}
