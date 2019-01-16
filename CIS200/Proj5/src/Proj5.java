/**
* <Proj5.java>
* <Swapnil Gupta / Thursday 6pm / Atef Khan>
*
* <This file reads a text file of 1's and 0's and then plays the Game of Life with them.>
*/
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Proj5 {
	/**
	* <This is the main method>
	*/
	public static void main(String[] args) throws IOException {
		String fname = "";
		int [][] cells = new int [1][1];
		String board = "";
		int neighbors = 0;
		if (args.length == 0) 
		{ 
			System.out.println("No file was given. Please try again.");
			System.exit(0);
		} 
		else 
		{ 
			fname = args[0];
			cells = readBoard(fname);
		}
		
		do{
		board = boardDisplay(cells);
		try {
			Thread.sleep(500);
			}
			catch (InterruptedException e) {}
		System.out.println(board);
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				neighbors = neighbors(cells, i, j);
				cells[i][j] = update(cells, neighbors, i, j);
			}
		}
		}while(true);
	}
	/**
	* <This method reads the text file and converts into an array>
	*
	* <the parameter 'filename' is used to read the file>
	* <an array of 1's and 0's from the text file is returned>
	*/
	public static int[][] readBoard(String filename) throws IOException {
		Scanner inFile = new Scanner(new File(filename)); //read file
		int numRows = Integer.parseInt(inFile.nextLine()); //set first line in file to rows
		int numCols = Integer.parseInt(inFile.nextLine()); //set second line in file to columns
		int [][] cells = new int [numRows][numCols];
		for (int i = 0; i < numRows; i++) {
			String row = inFile.nextLine();
			for (int j = 0; j < numCols; j++) {
				cells[i][j] = (int)row.charAt(j);
				if(cells[i][j] == 48) cells[i][j] = 0;
					else if (cells[i][j] == 49) cells[i][j] = 1;
			}
		}
		inFile.close();
		return cells;
	}
	/**
	* <This method reads an array of 1's and 0's and converts them into a grid of *'s and .'s>
	*
	* <the parameter 'cells' is an array for this method to read>
	* <A string set up in a grid of alive and dead cells is returned>
	*/
	public static String boardDisplay(int[][] cells){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cells.length; i++) {
			if (i != 0) sb.append("\n");
			for (int j = 0; j < cells[0].length; j++) {
				if(cells[i][j] == 0) sb.append(".");
				else if (cells[i][j] == 1) sb.append("*");
			}
		}
		String board = sb.toString();
		return board;
	}
	/**
	* <This method is used to find how many alive cells neighbor a certain cell>
	*
	* <The parameter 'cells' is used as the grid, 'row' is used as the row of the cell we're checking, 'col' is used as the column of the cell we're checking>
	* <The number of alive cells neighboring the chosen cell is returned>
	*/
	public static int neighbors(int[][] cells, int row, int col){
		int neighbors = 0;
		for (int i = -1; i < 2; i++) {
			if ((row == 0) && (i == -1)) i++;
			
			if((row == cells.length-1)&&(i == 1)) continue;
			
			for (int j = -1; j < 2; j++) {
				if ((col == 0) && (j == -1)) j++;
				
				if((col == cells[0].length-1)&&(j == 1)) continue;
				
				if (i == 0 && j == 0);
				else if (cells[row+i][col+j] == 1) neighbors++;
			}
		}
		return neighbors;
	}
	/**
	* <This method is used to update the grid>
	*
	* <'cells' is the current grid, 'neighbors' is the number of neighboring alive cells, 'row' is used as the row of the cell we're checking, 'col' is used as the column of the cell we're checking >
	* <The new state of the cell is returned>
	*/
	public static int update(int[][] cells, int neighbors, int row, int col){
		int cellsUpdate = 0;
				if(cells[row][col] == 0){
					if (neighbors == 3) cellsUpdate = 1;
					else cellsUpdate = 0;
				}
				else if(cells[row][col] == 1){
					if (neighbors == 3) cellsUpdate = 1;
					else if (neighbors == 2) cellsUpdate = 1;
					else cellsUpdate = 0;
				}
		return cellsUpdate;
	}
}
