import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	
 
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<String> words = new ArrayList<String>();
		words.add("a");
		words.add("a");
		words.add("a");
		words.add("ab");
		words.add("ab");
		words.add("ab");
		words.add("ab");
		words.add("abc");
		words.add("abc");
		words.add("abcde");
		
		HashMap<Integer, Integer> num = new HashMap<Integer, Integer>();
		
		
		for(int i=0; i<20; i++){
			
			int count = 0;
			for(int j=0; j<words.size(); j++){
				
				if (words.get(j).length() == i) count++;
			}
			num.put(i, count);
		}
		
		System.out.println("What is the number?");
		int number = Integer.parseInt(s.nextLine());
		
		System.out.print(num.get(number));
	} 
}