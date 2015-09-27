// CS4413 - 850, Summer 2015
// Abdul Wahab
// HW 4, Version 2 (n-Queens Problem)
// used backtracking for figuring out combinations for placing queens in different positions on each board (goes left -> right)
// column oriented 

import java.util.*;
public class NQueens {

	public static void main(String[] args) {
		
		Scanner input= new Scanner(System.in);
		System.out.println("\t================================== N-Queens Problem Solver =======================================");
		
		System.out.println("\n");
		System.out.print("Enter the dimensions for the chessboard: \n");
		n = input.nextInt();
		int[][] chessBoard = new int[n][n];
		if (!SOLVEBOARD(chessBoard, 0)) {
			System.out
					
			.println("No solution can be made from the dimensions entered.");
		}
		
		PRINTBOARD(chessBoard);
		
	}

	public static int n = 0;
	public static void PRINTBOARD(int chessBoard[][]) { // prints the board

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				if (chessBoard[i][j] == 1) {
					System.out.print("QUEEN\t");
				} else {
					
					System.out.print("----\t");
				}
			System.out.println("\n");
		}
	}
      public static boolean CHECKBOARD(int chessBoard[][], int r, int c) { // checks to see if the board can place n-queens, based on the dimensions eneterd
		for (int i = 0; i < c; i++) {
			if (chessBoard[r][i] == 1)
				return false;
			    //break;
		}
		for (int i = r, j = c; (j > 0 || j == 0) && i < n; i++, j--) { // most important fucntion of the CHECKBOARD() method.
			if (chessBoard[i][j] == 1) 
				return false;
		}
		for (int i = r, j = c; (i > 0 || i == 0) && (j > 0 || j == 0); i--, j--) {
			if (chessBoard[i][j] == 1)
				return false;
		}
		
		return true;
	}
     public static boolean SOLVEBOARD(int chessBoard[][], int c) { // solves the board by adding every new queen to the next column, that way, no queen cliides with the other. 
		if (c > n || c == n)
			return true;
		for (int i = 0; i < n; i++) {
			if (CHECKBOARD(chessBoard, i, c)) {
				chessBoard[i][c] = 1;
				if (SOLVEBOARD(chessBoard, c + 1))
					return true;

				chessBoard[i][c] = 0;
			}
		}
		return false;
	}

}
