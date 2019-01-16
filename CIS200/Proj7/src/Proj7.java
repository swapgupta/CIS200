/**
 * This project implements the four-square cipher, allowing for
 * encryption and decryption.
 * @author Swapnil Gupta
 * @version Project 7
*/

public class Proj7 {
	public static void main(String[] args) {
		IO io = new IO(); 
		String firstKey = io.firstKey();   
		String secondKey = io.secondKey(); 
		
		Cipher cipher = new Cipher(firstKey, secondKey); 	
		
		boolean encrypt;
		char choice = io.encryptOrDecrypt(); 
		if (choice == 'E') {
			encrypt = true;
			io.printResults(cipher.encrypt(io.message(encrypt)), encrypt); 
		} else {
			encrypt = false;
			io.printResults(cipher.decrypt(io.message(encrypt)), encrypt);
		}
 } // end main
} // end class