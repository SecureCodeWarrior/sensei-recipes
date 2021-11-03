package amountsoftime;

import org.joda.time.*;
import org.joda.time.chrono.ISOChronology;

import java.math.RoundingMode;

public class DurationExamples {

    public void constructors() {

        // arguments
        Object objectArg = null;
        ReadableInstant readableinstantArg = null;
        long longArg = 0L;
                
        Duration Duration1 = new Duration(objectArg);
        Duration Duration2 = new Duration(readableinstantArg,readableinstantArg);
        Duration Duration3 = new Duration(longArg,longArg);
        Duration Duration4 = new Duration(longArg);

    }

    public void staticMethods() {
        
        long longArg = 0L;
        String stringArg = "parseme";
                
        Duration standardDays = Duration.standardDays(longArg);
        Duration standardHours = Duration.standardHours(longArg);
        Duration standardMinutes = Duration.standardMinutes(longArg);
        Duration standardSeconds = Duration.standardSeconds(longArg);
        Duration millis = Duration.millis(longArg);
        Duration parse = Duration.parse(stringArg);

    }

    public void staticFields() {


        // Used as assigment
        org.joda.time.Duration myZERO = Duration.ZERO;

        // Used as argument
        int compare = myZERO.compareTo(Duration.ZERO);

    }

    public void instanceMethods() {

        Duration testDuration = Duration.standardDays(1);

        // arguments
        Object objectArg = null;
        ReadableInstant readableinstantArg = null;
        ReadableDuration readabledurationArg = null;
        int intArg = 0;
        long longArg = 0L;
        String stringArg = "parseme";
        PeriodType periodtypeArg = PeriodType.days();
        RoundingMode roundingmodeArg = RoundingMode.FLOOR;
        Chronology chronologyArg = ISOChronology.getInstance();
        
        org.joda.time.Duration toDuration = testDuration.toDuration();
        long getStandardDays = testDuration.getStandardDays();
        long getStandardHours = testDuration.getStandardHours();
        long getStandardMinutes = testDuration.getStandardMinutes();
        long getStandardSeconds = testDuration.getStandardSeconds();
        Days toStandardDays = testDuration.toStandardDays();
        Hours toStandardHours = testDuration.toStandardHours();
        Minutes toStandardMinutes = testDuration.toStandardMinutes();
        Seconds toStandardSeconds = testDuration.toStandardSeconds();
        Duration withMillis = testDuration.withMillis(longArg);
        Duration withDurationAdded = testDuration.withDurationAdded(readabledurationArg,intArg);
        Duration withDurationAdded1 = testDuration.withDurationAdded(longArg,intArg);
        Duration plus = testDuration.plus(longArg);
        Duration plus1 = testDuration.plus(readabledurationArg);
        Duration minus = testDuration.minus(readabledurationArg);
        Duration minus1 = testDuration.minus(longArg);
        Duration multipliedBy = testDuration.multipliedBy(longArg);
        Duration dividedBy = testDuration.dividedBy(longArg);
        Duration dividedBy1 = testDuration.dividedBy(longArg,roundingmodeArg);
        Duration negated = testDuration.negated();
        Duration abs = testDuration.abs();
        Period toPeriod = testDuration.toPeriod(periodtypeArg);
        Period toPeriod1 = testDuration.toPeriod(periodtypeArg,chronologyArg);
        Period toPeriod2 = testDuration.toPeriod(chronologyArg);
        Period toPeriodFrom = testDuration.toPeriodFrom(readableinstantArg);
        Period toPeriodFrom1 = testDuration.toPeriodFrom(readableinstantArg,periodtypeArg);
        Period toPeriodTo = testDuration.toPeriodTo(readableinstantArg);
        Period toPeriodTo1 = testDuration.toPeriodTo(readableinstantArg,periodtypeArg);
        Interval toIntervalFrom = testDuration.toIntervalFrom(readableinstantArg);
        Interval toIntervalTo = testDuration.toIntervalTo(readableinstantArg);
        long getMillis = testDuration.getMillis();
        Period toPeriod3 = testDuration.toPeriod();
        boolean isLongerThan = testDuration.isLongerThan(readabledurationArg);
        boolean isShorterThan = testDuration.isShorterThan(readabledurationArg);
        boolean isEqual = testDuration.isEqual(readabledurationArg);

        int compareTo2 = testDuration.compareTo(readabledurationArg);

    }

    public void instanceFields() {

    }
}
