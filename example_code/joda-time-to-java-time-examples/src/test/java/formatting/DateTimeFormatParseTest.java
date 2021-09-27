package formatting;

import formatting.DateTimeFormatterExamples;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTimeFormatParseTest {

    ZonedDateTime zdt = ZonedDateTime.of(2021, 10, 8, 16, 21, 45, 123456, ZoneId.systemDefault());
    long dateOnlyLong = 1633611600000L;
    long timeOnlyLong = 22860000L;
    long timeOnlyLongWithSeconds = 22905000L;
    long timeOnlyLongWithSecondsWithNanos = 22860000L;

    @Test
    public void parse_fullDate() {

        String expectedString = "Friday, 8 October 2021";

        //Parse
        long longResult = DateTimeFormatterExamples.parseFullDate(expectedString);
        assertEquals(dateOnlyLong, longResult);

    }

    @Test
    public void parse_fullDateTime() {

        long expectedLong = Instant.from(zdt).toEpochMilli();
        String zoneFull = zoneDisplay(TimeZone.LONG, expectedLong);
        String expectedString = "Friday, 8 October 2021 at 4:21:45 pm " + zoneFull;

        //Parse
        long longResult = DateTimeFormatterExamples.parseFullDateTime(expectedString);
        assertEquals(expectedLong, longResult);

    }


    @Test
    public void parse_fullTime() {

        long expectedLong = Instant.from(zdt).toEpochMilli();
        //String expectedString = "4:21:45 pm Australian Eastern Daylight Time";
        String expectedString = "4:21:45 pm";

        //Parse
        long longResult = DateTimeFormatterExamples.parseFullTime(expectedString);
        assertEquals(expectedLong, longResult);

    }


    @Test
    public void parse_longDate() {

        long expectedLong = Instant.from(zdt).toEpochMilli();
        String expectedString = "8 October 2021";

        //Parse
        long longResult = DateTimeFormatterExamples.parseLongDate(expectedString);
        assertEquals(expectedLong, longResult);

    }


    @Test
    public void parse_longDateTime() {

        ZonedDateTime zdtStart = zdt.withHour(0).withMinute(0).withSecond(0).withNano(0);

        long expectedLong = Instant.from(zdtStart).toEpochMilli();

        String timeZoneDisplay = zoneDisplay(TimeZone.LONG, expectedLong);
        String expectedString = "8 October 2021 at 4:21:45 pm";

        //Parse
        long longResult = DateTimeFormatterExamples.parseLongDateTime(expectedString);
        assertEquals(expectedLong, longResult);

    }


    @Test
    public void parse_longTime() {

        long expectedLong = Instant.from(zdt).toEpochMilli();
        String expectedString = "4:21:45 pm Z";

        //Parse
        long longResult = DateTimeFormatterExamples.parseLongTime(expectedString);
        assertEquals(expectedLong, longResult);

    }


    @Test
    public void parse_mediumDate() {

        String expectedString = "8 Oct. 2021";

        //Parse
        long longResult = DateTimeFormatterExamples.parseMediumDate(expectedString);
        assertEquals(dateOnlyLong, longResult);

    }


    @Test
    public void parse_mediumDateTime() {

        long expectedLong = Instant.from(zdt).toEpochMilli();
        String expectedString = "8 Oct. 2021";

        //Parse
        long longResult = DateTimeFormatterExamples.parseMediumDateTime(expectedString);
        assertEquals(expectedLong, longResult);

    }


    @Test
    public void parse_mediumTime() {

        long expectedLong = Instant.from(zdt).toEpochMilli();
        String expectedString = "4:21:45 pm";

        //Parse
        long longResult = DateTimeFormatterExamples.parseMediumTime(expectedString);
        assertEquals(timeOnlyLongWithSeconds, longResult);

    }


    @Test
    public void parse_shortDate() {

        String expectedString = "8/10/21";

        //Parse
        long longResult = DateTimeFormatterExamples.parseShortDate(expectedString);
        assertEquals(dateOnlyLong, longResult);

    }


    @Test
    public void parse_shortDateTime() {

        long expectedLong = Instant.from(zdt).toEpochMilli();
        String expectedString = "8 Oct. 2021";

        //Parse
        long longResult = DateTimeFormatterExamples.parseShortDateTime(expectedString);
        assertEquals(expectedLong, longResult);

    }


    @Test
    public void parse_shortTime() {

        String expectedString = "4:21 pm";

        //Parse
        long longResult = DateTimeFormatterExamples.parseShortTime(expectedString);
        assertEquals(timeOnlyLong, longResult);

    }

    private String zoneDisplay(int style, long epochMillis) {

        boolean daylightSavings = TimeZone.getDefault().inDaylightTime(new Date(epochMillis));
        return TimeZone.getDefault().getDisplayName(daylightSavings, style);

    }

}
