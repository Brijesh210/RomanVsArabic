package com.number.view;
import java.util.Scanner;

/**
 * Class performing input/output operations
 *
 * @author Brijesh Varsani
 * @version 1.0
 */
public class View {
    /**
     * Scanner for reading standard input
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     *
     * @param message  printing massage
     */

    public void printMessage(String message){
        System.out.print(message);
    }

    /**
     *
     * @return returning string of massage
     */
    public String getStringInput(){
        if(scanner.hasNextLine()) return scanner.next();
        return "";
    }


    /**
     *
     * @return returning integer of massage, returns -1 when fails to read int
     */
    public int getIntInput(){
        if(scanner.hasNextInt()) return scanner.nextInt();
        clearInput();
        return -1;
    }

    /**
     * Clear the input stream
     */
    public void clearInput(){
        scanner.next();
    }
}
