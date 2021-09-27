package other;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.chrono.ISOChronology;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalField;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DateTimeFieldExamplesTest {

    private void check_equivalent_fields(long sometime, DateTimeField jodaField, TemporalField javaChronoField) {

        // Joda-Time roundFloor
        org.joda.time.Instant jodaInstant = org.joda.time.Instant.ofEpochMilli(sometime);
        long jodaFloor = jodaField.roundFloor(sometime);

        // java.time equivalent
        Instant javaInstant = Instant.ofEpochMilli(sometime);
        long javaTruncated = javaInstant.truncatedTo(javaChronoField.getBaseUnit()).toEpochMilli();

        assertEquals(jodaFloor, javaTruncated);

    }

    @Test
    public void round_floor_truncatedTo() {

        long sometime = Instant.now().toEpochMilli();

        ISOChronology chronology = ISOChronology.getInstanceUTC();

        check_equivalent_fields(sometime, DateTimeFieldType.dayOfMonth().getField(chronology), ChronoField.DAY_OF_MONTH);
        check_equivalent_fields(sometime, DateTimeFieldType.dayOfWeek().getField(chronology), ChronoField.DAY_OF_WEEK);
        check_equivalent_fields(sometime, DateTimeFieldType.dayOfYear().getField(chronology), ChronoField.DAY_OF_YEAR);
        check_equivalent_fields(sometime, DateTimeFieldType.hourOfDay().getField(chronology), ChronoField.HOUR_OF_DAY);
        check_equivalent_fields(sometime, DateTimeFieldType.millisOfDay().getField(chronology), ChronoField.MILLI_OF_DAY);
        check_equivalent_fields(sometime, DateTimeFieldType.millisOfSecond().getField(chronology), ChronoField.MILLI_OF_SECOND);
        check_equivalent_fields(sometime, DateTimeFieldType.minuteOfHour().getField(chronology), ChronoField.MINUTE_OF_HOUR);
        check_equivalent_fields(sometime, DateTimeFieldType.secondOfDay().getField(chronology), ChronoField.SECOND_OF_DAY);
        check_equivalent_fields(sometime, DateTimeFieldType.secondOfMinute().getField(chronology), ChronoField.SECOND_OF_MINUTE);


        //check_equivalent_fields(sometime, DateTimeFieldType.centuryOfEra().getField(chronology), ChronoField.CENT);
        //check_equivalent_fields(sometime, DateTimeFieldType.era().getField(chronology), ChronoField.ERA);
        //check_equivalent_fields(sometime, DateTimeFieldType.monthOfYear().getField(chronology), ChronoField.MONTH_OF_YEAR);
        //check_equivalent_fields(sometime, DateTimeFieldType.weekOfWeekyear().getField(chronology), IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        //check_equivalent_fields(sometime, DateTimeFieldType.weekyear().getField(chronology), ChronoField.ALIGNED_WEEK_OF_YEAR);
        //check_equivalent_fields(sometime, DateTimeFieldType.weekyearOfCentury().getField(chronology), IsoFields.W);
        //check_equivalent_fields(sometime, DateTimeFieldType.year().getField(chronology), ChronoField.YEAR);
        //check_equivalent_fields(sometime, DateTimeFieldType.yearOfCentury().getField(chronology), ChronoField.);
        //check_equivalent_fields(sometime, DateTimeFieldType.yearOfEra().getField(chronology), ChronoField.YEAR_OF_ERA);





    }

}
