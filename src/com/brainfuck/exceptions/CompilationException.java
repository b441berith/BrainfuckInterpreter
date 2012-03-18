package com.brainfuck.exceptions;

/**
 * User: ashuiskov
 * Date: 18/03/2012
 * Time: 16:46
 */
public class CompilationException extends Exception{
    public CompilationException() {
    }

    public CompilationException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public CompilationException(Throwable throwable) {
        super(throwable);
    }

    public CompilationException(String s) {
        super(s);
    }
}
