package com.number.main;


import com.number.model.RomanArabicConverter;
import com.number.controller.Controller;
import com.number.view.View;

/**
 * Main class for executing program
 *
 * @author Brijesh Varsani
 * @version 1.0
 */

public class Main {
    /**
     * Main method of the program
     *
     * @param args option, for args[0]. if
     */
    public static void main(String[] args) {
        RomanArabicConverter romanToInteger = new RomanArabicConverter();

        View view = new View();

        Controller controller = new Controller(view, romanToInteger);

        controller.runConverter(args);
    }
}
