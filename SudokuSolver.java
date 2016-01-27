/*
 * SudokuSolver.java
 * This sudoku solver will generate a solution to any valid sudoku puzzle
 *
 * @author Kevin Tone
 */



public class SudokuSolver() {
	
	private int boardArray[][];
	
		
	public SudokuSolver()	{
		//Initialize the board
		boardArray = new int[9][9];
	}
	
	public void getBoard() {
		
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



