/**
 * 
 */
package Student;

import java.util.Scanner;
/**
 * @author BABAKAKAN
 *
 */
public class Execution {
	static Scanner sc = new Scanner(System.in);
	static Student[] students = new Student[100];
	static int lastIterator = -1;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create a dummy student
		Student ob = new Student("", "");
		// His details: Used for input
		String username, password;
		boolean cond = true;
		do {
			System.out.println("What do you want to do?");
			System.out.println("\t 1. Create an Account \n\t 2. Login \n\t 3. Enter Marks \n\t 4. Get results \n\t 5. Exit");
			switch( sc.nextInt() ){
				case 1: // Create an account
					// Flush the scanner's buffer
					sc.nextLine();
					// Ask for details

					// Username
					System.out.println("Enter username: ");
					username = sc.nextLine();

					// Password
					System.out.println("Enter password: ");
					password = sc.nextLine();

					// Create the account and login
					ob = new Student(username,password);
					ob.login(username,password);

					// Increase the iteration, for the account.
					lastIterator++;
					students[lastIterator] = ob; // Store the object
					System.out.println("Your Unique ID is " + lastIterator);
				break;

				case 2: // Login
					System.out.println("Your Unique ID: ");
					int uid = sc.nextInt();

					sc.nextLine(); // Flush the buffer

					// Username input
					System.out.println("Your username: ");
					username = sc.nextLine();

					// Password input
					System.out.println("Your password: ");
					password = sc.nextLine();

					// Store the reference in temp variable ob.
					ob = students[uid];

					// Try to login.
					ob.login(username,password);

				break;

				case 3: // Input Marks
					inputMarks(ob); break;
				case 4: // Get Result
					getResult(ob); break;
				case 5: // Exit
					cond = false; break;
				default: System.out.println("Wrong input. Try again"); break;
			}
		} while(cond);
		System.out.println("Goodbye");
	}

	/**
	 * @param ob -- The required student
	 */
	public static void inputMarks(Student ob){
		// Flush the buffer
		sc.nextLine();

		// Ask for input
		System.out.println("Enter subject: ");
		String subject = sc.nextLine();
		System.out.println("Enter marks: ");
		int marks = sc.nextInt();

		//And of the exam
		System.out.println("Please enter the exam time: ");
		System.out.println("\t1. Unit test \n\t 2. Half-yearly \n\t 3. 2nd Unit Test \n\t 4. Annual");

		// We'll store the exam timing in this.
		EXAM exam_id;

		switch( sc.nextInt() ){
			case 1: exam_id = EXAM.UNIT_TEST; break;
			case 2: exam_id = EXAM.HALF_YEARLY; break;
			case 3: exam_id = EXAM.UNIT_TEST2; break;
			case 4: exam_id = EXAM.ANNUAL; break;
			default: exam_id = EXAM.ANNUAL; break;
		}

		// Send it to the student object to enter the marks.
		ob.enterMarks( exam_id, marks, subject );

	}

	/**
	 * @param ob -- The required student
	 */
	public static void getResult(Student ob){
		System.out.println("Please enter the exam time: ");
		System.out.println("\t1. Unit test \n\t 2. Half-yearly \n\t 3. 2nd Unit Test \n\t 4. Annual");
		EXAM exam_id;
		switch( sc.nextInt() ){
			case 1: exam_id = EXAM.UNIT_TEST; break;
			case 2: exam_id = EXAM.HALF_YEARLY; break;
			case 3: exam_id = EXAM.UNIT_TEST2; break;
			case 4: exam_id = EXAM.ANNUAL; break;
			default: exam_id = EXAM.ANNUAL; break;
		}
		ob.showResults(exam_id);

	}

}
