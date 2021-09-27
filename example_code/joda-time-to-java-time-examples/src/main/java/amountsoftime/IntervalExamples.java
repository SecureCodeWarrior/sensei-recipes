package amountsoftime;

import org.joda.time.DateTimeZone;
import org.joda.time.Interval;

import java.time.Instant;
import java.time.ZoneId;

public class IntervalExamples {

    public void example() {

        Long start = 0L;
        long finish = 0L;

        org.threeten.extra.Interval interval = org.threeten.extra.Interval.of(Instant.ofEpochMilli(start), Instant.ofEpochMilli(finish));

        Instant startInterval = java.time.Instant.ofEpochMilli(start);
        Instant finishInterval = java.time.Instant.ofEpochMilli(finish);

        org.threeten.extra.Interval interval1 = org.threeten.extra.Interval.of(startInterval, finishInterval);

    }
}
