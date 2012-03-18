package com.brainfuck.operations;

import com.brainfuck.BrainfuckRuntimeEnvironment;

/**
 * User: ashuiskov
 * Date: 18/03/2012
 * Time: 15:52
 */
public class IncrementDataPointerOperation implements BrainfuckOperation {
    public void execute(BrainfuckRuntimeEnvironment runtimeEnvironment) {
        runtimeEnvironment.incrementDataPointer();
        runtimeEnvironment.incrementInstructionPointer();
    }
}
