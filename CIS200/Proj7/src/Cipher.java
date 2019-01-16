/**
 * Cipher handles the encryption and decryption of
 * messages according to the four-square cipher algorithm.
 *
 *	@author Swapnil Gupta
 *  @version Project 7
 */
import java.util.ArrayList;

public class Cipher {
	private Square plain1;
	private Square plain2;
	private Square cipher1;
	private Square cipher2;

	/**
	 * Cipher creates the four squares based on
	 * two keys for the four-square cipher algorithm.
	 *
	 * @param key1 The first key (no Q's)
	 * @param key2 The second key (no Q's)
	 */
	public Cipher(String key1, String key2) {
		plain1 = new Square();
		plain2 = new Square(2); 
		cipher1 = new Square(key1);
		cipher2 = new Square(key2);
	} // end 2 arg constructor

	/**
	 * encrypt returns the encrypted message using the
	 * four-square cipher algorithm
	 *
	 * @param message The message to encrypt
	 *
	 * @return The encrypted message
	 */
	public String encrypt(String message) {
		String finalMessage = ""; 
		
		ArrayList<String> encrypt = new ArrayList<String>(); 
		int count = 0; 
		
		while (count < message.length()) { 
			if (message.length()-count != 1) {
				encrypt.add(message.substring(count, count + 2)); 
				count+=2;
			} 
			else { 
				encrypt.add(message.substring(count));
				count++;
			}
		}
		
		for (int i = 0; i < encrypt.size(); i++) { 
			
			char first = encrypt.get(i).charAt(0); 
			char second = '_'; 
			
			if (encrypt.get(i).length() > 1) {
				second = encrypt.get(i).charAt(1);
			}
			
			
			if (first == ' ') first = '_';
			if (second == ' ') second = '_';
			
			int[] firstPosition = plain1.getPos(first);
			int[] secondPosition = plain2.getPos(second);

			char char1 = cipher1.getChar(firstPosition[0], secondPosition[1]);
			char char2 = cipher2.getChar(secondPosition[0], firstPosition[1]);
			
			finalMessage += char1;
			finalMessage += char2;
		}
		return finalMessage;
	} // end encrypt

	/**
	 * decrypt returns the decrypted message using the
	 * four-square cipher algorithm
 	 *
	 * @param message The message to decrypt
	 *
	 * @return The decrypted message
	 */
	public String decrypt(String message) {
		
		String finalMessage = ""; 
		
		message = message.replaceAll("\\s+", "_"); 
		
		ArrayList<String> decrypt = new ArrayList<String>();
		int count = 0;
		
		while (count < message.length()) { 
			if ((message.length())-count != 1) { 
				decrypt.add(message.substring(count, count + 2));
				count+=2;
			} 
			else {
				decrypt.add(message.substring(count));
				count++;
			}
		}
		
		for (int i = 0; i < decrypt.size(); i++) { 
			char first = decrypt.get(i).charAt(0); 
			char second = ' '; 
			
			if (decrypt.get(i).length() > 1) { 
				second = decrypt.get(i).charAt(1);
			}
			
			int[] firstPosition = cipher1.getPos(first);
			int[] secondPosition = cipher2.getPos(second);
			
			char char1 = plain1.getChar(firstPosition[0], secondPosition[1]);
			char char2 = plain2.getChar(secondPosition[0], firstPosition[1]);
			
			if (char1 == '_') char1 = ' ';
			if (char2 == '_') char2 = ' ';
			
			finalMessage += char1;
			finalMessage += char2;
		}
		return finalMessage;
	} // end decrypt
} // end class