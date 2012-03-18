package com.brainfuck;

/**
 * User: ashuiskov
 * Date: 18/03/2012
 * Time: 16:05
 */
public interface RuntimeEnvironment<P extends AbstractProgram> {
    public void runProgram(P program);
}
