package com.bc;

import static org.junit.Assert.*;

import org.junit.Test;

public class Validator {
	
	
	/** A valid answer */
	@Test public void validateACorrectSudokuAnswer() {
		
		SudokuCore s = new SudokuCore();
		
		String input =  "7 5 1 8 4 3 9 2 6 " +
						"8 9 3 6 2 5 1 7 4 " + 
						"6 4 2 1 7 9 5 8 3 " +
						"4 2 5 3 1 6 7 9 8 " +
						"1 7 6 9 8 2 3 4 5 " +
						"9 3 8 7 5 4 6 1 2 " +
						"3 6 4 2 9 7 8 5 1 " +
						"2 8 9 5 3 1 4 6 7 " +
						"5 1 7 4 6 8 2 3 9";
		
		boolean result = s.validate(input);
		
		assertTrue(result);
		
	}
	
	/** Duplicated number */
	@Test public void validateDuplicatedLineNumber() {
		
		SudokuCore s = new SudokuCore();
		
		//                           Problem
		//                             | |
		String input =  "7 5 1 8 4 3 9 6 6 " +
						"8 9 3 6 2 5 1 7 4 " + 
						"6 4 2 1 7 9 5 8 3 " +
						"4 2 5 3 1 6 7 9 8 " +
						"1 7 6 9 8 2 3 4 5 " +
						"9 3 8 7 5 4 6 1 2 " +
						"3 6 4 2 9 7 8 5 1 " +
						"2 8 9 5 3 1 4 6 7 " +
						"5 1 7 4 6 8 2 3 9";
		
		boolean result = s.validate(input);
		
		assertFalse(result);
		
	}
	
	/** Duplicated number with the same total */ 
	@Test public void validateDoubleDuplicateNumberInSameLine() {
		
		SudokuCore s = new SudokuCore();
		
		//               Problem
		//                 |       |   | |
		String input =  "7 5 1 8 4 3 9 3 5 " +
						"8 9 3 6 2 5 1 7 4 " + 
						"6 4 2 1 7 9 5 8 3 " +
						"4 2 5 3 1 6 7 9 8 " +
						"1 7 6 9 8 2 3 4 5 " +
						"9 3 8 7 5 4 6 1 2 " +
						"3 6 4 2 9 7 8 5 1 " +
						"2 8 9 5 3 1 4 6 7 " +
						"5 1 7 4 6 8 2 3 9";
		
		boolean result = s.validate(input);
		
		assertFalse(result);
	}
	
	/** Duplicated number in the same column */
	@Test public void validateDuplicatedColumnNumber() {
		
		SudokuCore s = new SudokuCore();
		
		//             Problem 
		//               |     
		String input =  "8 5 1 7 4 3 9 2 6 " +
						"8 9 3 6 2 5 1 7 4 " + 
						"6 4 2 1 7 9 5 8 3 " +
						"4 2 5 3 1 6 7 9 8 " +
						"1 7 6 9 8 2 3 4 5 " +
						"9 3 8 7 5 4 6 1 2 " +
						"3 6 4 2 9 7 8 5 1 " +
						"2 8 9 5 3 1 4 6 7 " +
						"5 1 7 4 6 8 2 3 9";
		
		boolean result = s.validate(input);
		
		assertFalse(result);
	}	
	
	/** Double Duplicated number in the same column */
	@Test public void validateDuplicatedColumnNumber2() {
		
		SudokuCore s = new SudokuCore();
		
		//              Problem 
		//                 |     
		String input =  "7 5 1 8 4 3 9 2 6 " +
						"8 8 3 6 2 5 1 7 4 " + 
						"6 4 2 1 7 9 5 8 3 " +
						"4 2 5 3 1 6 7 9 8 " +
						"1 7 6 9 8 2 3 4 5 " +
						"9 4 8 7 5 4 6 1 2 " +
						"3 6 4 2 9 7 8 5 1 " +
						"2 8 9 5 3 1 4 6 7 " +
						"5 1 7 4 6 8 2 3 9";
		
		boolean result = s.validate(input);
		
		assertFalse(result);
	}	
	

}
