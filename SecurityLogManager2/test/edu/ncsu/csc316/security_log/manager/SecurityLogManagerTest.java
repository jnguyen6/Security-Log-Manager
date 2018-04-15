package edu.ncsu.csc316.security_log.manager;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the SecurityLogManager class. This test class reuses the
 * SecurityLogManagerTest class from CSC316 project 1.
 * 
 * @author Jimmy Nguyen
 */
public class SecurityLogManagerTest {
	
	/** The user activity log test file. */
	private final String validTestFile = "input/activityLog_xsmall.txt";
	/** The second user activity log test file. */
	private final String validTestFile2 = "input/activityLog_small.txt";

	/**
	 * Tests the SecurityLogManager constructor.
	 */
	@Test
	public void testSecurityLogManager() {
		SecurityLogManager slm = new SecurityLogManager(validTestFile);
		assertTrue(slm instanceof SecurityLogManager);
		try {
			slm = new SecurityLogManager("file.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("There was a problem reading the input file. Quitting program.", e.getMessage());
		}
	}

	/**
	 * Tests the generateOperationalProfile() method.
	 */
	@Test
	public void testGenerateOperationalProfile() {
		SecurityLogManager slm = new SecurityLogManager(validTestFile);
		String expected = "No activity was recorded.";
		String actual = slm.generateOperationalProfile("02/01/2018 01:01:12PM", "01/19/2019 09:43:43AM");
		assertEquals(expected, actual);
		String expected2 = "OperationalProfile[\n";
		expected2 += "   sort ICD-9 Code 196: frequency: 3, percentage: 75.0%\n";
		expected2 += "   view medical records: frequency: 1, percentage: 25.0%\n]";
		String actual2 = slm.generateOperationalProfile("04/26/2017 12:33:15PM", "01/23/2018 03:13:18PM");
		assertEquals(expected2, actual2);
		
		slm = new SecurityLogManager(validTestFile2);
		actual = slm.generateOperationalProfile("04/26/2007 12:33:15PM", "01/23/2020 03:13:18PM");
		
	}

	/**
	 * Tests the getUserReport() method.
	 */
	@Test
	public void testGetUserReport() {
		SecurityLogManager slm = new SecurityLogManager(validTestFile2);
		String expected = "Activity Report for james[\n   No activity was recorded.\n]";
		String actual = slm.getUserReport("james");
		assertEquals(expected, actual);
		String expected2 = "Activity Report for fzalcala[\n";
		expected2 += "   05/04/2015 02:09:40PM - sort ICD-9 Code 196\n";
		expected2 += "   06/09/2015 06:26:04AM - sort ICD-9 Code 196\n";
		expected2 += "   10/04/2015 12:17:49PM - sort ICD-9 Code 196\n";
		expected2 += "   08/04/2016 06:57:34AM - resolve message M2964\n";
		expected2 += "   10/07/2016 07:08:47AM - sort ICD-9 Code 196\n";
		expected2 += "   04/26/2017 12:33:15PM - sort ICD-9 Code 196\n";
		expected2 += "   07/03/2017 12:36:05AM - sort ICD-9 Code 196\n";
		expected2 += "   08/10/2017 05:10:54AM - sort ICD-9 Code 196\n";
		expected2 += "   08/26/2017 08:15:06AM - sort ICD-9 Code 196\n";
		expected2 += "   10/24/2017 11:38:02AM - sort ICD-9 Code 196\n";
		expected2 += "   11/20/2017 11:38:22AM - sort ICD-9 Code 196\n";
        expected2 += "]";
        String actual2 = slm.getUserReport("fzalcala");
        assertEquals(expected2, actual2);
	}

}
