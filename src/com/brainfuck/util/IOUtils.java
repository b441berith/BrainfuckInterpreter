package com.brainfuck.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * User: ashuiskov
 * Date: 19/03/2012
 * Time: 17:23
 */
public class IOUtils {
    public static InputStream fromString(String str) {
        byte[] bytes = str.getBytes();
        return new ByteArrayInputStream(bytes);
    }
}
