package edu.ncsu.csc316.security_log.data;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the LogEntry class.This class is reused from the
 * LogEntryTest class from CSC316 project 1, with updates
 * that pertains to removing Timestamp tests.
 * 
 * @author Jimmy Nguyen
 */
public class LogEntryTest {

	/**
	 * Tests the LogEntry constructor.
	 */
	@Test
	public void testLogEntry() {
		LogEntry l = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "view", "medical history");
		assertTrue(l instanceof LogEntry);
		assertEquals("jnguyen", l.getUsername());
		assertEquals("01", l.getTimestamp().getMonth());
		assertEquals("31", l.getTimestamp().getDay());
		assertEquals("2018", l.getTimestamp().getYear());
		assertEquals("02", l.getTimestamp().getHour());
		assertEquals("58", l.getTimestamp().getMinutes());
		assertEquals("00PM", l.getTimestamp().getSecondsXM());
		assertEquals("view", l.getAction());
		assertEquals("medical history", l.getResource());
	}

	/**
	 * Tests the setUsername() method.
	 */
	@Test
	public void testSetUsername() {
		LogEntry l = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "view", "medical history");
		assertEquals("jnguyen", l.getUsername());
		try {
			l.setUsername(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("The username null is not valid. Quitting program.", e.getMessage());
			assertEquals("jnguyen", l.getUsername());
		}
		try {
			l.setUsername("jm");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("The username jm is not valid. Quitting program.", e.getMessage());
			assertEquals("jnguyen", l.getUsername());
		}
		l.setUsername("james");
		assertEquals("james", l.getUsername());
	}

	/**
	 * Tests the setTimestamp() method.
	 */
	@Test
	public void testSetTimestamp() {
		LogEntry l = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "view", "medical history");
		assertEquals("01", l.getTimestamp().getMonth());
		assertEquals("31", l.getTimestamp().getDay());
		assertEquals("2018", l.getTimestamp().getYear());
		assertEquals("02", l.getTimestamp().getHour());
		assertEquals("58", l.getTimestamp().getMinutes());
		assertEquals("00PM", l.getTimestamp().getSecondsXM());
		l.setTimestamp("12/04/1997 01:23:45AM");
		assertEquals("12", l.getTimestamp().getMonth());
		assertEquals("04", l.getTimestamp().getDay());
		assertEquals("1997", l.getTimestamp().getYear());
		assertEquals("01", l.getTimestamp().getHour());
		assertEquals("23", l.getTimestamp().getMinutes());
		assertEquals("45AM", l.getTimestamp().getSecondsXM());
	}

	/**
	 * Tests the setAction() method.
	 */
	@Test
	public void testSetAction() {
		LogEntry l = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "view", "medical history");
		assertEquals("view", l.getAction());
		try {
			l.setAction(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("The action null is invalid. Quitting program.", e.getMessage());
			assertEquals("view", l.getAction());
		}
		try {
			l.setAction("");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("The action  is invalid. Quitting program.", e.getMessage());
			assertEquals("view", l.getAction());
		}
		l.setAction("delete");
		assertEquals("delete", l.getAction());
	}

	/**
	 * Tests the setResource() method.
	 */
	@Test
	public void testSetResource() {
		LogEntry l = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "view", "medical history");
		assertEquals("medical history", l.getResource());
		try {
			l.setResource(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("The resource null is invalid. Quitting program.", e.getMessage());
			assertEquals("medical history", l.getResource());
		}
		try {
			l.setResource("");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("The resource  is invalid. Quitting program.", e.getMessage());
			assertEquals("medical history", l.getResource());
		}
		l.setResource("immunization records");
		assertEquals("immunization records", l.getResource());
	}
	
	/**
	 * Tests the toString() method.
	 */
	@Test
	public void testToString() {
		LogEntry l = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "view", "medical history");
		String expected = "jnguyen, 01/31/2018 02:58:00PM, view, medical history";
		assertEquals(expected, l.toString());
	}
	
	/**
	 * Tests the hashCode() method.
	 */
	@Test
	public void testHashCode() {
		LogEntry l = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "view", "medical history");
		LogEntry l2 = new LogEntry("jnguyen", "02/28/2018 12:45:27AM", "view", "medical history");
		LogEntry l3 = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "delete", "medical history");
		LogEntry l4 = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "view", "immunization records");
		LogEntry l5 = new LogEntry("james", "01/31/2018 02:58:00PM", "view", "medical history");
		
		assertTrue(l.hashCode() == l.hashCode());
		assertTrue(l.hashCode() == l2.hashCode());
		assertFalse(l.hashCode() == l3.hashCode());
		assertFalse(l.hashCode() == l4.hashCode());
		assertTrue(l.hashCode() == l5.hashCode());
	}
	
	/**
	 * Tests the equals() method.
	 */
	@Test
	public void testEqualsObject() {
		LogEntry l = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "view", "medical history");
		LogEntry l2 = new LogEntry("jnguyen", "02/28/2018 12:45:27AM", "view", "medical history");
		LogEntry l3 = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "delete", "medical history");
		LogEntry l4 = new LogEntry("jnguyen", "01/31/2018 02:58:00PM", "view", "immunization records");
		LogEntry l5 = new LogEntry("james", "01/31/2018 02:58:00PM", "view", "medical history");
		assertTrue(l.equals(l));
		assertFalse(l.equals(l2));
		assertFalse(l.equals(l3));
		assertFalse(l.equals(l4));
		assertFalse(l.equals(l5));
		assertFalse(l2.equals(l3));
		assertFalse(l2.equals(l4));
		assertFalse(l2.equals(l5));
		assertFalse(l3.equals(l4));
		assertFalse(l3.equals(l5));
		assertFalse(l4.equals(l5));
	}

}
