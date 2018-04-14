package edu.ncsu.csc316.security_log.util;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.security_log.data.LogEntry;

/**
 * Tests the UserActivityLogComparator class. This test class is reused
 * from the UserActivityLogComparatorTest class from CSC316 project 1.
 * 
 * @author Jimmy Nguyen
 */
public class UserActivityLogComparatorTest {

	/**
	 * Tests the compare() method.
	 */
	@Test
	public void testCompare() {
		LogEntry l = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "view", "medical history");
		LogEntry l1 = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "view", "medical history");    //same log entry
		LogEntry l2 = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "delete", "medical history");  //diff action
		LogEntry l3 = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "view", "immunization records"); //diff resource
		
		LogEntry l4 = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "update", "ICD-9 Code 900");
		LogEntry l5 = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "disable", "system alert CA02513");
		
		UserActivityLogComparator ualc = new UserActivityLogComparator();
		assertTrue(ualc.compare(l, l1) == 0);
		assertTrue(ualc.compare(l, l2) > 0);
		assertTrue(ualc.compare(l2, l) < 0);
		assertTrue(ualc.compare(l, l3) > 0);
		assertTrue(ualc.compare(l3, l) < 0);
		
		assertTrue(ualc.compare(l4, l5) > 0);
		assertTrue(ualc.compare(l5, l4) < 0);
	}

}