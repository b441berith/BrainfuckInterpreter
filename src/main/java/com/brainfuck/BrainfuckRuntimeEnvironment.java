package com.brainfuck;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.brainfuck.operations.BrainfuckOperation;
import com.brainfuck.operations.EndLoopOperation;
import com.brainfuck.operations.StartLoopOperation;
import com.processor.Operation;
import com.processor.RuntimeEnvironment;

/**
 * User: ashuiskov
 * Date: 18/03/2012
 * Time: 16:07
 */
public class BrainfuckRuntimeEnvironment implements RuntimeEnvironment<BrainfuckProgram> {
    private int dataPointer;
    private List<Integer> data;
    private int instructionPointer;
    private InputStream inputStream;
    private OutputStream outputStream;
    private List<BrainfuckOperation> machineOperations;

    public static final int DEFAULT_DATA_SIZE = 10;

    public BrainfuckRuntimeEnvironment(InputStream inputStream, OutputStream outputStream, BrainfuckProgram program) {
        this.dataPointer = 0;
        this.data = new ArrayList<Integer>(DEFAULT_DATA_SIZE);
        for (int i = 0; i < DEFAULT_DATA_SIZE; i++) {
            this.data.add(0);
        }
        this.instructionPointer = 0;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.machineOperations = program.getOperations();
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public int getDataPointerValue() {
        return data.get(dataPointer);
    }

    public void setDataPointerValue(int dataPointerValue) {
        data.set(dataPointer, dataPointerValue);
    }

    public int getDataPointer() {
        return dataPointer;
    }

    public int getInstructionPointer() {
        return instructionPointer;
    }

    public void setInstructionPointer(int instructionPointer) {
        this.instructionPointer = instructionPointer;
    }

    public void incrementInstructionPointer() {
        this.instructionPointer++;
    }

    public void incrementDataPointer() {
        if (dataPointer+1 >= data.size()) {
            data.add(0);
        }
        this.dataPointer++;
    }

    public void decrementInstructionPointer() {
        this.instructionPointer--;
    }

    public void decrementDataPointer() {
        this.dataPointer--;
    }

    public void incrementDataPointerValue() {
        int value = getDataPointerValue();
        setDataPointerValue(++value);
    }

    public void decrementDataPointerValue() {
        int value = getDataPointerValue();
        setDataPointerValue(--value);
    }

    public int getNextEnclosingEndLoopIndex() {
        int balance = 1;
        int pointer = instructionPointer+1;
        while (balance != 0) {
            Operation operation = machineOperations.get(pointer);
            if (operation instanceof EndLoopOperation) {
                balance--;
            } else if (operation instanceof StartLoopOperation) {
                balance++;
            }
            pointer++;
        }
        return pointer;
    }

    public int getPrevEnclosingStartLoopIndex() {
        int balance = -1;
        int pointer = instructionPointer-1;
        while (balance != 0) {
            Operation operation = machineOperations.get(pointer);
            if (operation instanceof EndLoopOperation) {
                balance--;
            } else if (operation instanceof StartLoopOperation) {
                balance++;
            }
            pointer--;
        }
        return pointer;
    }

    public void runProgram() {
        this.instructionPointer = 0;
        while (instructionPointer >= 0 && instructionPointer < machineOperations.size()) {
            Operation<BrainfuckRuntimeEnvironment> operation = machineOperations.get(instructionPointer);
            operation.execute(this);
        }
    }
}
