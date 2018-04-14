package edu.ncsu.csc316.security_log.util;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

import edu.ncsu.csc316.security_log.data.LogEntry;

/**
 * Tests the Sorter class. This test class is reused from the
 * SorterTest class from CSC316 project 1.
 * 
 * @author Jimmy Nguyen
 */
public class SorterTest {

	/** Expected results for first entry. */
	private final LogEntry firstEntry = new LogEntry("fzalcala", "08/04/2016 06:57:34AM", "resolve", "message M2964");
	/** Expected results for second entry. */
	private final LogEntry secondEntry = new LogEntry("quhundley", "07/18/2015 07:57:42PM", "sort", "ICD-9 Code 196");
	/** Expected results for third entry. */
	private final LogEntry thirdEntry = new LogEntry("quhundley", "08/04/2017 11:01:45AM", "sort", "ICD-9 Code 196");
	/** Expected results for fourth entry. */
	private final LogEntry fourthEntry = new LogEntry("jnguyen", "01/12/2018 01:13:43PM", "view", "medical history");
	/** Expected results for fifth entry. */
	private final LogEntry fifthEntry = new LogEntry("jnguyen", "01/12/2018 01:13:43PM", "view", "immunization records");
	
	/** The list of log entries that will be used for testing. */
	private final LogEntry[] entries = {firstEntry, secondEntry, thirdEntry, fourthEntry, fifthEntry};
	/** The expected sorted list of log entries by timestamp. */
	private final LogEntry[] expectedEntries = {secondEntry, firstEntry, thirdEntry, fifthEntry, fourthEntry};
	/** The expected sorted list of log entries by action + resource. */
	private final LogEntry[] expectedEntries2 = {firstEntry, secondEntry, thirdEntry, fifthEntry, fourthEntry};
	
	/**
	 * Tests the mergeSort algorithm.
	 */
	@Test
	public void testMergeSort() {
		@SuppressWarnings("unused")
		Sorter<LogEntry> s = new Sorter<LogEntry>();
		//First, compare using TimestampComparator
		Comparator<LogEntry> tsc = new TimestampComparator();
		Sorter.mergeSort(entries, tsc);
		assertTrue(expectedEntries[0].equals(entries[0]));
		assertTrue(expectedEntries[1].equals(entries[1]));
		assertTrue(expectedEntries[2].equals(entries[2]));
		assertTrue(expectedEntries[3].equals(entries[3]));
		assertTrue(expectedEntries[4].equals(entries[4]));
		//Now, compare using UserActivityLogComparator
		Comparator<LogEntry> ualc = new UserActivityLogComparator();
		Sorter.mergeSort(entries, ualc);
		assertTrue(expectedEntries2[0].equals(entries[0]));
		assertTrue(expectedEntries2[1].equals(entries[1]));
		assertTrue(expectedEntries2[2].equals(entries[2]));
		assertTrue(expectedEntries2[3].equals(entries[3]));
		assertTrue(expectedEntries2[4].equals(entries[4]));
	}

}
