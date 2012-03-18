package com.brainfuck.operations;

import java.io.IOException;
import java.io.OutputStream;

import com.brainfuck.BrainfuckRuntimeEnvironment;

/**
 * User: ashuiskov
 * Date: 18/03/2012
 * Time: 15:54
 */
public class PrintCurrentDataCellValue implements BrainfuckOperation {
    public void execute(BrainfuckRuntimeEnvironment runtimeEnvironment) {
        final OutputStream outputStream = runtimeEnvironment.getOutputStream();
        if (outputStream != null) {
            try {
                outputStream.write(runtimeEnvironment.getDataPointerValue());
            } catch (IOException e) {
                throw new RuntimeException("Can't write to output stream");
            }
        }
        runtimeEnvironment.incrementInstructionPointer();
    }
}