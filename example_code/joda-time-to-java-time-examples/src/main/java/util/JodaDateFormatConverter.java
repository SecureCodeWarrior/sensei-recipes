package util;

import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.ArrayList;
import java.util.List;

public class JodaDateFormatConverter {

    public static String convertToJavaTimeDateFormat(String pattern) {
        return convertToJavaTimeDateFormat(pattern, true);
    }

    public static String convertToJavaTimeDateFormat(String pattern, boolean strict) {

        List<String> problems = new ArrayList<>();

        if (pattern.matches("C+")) {
            problems.add("Century of Era [Joda Time format character: C] is Not Supported in java-time");
            if(!strict) {
                pattern = pattern.replaceAll("C","");
            }
        }

        // Joda only had 1 length for Era
        pattern = pattern.replaceAll("G+", "G");

        // Only one letter of 'c' and 'F' can be specified ( and it seems a)
        for (char c : "cFa".toCharArray()) {

            String regex = String.format("%s{2,}",c);
            String replace = String.format("%s",c);

            if (pattern.matches(regex)) {
                problems.add(String.format("Only one letter of '%s' can be specified", c));
                if (!strict) {
                    pattern = pattern.replaceAll(regex, replace);
                }
            }

        }

        // Up to three letters of 'D' can be specified.
        if (pattern.matches("D{4,}")) {
            problems.add("Java Time limit's the use of D to 3");
            if(!strict) {
                pattern = pattern.replaceAll("D{4,}","DDD");
            }
        }

        // Three e's no longer pads the number
        if (pattern.matches("e{3,}")) {
            problems.add("eee does not pad the day-of-week-number anymore.");
            if (!strict) {
                pattern.replaceAll("e{3,}", "ee");
            }
        }

        //Up to two letters of 'd', 'H', 'h', 'K', 'k', 'm', and 's' can be specified.
        for (char c : "dHhKkms".toCharArray()) {

            String regex = String.format("%s{3,}",c);
            String replace = String.format("%1$s%1$s",c);

            if (pattern.matches(regex)) {
                problems.add("Up to 2 letters of '"+ c +"' can be specified");
                if (!strict) {
                    pattern = pattern.replaceAll(regex, replace);
                }
            }

        }

        // Different precision of fraction of a second
        if (pattern.matches("S{4,}")) {
            // Same format but it will just have a side effect of greater precision
            problems.add("Fraction of a Second (S) has greater precision so the number may be more precise");
            if (!strict) {
                if (pattern.matches("S{10,}")) {
                    // Maximum 9
                    problems.add("Fraction of a Second (S) has maximum of 9");
                    pattern = pattern.replaceAll("S{10,}","SSSSSSSSS");
                }
            }
        }

        // Text Styles
        // Less than 4 pattern letters will use the short form.
        // Exactly 4 pattern letters will use the full form.
        // Exactly 5 pattern letters will use the narrow form.
        for (char c : "z".toCharArray()) {

            String regex = String.format("%s{5,}",c);
            String replace = new String(new char[4]).replace("\0",String.valueOf(c));

            if (pattern.matches(regex)) {
                problems.add("Up to 4 letters of '"+ c +"' can be specified");
                if (!strict) {
                    pattern = pattern.replaceAll(regex, replace);
                }
            }

        }

        // Zone has special cases
        if (pattern.matches("Z{3,}")) {
            problems.add("ZZZ equivalent is VV");
            if(!strict) {
                pattern = pattern.replaceAll("Z{3,}","VV");
            }
        } else if (pattern.matches("Z{2}")) {
            problems.add("ZZ equivalent is ZZZZZ");
            if(!strict) {
                pattern = pattern.replaceAll("Z{2}","ZZZZZ");
            }
        }


        // Pattern letters 'L', 'c', and 'q' specify the stand-alone form of the text styles
        pattern = pattern.replaceAll("M{4,}", "MMMM");
        pattern = pattern.replaceAll("E{4,}", "EEEE");

        // Year of Era Y -> y
        pattern = pattern.replaceAll("Y", "y");
        // week-based-year x -> Y
        pattern = pattern.replaceAll("x", "Y");

        if (!problems.isEmpty() && strict) {
            throw new IllegalArgumentException("Problems");
        }

        return pattern;

    }

}
