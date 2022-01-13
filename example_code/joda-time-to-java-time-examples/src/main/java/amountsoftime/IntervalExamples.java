package amountsoftime;

import org.joda.time.*;
import org.joda.time.chrono.ISOChronology;

public class IntervalExamples {

    public void constructors() {

        Long longArg = 0L;
        Chronology chronologyArg = ISOChronology.getInstance();
        DateTimeZone datetimezoneArg = DateTimeZone.getDefault();
        Object objectArg = null;
        DateTime readableinstantArg = DateTime.now();
        Duration readabledurationArg = Duration.standardDays(5);
        Period readableperiodArg = Period.days(5);

        Interval Interval1 = new Interval(longArg, longArg, chronologyArg);
        Interval Interval2 = new Interval(readableinstantArg, readableinstantArg);
        Interval Interval3 = new Interval(readableinstantArg, readabledurationArg);
        Interval Interval4 = new Interval(longArg, longArg, datetimezoneArg);
        Interval Interval5 = new Interval(longArg, longArg);
        Interval Interval6 = new Interval(objectArg, chronologyArg);
        Interval Interval7 = new Interval(objectArg);
        Interval Interval8 = new Interval(readableperiodArg, readableinstantArg);
        Interval Interval9 = new Interval(readableinstantArg, readableperiodArg);
        Interval Interval10 = new Interval(readabledurationArg, readableinstantArg);

    }

    public void staticMethods() {

        String stringArg = "";

        Interval parseWithOffset = Interval.parseWithOffset(stringArg);
        Interval parse = Interval.parse(stringArg);

    }

    public void staticFields() {

    }

    public void instanceMethods(Interval testInterval) {

        Long longArg = 0L;
        Chronology chronologyArg = ISOChronology.getInstance();
        DateTimeZone datetimezoneArg = DateTimeZone.getDefault();
        Object objectArg = null;
        DateTime readableinstantArg = DateTime.now();
        Duration readabledurationArg = Duration.standardDays(5);
        Period readableperiodArg = Period.days(5);
        Interval readableintervalArg = testInterval;
        PeriodType periodtypeArg = PeriodType.days();

        Interval toInterval = testInterval.toInterval();
        Interval overlap = testInterval.overlap(readableintervalArg);
        Interval gap = testInterval.gap(readableintervalArg);
        boolean abuts = testInterval.abuts(readableintervalArg);
        Interval withStart = testInterval.withStart(readableinstantArg);
        Interval withEnd = testInterval.withEnd(readableinstantArg);
        Interval withChronology = testInterval.withChronology(chronologyArg);
        Interval withStartMillis = testInterval.withStartMillis(longArg);
        Interval withEndMillis = testInterval.withEndMillis(longArg);
        Interval withDurationAfterStart = testInterval.withDurationAfterStart(readabledurationArg);
        Interval withDurationBeforeEnd = testInterval.withDurationBeforeEnd(readabledurationArg);
        Interval withPeriodAfterStart = testInterval.withPeriodAfterStart(readableperiodArg);
        Interval withPeriodBeforeEnd = testInterval.withPeriodBeforeEnd(readableperiodArg);
        long getStartMillis = testInterval.getStartMillis();
        long getEndMillis = testInterval.getEndMillis();
        org.joda.time.Chronology getChronology = testInterval.getChronology();
        boolean overlaps = testInterval.overlaps(readableintervalArg);
        org.joda.time.DateTime getStart = testInterval.getStart();
        org.joda.time.DateTime getEnd = testInterval.getEnd();
        boolean isAfter = testInterval.isAfter(longArg);
        boolean isAfter1 = testInterval.isAfter(readableinstantArg);
        boolean isAfter2 = testInterval.isAfter(readableintervalArg);
        boolean isBefore = testInterval.isBefore(readableintervalArg);
        boolean isBefore1 = testInterval.isBefore(longArg);
        boolean isBefore2 = testInterval.isBefore(readableinstantArg);
        org.joda.time.Duration toDuration = testInterval.toDuration();
        org.joda.time.Period toPeriod = testInterval.toPeriod(periodtypeArg);
        org.joda.time.Period toPeriod1 = testInterval.toPeriod();
        boolean isAfterNow = testInterval.isAfterNow();
        long toDurationMillis = testInterval.toDurationMillis();
        org.joda.time.MutableInterval toMutableInterval = testInterval.toMutableInterval();
        boolean isBeforeNow = testInterval.isBeforeNow();
        boolean containsNow = testInterval.containsNow();
        boolean equals = testInterval.equals(objectArg);
        java.lang.String toString = testInterval.toString();
        int hashCode = testInterval.hashCode();
        boolean contains = testInterval.contains(longArg);
        boolean contains1 = testInterval.contains(readableintervalArg);
        boolean contains2 = testInterval.contains(readableinstantArg);
        boolean isEqual = testInterval.isEqual(readableintervalArg);

    }

    public void instanceFields() {

    }

}
