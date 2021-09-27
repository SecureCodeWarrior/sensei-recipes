package includetimezone;

import org.joda.time.*;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class InstantExamples {


    public void constructors() {

        Object objectArg = null;
        long longArg = 0L;
        
        Instant Instant1 = new Instant();
        Instant Instant2 = new Instant(objectArg);
        Instant Instant3 = new Instant(longArg);

    }

    public void staticMethods() {

        // Arguments
        Object objectArg = null;
        long longArg = 0L;
        String stringArg = "something";
        DateTimeFormatter datetimeformatterArg = DateTimeFormat.fullDate();

        // Usages
        Instant ofEpochSecond = Instant.ofEpochSecond(longArg);
        Instant ofEpochMilli = Instant.ofEpochMilli(longArg);
        Instant now = Instant.now();
        Instant parse = Instant.parse(stringArg,datetimeformatterArg);
        Instant parse2 = Instant.parse(stringArg);

    }

    public void staticFields() {
        Instant myEPOCH = Instant.EPOCH;

    }

    public void instanceMethods() {

        Instant testInstant = Instant.now();

        // Arguments
        long longArg = 0L;
        int intArg = 0;
        ReadableDuration readabledurationArg = null;
        ReadableInstant readableinstantArg = null;
        DateTimeZone datetimezoneArg = DateTimeZone.getDefault();
        Chronology chronologyArg = ISOChronology.getInstance();
        DateTimeFieldType datetimefieldtypeArg = DateTimeFieldType.dayOfMonth();
        DateTimeField datetimefieldArg = DateTimeFieldType.dayOfMonth().getField(chronologyArg);
        Object objectArg = null;
        DateTimeFormatter datetimeformatterArg = DateTimeFormat.fullTime();

        Instant withMillis = testInstant.withMillis(longArg);
        Instant withDurationAdded = testInstant.withDurationAdded(longArg,intArg);
        Instant withDurationAdded2 = testInstant.withDurationAdded(readabledurationArg,intArg);
        Instant plus = testInstant.plus(longArg);
        Instant plus2 = testInstant.plus(readabledurationArg);
        Instant minus = testInstant.minus(longArg);
        Instant minus2 = testInstant.minus(readabledurationArg);
        long getMillis = testInstant.getMillis();
        org.joda.time.Chronology getChronology = testInstant.getChronology();
        org.joda.time.DateTime toDateTime = testInstant.toDateTime();
        org.joda.time.DateTime toDateTimeISO = testInstant.toDateTimeISO();
        org.joda.time.MutableDateTime toMutableDateTime = testInstant.toMutableDateTime();
        org.joda.time.MutableDateTime toMutableDateTimeISO = testInstant.toMutableDateTimeISO();
        Instant toInstant = testInstant.toInstant();
        org.joda.time.DateTime toDateTime2 = testInstant.toDateTime(datetimezoneArg);
        org.joda.time.DateTime toDateTime3 = testInstant.toDateTime(chronologyArg);
        org.joda.time.MutableDateTime toMutableDateTime2 = testInstant.toMutableDateTime(datetimezoneArg);
        org.joda.time.MutableDateTime toMutableDateTime3 = testInstant.toMutableDateTime(chronologyArg);
        org.joda.time.DateTimeZone getZone = testInstant.getZone();
        boolean isAfter = testInstant.isAfter(readableinstantArg);
        boolean isAfter2 = testInstant.isAfter(longArg);
        java.util.Date toDate = testInstant.toDate();
        boolean isAfterNow = testInstant.isAfterNow();
        boolean isBeforeNow = testInstant.isBeforeNow();
        boolean isEqualNow = testInstant.isEqualNow();
        boolean isBefore = testInstant.isBefore(readableinstantArg);
        boolean isBefore2 = testInstant.isBefore(longArg);
        boolean isEqual = testInstant.isEqual(readableinstantArg);
        boolean isEqual2 = testInstant.isEqual(longArg);
        int get = testInstant.get(datetimefieldtypeArg);
        int get2 = testInstant.get(datetimefieldArg);
        boolean equals = testInstant.equals(objectArg);

        java.lang.String toString = testInstant.toString(datetimeformatterArg);

        int compareTo2 = testInstant.compareTo(readableinstantArg);

        boolean isSupported = testInstant.isSupported(datetimefieldtypeArg);


    }

    public void instanceFields() {

    }
}
