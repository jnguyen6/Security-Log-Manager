package edu.ncsu.csc316.security_log.manager;

import edu.ncsu.csc316.security_log.data.LogEntry;
import edu.ncsu.csc316.security_log.dictionary.Dictionary;
import edu.ncsu.csc316.security_log.dictionary.List;

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
	    // TODO: Add your code here
	}
	
	/**
	 * Produces an operational profile of user activity
	 * performed between the given start and end dates (inclusive)
	 * 
	 * @param start - the start date in the format "MM/DD/YYYY HH:MM:SSXM"
	 * @param end - the end date in the format "MM/DD/YYYY HH:MM:SSXM"
	 * @return a string representing the operational profile
	 */
	public String generateOperationalProfile(String start, String end)
	{
	    return null;
	}
	
	/**
	 * Produces a list of log entries for a given 
	 * user. The output list is sorted chronologically.
	 * 
	 * @param username - the user for which to generate a report
	 * @return a string representing the user report
	 */
	public String getUserReport(String username)
	{
	    return null;
	}
}
