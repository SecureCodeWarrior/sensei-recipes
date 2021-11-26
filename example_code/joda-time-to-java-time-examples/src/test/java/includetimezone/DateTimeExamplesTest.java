package includetimezone;

import org.joda.time.*;
import org.junit.jupiter.api.Test;
import util.JodaTimeToJavaTimeTestUtil;

import java.time.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTimeExamplesTest {


    @Test
    public void test_constructor_with_millis_same_as_of_with_nanos() {

        int year = 2021;
        int month = 11;
        int day = 8;
        int hour = 4;
        int minute = 45;
        int seconds = 23;
        int millis = 33;


        org.joda.time.DateTime jodaDateTime = new DateTime(year, month, day, hour, minute, seconds, millis, DateTimeZone.UTC);

        java.time.ZonedDateTime javaDateTime = java.time.ZonedDateTime.of(year, month, day, hour, minute, seconds,0, ZoneId.of("UTC")).with(ChronoField.MILLI_OF_SECOND, millis);

        long jodaDateTimeMillis = jodaDateTime.getMillis();
        long javaDateTimeMillis = javaDateTime.toInstant().toEpochMilli();

        assertEquals(jodaDateTimeMillis, javaDateTimeMillis);


    }

    /*
        This test is to demonstrate that the Joda-Time method:
            toDateTime(DateTimeZone)
            toMutableDateTime(DateTimeZone) with obvious side effects
        Is equivalent to the java.time methods:
            ZonedDateTime  withZoneSameInstant(ZoneId)
            OffsetDateTime atZoneSameInstant(ZoneId)
    */
    @Test
    public void test_toDateTime_ZoneID() {


        DateTimeZone maldives = DateTimeZone.forID("Indian/Maldives");
        ZoneId maldivesZoneId = ZoneId.of("Indian/Maldives");

        DateTime dateTimeHere = DateTime.now();
        long originalLong = dateTimeHere.getMillis();

        DateTime dateTimeMaldives = dateTimeHere.toDateTime(maldives);

        // Test Equivalent Functionality in java.time
        MutableDateTime mutableDateTimeMaldives = dateTimeHere.toMutableDateTime(maldives);
        java.time.ZonedDateTime zdt = Instant.ofEpochMilli(originalLong).atZone(ZoneId.systemDefault());
        java.time.OffsetDateTime odt = zdt.toOffsetDateTime();
        java.time.ZonedDateTime zdtMaldives = zdt.withZoneSameInstant(maldivesZoneId);
        java.time.ZonedDateTime odtMaldives = odt.atZoneSameInstant(maldivesZoneId);

        long zdtLong = zdt.toInstant().toEpochMilli();
        long mutableLongMaldives = mutableDateTimeMaldives.getMillis();
        long zdtLongMaldives = zdtMaldives.toInstant().toEpochMilli();
        long odtLongMaldives = odtMaldives.toInstant().toEpochMilli();

        // All Represent the same instant
        assertThat(zdtLongMaldives).isEqualTo(zdtLong).isEqualTo(odtLongMaldives).isEqualTo(originalLong).isEqualTo(mutableLongMaldives);

        // Default Zone all have the same hour
        assertThat(dateTimeHere.getHourOfDay())
                .isEqualTo(zdt.getHour())
                .isEqualTo(odt.getHour());

        // Maldives Zone all have the same hour
        assertThat(dateTimeMaldives.getHourOfDay())
                .isEqualTo(zdtMaldives.getHour())
                .isEqualTo(mutableDateTimeMaldives.getHourOfDay())
                .isEqualTo(odtMaldives.getHour());

        // Hour is different here and maldives
        assertThat(dateTimeHere.getHourOfDay()).isNotEqualTo(dateTimeMaldives.getHourOfDay());


    }

    @Test
    public void test_constructors_equivalent() {

        Date date = new Date();

        // Test equivalent used for recipe DateTime-constructor-Date
        DateTime fromDate = new DateTime(date);
        ZonedDateTime fromDateZdt = ZonedDateTime.ofInstant(date.toInstant(), java.time.ZoneId.systemDefault());
        OffsetDateTime fromDateOdt = OffsetDateTime.ofInstant(date.toInstant(), java.time.ZoneId.systemDefault());

        assertThat(fromDate.getMillis()).isEqualTo(fromDateZdt.toInstant().toEpochMilli());
        assertThat(fromDate.getMillis()).isEqualTo(fromDateOdt.toInstant().toEpochMilli());

        assertThat(fromDate.getHourOfDay()).isEqualTo(fromDateZdt.getHour());
        assertThat(fromDate.getHourOfDay()).isEqualTo(fromDateOdt.getHour());

        assertThat(fromDate.getMinuteOfHour()).isEqualTo(fromDateZdt.getMinute());
        assertThat(fromDate.getMinuteOfHour()).isEqualTo(fromDateOdt.getMinute());


    }

    /*
        This test is to demonstrate that the Joda-Time method:
            withZone(DateTimeZone)
        Is equivalent to the java.time methods:
            ZonedDateTime withZoneSameInstant(ZoneId)
            OffsetDateTime atZoneSameInstant(ZoneId)
    */
    @Test
    void withZone_DateTimeZone() {

        // Establish the instant will we test
        DateTime dateTime = DateTime.now();
        long originalLong = dateTime.getMillis();

        // Zones to use
        DateTimeZone maldives = DateTimeZone.forID("Indian/Maldives");
        ZoneId maldivesZoneId = ZoneId.of("Indian/Maldives");

        // Get Maldives DateTime using Joda-Time
        DateTime dateTimeMaldives = dateTime.withZone(maldives);

        // Test Equivalent Functionality in java.time
        java.time.ZonedDateTime zdt = Instant.ofEpochMilli(originalLong).atZone(ZoneId.systemDefault());
        java.time.ZonedDateTime zdtMaldives = zdt.withZoneSameInstant(maldivesZoneId);
        java.time.OffsetDateTime odt = zdt.toOffsetDateTime();
        java.time.ZonedDateTime odtMaldives = odt.atZoneSameInstant(maldivesZoneId);

        // All Dates should represent the same instant
        assertThat(originalLong).isEqualTo(dateTime.getMillis());
        assertThat(originalLong).isEqualTo(dateTimeMaldives.getMillis());
        assertThat(originalLong).isEqualTo(zdt.toInstant().toEpochMilli());
        assertThat(originalLong).isEqualTo(zdtMaldives.toInstant().toEpochMilli());
        assertThat(originalLong).isEqualTo(odtMaldives.toInstant().toEpochMilli());

        // ZonedDateTime should be the same hour of day in both Joda-Time and java.time
        assertThat(dateTime.getHourOfDay()).isEqualTo(zdt.getHour());
        assertThat(dateTime.getHourOfDay()).isEqualTo(odt.getHour());

        // Hours of Day should be different in Maldives
        assertThat(dateTime.getHourOfDay()).isNotEqualTo(dateTimeMaldives.getHourOfDay());
        assertThat(zdt.getHour()).isNotEqualTo(zdtMaldives.getHour());
        assertThat(odt.getHour()).isNotEqualTo(odtMaldives.getHour());

        // DateTime Maldives and ZonedDateTime maldives should have the same hour
        assertThat(dateTimeMaldives.getHourOfDay()).isEqualTo(zdtMaldives.getHour()).isEqualTo(odtMaldives.getHour());

    }

    /*
        This test is to demonstrate that the Joda-Time method:
            withZoneRetainFields(DateTimeZone)
        Is equivalent to the java.time methods:
            ZonedDateTime: withZoneSameLocal(ZoneId)
            OffsetDateTime: atZoneSimilarLocal(ZoneId)
    */
    @Test
    void withZoneRetainFields_DateTimeZone() {

        // Establish the instant will we test
        DateTime dateTime = DateTime.now();
        long originalLong = dateTime.getMillis();

        // Zones to use
        DateTimeZone maldivesDateTimeZone = DateTimeZone.forID("Indian/Maldives");
        ZoneId maldivesZoneId = ZoneId.of("Indian/Maldives");

        // Get Maldives DateTime using Joda-Time withZoneRetainFields
        DateTime dateTimeMaldives = dateTime.withZoneRetainFields(maldivesDateTimeZone);

        // Test Equivalent Functionality in java.time
        java.time.ZonedDateTime zdt = Instant.ofEpochMilli(originalLong).atZone(ZoneId.systemDefault());
        java.time.ZonedDateTime zdtMaldives = zdt.withZoneSameLocal(maldivesZoneId);
        java.time.OffsetDateTime odt = zdt.toOffsetDateTime();
        java.time.ZonedDateTime odtMaldives = odt.atZoneSimilarLocal(maldivesZoneId);

        // Default Zone Dates should represent the same instant
        assertThat(originalLong).isEqualTo(dateTime.getMillis());
        assertThat(originalLong).isEqualTo(zdt.toInstant().toEpochMilli());
        assertThat(originalLong).isEqualTo(odt.toInstant().toEpochMilli());

        // Maldives dates represent a different instant
        assertThat(originalLong).isNotEqualTo(dateTimeMaldives.getMillis());
        assertThat(originalLong).isNotEqualTo(zdtMaldives.toInstant().toEpochMilli());
        assertThat(originalLong).isNotEqualTo(odtMaldives.toInstant().toEpochMilli());

        // Maldives Dates both represent the same instant
        assertThat(dateTimeMaldives.getMillis()).isEqualTo(zdtMaldives.toInstant().toEpochMilli());
        assertThat(dateTimeMaldives.getMillis()).isEqualTo(odtMaldives.toInstant().toEpochMilli());

        // ZonedDateTime should be the same hour of day in both Joda-Time and java.time
        assertThat(dateTime.getHourOfDay()).isEqualTo(zdt.getHour());
        assertThat(dateTime.getHourOfDay()).isEqualTo(odt.getHour());

        // Hours of Day should be same for Default Zone and Maldives
        assertThat(dateTime.getHourOfDay()).isEqualTo(dateTimeMaldives.getHourOfDay());
        assertThat(zdt.getHour()).isEqualTo(zdtMaldives.getHour());
        assertThat(odt.getHour()).isEqualTo(odtMaldives.getHour());

        // DateTime Maldives and ZonedDateTime maldives should have the same hour
        assertThat(dateTimeMaldives.getHourOfDay()).isEqualTo(zdtMaldives.getHour()).isEqualTo(odtMaldives.getHour());

    }

    @Test
    public void dateTime_toString() {

        ZonedDateTime now = ZonedDateTime.now();

        test_datetime_toString(now);

        //String pattern = "uuuu-MM-dd'T'HH:mm:ss.SSSX"
        test_datetime_toString(now.withNano(0));
        test_datetime_toString(now.withNano(10));
        test_datetime_toString(now.withNano(100));
        test_datetime_toString(now.withNano(1000));
        test_datetime_toString(now.withNano(10000));
        test_datetime_toString(now.withNano(100000));
        test_datetime_toString(now.withNano(1000000));
        test_datetime_toString(now.withNano(10000000));
        test_datetime_toString(now.withNano(900000000));
        test_datetime_toString(now.withNano(987654321));
        test_datetime_toString(now.withNano(123456789));
        test_datetime_toString(now.withSecond(0));
        test_datetime_toString(now.withMinute(0).withSecond(0));

    }

    private void test_datetime_toString(ZonedDateTime zonedDateTime) {

        long instant = zonedDateTime.toInstant().toEpochMilli();

        ZoneId.getAvailableZoneIds()
                .stream().filter(z -> !z.startsWith("System"))
                .forEach(zoneId -> {

            DateTimeZone dateTimeZone = DateTimeZone.forID(zoneId);

            // Create a Joda-Time DateTime at this instant in the specified Zone
            DateTime dt = org.joda.time.Instant.ofEpochMilli(instant).toDateTime(dateTimeZone);
            // Create a java.time ZonedDateTime at this instant in the specified Zone
            ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.ofEpochMilli(instant), ZoneId.of(zoneId));
            OffsetDateTime odt = zdt.toOffsetDateTime();

            String pattern = "uuuu-MM-dd'T'HH:mm:ss.SSSXXX";

            assertThat(zdt.format(DateTimeFormatter.ofPattern(pattern))).isEqualTo(dt.toString());
            assertThat(odt.format(DateTimeFormatter.ofPattern(pattern))).isEqualTo(dt.toString());

            String examplesMethod = DateTimeExamples.toString(instant, zoneId);
            assertThat(examplesMethod).isEqualTo(dt.toString());

        });

    }

    @Test
    void getMillis() {

        DateTime dateTime = DateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(java.time.Instant.ofEpochMilli(dateTime.getMillis()), ZoneId.systemDefault());

        assertThat(zonedDateTime.toInstant().toEpochMilli()).isEqualTo(dateTime.getMillis());

    }

    @Test
    void isAfterNow() {

        DateTime dateTime = DateTime.now().withTimeAtStartOfDay();

        for (int i = 0; i < 24; i++) {

            ZonedDateTime zonedDateTime = equivalentZonedDateTime(dateTime);
            OffsetDateTime offsetDateTime = zonedDateTime.toOffsetDateTime();

            assertThat(zonedDateTime.isAfter(ZonedDateTime.now())).isEqualTo(dateTime.isAfterNow());
            assertThat(offsetDateTime.isAfter(OffsetDateTime.now())).isEqualTo(dateTime.isAfterNow());

        }

    }

    @Test
    void isBeforeNow() {

        DateTime dateTime = DateTime.now().withTimeAtStartOfDay();

        for (int i = 0; i < 24; i++) {

            ZonedDateTime zonedDateTime = equivalentZonedDateTime(dateTime);
            OffsetDateTime offsetDateTime = zonedDateTime.toOffsetDateTime();

            assertThat(zonedDateTime.isBefore(ZonedDateTime.now())).isEqualTo(dateTime.isBeforeNow());
            assertThat(offsetDateTime.isBefore(OffsetDateTime.now())).isEqualTo(dateTime.isBeforeNow());

        }

    }

    private ZonedDateTime equivalentZonedDateTime(DateTime dateTime) {
        ZoneId zoneId = ZoneId.of(dateTime.getZone().getID());
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(dateTime.getMillis()), zoneId);
    }

    @Test
    void minus_long() {

        LongStream.range(-10000, 10000).forEach(l -> {

            DateTime dateTime = DateTime.now();
            DateTime dateTimeResult = dateTime.minus(l);

            ZonedDateTime zonedDateTime = equivalentZonedDateTime(dateTime);
            OffsetDateTime offsetDateTime = zonedDateTime.toOffsetDateTime();

            ZonedDateTime zonedDateTimeResult = zonedDateTime.minus(l, ChronoUnit.MILLIS);
            OffsetDateTime offsetDateTimeResult = offsetDateTime.minus(l, ChronoUnit.MILLIS);

            JodaTimeToJavaTimeTestUtil.assertSameInstantAndZoneId(dateTimeResult, zonedDateTimeResult);
            JodaTimeToJavaTimeTestUtil.assertSameInstantAndOffset(dateTimeResult, offsetDateTimeResult);

        });

    }

    @Test
    void plus_long() {

        LongStream.range(-10000, 10000).forEach(l -> {

            DateTime dateTime = DateTime.now();
            DateTime dateTimeResult = dateTime.plus(l);

            ZonedDateTime zonedDateTime = equivalentZonedDateTime(dateTime);
            OffsetDateTime offsetDateTime = zonedDateTime.toOffsetDateTime();

            ZonedDateTime zonedDateTimeResult = zonedDateTime.plus(l, ChronoUnit.MILLIS);
            OffsetDateTime offsetDateTimeResult = offsetDateTime.plus(l, ChronoUnit.MILLIS);

            JodaTimeToJavaTimeTestUtil.assertSameInstantAndZoneId(dateTimeResult, zonedDateTimeResult);
            JodaTimeToJavaTimeTestUtil.assertSameInstantAndOffset(dateTimeResult, offsetDateTimeResult);


        });

    }

    @Test
    void toDate() {

        DateTime dateTime = DateTime.now();
        ZonedDateTime zonedDateTime = equivalentZonedDateTime(dateTime);
        OffsetDateTime offsetDateTime = zonedDateTime.toOffsetDateTime();

        Date date = dateTime.toDate();

        Date zdtDate = Date.from(zonedDateTime.toInstant());
        Date odtDate = Date.from(offsetDateTime.toInstant());

        assertThat(zdtDate).isEqualTo(date);
        assertThat(odtDate).isEqualTo(date);

    }

    @Test
    void toDateMidnight() {

        String testZone = "Asia/Tokyo";
        ZoneId zoneId = ZoneId.of(testZone);
        DateTime dateTime = DateTime.now().withZone(DateTimeZone.forID(testZone));
        ZonedDateTime zonedDateTime = equivalentZonedDateTime(dateTime);
        OffsetDateTime offsetDateTime = zonedDateTime.toOffsetDateTime();

        DateMidnight dateMidnight = dateTime.toDateMidnight();
        ZonedDateTime zdt = zonedDateTime.toLocalDate().atStartOfDay(zonedDateTime.getZone());
        OffsetDateTime odt = offsetDateTime.toLocalDate().atStartOfDay().atOffset(offsetDateTime.getOffset());

        JodaTimeToJavaTimeTestUtil.assertSameInstantAndZoneId(dateMidnight.toDateTime(), zdt);
        JodaTimeToJavaTimeTestUtil.assertSameInstantAndOffset(dateMidnight.toDateTime(), odt);

    }

    @Test
    void toDateTime_DateTimeZone() {

        Set<String> zoneIds = new HashSet<>();

        zoneIds.add("Asia/Tokyo");
        zoneIds.add("Europe/Berlin");
        zoneIds.add("Europe/Helsinki");
        zoneIds.add("America/Denver");
        zoneIds.add("Europe/Stockholm");
        zoneIds.add("Europe/Lisbon");
        zoneIds.add("Africa/Nairobi");
        zoneIds.add("America/Rio_Branco");

        DateTime dateTime = DateTime.now();
        ZonedDateTime zonedDateTime = equivalentZonedDateTime(dateTime);
        OffsetDateTime offsetDateTime = zonedDateTime.toOffsetDateTime();

        zoneIds.forEach(z -> {

            ZoneId zoneId = ZoneId.of(z);
            DateTimeZone dateTimeZone = DateTimeZone.forID(z);

            DateTime dateTimeThere = dateTime.toDateTime(dateTimeZone);
            MutableDateTime mutableDateTimeThere = dateTime.toMutableDateTime(dateTimeZone);

            ZonedDateTime zonedDateTimeThere = zonedDateTime.withZoneSameInstant(zoneId);
            ZonedDateTime zonedDateTimeThereFromOffsetDateTime = offsetDateTime.atZoneSameInstant(zoneId);

            JodaTimeToJavaTimeTestUtil.assertSameInstantAndZoneId(dateTimeThere, zonedDateTimeThere);
            JodaTimeToJavaTimeTestUtil.assertSameInstantAndZoneId(dateTimeThere, zonedDateTimeThereFromOffsetDateTime);
            JodaTimeToJavaTimeTestUtil.assertSameInstantAndZoneId(mutableDateTimeThere, zonedDateTimeThere);
            JodaTimeToJavaTimeTestUtil.assertSameInstantAndZoneId(mutableDateTimeThere, zonedDateTimeThereFromOffsetDateTime);

        });

        IntStream.range(-12,14).forEach(o -> {

            DateTimeZone dateTimeZoneOffset = DateTimeZone.forOffsetHours(o);
            ZoneOffset zoneOffset = ZoneOffset.ofHours(o);

            DateTime dateTimeOffset = dateTime.toDateTime(dateTimeZoneOffset);
            MutableDateTime mutableDateTimeOffset = dateTime.toMutableDateTime(dateTimeZoneOffset);
            OffsetDateTime offsetDateTimeOffset = offsetDateTime.withOffsetSameInstant(zoneOffset);

            JodaTimeToJavaTimeTestUtil.assertSameInstantAndOffset(dateTimeOffset, offsetDateTimeOffset);
            JodaTimeToJavaTimeTestUtil.assertSameInstantAndOffset(mutableDateTimeOffset, offsetDateTimeOffset);

        });

    }

    @Test
    void toDateTime() {

        DateTime dateTime = DateTime.now();
        ZonedDateTime zonedDateTime = equivalentZonedDateTime(dateTime);
        OffsetDateTime offsetDateTime = zonedDateTime.toOffsetDateTime();

        JodaTimeToJavaTimeTestUtil.assertSameInstantAndZoneId(dateTime.toDateTime(), zonedDateTime);
        JodaTimeToJavaTimeTestUtil.assertSameInstantAndZoneId(dateTime.toDateTimeISO(), zonedDateTime);

        JodaTimeToJavaTimeTestUtil.assertSameInstantAndOffset(dateTime.toDateTime(), offsetDateTime);
        JodaTimeToJavaTimeTestUtil.assertSameInstantAndOffset(dateTime.toDateTimeISO(), offsetDateTime);

    }

    @Test
    void toMutableDateTime() {

        DateTime dateTime = DateTime.now();
        ZonedDateTime zonedDateTime = equivalentZonedDateTime(dateTime);
        OffsetDateTime offsetDateTime = zonedDateTime.toOffsetDateTime();

        JodaTimeToJavaTimeTestUtil.assertSameInstantAndZoneId(dateTime.toMutableDateTime(), zonedDateTime);
        JodaTimeToJavaTimeTestUtil.assertSameInstantAndZoneId(dateTime.toMutableDateTimeISO(), zonedDateTime);

        JodaTimeToJavaTimeTestUtil.assertSameInstantAndOffset(dateTime.toMutableDateTime(), offsetDateTime);
        JodaTimeToJavaTimeTestUtil.assertSameInstantAndOffset(dateTime.toMutableDateTimeISO(), offsetDateTime);

    }

    @Test
    void toGregorianCalendar() {

        DateTime dateTime = DateTime.now();
        ZonedDateTime zonedDateTime = equivalentZonedDateTime(dateTime);
        OffsetDateTime offsetDateTime = zonedDateTime.toOffsetDateTime();

        GregorianCalendar gcDateTime = dateTime.toGregorianCalendar();
        GregorianCalendar gcZonedDateTime = GregorianCalendar.from(zonedDateTime);
        GregorianCalendar gcOffsetDateTime = GregorianCalendar.from(offsetDateTime.toZonedDateTime());

        // Assert GregorianCalendar from zonedDateTime has same TimeZone and Millis
        assertThat(gcZonedDateTime.getTimeZone()).isEqualTo(gcDateTime.getTimeZone());
        assertThat(gcZonedDateTime.getTimeInMillis()).isEqualTo(gcDateTime.getTimeInMillis());

        // Assert GregorianCalendar from offsetDateTime has same Offset and Millis
        assertThat(gcOffsetDateTime.getTimeInMillis()).isEqualTo(gcDateTime.getTimeInMillis());
        assertThat(gcOffsetDateTime.getTimeZone().getOffset(gcOffsetDateTime.getTimeInMillis())).isEqualTo(gcDateTime.getTimeZone().getOffset(gcDateTime.getTimeInMillis()));

    }

    @Test
    void toTimeOfDay() {

        DateTime dateTime = DateTime.now();
        ZonedDateTime zonedDateTime = equivalentZonedDateTime(dateTime);
        OffsetDateTime offsetDateTime = zonedDateTime.toOffsetDateTime();

        TimeOfDay timeOfDay = dateTime.toTimeOfDay();

        LocalTime zdtLocalTime = zonedDateTime.toLocalTime();
        LocalTime odtLocalTime = offsetDateTime.toLocalTime();

        JodaTimeToJavaTimeTestUtil.assertSameLocalTime(timeOfDay, zdtLocalTime);
        JodaTimeToJavaTimeTestUtil.assertSameLocalTime(timeOfDay, odtLocalTime);


    }

    @Test
    void toYearMonthDay() {

        DateTime dateTime = DateTime.now();
        ZonedDateTime zonedDateTime = equivalentZonedDateTime(dateTime);
        OffsetDateTime offsetDateTime = zonedDateTime.toOffsetDateTime();

        YearMonthDay yearMonthDay = dateTime.toYearMonthDay();

        LocalDate zdtLocalDate = zonedDateTime.toLocalDate();
        LocalDate odtLocalDate = offsetDateTime.toLocalDate();

        JodaTimeToJavaTimeTestUtil.assertSameLocalDate(yearMonthDay, zdtLocalDate);
        JodaTimeToJavaTimeTestUtil.assertSameLocalDate(yearMonthDay, odtLocalDate);

    }


}
