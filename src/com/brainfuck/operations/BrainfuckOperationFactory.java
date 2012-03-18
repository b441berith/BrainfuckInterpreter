package com.brainfuck.operations;

import java.util.HashMap;
import java.util.Map;

import com.brainfuck.Operation;

/**
 * User: ashuiskov
 * Date: 18/03/2012
 * Time: 16:57
 */
public class BrainfuckOperationFactory {
    private Map<Character, BrainfuckOperation> operationsMap = new HashMap<Character, BrainfuckOperation>()
    {
        {
            put(BrainfuckOperationNames.DECREMENT_CURRENT_DATA_POINTER_CELL_VALUE, new DecrementCurrentDataPointerCellValueOperation());
            put(BrainfuckOperationNames.DECREMENT_DATA_POINTER, new DecrementDataPointerOperation());
            put(BrainfuckOperationNames.END_LOOP, new EndLoopOperation());
            put(BrainfuckOperationNames.INCREMENT_CURRENT_DATA_POINTER_CELL_VALUE, new IncrementCurrentDataPointerCellValueOperation());
            put(BrainfuckOperationNames.INCREMENT_DATA_POINTER, new IncrementDataPointerOperation());
            put(BrainfuckOperationNames.PRINT_CURRENT_DATA_CELL_VAUE, new PrintCurrentDataCellValue());
            put(BrainfuckOperationNames.SET_DATA_CELL_VALUE_FROM_INPUT_STREAM, new SetDataCellValueFromInputStreamOperation());
            put(BrainfuckOperationNames.START_LOOP, new StartLoopOperation());
        }
    };

    public BrainfuckOperation createOperation(char operationCode) {
        if (operationsMap.containsKey(operationCode)) {
            return operationsMap.get(operationCode);
        } else {
            return null;
        }
    }

    public Character getOperatonCode(BrainfuckOperation operation) {
        //TODO improve (bidirectional map?)
        if (operation instanceof  DecrementCurrentDataPointerCellValueOperation) return BrainfuckOperationNames.DECREMENT_CURRENT_DATA_POINTER_CELL_VALUE;
        if (operation instanceof  DecrementDataPointerOperation) return BrainfuckOperationNames.DECREMENT_DATA_POINTER;
        if (operation instanceof  EndLoopOperation) return BrainfuckOperationNames.END_LOOP;
        if (operation instanceof  IncrementDataPointerOperation) return BrainfuckOperationNames.INCREMENT_DATA_POINTER;
        if (operation instanceof  IncrementCurrentDataPointerCellValueOperation) return BrainfuckOperationNames.INCREMENT_CURRENT_DATA_POINTER_CELL_VALUE;
        if (operation instanceof  PrintCurrentDataCellValue) return BrainfuckOperationNames.PRINT_CURRENT_DATA_CELL_VAUE;
        if (operation instanceof  SetDataCellValueFromInputStreamOperation) return BrainfuckOperationNames.SET_DATA_CELL_VALUE_FROM_INPUT_STREAM;
        if (operation instanceof  StartLoopOperation) return BrainfuckOperationNames.START_LOOP;
        return null;
    }
}
