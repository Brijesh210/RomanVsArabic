package com.number.myexceptions;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * An exception thrown when the roman number is invalid
 *
 * @author Brijesh Varsani
 * @version 1.0
 */
public class RomanDoesNotExist extends Exception {

    /**
     * Constructor with a specific message
     * @param message - exception message
     */
    public RomanDoesNotExist(String message) {
        super(message);
    }
}
