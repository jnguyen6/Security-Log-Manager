package edu.ncsu.csc316.security_log.ui;

import java.util.Scanner;

import edu.ncsu.csc316.security_log.manager.SecurityLogManager;

/**
 * Program that reads an input file containing log entries and creating
 * a SecurityLogManager instance that contains that file. The program
 * also reads user input, determines whether to generate an operational
 * profile, create a user report, or quit the program, and outputs
 * either the operational profile or the user report. This UI class is
 * reused from the SecurityLogManagerUI class from CSC316 project 1, with
 * some modifications.
 * 
 * @author Jimmy Nguyen
 */
public class SecurityLogManagerUI {
	
	/** The instance variable of the security log manager. */
	private SecurityLogManager slm;

	/**
	 * Method that starts the program. The user will first be given the 
	 * option to provide an input file Once the user provides an input file,
	 * then the method processUserAction() is called to continue reading user
	 * input. If the input file is invalid, then the program closes.
	 * 
	 * @param args the command-line arguments (not used)
	 */
	public static void main(String[] args) {
		SecurityLogManagerUI ui = new SecurityLogManagerUI();
		Scanner console = new Scanner(System.in);
		String fileName = "";
		System.out.print("Enter an input file: ");
		fileName = console.nextLine();
		if (!fileName.endsWith("txt")) {
			System.out.print("\nThe input file is invalid. The program will close.");
			console.close();
			System.exit(1);
		}
		ui.processUserAction(console, fileName);
	}
	
	/**
	 * The user will be prompted to either generate an operational profile, 
	 * create a user report for a specific user, or quit the program. If the
	 * user provides invalid input, then the program will close.
	 * 
	 * @param console the Scanner that reads input from the console
	 * @param fileName the name of the input file
	 */
	public void processUserAction(Scanner console, String fileName) {
		slm = new SecurityLogManager(fileName);
		String input = "";
		System.out.print("Generate Operational Profile (G), Create a User Report (U),"
				+ " or Quit (Q): ");
		input = console.nextLine();
		while (input.equalsIgnoreCase("G") || input.equalsIgnoreCase("U")) {
		    if (input.equalsIgnoreCase("G")) {
			    System.out.print("Please provide the start timestamp: ");
			    String start = console.nextLine();
			    System.out.print("Please provide the end timestamp: ");
			    String end = console.nextLine();
			    System.out.print("Generating Operational Profile...\n\n");
			    String operationalProfile = slm.generateOperationalProfile(start, end);
			    System.out.print(operationalProfile);
			    System.out.print("\n\nThe operational profile has been sucessfully created.\n\n.");
			
		    } else {
			    System.out.print("Please provide the username to generate the user report for: ");
			    String username = console.nextLine();
			    System.out.print("Generating User Report...\n\n");
			    String userReport = slm.getUserReport(username);
			    System.out.print(userReport);
			    System.out.print("\n\nThe user report has been sucessfully created.\n\n.");
		    }
			System.out.print("Generate Operational Profile (G), Create a User Report (U),"
					+ " or Quit (Q): ");
			input = console.nextLine();
		}
		System.out.print("\nThe Security Log Manager program will now close.");
		console.close();
		System.exit(1);
		
	}

}
