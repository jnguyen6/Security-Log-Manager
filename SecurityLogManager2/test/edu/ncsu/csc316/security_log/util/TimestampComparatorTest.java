package edu.ncsu.csc316.security_log.util;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.security_log.data.LogEntry;

/**
 * Tests the TimestampComparator class, specifically the compare method.
 * This test class is reused from the TimestampComparatorTest class from
 * CSC316 project 1.
 * 
 * @author Jimmy Nguyen
 */
public class TimestampComparatorTest {

	/**
	 * Tests the compare() method.
	 */
	@Test
	public void testCompare() {
		LogEntry l = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "view", "medical history");
		LogEntry l2 = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "view", "medical history");   //same date and time
		LogEntry l3 = new LogEntry("jnguyen", "02/31/2018 02:58:00PM", "view", "medical history");   //later month
		LogEntry l4 = new LogEntry("jnguyen", "01/31/2018 02:58:00AM", "view", "medical history");   //earlier secondsXM by time period (AM/PM)
		LogEntry l5 = new LogEntry("jnguyen", "01/31/2017 02:58:00PM", "view", "medical history");   //earlier year
		LogEntry l6 = new LogEntry("jnguyen", "01/31/2018 02:58:01PM", "view", "medical history");   //later secondsXM by one second
		LogEntry l7 = new LogEntry("jnguyen", "01/31/2018 02:57:59PM", "view", "medical history");   //earlier secondsXM by one second
		LogEntry l8 = new LogEntry("jnguyen", "01/30/2018 02:58:00PM", "view", "medical history");   //earlier day
		LogEntry l9 = new LogEntry("jnguyen", "01/31/2018 01:58:00PM", "view", "medical history");   //earlier hour
		LogEntry l10 = new LogEntry("jnguyen", "01/31/2018 02:57:00PM", "view", "medical history");  //earlier minute
		LogEntry l11 = new LogEntry("jnguyen", "03/19/2016 12:54:12PM", "view", "medical history"); 
		LogEntry l12 = new LogEntry("jnguyen", "03/19/2016 01:45:30PM", "view", "medical history"); 
		
		TimestampComparator tsc = new TimestampComparator();
		assertTrue(tsc.compare(l, l2) == 0);
		
		//Checking for month
		assertTrue(tsc.compare(l, l3) < 0);
		assertTrue(tsc.compare(l3, l) > 0);
		//Checking for day
		assertTrue(tsc.compare(l, l8) > 0);
		assertTrue(tsc.compare(l8, l) < 0);
		//Checking for year
		assertTrue(tsc.compare(l, l5) > 0);
		assertTrue(tsc.compare(l5, l) < 0);
		//Checking for hours
		assertTrue(tsc.compare(l, l9) > 0);
		assertTrue(tsc.compare(l9, l) < 0);
		//Checking for minutes
		assertTrue(tsc.compare(l, l10) > 0);
		assertTrue(tsc.compare(l10, l) < 0);
		//Checking for secondsXM
		assertTrue(tsc.compare(l, l4) > 0);
		assertTrue(tsc.compare(l4, l) < 0);
		assertTrue(tsc.compare(l, l6) < 0);
		assertTrue(tsc.compare(l6, l) > 0);
		assertTrue(tsc.compare(l, l7) > 0);
		assertTrue(tsc.compare(l7, l) < 0);
		
		assertTrue(tsc.compare(l12, l11) > 0);
		assertTrue(tsc.compare(l11, l12) < 0);
		
	}

}
