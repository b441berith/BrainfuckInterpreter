package com.brainfuck.operations;

import com.brainfuck.BrainfuckRuntimeEnvironment;

/**
 * User: ashuiskov
 * Date: 18/03/2012
 * Time: 15:54
 */
public class DecrementDataPointerOperation implements BrainfuckOperation {
    public void execute(BrainfuckRuntimeEnvironment runtimeEnvironment) {
        runtimeEnvironment.decrementDataPointer();
        runtimeEnvironment.incrementInstructionPointer();
    }
}