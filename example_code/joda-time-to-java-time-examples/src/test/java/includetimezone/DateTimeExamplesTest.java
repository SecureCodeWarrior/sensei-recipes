package includetimezone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
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
    public void test_withZone_equivalent() {

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
    public void test_withZoneRetainFields() {

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
    public void test_datetime_toString() {

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

            System.out.println(zoneId);

            //assertThat(zdt.toOffsetDateTime().toString()).isEqualTo(dt.toString());
            assertThat(zdt.format(DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSSXXX"))).isEqualTo(dt.toString());
            //assertThat(zdt.toString()).isNotEqualTo(dt.toString());

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


}
