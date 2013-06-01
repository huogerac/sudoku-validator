package com.bc;


public class SudokuCore {
	
	private enum Direction { LINE, COLUMN } 

	private String[] numbers;
	
	public boolean validate(String input) {

		numbers = input.split(" ");

		if ( !validateFrom(Direction.LINE) || !validateFrom(Direction.COLUMN)) {
			return false;
		}
				
		return true;
	}
	
	/**
	 * Validate all items from a @param direction (LINES or COLUMN)  */
	private boolean validateFrom(Direction direction) {
		boolean result = true;
		String[] sequence;

		for (int item=0; item < 9; item++) {
			sequence = new String[] {"0","0","0","0","0","0","0","0","0"};
			
			for (int index=0; index < 9; index++) {
				int number = getNumberFromDirection(direction, item, index);
				sequence[number-1] = String.valueOf(number);
			}
			
			if ( !isSequenceValid(sequence) ) {
				result = false;
				break;
			}
		}
		return result;
	}
	
	
	/**
	 * -------------LINE
	 *  Item 0, index 0 to 8
	 *  x x x x x x x x x
	 * "7 5 1 8 4 3 9 6 6 | 8 9 3 6 2 5 1 7 4 | 6 4 2 1 7 9 5 8 3 | 4 2 5 3 1 6 7 9 8 | ..." 
     *
	 *  Item 1, index 0 to 8
	 *                      x x x x x x x x x
	 * "7 5 1 8 4 3 9 6 6 | 8 9 3 6 2 5 1 7 4 | 6 4 2 1 7 9 5 8 3 | 4 2 5 3 1 6 7 9 8 | ..." 
	 * 
	 * -------------COLUMN
	 *  Item 0, index 0 to 8
	 *  x                   x                   x                   x                   x
	 * "7 5 1 8 4 3 9 6 6 | 8 9 3 6 2 5 1 7 4 | 6 4 2 1 7 9 5 8 3 | 4 2 5 3 1 6 7 9 8 | ..." 
	 *
	 *  Item 1, index 0 to 8
	 *    x                   x                   x                   x                  x
	 * "7 5 1 8 4 3 9 6 6 | 8 9 3 6 2 5 1 7 4 | 6 4 2 1 7 9 5 8 3 | 4 2 5 3 1 6 7 9 8 | ..." 
	 * 
	 */
	private int getNumberFromDirection(Direction direction, int item, int index) {
		if (direction.equals(Direction.LINE)) {			
			return Integer.parseInt(numbers[ (item*9) + index]);
		} else {			
			return Integer.parseInt(numbers[ item + 9*index]);
		}
	}
	
	
	/** @return True when the sequence has all numbers from 1 to 9 */
	private boolean isSequenceValid(String[] seq) {
		boolean result = true;
		for (String item: seq) {
			if (item.equals("0")) {
				result = false;
				break;
			}
		}
		return result;
	}

}
