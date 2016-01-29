/*
 * SudokuSolver.java
 * This sudoku solver will generate a solution to any valid sudoku puzzle
 *
 * @author Kevin Tone
 */

import java.util.Scanner;
import java.util.ArrayList;

public class SudokuSolver {
	
	private int boardArray[][];
	private Scanner scan;
		
	public SudokuSolver()	{
		//Initialize the board
		boardArray = new int[9][9];
		scan = new Scanner(System.in);
		
		//Get the user input
		getBoard();
		//Print the user inputted board
		printBoard();
		solveSudoku();
		System.out.println("Solution: ");
		printBoard();
	}
	
	public void getBoard() {
		System.out.println("Please enter the board left to right");
		System.out.println("The number 0 represents an empty block");
		System.out.println("Each line should have 9 characters");

		for (int i = 0; i < 9; i++) {
			String input = scan.nextLine();
			
			//If line != 9 --> wrongly entered and reinput line
			if (input.length() != 9) {
				System.out.println("Please enter a valid line");
				//Decrement i to re-enter the line
				i = i-1;
			} else {
				for (int j = 0; j < 9; j++) {
					boardArray[i][j] = Character.getNumericValue(input.charAt(j));
				}
			}
		}
	}

	public void printBoard() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(boardArray[i][j] + "|");
			}
			System.out.println();
		}
	}

	
	public boolean checkCompleted() {
		for (int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if (boardArray[i][j] == 0) {
					return false;
				}
			}
		}

		return true;

	}
	
	/*public boolean checkValid()
	{
		if(checkColumn() && checkRow() && checkSquare())
		{
			return true;
		} 

		return false;
	}*/

	public boolean checkColumn() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				for (int k = j+1; k < 9; k++) {
					if(boardArray[i][j] != 0 && boardArray[i][j] != boardArray[i][k]) {
						return false;
					}
				}
			}
		}

		return true;
	}

	public boolean checkRow() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				for (int k = j+1; j<9; j++) {
					if (boardArray[j][i] !=0 && boardArray[j][i] != boardArray[k][i]) {
						return false;
					}
				}
			}
		}

		return true;
	}
	

	/*
	* The checkSquare method will check if the move was valid or not
	* given the row and column of the square its working on
	*/
	public boolean checkSquare(int numRow, int numCol) {
		int row = (numRow / 3) * 3;
		int col = (numCol / 3) * 3;
		
		System.out.println("Row: " + row);
		System.out.println("Col: " + col);
	
		ArrayList<Integer> duplicateCheck = new ArrayList<Integer>();

		for(int i = row; i < (row+3); i++) 
		{
			for (int j = col; j < (col+3); j++)
			{
				System.out.println("i: " + i + " j: " + j);
				if (boardArray[i][j] !=0)
				{
					duplicateCheck.add(boardArray[i][j]);
				}
			}
		}
		for(int i = 0; i<duplicateCheck.size(); i++)
		{
			for(int j = i+1; j < duplicateCheck.size(); j++)
			{
				if(duplicateCheck.get(i) == duplicateCheck.get(j))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	
	private boolean solveSudoku() {
		int[] emptyBox = findEmptySpace();
		int row = emptyBox[0];
		int column = emptyBox[1];
		
		if(row == 10)
		{
			System.out.println("Here");
			return false;
		} 

		for(int i = 1; i < 10; i++)
		{
			System.out.println("Here");
			boardArray[row][column] = i;

			System.out.println("checkRow: " + checkRow());
			System.out.println("checkColumn: " + checkColumn());
			System.out.println("checkSquare: " + checkSquare(row,column));
			if(checkRow() && checkColumn() && checkSquare(row,column))
			{
				printBoard();
				if(solveSudoku())
				{
					return true;
				}
			}
		}
		
		boardArray[row][column] = 0;
		return false;
	}

	private int[] findEmptySpace()
	{
		for(int i = 0; i < 9; i ++)
		{
			for(int j = 0; j < 9; j++)
			{
				if (boardArray[i][j] == 0)
				{
					return new int[] {i, j};
				}
			}
		}
		return new int[] {10,10};
	}
		
	public static void main(String[] args) {
		SudokuSolver sudoku = new SudokuSolver();
	}
}


