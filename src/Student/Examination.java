/**
 * 
 */
package Student;

/**
 * @author BABAKAKAN
 *
 */
public class Examination {
	// Stores the marks of a given subject
	private int[] marks;
	// Stores the subject name of a given exam
	private String[] subject;
	// The exam we're talking about
	private EXAM exam_id;
	private int lastIterator;
	
	/**
	 * @param exam_id -- To store the details of the specified exam.
	 */
	Examination(EXAM exam_id){
		this.marks = new int[10];
		this.subject = new String[10];
		this.exam_id = exam_id;
		this.lastIterator = -1;
	}
	/**
	 * Displays the marks scored in each subject, along with total percentage
	 */
	void display() {
		float marksScored = 0, totalMarks;
		switch( exam_id ) {
			case UNIT_TEST:
			case UNIT_TEST2: 
					totalMarks = 400; break;
			case HALF_YEARLY: totalMarks = 800; break;
			case ANNUAL: totalMarks = 1000; break;
			default: totalMarks = 1000;
		}
		System.out.println("Exam: " + exam_id );
		for(int i = 0; i <= lastIterator; i++) {
			System.out.println("\tYou scored " + marks[i] + " in " + subject[i]);
			marksScored += marks[i];
		}
		System.out.println("\tYour percentage: " + ( marksScored/totalMarks*100 ) + "%" );
	}
	/**
	 * @param marks -- Set the marks of the specified exam.
	 * @param subject -- The subject to which the mark is given.
	 */
	void setMarks(int marks, String subject) {
		lastIterator++;
		if( lastIterator <= 10 ) {
			this.marks[lastIterator] = marks;
			this.subject[lastIterator] = subject;
		}
	}
}
