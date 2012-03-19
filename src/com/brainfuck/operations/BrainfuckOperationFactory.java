package com.brainfuck.operations;

import java.util.HashMap;
import java.util.Map;

/**
 * User: ashuiskov
 * Date: 18/03/2012
 * Time: 16:57
 */
public class BrainfuckOperationFactory {
    private static final Map<Character, BrainfuckOperation> operationsMap = new HashMap<Character, BrainfuckOperation>()
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

    private static final Map<Class<? extends BrainfuckOperation>, Character> reverseOperationsMap = new HashMap<Class<? extends BrainfuckOperation>, Character>() {
        {
            put(DecrementCurrentDataPointerCellValueOperation.class, BrainfuckOperationNames.DECREMENT_CURRENT_DATA_POINTER_CELL_VALUE);
            put(DecrementDataPointerOperation.class, BrainfuckOperationNames.DECREMENT_DATA_POINTER);
            put(EndLoopOperation.class, BrainfuckOperationNames.END_LOOP);
            put(IncrementCurrentDataPointerCellValueOperation.class, BrainfuckOperationNames.INCREMENT_CURRENT_DATA_POINTER_CELL_VALUE);
            put(IncrementDataPointerOperation.class, BrainfuckOperationNames.INCREMENT_DATA_POINTER);
            put(PrintCurrentDataCellValue.class, BrainfuckOperationNames.PRINT_CURRENT_DATA_CELL_VAUE);
            put(SetDataCellValueFromInputStreamOperation.class, BrainfuckOperationNames.SET_DATA_CELL_VALUE_FROM_INPUT_STREAM);
            put(StartLoopOperation.class, BrainfuckOperationNames.START_LOOP);
        }
    };

    public static final BrainfuckOperation createOperation(char operationCode) {
        if (operationsMap.containsKey(operationCode)) {
            return operationsMap.get(operationCode);
        } else {
            return null;
        }
    }

    public static final Character getOperatonCode(BrainfuckOperation operation) {
        return reverseOperationsMap.get(operation.getClass());
    }
}
