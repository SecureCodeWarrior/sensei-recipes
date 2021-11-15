package util;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class JodaTimeToJavaTimeTestUtil {

    public static void assertSameInstantAndZoneId(DateTime dateTime, ZonedDateTime zonedDateTime) {

        assertSameInstant(dateTime, zonedDateTime.toInstant());
        assertSameZoneId(dateTime, zonedDateTime);

    }

    public static void assertSameInstantAndOffset(DateTime dateTime, OffsetDateTime offsetDateTime) {
        assertSameInstant(dateTime, offsetDateTime.toInstant());
        assertSameOffset(dateTime, offsetDateTime);
    }

    public static void assertSameInstant(DateTime dateTime, OffsetDateTime offsetDateTime) {
        assertSameInstant(dateTime, offsetDateTime.toInstant());
    }

    public static void assertSameInstant(DateTime dateTime, ZonedDateTime zonedDateTime) {
        assertSameInstant(dateTime, zonedDateTime.toInstant());
    }

    public static void assertSameInstant(DateTime dateTime, java.time.Instant instant) {

        // Both should represent the same instant
        assertThat(dateTime.getMillis()).isEqualTo(instant.toEpochMilli());

    }

    /*
        Used when we are testing .now(), just check our objects represent an instant within a second of each other
        Possibly could use AOP to modify clock behaviour. There is a now(Clock clock) method
        however we are specifically testing the other method signatures of now()
     */
    public static void assertCloseToInstant(DateTime dateTime, java.time.Instant instant) {

        // Both should represent almost the same instant
        assertThat(dateTime.getMillis()).isCloseTo(instant.toEpochMilli(), within(1000L));

    }

    public static void assertSameZoneId(DateTime dateTime, ZonedDateTime zonedDateTime) {

        // Both should be in the same Zone
        assertThat(dateTime.getZone().getID()).isEqualTo(zonedDateTime.getZone().getId());

    }

    public static void assertSameOffset(DateTime dateTime, OffsetDateTime offsetDateTime) {

        // Offsets should be the same. Use Joda Duration to compare
        Duration jodaOffset = Duration.ofMillis(dateTime.getZone().getOffset(dateTime));
        Duration javaOffset = Duration.ofSeconds(offsetDateTime.getOffset().getTotalSeconds());

        assertThat(jodaOffset).isEqualTo(javaOffset);

    }

    public static void assertSameLocalDate(LocalDate jodaLocalDate, java.time.LocalDate javaLocalDate) {

        assertThat(javaLocalDate.getYear()).isEqualTo(jodaLocalDate.getYear());
        assertThat(javaLocalDate.getMonthValue()).isEqualTo(jodaLocalDate.getMonthOfYear());
        assertThat(javaLocalDate.getDayOfMonth()).isEqualTo(jodaLocalDate.getDayOfMonth());

    }

    public static void assertSameLocalTime(LocalTime jodaLocalTime, java.time.LocalTime javaLocalTime) {

        assertThat(javaLocalTime.getHour()).isEqualTo(jodaLocalTime.getHourOfDay());
        assertThat(javaLocalTime.getMinute()).isEqualTo(jodaLocalTime.getMinuteOfHour());
        assertThat(javaLocalTime.getSecond()).isEqualTo(jodaLocalTime.getSecondOfMinute());
        assertThat(javaLocalTime.get(ChronoField.MILLI_OF_SECOND)).isEqualTo(jodaLocalTime.getMillisOfSecond());

    }

    public static void assertSameLocalDateTime(LocalDateTime jodaLocalDateTime, java.time.LocalDateTime javaLocalDateTime) {

        assertSameLocalDate(jodaLocalDateTime.toLocalDate(), javaLocalDateTime.toLocalDate());
        assertSameLocalTime(jodaLocalDateTime.toLocalTime(), javaLocalDateTime.toLocalTime());

    }

    public static void assertDifferentInstant(DateTime dateTime, ZonedDateTime zonedDateTime) {

        assertThat(zonedDateTime.toInstant().toEpochMilli()).isNotEqualTo(dateTime.getMillis());

    }

    public static void assertDifferentInstant(DateTime dateTime, OffsetDateTime offsetDateTime) {

        assertThat(offsetDateTime.toInstant().toEpochMilli()).isNotEqualTo(dateTime.getMillis());

    }


}
