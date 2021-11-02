package includetimezone;

import org.joda.time.*;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Locale;
import java.util.Optional;

public class DateTimeExamples {

    private DateTime dateTimeField;

    public void constructors() {

        // The following are arguments used in the Constructors below
        Chronology chronology = BuddhistChronology.getInstance();
        long longInstant = System.currentTimeMillis();
        Object instantObject = new java.util.Date();
        java.sql.Date sqlDate = java.sql.Date.valueOf("2020-02-20");
        java.util.Date javaDate = new java.util.Date();
        DateTimeZone dateTimeZone = DateTimeZone.getDefault();

        DateTime noargs = new DateTime();

        DateTime fromChronology = new DateTime(chronology);
        DateTime fromDateTimeZone = new DateTime(dateTimeZone);

        DateTime fromParts = new DateTime(2021, 1, 15, 12, 30);
        DateTime fromPartsChronology = new DateTime(2021, 1, 15, 12, 30, chronology);
        DateTime fromPartsDateTimeZone = new DateTime(2021, 1, 15, 12, 30, dateTimeZone);

        DateTime fromPartsWithSeconds = new DateTime(2021, 1, 15, 12, 30, 45);
        DateTime fromPartsChronologyWithSeconds = new DateTime(2021, 1, 15, 12, 30, 45, chronology);
        DateTime fromPartsDateTimeZoneWithSeconds = new DateTime(2021, 1, 15, 12, 30, 45, dateTimeZone);

        DateTime fromPartsWithMillis = new DateTime(2021, 1, 15, 12, 30, 45, 123456789);
        DateTime fromPartsChronologyWithMillis = new DateTime(2021, 1, 15, 12, 30, 45, 123456789, chronology);
        DateTime fromPartsDateTimeZoneWithMillis = new DateTime(2021, 1, 15, 12, 30, 45, 123456789, dateTimeZone);

        DateTime fromInstant = new DateTime(longInstant);
        DateTime fromInstantChronology = new DateTime(longInstant, chronology);
        DateTime fromInstantDateTimeZone = new DateTime(longInstant, dateTimeZone);

        DateTime fromObject = new DateTime(instantObject);
        DateTime fromObjectChronology = new DateTime(instantObject, chronology);
        DateTime fromObjectDateTimeZone = new DateTime(instantObject, dateTimeZone);

        // Sql and Java Date examples
        DateTime fromSqlDate = new DateTime(sqlDate);
        DateTime fromJavaDate = new DateTime(javaDate);


    }

    public void factoryMethods() {

        // These variables are used in the factory methods below
        Chronology chronology = ISOChronology.getInstance();
        DateTimeZone dateTimeZone = DateTimeZone.UTC;
        DateTimeFormatter dtf = DateTimeFormat.fullDate();

        // now factory methods
        DateTime dtnow = DateTime.now();
        DateTime dtNowChronology = DateTime.now(chronology);
        DateTime dtNowDateTimeZone = DateTime.now(dateTimeZone);

        // parse factory methods
        DateTime dtParsed = DateTime.parse("somedate");
        DateTime dtParsedFormatter = DateTime.parse("somedate", dtf);

    }

    public DateTime getCreatedAt() {
        return dateTimeField;
    }

    public Optional<DateTime> getSentAt() {
        return Optional.ofNullable(dateTimeField);
    }

    public void methods(DateTime dateTime) {

        // These variables are used as arguments in the methods below
        DateTimeFieldType datetimefieldtypeArg = DateTimeFieldType.monthOfYear();

        // Property accessors
        DateTime.Property property = dateTime.property(datetimefieldtypeArg);
        DateTime.Property propCenturyOfEra = dateTime.centuryOfEra();
        DateTime.Property propDayOfMonth = dateTime.dayOfMonth();
        DateTime.Property propDayOfWeek = dateTime.dayOfWeek();
        DateTime.Property propDayOfYear = dateTime.dayOfYear();
        DateTime.Property propEra = dateTime.era();
        DateTime.Property propHourOfDay = dateTime.hourOfDay();
        DateTime.Property propMillisOfDay = dateTime.millisOfDay();
        DateTime.Property propMillisOfSecond = dateTime.millisOfSecond();
        DateTime.Property propMinuteOfDay = dateTime.minuteOfDay();
        DateTime.Property propMinuteOfHour = dateTime.minuteOfHour();
        DateTime.Property propMonthOfYear = dateTime.monthOfYear();
        DateTime.Property propSecondOfDay = dateTime.secondOfDay();
        DateTime.Property propSecondOfMinute = dateTime.secondOfMinute();
        DateTime.Property propWeekOfWeekYear = dateTime.weekOfWeekyear();
        DateTime.Property propWeekyear = dateTime.weekyear();
        DateTime.Property propYear = dateTime.year();
        DateTime.Property propYearOfCentury = dateTime.yearOfCentury();
        DateTime.Property propYearOfEra = dateTime.yearOfEra();
    }

    public void getMethods(DateTime dateTime) {

        // These variables are used as arguments in the methods below
        DateTimeFieldType datetimefieldtypeArg = DateTimeFieldType.monthOfYear();
        DateTimeField datetimefieldArg = null;

        // Get methods
        org.joda.time.Chronology getChronology = dateTime.getChronology();
        long getMillis = dateTime.getMillis();
        int getMillisOfDay = dateTime.getMillisOfDay();
        int getMonthOfYear = dateTime.getMonthOfYear();
        int getHourOfDay = dateTime.getHourOfDay();
        int getMinuteOfHour = dateTime.getMinuteOfHour();
        int getSecondOfMinute = dateTime.getSecondOfMinute();
        int getMillisOfSecond = dateTime.getMillisOfSecond();
        int getDayOfWeek = dateTime.getDayOfWeek();
        int getDayOfYear = dateTime.getDayOfYear();
        int getWeekOfWeekyear = dateTime.getWeekOfWeekyear();
        int getWeekyear = dateTime.getWeekyear();
        int getYearOfEra = dateTime.getYearOfEra();
        int getYearOfCentury = dateTime.getYearOfCentury();
        int getCenturyOfEra = dateTime.getCenturyOfEra();
        int getEra = dateTime.getEra();
        int getSecondOfDay = dateTime.getSecondOfDay();
        int getMinuteOfDay = dateTime.getMinuteOfDay();
        int get = dateTime.get(datetimefieldtypeArg);
        int getYear = dateTime.getYear();
        int getDayOfMonth = dateTime.getDayOfMonth();
        DateTimeZone getZone = dateTime.getZone();
        int getDateTimeField = dateTime.get(datetimefieldArg);
    }

    public void minusMethods(DateTime dateTime) {

        // These variables are used as arguments in the methods below
        ReadableDuration readableDuration = null;
        ReadablePeriod readablePeriod = null;

        // Minus Methods
        DateTime dateTimeMinusLong = dateTime.minus(123L);
        DateTime dateTimeMinusReadableDuration = dateTime.minus(readableDuration);
        DateTime dateTimeMinusReadablePeriod = dateTime.minus(readablePeriod);
        DateTime dateTimeMinusYears = dateTime.minusYears(2);
        DateTime dateTimeMinusMonths = dateTime.minusMonths(5);
        DateTime dateTimeMinusWeeks = dateTime.minusWeeks(5);
        DateTime dateTimeMinusDays = dateTime.minusDays(5);
        DateTime dateTimeMinusHours = dateTime.minusHours(5);
        DateTime dateTimeMinusMinutes = dateTime.minusMinutes(560);
        DateTime dateTimeMinusSeconds = dateTime.minusSeconds(45);
        DateTime dateTimeMinusMillis = dateTime.minusMillis(500);

    }

    public void plusMethods(DateTime dateTime) {
        // These variables are used as arguments in the methods below
        ReadableDuration readableDuration = null;
        ReadablePeriod readablePeriod = null;

        // Plus Methods
        DateTime dateTimePlusLong = dateTime.plus(123L);
        DateTime dateTimePlusReadableDuration = dateTime.plus(readableDuration);
        DateTime dateTimePlusReadablePeriod = dateTime.plus(readablePeriod);
        DateTime dateTimePlusDays = dateTime.plusDays(5);
        DateTime dateTimePlusHours = dateTime.plusHours(5);
        DateTime dateTimePlusMillis = dateTime.plusMillis(500);
        DateTime dateTimePlusMinutes = dateTime.plusMinutes(560);
        DateTime dateTimePlusMonths = dateTime.plusMonths(5);
        DateTime dateTimePlusSeconds = dateTime.plusSeconds(45);
        DateTime dateTimePlusWeeks = dateTime.plusWeeks(5);
        DateTime dateTimePlusYears = dateTime.plusYears(2);
    }

    public void toMethods(DateTime dateTime) {
        // These variables are used as arguments in the methods below
        Locale localeArg = Locale.getDefault();
        DateTimeZone dateTimeZone = DateTimeZone.UTC;
        Chronology chronology = BuddhistChronology.getInstance();
        DateTimeFormatter datetimeformatterArg = DateTimeFormat.fullDate();

        // to methods
        DateTime toDateTime = dateTime.toDateTime();
        DateMidnight dateMidnight = dateTime.toDateMidnight();
        DateTime dateTimeFromChronology = dateTime.toDateTime(chronology);
        DateTime dateTimeFromDateTimeZone = dateTime.toDateTime(dateTimeZone);
        DateTime dateTimeIso = dateTime.toDateTimeISO();
        LocalDate localDate = dateTime.toLocalDate();
        LocalDateTime localDateTime = dateTime.toLocalDateTime();
        LocalTime localTime = dateTime.toLocalTime();
        TimeOfDay timeOfDay = dateTime.toTimeOfDay();
        YearMonthDay yearMonthDay = dateTime.toYearMonthDay();
        java.util.Calendar toCalendar = dateTime.toCalendar(localeArg);
        java.util.GregorianCalendar toGregorianCalendar = dateTime.toGregorianCalendar();
        java.util.Date toDate = dateTime.toDate();
        org.joda.time.Instant toInstant = dateTime.toInstant();

        MutableDateTime toMutableDateTime1 = dateTime.toMutableDateTime(chronology);
        MutableDateTime toMutableDateTime2 = dateTime.toMutableDateTime();
        MutableDateTime toMutableDateTime3 = dateTime.toMutableDateTime(dateTimeZone);
        MutableDateTime toMutableDateTimeISO = dateTime.toMutableDateTimeISO();

        // toString methods
        java.lang.String toString = dateTime.toString("pattern");
        java.lang.String toString2 = dateTime.toString("pattern", localeArg);
        java.lang.String toString3 = dateTime.toString(datetimeformatterArg);
    }

    public void withMethods(DateTime dateTime) {
        // These variables are used as arguments in the methods below
        ReadableDuration readableDuration = null;
        ReadablePeriod readablePeriod = null;
        ReadablePartial readablePartial = null;
        ReadableInstant readableInstant = null;
        Object objectArg = null;
        Locale localeArg = Locale.getDefault();
        DateTimeZone dateTimeZone = DateTimeZone.UTC;
        Chronology chronology = BuddhistChronology.getInstance();
        DateTimeFieldType datetimefieldtypeArg = DateTimeFieldType.monthOfYear();
        DateTimeField datetimefieldArg = null;
        DateTimeFormatter datetimeformatterArg = DateTimeFormat.fullDate();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        // with
        DateTime withDateLocalDate = dateTime.withDate(localDate);
        DateTime withDateParts = dateTime.withDate(2020, 2, 35);

        DateTime withTime = dateTime.withTime(6, 7, 8, 123);
        DateTime withTimeLocalTime = dateTime.withTime(localTime);
        DateTime withTimeAtStartOfDay = dateTime.withTimeAtStartOfDay();

        DateTime withCenturyOfEra = dateTime.withCenturyOfEra(5);
        DateTime withDayOfMonth = dateTime.withDayOfMonth(5);
        DateTime withDayOfWeek = dateTime.withDayOfWeek(5);
        DateTime withDayOfYear = dateTime.withDayOfYear(6);
        DateTime withEra = dateTime.withEra(5);
        DateTime withHourOfDay = dateTime.withHourOfDay(5);
        DateTime withMillisInt = dateTime.withMillis(123);
        DateTime withMillisLong = dateTime.withMillis(123L);
        DateTime withMillisOfDay = dateTime.withMillisOfDay(1234);
        DateTime withMillisOfSecond = dateTime.withMillisOfSecond(531);
        DateTime withMinuteOfHour = dateTime.withMinuteOfHour(30);
        DateTime withMonthOfYear = dateTime.withMonthOfYear(2);
        DateTime withSecondOfMinute = dateTime.withSecondOfMinute(50);
        DateTime withWeekOfWeekYear = dateTime.withWeekOfWeekyear(5);
        DateTime withWeekyear = dateTime.withWeekyear(6);
        DateTime withYear = dateTime.withYear(1236);
        DateTime withYearOfCentury = dateTime.withYearOfCentury(56);
        DateTime withYearOfEra = dateTime.withYearOfEra(56);

        DateTime withDurationAdded = dateTime.withDurationAdded(23L, 3);
        DateTime withDurationAddedRd = dateTime.withDurationAdded(readableDuration, 5);
        DateTime withPeriodAdded = dateTime.withPeriodAdded(readablePeriod, 5);

        DateTime withField = dateTime.withField(DateTimeFieldType.dayOfMonth(), 5);
        DateTime withFieldAdded = dateTime.withFieldAdded(DurationFieldType.hours(), 5);
        DateTime withFields = dateTime.withFields(readablePartial);

        DateTime withEarlierOffsetAtOverlap = dateTime.withEarlierOffsetAtOverlap();
        DateTime withLaterOffsetAtOverlap = dateTime.withLaterOffsetAtOverlap();

        DateTime withChronology = dateTime.withChronology(chronology);

        DateTime withZone = dateTime.withZone(dateTimeZone);
        DateTime withZoneRetainFields = dateTime.withZoneRetainFields(dateTimeZone);
    }

    public void isMethods(DateTime dateTime) {

        // These variables are used as arguments in the methods below
        ReadableInstant readableInstant = null;
        DateTimeFieldType datetimefieldtypeArg = DateTimeFieldType.monthOfYear();

        // is methods
        boolean isAfter1 = dateTime.isAfter(readableInstant);
        boolean isAfter2 = dateTime.isAfter(123456L);
        boolean isBefore1 = dateTime.isBefore(123456L);
        boolean isBefore2 = dateTime.isBefore(readableInstant);
        boolean isEqual1 = dateTime.isEqual(readableInstant);
        boolean isEqual2 = dateTime.isEqual(123456L);
        boolean isAfterNow = dateTime.isAfterNow();
        boolean isBeforeNow = dateTime.isBeforeNow();
        boolean isEqualNow = dateTime.isEqualNow();
        boolean isSupported = dateTime.isSupported(datetimefieldtypeArg);

    }

    public void compareMethods(DateTime dateTime) {

        // These variables are used as arguments in the methods below
        ReadableInstant readableInstant = null;

        // Compare to
        int compareTo2 = dateTime.compareTo(readableInstant);


    }


}
