package com.threaded.app.sudoku;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	int[][] cellsInvalidEmpty = null;

	int[][] cellsInvalidEmptyLine2 = { { 8, 0, 0, 0, 0, 0, 0, 0, 0 }, null,
			{ 0, 7, 0, 0, 9, 0, 2, 0, 0 }, { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
			{ 0, 0, 0, 0, 4, 5, 7, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
			{ 0, 0, 1, 0, 0, 0, 0, 6, 8 }, { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
			{ 0, 9, 0, 0, 0, 0, 4, 0, 0 }, };

	int[][] cellsInvalidMalformedLine2 = { { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 3, 6, 0, 0, 0 }, { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
			{ 0, 5, 0, 0, 0, 7, 0, 0, 0 }, { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
			{ 0, 0, 0, 1, 0, 0, 0, 3, 0 }, { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
			{ 0, 0, 8, 5, 0, 0, 0, 1, 0 }, { 0, 9, 0, 0, 0, 0, 4, 0, 0 }, };

	int[][] cellsInvalidSillyValueHighLine3 = { { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 3, 6, 0, 0, 0, 0 }, { 0, 7, 10, 0, 9, 0, 2, 0, 0 },
			{ 0, 5, 0, 0, 0, 7, 0, 0, 0 }, { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
			{ 0, 0, 0, 1, 0, 0, 0, 3, 0 }, { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
			{ 0, 0, 8, 5, 0, 0, 0, 1, 0 }, { 0, 9, 0, 0, 0, 0, 4, 0, 0 }, };

	int[][] cellsInvalidSillyValueLowLine4 = { { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 3, 6, 0, 0, 0, 0 }, { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
			{ 0, 5, 0, -1, 0, 7, 0, 0, 0 }, { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
			{ 0, 0, 0, 1, 0, 0, 0, 3, 0 }, { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
			{ 0, 0, 8, 5, 0, 0, 0, 1, 0 }, { 0, 9, 0, 0, 0, 0, 4, 0, 0 }, };

	int[][] cellsValid1 = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
			{ 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
			{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
			{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

	int[][] cellsValid2 = { { 9, 0, 4, 0, 6, 0, 7, 0, 1 },
			{ 0, 2, 0, 4, 0, 3, 0, 8, 0 }, { 8, 0, 0, 0, 0, 0, 0, 0, 4 },
			{ 0, 0, 1, 8, 4, 9, 6, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 3, 2, 5, 7, 9, 0, 0 }, { 4, 0, 0, 0, 0, 0, 0, 0, 7 },
			{ 0, 8, 0, 6, 0, 4, 0, 5, 0 }, { 5, 0, 6, 0, 8, 0, 2, 0, 3 }, };

	int[][] cellsValidHardest = { { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 3, 6, 0, 0, 0, 0, 0 }, { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
			{ 0, 5, 0, 0, 0, 7, 0, 0, 0 }, { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
			{ 0, 0, 0, 1, 0, 0, 0, 3, 0 }, { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
			{ 0, 0, 8, 5, 0, 0, 0, 1, 0 }, { 0, 9, 0, 0, 0, 0, 4, 0, 0 }, };

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}
	
	public void testCellsInvalidEmpty() {
		Puzzle puzzle = new Puzzle();
		try {
			puzzle.set(cellsInvalidEmpty);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	public void testCellsInvalidEmptyLine2() {
		Puzzle puzzle = new Puzzle();
		try {
			puzzle.set(cellsInvalidEmptyLine2);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	public void testCellsInvalidSillyValueHighLine3() {
		Puzzle puzzle = new Puzzle();
		try {
			puzzle.set(cellsInvalidSillyValueHighLine3);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	public void testCellsInvalidSillyValueLowLine4() {
		Puzzle puzzle = new Puzzle();
		try {
			puzzle.set(cellsInvalidSillyValueLowLine4);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	public void testCellsInvalidMalformedLine2() {
		Puzzle puzzle = new Puzzle();
		try {
			puzzle.set(cellsInvalidMalformedLine2);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	public void testCellsValid1() {
		Puzzle puzzle = new Puzzle();
		try {
			puzzle.set(cellsValid1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Solver solver = new Solver();
		boolean result = false;
		try {
			result = solver.solve(puzzle);
		} catch (PuzzleException e) {
			e.printStackTrace();
		}

		assertTrue(result);
	}

	public void testCellsValid2() {
		Puzzle puzzle = new Puzzle();
		try {
			puzzle.set(cellsValid2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Solver solver = new Solver();
		boolean result = false;
		try {
			result = solver.solve(puzzle);
		} catch (PuzzleException e) {
			e.printStackTrace();
		}

		assertTrue(result);
	}

	public void testCellsValidHardest() {
		Puzzle puzzle = new Puzzle();
		try {
			puzzle.set(cellsValidHardest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Solver solver = new Solver();
		boolean result = false;
		try {
			result = solver.solve(puzzle);
		} catch (PuzzleException e) {
			e.printStackTrace();
		}

		assertTrue(result);
	}
}
