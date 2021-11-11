package formatting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.TimeZone;

import static org.assertj.core.api.Assertions.assertThat;


public class DateTimeFormatParseTest {

    ZonedDateTime zdt = ZonedDateTime.of(2021, 10, 8, 20, 00, 00, 0, ZoneId.systemDefault());
    long dateOnlyLong = 1633615200000L;
    long timeOnlyLong = LocalTime.from(zdt).getLong(ChronoField.MILLI_OF_DAY);

    @Test
    public void parse_fullDate() {
        String expectedString = "Friday, 8 October 2021";

        //Parse
        long longResult = DateTimeFormatterExamples.parseFullDate(expectedString);
        assertThat(longResult).isEqualTo(dateOnlyLong);
    }

    @Test
    public void parse_fullDateTime() {
        long expectedLong = Instant.from(zdt).toEpochMilli();
        String zoneFull = zoneDisplay(TimeZone.LONG, expectedLong);
        String expectedString = "Friday, 8 October 2021 at 8:00:00 pm " + zoneFull;

        //Parse
        long longResult = DateTimeFormatterExamples.parseFullDateTime(expectedString);
        assertThat(longResult).isEqualTo(expectedLong);
    }


    @Test
    public void parse_fullTime() {
        String expectedString = "8:00:00 pm Australian Eastern Standard Time";

        //Parse
        long longResult = DateTimeFormatterExamples.parseFullTime(expectedString);
        assertThat(longResult).isEqualTo(timeOnlyLong);
    }


    @Test
    public void parse_longDate() {
        String expectedString = "8 October 2021";

        //Parse
        long longResult = DateTimeFormatterExamples.parseLongDate(expectedString);
        Assertions.assertThat(longResult).isEqualTo(dateOnlyLong);
    }


    @Test
    public void parse_longDateTime() {
        ZonedDateTime zdtStart = zdt.withHour(0).withMinute(0).withSecond(0).withNano(0);
        long expectedLong = Instant.from(zdtStart).toEpochMilli();

        String timeZoneDisplay = zoneDisplay(TimeZone.LONG, expectedLong);
        String expectedString = "8 October 2021 at 12:00:00 am AEST";

        //Parse
        long longResult = DateTimeFormatterExamples.parseLongDateTime(expectedString);
        assertThat(longResult).isEqualTo(expectedLong);
    }


    @Test
    public void parse_longTime() {
        String expectedString = "8:00:00 pm Z";

        //Parse
        long longResult = DateTimeFormatterExamples.parseLongTime(expectedString);
        assertThat(longResult).isEqualTo(timeOnlyLong);
    }


    @Test
    public void parse_mediumDate() {
        String expectedString = "8 Oct. 2021";

        //Parse
        long longResult = DateTimeFormatterExamples.parseMediumDate(expectedString);
        assertThat(longResult).isEqualTo(dateOnlyLong);
    }


    @Test
    public void parse_mediumDateTime() {
        long expectedLong = Instant.from(zdt).toEpochMilli();
        String expectedString = "8 Oct. 2021, 8:00:00 pm";

        //Parse
        long longResult = DateTimeFormatterExamples.parseMediumDateTime(expectedString);
        assertThat(longResult).isEqualTo(expectedLong);
    }


    @Test
    public void parse_mediumTime() {
        String expectedString = "8:00:00 pm";

        //Parse
        long longResult = DateTimeFormatterExamples.parseMediumTime(expectedString);
        assertThat(longResult).isEqualTo(timeOnlyLong);

    }

    @Test
    public void parse_shortDate() {
        String expectedString = "8/10/21";

        //Parse
        long longResult = DateTimeFormatterExamples.parseShortDate(expectedString);
        assertThat(longResult).isEqualTo(dateOnlyLong);
    }


    @Test
    public void parse_shortDateTime() {
        long expectedLong = Instant.from(zdt).toEpochMilli();
        String expectedString = "8/10/21, 8:00 pm";

        //Parse
        long longResult = DateTimeFormatterExamples.parseShortDateTime(expectedString);
        assertThat(longResult).isEqualTo(expectedLong);
    }


    @Test
    public void parse_shortTime() {
        String expectedString = "8:00 pm";

        //Parse
        long longResult = DateTimeFormatterExamples.parseShortTime(expectedString);
        assertThat(longResult).isEqualTo(timeOnlyLong);
    }

    @Test
    public void parse_DateTime() {
        String expectedString = "Friday, 8 October 2021 at 9:00:00 pm Australian Eastern Standard Time";
        ZonedDateTime zonedDateTime = DateTimeFormatterExamples.parseDateTime(expectedString);
        assertThat(zonedDateTime).isEqualTo(zdt);
    }

    private String zoneDisplay(int style, long epochMillis) {
        boolean daylightSavings = TimeZone.getDefault().inDaylightTime(new Date(epochMillis));
        return TimeZone.getDefault().getDisplayName(daylightSavings, style);

    }

}
