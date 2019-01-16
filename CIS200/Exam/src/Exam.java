import java.util.*;
public class Exam {
public static void main(String[] args) {
Scanner s = new Scanner(System.in);
System.out.print("Enter a word: ");
String word = s.nextLine();
String result = "";
for (int i = 0; i < word.length(); i++) {
result += "_";
}
System.out.println("\nCurrent word: " + result);
while (!(result.equals(word))) {
System.out.print("\nGuess a letter: ");
char letter = (s.nextLine()).charAt(0);
boolean contains = false;
for (int i = 0; i < word.length(); i++) {
if (word.charAt(i) == letter) {
contains = true;
result = result.substring(0, i) +
 letter + result.substring(i+1);
}
}
if (contains == true) {
System.out.println("\nCurrent word: " + result);
}
else {
System.out.println("\nLetter is not in the word");
}
}
System.out.println("\nYou guessed it!");
}
}