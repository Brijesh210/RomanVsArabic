package com.number.test;

import java.util.*;

import com.number.model.RomanArabicConverter;
import com.number.myexceptions.RomanDoesNotExist;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Class for testing
 *
 * @author Brijesh Varsani
 * @version 1.0
 * @since 1.0
 */

public class RomanArabicConverterText {

    /**
     * Object to perform tests on
     */
    RomanArabicConverter rac = new RomanArabicConverter();

    /**
     * Method to test romanToArabic
     */
    @Test
    public void testRomanToArabic() {
        String roman = "XVII";
        int arabic = 17;
        assertEquals("Arabic number obtained from conversion is wrong", arabic, rac.romanToArabic(roman));
    }

    /**
     * Method to test arabicToRoman
     */
    @Test
    public void testArabicToRoman() {
        int arabic = 25;
        String roman = "XXV";
        try {
            assertEquals("Roman number obtained by the converter is wrong", roman, rac.arabicToRoman(25));
        } catch (RomanDoesNotExist exception) {

        }
        try {
            rac.arabicToRoman(5000);
            fail("Exception expected");
        } catch (RomanDoesNotExist exception) {
        }
    }

}
