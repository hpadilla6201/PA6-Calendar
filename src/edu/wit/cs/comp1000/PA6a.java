package edu.wit.cs.comp1000;
import java.util.Scanner;
/*
 * Making a Calendar
 * @author Hector Padilla
 * @date November 11 2019
 */


// TODO: document this class
public class PA6a {

	/**
	 * Error to output if year is not positive
	 */
	static final String E_YEAR = "The year must be positive!";

	/**
	 * Error to output if the day is not between 0 and 6
	 */
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";

	/**
	 * Determines if an input is a leap year
	 * 
	 * @param year year in question
	 * @return true if a leap year
	 */
	public static boolean isLeapYear(int year) {
		// return false; // TODO: replace with your code

		boolean flag = false;

		if (year % 400 == 0) {
			flag = true;
		} else if (year % 100 == 0) {
			flag = false;
		} else if (year % 4 == 0) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;

	}

	/**
	 * Outputs a month to the console
	 * 
	 * @param month    title
	 * @param startDay 0=Sunday ... 6=Saturday
	 * @param numDays  number of days in the month
	 * @return day of the week after the last day of the month
	 */
	public static int printMonth(String month, int startDay, int numDays) {
		// return 0; // TODO: replace with your code
		int currDay = startDay;
		System.out.println(month);
		

		
		//Prints WhiteSpace
		String initialSpace = ""; 
		for (int i = 0; i < currDay; i++) {
			System.out.print("   ");
		}
		
		
		for (int x= 1; x <= numDays; ++x) { //This for loop fills in Calendar
			if (currDay == 7) {
				System.out.println();
				currDay = 0;
			}
			System.out.printf("%3d", x);
	
			currDay++;
		}
		System.out.println();
		System.out.println();
		return currDay % 7;
		}
	

//("December", 0, 9, String.format("December%n  1  2  3  4  5  6  7%n  8  9%n%n", new Object[] {}), 2);
		/*int dayCounter = startDay;
		int date = 1;
		int weekCounter = 1;
		System.out.print(month);
		System.out.println();
		String initialSpace = "";
		for (int i = 0; i < startDay; i++) {
			initialSpace += " ";
		}
		System.out.print(initialSpace);

		for (int counter = 1; counter <= numDays; counter++) {
			if (weekCounter == 7) {
				System.out.println();
				weekCounter = 0;
			}
			System.out.print(" " + date);
			date++;
			weekCounter++;
		}
		return 1;
	}
	
	*/

	/**
	 * Program execution point: input year, day of the week (0-6) of january 1
	 * output calendar for that year
	 * 
	 * @param args command-line arguments (ignored)
	 */
	public static void main(String[] args) {
		// TODO: write your code here
		Scanner scnr = new Scanner(System.in);

		System.out.print("Enter the year: ");

		int Year = scnr.nextInt();

		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");

		int day = scnr.nextInt();

		if (Year < 0) {
			System.out.println("The year must be positive!");
			System.exit(0);
		}
		if ((day < 0) || (day > 6)) {
			System.out.println("The day of January 1st must be between 0 and 6!");
			System.exit(0);
		}

		int[] maxDay = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		int currMonth = printMonth("January", day, 31);
		
		for (int i = 1; i < monthName.length; ++i) {
			int d = maxDay[i];
			if ((monthName[i].equals("Febraury")) && isLeapYear(Year)){
				d = 29;
			}
			
			currMonth = printMonth(monthName[i], currMonth,d); //asking the last month where to start from
			
			
		}

	}

}
