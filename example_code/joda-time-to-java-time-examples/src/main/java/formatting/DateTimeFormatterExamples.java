package formatting;

import org.joda.time.*;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeParser;
import org.joda.time.format.DateTimePrinter;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
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

        String dateWithZone = "2011-12-03T10:15:30+01:00[Europe/Paris]";
        long longWithZone = dtf.parseMillis(dateWithZone);

    }
}
