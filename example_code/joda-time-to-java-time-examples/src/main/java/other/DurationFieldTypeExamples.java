package other;

import org.joda.time.DurationFieldType;
import org.joda.time.chrono.ISOChronology;

public class DurationFieldTypeExamples {

    public void examples() {

        // Same Concept
        DurationFieldType ft1 = DurationFieldType.centuries();
        DurationFieldType ft2 = DurationFieldType.days();
        DurationFieldType ft3 = DurationFieldType.eras();
        DurationFieldType ft4 = DurationFieldType.halfdays();
        DurationFieldType ft5 = DurationFieldType.hours();
        DurationFieldType ft6 = DurationFieldType.millis();
        DurationFieldType ft7 = DurationFieldType.minutes();
        DurationFieldType ft8 = DurationFieldType.months();
        DurationFieldType ft9 = DurationFieldType.seconds();
        DurationFieldType ft10 = DurationFieldType.weeks();
        DurationFieldType ft12 = DurationFieldType.years();

        // Not Supported
        DurationFieldType ft11 = DurationFieldType.weekyears();

        // New Concepts
        // DECADES
        // FOREVER
        // MILLENNIA
        // NANOS

        // from apache/pinot
        int result = DurationFieldType.weeks().getField(ISOChronology.getInstanceUTC()).getDifference(0L, 0L);

    }

}
