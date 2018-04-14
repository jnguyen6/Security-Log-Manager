package edu.ncsu.csc316.security_log.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import edu.ncsu.csc316.security_log.data.LogEntry;
import edu.ncsu.csc316.security_log.dictionary.ArrayBasedList;

/**
 * Tests the LogEntryReader class. This test class is reused from the
 * LogEntryReaderTest class from CSC316 project 1, with minor updates.
 * 
 * @author Jimmy Nguyen
 */
public class LogEntryReaderTest {

	/** The valid xsmall activity log file used for testing. */
	private final String activityLogTestFileXSmall = "input/activityLog_xsmall.txt";
	/** The valid small activity log file used for testing. */
	private final String activityLogTestFileSmall = "input/activityLog_small.txt";
	
	/**
	 * Tests the readLogEntries() method.
	 * 
	 * @throws FileNotFoundException if there is a problem reading the file
	 */
	@Test
	public void testReadLogEntries() throws FileNotFoundException {
		@SuppressWarnings("unused")
		LogEntryReader lr = new LogEntryReader();
		ArrayBasedList<LogEntry> actualEntries = (ArrayBasedList<LogEntry>) LogEntryReader.readLogEntries(activityLogTestFileXSmall);
		assertEquals(4, actualEntries.size());
		assertEquals("fzalcala", actualEntries.get(0).getUsername());
		assertEquals("fzalcala", actualEntries.get(1).getUsername());
		assertEquals("quhundley", actualEntries.get(2).getUsername());
		assertEquals("jnguyen", actualEntries.get(3).getUsername());
	}

	/**
	 * Tests the writeLogEntries() method.
	 */
	@Test
	public void testWriteLogEntries() {
		try {
			ArrayBasedList<LogEntry> actualEntries = (ArrayBasedList<LogEntry>) LogEntryReader.readLogEntries(activityLogTestFileXSmall);
			LogEntryReader.writeLogEntries("output/actualActivityLog_xsmall.txt", actualEntries);
		} catch (IOException e) {
			fail();
		}
		checkFiles("input/activityLog_xsmall.txt", "output/actualActivityLog_xsmall.txt");
		try {
		    ArrayBasedList<LogEntry> actualEntries2 = (ArrayBasedList<LogEntry>) LogEntryReader.readLogEntries(activityLogTestFileSmall);
		    LogEntryReader.writeLogEntries("output/actualActivityLog_small.txt", actualEntries2);
		} catch (IOException e) {
			fail();
		}
		checkFiles("input/activityLog_small.txt", "output/actualActivityLog_small.txt");
	}
	
	/**
	 * Helper method to compare two files for the same contents. Note that this method 
	 * is referenced from CourseRecordIOTest from the PackScheduler project from CSC216 lab.
	 * 
	 * @param expFile expected output
	 * @param actFile actual output
	 */
	private void checkFiles(String expFile, String actFile) {
		try {
			Scanner expScanner = new Scanner(new File (expFile));
			Scanner actScanner = new Scanner(new File(actFile));
			
			while (expScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}
			
			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}

}
