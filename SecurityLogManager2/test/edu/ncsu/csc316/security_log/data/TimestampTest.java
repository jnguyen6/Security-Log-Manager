package edu.ncsu.csc316.security_log.data;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the Timestamp class.
 * 
 * @author Jimmy Nguyen
 */
public class TimestampTest {

	/**
	 * Tests the Timestamp constructor.
	 */
	@Test
	public void testTimestamp() {
		Timestamp ts = new Timestamp("01/31/2018", "02:58:00PM");
		assertTrue(ts instanceof Timestamp);
		assertEquals("01", ts.getMonth());
		assertEquals("31", ts.getDay());
		assertEquals("2018", ts.getYear());
		assertEquals("02", ts.getHour());
		assertEquals("58", ts.getMinutes());
		assertEquals("00PM", ts.getSecondsXM());
	}

	/**
	 * Tests the setMonth() method.
	 */
	@Test
	public void testSetMonth() {
		Timestamp ts = new Timestamp("01/31/2018", "02:58:00PM");
		assertEquals("01", ts.getMonth());
		ts.setMonth("12");
		assertEquals("12", ts.getMonth());
	}

	/**
	 * Tests the setDay() method.
	 */
	@Test
	public void testSetDay() {
		Timestamp ts = new Timestamp("01/31/2018", "02:58:00PM");
		assertEquals("31", ts.getDay());
		ts.setDay("29");
		assertEquals("29", ts.getDay());
	}

	/**
	 * Tests the setYear() method.
	 */
	@Test
	public void testSetYear() {
		Timestamp ts = new Timestamp("01/31/2018", "02:58:00PM");
		assertEquals("2018", ts.getYear());
		ts.setYear("1997");
		assertEquals("1997", ts.getYear());
	}

	/**
	 * Tests the setHour() method.
	 */
	@Test
	public void testSetHour() {
		Timestamp ts = new Timestamp("01/31/2018", "02:58:00PM");
		assertEquals("02", ts.getHour());
		ts.setHour("12");
		assertEquals("12", ts.getHour());
	}

	/**
	 * Tests the setMinutes() method.
	 */
	@Test
	public void testSetMinutes() {
		Timestamp ts = new Timestamp("01/31/2018", "02:58:00PM");
		assertEquals("58", ts.getMinutes());
		ts.setMinutes("00");
		assertEquals("00", ts.getMinutes());
	}

	/**
	 * Tests the setSecondsXM() method.
	 */
	@Test
	public void testSetSecondsXM() {
		Timestamp ts = new Timestamp("01/31/2018", "02:58:00PM");
		assertEquals("00PM", ts.getSecondsXM());
		ts.setSecondsXM("59AM");
		assertEquals("59AM", ts.getSecondsXM());
	}

	/**
	 * Tests the toString() method.
	 */
	@Test
	public void testToString() {
		Timestamp ts = new Timestamp("01/31/2018", "02:58:00PM");
		assertEquals("01/31/2018 02:58:00PM", ts.toString());
	}

	/**
	 * Tests the equals() method.
	 */
	@Test
	public void testEqualsObject() {
		Timestamp ts = new Timestamp("01/31/2018", "02:58:00PM");
		Timestamp ts2 = new Timestamp("01/30/2018", "02:58:00PM");
		Timestamp ts3 = new Timestamp("01/31/2018", "01:58:00PM");
		Timestamp ts4 = new Timestamp("01/31/2018", "02:57:00PM");
		Timestamp ts5 = new Timestamp("02/31/2018", "02:58:00PM");
		Timestamp ts6 = new Timestamp("01/31/2018", "02:58:01PM");
		Timestamp ts7 = new Timestamp("01/31/2019", "02:58:00PM");
		
		assertTrue(ts.equals(ts));
		assertFalse(ts.equals(ts2));
		assertFalse(ts.equals(ts3));
		assertFalse(ts.equals(ts4));
		assertFalse(ts.equals(ts5));
		assertFalse(ts.equals(ts6));
		assertFalse(ts.equals(ts7));
	}
	
	/**
	 * Tests the hashCode() method.
	 */
	@Test
	public void testHashCode() {
		Timestamp ts = new Timestamp("01/31/2018", "02:58:00PM");
		Timestamp ts2 = new Timestamp("02/28/2018", "12:45:27AM");
		assertFalse(ts.hashCode() == ts2.hashCode());
		assertTrue(ts.hashCode() == ts.hashCode());
	}

}
