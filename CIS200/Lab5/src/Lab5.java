import java.util.*;
import java.io.*;

public class Lab5 {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		Scanner inFile = new Scanner (new File("words.txt"));
		String [] words = new String[Integer.parseInt(inFile.nextLine())];
		for (int i = 0; i < words.length; i++) 
			{ 
			words[i] = inFile.nextLine(); 
			}
		inFile.close();
		
		Random rand = new Random();
		String correct = words[rand.nextInt(words.length)];
		System.out.println(correct);
		
		boolean[] used = new boolean[correct.length()];
		StringBuilder build = new StringBuilder();
		int count = 0;
		
		while (count < correct.length())
		{
			Random randIndex = new Random();
			int index = randIndex.nextInt(correct.length());
			if (used[index]==false)
			{
				build.append(correct.charAt(index));
				used[index] = true;
				count += 1;
			}
		}
		System.out.println(build);
		String guess = "na";
		int count2 = 0;
		do
		{
			System.out.print("Guess a word: ");
			guess = s.nextLine();
			count2 += 1;
			if (!guess.equals(correct))
			{
				System.out.println("Wrong! Try Again.");
			}
		}while(!guess.equals(correct));
		System.out.print("You guessed the correct word! It took you " + count2 + " attempts.");
		
		
		
		
		
		
	}
}