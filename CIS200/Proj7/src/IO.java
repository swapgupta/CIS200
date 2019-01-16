/**
 * IO handles all input and output for the
 * four-square encryption algorithm
 *
 *	@author Swapnil Gupta
 *  @version Project 7
 */

import java.util.*;

public class IO {
	private Scanner s;

	/**
	 * IO sets up a new Scanner to System.in
	 */
	public IO() {
		s = new Scanner(System.in);
	}

	/**
	 * firstKey returns the first key from the user
	 *
	 * @return The first key from the user
	 */
	public String firstKey() {
		System.out.print("Enter the first key: "); 
		String firstKey = s.nextLine().toLowerCase(); 
		firstKey = firstKey.replaceAll("\\s+", ""); 
		return firstKey;
	} 

	/**
	 * secondKey returns the second key from the user
	 *
	 * @return The second key from the user
	 */
	public String secondKey() {
		System.out.print("Enter the second key: ");
		String secondKey = s.nextLine().toLowerCase();
		secondKey = secondKey.replaceAll("\\s+", "");
		return secondKey;
	}

	/**
	 * gets and returns whether the user wants to encrypt or decrypt
	 *
	 * @return 'e' for encryption, and 'd' for decryption
	 */
	public char encryptOrDecrypt() {
		System.out.print("Enter (e)ncrypt or (d)ecrypt: "); 
		char choice = s.nextLine().toUpperCase().charAt(0);
		return choice;
	} 

	/**
	 * message returns the message from the user
	 *
	 * @param encrypt True if encrypting, false if decrypting
	 *
	 * @return The message from the user
	 */
	public String message(boolean encrypt) {
		String c = "Decrypt";
		if (encrypt) c = "Encrypt";
		
		System.out.print("Enter the message to " + c + ": ");
		String message = s.nextLine();
		return message;
	} // end message

	/**
	 * printResults prints the encrypted and decrypted messages
	 *
	 * @param msg The resulting message
	 * @param encrypt True if encrypting, false if decrypting
	 */
	public void printResults(String msg, boolean encrypt) {
		System.out.println();
		if (encrypt) {
			System.out.print("Encypted message: " + msg);
		} 
		else {
			System.out.print("Decrypted message: " + msg);			
		}
	} 

	/*
	 * printError prints an error message (not Used)
	 *
	 * @param err The error message to print
	 */
	public void printError(String err) {
		//System.out.println(err);
	} // end printError

} // end class