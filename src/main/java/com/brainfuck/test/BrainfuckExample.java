package com.brainfuck.test;

import java.io.InputStream;

import com.brainfuck.BrainfuckProgram;
import com.brainfuck.BrainfuckProgramRuntime;
import com.brainfuck.BrainfuckRuntimeEnvironment;
import com.brainfuck.decompiler.BrainfuckDecompiler;
import com.processor.exceptions.DecompilationException;
import com.processor.util.IOUtils;

/**
 * User: ashuiskov
 * Date: 19/03/2012
 * Time: 17:18
 */
public class BrainfuckExample {
    public static void main(String[] args) throws DecompilationException {
        BrainfuckProgramRuntime runtime = new BrainfuckProgramRuntime();
        final String helloWorldText = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++" +
                " .>+.+++++++..+++.>++.<<+++++++++++++++.>.+++." +
                " ------.--------.>+.>.";
        InputStream in = IOUtils.fromString(helloWorldText);
        BrainfuckDecompiler decompiler = new BrainfuckDecompiler();
        BrainfuckProgram program = decompiler.decompile(in);
        BrainfuckRuntimeEnvironment runtimeEnvironment = runtime.createRuntimeEnvironment(program);
        runtimeEnvironment.runProgram();
    }
}
