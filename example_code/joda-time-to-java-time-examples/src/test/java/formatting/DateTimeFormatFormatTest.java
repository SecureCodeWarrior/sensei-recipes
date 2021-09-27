package formatting;

import formatting.DateTimeFormatterExamples;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTimeFormatFormatTest {

    java.time.ZonedDateTime zdt = ZonedDateTime.of(2021, 10, 8, 16, 21, 45, 123456, ZoneId.systemDefault());

    @Test
    public void format_fullDate() {

        long expectedLong = Instant.from(zdt).toEpochMilli();
        String expectedString = "Friday, 8 October 2021";

        //Format
        String stringResult = DateTimeFormatterExamples.formatFullDate(expectedLong);
        assertEquals(expectedString, stringResult);

    }

    @Test
    public void format_fullDateTime() {

        long expectedLong = Instant.from(zdt).toEpochMilli();

        String zoneFull = zoneDisplay(TimeZone.LONG, expectedLong);
        String expectedString = "Friday, 8 October 2021 at 4:21:45 pm " + zoneFull;

        //Format
        String stringResult = DateTimeFormatterExamples.formatFullDateTime(expectedLong);
        assertEquals(expectedString, stringResult);

    }

    @Test
    public void format_fullTime() {

        long expectedLong = Instant.from(zdt).toEpochMilli();
        String expectedString = "4:21:45 pm Australian Eastern Daylight Time";

        //Format
        String stringResult = DateTimeFormatterExamples.formatFullTime(expectedLong);
        assertEquals(expectedString, stringResult);

    }

    @Test
    public void format_longDate() {

        long expectedLong = Instant.from(zdt).toEpochMilli();
        String expectedString = "8 October 2021";

        //Format
        String stringResult = DateTimeFormatterExamples.formatLongDate(expectedLong);
        assertEquals(expectedString, stringResult);

    }

    @Test
    public void format_longDateTime() {

        long expectedLong = Instant.from(zdt).toEpochMilli();

        String timeZoneDisplay = zoneDisplay(TimeZone.SHORT, expectedLong);
        String expectedString = "8 October 2021 at 4:21:45 pm " + timeZoneDisplay;

        //Format
        String stringResult = DateTimeFormatterExamples.formatLongDateTime(expectedLong);
        assertEquals(expectedString, stringResult);

    }

    @Test
    public void format_longTime() {

        long expectedLong = Instant.from(zdt).toEpochMilli();
        String expectedString = "4:21:45 pm AEDT";

        //Format
        String stringResult = DateTimeFormatterExamples.formatLongTime(expectedLong);
        assertEquals(expectedString, stringResult);

    }

    @Test
    public void format_mediumDate() {

        long expectedLong = Instant.from(zdt).toEpochMilli();
        String expectedString = "8 Oct. 2021";

        //Format
        String stringResult = DateTimeFormatterExamples.formatMediumDate(expectedLong);
        assertEquals(expectedString, stringResult);


    }

    @Test
    public void format_mediumDateTime() {

        long expectedLong = Instant.from(zdt).toEpochMilli();
        String expectedString = "8 Oct. 2021, 4:21:45 pm";

        //Format
        String stringResult = DateTimeFormatterExamples.formatMediumDateTime(expectedLong);
        assertEquals(expectedString, stringResult);

    }

    @Test
    public void format_mediumTime() {

        long expectedLong = Instant.from(zdt).toEpochMilli();
        String expectedString = "4:21:45 pm";

        //Format
        String stringResult = DateTimeFormatterExamples.formatMediumTime(expectedLong);
        assertEquals(expectedString, stringResult);

    }

    @Test
    public void format_shortDate() {

        long expectedLong = Instant.from(zdt).toEpochMilli();
        String expectedString = "8/10/21";

        //Format
        String stringResult = DateTimeFormatterExamples.formatShortDate(expectedLong);
        assertEquals(expectedString, stringResult);

    }

    @Test
    public void format_shortDateTime() {

        long expectedLong = Instant.from(zdt).toEpochMilli();
        String expectedString = "8/10/21, 4:21 pm";

        //Format
        String stringResult = DateTimeFormatterExamples.formatShortDateTime(expectedLong);
        assertEquals(expectedString, stringResult);

    }

    @Test
    public void format_shortTime() {

        long expectedLong = Instant.from(zdt).toEpochMilli();
        String expectedString = "4:21 pm";

        //Format
        String stringResult = DateTimeFormatterExamples.formatShortTime(expectedLong);
        assertEquals(expectedString, stringResult);

    }

    private String zoneDisplay(int style, long epochMillis) {

        boolean daylightSavings = TimeZone.getDefault().inDaylightTime(new Date(epochMillis));
        return TimeZone.getDefault().getDisplayName(daylightSavings, style);

    }

}
