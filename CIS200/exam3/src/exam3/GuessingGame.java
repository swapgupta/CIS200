package exam3;

import java.util.Random;

public class GuessingGame {

	public static void main(String[] args) {
		IO io = new IO();
		
		Random rand = new Random();
		//random.nextInt(max - min + 1) + min
		int correct = rand.nextInt(100) + 1;
		Guesser G = new Guesser(correct);
		
		int guess;
		String result = "";
		do{
			guess = io.getNum();
			result = G.checkGuess();
			io.displayResult(guess, correct, result);
			
		}while("equal" != result);

	}

}
