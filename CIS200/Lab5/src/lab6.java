package lab6;

import java.io.*;
import java.util.*;

public class lab6 {
	public static String getInitial(String fullName) {
		//WRITE THIS METHOD FIRST

		StringTokenizer st = new StringTokenizer(fullName, " ");
		int names = st.countTokens();
		String [] name = new String[names];
		String [] initials = new String[names];
		
		for (int i= 0; i<names; i++){
			name[i] = st.nextToken();
		}
		
		for (int i= 0; i<names; i++){
			initials[i] =  name[i].substring(0, 1); 
		}
		
		StringBuilder build = new StringBuilder();
		for (int i= 0; i<names; i++){
			build.append(initials[i] + ". ");
		}
		String initial = build.toString();
		return initial;
		//fullName is a string with a person's first, middle, and last
		//names separated by spaces (like "Thomas Alva Edison").  You
		//should return the string with the first, middle, and last
		//initials of the person' with this fullName.  For example,
		//if fullName was "Thomas Alva Edison", you should return
		//the string "T.A.E."

		//use StringTokenizer or split method to parse name into pieces

        //use StringBuilder to 'build' the new string

	} // end getInitial

	public static void printInitials(String[] allNames) {
		//WRITE THIS METHOD SECOND
		for (int i= 0; i<allNames.length; i++){
			String currentInitial = getInitial(allNames[i]); 
			System.out.println(currentInitial);
		}

		//allNames is an array of strings, where each element is
		//someone's full name (first, middle, last separated by spaces).

		//Loop through allNames, and for each element, display the
		//initials corresponding to that name.  You should call
		//getInitial on each full name to get the initials.  Then,
		//display the return value you get back from printInitials.
	} // end printInitials

	public static String[] getNames(String filename) throws IOException {
		//THIS METHOD IS DONE FOR YOU

		Scanner inFile = new Scanner(new File(filename));
		int size = Integer.parseInt(inFile.nextLine());
		String[] arr = new String[size];

		for (int i = 0; i < size; i++) {
			arr[i] = inFile.nextLine();
		}

		inFile.close();

		return arr;
	} // end getNames

	//public static void main(String[] args) throws IOException {
		public static void main(String[] args) throws IOException
		{	 
			String fname = "NA";
		if (args.length == 0) 
		{ 
		System.out.println("no arguments were given.");
		 } 
		else 
		{ 
			fname = args[0];
			String[] names = getNames(fname);
			lab6.printInitials(names);
		}


	} // end main
} // end class