package com.threaded.app.sudoku;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Puzzle {

	public int[][] cells = new int[Constants.GRID_SIZE][Constants.GRID_SIZE];

	// utility to view state
	public void print() {
		for (int i = 0; i < Constants.GRID_SIZE; i++) {
			for (int j = 0; j < Constants.GRID_SIZE; j++)
				System.out.print(cells[i][j] + " ");
			System.out.println();
		}
	}

	// generic getter
	public int get(final int row, final int col) {
		int q = cells[row][col];
		return q;
	}

	// generic setter
	public void set(final int row, final int col, final int value) throws PuzzleException {
		if(value < 0 || value > 9)
			throw new PuzzleException("silly value: " + value + " at: " + row + "," + col);
		cells[row][col] = value;
	}

	// generic setter
	public void set(int[][] someCells) throws Exception {
		if (null == someCells)
			throw new PuzzleException("Array in null");

		if (someCells.length != Constants.GRID_SIZE)
			throw new PuzzleException("Array has wrong length, is: "
					+ someCells.length);

		for (int i = 0; i < Constants.GRID_SIZE; i++) {
			if (null == someCells[i])
				throw new PuzzleException("Empty array at row: " + i);

			if (someCells[i].length != Constants.GRID_SIZE)
				throw new PuzzleException("Row " + i + " has wrong length, is: "
						+ someCells[i].length);
			
			for(int j = 0; j < Constants.GRID_SIZE; j++) {
				int q = someCells[i][j];
				if(q < 0 || q > 9)
					throw new PuzzleException("Some silly value: " + q + " at: " + i + "," + j + " ... rem: count from 0,0");
			}

		}
		cells = someCells;
	}

	// Reads in a puzzle from input
	void read(InputStream is) throws IOException, PuzzleException {		
		Scanner scanner = new Scanner(is);
		scanner.useDelimiter(",");
		for (int i = 0; i < Constants.GRID_SIZE; i++) {
			for (int j = 0; j < Constants.GRID_SIZE; j++) {
				while (scanner.hasNext()) 
				{
					String q = scanner.next();
					q = q.trim();
					int c = Integer.parseInt(q);
					set(i, j, c);
					break;
				}	
			}
		}
	}
}
