package includetimezone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

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

}
