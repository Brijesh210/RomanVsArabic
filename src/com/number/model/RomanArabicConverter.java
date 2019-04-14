package com.number.model;

import com.number.myexceptions.RomanDoesNotExist;
import java.util.*;
/**
 * Conversion between Arabic and Roman number and vice versa
 *
 * @author Brijesh Varsani
 * @version 1.0
 */
public class RomanArabicConverter {
    /**
     * Convert roman  to arabic number
     *
     * @param s String to convert
     * @return int result of conversion
     */
    public int romanToArabic(String s) {
        if (s == null) {
            return 0;
        }
        int length = s.length();
        int sum = 0;
        int pre = 0;

        for (int i = length - 1; i >= 0; i--) {
            int cur = romanTable(s.charAt(i));

            if (i == length - 1) {
                sum = sum + cur;
            } else {
                if (cur < pre) {
                    sum = sum - cur;
                } else {
                    sum = sum + cur;
                }
            }
            pre = cur;
        }
        return sum;
    }

    /**
     * Take char of Roman number and convert to Integer
     *
     * @param c char to integer converter
     * @return int return int from char
     */
    private int romanTable(char c) {
        int num = 0;
        switch (c) {
            case 'I':
                num = 1;
                break;
            case 'V':
                num = 5;
                break;
            case 'X':
                num = 10;
                break;
            case 'L':
                num = 50;
                break;
            case 'C':
                num = 100;
                break;
            case 'D':
                num = 500;
                break;
            case 'M':
                num = 1000;
                break;
            default:
                num = 0;
                break;
        }
        return num;
    }

    /**
     * Convert arabic number to Roman String
     *
     * @param number Get number and converts into String
     * @return String return string as roman number
     */
    public String arabicToRoman(int number) throws RomanDoesNotExist {
        if (number > 4000) {
            throw new RomanDoesNotExist("No roman number over 4000 exist.");
        }
        StringBuilder sb = new StringBuilder();
        int times = 0;

        HashMap<Integer,String> arabicVsRoman  = intializeArabicVsRomanTable();

        ArrayList<Integer> keys = new ArrayList<>(arabicVsRoman.keySet());    //Collection without array
        Collections.sort(keys,Collections.reverseOrder());

        for (Integer i:                                                       // for-each Loop
                keys) {
            times = number / i;
            number %= i;
            while(times > 0){
                sb.append(arabicVsRoman.get(i));
                times--;
            }
        }
        return sb.toString();
    }

    /**
     * Initializing the map with respective values
     * Arabic number as a key, roman as a value
     * @return a map with initialized values from 1 - 1000
     */
    public HashMap<Integer,String> intializeArabicVsRomanTable(){
        HashMap<Integer,String> arabicVsRoman = new HashMap<>();
        arabicVsRoman.put(1000,"M");
        arabicVsRoman.put(900,"CM");
        arabicVsRoman.put(500,"D");
        arabicVsRoman.put(400,"CD");
        arabicVsRoman.put(100,"C");
        arabicVsRoman.put(90,"XC");
        arabicVsRoman.put(50,"L");
        arabicVsRoman.put(40,"XL");
        arabicVsRoman.put(10,"X");
        arabicVsRoman.put(9,"IX");
        arabicVsRoman.put(5,"V");
        arabicVsRoman.put(4,"IV");
        arabicVsRoman.put(1,"I");
        return arabicVsRoman;
    }
}
