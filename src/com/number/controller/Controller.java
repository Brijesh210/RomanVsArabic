package com.number.controller;


import com.number.model.RomanArabicConverter;
import com.number.myexceptions.RomanDoesNotExist;
import com.number.view.View;

import java.util.Arrays;

/**
 * Class responsible for controlling View and Model functions
 *
 * @author Brijesh Varsani
 * @version 1.0
 * @since 1.0
 */
public class Controller {
    /**
     * View class object that controls IO stream
     */
    private View view;
    /**
     * Model class object, used to perform conversions
     */
    private RomanArabicConverter romanToInteger;

    /**
     * Constructor initializing class fields
     *
     * @param view           works as com.number.view , to print and get data
     * @param romanToInteger works as a model
     */
    public Controller(View view, RomanArabicConverter romanToInteger) {
        this.view = view;
        this.romanToInteger = romanToInteger;
    }

    /**
     * Method that controls execution of the program
     * And runs arabicToRoman, romanToArabic or default converter methods depending on the arg
     *
     * @param args  - String of args passed in the main method, to choose between converters
     */
    public void runConverter(String[] args){
        if(args.length > 0){
            //arabic to roman
            if(args[0].equals("1")){
                convertFromArabicToRoman();
            }
            //roman to arabic
            else if(args[0].equals("2")){
                convertFromRomanToArabic();
            }
            //default wrong argument
            else {
                convertByDefault();
            }
            //default no argument
        }else {

            convertByDefault();
        }
    }

    /**
     * Method that prints the result of conversion
     * from Roman number to Arabic
     */
    public void convertFromRomanToArabic() {
        view.printMessage("Enter roman number pls: ");
        view.printMessage("" + romanToInteger.romanToArabic(view.getStringInput()));

    }

    /**
     * Method that prints the result of conversion
     * from Arabic number to Roman
     */
    public void convertFromArabicToRoman() {
        view.printMessage("Enter arabic number pls or '0' to quit: ");
        boolean quit = false;
        while (!quit) {

            int input = view.getIntInput();
            if (input == 0) {
                view.printMessage("Bye-bye");
                quit = true;
            } else if(input== -1) {     // -1 means failure to read input
                view.clearInput();      // clean the input buffer
                view.printMessage("Wrong input!!Try again");
            } else {
                try {
                    view.printMessage(romanToInteger.arabicToRoman(input));
                    quit = true;
                } catch (RomanDoesNotExist e) {
                    view.printMessage(e.getMessage());
                    quit = true;
                } catch (Exception e) {
                    view.printMessage(e.getMessage());
                    quit = true;
                }
            }
        }
    }

    /**
     *
     * Runs when no arguments were given when running the application
     * The method runs any of the converter programs depending on user input choice
     *
     */
    public void convertByDefault(){
        view.printMessage("Press 1 to convert from roman to arabic, "+
                "\nor 2 to convert from arabic to roman or anything else to exit:");
        int choise = view.getIntInput();

        if(choise == 1){
            convertFromRomanToArabic();
        }else if(choise == 2){
            convertFromArabicToRoman();
        }else{ view.printMessage("Bye-bye");
        }
    }
}
