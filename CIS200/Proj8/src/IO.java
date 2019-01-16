/**
 * This is the input/output class for project 8.
 * @author Swapnil Gupta
 * @version Project 8
 */ 
import java.util.Scanner;

public class IO {

	private Scanner s;

	/**
	 * IO sets up a new Scanner to System.in
	 */
	public IO() {
		s = new Scanner(System.in);
	}
	
	 /**
    asks the user for the number of the course
    @return The number of the course.
	 */
	public String getNumber() {
		System.out.print("Enter the course number: "); 
		while (true) {
            try {
            	String number = s.nextLine(); 
                if (number.isEmpty()) {
                    throw new IllegalArgumentException();
                } 
                else {
                    return number;
                }
            } 
            catch (IllegalArgumentException e) {
                System.out.print("\nInvalid Input.\nPlease enter the course number: ");
                System.out.println();
            }
        }
	} 
	
	/**
    asks the user for the name of the course
    @return The name of the course.
	*/
	public String getName() {
		System.out.print("Enter the course name: "); 
		while (true) {
            try {
            	String name = s.nextLine(); 
                if (name.isEmpty()) {
                    throw new IllegalArgumentException();
                } 
                else {
                    return name;
                }
            } 
            catch (IllegalArgumentException e) {
                System.out.print("\nInvalid Input.\nPlease enter the course name: ");
                System.out.println();
            }
        }
	} 
	
	/**
    asks the user for the last name of the instructor
    @return The last name of the instructor
	*/
	public String getlastName() {
		System.out.print("Enter the Instructor last name: "); 
		while (true) {
            try {
            	String lastName = s.nextLine();  
                if (lastName.isEmpty()) {
                    throw new IllegalArgumentException();
                } 
                else {
                    return lastName;
                }
            } 
            catch (IllegalArgumentException e) {
            	System.out.print("\nInvalid Input.\nPlease enter the instructor's last name: ");
                System.out.println();
            }
        }
	} 
	
	/**
    asks the user for the first name of the instructor
    @return The first name of the instructor
	*/
	public String getfirstName() {
		System.out.print("Enter the Instructor first name: "); 
		while (true) {
            try {
            	String firstName = s.nextLine();  
                if (firstName.isEmpty()) {
                    throw new IllegalArgumentException();
                } 
                else {
                    return firstName;
                }
            } 
            catch (IllegalArgumentException e) {
            	System.out.print("\nInvalid Input.\nPlease enter the instructor's first name: ");
                System.out.println();
            }
        }
	} 
	
	/**
    asks the user for the username of the instructor
    @return The username of the instructor
	*/
	public String getuserName() {
		System.out.print("Enter the Instructor username: "); 
		while (true) {
            try {
            	String userName = s.nextLine();  
                if (userName.isEmpty()) {
                    throw new IllegalArgumentException();
                } 
                else {
                    return userName;
                }
            } 
            catch (IllegalArgumentException e) {
            	System.out.print("\nInvalid Input.\nPlease enter the instructor's username: ");
                System.out.println();
            }
        }
	} 
	
	/**
    asks the user for the title of the textbook
    @return The title of the textbook
	*/
	public String getTitle() {
		System.out.print("Enter the Textbook Title: "); 
		while (true) {
            try {
            	String title = s.nextLine();  
                if (title.isEmpty()) {
                    throw new IllegalArgumentException();
                } 
                else {
                    return title;
                }
            } 
            catch (IllegalArgumentException e) {
            	System.out.print("\nInvalid Input.\nPlease enter the Textbook Title: ");
                System.out.println();
            }
        }
	} 
	
	/**
    asks the user for the author of the textbook
    @return The author of the textbook
	*/
	public String getAuthor() {
		System.out.print("Enter the Textbook author: "); 
		while (true) {
            try {
            	String author = s.nextLine();  
                if (author.isEmpty()) {
                    throw new IllegalArgumentException();
                } 
                else {
                    return author;
                }
            } 
            catch (IllegalArgumentException e) {
            	System.out.print("\nInvalid Input.\nPlease enter the Textbook author: ");
                System.out.println();
            }
        }
	} 
	
	/**
    asks the user for the price of the textbook
    @return The price of the textbook
	*/
	public double getPrice() {
		System.out.print("Enter the Textbook price: "); 
		while (true) {
            try {
            	double price = Double.parseDouble(s.nextLine());  
            	return price;
            } 
            catch (NumberFormatException e) {
                    System.out.print("\nInvalid Input.\nPlease enter the textbook price: ");
            }
		}
	} 
	
	/**
    asks the user if they want to enter another entry
    @return Y or N if the user wants to enter another entry
	*/
	public char anotherCourse(){
		System.out.println("Would you like to enter another course? ('Y' or 'N')");
		while (true) {
            try {
            	char another = s.nextLine().toUpperCase().charAt(0);
                if (another != 'Y' && another != 'N') {
                    throw new IllegalArgumentException();
                } 
                else {
                    return another;
                }
            } 
            catch (IllegalArgumentException e) {
            	System.out.print("\nInvalid Input.\nPlease enter Y or N. ");
                System.out.println();
            }
        }
	}
	
	/**
    Prompts the user to press enter
	*/
	public void pressEnter(){
            System.out.println("Press Enter to continue...");
        	s.nextLine();
	}
	
	 /**
    Prints the input
    @param s the string to print
	*/
	public void printString(String s){
		System.out.println(s);
	}
	
	/**
    asks the user a course to delete
    @return course to delete
	*/
	public String getDeleteCourse(){
		System.out.println("Enter a course number to delete: ");
		return s.nextLine();
	}
	
	/**
    Prints Error!
	*/
	public void Error(){
		System.out.println("Error!");
	}
}
