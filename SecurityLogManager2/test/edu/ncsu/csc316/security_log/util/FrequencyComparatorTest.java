package edu.ncsu.csc316.security_log.util;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

import edu.ncsu.csc316.security_log.data.LogEntry;

/**
 * Tests the FrequencyComparator class. This test class is reused from
 * the FrequencyComparatorTest class from CSC316 project 1.
 * 
 * @author Jimmy Nguyen
 */
public class FrequencyComparatorTest {

	/**
	 * Tests the compare() method.
	 */
	@Test
	public void testCompare() {
		LogEntry l = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "view", "medical history");
		LogEntry l1 = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "view", "medical history"); 
		LogEntry l2 = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "delete", "medical history"); 
		LogEntry l3 = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "view", "immunization records");
		assertEquals(1, l.getFrequency());
		assertEquals(1, l1.getFrequency());
		assertEquals(1, l2.getFrequency());
		assertEquals(1, l3.getFrequency());
		
		l.incrementFrequency();
		assertEquals(2, l.getFrequency());
		
		Comparator<LogEntry> fc = new FrequencyComparator();
		assertTrue(fc.compare(l, l2) < 0);      //l has greater frequency
		assertTrue(fc.compare(l3, l) > 0);
		assertTrue(fc.compare(l2, l3) < 0);
		assertTrue(fc.compare(l3, l2) > 0);
	}

}
