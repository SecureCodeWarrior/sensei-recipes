package notimezone;

import org.joda.time.*;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class LocalTimeExamples {


    public void constructors() {

        // Arguments
        DateTimeZone datetimezoneArg = DateTimeZone.getDefault();
        Chronology chronologyArg = ISOChronology.getInstance();
        long longArg = 0L;
        Object objectArg = null;
        int intArg = 3;

        LocalTime LocalTime1 = new LocalTime(datetimezoneArg);
        LocalTime LocalTime2 = new LocalTime(chronologyArg);
        LocalTime LocalTime3 = new LocalTime(longArg);
        LocalTime LocalTime4 = new LocalTime();
        LocalTime LocalTime5 = new LocalTime(objectArg, chronologyArg);
        LocalTime LocalTime6 = new LocalTime(intArg, intArg);
        LocalTime LocalTime7 = new LocalTime(intArg, intArg, intArg);
        LocalTime LocalTime8 = new LocalTime(intArg, intArg, intArg, intArg);
        LocalTime LocalTime9 = new LocalTime(intArg, intArg, intArg, intArg, chronologyArg);
        LocalTime LocalTime10 = new LocalTime(longArg, datetimezoneArg);
        LocalTime LocalTime11 = new LocalTime(longArg, chronologyArg);
        LocalTime LocalTime12 = new LocalTime(objectArg);
        LocalTime LocalTime13 = new LocalTime(objectArg, datetimezoneArg);

    }

    public void staticMethods() {

        // Arguments
        DateTimeZone datetimezoneArg = DateTimeZone.getDefault();
        Chronology chronologyArg = ISOChronology.getInstance();
        long longArg = 0L;
        Object objectArg = null;
        int intArg = 3;
        Calendar calendarArg = Calendar.getInstance();
        Date dateArg = new Date();
        String stringArg = "somedate";
        DateTimeFormatter datetimeformatterArg = DateTimeFormat.longDateTime();

        LocalTime fromMillisOfDay1 = LocalTime.fromMillisOfDay(longArg, chronologyArg);
        LocalTime fromMillisOfDay2 = LocalTime.fromMillisOfDay(longArg);
        LocalTime fromCalendarFields = LocalTime.fromCalendarFields(calendarArg);
        LocalTime fromDateFields = LocalTime.fromDateFields(dateArg);
        LocalTime now1 = LocalTime.now(datetimezoneArg);
        LocalTime now2 = LocalTime.now(chronologyArg);
        LocalTime now3 = LocalTime.now();
        LocalTime parse = LocalTime.parse(stringArg, datetimeformatterArg);
        LocalTime parse2 = LocalTime.parse(stringArg);

    }

    public void staticFields() {
        LocalTime myMIDNIGHT = LocalTime.MIDNIGHT;
    }

    public LocalTime instanceMethods(LocalTime testLocalTime) {

        // Arguments used
        DateTimeZone datetimezoneArg = DateTimeZone.getDefault();
        Chronology chronologyArg = ISOChronology.getInstance();
        long longArg = 0L;
        Object objectArg = null;
        int intArg = 3;
        Calendar calendarArg = Calendar.getInstance();
        Date dateArg = new Date();
        String stringArg = "somedate";
        DateTimeFormatter datetimeformatterArg = DateTimeFormat.longDateTime();
        ReadablePartial readablepartialArg = null;
        ReadablePeriod readableperiodArg = null;
        ReadableInstant readableinstantArg = null;
        DateTimeFieldType datetimefieldtypeArg = null;
        DurationFieldType durationfieldtypeArg = null;
        Locale localeArg = Locale.JAPAN;

        org.joda.time.Chronology getChronology = testLocalTime.getChronology();
        LocalTime withFields = testLocalTime.withFields(readablepartialArg);
        LocalTime withField = testLocalTime.withField(datetimefieldtypeArg, intArg);
        LocalTime withFieldAdded = testLocalTime.withFieldAdded(durationfieldtypeArg, intArg);
        LocalTime withPeriodAdded = testLocalTime.withPeriodAdded(readableperiodArg, intArg);
        LocalTime plus = testLocalTime.plus(readableperiodArg);
        LocalTime plusHours = testLocalTime.plusHours(intArg);
        LocalTime plusMinutes = testLocalTime.plusMinutes(intArg);
        LocalTime plusSeconds = testLocalTime.plusSeconds(intArg);
        LocalTime plusMillis = testLocalTime.plusMillis(intArg);
        LocalTime minus = testLocalTime.minus(readableperiodArg);
        LocalTime minusHours = testLocalTime.minusHours(intArg);
        LocalTime minusMinutes = testLocalTime.minusMinutes(intArg);
        LocalTime minusSeconds = testLocalTime.minusSeconds(intArg);
        LocalTime minusMillis = testLocalTime.minusMillis(intArg);
        LocalTime.Property property = testLocalTime.property(datetimefieldtypeArg);
        int getHourOfDay = testLocalTime.getHourOfDay();
        int getMinuteOfHour = testLocalTime.getMinuteOfHour();
        int getSecondOfMinute = testLocalTime.getSecondOfMinute();
        int getMillisOfSecond = testLocalTime.getMillisOfSecond();
        int getMillisOfDay = testLocalTime.getMillisOfDay();
        LocalTime withHourOfDay = testLocalTime.withHourOfDay(intArg);
        LocalTime withMinuteOfHour = testLocalTime.withMinuteOfHour(intArg);
        LocalTime withSecondOfMinute = testLocalTime.withSecondOfMinute(intArg);
        LocalTime withMillisOfSecond = testLocalTime.withMillisOfSecond(intArg);
        LocalTime withMillisOfDay = testLocalTime.withMillisOfDay(intArg);
        LocalTime.Property hourOfDay = testLocalTime.hourOfDay();
        LocalTime.Property minuteOfHour = testLocalTime.minuteOfHour();
        LocalTime.Property secondOfMinute = testLocalTime.secondOfMinute();
        LocalTime.Property millisOfSecond = testLocalTime.millisOfSecond();
        LocalTime.Property millisOfDay = testLocalTime.millisOfDay();
        org.joda.time.DateTime toDateTimeToday = testLocalTime.toDateTimeToday(datetimezoneArg);
        org.joda.time.DateTime toDateTimeToday2 = testLocalTime.toDateTimeToday();
        int get = testLocalTime.get(datetimefieldtypeArg);
        boolean equals = testLocalTime.equals(objectArg);
        int getValue = testLocalTime.getValue(intArg);
        int size = testLocalTime.size();
        boolean isSupported = testLocalTime.isSupported(durationfieldtypeArg);
        boolean isSupported2 = testLocalTime.isSupported(datetimefieldtypeArg);
        org.joda.time.DateTime toDateTime = testLocalTime.toDateTime(readableinstantArg);

        DateTimeFieldType[] getFieldTypes = testLocalTime.getFieldTypes();
        int[] getValues = testLocalTime.getValues();
        boolean isAfter = testLocalTime.isAfter(readablepartialArg);
        boolean isBefore = testLocalTime.isBefore(readablepartialArg);
        boolean isEqual = testLocalTime.isEqual(readablepartialArg);
        DateTimeField[] getFields = testLocalTime.getFields();
        org.joda.time.DateTimeField getField = testLocalTime.getField(intArg);
        org.joda.time.DateTimeFieldType getFieldType = testLocalTime.getFieldType(intArg);

        return testLocalTime;

    }

    public void instanceFields() {

    }


}
