package com.brainfuck.compiler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.brainfuck.BrainfuckProgram;
import com.processor.exceptions.CompilationException;
import com.brainfuck.operations.BrainfuckOperation;
import com.brainfuck.operations.BrainfuckOperationFactory;

/**
 * User: ashuiskov
 * Date: 18/03/2012
 * Time: 17:17
 */
public class BrainfuckCompiler implements com.processor.Compiler<BrainfuckProgram> {
    private BrainfuckOperationFactory operationFactory;

    public BrainfuckCompiler(BrainfuckOperationFactory operationFactory) {
        this.operationFactory = operationFactory;
    }

    public void compile(OutputStream outputStream, BrainfuckProgram program) throws CompilationException {
        if (outputStream == null || program == null || program.getOperations() == null || program.getOperations().isEmpty()) {
            return;
        }
        List<BrainfuckOperation> operations = program.getOperations();

        try {
            for (BrainfuckOperation operation : operations) {
                outputStream.write(operationFactory.getOperatonCode(operation));
            }
        } catch (IOException e) {
            throw new CompilationException("Error while writing to output stream");
        }
    }
}
