package notimezone;

import org.joda.time.*;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class LocalDateTimeExamples {

    public void constructors() {

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
        
        LocalDateTime LocalDateTime1 = new LocalDateTime(intArg,intArg,intArg,intArg,intArg,intArg);
        LocalDateTime LocalDateTime2 = new LocalDateTime(objectArg, datetimezoneArg);
        LocalDateTime LocalDateTime3 = new LocalDateTime(objectArg, chronologyArg);
        LocalDateTime LocalDateTime4 = new LocalDateTime(intArg,intArg,intArg,intArg,intArg,intArg,intArg);
        LocalDateTime LocalDateTime5 = new LocalDateTime(intArg,intArg,intArg,intArg,intArg,intArg,intArg,chronologyArg);
        LocalDateTime LocalDateTime6 = new LocalDateTime(longArg);
        LocalDateTime LocalDateTime7 = new LocalDateTime(chronologyArg);
        LocalDateTime LocalDateTime8 = new LocalDateTime();
        LocalDateTime LocalDateTime9 = new LocalDateTime(intArg,intArg,intArg,intArg,intArg);
        LocalDateTime LocalDateTime10 = new LocalDateTime(datetimezoneArg);
        LocalDateTime LocalDateTime11 = new LocalDateTime(objectArg);
        LocalDateTime LocalDateTime12 = new LocalDateTime(longArg,datetimezoneArg);
        LocalDateTime LocalDateTime13 = new LocalDateTime(longArg,chronologyArg);

    }

    public void staticMethods() {

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
        
        LocalDateTime fromCalendarFields = LocalDateTime.fromCalendarFields(calendarArg);
        LocalDateTime fromDateFields = LocalDateTime.fromDateFields(dateArg);
        LocalDateTime now = LocalDateTime.now(datetimezoneArg);
        LocalDateTime now1 = LocalDateTime.now();
        LocalDateTime now2 = LocalDateTime.now(chronologyArg);
        LocalDateTime parse = LocalDateTime.parse(stringArg);
        LocalDateTime parse1 = LocalDateTime.parse(stringArg,datetimeformatterArg);

    }

    public void staticFields() {

    }

    public void instanceMethods() {

        LocalDateTime testLocalDateTime = LocalDateTime.now();

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
        
        Chronology getChronology = testLocalDateTime.getChronology();

        // 'plus' methods
        LocalDateTime plus = testLocalDateTime.plus(readableperiodArg);
        LocalDateTime plus1 = testLocalDateTime.plus(readabledurationArg);
        LocalDateTime plusYears = testLocalDateTime.plusYears(intArg);
        LocalDateTime plusMonths = testLocalDateTime.plusMonths(intArg);
        LocalDateTime plusWeeks = testLocalDateTime.plusWeeks(intArg);
        LocalDateTime plusDays = testLocalDateTime.plusDays(intArg);
        LocalDateTime plusHours = testLocalDateTime.plusHours(intArg);
        LocalDateTime plusMinutes = testLocalDateTime.plusMinutes(intArg);
        LocalDateTime plusSeconds = testLocalDateTime.plusSeconds(intArg);
        LocalDateTime plusMillis = testLocalDateTime.plusMillis(intArg);

        // 'minus' methods
        LocalDateTime minus = testLocalDateTime.minus(readableperiodArg);
        LocalDateTime minus1 = testLocalDateTime.minus(readabledurationArg);
        LocalDateTime minusYears = testLocalDateTime.minusYears(intArg);
        LocalDateTime minusMonths = testLocalDateTime.minusMonths(intArg);
        LocalDateTime minusWeeks = testLocalDateTime.minusWeeks(intArg);
        LocalDateTime minusDays = testLocalDateTime.minusDays(intArg);
        LocalDateTime minusHours = testLocalDateTime.minusHours(intArg);
        LocalDateTime minusMinutes = testLocalDateTime.minusMinutes(intArg);
        LocalDateTime minusSeconds = testLocalDateTime.minusSeconds(intArg);
        LocalDateTime minusMillis = testLocalDateTime.minusMillis(intArg);

        // 'get' methods
        int getEra = testLocalDateTime.getEra();
        int getCenturyOfEra = testLocalDateTime.getCenturyOfEra();
        int getYearOfEra = testLocalDateTime.getYearOfEra();
        int getYearOfCentury = testLocalDateTime.getYearOfCentury();
        int getWeekyear = testLocalDateTime.getWeekyear();
        int getMonthOfYear = testLocalDateTime.getMonthOfYear();
        int getWeekOfWeekyear = testLocalDateTime.getWeekOfWeekyear();
        int getDayOfYear = testLocalDateTime.getDayOfYear();
        int getDayOfWeek = testLocalDateTime.getDayOfWeek();
        int getHourOfDay = testLocalDateTime.getHourOfDay();
        int getMinuteOfHour = testLocalDateTime.getMinuteOfHour();
        int getSecondOfMinute = testLocalDateTime.getSecondOfMinute();
        int getMillisOfSecond = testLocalDateTime.getMillisOfSecond();
        int getMillisOfDay = testLocalDateTime.getMillisOfDay();

        // 'with' methods
        LocalDateTime withEra = testLocalDateTime.withEra(intArg);
        LocalDateTime withCenturyOfEra = testLocalDateTime.withCenturyOfEra(intArg);
        LocalDateTime withYearOfEra = testLocalDateTime.withYearOfEra(intArg);
        LocalDateTime withYearOfCentury = testLocalDateTime.withYearOfCentury(intArg);
        LocalDateTime withYear = testLocalDateTime.withYear(intArg);
        LocalDateTime withWeekyear = testLocalDateTime.withWeekyear(intArg);
        LocalDateTime withMonthOfYear = testLocalDateTime.withMonthOfYear(intArg);
        LocalDateTime withWeekOfWeekyear = testLocalDateTime.withWeekOfWeekyear(intArg);
        LocalDateTime withDayOfYear = testLocalDateTime.withDayOfYear(intArg);
        LocalDateTime withDayOfMonth = testLocalDateTime.withDayOfMonth(intArg);
        LocalDateTime withDayOfWeek = testLocalDateTime.withDayOfWeek(intArg);
        LocalDateTime withHourOfDay = testLocalDateTime.withHourOfDay(intArg);
        LocalDateTime withMinuteOfHour = testLocalDateTime.withMinuteOfHour(intArg);
        LocalDateTime withSecondOfMinute = testLocalDateTime.withSecondOfMinute(intArg);
        LocalDateTime withMillisOfSecond = testLocalDateTime.withMillisOfSecond(intArg);
        LocalDateTime withMillisOfDay = testLocalDateTime.withMillisOfDay(intArg);

        LocalDateTime withDate = testLocalDateTime.withDate(intArg,intArg,intArg);
        LocalDateTime withTime = testLocalDateTime.withTime(intArg,intArg,intArg,intArg);
        LocalDateTime withFields = testLocalDateTime.withFields(readablepartialArg);
        LocalDateTime withField = testLocalDateTime.withField(datetimefieldtypeArg,intArg);
        LocalDateTime withFieldAdded = testLocalDateTime.withFieldAdded(durationfieldtypeArg,intArg);
        LocalDateTime withDurationAdded = testLocalDateTime.withDurationAdded(readabledurationArg,intArg);
        LocalDateTime withPeriodAdded = testLocalDateTime.withPeriodAdded(readableperiodArg,intArg);


        // 'property' methods
        LocalDateTime.Property era = testLocalDateTime.era();
        LocalDateTime.Property centuryOfEra = testLocalDateTime.centuryOfEra();
        LocalDateTime.Property yearOfCentury = testLocalDateTime.yearOfCentury();
        LocalDateTime.Property yearOfEra = testLocalDateTime.yearOfEra();
        LocalDateTime.Property weekyear = testLocalDateTime.weekyear();
        LocalDateTime.Property monthOfYear = testLocalDateTime.monthOfYear();
        LocalDateTime.Property weekOfWeekyear = testLocalDateTime.weekOfWeekyear();
        LocalDateTime.Property dayOfYear = testLocalDateTime.dayOfYear();
        LocalDateTime.Property dayOfMonth = testLocalDateTime.dayOfMonth();
        LocalDateTime.Property dayOfWeek = testLocalDateTime.dayOfWeek();
        LocalDateTime.Property hourOfDay = testLocalDateTime.hourOfDay();
        LocalDateTime.Property minuteOfHour = testLocalDateTime.minuteOfHour();
        LocalDateTime.Property secondOfMinute = testLocalDateTime.secondOfMinute();
        LocalDateTime.Property millisOfSecond = testLocalDateTime.millisOfSecond();
        LocalDateTime.Property millisOfDay = testLocalDateTime.millisOfDay();
        LocalDateTime.Property property = testLocalDateTime.property(datetimefieldtypeArg);

        // 'to' methods
        DateTime toDateTime = testLocalDateTime.toDateTime(datetimezoneArg);
        DateTime toDateTime1 = testLocalDateTime.toDateTime();
        LocalDate toLocalDate = testLocalDateTime.toLocalDate();
        LocalTime toLocalTime = testLocalDateTime.toLocalTime();
        java.util.Date toDate = testLocalDateTime.toDate(timezoneArg);
        java.util.Date toDate1 = testLocalDateTime.toDate();


        int get = testLocalDateTime.get(datetimefieldtypeArg);
        boolean equals = testLocalDateTime.equals(objectArg);
        java.lang.String toString = testLocalDateTime.toString(stringArg);
        java.lang.String toString1 = testLocalDateTime.toString();
        java.lang.String toString2 = testLocalDateTime.toString(stringArg,localeArg);
        int compareTo = testLocalDateTime.compareTo(readablepartialArg);
        int getValue = testLocalDateTime.getValue(intArg);
        int size = testLocalDateTime.size();
        boolean isSupported = testLocalDateTime.isSupported(datetimefieldtypeArg);
        boolean isSupported1 = testLocalDateTime.isSupported(durationfieldtypeArg);
        LocalDateTime.Property year = testLocalDateTime.year();
        int getYear = testLocalDateTime.getYear();
        int getDayOfMonth = testLocalDateTime.getDayOfMonth();
        DateTime toDateTime2 = testLocalDateTime.toDateTime(readableinstantArg);
        boolean isBefore = testLocalDateTime.isBefore(readablepartialArg);
        int[] getValues = testLocalDateTime.getValues();
        DateTimeFieldType[] getFieldTypes = testLocalDateTime.getFieldTypes();
        boolean isAfter = testLocalDateTime.isAfter(readablepartialArg);
        boolean isEqual = testLocalDateTime.isEqual(readablepartialArg);
        java.lang.String toString3 = testLocalDateTime.toString(datetimeformatterArg);
        int indexOf = testLocalDateTime.indexOf(datetimefieldtypeArg);
        DateTimeField[] getFields = testLocalDateTime.getFields();
        DateTimeField getField = testLocalDateTime.getField(intArg);
        DateTimeFieldType getFieldType = testLocalDateTime.getFieldType(intArg);

    }

    public void instanceFields() {

    }

}
