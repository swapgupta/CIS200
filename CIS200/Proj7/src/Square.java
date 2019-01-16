/**
 * Square represents one of the squares in the four-square
 * cipher algorithm.
 *
 *	@author Swapnil Gupta
 *  @version Project 7
 */

public class Square {
	private char[][] matrix;

	/**
	 * Square constructs a matrix with 
	 * the letters a-z, then the characters 
	 * _, |, }, ~, , and ?, then A-Z, then 
	 * the characters _, |, }, ~, , and ?.
	 * '_' is used instead of space.
	 */
	public Square() {
		matrix = new char[8][8]; 
		
		int count = 0; 
		char a = 'a'; 
		for (int i = 0; i < matrix.length/2; i++) 
		{
			for (int j = 0; j < matrix[i].length; j++) 
			{
				if (count == 26) matrix[i][j] = '_'; 
				else matrix[i][j] = (char) (a + count); 
				count++; 
			}
		}
		for (int i = 0; i < matrix.length/2; i++) 
		{ 
			for (int j = 0; j < matrix[i].length; j++) 
			{ 
				matrix[i + (matrix.length/2)][j] = Character.toUpperCase(matrix[i][j]); 
			}
		}
	} 

	private int keyRow; 
	private int keyCol;
	/**
	 * Square first puts the characters from key into
	 * the matrix, and then fills the matrix with the remaining
	 * letters.
	 *
	 * @param key One of the encryption keys
	 */
	public Square(String key) {
		matrix = new char[8][8]; 
		key = removeDups(key); 
		key = key.replace("\\s+", "_"); 
		int tempLength = key.length(); 
		this.keyRow = 1;
		while (true) { 
			if (tempLength - matrix[0].length > 0) { 
				tempLength -= matrix[0].length; 
				this.keyRow++; 
			} 
			else {
				break; 
			}
		}
		keyCol = tempLength; 
		int tempCol = keyCol; 
		int count = key.length() - 1; 
		for (int i = this.keyRow-1; i >= 0; i--) {
			for (int j = tempCol-1; j >= 0; j--) {
				matrix[i][j] = key.charAt(count--); 
			}
			tempCol = matrix[0].length; 
		}
		char[][] m1 = makeAlphaMatrix('a', key); 
		char[][] m2 = makeAlphaMatrix('A', key); 
		
		int offset = this.keyCol; 
		for (int i = this.keyRow - 1; i < m1.length; i++) {
			for (int j = 0 + offset; j < m1[i].length; j++) {
				matrix[i][j] = m1[i-(this.keyRow-1)][j]; 
			}
			offset = 0; 
		}
		for (int i = 0; i < m2.length; i++) {
			for (int j = 0; j < m2[i].length; j++) {
				matrix[m1.length + i][j] = m2[i][j]; 
			}
		}
	} 
	
	/**
	 * Square constructs a matrix with 
	 * the letters A-Z, then the characters 
	 * _, |, }, ~, , and ?, then a-z, then 
	 * the characters _, |, }, ~, , and ?.
	 * '_' is used instead of space.
	 * This construct is used for plain2
	 * 
	 * @param It's just a way to have two different 
	 * matrixes for plain1 and plain2
	 */
	public Square(int plain2) {
		matrix = new char[8][8];
		
		int count = 0; 
		char a = 'A'; 
		for (int i = 0; i < matrix.length/2; i++) { 
			for (int j = 0; j < matrix[i].length; j++) { 
				if (count == 26) matrix[i][j] = '_'; 
				else matrix[i][j] = (char) (a + count);
				count++;
			}
		}
		for (int i = 0; i < matrix.length/2; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i + (matrix.length/2)][j] = Character.toLowerCase(matrix[i][j]); 
			}
		}
	}
	
	/**
	 * Make AlphaMatrix is used to make a 
	 * matrix with the key at the beginning 
	 * of the matrix
	 * 
	 * @param key One of the encryption keys
	 * @param startLetter Letter to start checking for the key
	 * 
	 * @return tempMatrix a temporary matrix to add the key to
	 */
	private char[][] makeAlphaMatrix(char startLetter, String key) {
		char[][] tempMatrix = new char[matrix.length/2][matrix[1].length]; 
		int offset2;
		int row;
		
		if (startLetter == 'a') {
			offset2 = this.keyCol;
			row = this.keyRow - 1; 
		} 
		else {                   
			offset2 = 0;		   
			row = 0;			   
		}
		
		int count = 0; 
		for (int i = 0; i < tempMatrix.length - row; i++) {
			for (int j = 0 + offset2; j < tempMatrix[i].length; j++) {
				if (!strContains(key, (char) (startLetter + count))) { 
					tempMatrix[i][j] = (char) (startLetter + count); 
					count++; 
				} 
				else {
					count++;
					j--; 
				}
			}
			offset2 = 0; 
		}
		return tempMatrix;
	}

	/**
	 * getChar returns the character at a given
	 * row and column in the matrix.
	 *
	 * @param row The row to look in
	 * @param col The column to look in
	 *
	 * @return The character at (row, col)
	 */
	public char getChar(int row, int col) {
		return matrix[row][col];
	} // end getChar

	/**
	 * getPos returns the [row,col] position
	 * of the given character.
	 *
	 * @param c The character to look for
	 *
	 * @return A 1D array holding the row and col of c stored in [0] and [1]
	 */
	public int[] getPos(char c) {
		int[] pos = new int[2]; 
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == c) { 
					pos[0] = i;
					pos[1] = j;
					return pos;
				}
			}
		}
		// character not found
		pos[0] = -1;
		pos[1] = -1;
		return pos;	 
	} // end getPos

	/**
	 * strContains returns whether the given string
	 * contains the given character
	 *
	 * @param str The string to search
	 * @param c The character to search for
	 *
	 * @return true if c is in str else false
	 */
	private boolean strContains(String str, char c) {
		return str.contains(Character.toString(c));
	} // end strContains
	
	/*
	 * removeDups removes all duplicate characters
	 * from the string
	 *
	 * @param key The string to remove duplicates from
	 *
	 * @return The string with all duplicates removed
	 */
	private String removeDups(String key) {
		String tempKey = "";
		for (int i = 0; i < key.length(); i++) {
			if (!tempKey.contains(String.valueOf(key.charAt(i)))) {
				tempKey += String.valueOf(key.charAt(i));
			}
		}
		return tempKey;
	} // end removeDups	

} // end class