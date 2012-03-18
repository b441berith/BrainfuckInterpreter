package com.brainfuck;

/**
 * User: ashuiskov
 * Date: 18/03/2012
 * Time: 15:50
 */
public interface Operation<R extends RuntimeEnvironment> {
    public void execute(R runtimeEnvironment);
}
