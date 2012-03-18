package com.brainfuck;

import java.util.List;

import com.brainfuck.operations.BrainfuckOperation;

/**
 * User: ashuiskov
 * Date: 18/03/2012
 * Time: 15:51
 */
public class BrainfuckProgram extends AbstractProgram<BrainfuckOperation> {

    public BrainfuckProgram(List<BrainfuckOperation> operations) {
        super(operations);
    }
}
