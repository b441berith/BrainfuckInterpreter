package com.brainfuck.operations;

/**
 * User: ashuiskov
 * Date: 18/03/2012
 * Time: 15:59
 */
public interface BrainfuckOperationNames {
    public static final char DECREMENT_CURRENT_DATA_POINTER_CELL_VALUE = '-';
    public static final char INCREMENT_CURRENT_DATA_POINTER_CELL_VALUE = '+';
    public static final char DECREMENT_DATA_POINTER = '<';
    public static final char INCREMENT_DATA_POINTER = '>';
    public static final char PRINT_CURRENT_DATA_CELL_VAUE = '.';
    public static final char SET_DATA_CELL_VALUE_FROM_INPUT_STREAM = ',';
    public static final char START_LOOP = '[';
    public static final char END_LOOP = ']';
}
