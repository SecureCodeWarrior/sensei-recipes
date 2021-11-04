package includetimezone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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

    @Test
    public void test_toMutableDateTime_ZoneID() {

        /*
         This test is to demonstrate that the Joda-Time method:
            toDateTime(DateTimeZone)
         Is equivalent to the java.time method:
            withZoneSameInstant(ZoneId)
         */


        DateTimeZone maldives = DateTimeZone.forID("Indian/Maldives");
        ZoneId maldivesZoneId = ZoneId.of("Indian/Maldives");

        DateTime dateTimeHere = DateTime.now();

        DateTime dateTimeMaldives = dateTimeHere.toDateTime(maldives);
        MutableDateTime mutableDateTimeMaldives = dateTimeHere.toMutableDateTime(maldives);

        long originalLong = dateTimeHere.getMillis();
        long maldivesLong = dateTimeMaldives.getMillis();
        long maldivesMutableLong = mutableDateTimeMaldives.getMillis();

        assertThat(maldivesLong).isEqualTo(originalLong);
        assertThat(maldivesMutableLong).isEqualTo(originalLong);

        // Test Equivalent Functionality in java.time
        java.time.ZonedDateTime zdt = Instant.ofEpochMilli(originalLong).atZone(ZoneId.systemDefault());
        java.time.ZonedDateTime zdtMaldives = zdt.withZoneSameInstant(maldivesZoneId);

        long zdtLong = zdt.toInstant().toEpochMilli();
        long zdtLongMaldives = zdtMaldives.toInstant().toEpochMilli();

        assertThat(zdtLongMaldives).isEqualTo(zdtLong);

    }

}
