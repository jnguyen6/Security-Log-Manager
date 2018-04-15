package edu.ncsu.csc316.security_log.dictionary;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

import edu.ncsu.csc316.security_log.data.LogEntry;
import edu.ncsu.csc316.security_log.util.TimestampComparator;

/**
 * Tests the ArrayBasedList class. This JUnit test class is reused
 * from the ArrayBasedList test class from CSC316 project 1.
 * 
 * @author Jimmy Nguyen
 */
public class ArrayBasedListTest {

	/**
	 * Tests the ArrayBasedList constructor.
	 */
	@Test
	public void testArrayBasedList() {
		ArrayBasedList<String> l = new ArrayBasedList<String>();
		assertTrue(l instanceof ArrayBasedList);
		assertEquals(0, l.size());
	}

	/**
	 * Tests the insert() method.
	 */
	@Test
	public void testInsert() {
		ArrayBasedList<String> l = new ArrayBasedList<String>();
		assertEquals(0, l.size());
		l.insert("apple");
		assertEquals(1, l.size());
		assertEquals("apple", l.get(0));
		l.insert("grape");
		assertEquals(2, l.size());
		assertEquals("apple", l.get(0));
		assertEquals("grape", l.get(1));
		l.insert("orange");
		l.insert("cantelope");
		l.insert("strawberry");
		l.insert("mango");
		l.insert("pear");
		l.insert("peach");
		l.insert("avocado");
		l.insert("plum");
		assertEquals(10, l.size());
		assertEquals("plum", l.get(9));
		l.insert("dragonfruit");
		assertEquals(11, l.size());
		assertEquals("dragonfruit", l.get(10));
		
	}

	/**
	 * Tests the add() method.
	 */
	@Test
	public void testAdd() {
		ArrayBasedList<String> l = new ArrayBasedList<String>();
		try {
			l.add(-1, "apple");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals("The given index is invalid.", e.getMessage());
			assertEquals(0, l.size());
		}
		try {
			l.add(1, "apple");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals("The given index is invalid.", e.getMessage());
			assertEquals(0, l.size());
		}
		assertEquals(0, l.size());
		l.add(0, "apple");
		assertEquals(1, l.size());
		assertEquals("apple", l.get(0));
		l.add(0, "grape");
		assertEquals(2, l.size());
		assertEquals("grape", l.get(0));
		assertEquals("apple", l.get(1));
		l.add(1, "pear");
		assertEquals(3, l.size());
		assertEquals("grape", l.get(0));
		assertEquals("pear", l.get(1));
		assertEquals("apple", l.get(2));
		l.add(3, "plum");
		assertEquals(4, l.size());
		assertEquals("grape", l.get(0));
		assertEquals("pear", l.get(1));
		assertEquals("apple", l.get(2));
		assertEquals("plum", l.get(3));
	}

	/**
	 * Tests the size() method.
	 */
	@Test
	public void testSize() {
		ArrayBasedList<String> l = new ArrayBasedList<String>();
		assertEquals(0, l.size());
		l.insert("apple");
		assertEquals(1, l.size());
	}

	/**
	 * Tests the remove() method.
	 */
	@Test
	public void testRemove() {
		ArrayBasedList<String> l = new ArrayBasedList<String>();
		l.insert("apple");
		assertEquals(1, l.size());
		try {
			l.remove(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals("The given index is invalid.", e.getMessage());
			assertEquals("apple", l.get(0));
			assertEquals(1, l.size());
		}
		try {
			l.remove(1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals("The given index is invalid.", e.getMessage());
			assertEquals("apple", l.get(0));
			assertEquals(1, l.size());
		}
		assertEquals("apple", l.remove(0));
		assertEquals(0, l.size());
		l.insert("apple");
		l.insert("grape");
		l.insert("orange");
		assertEquals("grape", l.remove(1));
		assertEquals(2, l.size());
		assertEquals("orange", l.remove(1));
		assertEquals(1, l.size());
	}

	/**
	 * Tests the set() method.
	 */
	@Test
	public void testSet() {
		ArrayBasedList<String> l = new ArrayBasedList<String>();
		l.insert("apple");
		assertEquals("apple", l.set(0, "grape"));
		assertEquals(1, l.size());
		assertEquals("grape", l.get(0));
	}
	
	/**
	 * Tests the lookUp() method. Note that the lookUp() method
	 * is not used for the SecurityLogManager program, so the
	 * method is expected to return null.
	 */
	@Test
	public void testLookUp() {
		ArrayBasedList<LogEntry> l = new ArrayBasedList<LogEntry>();
		LogEntry entry = new LogEntry("jnguyen", "01/01/2018 05:14:42AM", "delete", "immunization records");
		assertEquals(null, l.lookUp(entry));
	}

}
