package com.brainfuck.operations;

import java.io.IOException;
import java.io.InputStream;

import com.brainfuck.BrainfuckRuntimeEnvironment;

/**
 * User: ashuiskov
 * Date: 18/03/2012
 * Time: 15:56
 */
public class SetDataCellValueFromInputStreamOperation implements BrainfuckOperation {
    public void execute(BrainfuckRuntimeEnvironment runtimeEnvironment) {
        final InputStream inputStream = runtimeEnvironment.getInputStream();
        if (inputStream != null) {
            try {
                int value = inputStream.read();
                runtimeEnvironment.setDataPointerValue(value);
            } catch (IOException e) {
                throw new RuntimeException("Can't read from input stream");
            }
        } else {
            throw new RuntimeException("Input stream is null");
        }
        runtimeEnvironment.incrementInstructionPointer();
    }
}