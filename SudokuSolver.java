/*
 * SudokuSolver.java
 * This sudoku solver will generate a solution to any valid sudoku puzzle
 *
 * @author Kevin Tone
 */

import java.util.Scanner;


public class SudokuSolver {
	
	private int boardArray[][];
	private Scanner scan;
		
	public SudokuSolver()	{
		//Initialize the board
		boardArray = new int[9][9];
		scan = new Scanner(System.in);
	}
	
	public void getBoard() {
		System.out.println("Please enter the board left to right");
		System.out.println("The number 0 represents an empty block");
		System.out.println("Each line should have 9 characters");

		for (int i = 0; i < 9; i++) {
			String input = scan.nextLine();
			System.out.println(input);
			
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
				System.out.print(boardArray[i][j]);
			}
			System.out.println();
		}
	}

}



