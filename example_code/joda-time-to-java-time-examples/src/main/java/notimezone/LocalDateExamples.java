package notimezone;

import org.joda.time.*;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class LocalDateExamples {

    public void constructors() {

        long longArg = 0L;
        Chronology chronologyArg = BuddhistChronology.getInstance();
        DateTimeZone datetimezoneArg = DateTimeZone.getDefault();
        int intArg = 0;
        Object objectArg = null;

        LocalDate LocalDate1 = new LocalDate();
        LocalDate LocalDate2 = new LocalDate(longArg,chronologyArg);
        LocalDate LocalDate3 = new LocalDate(longArg,datetimezoneArg);
        LocalDate LocalDate4 = new LocalDate(longArg);
        LocalDate LocalDate5 = new LocalDate(chronologyArg);
        LocalDate LocalDate6 = new LocalDate(datetimezoneArg);
        LocalDate LocalDate7 = new LocalDate(intArg,intArg,intArg,chronologyArg);
        LocalDate LocalDate8 = new LocalDate(intArg,intArg,intArg);
        LocalDate LocalDate9 = new LocalDate(objectArg,chronologyArg);
        LocalDate LocalDate10 = new LocalDate(objectArg,datetimezoneArg);
        LocalDate LocalDate11 = new LocalDate(objectArg);

        // Special Case for java.sql.date
        java.sql.Date sqlDate = java.sql.Date.valueOf("2020-02-20");
        LocalDate fromSqlDate = new LocalDate(sqlDate);

        // Special Case for java.util.date
        java.util.Date javaDate = new java.util.Date();
        LocalDate fromJavaDate = new LocalDate(javaDate);
    }

    public void staticMethods() {

        Calendar calendarArg = Calendar.getInstance();
        Date dateArg = new Date();
        Chronology chronologyArg = BuddhistChronology.getInstance();
        DateTimeZone datetimezoneArg = DateTimeZone.getDefault();
        String stringArg = "somedate";
        DateTimeFormatter datetimeformatterArg = DateTimeFormat.fullDateTime();

        LocalDate fromCalendarFields = LocalDate.fromCalendarFields(calendarArg);
        LocalDate fromDateFields = LocalDate.fromDateFields(dateArg);
        LocalDate now = LocalDate.now(datetimezoneArg);
        LocalDate now1 = LocalDate.now(chronologyArg);
        LocalDate now2 = LocalDate.now();
        LocalDate parse = LocalDate.parse(stringArg,datetimeformatterArg);
        LocalDate parse1 = LocalDate.parse(stringArg);

    }

    public void staticFields() {

    }

    public void instanceMethods() {

        LocalDate testLocalDate = LocalDate.now();

        // Arguments used
        DateTimeZone datetimezoneArg = DateTimeZone.getDefault();
        TimeZone timezoneArg = TimeZone.getDefault();
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
        ReadableDuration readabledurationArg = null;
        DateTimeFieldType datetimefieldtypeArg = null;
        DurationFieldType durationfieldtypeArg = null;
        Locale localeArg = Locale.JAPAN;
        LocalTime localtimeArg = LocalTime.now();

        Chronology getChronology = testLocalDate.getChronology();
        DateTime toDateTimeAtStartOfDay = testLocalDate.toDateTimeAtStartOfDay(datetimezoneArg);
        DateTime toDateTimeAtStartOfDay1 = testLocalDate.toDateTimeAtStartOfDay();
        DateTime toDateTimeAtMidnight = testLocalDate.toDateTimeAtMidnight();
        DateTime toDateTimeAtMidnight1 = testLocalDate.toDateTimeAtMidnight(datetimezoneArg);
        DateTime toDateTimeAtCurrentTime = testLocalDate.toDateTimeAtCurrentTime(datetimezoneArg);
        DateTime toDateTimeAtCurrentTime1 = testLocalDate.toDateTimeAtCurrentTime();
        DateMidnight toDateMidnight = testLocalDate.toDateMidnight(datetimezoneArg);
        DateMidnight toDateMidnight1 = testLocalDate.toDateMidnight();
        LocalDateTime toLocalDateTime = testLocalDate.toLocalDateTime(localtimeArg);
        DateTime toDateTime = testLocalDate.toDateTime(localtimeArg);
        DateTime toDateTime1 = testLocalDate.toDateTime(localtimeArg,datetimezoneArg);
        Interval toInterval = testLocalDate.toInterval(datetimezoneArg);
        Interval toInterval1 = testLocalDate.toInterval();
        java.util.Date toDate = testLocalDate.toDate();
        LocalDate withFields = testLocalDate.withFields(readablepartialArg);
        LocalDate withField = testLocalDate.withField(datetimefieldtypeArg,intArg);
        LocalDate withFieldAdded = testLocalDate.withFieldAdded(durationfieldtypeArg,intArg);
        LocalDate withPeriodAdded = testLocalDate.withPeriodAdded(readableperiodArg,intArg);
        LocalDate plus = testLocalDate.plus(readableperiodArg);
        LocalDate plusYears = testLocalDate.plusYears(intArg);
        LocalDate plusMonths = testLocalDate.plusMonths(intArg);
        LocalDate plusWeeks = testLocalDate.plusWeeks(intArg);
        LocalDate plusDays = testLocalDate.plusDays(intArg);
        LocalDate minus = testLocalDate.minus(readableperiodArg);
        LocalDate minusYears = testLocalDate.minusYears(intArg);
        LocalDate minusMonths = testLocalDate.minusMonths(intArg);
        LocalDate minusWeeks = testLocalDate.minusWeeks(intArg);
        LocalDate minusDays = testLocalDate.minusDays(intArg);
        LocalDate.Property property = testLocalDate.property(datetimefieldtypeArg);
        int getEra = testLocalDate.getEra();
        int getCenturyOfEra = testLocalDate.getCenturyOfEra();
        int getYearOfEra = testLocalDate.getYearOfEra();
        int getYearOfCentury = testLocalDate.getYearOfCentury();
        int getWeekyear = testLocalDate.getWeekyear();
        int getMonthOfYear = testLocalDate.getMonthOfYear();
        int getWeekOfWeekyear = testLocalDate.getWeekOfWeekyear();
        int getDayOfYear = testLocalDate.getDayOfYear();
        int getDayOfWeek = testLocalDate.getDayOfWeek();
        LocalDate withEra = testLocalDate.withEra(intArg);
        LocalDate withCenturyOfEra = testLocalDate.withCenturyOfEra(intArg);
        LocalDate withYearOfEra = testLocalDate.withYearOfEra(intArg);
        LocalDate withYearOfCentury = testLocalDate.withYearOfCentury(intArg);
        LocalDate withYear = testLocalDate.withYear(intArg);
        LocalDate withWeekyear = testLocalDate.withWeekyear(intArg);
        LocalDate withMonthOfYear = testLocalDate.withMonthOfYear(intArg);
        LocalDate withWeekOfWeekyear = testLocalDate.withWeekOfWeekyear(intArg);
        LocalDate withDayOfYear = testLocalDate.withDayOfYear(intArg);
        LocalDate withDayOfMonth = testLocalDate.withDayOfMonth(intArg);
        LocalDate withDayOfWeek = testLocalDate.withDayOfWeek(intArg);
        LocalDate.Property era = testLocalDate.era();
        LocalDate.Property centuryOfEra = testLocalDate.centuryOfEra();
        LocalDate.Property yearOfCentury = testLocalDate.yearOfCentury();
        LocalDate.Property yearOfEra = testLocalDate.yearOfEra();
        LocalDate.Property weekyear = testLocalDate.weekyear();
        LocalDate.Property monthOfYear = testLocalDate.monthOfYear();
        LocalDate.Property weekOfWeekyear = testLocalDate.weekOfWeekyear();
        LocalDate.Property dayOfYear = testLocalDate.dayOfYear();
        LocalDate.Property dayOfMonth = testLocalDate.dayOfMonth();
        LocalDate.Property dayOfWeek = testLocalDate.dayOfWeek();
        LocalDate.Property year = testLocalDate.year();
        int getYear = testLocalDate.getYear();
        int getDayOfMonth = testLocalDate.getDayOfMonth();
        int get = testLocalDate.get(datetimefieldtypeArg);
        boolean equals = testLocalDate.equals(objectArg);
        java.lang.String toString = testLocalDate.toString();
        java.lang.String toString1 = testLocalDate.toString(stringArg,localeArg);
        java.lang.String toString2 = testLocalDate.toString(stringArg);
        int compareTo1 = testLocalDate.compareTo(readablepartialArg);
        int getValue = testLocalDate.getValue(intArg);
        int size = testLocalDate.size();
        boolean isSupported = testLocalDate.isSupported(durationfieldtypeArg);
        boolean isSupported1 = testLocalDate.isSupported(datetimefieldtypeArg);
        DateTime toDateTime2 = testLocalDate.toDateTime(readableinstantArg);
        boolean isBefore = testLocalDate.isBefore(readablepartialArg);
        boolean isAfter = testLocalDate.isAfter(readablepartialArg);
        DateTimeFieldType[] getFieldTypes = testLocalDate.getFieldTypes();
        int[] getValues = testLocalDate.getValues();
        boolean isEqual = testLocalDate.isEqual(readablepartialArg);
        java.lang.String toString3 = testLocalDate.toString(datetimeformatterArg);
        int indexOf = testLocalDate.indexOf(datetimefieldtypeArg);
        DateTimeField[] getFields = testLocalDate.getFields();
        org.joda.time.DateTimeField getField = testLocalDate.getField(intArg);
        org.joda.time.DateTimeFieldType getFieldType = testLocalDate.getFieldType(intArg);

    }

    public void instanceFields() {

    }
    
}
