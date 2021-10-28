package includetimezone;

import org.joda.time.DateTimeZone;
import org.junit.jupiter.api.Test;

import javax.sound.midi.SysexMessage;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTimeZoneExamplesTest {

    /*
        This is just a test to verify that the migration recipes for DateTimeZone.getName and DateTimeZone.getShortName
        are going to be good enough. There are a few exceptions but these are most likely just because of different
        Time Zone provider details. Conceptually this test should prove the recipe is the best approximation.
     */
    @Test
    public void test_equivalent_names() {

        LocalDateTime summer = LocalDateTime.of(2021, 1, 1, 5, 5, 5, 0);
        LocalDateTime winter = LocalDateTime.of(2021, 6, 1, 5, 5, 5, 0);

        // Add a list of known exceptions.
        Map<String, String> knownExceptions = new HashMap<>();
        knownExceptions.put("America/Godthab", "Western Greenland Time vs West Greenland Standard Time");
        knownExceptions.put("Pacific/Johnston", "Hawaii Standard Time vs Hawaii-Aleutian Standard Time");
        knownExceptions.put("America/Santa_Isabel", "GMT-08:00 vs PST");

        for (String testId : ZoneId.getAvailableZoneIds()) {

            // Ignore the differences in these System Names
            if (testId.startsWith("Etc")) {
                continue;
            }
            if (testId.startsWith("SystemV")) {
                continue;
            }
            if (testId.startsWith("GMT")) {
                continue;
            }

            if (!knownExceptions.containsKey(testId)) {

                test_shortname_equivalent(testId, summer);
                test_shortname_equivalent(testId, winter);

                test_name_equivalent(testId, summer);
                test_name_equivalent(testId, winter);

                // With Locale
                test_shortname_equivalent(testId, summer, Locale.FRANCE);
                test_shortname_equivalent(testId, winter, Locale.FRANCE);

                test_name_equivalent(testId, summer, Locale.FRANCE);
                test_name_equivalent(testId, winter, Locale.FRANCE);

            }

        }

    }

    private void test_shortname_equivalent(String testId, LocalDateTime localDateTime) {

        DateTimeZone dateTimeZone = DateTimeZone.forID(testId);
        ZoneId zoneId = ZoneId.of(testId);

        Instant instant = localDateTime.atZone(zoneId).toInstant();
        long epochMilli = instant.toEpochMilli();

        String nameDateTimeZone = dateTimeZone.getShortName(instant.toEpochMilli());
        String nameZoneId = Instant.ofEpochMilli(epochMilli).atZone(zoneId).format(DateTimeFormatter.ofPattern("z"));

        assertEquals(nameDateTimeZone, nameZoneId);

    }

    private void test_name_equivalent(String testId, LocalDateTime localDateTime) {

        DateTimeZone dateTimeZone = DateTimeZone.forID(testId);
        ZoneId zoneId = ZoneId.of(testId);

        Instant instant = localDateTime.atZone(zoneId).toInstant();

        String nameDateTimeZone = dateTimeZone.getName(instant.toEpochMilli());
        String nameZoneId = instant.atZone(zoneId).format(DateTimeFormatter.ofPattern("zzzz"));

        assertEquals(nameDateTimeZone, nameZoneId);

    }

    private void test_shortname_equivalent(String testId, LocalDateTime localDateTime, Locale locale) {

        DateTimeZone dateTimeZone = DateTimeZone.forID(testId);
        ZoneId zoneId = ZoneId.of(testId);

        Instant instant = localDateTime.atZone(zoneId).toInstant();

        String nameDateTimeZone = dateTimeZone.getShortName(instant.toEpochMilli(), locale);
        String nameZoneId = instant.atZone(zoneId).format(DateTimeFormatter.ofPattern("z", locale));

        assertEquals(nameDateTimeZone, nameZoneId);

    }

    private void test_name_equivalent(String testId, LocalDateTime localDateTime, Locale locale) {

        DateTimeZone dateTimeZone = DateTimeZone.forID(testId);
        ZoneId zoneId = ZoneId.of(testId);

        Instant instant = localDateTime.atZone(zoneId).toInstant();

        String nameDateTimeZone = dateTimeZone.getName(instant.toEpochMilli(), locale);
        String nameZoneId = instant.atZone(zoneId).format(DateTimeFormatter.ofPattern("zzzz", locale));

        assertEquals(nameDateTimeZone, nameZoneId);

    }

}