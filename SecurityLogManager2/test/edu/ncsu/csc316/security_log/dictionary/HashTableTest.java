package edu.ncsu.csc316.security_log.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.security_log.data.LogEntry;

/**
 * Tests the HashTable class.
 * 
 * @author Jimmy Nguyen
 */
public class HashTableTest {

	/**
	 * Tests the HashTable constructor.
	 */
	@Test
	public void testHashTable() {
		HashTable<String> ht = new HashTable<String>();
		assertTrue(ht instanceof HashTable);
		assertEquals(0, ht.size());
		assertEquals(10, ht.getHashTableLength());
	}

	/**
	 * Tests the insert() method.
	 */
	@Test
	public void testInsert() {
		HashTable<String> ht = new HashTable<String>();
		assertEquals(0, ht.size());
		assertEquals(10, ht.getHashTableLength());
		ht.insert("apple");
		assertEquals(1, ht.size());
		assertEquals(10, ht.getHashTableLength());
		ht.insert("banana");
		assertEquals(2, ht.size());
		assertEquals(10, ht.getHashTableLength());
		ht.insert("kiwi");
		assertEquals(3, ht.size());
		assertEquals(10, ht.getHashTableLength());
		ht.insert("orange");
		assertEquals(4, ht.size());
		assertEquals(10, ht.getHashTableLength());
		ht.insert("grape");
		assertEquals(5, ht.size());
		assertEquals(10, ht.getHashTableLength());
		ht.insert("peach");
		assertEquals(6, ht.size());
		assertEquals(10, ht.getHashTableLength());
		ht.insert("lime");
		assertEquals(7, ht.size());
		assertEquals(10, ht.getHashTableLength());
		ht.insert("lemon");
		assertEquals(8, ht.size());
		assertEquals(10, ht.getHashTableLength());
		ht.insert("dragon fruit");
		assertEquals(9, ht.size());
		assertEquals(21, ht.getHashTableLength());
		
	}

	/**
	 * Tests the lookUp() method.
	 */
	@Test
	public void testLookUp() {
		HashTable<String> ht = new HashTable<String>();
		assertNull(ht.lookUp("apple"));
		ht.insert("apple");
		assertEquals("apple", ht.lookUp("apple"));
		ht.insert("banana");
		assertEquals("banana", ht.lookUp("banana"));
		assertEquals("apple", ht.lookUp("apple"));
		ht.insert("grape");
		assertEquals("grape", ht.lookUp("grape"));
		assertEquals("banana", ht.lookUp("banana"));
		assertEquals("apple", ht.lookUp("apple"));
		ht.insert("kiwi");
		assertEquals("kiwi", ht.lookUp("kiwi"));
		assertEquals("grape", ht.lookUp("grape"));
		assertEquals("banana", ht.lookUp("banana"));
		assertEquals("apple", ht.lookUp("apple"));
		ht.insert("orange");
		assertEquals("orange", ht.lookUp("orange"));
		assertEquals("kiwi", ht.lookUp("kiwi"));
		assertEquals("grape", ht.lookUp("grape"));
		assertEquals("banana", ht.lookUp("banana"));
		assertEquals("apple", ht.lookUp("apple"));
		ht.insert("peach");
		assertEquals("peach", ht.lookUp("peach"));
		assertEquals("orange", ht.lookUp("orange"));
		assertEquals("kiwi", ht.lookUp("kiwi"));
		assertEquals("grape", ht.lookUp("grape"));
		assertEquals("banana", ht.lookUp("banana"));
		assertEquals("apple", ht.lookUp("apple"));
		ht.insert("pear");
		assertEquals("pear", ht.lookUp("pear"));
		assertEquals("peach", ht.lookUp("peach"));
		assertEquals("orange", ht.lookUp("orange"));
		assertEquals("kiwi", ht.lookUp("kiwi"));
		assertEquals("grape", ht.lookUp("grape"));
		assertEquals("banana", ht.lookUp("banana"));
		assertEquals("apple", ht.lookUp("apple"));
		ht.insert("dragon fruit");
		assertEquals("dragon fruit", ht.lookUp("dragon fruit"));
		assertEquals("pear", ht.lookUp("pear"));
		assertEquals("peach", ht.lookUp("peach"));
		assertEquals("orange", ht.lookUp("orange"));
		assertEquals("kiwi", ht.lookUp("kiwi"));
		assertEquals("grape", ht.lookUp("grape"));
		assertEquals("banana", ht.lookUp("banana"));
		assertEquals("apple", ht.lookUp("apple"));
		ht.insert("lime");
		assertEquals("lime", ht.lookUp("lime"));
		assertEquals("dragon fruit", ht.lookUp("dragon fruit"));
		assertEquals("pear", ht.lookUp("pear"));
		assertEquals("peach", ht.lookUp("peach"));
		assertEquals("orange", ht.lookUp("orange"));
		assertEquals("kiwi", ht.lookUp("kiwi"));
		assertEquals("grape", ht.lookUp("grape"));
		assertEquals("banana", ht.lookUp("banana"));
		assertEquals("apple", ht.lookUp("apple"));
		ht.insert("lemon");
		assertEquals("lemon", ht.lookUp("lemon"));
		assertEquals("lime", ht.lookUp("lime"));
		assertEquals("dragon fruit", ht.lookUp("dragon fruit"));
		assertEquals("pear", ht.lookUp("pear"));
		assertEquals("peach", ht.lookUp("peach"));
		assertEquals("orange", ht.lookUp("orange"));
		assertEquals("kiwi", ht.lookUp("kiwi"));
		assertEquals("grape", ht.lookUp("grape"));
		assertEquals("banana", ht.lookUp("banana"));
		assertEquals("apple", ht.lookUp("apple"));
		ht.insert("cranberry");
		assertEquals("cranberry", ht.lookUp("cranberry"));
		assertEquals("banana", ht.lookUp("banana"));
		assertEquals("grape", ht.lookUp("grape"));
		assertEquals("kiwi", ht.lookUp("kiwi"));
		assertEquals("orange", ht.lookUp("orange"));
		assertEquals("peach", ht.lookUp("peach"));
		assertEquals("pear", ht.lookUp("pear"));
		assertEquals("dragon fruit", ht.lookUp("dragon fruit"));
		assertEquals("lime", ht.lookUp("lime"));
		assertEquals("lemon", ht.lookUp("lemon"));
		assertEquals("cranberry", ht.lookUp("cranberry"));
		
		HashTable<LogEntry> ht2 = new HashTable<LogEntry>();
		LogEntry e = new LogEntry("fzalcala", "04/26/2017 12:33:15PM", "sort", "ICD-9 Code 196");
		LogEntry e2 = new LogEntry("fzalcala", "07/03/2017 12:36:05AM", "sort", "ICD-9 Code 196");
		LogEntry e3 = new LogEntry("quhundley", "08/04/2017 11:01:45AM", "sort", "ICD-9 Code 196");
		LogEntry e4 = new LogEntry("fzalcala", "08/10/2017 05:10:54AM", "sort", "ICD-9 Code 196");
		LogEntry e5 = new LogEntry("fzalcala", "08/26/2017 08:15:06AM", "sort", "ICD-9 Code 196");
		LogEntry e6 = new LogEntry("quhundley", "09/21/2017 08:50:13AM", "import", "office visit OV04312");
		LogEntry e7 = new LogEntry("fzalcala", "10/24/2017 11:38:02AM", "sort", "ICD-9 Code 196");
		LogEntry e8 = new LogEntry("fzalcala", "11/20/2017 11:38:22AM", "sort", "ICD-9 Code 196");
		LogEntry e9 = new LogEntry("fzalcala", "05/04/2015 02:09:40PM", "sort", "ICD-9 Code 196");
		LogEntry e10 = new LogEntry("fzalcala", "06/09/2015 06:26:04AM", "sort", "ICD-9 Code 196");
		LogEntry e11 = new LogEntry("quhundley", "07/18/2015 07:57:42PM", "sort", "ICD-9 Code 196");
		LogEntry e12 = new LogEntry("fzalcala", "10/04/2015 12:17:49PM", "sort", "ICD-9 Code 196");
		LogEntry e13 = new LogEntry("quhundley", "02/04/2016 08:49:22AM", "sort", "ICD-9 Code 196");
		LogEntry e14 = new LogEntry("fzalcala", "08/04/2016 06:57:34AM", "resolve", "message M2964");
		LogEntry e15 = new LogEntry("fzalcala", "10/07/2016 07:08:47AM", "sort", "ICD-9 Code 196");
		LogEntry e16 = new LogEntry("quhundley", "11/20/2016 02:07:54PM", "sort", "ICD-9 Code 196");
		
		ht2.insert(e);
		ht2.insert(e6);
		ht2.insert(e14);
		
		assertEquals(e, ht2.lookUp(e));
		assertEquals(e, ht2.lookUp(e2));
		assertEquals(e, ht2.lookUp(e3));
		assertEquals(e, ht2.lookUp(e4));
		assertEquals(e, ht2.lookUp(e5));
//		assertNull(ht2.lookUp(e2));
//		assertNull(ht2.lookUp(e3));
//		assertNull(ht2.lookUp(e4));
//		assertNull(ht2.lookUp(e5));
		assertEquals(e6, ht2.lookUp(e6));
		assertEquals(e, ht2.lookUp(e7));
		assertEquals(e, ht2.lookUp(e8));
		assertEquals(e, ht2.lookUp(e9));
		assertEquals(e, ht2.lookUp(e10));
		assertEquals(e, ht2.lookUp(e11));
		assertEquals(e, ht2.lookUp(e12));
		assertEquals(e, ht2.lookUp(e13));
//		assertNull(ht2.lookUp(e7));
//		assertNull(ht2.lookUp(e8));
//		assertNull(ht2.lookUp(e9));
//		assertNull(ht2.lookUp(e10));
//		assertNull(ht2.lookUp(e11));
//		assertNull(ht2.lookUp(e12));
//		assertNull(ht2.lookUp(e13));
		assertEquals(e14, ht2.lookUp(e14));
		assertEquals(e, ht2.lookUp(e15));
		assertEquals(e, ht2.lookUp(e16));
//		assertNull(ht2.lookUp(e15));
//		assertNull(ht2.lookUp(e16));
	}

	/**
	 * Tests the size() method.
	 */
	@Test
	public void testSize() {
		HashTable<String> ht = new HashTable<String>();
		assertEquals(0, ht.size());
		ht.insert("apple");
		assertEquals(1, ht.size());
	}

	/**
	 * Tests the getHashTableLength() method.
	 */
	@Test
	public void testGetHashTableLength() {
		HashTable<String> ht = new HashTable<String>();
		assertEquals(10, ht.getHashTableLength());
		ht.insert("apple");
		ht.insert("banana");
		ht.insert("kiwi");
		ht.insert("orange");
		ht.insert("grape");
		ht.insert("peach");
		ht.insert("lime");
		ht.insert("lemon");
		ht.insert("dragon fruit");
		assertEquals(21, ht.getHashTableLength());
	}

}
