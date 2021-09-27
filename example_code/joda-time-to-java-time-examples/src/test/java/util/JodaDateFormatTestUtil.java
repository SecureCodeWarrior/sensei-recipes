package util;

import org.joda.time.format.DateTimeFormat;
import org.junit.jupiter.api.Assertions;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.UnsupportedTemporalTypeException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JodaDateFormatTestUtil {

    public JodaDateFormatTestUtil() {
        super();
    }

    public static long toLong(ZonedDateTime zdt) {
        return Instant.from(zdt).toEpochMilli();
    }

    public static void testFormatUnsupportedRange(Character jodaCharacter, int minLetters, int maxLetters, String expectedJodaOutput, ZonedDateTime zdt) {

        debugJodaFormat(jodaCharacter, minLetters, maxLetters, zdt);

        for (int numberOfCharacters = minLetters; numberOfCharacters <= maxLetters; numberOfCharacters++) {

            testJodaFormatUnsupported(jodaCharacter,  numberOfCharacters, expectedJodaOutput, zdt);

        }

    }

    public static void testJodaFormatUnsupported(Character jodaCharacter, int numberOfCharacters, String expectedJodaOutput, ZonedDateTime zdt) {

        String jodaPattern = new String(new char[numberOfCharacters]).replace("\0", jodaCharacter.toString());
    }
    public static void jodaDateFormatIsUnsupported(String jodaDateFormat, String expectedJodaOutput, ZonedDateTime zdt) {

        long expectedLong = toLong(zdt);

        String jodaFormatted = formatJoda(jodaDateFormat, expectedLong);
        assertEquals(expectedJodaOutput, jodaFormatted);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String javaFormat = util.JodaDateFormatConverter.convertToJavaTimeDateFormat(jodaDateFormat);
        });

    }

    public static void testJodaFormatRange(Character jodaCharacter, int minLetters, int maxLetters, String expectedJodaOutput, String expectedJavaFormat, String expectedJavaOutput, ZonedDateTime zdt) {

        debugJodaFormat(jodaCharacter, minLetters, maxLetters, zdt);

        for (int numberOfCharacters = minLetters; numberOfCharacters <= maxLetters; numberOfCharacters++) {
            testJodaPatternConversion(jodaCharacter, numberOfCharacters, expectedJodaOutput,expectedJavaFormat,expectedJavaOutput,zdt);
        }

    }


    public static void testJodaPatternConversion(Character jodaCharacter, int numberOfCharacters, String expectedJodaOutput, String expectedJavaDateFormat, String expectedJavaOutput, ZonedDateTime zdt) {

        String jodaDateFormat = new String(new char[numberOfCharacters]).replace("\0", jodaCharacter.toString());

        testJodaPatternConversion(jodaDateFormat,expectedJodaOutput,expectedJavaDateFormat,expectedJavaOutput,zdt);


    }

    // Test a Joda Format Pattern that should operate exactly the same for both Joda and Java
    public static void jodaDateFormatShouldRemainTheSame(String jodaDateFormat, String expectedOutput, ZonedDateTime zdt) {

        testJodaPatternConversion(jodaDateFormat, expectedOutput, jodaDateFormat, expectedOutput, zdt);

    }

    public static void jodaPatternConversionNotStrict(String jodaDateFormat, String expectedJodaOutput, String expectedJavaDateFormat, String expectedJavaOutput, ZonedDateTime zdt) {
        testJodaPatternConversion(jodaDateFormat,expectedJodaOutput,expectedJavaDateFormat,expectedJavaOutput,zdt,false);
    }
    public static void testJodaPatternConversion(String jodaDateFormat, String expectedJodaOutput, String expectedJavaDateFormat, String expectedJavaOutput, ZonedDateTime zdt) {
        testJodaPatternConversion(jodaDateFormat,expectedJodaOutput,expectedJavaDateFormat,expectedJavaOutput,zdt,true);
    }
    public static void testJodaPatternConversion(String jodaDateFormat, String expectedJodaOutput, String expectedJavaDateFormat, String expectedJavaOutput, ZonedDateTime zdt, boolean strict) {

        long expectedLong = toLong(zdt);

        String jodaFormatted = formatJoda(jodaDateFormat, expectedLong);
        assertEquals(expectedJodaOutput, jodaFormatted);

        String javaFormat = util.JodaDateFormatConverter.convertToJavaTimeDateFormat(jodaDateFormat, strict);
        assertEquals(expectedJavaDateFormat, javaFormat);

        String javaOutput = formatJava(javaFormat, zdt);
        assertEquals(expectedJavaOutput, javaOutput);

    }

    public static void debugJodaFormat(Character symbol, int minLetters, int maxLetters, ZonedDateTime zdt) {

        System.out.println(String.format("%s: joda    java", symbol));

        for (int number = 1; number <= maxLetters; number++) {

            String pattern = new String(new char[number]).replace("\0", symbol.toString());

            String java = formatJava(pattern, zdt);
            String joda = formatJoda(pattern, toLong(zdt));

            String newPattern = util.JodaDateFormatConverter.convertToJavaTimeDateFormat(pattern, false);
            String javaNew = formatJava(newPattern, zdt);

            System.out.println(String.format("%1$12s: %2$15s %3$15s %4$15s", pattern, joda, java, javaNew));

        }

    }
    
    public static String formatJava(String pattern, ZonedDateTime zdt) {

        try {
            return DateTimeFormatter.ofPattern(pattern).format(zdt);
        } catch (UnsupportedTemporalTypeException e) {
            return "UNSUPPORTED";
        } catch (IllegalArgumentException e) {
            return "TOO MANY";
        }


    }

    public static String formatJoda(String pattern, long millis) {

        try {
            return DateTimeFormat.forPattern(pattern).print(millis);
        } catch (UnsupportedTemporalTypeException e) {
            return "UNSUPPORTED";
        } catch (IllegalArgumentException e) {
            return "TOO MANY";
        }

    }

}
