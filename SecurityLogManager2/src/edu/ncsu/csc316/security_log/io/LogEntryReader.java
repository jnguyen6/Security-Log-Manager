package edu.ncsu.csc316.security_log.io;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import edu.ncsu.csc316.security_log.data.LogEntry;
import edu.ncsu.csc316.security_log.dictionary.List;
import edu.ncsu.csc316.security_log.dictionary.ArrayBasedList;

/**
 * Class that reads input from the user activity log file. This class is
 * reused from the LogEntryReader class from CSC316 project 1, with some
 * modifications to the readLogEntries method.
 * 
 * @author Jimmy Nguyen
 */
public class LogEntryReader {

	/**
	 * Reads each user activity log from the input file and adds each log 
	 * to the list of log entries. Returns an unsorted list of log entries. 
	 * This method will be used under the assumption that the file provided 
	 * is correctly formated.
	 * 
	 * @param file the input file containing log entry information to read
	 * @return the unsorted list of log entries
	 * @throws FileNotFoundException if a problem occurred when processing the file
	 */
	public static List<LogEntry> readLogEntries(String file) throws FileNotFoundException {
		Scanner fileScanner = new Scanner(new FileInputStream(file));
		ArrayBasedList<LogEntry> entries = new ArrayBasedList<LogEntry>();
		fileScanner.nextLine(); //discard header
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			Scanner lineScanner = new Scanner(line);
			lineScanner.useDelimiter(", ");
			LogEntry entry = new LogEntry(lineScanner.next(), lineScanner.next(), lineScanner.next(), 
											lineScanner.next());
			entries.insert(entry);
			lineScanner.close();
		}
		fileScanner.close();
		return entries;
	}
	
	/**
	 * Writes the given list of log entries to a file. If there is a problem
	 * with writing to the file, then an IOException is thrown. Note that the
	 * method was referenced from the CourseRecordsIO class from the PackScheduler
	 * project from CSC216 lab.
	 * 
	 * @param fileName the file to write the log entries in
	 * @param entries the list of log entries
	 * @throws IOException if there is a problem writing to the file
	 */
	public static void writeLogEntries(String fileName, ArrayBasedList<LogEntry> entries) throws IOException {
		PrintStream fileWriter = new PrintStream(new File(fileName));
		fileWriter.println("USERNAME, TIMESTAMP, ACTION, RESOURCE");
		for (int i = 0; i < entries.size(); i++) {
			fileWriter.println(entries.get(i).toString());
		}
		fileWriter.close();
	}
 }
