package com.brainfuck.decompiler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.brainfuck.BrainfuckProgram;
import com.brainfuck.Decompiler;
import com.brainfuck.Operation;
import com.brainfuck.exceptions.DecompilationException;
import com.brainfuck.operations.BrainfuckOperation;
import com.brainfuck.operations.BrainfuckOperationFactory;

/**
 * User: ashuiskov
 * Date: 18/03/2012
 * Time: 16:46
 */
public class BrainfuckDecompiler implements Decompiler<BrainfuckProgram> {
    private BrainfuckOperationFactory operationFactory;

    public BrainfuckDecompiler(BrainfuckOperationFactory operationFactory) {
        this.operationFactory = operationFactory;
    }

    public BrainfuckProgram decompile(InputStream inputStream) throws DecompilationException {
        if (inputStream == null) {
            throw new DecompilationException("Can't decompile from null input stream");
        }
        //assuming program text is enough to fit in memory
        final char[] buffer = new char[0x10000];
        StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(inputStream);
        int read;
        try {
            do {
                read = in.read(buffer, 0, buffer.length);
                if (read > 0) {
                    out.append(buffer, 0, read);
                }

            } while (read >= 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = out.toString();
        List<BrainfuckOperation> operations = new ArrayList<BrainfuckOperation>();
        for (char ch : result.toCharArray()) {
            BrainfuckOperation operation = operationFactory.createOperation(ch);
            if (operation != null) {
                operations.add(operation);
            }
        }
        return new BrainfuckProgram(operations);
    }
}
