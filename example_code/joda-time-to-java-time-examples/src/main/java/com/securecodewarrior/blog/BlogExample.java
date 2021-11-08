package com.securecodewarrior.blog;

import org.joda.time.DateTime;

public class BlogExample {

    public static String formatDateTimeFromParts(int year, int month, int day, int hour, int minute, int second, int milli) {

        DateTime dateTime = new DateTime(year, month, day, hour, minute, second, milli);

        return dateTime.toString();

    }

}
