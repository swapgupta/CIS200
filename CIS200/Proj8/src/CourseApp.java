/**
 * This project reads in data about a course, its instructor and its textbook and prints in out.
 * *****EXTRA CREDIT #1 DONE*************
 * @author Swapnil Gupta
 * @version Project 8
 */ 
import java.util.ArrayList;
import java.util.HashMap;

public class CourseApp {

	public static void main(String[] args) {
		
		ArrayList<Course> course = new ArrayList<Course>();
		HashMap<String, Course> cLookup = new HashMap<String, Course>();
		IO io = new IO();
		int count = 0;
		boolean done = false;
		
		do{
			String number = io.getNumber();
			String name = io.getName();
			String lName = io.getlastName();
			String fName = io.getfirstName();
			String username = io.getuserName();
			String title = io.getTitle();
			String author = io.getAuthor();
			double price = io.getPrice();
			Instructor instr = new Instructor(lName, fName, username);
			TextBook tb = new TextBook(title, author, price);
			Course c = new Course(number, name, instr, tb);
			course.add(c);
			cLookup.put(number, c);
			char another = io.anotherCourse();
		
			if( another == 'Y') { 
				done = false;
				continue;
			}
			else if( another == 'N') { 
				done = true;
				break;	
			}
			
		}while(done == false);
		
		for (int i = 0; i<course.size(); i++){
			io.printString(course.get(i).toString());
			io.printString(course.get(i).getInstructor().toString());
			io.printString(course.get(i).getTextBook().toString());
			io.printString("\n");
			io.pressEnter();
		}
		
		int index = -1;
		while(true){
			Course cDelete = cLookup.get(io.getDeleteCourse()); 
			for (int i = 0; i<course.size(); i++){
				if (cDelete.getName().equals(course.get(i).getName())){
					index = i;
					break;
				}
			}
			if (index == -1) io.Error();
			else break;
		}
		
		course.remove(index);
		
		String number = io.getNumber();
		String name = io.getName();
		String lName = io.getlastName();
		String fName = io.getfirstName();
		String username = io.getuserName();
		String title = io.getTitle();
		String author = io.getAuthor();
		double price = io.getPrice();
		Instructor instr = new Instructor(lName, fName, username);
		TextBook tb = new TextBook(title, author, price);
		Course c = new Course(number, name, instr, tb);
		course.add(c);
		cLookup.put(name, c);
		for (int i = 0; i<course.size(); i++){
			io.printString(course.get(i).toString());
			io.printString(course.get(i).getInstructor().toString());
			io.printString(course.get(i).getTextBook().toString());
			io.printString("\n");
			io.pressEnter();
		}

	}
}
