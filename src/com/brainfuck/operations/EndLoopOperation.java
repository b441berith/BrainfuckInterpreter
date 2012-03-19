package com.brainfuck.operations;

import com.brainfuck.BrainfuckRuntimeEnvironment;

/**
 * User: ashuiskov
 * Date: 18/03/2012
 * Time: 15:56
 */
public class EndLoopOperation implements BrainfuckOperation {
    public void execute(BrainfuckRuntimeEnvironment runtimeEnvironment) {
        int dataPointerValue = runtimeEnvironment.getDataPointerValue();
        if (dataPointerValue != 0) {
            int instructionPointer = runtimeEnvironment.getPrevEnclosingStartLoopIndex();
            instructionPointer++;
            runtimeEnvironment.setInstructionPointer(instructionPointer);
        } else {
            runtimeEnvironment.incrementInstructionPointer();
        }
    }
}