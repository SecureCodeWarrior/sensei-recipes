package includetimezone;

import org.joda.time.*;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateTimeConstructorsTest {

    /*
        This test is written in support of the recipe:
            DateTime-constructor-year-month-day-hour-minute-second-millis.yaml
    */
    @Test
    public void test_year_month_day_hour_minute_second_millis() {

        int year = 2021;
        int month = 11;
        int day = 8;
        int hour = 12;
        int minute = 34;
        int seconds = 56;
        int millis = 789;

        DateTime dateTime = new DateTime(year, month, day, hour, minute, seconds, millis);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(year, month, day, hour, minute, seconds, 0, ZoneId.systemDefault()).with(ChronoField.MILLI_OF_SECOND, millis);

        assertSameInstant(dateTime, zonedDateTime.toInstant());
        assertSameZoneId(dateTime, zonedDateTime);

    }

    /*
        This test is written in support of the recipe:
            DateTime-constructor-year-month-day-hour-minute-second-millis-DateTimeZone.yaml
    */

    @Test
    public void test_year_month_day_hour_minute_second_millis_DateTimeZone() {

        String id = "Indian/Maldives";
        DateTimeZone dateTimeZone = DateTimeZone.forID(id);
        // This is the equivalent zone as would be migrated by: datetimezone-zoneid-forid.yaml
        ZoneId zoneId = ZoneId.of(id);

        int year = 2021;
        int month = 11;
        int day = 8;
        int hour = 12;
        int minute = 34;
        int seconds = 56;
        int millis = 789;

        DateTime dateTime = new DateTime(year, month, day, hour, minute, seconds, millis, dateTimeZone);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(year, month, day, hour, minute, seconds, 0, zoneId).with(ChronoField.MILLI_OF_SECOND, millis);

        assertSameInstant(dateTime, zonedDateTime.toInstant());
        assertSameZoneId(dateTime, zonedDateTime);

    }

    /*
    This test is written in support of the recipe:
        DateTime-constructor-year-month-day-hour-minute-second.yaml
*/
    @Test
    public void test_year_month_day_hour_minute_second() {

        int year = 2021;
        int month = 11;
        int day = 8;
        int hour = 12;
        int minute = 34;
        int seconds = 56;

        DateTime dateTime = new DateTime(year, month, day, hour, minute, seconds);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(year, month, day, hour, minute, seconds, 0, ZoneId.systemDefault());

        assertSameInstant(dateTime, zonedDateTime.toInstant());
        assertSameZoneId(dateTime, zonedDateTime);

    }

    /*
        This test is written in support of the recipe:
            DateTime-constructor-year-month-day-hour-minute-second-DateTimeZone.yaml
    */

    @Test
    public void test_year_month_day_hour_minute_second_DateTimeZone() {

        String id = "Indian/Maldives";
        DateTimeZone dateTimeZone = DateTimeZone.forID(id);
        // This is the equivalent zone as would be migrated by: datetimezone-zoneid-forid.yaml
        ZoneId zoneId = ZoneId.of(id);

        int year = 2021;
        int month = 11;
        int day = 8;
        int hour = 12;
        int minute = 34;
        int seconds = 56;

        DateTime dateTime = new DateTime(year, month, day, hour, minute, seconds, dateTimeZone);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(year, month, day, hour, minute, seconds, 0, zoneId);

        assertSameInstant(dateTime, zonedDateTime.toInstant());
        assertSameZoneId(dateTime, zonedDateTime);

    }

    /*
        This test is written in support of the recipe:
            DateTime-constructor-year-month-day-hour-minute.yaml
    */
    @Test
    public void test_year_month_day_hour_minute() {

        int year = 2021;
        int month = 11;
        int day = 8;
        int hour = 12;
        int minute = 34;

        DateTime dateTime = new DateTime(year, month, day, hour, minute);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(year, month, day, hour, minute, 0, 0, ZoneId.systemDefault());

        assertSameInstant(dateTime, zonedDateTime.toInstant());
        assertSameZoneId(dateTime, zonedDateTime);

    }

    /*
        This test is written in support of the recipe:
            DateTime-constructor-year-month-day-hour-minute-DateTimeZone.yaml
    */
    @Test
    public void test_year_month_day_hour_minute_DateTimeZone() {

        String id = "Indian/Maldives";
        DateTimeZone dateTimeZone = DateTimeZone.forID(id);
        // This is the equivalent zone as would be migrated by: datetimezone-zoneid-forid.yaml
        ZoneId zoneId = ZoneId.of(id);

        int year = 2021;
        int month = 11;
        int day = 8;
        int hour = 12;
        int minute = 34;

        DateTime dateTime = new DateTime(year, month, day, hour, minute, dateTimeZone);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(year, month, day, hour, minute, 0, 0, zoneId);

        assertSameInstant(dateTime, zonedDateTime.toInstant());
        assertSameZoneId(dateTime, zonedDateTime);

    }

    /*
        This test is written in support of the recipe:
            DateTime-constructor-empty.yaml
     */
    @Test
    public void test_empty() {

        // Recipe searches for this
        DateTime dateTime = new DateTime();

        // ZonedDateTime fix transforms to this:
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        // OffsetDateTime fix transforms to this:
        OffsetDateTime offsetDateTime = OffsetDateTime.now();

        // Assert the ZonedDateTime is the same (within a second)
        assertCloseToInstant(dateTime, zonedDateTime.toInstant());
        assertSameZoneId(dateTime, zonedDateTime);

        // Assert the offsetdatetime is the same (within a second)
        assertCloseToInstant(dateTime, offsetDateTime.toInstant());
        assertSameOffset(dateTime, offsetDateTime);

    }


    @Test
    public void test_Constructor_DateMidnight() {

        DateTime dateTime = new DateTime(DateMidnight.now());
        ZonedDateTime zonedDateTime = ZonedDateTime.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()));

        assertThat(dateTime.getMillis()).isEqualTo(zonedDateTime.toInstant().toEpochMilli());
        assertThat(dateTime.getZone().getID()).isEqualTo(zonedDateTime.getZone().getId());

    }

    @Test
    public void test_Constructor_DateTime() {

        DateTime dateTime = new DateTime(DateTime.now().plusDays(2));
        ZonedDateTime zonedDateTime = ZonedDateTime.from(ZonedDateTime.now().plusDays(2));

    }

    @Test
    public void test_Constructor_MutableDateTime() {

        long now = Clock.systemDefaultZone().millis();

        DateTime dateTime = new DateTime(new MutableDateTime(now));
        ZonedDateTime zonedDateTime = ZonedDateTime.from(ZonedDateTime.now());


    }

    @Test
    public void test_Constructor_String() {

        DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd['T'HH:mm:ss.SSSX]");

        String shortDate = "2021-09-08";
        String fullDatetime = "2021-09-08T12:45:56.123Z";

        DateTime dateTimeShortDate = new DateTime(shortDate);

        System.out.println(dateTimeShortDate.toString());

        DateTime dateTime = new DateTime(fullDatetime);

        ZonedDateTime zdtShort = LocalDate.parse(shortDate).atStartOfDay(ZoneId.systemDefault());
        ZonedDateTime zdt = ZonedDateTime.parse(fullDatetime, dtf);

    }

    @Test
    public void test_Constructor_String_shortDate() {
        /*
        datetime          = time | date-opt-time
        time              = 'T' time-element [offset]
        date-opt-time     = date-element ['T' [time-element] [offset]]
        date-element      = std-date-element | ord-date-element | week-date-element
        std-date-element  = yyyy ['-' MM ['-' dd]]
        ord-date-element  = yyyy ['-' DDD]
        week-date-element = xxxx '-W' ww ['-' e]
        time-element      = HH [minute-element] | [fraction]
        minute-element    = ':' mm [second-element] | [fraction]
        second-element    = ':' ss [fraction]
        fraction          = ('.' | ',') digit+
        offset            = 'Z' | (('+' | '-') HH [':' mm [':' ss [('.' | ',') SSS]]])
         */

        String standardDateElement = "2021-11-25";
        String ordinalDateElement = "2021-300";
        String weekDateElement = "2021-W05-6"; // Check This

        String timeElementHoursOnly = "12";
        String timeElementHourMinutes = "12:34";
        String timeElementHourMinutesSeconds = "12:34:56";
        String timeElementHourMinutesSecondsFractionPeriod = "12:34:56.789";
        String timeElementHourMinutesSecondsFractionComma = "12:34:56,789";
        String timeElementFractionOnlyWithPeriod = ".789";
        String timeElementFractionOnlyWithComma = ",789";
        String timeNoOffset = "Ttime-element";
        String timeWithOffset = "Ttime-element[offset]";
        String dateWithTimeNoOffset = "";
        String dateWithOffsetNoTime = "";

        //DateTime dateTimeShortDate = new DateTime(shortDate);
        //System.out.println(dateTimeShortDate.toString());
        //ZonedDateTime zdtShort = LocalDate.parse(shortDate).atStartOfDay(ZoneId.systemDefault());
        //System.out.println(zdtShort.toString());

        //(dateTimeShortDate.getMillis()).isEqualTo(zdtShort.toInstant().toEpochMilli());
        //assertThat(dateTimeShortDate.getZone().getID()).isEqualTo(zdtShort.getZone().getId());


    }


    @Test
    public void test_Constructor_String_DateTimeZone() {

        String string = "2021-09-08T12:45:56";

        DateTime dateTime = new DateTime(string);
        //ZonedDateTime zonedDateTime = ZonedDateTime.parse(string, DateTimeFormatter.ISO_DATE_TIME);

    }

    /*
        This test is written in support of the recipe:
            DateTime-constructor-Calendar-DateTimeZone.yaml
     */
    @Test
    public void test_Calendar_DateTimeZone() {

        String id = "Indian/Maldives";
        DateTimeZone dateTimeZone = DateTimeZone.forID(id);
        // This is the equivalent zone as would be migrated by: datetimezone-zoneid-forid.yaml
        ZoneId zoneId = ZoneId.of(id);

        Calendar calendar = Calendar.getInstance();

        // Recipe searches for this
        DateTime dateTime = new DateTime(calendar, dateTimeZone);
        // ZonedDateTime fix should transform to this (after DateTimeZone has also been migrated)
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(calendar.toInstant(), zoneId);
        // OffsetDateTime fix should transform to this (after DateTimeZone has also been migrated)
        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(calendar.toInstant(), zoneId);

        // Assert ZonedDateTime is equivalent
        assertSameInstant(dateTime, zonedDateTime.toInstant());
        assertSameZoneId(dateTime, zonedDateTime);
        // Assert OffsetDateTime is equivalent
        assertSameInstant(dateTime, offsetDateTime.toInstant());
        assertSameOffset(dateTime, offsetDateTime);

    }

    /*
    This test is written in support of the recipe:
        DateTime-constructor-Calendar.yaml
    */
    @Test
    public void test_Calendar() {

        String id = "Indian/Maldives";

        Calendar calendar = Calendar.getInstance();

        // Recipe searches for this
        DateTime dateTime = new DateTime(calendar);
        // ZonedDateTime fix should transform to this
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());
        // OffsetDateTime fix should transform to this
        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());

        // Assert ZonedDateTime is equivalent
        assertSameInstant(dateTime, zonedDateTime.toInstant());
        assertSameZoneId(dateTime, zonedDateTime);
        // Assert OffsetDateTime is equivalent
        assertSameInstant(dateTime, offsetDateTime.toInstant());
        assertSameOffset(dateTime, offsetDateTime);

    }

    /*
    This test is written in support of the recipe:
        DateTime-constructor-Date-DateTimeZone.yaml
    */
    @Test
    public void test_Date_DateTimeZone() {

        String id = "Indian/Maldives";
        DateTimeZone dateTimeZone = DateTimeZone.forID(id);
        ZoneId zoneId = ZoneId.of(id);
        Date date = new Date();

        // Recipe searches for this
        DateTime dateTime = new DateTime(date, dateTimeZone);
        // ZonedDateTime fix should transform to this (after DateTimeZone has also been migrated)
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(date.toInstant(), zoneId);
        // OffsetDateTime fix should transform to this (after DateTimeZone has also been migrated)
        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(date.toInstant(), zoneId);

        // Assert ZonedDateTime is equivalent
        assertSameInstant(dateTime, zonedDateTime.toInstant());
        assertSameZoneId(dateTime, zonedDateTime);
        // Assert OffsetDateTime is equivalent
        assertSameInstant(dateTime, offsetDateTime.toInstant());
        assertSameOffset(dateTime, offsetDateTime);


    }

    /*
        This test is written in support of the recipe:
            DateTime-constructor-Date.yaml
    */
    @Test
    public void test_Date() {

        Date date = new Date();

        // Recipe searches for this
        DateTime dateTime = new DateTime(date);
        // ZonedDateTime fix should transform to this (after DateTimeZone has also been migrated)
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        // OffsetDateTime fix should transform to this (after DateTimeZone has also been migrated)
        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());

        // Assert ZonedDateTime is equivalent
        assertSameInstant(dateTime, zonedDateTime.toInstant());
        assertSameZoneId(dateTime, zonedDateTime);
        // Assert OffsetDateTime is equivalent
        assertSameInstant(dateTime, offsetDateTime.toInstant());
        assertSameOffset(dateTime, offsetDateTime);


    }

    /*
        This test is written in support of the recipe:
            DateTime-constructor-DateTimeZone.yaml
    */
    @Test
    public void test_DateTimeZone() {

        String id = "Indian/Maldives";
        DateTimeZone dateTimeZone = DateTimeZone.forID(id);
        ZoneId zoneId = ZoneId.of(id);

        // Recipe searches for this
        DateTime dateTime = new DateTime(dateTimeZone);
        // ZonedDateTime fix should transform to this (after DateTimeZone has also been migrated)
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        // OffsetDateTime fix should transform to this (after DateTimeZone has also been migrated)
        OffsetDateTime offsetDateTime = OffsetDateTime.now(zoneId);

        // Assert ZonedDateTime is equivalent
        assertCloseToInstant(dateTime, zonedDateTime.toInstant());
        assertSameZoneId(dateTime, zonedDateTime);
        // Assert OffsetDateTime is equivalent
        assertCloseToInstant(dateTime, offsetDateTime.toInstant());
        assertSameOffset(dateTime, offsetDateTime);


    }

    /*
        This test is written in support of the recipe:
            DateTime-constructor-long-DateTimeZone.yaml
    */
    @Test
    public void test_Long_DateTimeZone() {

        String id = "Indian/Maldives";
        DateTimeZone dateTimeZone = DateTimeZone.forID(id);
        ZoneId zoneId = ZoneId.of(id);
        Long longNow = Instant.now().toEpochMilli();

        // Recipe searches for this
        DateTime dateTime = new DateTime(longNow, dateTimeZone);
        // ZonedDateTime fix transforms to this:
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(longNow), zoneId);
        // OffsetDateTime fix transforms to this:
        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(Instant.ofEpochMilli(longNow), zoneId);

        // ZonedDateTime should represent the same instant and Zone
        assertSameInstant(dateTime, zonedDateTime.toInstant());
        assertSameZoneId(dateTime, zonedDateTime);

        // OffsetDateTime should represent same instant and offset
        assertSameInstant(dateTime, offsetDateTime.toInstant());
        assertSameOffset(dateTime, offsetDateTime);

    }

    /*
        This test is written in support of the recipe:
            DateTime-constructor-long.yaml
    */
    @Test
    public void test_Long() {

        Long longNow = Instant.now().toEpochMilli();

        // Recipe searches for this
        DateTime dateTime = new DateTime(longNow);
        // ZonedDateTime fix transforms to this:
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(longNow), ZoneId.systemDefault());
        // OffsetDateTime fix transforms to this:
        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(Instant.ofEpochMilli(longNow), ZoneId.systemDefault());

        // ZonedDateTime should represent the same instant and Zone
        assertSameInstant(dateTime, zonedDateTime.toInstant());
        assertSameZoneId(dateTime, zonedDateTime);

        // OffsetDateTime should represent same instant and offset
        assertSameInstant(dateTime, offsetDateTime.toInstant());
        assertSameOffset(dateTime, offsetDateTime);

    }

    /*
        This test is written in support of the recipe:
            DateTime-constructor-Instant-DateTimeZone.yaml
    */
    @Test
    public void test_Instant_DateTimeZone() {

        String id = "Indian/Maldives";
        DateTimeZone dateTimeZone = DateTimeZone.forID(id);
        ZoneId zoneId = ZoneId.of(id);
        Long now = Instant.now().toEpochMilli();

        // Equivalent Instants to use as arguments
        org.joda.time.Instant jodaInstant = org.joda.time.Instant.ofEpochMilli(now);
        Instant javaInstant = Instant.ofEpochMilli(now);

        // Recipe searches for this
        DateTime dateTime = new DateTime(jodaInstant, dateTimeZone);
        // ZonedDateTime fix will transform to this:
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(javaInstant, zoneId);
        // OffsetDateTime fix will transform to this:
        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(javaInstant, zoneId);

        // Assert ZonedDateTime is equivalent
        assertSameInstant(dateTime, zonedDateTime.toInstant());
        assertSameZoneId(dateTime, zonedDateTime);

        // Assert OffsetDateTime is equivalent
        assertSameInstant(dateTime, offsetDateTime.toInstant());
        assertSameOffset(dateTime, offsetDateTime);

    }

    /*
        This test is written in support of the recipe:
            DateTime-constructor-Instant.yaml
    */
    @Test
    public void test_Instant() {

        Long now = Instant.now().toEpochMilli();

        // Equivalent Instants to use as arguments
        org.joda.time.Instant jodaInstant = org.joda.time.Instant.ofEpochMilli(now);
        Instant javaInstant = Instant.ofEpochMilli(now);

        // Recipe searches for this
        DateTime dateTime = new DateTime(jodaInstant);
        // ZonedDateTime fix will transform to this:
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(javaInstant, ZoneId.of("UTC"));
        // OffsetDateTime fix will transform to this:
        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(javaInstant, ZoneOffset.UTC);

        // Assert ZonedDateTime is equivalent
        assertSameInstant(dateTime, zonedDateTime.toInstant());
        assertSameZoneId(dateTime, zonedDateTime);

        // Assert OffsetDateTime is equivalent
        assertSameInstant(dateTime, offsetDateTime.toInstant());
        assertSameOffset(dateTime, offsetDateTime);

    }

    /*
        This test is written in support of the recipe:
            DateTime-constructor-TemporalAccessor-DateTimeZone.yaml
        4 different scenarios that this recipe covers are tested, all of which require the first argument to have been
        migrated to a java.time.temporal.TemporalAccessor before this recipe can match:
            - new DateTime(DateTime, DateTimeZone) that was migrated to new DateTime(ZonedDateTime, DateTimeZone)
            - new DateTime(DateTime, DateTimeZone) that was migrated to new DateTime(OffsetDateTime, DateTimeZone)
            - new DateTime(DateMidnight, DateTimeZone) that was migrated to new DateTime(ZonedDateTime, DateTimeZone)
            - new DateTime(MutableDateTime, DateTimeZone) that was migrated to new DateTime(ZonedDateTime, DateTimeZone)
     */
    @Test
    public void test_TemporalAccessor_DateTimeZone() {

        String id = "Indian/Maldives";
        DateTimeZone dateTimeZone = DateTimeZone.forID(id);
        Long now = Instant.now().toEpochMilli();

        // Joda Objects to use as arguments
        DateTime dateTime = new DateTime(now);
        DateMidnight dateMidnight = dateTime.toDateMidnight();
        MutableDateTime mutableDateTime = new MutableDateTime(now);

        // The following java.time objects are obtained in the same fashion of their respective migration recipes

        // - ZonedDateTime is an equivalent TemporalAccessor that can be migrated to from DateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(now), ZoneId.systemDefault());
        // - OffsetDateTime is an equivalent TemporalAccessor that can be migrated to from DateTime
        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(Instant.ofEpochMilli(now), ZoneId.systemDefault());
        // - Joda DateMidnight can be migrated to this ZonedDateTime
        ZonedDateTime zoneDateTimeMidnight = zonedDateTime.toLocalDate().atStartOfDay(zonedDateTime.getZone());


        // Test that the datetime when migrated to the temporalAccessor ZonedDatetime is equivalent
        test_ReadableInstant_and_TemporalAccessor(dateTime, zonedDateTime, dateTimeZone);
        // Test that the datetime when migrated to the temporalAccessor OffsetDatetime is equivalent
        test_ReadableInstant_and_TemporalAccessor(dateTime, offsetDateTime, dateTimeZone);
        // Test that the dateMidnight when migrated to the TemporalAccessor ZonedDateTime is equivalent
        test_ReadableInstant_and_TemporalAccessor(dateMidnight, zoneDateTimeMidnight, dateTimeZone);
        // Test that the mutableDateTime when migrated to the TemporalAccessor ZonedDateTime is equivalent
        test_ReadableInstant_and_TemporalAccessor(mutableDateTime, zonedDateTime, dateTimeZone);

    }

    /*
        This method is written in support of recipe:
            DateTime-constructor-TemporalAccessor-DateTimeZone.yaml

        This method accepts a Joda-Time ReadableInstant, and an equivalent java.time TemporalAccessor that this
        ReadableInstant would be migrated to.
        It can use these 2 to verify that the transformation in the recipe is correct.
     */
    private void test_ReadableInstant_and_TemporalAccessor(ReadableInstant readableInstant, TemporalAccessor temporalAccessor, DateTimeZone dateTimeZone) {

        ZoneId zoneId = ZoneId.of(dateTimeZone.getID());

        DateTime dateTime = new DateTime(readableInstant, dateTimeZone);
        ZonedDateTime zonedDateTime = ZonedDateTime.from(temporalAccessor).withZoneSameInstant(zoneId);

        // Assert they are the same instant and ZoneId
        assertSameInstant(dateTime, zonedDateTime.toInstant());
        assertSameZoneId(dateTime, zonedDateTime);


    }

    /*
        This test is written in support of the recipe:
            DateTime-constructor-TemporalAccessor.yaml
        4 different scenarios that this recipe covers are tested, all of which require the first argument to have been
        migrated to a java.time.temporal.TemporalAccessor before this recipe can match:
            - new DateTime(DateTime) that was migrated to new DateTime(ZonedDateTime)
            - new DateTime(DateTime) that was migrated to new DateTime(OffsetDateTime)
            - new DateTime(DateMidnight) that was migrated to new DateTime(ZonedDateTime)
            - new DateTime(MutableDateTime) that was migrated to new DateTime(ZonedDateTime)
     */
    @Test
    public void test_TemporalAccessor() {

        Long now = Instant.now().toEpochMilli();

        // Joda Objects to use as arguments
        DateTime dateTime = new DateTime(now);
        DateMidnight dateMidnight = dateTime.toDateMidnight();
        MutableDateTime mutableDateTime = new MutableDateTime(now);

        // The following java.time objects are obtained in the same fashion of their respective migration recipes

        // - ZonedDateTime is an equivalent TemporalAccessor that can be migrated to from DateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(now), ZoneId.systemDefault());
        // - OffsetDateTime is an equivalent TemporalAccessor that can be migrated to from DateTime
        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(Instant.ofEpochMilli(now), ZoneId.systemDefault());
        // - Joda DateMidnight can be migrated to this ZonedDateTime
        ZonedDateTime zoneDateTimeMidnight = zonedDateTime.toLocalDate().atStartOfDay(zonedDateTime.getZone());


        // Test that the datetime when migrated to the temporalAccessor ZonedDatetime is equivalent
        test_ReadableInstant_and_TemporalAccessor(dateTime, zonedDateTime);
        // Test that the datetime when migrated to the temporalAccessor OffsetDatetime is equivalent
        test_ReadableInstant_and_TemporalAccessor_OffsetDateTime(dateTime, offsetDateTime);
        // Test that the dateMidnight when migrated to the TemporalAccessor ZonedDateTime is equivalent
        test_ReadableInstant_and_TemporalAccessor(dateMidnight, zoneDateTimeMidnight);
        // Test that the mutableDateTime when migrated to the TemporalAccessor ZonedDateTime is equivalent
        test_ReadableInstant_and_TemporalAccessor(mutableDateTime, zonedDateTime);

    }

    /*
        This method is written in support of recipe:
            DateTime-constructor-TemporalAccessor-DateTimeZone.yaml

        This method accepts a Joda-Time ReadableInstant, and an equivalent java.time TemporalAccessor that this
        ReadableInstant would be migrated to.
        It can use these 2 to verify that the transformation in the recipe is correct.
     */
    private void test_ReadableInstant_and_TemporalAccessor(ReadableInstant readableInstant, TemporalAccessor temporalAccessor) {

        DateTime dateTime = new DateTime(readableInstant);
        ZonedDateTime zonedDateTime = ZonedDateTime.from(temporalAccessor);

        // Assert they are the same instant and ZoneId
        assertSameInstant(dateTime, zonedDateTime.toInstant());
        assertSameZoneId(dateTime, zonedDateTime);


    }

    /*
    This method is written in support of recipe:
        DateTime-constructor-TemporalAccessor-DateTimeZone.yaml

    This method accepts a Joda-Time ReadableInstant, and an equivalent java.time TemporalAccessor that this
    ReadableInstant would be migrated to.
    It can use these 2 to verify that the transformation in the recipe is correct.
 */
    private void test_ReadableInstant_and_TemporalAccessor_OffsetDateTime(ReadableInstant readableInstant, TemporalAccessor temporalAccessor) {

        DateTime dateTime = new DateTime(readableInstant);
        OffsetDateTime offsetDateTime = OffsetDateTime.from(temporalAccessor);

        // Assert they are the same instant and ZoneId
        assertSameInstant(dateTime, offsetDateTime.toInstant());
        assertSameOffset(dateTime, offsetDateTime);


    }

    private void assertSameInstant(DateTime dateTime, java.time.Instant instant) {

        // Both should represent the same instant
        assertThat(dateTime.getMillis()).isEqualTo(instant.toEpochMilli());

    }

    /*
        Used when we are testing .now(), just check our objects represent an instant within a second of each other
        Possibly could use AOP to modify clock behaviour. There is a now(Clock clock) method
        however we are specifically testing the other method signatures of now()
     */
    private void assertCloseToInstant(DateTime dateTime, java.time.Instant instant) {

        // Both should represent almost the same instant
        assertThat(dateTime.getMillis()).isCloseTo(instant.toEpochMilli(), within(1000L));

    }

    private void assertSameZoneId(DateTime dateTime, ZonedDateTime zonedDateTime) {

        // Both should be in the same Zone
        assertThat(dateTime.getZone().getID()).isEqualTo(zonedDateTime.getZone().getId());

    }

    private void assertSameOffset(DateTime dateTime, OffsetDateTime offsetDateTime) {

        // Offsets should be the same. Use Joda Duration to compare
        Duration jodaOffset = Duration.ofMillis(dateTime.getZone().getOffset(dateTime));
        Duration javaOffset = Duration.ofSeconds(offsetDateTime.getOffset().getTotalSeconds());

        assertThat(jodaOffset).isEqualTo(javaOffset);

    }

    @Test
    public void Instant_cannot_be_used_in_ZonedDateTime_from() {

        Instant instant = Instant.now();

        assertThrows(DateTimeException.class, () -> ZonedDateTime.from(instant));

    }

    @Test
    public void Instant_cannot_be_used_in_OffsetDateTime_from() {

        Instant instant = Instant.now();

        assertThrows(DateTimeException.class, () -> OffsetDateTime.from(instant));

    }

}
