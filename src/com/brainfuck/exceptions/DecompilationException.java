package com.brainfuck.exceptions;

/**
 * User: ashuiskov
 * Date: 18/03/2012
 * Time: 16:46
 */
public class DecompilationException extends Exception{
    public DecompilationException() {
    }

    public DecompilationException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DecompilationException(Throwable throwable) {
        super(throwable);
    }

    public DecompilationException(String s) {
        super(s);
    }
}
