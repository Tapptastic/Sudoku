package com.threaded.app.sudoku;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Solver {

	boolean solve(Puzzle puzzle) throws PuzzleException {
		return solve(0, 0, puzzle);
	}

	private boolean solve(int row, int col, Puzzle puzzle) throws PuzzleException {
		if (row == Constants.GRID_SIZE) {
			row = 0;
			col++;
			if (col == Constants.GRID_SIZE)
				return true;
		}

		if (puzzle.get(row, col) != Constants.UNASSIGNED)
			return solve(row + 1, col, puzzle);

		for (int val = 1; val <= Constants.GRID_SIZE; val++) {
			if (isValid(row, col, val, puzzle)) {
				puzzle.set(row, col, val);
				if (solve(row + 1, col, puzzle))
					return true;
			}
		}

		puzzle.set(row, col, Constants.UNASSIGNED); // reset on backtrack

		return false;
	}

	boolean isValid(int row, int col, int val, Puzzle puzzle) {
		for (int q = 0; q < Constants.GRID_SIZE; q++)
			if (val == puzzle.get(q, col))
				return false;

		for (int q = 0; q < Constants.GRID_SIZE; q++)
			if (val == puzzle.get(row, q))
				return false;

		int boxRowOffset = (row / Constants.BLOCK_SIZE) * Constants.BLOCK_SIZE;
		int boxColOffset = (col / Constants.BLOCK_SIZE) * Constants.BLOCK_SIZE;

		for (int q = 0; q < Constants.BLOCK_SIZE; q++)
			for (int m = 0; m < Constants.BLOCK_SIZE; ++m)
				if (val == puzzle.get(boxRowOffset + q, boxColOffset + m))
					return false;

		return true;
	}

	public static void main(String[] args) {

		InputStream is = null;
		if (args.length == 0) // take the standard input
			is = System.in;
		else if (args.length == 1) { // should be a filename
			String fileName = args[0];
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(fileName);
			} catch (FileNotFoundException e) {
				System.out.println("INVALID " + e.getMessage());
				System.exit(1);
			}
			is = fis;
		} else if (args.length > 1) {  // bizarre input
			System.out.println("INVALID too many arguments. Only require one, a filename.");
			System.exit(2);			
		}

		Puzzle puzzle = new Puzzle();
		try {
			puzzle.read(is);
			is.close();
		} catch (Exception e) {
			System.out.println("INVALID " + e.getMessage());
			System.exit(3);
		}

		Solver solver = new Solver();
		boolean solved = false;
		
		try {
			solved = solver.solve(puzzle);
		} catch (PuzzleException e) {
			System.out.println("INVALID " + e.getMessage());
			System.exit(4);
		}
		
		if (!solved) {
			System.out.println("INVALID");
			System.exit(5);
		}

		System.out.println("VALID");
		System.exit(0);
	}
}
