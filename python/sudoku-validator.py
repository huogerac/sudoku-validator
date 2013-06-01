# coding: utf-8
"""
Sudoku validator

    >>> sudoku1_valid = [(7, 5, 1, 8, 4, 3, 9, 2, 6), \
                         (8, 9, 3, 6, 2, 5, 1, 7, 4), \
                         (6, 4, 2, 1, 7, 9, 5, 8, 3), \
                         (4, 2, 5, 3, 1, 6, 7, 9, 8), \
                         (1, 7, 6, 9, 8, 2, 3, 4, 5), \
                         (9, 3, 8, 7, 5, 4, 6, 1, 2), \
                         (3, 6, 4, 2, 9, 7, 8, 5, 1), \
                         (2, 8, 9, 5, 3, 1, 4, 6, 7), \
                         (5, 1, 7, 4, 6, 8, 2, 3, 9)]
    >>> validate(sudoku1_valid)
    True

		                                       Problem
		                                         |  |
    >>> sudoku2_invalid = [(7, 5, 1, 8, 4, 3, 9, 6, 6), \
                           (8, 9, 3, 6, 2, 5, 1, 7, 4), \
                           (6, 4, 2, 1, 7, 9, 5, 8, 3), \
                           (4, 2, 5, 3, 1, 6, 7, 9, 8), \
                           (1, 7, 6, 9, 8, 2, 3, 4, 5), \
                           (9, 3, 8, 7, 5, 4, 6, 1, 2), \
                           (3, 6, 4, 2, 9, 7, 8, 5, 1), \
                           (2, 8, 9, 5, 3, 1, 4, 6, 7), \
                           (5, 1, 7, 4, 6, 8, 2, 3, 9)]
    >>> validate(sudoku2_invalid)
    False

                         Problem
                            |
    >>> sudoku3_invalid = [(8, 5, 1, 8, 4, 3, 9, 2, 6), \
                           (8, 9, 3, 6, 2, 5, 1, 7, 4), \
                           (6, 4, 2, 1, 7, 9, 5, 8, 3), \
                           (4, 2, 5, 3, 1, 6, 7, 9, 8), \
                           (1, 7, 6, 9, 8, 2, 3, 4, 5), \
                           (9, 3, 8, 7, 5, 4, 6, 1, 2), \
                           (3, 6, 4, 2, 9, 7, 8, 5, 1), \
                           (2, 8, 9, 5, 3, 1, 4, 6, 7), \
                           (5, 1, 7, 4, 6, 8, 2, 3, 9)]
    >>> validate(sudoku3_invalid)
    False

                            Problem
                               |
    >>> sudoku4_invalid = [(7, 5, 1, 8, 4, 3, 9, 2, 6), \
                           (8, 8, 3, 6, 2, 5, 1, 7, 4), \
                           (6, 4, 2, 1, 7, 9, 5, 8, 3), \
                           (4, 2, 5, 3, 1, 6, 7, 9, 8), \
                           (1, 7, 6, 9, 8, 2, 3, 4, 5), \
                           (9, 3, 8, 7, 5, 4, 6, 1, 2), \
                           (3, 6, 4, 2, 9, 7, 8, 5, 1), \
                           (2, 8, 9, 5, 3, 1, 4, 6, 7), \
                           (5, 1, 7, 4, 6, 8, 2, 3, 9)]
    >>> validate(sudoku4_invalid)
    False

"""

def validate(sudoku):
    ''' sudoku validator '''
    
    for item in range(9):
        current_line = sudoku[item]
        current_column = [(col[item]) for col in sudoku]
        
        line_validated = validate_numbers( current_line )
        col_validated = validate_numbers( current_column )
        
        validated = line_validated and col_validated
        if not validated:
            break

    return validated

def validate_numbers(numbers):
    ''' return True if there are all 1 to 9 numbers without repetition '''
    sequence = [0, 0, 0, 0, 0, 0, 0, 0, 0]
    for number in numbers:
        sequence[number-1] = number
    return 0 not in sequence

    
