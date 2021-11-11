package formatting;

import org.joda.time.*;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.*;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.*;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class DateTimeFormatterExamples {


    public DateTimeFormatter getDateTimeFormatter() {
        return DateTimeFormat.longDateTime();
    }

    public void constructors() {

        DateTimePrinter datetimeprinterArg = null;
        DateTimeParser datetimeparserArg = null;

        DateTimeFormatter DateTimeFormatter1 = new DateTimeFormatter(datetimeprinterArg,datetimeparserArg);

    }

    public void staticMethods() {
        // none
    }

    public void staticFields() {
        // none
    }

    public void instanceMethods() throws IOException {

        DateTimeFormatter dtf = DateTimeFormat.fullDate();

        // Variables used in methods below
        Locale localeArg = Locale.getDefault();
        long longArg = 43L;
        Integer integerArg = null;
        int intArg = 0;
        Appendable appendableArg = new StringWriter();
        StringBuffer stringbufferArg = new StringBuffer();
        StringBuilder stringbuilderArg = new StringBuilder();
        String stringArg = "";
        ReadableInstant readableinstantArg = null;
        ReadablePartial readablepartialArg = null;
        ReadWritableInstant readwritableinstantArg = null;
        Writer writerArg = new StringWriter();
        Chronology chronologyArg = ISOChronology.getInstance();
        DateTimeZone datetimezoneArg = DateTimeZone.UTC;
        MutableDateTime mdt = MutableDateTime.now();

        boolean isPrinter = dtf.isPrinter();
        org.joda.time.format.DateTimePrinter getPrinter = dtf.getPrinter();

        boolean isParser = dtf.isParser();
        org.joda.time.format.DateTimeParser getParser = dtf.getParser();

        org.joda.time.format.DateTimeFormatter withLocale = dtf.withLocale(localeArg);
        java.util.Locale getLocale = dtf.getLocale();

        org.joda.time.format.DateTimeFormatter withOffsetParsed = dtf.withOffsetParsed();
        boolean isOffsetParsed = dtf.isOffsetParsed();

        org.joda.time.format.DateTimeFormatter withChronology = dtf.withChronology(chronologyArg);
        org.joda.time.Chronology getChronology = dtf.getChronology();
        org.joda.time.Chronology getChronolgy = dtf.getChronolgy();

        org.joda.time.format.DateTimeFormatter withZoneUTC = dtf.withZoneUTC();
        org.joda.time.format.DateTimeFormatter withZone = dtf.withZone(datetimezoneArg);
        org.joda.time.DateTimeZone getZone = dtf.getZone();

        org.joda.time.format.DateTimeFormatter withPivotYear = dtf.withPivotYear(integerArg);
        org.joda.time.format.DateTimeFormatter withPivotYear2 = dtf.withPivotYear(intArg);
        java.lang.Integer getPivotYear = dtf.getPivotYear();

        org.joda.time.format.DateTimeFormatter withDefaultYear = dtf.withDefaultYear(intArg);
        int getDefaultYear = dtf.getDefaultYear();

        dtf.printTo(stringbufferArg,readablepartialArg);
        dtf.printTo(appendableArg,longArg);
        dtf.printTo(writerArg,longArg);
        dtf.printTo(stringbuilderArg,longArg);
        dtf.printTo(writerArg,readablepartialArg);
        dtf.printTo(appendableArg,readablepartialArg);
        dtf.printTo(stringbuilderArg,readablepartialArg);
        dtf.printTo(stringbuilderArg,readableinstantArg);
        dtf.printTo(stringbufferArg,readableinstantArg);
        dtf.printTo(writerArg,readableinstantArg);
        dtf.printTo(stringbufferArg,longArg);
        dtf.printTo(appendableArg,readableinstantArg);

        int parseInto = dtf.parseInto(readwritableinstantArg,stringArg,intArg);
        long parseMillis = dtf.parseMillis(stringArg);
        org.joda.time.LocalDate parseLocalDate = dtf.parseLocalDate(stringArg);
        org.joda.time.LocalTime parseLocalTime = dtf.parseLocalTime(stringArg);
        org.joda.time.LocalDateTime parseLocalDateTime = dtf.parseLocalDateTime(stringArg);
        org.joda.time.DateTime parseDateTime = dtf.parseDateTime(stringArg);
        org.joda.time.MutableDateTime parseMutableDateTime = dtf.parseMutableDateTime(stringArg);

        java.lang.String print = dtf.print(readableinstantArg);
        java.lang.String print1 = dtf.print(longArg);
        java.lang.String print2 = dtf.print(readablepartialArg);

    }

    public void instanceFields() {

    }

    public static String formatFullDate(long millis) {
        DateTimeFormatter dtf = DateTimeFormat.fullDate();
        return dtf.print(millis);
    }

    public static String formatFullDateTime(long millis) {
        DateTimeFormatter dtf = DateTimeFormat.fullDateTime();
        return dtf.print(millis);
    }

    public static String formatFullTime(long millis) {
        DateTimeFormatter dtf = ISODateTimeFormat.time();
        return dtf.print(millis);
    }

    public static String formatLongDate(long millis) {
        DateTimeFormatter dtfLongDate = DateTimeFormat.longDate();
        return dtfLongDate.print(millis);
    }

    public static String formatLongDateTime(long millis) {
        DateTimeFormatter dtf = DateTimeFormat.longDateTime();
        return dtf.print(millis);

    }

    public static String formatLongTime(long millis) {
        DateTimeFormatter dtf = DateTimeFormat.longTime();
        return dtf.print(millis);

    }

    public static String formatMediumDate(long millis) {
        DateTimeFormatter dtfMediumDate = DateTimeFormat.mediumDate();
        return dtfMediumDate.print(millis);

    }

    public static String formatMediumDateTime(long millis) {
        DateTimeFormatter dtf = DateTimeFormat.mediumDateTime();
        return dtf.print(millis);

    }

    public static String formatMediumTime(long millis) {
        DateTimeFormatter dtf = DateTimeFormat.mediumTime();
        return dtf.print(millis);

    }

    public static String formatShortDate(long millis) {
        DateTimeFormatter dtf = DateTimeFormat.shortDate();
        return dtf.print(millis);

    }

    public static String formatShortDateTime(long millis) {
        DateTimeFormatter dtf = DateTimeFormat.shortDateTime();
        return dtf.print(millis);

    }

    public static String formatShortTime(long millis) {
        DateTimeFormatter dtf = DateTimeFormat.shortTime();
        return dtf.print(millis);

    }

    // Standard Parsing

    public static long parseFullDate(String string) {
        java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        return java.time.LocalDate.parse(string,dtf).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static long parseFullDateTime(String string) {
        java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        return ZonedDateTime.parse(string,dtf).withZoneSameLocal(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static long parseFullTime(String string) {
        java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL);
        return LocalTime.parse(string,dtf).getLong(ChronoField.MILLI_OF_DAY);
    }

    public static long parseLongDate(String string) {
        java.time.format.DateTimeFormatter dtfLongDate = java.time.format.DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        return java.time.LocalDate.parse(string,dtfLongDate).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static long parseLongDateTime(String string) {
        java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        return java.time.LocalDate.parse(string,dtf).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static long parseLongTime(String string) {
        java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG);
        return java.time.LocalTime.parse(string,dtf).getLong(ChronoField.MILLI_OF_DAY);
    }

    public static long parseMediumDate(String string) {
        java.time.format.DateTimeFormatter dtfMediumDate = java.time.format.DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        return java.time.LocalDate.parse(string,dtfMediumDate).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static long parseMediumDateTime(String string) {
        java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return java.time.LocalDateTime.parse(string,dtf).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static long parseMediumTime(String string) {
        java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        return java.time.LocalTime.parse(string,dtf).getLong(ChronoField.MILLI_OF_DAY);
    }

    public static long parseShortDate(String string) {
        java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        return LocalDate.parse(string,dtf).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static long parseShortDateTime(String string) {
        java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        return LocalDateTime.parse(string,dtf).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static long parseShortTime(String string) {
        java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        return java.time.LocalTime.parse(string,dtf).getLong(ChronoField.MILLI_OF_DAY);
    }

    public static ZonedDateTime parseDateTime(String string) {
        java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        return ZonedDateTime.parse(string,dtf);
    }

    public static java.time.LocalDate parseLocalDate(String string) {
        java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        return java.time.LocalDate.parse(string,dtf);
    }

}
