package jac444.wk4;

import java.io.Serializable;

/**
 * @author Namra Rupesh Fanse
 *
 */
public class Student implements Serializable {

	/**
	 * serialVersionUID of this class
	 */
	private static final long serialVersionUID = 3403531361456240910L;
	/**
	 * a string to store name of the student.
	 */
	private String name;
	/**
	 * a string to store course name of the student.
	 */
	private String course;
	/**
	 * an integer to store grade of the student.
	 */
	private int grade;

	/**
	 * Constructor to instantiate the object.
	 */
	public Student() {
	}

	/**
	 * A setter which assigns name of the student to the student object.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * A setter which assigns course name to the student object.
	 * 
	 * @param course name
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * A setter which assigns grade to the student object.
	 * 
	 * @param grade
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	/**
	 * A getter which returns the name of the student.
	 * 
	 * @return name of the student
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * A getter which returns the course name of the student.
	 * 
	 * @return course name
	 */
	public String getCourse() {
		return this.course;
	}

	/**
	 * A getter which returns the grade of the student.
	 * 
	 * @return grade
	 */
	public int getGrade() {
		return this.grade;
	}
}
