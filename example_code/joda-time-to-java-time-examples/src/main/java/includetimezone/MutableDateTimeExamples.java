package includetimezone;

import org.joda.time.*;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MutableDateTimeExamples {

    public void constructors() {

        // The following are arguments used in the Constructors below
        Chronology chronologyArg = BuddhistChronology.getInstance();
        long longInstant = System.currentTimeMillis();
        Object instantObject = new java.util.Date();
        java.sql.Date sqlDate = java.sql.Date.valueOf("2020-02-20");
        java.util.Date javaDate = new java.util.Date();
        DateTimeZone datetimezoneArg = DateTimeZone.getDefault();
        int intArg = 0;
        long longArg = 0L;
        Object objectArg = null;

        MutableDateTime MutableDateTime1 = new MutableDateTime(objectArg,chronologyArg);
        MutableDateTime MutableDateTime2 = new MutableDateTime(intArg,intArg,intArg,intArg,intArg,intArg,intArg,datetimezoneArg);
        MutableDateTime MutableDateTime3 = new MutableDateTime(intArg,intArg,intArg,intArg,intArg,intArg,intArg);
        MutableDateTime MutableDateTime4 = new MutableDateTime(objectArg,datetimezoneArg);
        MutableDateTime MutableDateTime5 = new MutableDateTime(objectArg);
        MutableDateTime MutableDateTime6 = new MutableDateTime(longArg);
        MutableDateTime MutableDateTime7 = new MutableDateTime(datetimezoneArg);
        MutableDateTime MutableDateTime8 = new MutableDateTime(chronologyArg);
        MutableDateTime MutableDateTime9 = new MutableDateTime();
        MutableDateTime MutableDateTime10 = new MutableDateTime(intArg,intArg,intArg,intArg,intArg,intArg,intArg,chronologyArg);
        MutableDateTime MutableDateTime11 = new MutableDateTime(longArg,chronologyArg);
        MutableDateTime MutableDateTime12 = new MutableDateTime(longArg,datetimezoneArg);

    }

    public void staticMethods() {

        // The following are arguments used in the Constructors below
        Chronology chronologyArg = BuddhistChronology.getInstance();
        DateTimeZone datetimezoneArg = DateTimeZone.getDefault();
        String stringArg = "pattern";
        DateTimeFormatter datetimeformatterArg = DateTimeFormat.fullTime();

        MutableDateTime now1 = MutableDateTime.now(datetimezoneArg);
        MutableDateTime now2 = MutableDateTime.now(chronologyArg);
        MutableDateTime now3 = MutableDateTime.now();
        MutableDateTime parse1 = MutableDateTime.parse(stringArg);
        MutableDateTime parse2 = MutableDateTime.parse(stringArg,datetimeformatterArg);

    }

    public void staticFields() {
        int myROUND_NONE = MutableDateTime.ROUND_NONE;
        int myROUND_FLOOR = MutableDateTime.ROUND_FLOOR;
        int myROUND_CEILING = MutableDateTime.ROUND_CEILING;
        int myROUND_HALF_FLOOR = MutableDateTime.ROUND_HALF_FLOOR;
        int myROUND_HALF_CEILING = MutableDateTime.ROUND_HALF_CEILING;
        int myROUND_HALF_EVEN = MutableDateTime.ROUND_HALF_EVEN;

    }

    public void instanceMethods(MutableDateTime testMutableDateTime) {

        int intArg = 0;
        long longArg = 0L;


    }

    public void setMethods(MutableDateTime testMutableDateTime) {

        Instant readableinstantArg = Instant.now();
        long longArg = 0L;
        int intArg = 0;
        Chronology chronologyArg = ISOChronology.getInstanceUTC();
        DateTimeZone datetimezoneArg = DateTimeZone.getDefault();
        DateTimeFieldType datetimefieldtypeArg = DateTimeFieldType.dayOfMonth();

        testMutableDateTime.setMillis(readableinstantArg);
        testMutableDateTime.setMillis(longArg);
        testMutableDateTime.setChronology(chronologyArg);
        testMutableDateTime.setZone(datetimezoneArg);
        testMutableDateTime.setZoneRetainFields(datetimezoneArg);
        testMutableDateTime.setYear(intArg);
        testMutableDateTime.setWeekyear(intArg);
        testMutableDateTime.setMonthOfYear(intArg);
        testMutableDateTime.setWeekOfWeekyear(intArg);
        testMutableDateTime.setDayOfYear(intArg);
        testMutableDateTime.setDayOfMonth(intArg);
        testMutableDateTime.setDayOfWeek(intArg);
        testMutableDateTime.setHourOfDay(intArg);
        testMutableDateTime.setMinuteOfDay(intArg);
        testMutableDateTime.setMinuteOfHour(intArg);
        testMutableDateTime.setSecondOfDay(intArg);
        testMutableDateTime.setSecondOfMinute(intArg);
        testMutableDateTime.setMillisOfDay(intArg);
        testMutableDateTime.setMillisOfSecond(intArg);
        testMutableDateTime.setDate(longArg);
        testMutableDateTime.setDate(readableinstantArg);
        testMutableDateTime.setDate(intArg,intArg,intArg);
        testMutableDateTime.setDateTime(intArg,intArg,intArg,intArg,intArg,intArg,intArg);
        testMutableDateTime.setTime(longArg);
        testMutableDateTime.setTime(readableinstantArg);
        testMutableDateTime.setTime(intArg,intArg,intArg,intArg);
        testMutableDateTime.set(datetimefieldtypeArg,intArg);

    }

    public void addMethods(MutableDateTime testMutableDateTime) {

        int intArg = 0;
        long longArg = 0L;
        Period readableperiodArg = Period.ZERO;
        Duration readabledurationArg = Duration.ZERO;
        DurationFieldType durationfieldtypeArg = DurationFieldType.days();

        testMutableDateTime.addYears(intArg);
        testMutableDateTime.addWeekyears(intArg);
        testMutableDateTime.addMonths(intArg);
        testMutableDateTime.addWeeks(intArg);
        testMutableDateTime.addDays(intArg);
        testMutableDateTime.addHours(intArg);
        testMutableDateTime.addMinutes(intArg);
        testMutableDateTime.addSeconds(intArg);
        testMutableDateTime.addMillis(intArg);
        testMutableDateTime.add(longArg);
        testMutableDateTime.add(durationfieldtypeArg,intArg);
        testMutableDateTime.add(readableperiodArg,intArg);
        testMutableDateTime.add(readableperiodArg);
        testMutableDateTime.add(readabledurationArg,intArg);
        testMutableDateTime.add(readabledurationArg);
    }

    public void propertyMethods(MutableDateTime testMutableDateTime) {

        DateTimeFieldType datetimefieldtypeArg = DateTimeFieldType.monthOfYear();

        MutableDateTime.Property property = testMutableDateTime.property(datetimefieldtypeArg);
        MutableDateTime.Property era = testMutableDateTime.era();
        MutableDateTime.Property centuryOfEra = testMutableDateTime.centuryOfEra();
        MutableDateTime.Property yearOfCentury = testMutableDateTime.yearOfCentury();
        MutableDateTime.Property yearOfEra = testMutableDateTime.yearOfEra();
        MutableDateTime.Property weekyear = testMutableDateTime.weekyear();
        MutableDateTime.Property monthOfYear = testMutableDateTime.monthOfYear();
        MutableDateTime.Property weekOfWeekyear = testMutableDateTime.weekOfWeekyear();
        MutableDateTime.Property dayOfYear = testMutableDateTime.dayOfYear();
        MutableDateTime.Property dayOfMonth = testMutableDateTime.dayOfMonth();
        MutableDateTime.Property dayOfWeek = testMutableDateTime.dayOfWeek();
        MutableDateTime.Property hourOfDay = testMutableDateTime.hourOfDay();
        MutableDateTime.Property minuteOfDay = testMutableDateTime.minuteOfDay();
        MutableDateTime.Property minuteOfHour = testMutableDateTime.minuteOfHour();
        MutableDateTime.Property secondOfDay = testMutableDateTime.secondOfDay();
        MutableDateTime.Property secondOfMinute = testMutableDateTime.secondOfMinute();
        MutableDateTime.Property millisOfDay = testMutableDateTime.millisOfDay();
        MutableDateTime.Property millisOfSecond = testMutableDateTime.millisOfSecond();
        org.joda.time.MutableDateTime.Property year = testMutableDateTime.year();

    }

    public void getMethods(MutableDateTime testMutableDateTime) {

        DateTimeFieldType datetimefieldtypeArg = DateTimeFieldType.monthOfYear();
        DateTimeField datetimefieldArg = null;

        java.lang.Object clone = testMutableDateTime.clone();
        MutableDateTime copy = testMutableDateTime.copy();

        Chronology getChronology = testMutableDateTime.getChronology();
        long getMillis = testMutableDateTime.getMillis();
        int getYear = testMutableDateTime.getYear();
        int getDayOfMonth = testMutableDateTime.getDayOfMonth();
        int getEra = testMutableDateTime.getEra();
        int getMillisOfDay = testMutableDateTime.getMillisOfDay();
        int getDayOfWeek = testMutableDateTime.getDayOfWeek();
        int getDayOfYear = testMutableDateTime.getDayOfYear();
        int getWeekOfWeekyear = testMutableDateTime.getWeekOfWeekyear();
        int getWeekyear = testMutableDateTime.getWeekyear();
        int getMonthOfYear = testMutableDateTime.getMonthOfYear();
        int getYearOfEra = testMutableDateTime.getYearOfEra();
        int getYearOfCentury = testMutableDateTime.getYearOfCentury();
        int getCenturyOfEra = testMutableDateTime.getCenturyOfEra();
        int getMillisOfSecond = testMutableDateTime.getMillisOfSecond();
        int getSecondOfMinute = testMutableDateTime.getSecondOfMinute();
        int getSecondOfDay = testMutableDateTime.getSecondOfDay();
        int getMinuteOfHour = testMutableDateTime.getMinuteOfHour();
        int getMinuteOfDay = testMutableDateTime.getMinuteOfDay();
        int getHourOfDay = testMutableDateTime.getHourOfDay();
        int get1 = testMutableDateTime.get(datetimefieldtypeArg);
        int get2 = testMutableDateTime.get(datetimefieldArg);
        DateTimeZone getZone = testMutableDateTime.getZone();

    }

    public void toMethods(MutableDateTime testMutableDateTime) {

        Locale localeArg = Locale.getDefault();
        String stringArg = "parse";
        DateTimeZone datetimezoneArg = DateTimeZone.getDefault();
        Chronology chronologyArg = ISOChronology.getInstanceUTC();
        DateTimeFormatter datetimeformatterArg = DateTimeFormat.fullDate();

        Calendar toCalendar = testMutableDateTime.toCalendar(localeArg);
        GregorianCalendar toGregorianCalendar = testMutableDateTime.toGregorianCalendar();
        String toString1 = testMutableDateTime.toString(stringArg);
        String toString2 = testMutableDateTime.toString(stringArg, localeArg);
        String toString3 = testMutableDateTime.toString();
        Instant toInstant = testMutableDateTime.toInstant();
        DateTime toDateTimeISO = testMutableDateTime.toDateTimeISO();
        MutableDateTime toMutableDateTimeISO = testMutableDateTime.toMutableDateTimeISO();
        Date toDate = testMutableDateTime.toDate();
        MutableDateTime toMutableDateTime1 = testMutableDateTime.toMutableDateTime(datetimezoneArg);
        MutableDateTime toMutableDateTime2 = testMutableDateTime.toMutableDateTime();
        MutableDateTime toMutableDateTime3 = testMutableDateTime.toMutableDateTime(chronologyArg);
        DateTime toDateTime1 = testMutableDateTime.toDateTime(datetimezoneArg);
        DateTime toDateTime2 = testMutableDateTime.toDateTime(chronologyArg);
        DateTime toDateTime3 = testMutableDateTime.toDateTime();
        java.lang.String toString = testMutableDateTime.toString(datetimeformatterArg);
    }

    public void otherMethods(MutableDateTime testMutableDateTime) {

        DateTimeFieldType datetimefieldtypeArg = DateTimeFieldType.dayOfWeek();
        DateTimeField datetimefieldArg = ISOChronology.getInstance().dayOfWeek();
        int intArg = 0;
        long longArg = 9L;
        Instant readableinstantArg = Instant.now();


        DateTimeField getRoundingField = testMutableDateTime.getRoundingField();
        int getRoundingMode = testMutableDateTime.getRoundingMode();
        testMutableDateTime.setRounding(datetimefieldArg, intArg);
        testMutableDateTime.setRounding(datetimefieldArg);

        boolean isAfterNow = testMutableDateTime.isAfterNow();
        boolean isBeforeNow = testMutableDateTime.isBeforeNow();
        boolean isEqualNow = testMutableDateTime.isEqualNow();
        boolean isAfter1 = testMutableDateTime.isAfter(longArg);
        boolean isAfter2 = testMutableDateTime.isAfter(readableinstantArg);
        boolean isBefore1 = testMutableDateTime.isBefore(readableinstantArg);
        boolean isBefore2 = testMutableDateTime.isBefore(longArg);
        boolean isEqual1 = testMutableDateTime.isEqual(longArg);
        boolean isEqual2 = testMutableDateTime.isEqual(readableinstantArg);
        boolean isSupported = testMutableDateTime.isSupported(datetimefieldtypeArg);

        int compareTo = testMutableDateTime.compareTo(readableinstantArg);

    }

    public void instanceFields() {

    }

}
