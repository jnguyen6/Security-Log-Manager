package edu.ncsu.csc316.security_log.util;
import java.util.Comparator;

import edu.ncsu.csc316.security_log.data.LogEntry;


/**
 * Class that compares two different log entries based on the frequency of
 * each log entry. Specifically, the two entries are compared for how often
 * the same user action and resource appear in each entry. This comparator
 * class is reused from the FrequencyComparator class from CSC316 project 1.
 * 
 * @author Jimmy Nguyen
 */
public class FrequencyComparator implements Comparator<LogEntry> {

	/**
	 * Compares the number of log entries that had the same occurrence of user
	 * action and resource for the two different log entries. If the frequency of
	 * occurrence for the first log entry is less than the frequency of occurrence
	 * for the second entry, then a positive number is returned. If the frequency of
	 * occurrence for the first log entry is greater than the frequency of occurrence
	 * for the second entry, then a negative number is returned. If both frequencies
	 * are the same, then 0 is returned.
	 * 
	 * @param thisEntry the first entry used for comparison
	 * @param otherEntry the second entry used for comparison
	 * @return a positive number, 0, or a negative number if the frequency of the first
	 * log entry is less than, equal to, or greater than the frequency of the second entry
	 */
	@Override
	public int compare(LogEntry thisEntry, LogEntry otherEntry) {
		if (otherEntry.getFrequency() - thisEntry.getFrequency() == 0) {
			Comparator<LogEntry> ualc = new UserActivityLogComparator();
			return ualc.compare(thisEntry, otherEntry);
		}
		return otherEntry.getFrequency() - thisEntry.getFrequency();
	}

	
}
