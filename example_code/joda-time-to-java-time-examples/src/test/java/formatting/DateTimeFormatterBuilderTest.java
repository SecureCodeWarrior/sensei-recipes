package formatting;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.format.SignStyle;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.IsoFields;

import static org.assertj.core.api.Assertions.assertThat;

class DateTimeFormatterBuilderTest {

    @Test
    void test_appendLiteral() {
        LocalDate jodaLocalDate = new LocalDate(2021, 1, 17);
        java.time.LocalDate javaLocalDate = java.time.LocalDate.of(2021, 1, 17);

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendLiteral('%');
        javaBuilder = javaBuilder.appendLiteral('%');

        DateTimeFormatter jodaFormatter =  jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaLocalDate)).isEqualTo(javaFormatter.format(javaLocalDate));
    }

    @Test
    void test_appendTimeZoneName() {
        DateTime jodaDateTime = new DateTime(2021, 1, 17, 10, 30, 20);
        java.time.ZonedDateTime javaDateTime = java.time.ZonedDateTime.of(2021, 1, 17, 10, 30, 20, 0, ZoneId.systemDefault());

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendTimeZoneName();
        javaBuilder = javaBuilder.appendZoneText(TextStyle.FULL);

        DateTimeFormatter jodaFormatter =  jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaDateTime)).isEqualTo(javaFormatter.format(javaDateTime));
    }

    @Test
    void test_appendTimeZoneShortName() {
        DateTime jodaDateTime = new DateTime(2021, 1, 17, 10, 30, 20);
        java.time.ZonedDateTime javaDateTime = java.time.ZonedDateTime.of(2021, 1, 17, 10, 30, 20, 0, ZoneId.systemDefault());

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendTimeZoneShortName();
        javaBuilder = javaBuilder.appendZoneText(TextStyle.SHORT);

        DateTimeFormatter jodaFormatter =  jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaDateTime)).isEqualTo(javaFormatter.format(javaDateTime));
    }

    @Test
    void test_appendMonthOfYear() {
        LocalDate jodaLocalDate = new LocalDate(2021, 10, 17);
        java.time.LocalDate javaLocalDate = java.time.LocalDate.of(2021, 10, 17);

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendMonthOfYear(2);
        javaBuilder = javaBuilder.appendValue(ChronoField.MONTH_OF_YEAR, 2);

        DateTimeFormatter jodaFormatter =  jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaLocalDate)).isEqualTo(javaFormatter.format(javaLocalDate));
    }

    @Test
    void test_appendDayOfMonth() {
        LocalDate jodaLocalDate = new LocalDate(2021, 1, 17);
        java.time.LocalDate javaLocalDate = java.time.LocalDate.of(2021, 1, 17);

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendDayOfMonth(19);
        javaBuilder = javaBuilder.appendValue(ChronoField.DAY_OF_MONTH, 19);

        DateTimeFormatter jodaFormatter =  jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaLocalDate)).isEqualTo(javaFormatter.format(javaLocalDate));
    }

    @Test
    void test_appendHourOfDay() {
        LocalDateTime jodaDateTime = new LocalDateTime(2021, 1, 17, 22, 30, 20);
        java.time.LocalDateTime javaDateTime = java.time.LocalDateTime.of(2021, 1, 17, 22, 30, 20);

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendHourOfDay(2);
        javaBuilder = javaBuilder.appendValue(ChronoField.HOUR_OF_DAY, 2);

        DateTimeFormatter jodaFormatter =  jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaDateTime)).isEqualTo(javaFormatter.format(javaDateTime));
    }

    @Test
    void test_appendYear() {
        LocalDateTime jodaDateTime = new LocalDateTime(2021, 1, 17, 22, 30, 20);
        java.time.LocalDateTime javaDateTime = java.time.LocalDateTime.of(2021, 1, 17, 22, 30, 20);

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendYear(2, 4);
        javaBuilder = javaBuilder.appendValue(ChronoField.YEAR, 2, 4, SignStyle.NEVER);

        DateTimeFormatter jodaFormatter =  jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaDateTime)).isEqualTo(javaFormatter.format(javaDateTime));
    }

    @Test
    void test_appendFractionOfDay() {
        LocalDateTime jodaDateTime = new LocalDateTime(2021, 1, 17, 3, 5, 20);
        java.time.LocalDateTime javaDateTime = java.time.LocalDateTime.of(2021, 1, 17, 3, 5, 20);

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendFractionOfDay(2, 4);
        javaBuilder = javaBuilder.appendFraction(ChronoField.MILLI_OF_DAY, 2, 4, false);
        DateTimeFormatter jodaFormatter =  jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaDateTime)).isEqualTo(javaFormatter.format(javaDateTime));
    }

    @Test
    void appendFractionOfHour() {
        LocalDateTime jodaDateTime = new LocalDateTime(2021, 1, 17, 3, 45, 00);
        java.time.LocalDateTime javaDateTime = java.time.LocalDateTime.of(2021, 1, 17, 3, 45, 00);

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendFractionOfHour(2, 4);
        javaBuilder = javaBuilder.appendFraction(ChronoField.MINUTE_OF_HOUR, 2, 4, false);
        DateTimeFormatter jodaFormatter =  jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaDateTime)).isEqualTo(javaFormatter.format(javaDateTime));
    }

    @Test
    void appendFractionOfMinute() {
        LocalDateTime jodaDateTime = new LocalDateTime(2021, 1, 17, 3, 45, 36);
        java.time.LocalDateTime javaDateTime = java.time.LocalDateTime.of(2021, 1, 17, 3, 45, 36);

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendFractionOfMinute(2, 6);
        javaBuilder = javaBuilder.appendFraction(ChronoField.SECOND_OF_MINUTE, 2, 6, false);
        DateTimeFormatter jodaFormatter =  jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaDateTime)).isEqualTo(javaFormatter.format(javaDateTime));
    }

    @Test
    void appendFractionOfSecond() {
        LocalDateTime jodaDateTime = new LocalDateTime(2021, 1, 17, 3, 45, 36, 1);
        java.time.LocalDateTime javaDateTime = java.time.LocalDateTime.of(2021, 1, 17, 3, 45, 36, 1000000);

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendFractionOfSecond(2, 6);
        javaBuilder = javaBuilder.appendFraction(ChronoField.MILLI_OF_SECOND, 2, 6, false);
        DateTimeFormatter jodaFormatter =  jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaDateTime)).isEqualTo(javaFormatter.format(javaDateTime));
    }

    @Test
    void test_appendClockhourOfDay() {
        LocalDateTime jodaDateTime = new LocalDateTime(2021, 1, 17, 15, 5, 20);
        java.time.LocalDateTime javaDateTime = java.time.LocalDateTime.of(2021, 1, 17, 15, 5, 20);

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendClockhourOfDay(2);
        javaBuilder = javaBuilder.appendValue(ChronoField.CLOCK_HOUR_OF_DAY, 2);
        DateTimeFormatter jodaFormatter =  jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaDateTime)).isEqualTo(javaFormatter.format(javaDateTime));
    }

    @Test
    void test_appendClockhourOfHalfday() {
        LocalDateTime jodaDateTime = new LocalDateTime(2021, 1, 17, 15, 5, 20);
        java.time.LocalDateTime javaDateTime = java.time.LocalDateTime.of(2021, 1, 17, 15, 5, 20);

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendClockhourOfHalfday(2);
        javaBuilder = javaBuilder.appendValue(ChronoField.CLOCK_HOUR_OF_AMPM, 2);
        DateTimeFormatter jodaFormatter =  jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaDateTime)).isEqualTo(javaFormatter.format(javaDateTime));
    }

    @Test
    void test_appendDayOfWeek() {
        LocalDate jodaLocalDate = new LocalDate(2021, 1, 18);
        java.time.LocalDate javaLocalDate = java.time.LocalDate.of(2021, 1, 18);

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendDayOfWeek(1);
        javaBuilder = javaBuilder.appendValue(ChronoField.DAY_OF_WEEK, 1);

        DateTimeFormatter jodaFormatter =  jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaLocalDate)).isEqualTo(javaFormatter.format(javaLocalDate));
    }

    @Test
    void test_appendDayOfYear() {
        LocalDate jodaLocalDate = new LocalDate(2021, 6, 18);
        java.time.LocalDate javaLocalDate = java.time.LocalDate.of(2021, 6, 18);

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendDayOfYear(3);
        javaBuilder = javaBuilder.appendValue(ChronoField.DAY_OF_YEAR, 3);

        DateTimeFormatter jodaFormatter =  jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaLocalDate)).isEqualTo(javaFormatter.format(javaLocalDate));
    }

    @Test
    void test_appendMillisOfSecond() {
        LocalDateTime jodaDateTime = new LocalDateTime(2021, 1, 17, 15, 5, 20);
        java.time.LocalDateTime javaDateTime = java.time.LocalDateTime.of(2021, 1, 17, 15, 5, 20);

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendMillisOfSecond(3);
        javaBuilder = javaBuilder.appendValue(java.time.temporal.ChronoField.MILLI_OF_SECOND, 3);

        DateTimeFormatter jodaFormatter =  jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaDateTime)).isEqualTo(javaFormatter.format(javaDateTime));
    }

    @Test
    void test_appendMinuteOfDay() {
        LocalDateTime jodaDateTime = new LocalDateTime(2021, 1, 17, 15, 5, 20);
        java.time.LocalDateTime javaDateTime = java.time.LocalDateTime.of(2021, 1, 17, 15, 5, 20);

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendMinuteOfDay(3);
        javaBuilder = javaBuilder.appendValue(java.time.temporal.ChronoField.MINUTE_OF_DAY, 3);

        DateTimeFormatter jodaFormatter =  jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaDateTime)).isEqualTo(javaFormatter.format(javaDateTime));
    }

    @Test
    void test_appendMinuteOfHour() {
        LocalDateTime jodaDateTime = new LocalDateTime(2021, 1, 17, 15, 5, 20);
        java.time.LocalDateTime javaDateTime = java.time.LocalDateTime.of(2021, 1, 17, 15, 5, 20);

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendMinuteOfHour(3);
        javaBuilder = javaBuilder.appendValue(java.time.temporal.ChronoField.MINUTE_OF_HOUR, 3);

        DateTimeFormatter jodaFormatter =  jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaDateTime)).isEqualTo(javaFormatter.format(javaDateTime));
    }

    @Test
    void test_appendSecondOfDay() {
        LocalDateTime jodaDateTime = new LocalDateTime(2021, 1, 17, 15, 5, 20);
        java.time.LocalDateTime javaDateTime = java.time.LocalDateTime.of(2021, 1, 17, 15, 5, 20);

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendSecondOfDay(5);
        javaBuilder = javaBuilder.appendValue(java.time.temporal.ChronoField.SECOND_OF_DAY, 5);

        DateTimeFormatter jodaFormatter =  jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaDateTime)).isEqualTo(javaFormatter.format(javaDateTime));
    }

    @Test
    void test_appendSecondOfMinute() {
        LocalDateTime jodaDateTime = new LocalDateTime(2021, 1, 17, 15, 5, 20);
        java.time.LocalDateTime javaDateTime = java.time.LocalDateTime.of(2021, 1, 17, 15, 5, 20);

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendSecondOfMinute(2);
        javaBuilder = javaBuilder.appendValue(ChronoField.SECOND_OF_MINUTE, 2);

        DateTimeFormatter jodaFormatter =  jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaDateTime)).isEqualTo(javaFormatter.format(javaDateTime));
    }

    @Test
    void test_appendSomethingShortText() {
        LocalDateTime jodaDateTime = new LocalDateTime(2021, 1, 17, 15, 5, 20);
        java.time.LocalDateTime javaDateTime = java.time.LocalDateTime.of(2021, 1, 17, 15, 5, 20);

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendDayOfWeekShortText();
        javaBuilder = javaBuilder.appendText(ChronoField.DAY_OF_WEEK, TextStyle.SHORT);

        DateTimeFormatter jodaFormatter = jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaDateTime)).isEqualTo(javaFormatter.format(javaDateTime));
    }

    @Test
    void test_appendSomethingText() {
        LocalDateTime jodaDateTime = new LocalDateTime(2021, 1, 17, 15, 5, 20);
        java.time.LocalDateTime javaDateTime = java.time.LocalDateTime.of(2021, 1, 17, 15, 5, 20);

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendDayOfWeekText();
        javaBuilder = javaBuilder.appendText(ChronoField.DAY_OF_WEEK);

        DateTimeFormatter jodaFormatter = jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaDateTime)).isEqualTo(javaFormatter.format(javaDateTime));
    }

    @Test
    void test_appendTimeZoneId() {
        DateTime jodaDateTime = new DateTime(2021, 1, 17, 10, 30, 20);
        java.time.ZonedDateTime javaDateTime = java.time.ZonedDateTime.of(2021, 1, 17, 10, 30, 20, 0, ZoneId.systemDefault());

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendTimeZoneId();
        javaBuilder = javaBuilder.appendZoneId();

        DateTimeFormatter jodaFormatter = jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaDateTime)).isEqualTo(javaFormatter.format(javaDateTime));
    }

    @Test
    void test_appendWeekOfWeekyear() {
        DateTime jodaDateTime = new DateTime(2021, 1, 8, 10, 30, 20);
        java.time.ZonedDateTime javaDateTime = java.time.ZonedDateTime.of(2021, 1, 8, 10, 30, 20, 0, ZoneId.systemDefault());

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendWeekOfWeekyear(2);
        javaBuilder = javaBuilder.appendValue(IsoFields.WEEK_OF_WEEK_BASED_YEAR, 2);

        DateTimeFormatter jodaFormatter = jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaDateTime)).isEqualTo(javaFormatter.format(javaDateTime));
    }

    @Test
    void test_appendYearOfCentury() {
        DateTime jodaDateTime = new DateTime(1950, 1, 8, 10, 30, 20);
        java.time.ZonedDateTime javaDateTime = java.time.ZonedDateTime.of(1950, 1, 8, 10, 30, 20, 0, ZoneId.systemDefault());

        DateTimeFormatterBuilder jodaBuilder = new DateTimeFormatterBuilder();
        java.time.format.DateTimeFormatterBuilder javaBuilder = new java.time.format.DateTimeFormatterBuilder();

        jodaBuilder = jodaBuilder.appendYearOfCentury(1, 1);
        javaBuilder = javaBuilder.appendPattern("uu");

        DateTimeFormatter jodaFormatter = jodaBuilder.toFormatter();
        java.time.format.DateTimeFormatter javaFormatter = javaBuilder.toFormatter();

        assertThat(jodaFormatter.print(jodaDateTime)).isEqualTo(javaFormatter.format(javaDateTime));
    }

}
