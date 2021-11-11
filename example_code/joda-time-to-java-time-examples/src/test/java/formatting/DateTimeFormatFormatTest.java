package formatting;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.FormatStyle;

import static org.assertj.core.api.Assertions.assertThat;

public class DateTimeFormatFormatTest {

    java.time.ZonedDateTime zdt = ZonedDateTime.of(2021, 10, 8, 16, 21, 45, 123456, ZoneId.systemDefault());

    @Test
    public void test_fullDate_is_equivalent() {
        long testinstant = zdt.toInstant().toEpochMilli();

        DateTimeFormatter joda = DateTimeFormat.fullDate();
        java.time.format.DateTimeFormatter javaFormatter = java.time.format.DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);

        String jodaResult = joda.print(testinstant);
        String javaResult = javaFormatter.format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(testinstant), ZoneId.systemDefault()));

        assertThat(jodaResult).isEqualTo(javaResult);
    }

    @Test
    public void test_fullDateTime_is_equivalent() {
        long testinstant = zdt.toInstant().toEpochMilli();

        DateTimeFormatter joda = DateTimeFormat.fullDateTime();
        java.time.format.DateTimeFormatter javaFormatter = java.time.format.DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);

        String jodaResult = joda.print(testinstant);
        String javaResult = javaFormatter.format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(testinstant), ZoneId.systemDefault()));

        assertThat(jodaResult).isEqualTo(javaResult);
    }

    @Test
    public void test_fullTime_is_equivalent() {
        long testinstant = zdt.toInstant().toEpochMilli();

        DateTimeFormatter joda = DateTimeFormat.fullTime();
        java.time.format.DateTimeFormatter javaFormatter = java.time.format.DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL);

        String jodaResult = joda.print(testinstant);
        String javaResult = javaFormatter.format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(testinstant), ZoneId.systemDefault()));

        assertThat(jodaResult).isEqualTo(javaResult);
    }

    @Test
    public void test_longDateTime_is_equivalent() {
        long testinstant = zdt.toInstant().toEpochMilli();

        DateTimeFormatter joda = DateTimeFormat.longDateTime();
        java.time.format.DateTimeFormatter javaFormatter = java.time.format.DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);

        String jodaResult = joda.print(testinstant);
        String javaResult = javaFormatter.format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(testinstant), ZoneId.systemDefault()));

        assertThat(jodaResult).isEqualTo(javaResult);
    }

    @Test
    public void test_longDate_is_equivalent() {
        long testinstant = zdt.toInstant().toEpochMilli();

        DateTimeFormatter joda = DateTimeFormat.longDate();
        java.time.format.DateTimeFormatter javaFormatter = java.time.format.DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);

        String jodaResult = joda.print(testinstant);
        String javaResult = javaFormatter.format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(testinstant), ZoneId.systemDefault()));

        assertThat(jodaResult).isEqualTo(javaResult);
    }

    @Test
    public void test_longTime_is_equivalent() {
        long testinstant = zdt.toInstant().toEpochMilli();

        DateTimeFormatter joda = DateTimeFormat.longTime();
        java.time.format.DateTimeFormatter javaFormatter = java.time.format.DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG);

        String jodaResult = joda.print(testinstant);
        String javaResult = javaFormatter.format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(testinstant), ZoneId.systemDefault()));

        assertThat(jodaResult).isEqualTo(javaResult);
    }

    @Test
    public void test_mediumDate_is_equivalent() {
        long testinstant = zdt.toInstant().toEpochMilli();

        DateTimeFormatter joda = DateTimeFormat.mediumDate();
        java.time.format.DateTimeFormatter javaFormatter = java.time.format.DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);

        String jodaResult = joda.print(testinstant);
        String javaResult = javaFormatter.format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(testinstant), ZoneId.systemDefault()));

        assertThat(jodaResult).isEqualTo(javaResult);
    }

    @Test
    public void test_mediumDateTime_is_equivalent() {
        long testinstant = zdt.toInstant().toEpochMilli();

        DateTimeFormatter joda = DateTimeFormat.mediumDateTime();
        java.time.format.DateTimeFormatter javaFormatter = java.time.format.DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

        String jodaResult = joda.print(testinstant);
        String javaResult = javaFormatter.format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(testinstant), ZoneId.systemDefault()));

        assertThat(jodaResult).isEqualTo(javaResult);
    }

    @Test
    public void test_mediumTime_is_equivalent() {
        long testinstant = zdt.toInstant().toEpochMilli();

        DateTimeFormatter joda = DateTimeFormat.mediumTime();
        java.time.format.DateTimeFormatter javaFormatter = java.time.format.DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);

        String jodaResult = joda.print(testinstant);
        String javaResult = javaFormatter.format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(testinstant), ZoneId.systemDefault()));

        assertThat(jodaResult).isEqualTo(javaResult);
    }

    @Test
    public void test_shortDate_is_equivalent() {
        long testinstant = zdt.toInstant().toEpochMilli();

        DateTimeFormatter joda = DateTimeFormat.shortDate();
        java.time.format.DateTimeFormatter javaFormatter = java.time.format.DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

        String jodaResult = joda.print(testinstant);
        String javaResult = javaFormatter.format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(testinstant), ZoneId.systemDefault()));

        assertThat(jodaResult).isEqualTo(javaResult);
    }

    @Test
    public void test_shortDateTime_is_equivalent() {
        long testinstant = zdt.toInstant().toEpochMilli();

        DateTimeFormatter joda = DateTimeFormat.shortDateTime();
        java.time.format.DateTimeFormatter javaFormatter = java.time.format.DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

        String jodaResult = joda.print(testinstant);
        String javaResult = javaFormatter.format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(testinstant), ZoneId.systemDefault()));

        assertThat(jodaResult).isEqualTo(javaResult);
    }

    @Test
    public void test_shortTime_is_equivalent() {
        long testinstant = zdt.toInstant().toEpochMilli();

        DateTimeFormatter joda = DateTimeFormat.shortTime();
        java.time.format.DateTimeFormatter javaFormatter = java.time.format.DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);

        String jodaResult = joda.print(testinstant);
        String javaResult = javaFormatter.format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(testinstant), ZoneId.systemDefault()));

        assertThat(jodaResult).isEqualTo(javaResult);
    }

    @Test
    public void testDateTimeFormatterTemporalAcessor() {
        long testinstant = zdt.toInstant().toEpochMilli();

        DateTime dateTimeJoda = new DateTime(testinstant);
        java.time.ZonedDateTime dateTimeJava = ZonedDateTime.ofInstant(Instant.ofEpochMilli(testinstant), ZoneId.systemDefault());

        DateTimeFormatter joda = DateTimeFormat.fullDateTime();
        java.time.format.DateTimeFormatter javaFormatter = java.time.format.DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);

        String jodaResult = joda.print(dateTimeJoda);
        String javaResult = javaFormatter.format(dateTimeJava);


        assertThat(jodaResult).isEqualTo(javaResult);

    }

    @Test
    public void testDateTimeFormatterAppendableTemporal() throws IOException {
        long testinstant = zdt.toInstant().toEpochMilli();

        Appendable appendableArg = new StringWriter();
        Appendable appendableArg2 = new StringWriter();

        DateTime dateTimeJoda = new DateTime(testinstant);
        java.time.ZonedDateTime dateTimeJava = ZonedDateTime.ofInstant(Instant.ofEpochMilli(testinstant), ZoneId.systemDefault());

        DateTimeFormatter joda = DateTimeFormat.fullDateTime();
        java.time.format.DateTimeFormatter javaFormatter = java.time.format.DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);

        joda.printTo(appendableArg, dateTimeJoda);
        javaFormatter.formatTo(dateTimeJava, appendableArg2);
        assertThat(appendableArg.toString()).isEqualTo(appendableArg2.toString());
    }

    @Test
    public void testDateTimeFormatterAppendableLong() throws IOException {
        long testinstant = zdt.toInstant().toEpochMilli();

        Appendable appendableArg = new StringWriter();
        Appendable appendableArg2 = new StringWriter();

        DateTimeFormatter joda = DateTimeFormat.fullDateTime();
        java.time.format.DateTimeFormatter javaFormatter = java.time.format.DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);

        joda.printTo(appendableArg, testinstant);
        javaFormatter.formatTo(ZonedDateTime.ofInstant(Instant.ofEpochMilli(testinstant), ZoneId.systemDefault()), appendableArg2);
        assertThat(appendableArg.toString()).isEqualTo(appendableArg2.toString());
    }

    @Test
    public void testDateTimeFormatterWithOffsetParsed() {
        long testinstant = zdt.toInstant().toEpochMilli();

        DateTimeFormatter joda = DateTimeFormat.fullDateTime();
        java.time.format.DateTimeFormatter javaFormatter = java.time.format.DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);

        String jodaResult = joda.withOffsetParsed().print(testinstant);
        String javaResult = ZonedDateTime.ofInstant(Instant.ofEpochMilli(testinstant), ZoneId.systemDefault()).format(javaFormatter);

        assertThat(jodaResult).isEqualTo(javaResult);
    }

}
