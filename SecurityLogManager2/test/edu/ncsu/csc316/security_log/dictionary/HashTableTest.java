package edu.ncsu.csc316.security_log.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

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
		assertEquals(17, ht.getHashTableLength());
	}

	/**
	 * Tests the insert() method.
	 */
	@Test
	public void testInsert() {
		HashTable<String> ht = new HashTable<String>();
		assertEquals(0, ht.size());
		assertEquals(17, ht.getHashTableLength());
		ht.insert("apple");
		assertEquals(1, ht.size());
		assertEquals(17, ht.getHashTableLength());
		ht.insert("banana");
		assertEquals(2, ht.size());
		assertEquals(17, ht.getHashTableLength());
		ht.insert("kiwi");
		assertEquals(3, ht.size());
		assertEquals(17, ht.getHashTableLength());
		ht.insert("orange");
		assertEquals(4, ht.size());
		assertEquals(17, ht.getHashTableLength());
		ht.insert("grape");
		assertEquals(5, ht.size());
		assertEquals(17, ht.getHashTableLength());
		ht.insert("peach");
		assertEquals(6, ht.size());
		assertEquals(17, ht.getHashTableLength());
		ht.insert("lime");
		assertEquals(7, ht.size());
		assertEquals(17, ht.getHashTableLength());
		ht.insert("lemon");
		assertEquals(8, ht.size());
		assertEquals(17, ht.getHashTableLength());
		ht.insert("dragon fruit");
		assertEquals(9, ht.size());
		assertEquals(17, ht.getHashTableLength());
		ht.insert("cherry");
		assertEquals(10, ht.size());
		assertEquals(17, ht.getHashTableLength());
		ht.insert("durian");
		assertEquals(11, ht.size());
		assertEquals(17, ht.getHashTableLength());
		ht.insert("lemon");
		assertEquals(12, ht.size());
		assertEquals(17, ht.getHashTableLength());
		ht.insert("avocado");
		assertEquals(13, ht.size());
		assertEquals(17, ht.getHashTableLength());
		ht.insert("plum");
		assertEquals(14, ht.size());
		assertEquals(35, ht.getHashTableLength());
		
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
		assertEquals(17, ht.getHashTableLength());
		ht.insert("apple");
		ht.insert("banana");
		ht.insert("kiwi");
		ht.insert("orange");
		ht.insert("grape");
		ht.insert("peach");
		ht.insert("lime");
		ht.insert("lemon");
		ht.insert("dragon fruit");
		ht.insert("durian");
		ht.insert("plum");
		ht.insert("avocado");
		ht.insert("cherry");
		ht.insert("fig");
		assertEquals(35, ht.getHashTableLength());
	}

}
