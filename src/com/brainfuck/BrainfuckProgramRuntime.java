package com.brainfuck;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * User: ashuiskov
 * Date: 18/03/2012
 * Time: 16:31
 */
public class BrainfuckProgramRuntime implements ProgramRuntime<BrainfuckRuntimeEnvironment>{
    public BrainfuckRuntimeEnvironment createRuntimeEnvironment() {
        return new BrainfuckRuntimeEnvironment(System.in, System.out);
    }

    public BrainfuckRuntimeEnvironment createRuntimeEnvironment(InputStream in, OutputStream out) {
        return new BrainfuckRuntimeEnvironment(in, out);
    }
}
