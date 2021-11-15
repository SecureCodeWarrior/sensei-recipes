package formatting;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.FormatStyle;

import static org.assertj.core.api.Assertions.assertThat;


class DateTimeFormatParseTest {

    @Test
    void parse_fullDate_is_equivalent() {
        String expectedString = "Monday, 15 November 2021";

        DateTimeFormatter jodaDtf = DateTimeFormat.fullDate();
        long jodaResult = jodaDtf.parseMillis(expectedString);

        java.time.format.DateTimeFormatter javaDtf = java.time.format.DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        long javaResult =  java.time.LocalDate.parse(expectedString, javaDtf).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();

        assertThat(jodaResult).isEqualTo(javaResult);
    }


    @Test
    void parse_longDate_is_equivalent() {
        String expectedString = "15 November 2021";

        DateTimeFormatter jodaDtf = DateTimeFormat.longDate();
        long jodaResult = jodaDtf.parseMillis(expectedString);

        java.time.format.DateTimeFormatter javaDtf = java.time.format.DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        long javaResult =  java.time.LocalDate.parse(expectedString, javaDtf).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();

        assertThat(jodaResult).isEqualTo(javaResult);
    }

    @Test
    void parse_mediumDate_is_equivalent() {
        String expectedString = "15 Nov. 2021";

        DateTimeFormatter jodaDtf = DateTimeFormat.mediumDate();
        long jodaResult = jodaDtf.parseMillis(expectedString);

        java.time.format.DateTimeFormatter javaDtf = java.time.format.DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        long javaResult =  java.time.LocalDate.parse(expectedString, javaDtf).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();

        assertThat(jodaResult).isEqualTo(javaResult);
    }


    @Test
    void parse_mediumDateTime_is_equivalent() {
        String expectedString = "15 Nov. 2021, 8:00:00 pm";

        DateTimeFormatter jodaDtf = DateTimeFormat.mediumDateTime();
        long jodaResult = jodaDtf.parseMillis(expectedString);

        java.time.format.DateTimeFormatter javaDtf = java.time.format.DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        long javaResult =  java.time.LocalDateTime.parse(expectedString, javaDtf).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        assertThat(jodaResult).isEqualTo(javaResult);
    }

    @Test
    void parse_shortDate_is_equivalent() {
        String expectedString = "15/11/21";

        DateTimeFormatter jodaDtf = DateTimeFormat.shortDate();
        long jodaResult = jodaDtf.parseMillis(expectedString);

        java.time.format.DateTimeFormatter javaDtf = java.time.format.DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        long javaResult =  java.time.LocalDate.parse(expectedString, javaDtf).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();

        assertThat(jodaResult).isEqualTo(javaResult);
    }


    @Test
    void parse_shortDateTime_is_equivalent() {
        String expectedString = "15/11/21, 8:00 pm";

        DateTimeFormatter jodaDtf = DateTimeFormat.shortDateTime();
        long jodaResult = jodaDtf.parseMillis(expectedString);

        java.time.format.DateTimeFormatter javaDtf = java.time.format.DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        long javaResult =  java.time.LocalDateTime.parse(expectedString, javaDtf).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        assertThat(jodaResult).isEqualTo(javaResult);
    }

    @Test
    void parse_localDateTimePattern_is_equivalent() {
        String dateTime = "11/15/2021 08:00:00";
        String pattern = "MM/dd/yyyy HH:mm:ss";

        DateTimeFormatter jodaDtf = DateTimeFormat.forPattern(pattern);
        LocalDateTime jodaDateTime = jodaDtf.parseLocalDateTime(dateTime);

        java.time.format.DateTimeFormatter javaDtf = java.time.format.DateTimeFormatter.ofPattern(pattern);
        java.time.LocalDateTime javaDateTime = java.time.LocalDateTime.parse(dateTime,javaDtf);

        assertThat(jodaDtf.print(jodaDateTime)).isEqualTo(javaDtf.format(javaDateTime));
    }

    @Test
    void parse_localDatePattern_is_equivalent() {
        String dateTime = "11/15/2021";
        String pattern = "MM/dd/yyyy";

        DateTimeFormatter jodaDtf = DateTimeFormat.forPattern(pattern);
        LocalDate jodaDate = jodaDtf.parseLocalDate(dateTime);

        java.time.format.DateTimeFormatter javaDtf = java.time.format.DateTimeFormatter.ofPattern(pattern);
        java.time.LocalDate javaDate = java.time.LocalDate.parse(dateTime,javaDtf);

        assertThat(jodaDtf.print(jodaDate)).isEqualTo(javaDtf.format(javaDate));
    }

    @Test
    void parse_localTimePattern_is_equivalent() {
        String dateTime = "08:00:00";
        String pattern = "HH:mm:ss";

        DateTimeFormatter jodaDtf = DateTimeFormat.forPattern(pattern);
        LocalTime jodaTime = jodaDtf.parseLocalTime(dateTime);

        java.time.format.DateTimeFormatter javaDtf = java.time.format.DateTimeFormatter.ofPattern(pattern);
        java.time.LocalTime javaTime = java.time.LocalTime.parse(dateTime,javaDtf);

        assertThat(jodaDtf.print(jodaTime)).isEqualTo(javaDtf.format(javaTime));
    }

    @Test
    void parsemillis_with_zone_is_equivalent() {
        String dateTime = "11/15/2021 08:00:00.000+1000";
        String pattern = "MM/dd/yyyy HH:mm:ss.SSSZZ";

        String outputPattern = "MM/dd/yyyy HH:mm:ss";

        DateTimeFormatter jodaDtf = DateTimeFormat.forPattern(pattern);
        long jodaResult = jodaDtf.parseMillis(dateTime);

        java.time.format.DateTimeFormatter javaDtf = java.time.format.DateTimeFormatter.ofPattern(pattern);
        long javaResult = java.time.LocalDateTime.parse(dateTime, javaDtf).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        assertThat(jodaResult).isEqualTo(javaResult);

    }

    @Test
    void parse_dateTimePattern_is_equivalent() {
        String dateTime = "11/15/2021 08:00:00.000+1000";
        String pattern = "MM/dd/yyyy HH:mm:ss.SSSZZ";

        String outputPattern = "MM/dd/yyyy HH:mm:ss";

        DateTimeFormatter jodaDtf = DateTimeFormat.forPattern(pattern);
        DateTime jodaDateTime = jodaDtf.parseDateTime(dateTime);

        java.time.format.DateTimeFormatter javaDtf = java.time.format.DateTimeFormatter.ofPattern(pattern);
        OffsetDateTime javaDateTime = OffsetDateTime.parse(dateTime,javaDtf);

        assertThat(DateTimeFormat.forPattern(outputPattern).print(jodaDateTime)).isEqualTo(java.time.format.DateTimeFormatter.ofPattern(outputPattern).format(javaDateTime));
    }

}
