package com.bc;


public class SudokuCore {
	
	private enum Direction { LINE, COLUMN } 

	private String[] numbers;
	
	public boolean validate(String input) {

		numbers = input.split(" ");

		if ( !validate(Direction.LINE) || !validate(Direction.COLUMN)) {
			return false;
		}
				
		return true;
	}
	
	private boolean validate(Direction direction) {
		boolean result = true;
		String[] sequence;

		for (int item=0; item < 9; item++) {
			sequence = new String[] {"0","0","0","0","0","0","0","0","0"};
			
			for (int index=0; index < 9; index++) {
				int number = Integer.parseInt(numbers[ item + 9*index]);
				if (direction.equals(Direction.LINE)) {
					number = Integer.parseInt(numbers[ (item*9) + index]);
				}
				sequence[number-1] = String.valueOf(number);
			}
			
			if ( !isSequenceValid(sequence) ) {
				result = false;
				break;
			}
		}
		return result;
	}	
	
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
