/**
 * <Student.java>
 * <Swapnil Gupta / Thursday 6pm / Atef Khan>
 *
 * <This is the class that calculates the grade and makes the string>
*/ 
import java.text.DecimalFormat;
import java.util.Scanner;

public class Student {
	private String fullName;
	private String WID;
	private double totalLabs;
	private double totalProj;
	private double totalCodeLab = 225;
	private double totalExams = 150;
	private double totalFinal = 100;
	private double totalScore;
	
	private double weightLabs = 10;
	private double weightProj = 15;
	private double weightCodeLab = 10;
	private double weightExams = 45;
	private double weightFinal = 20;
	
	DecimalFormat df = new DecimalFormat("#0.00");
	
	public Student()
	{
		fullName = "no name";
		WID = "no WID";
		totalLabs = 0;
		totalProj = 0;
		totalCodeLab = 0;
		totalExams = 0;
		totalFinal = 0;
		totalScore = 0;
	}
	public Student(double lab, double proj){
		totalLabs = lab;
		totalProj = proj;
		}
	/**
	 * this method finds the overall grade for the student
	 *
	 * @sLab (this is the student's lab grade)
	 * @sProj (this is the student's project grade)
	 * @sCodeLab (this is the student's codelab grade)
	 * @sExam (this is the student's exam grade)
	 * @sFinal (this is the student's final exam grade)
	 * @overall (The students overall grade is returned)
	 */ 
	public double findOverall(double sLab, double sProj, double sCodeLab, double sExam, double sFinal){
		double overall;
		double labOverall = (sLab/this.totalLabs) * this.weightLabs;
		double projOverall = (sProj/this.totalProj) * this.weightProj;
		double codeLabOverall = (sCodeLab/this.totalCodeLab) * this.weightCodeLab;
		double examOverall = (sExam/this.totalExams) * this.weightExams;
		double finalOverall = (sFinal/this.totalFinal) * this.weightFinal;
		overall = labOverall + projOverall + codeLabOverall + examOverall + finalOverall;
		return overall;
	}
	/**
	 * this method makes a string for each student with their grade
	 *
	 * @lastName (this is the student's last name)
	 * @firstName (this is the student's first name)
	 * @WID (this is the student's WID)
	 * @overallGrade (this is the student's overall grade)
	 * @return (The students name, WID, overall grade precent and letter is returned)
	 */ 
	 public String toString(String lastName, String firstName, String WID, double overallGrade){
		 char grade;
		 if (overallGrade >= 89.5) {
			 grade = 'A';
		 } else if (overallGrade >= 79.5) {
			 grade = 'B';
		 } else if (overallGrade >= 69.5) {
			 grade = 'C';
		 } else if (overallGrade >= 59.5) {
			 grade = 'D';
		 } else {
			 grade = 'F';
		 }
		 return "Student Name: " + lastName + ", " + firstName + "\nWID: " + WID + "\nOverall %: " + df.format(overallGrade) + "\nFinal Grade: " + grade;
	 }
}
