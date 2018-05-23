/**
 * 
 */
package Student;

/**
 * @author BABAKAKAN
 *
 */
public class Student {
	private String password;
	private String username;
	private boolean loggedin;
	
	private Examination Utest = new Examination(EXAM.UNIT_TEST),
						HYearly = new Examination(EXAM.HALF_YEARLY),
						UTest2 = new Examination(EXAM.UNIT_TEST2), 
						Annual = new Examination(EXAM.ANNUAL);
	
	/**
	 * @param username -- Username to register
	 * @param password -- The new password to be set.
	 */
	Student( String username, String password ){
		//Set the username and password
		this.password = password;
		this.username = username;
		System.out.println("Created account successfully!");
	}
	
	/**
	 * @param username -- Username to login with
	 * @param password -- The password.
	 */
	public void login( String username, String password ) {
		//Checks whether the username and password are correct.
		if( this.username.equals(username) && this.password.equals(password) ){
			//Set logged in session as true
			this.loggedin = true;
			System.out.println("Successfully logged in");
			return;
		}
		else
			System.err.println("Invalid username or password");
	}
	/**
	 * @param exam_id -- The required exam's ID according to the Enum
	 * @param marks -- Marks scored in the exam
	 * @param subject -- The subject of the exam
	 */
	public void enterMarks( EXAM exam_id, int marks, String subject ) {
		if( !loggedin ) {
			System.err.println("Not logged in.");
			return;
		}
		switch( exam_id ){
		case UNIT_TEST:
				 Utest.setMarks(marks, subject); break;
		case HALF_YEARLY:
				HYearly.setMarks(marks, subject); break;
		case UNIT_TEST2:
				UTest2.setMarks(marks, subject); break;
		case ANNUAL:
				Annual.setMarks(marks, subject); break;
		}
	}
	/**
	 * @param exam_id -- Show the results of the specified exam.
	 */
	public void showResults(EXAM exam_id){
		if( !loggedin ) {
			System.err.println("Not logged in.");
			return;
		}
		switch( exam_id ){
			case UNIT_TEST:
				Utest.display(); break;
			case HALF_YEARLY:
				HYearly.display(); break;
			case UNIT_TEST2:
				UTest2.display(); break;
			case ANNUAL:
				Annual.display(); break;
		}
	}
}
