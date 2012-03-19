package com.brainfuck;

/**
 * User: ashuiskov
 * Date: 18/03/2012
 * Time: 16:05
 */
public interface ProgramRuntime<R extends RuntimeEnvironment, P extends AbstractProgram> {
    public R createRuntimeEnvironment(P program);
}
