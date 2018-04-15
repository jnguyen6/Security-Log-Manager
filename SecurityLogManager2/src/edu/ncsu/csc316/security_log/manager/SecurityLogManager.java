package edu.ncsu.csc316.security_log.manager;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.Comparator;

import edu.ncsu.csc316.security_log.data.LogEntry;
import edu.ncsu.csc316.security_log.data.Timestamp;
import edu.ncsu.csc316.security_log.dictionary.ArrayBasedList;
import edu.ncsu.csc316.security_log.dictionary.Dictionary;
import edu.ncsu.csc316.security_log.dictionary.HashTable;
import edu.ncsu.csc316.security_log.dictionary.List;
import edu.ncsu.csc316.security_log.io.LogEntryReader;
import edu.ncsu.csc316.security_log.util.FrequencyComparator;
import edu.ncsu.csc316.security_log.util.Sorter;
import edu.ncsu.csc316.security_log.util.TimestampComparator;

/**
 * Class that allows the user to either generate an operational file
 * on log entries or create a user report for a specific user based
 * on log entries.
 * 
 * @author Jimmy Nguyen
 */
public class SecurityLogManager {
	
	/** The dictionary of log entries. */
	private Dictionary<LogEntry> logDictionary;
	/** The list of all log entries from the log entry file. */
	private List<LogEntry> logList;

	/**
	 * Constructs a new SecurityLogManager given
	 * the path to the input user activity log file.
	 * 
	 * @param filePath - the path to the user activity log file
	 */
	public SecurityLogManager(String filePath)
	{
		try {
			logList = LogEntryReader.readLogEntries(filePath);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("There was a problem reading the input file."
					+ " Quitting program.");
		}
	}
	
	/**
	 * Produces an operational profile of user activity
	 * performed between the given start and end dates (inclusive)
	 * 
	 * @param start - the start date in the format "MM/DD/YYYY HH:MM:SSXM"
	 * @param end - the end date in the format "MM/DD/YYYY HH:MM:SSXM"
	 * @return a string representing the operational profile
	 */
	public String generateOperationalProfile(String start, String end) {
		logDictionary = new HashTable<LogEntry>();
		Timestamp ts = new Timestamp(start.substring(0, 10), start.substring(11, 21));
		Timestamp ts2 = new Timestamp(end.substring(0, 10), end.substring(11, 21));
		ArrayBasedList<LogEntry> uniqueEntriesL = new ArrayBasedList<LogEntry>();
		for (int i = 0; i < logList.size(); i++) {
			if (logList.get(i).getTimestamp().compareTo(ts) >= 0 && logList.get(i).getTimestamp().compareTo(ts2) <= 0) {
				LogEntry e = logDictionary.lookUp(logList.get(i));
				if (e == null) {
					logDictionary.insert(logList.get(i));
					uniqueEntriesL.insert(logList.get(i));
				} else {
					e.incrementFrequency();
				}
			}
		}
		if (uniqueEntriesL.size() == 0) {
			return "No activity was recorded.";
		}
		LogEntry[] uniqueEntriesA = new LogEntry[uniqueEntriesL.size()];
		for (int i = 0; i < uniqueEntriesA.length; i++) {
			uniqueEntriesA[i] = uniqueEntriesL.get(i);
		}
		uniqueEntriesL = null;
		Comparator<LogEntry> fc = new FrequencyComparator();
		Sorter.mergeSort(uniqueEntriesA, fc);
		StringBuilder sb = new StringBuilder();
		sb.append("OperationalProfile[\n");
		int totalFrequency = getTotalFrequency(uniqueEntriesA);
		for (int i = 0; i < uniqueEntriesA.length; i++) {
			double percentage = Math.round(1.0 * uniqueEntriesA[i].getFrequency() / totalFrequency * 1000) / 10.0;
			sb.append("   " + uniqueEntriesA[i].getAction() + " " + uniqueEntriesA[i].getResource()
					+ ": frequency: " + uniqueEntriesA[i].getFrequency() + ", percentage: " + percentage + "%\n");
		}
		sb.append("]");
	    return sb.toString();
	}
	
	/**
	 * Produces a list of log entries for a given 
	 * user. The output list is sorted chronologically.
	 * 
	 * @param username - the user for which to generate a report
	 * @return a string representing the user report
	 */
	public String getUserReport(String username) {
		ArrayBasedList<LogEntry> entries = new ArrayBasedList<LogEntry>();
		for (int i = 0; i < logList.size(); i++) {
			if (logList.get(i).getUsername().equals(username)) {
				entries.insert(logList.get(i));
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("Activity Report for " + username + "[\n");
		if (entries.size() == 0) {
			sb.append("   No activity was recorded.\n]");
			return sb.toString();
		}
		LogEntry[] entriesWithUser = new LogEntry[entries.size()];
		for (int i = 0; i < entries.size(); i++) {
			entriesWithUser[i] = entries.get(i);
		}
		entries = null;
		Comparator<LogEntry> tsc = new TimestampComparator();
		Sorter.mergeSort(entriesWithUser, tsc);
		for (int i = 0; i < entriesWithUser.length; i++) {
			sb.append("   " + entriesWithUser[i].getTimestamp().toString() + " - " + entriesWithUser[i].getAction()
					+ " " + entriesWithUser[i].getResource() + "\n");
		}
		sb.append("]");
	    return sb.toString();
	}
	
	/**
	 * Returns the total frequency of log entries that appear in a given
	 * list of entries.
	 * 
	 * @param entries the list of log entries to process
	 * @return the total frequency of log entries from the given list
	 * of entries
	 */
	public int getTotalFrequency(LogEntry[] entries) {
		int totalFrequency = 0;
		for (int i = 0; i < entries.length; i++) {
			totalFrequency += entries[i].getFrequency();
		}
		return totalFrequency;
	}
}
