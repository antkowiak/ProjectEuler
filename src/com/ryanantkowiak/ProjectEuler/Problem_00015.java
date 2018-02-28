package com.ryanantkowiak.ProjectEuler;

/*
Lattice paths
Problem 15 
Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
there are exactly 6 routes to the bottom right corner.

How many such routes are there through a 20×20 grid?
*/

public class Problem_00015
{
	public static long paths(Long[][] board, int row, int col, final int numRows, final int numCols)
	{
		// out of range - no path
		if (row < 0 || col < 0 || row > numRows - 1 || col > numCols - 1)
			return 0L;

		// value already computed, return it
		if (board[row][col] != null)
			return board[row][col];

		// final position has zero paths to go
		if (row == numRows - 1 && col == numCols - 1)
			return board[row][col] = 0L;

		// base case for one move away along the row
		if (row == numRows - 1 && col == numCols - 2)
			return board[row][col] = 1L;

		// base case for one more away along the col
		if (row == numRows - 2 && col == numCols - 1)
			return board[row][col] = 1L;

		// compute recursively and store the value in the board for future use
		return board[row][col] = paths(board, row + 1, col, numRows, numCols)
				+ paths(board, row, col + 1, numRows, numCols);
	}

	public static void main(String[] args)
	{
		System.out.println(paths(new Long[21][21], 0, 0, 21, 21));
	}
}

/*
 * 137846528820
 */
