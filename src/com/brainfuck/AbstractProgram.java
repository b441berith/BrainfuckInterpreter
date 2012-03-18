package com.brainfuck;

import java.util.List;

/**
 * User: ashuiskov
 * Date: 18/03/2012
 * Time: 15:50
 */
public class AbstractProgram<O extends Operation> {
    /**
     * Program may be shown as a list of operations. Loops, changing variables etc are all operations.
     */
    List<O> operations;

    public AbstractProgram(List<O> operations) {
        this.operations = operations;
    }

    public List<O> getOperations() {
        return operations;
    }

    public void setOperations(List<O> operations) {
        this.operations = operations;
    }
}
