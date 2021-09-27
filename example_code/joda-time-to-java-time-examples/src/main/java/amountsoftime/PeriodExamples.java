package amountsoftime;

import org.joda.time.*;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.PeriodFormat;
import org.joda.time.format.PeriodFormatter;

public class PeriodExamples {

    public void constructors() {

        long longArg = 0L;
        int intArg = 0;
        PeriodType periodtypeArg = PeriodType.days();
        Chronology chronologyArg = ISOChronology.getInstanceUTC();
        Object objectArg = null;
        DateTime readableinstantArg = DateTime.now();
        Duration readabledurationArg = Duration.ZERO;
        LocalDateTime readablepartialArg = LocalDateTime.now();

        Period Period1 = new Period(longArg,periodtypeArg);
        Period Period2 = new Period(intArg,intArg,intArg,intArg,intArg,intArg,intArg,intArg,periodtypeArg);
        Period Period3 = new Period(longArg);
        Period Period4 = new Period(longArg,chronologyArg);
        Period Period5 = new Period(longArg,periodtypeArg,chronologyArg);
        Period Period6 = new Period(longArg,longArg);
        Period Period7 = new Period(longArg,longArg,periodtypeArg,chronologyArg);
        Period Period8 = new Period(objectArg,periodtypeArg,chronologyArg);
        Period Period9 = new Period();
        Period Period10 = new Period(intArg,intArg,intArg,intArg);
        Period Period11 = new Period(intArg,intArg,intArg,intArg,intArg,intArg,intArg,intArg);
        Period Period12 = new Period(readabledurationArg,readableinstantArg);
        Period Period13 = new Period(readableinstantArg,readabledurationArg,periodtypeArg);
        Period Period14 = new Period(readableinstantArg,readabledurationArg);
        Period Period15 = new Period(readablepartialArg,readablepartialArg,periodtypeArg);
        Period Period16 = new Period(readabledurationArg,readableinstantArg,periodtypeArg);
        Period Period17 = new Period(objectArg);
        Period Period18 = new Period(objectArg,periodtypeArg);
        Period Period19 = new Period(longArg,longArg,periodtypeArg);
        Period Period20 = new Period(longArg,longArg,chronologyArg);
        Period Period21 = new Period(objectArg,chronologyArg);
        Period Period22 = new Period(readableinstantArg,readableinstantArg);
        Period Period23 = new Period(readableinstantArg,readableinstantArg,periodtypeArg);
        Period Period24 = new Period(readablepartialArg,readablepartialArg);

    }

    public void staticMethods() {

        int intArg = 3;
        String stringArg = "parseme";
        PeriodFormatter periodformatterArg = PeriodFormat.getDefault();
        LocalDateTime readablepartialArg = LocalDateTime.now();


        Period years = Period.years(intArg);
        Period months = Period.months(intArg);
        Period weeks = Period.weeks(intArg);
        Period hours = Period.hours(intArg);
        Period minutes = Period.minutes(intArg);
        Period seconds = Period.seconds(intArg);
        Period fieldDifference = Period.fieldDifference(readablepartialArg,readablepartialArg);
        Period days = Period.days(intArg);
        Period millis = Period.millis(intArg);
        Period parse = Period.parse(stringArg);
        Period parse1 = Period.parse(stringArg,periodformatterArg);

    }

    public void staticFields() {
        Period myZERO = Period.ZERO;

    }

    public Period instanceMethods(Period testPeriod) {
        
        long longArg = 0L;
        int intArg = 0;
        PeriodType periodtypeArg = PeriodType.days();
        Chronology chronologyArg = ISOChronology.getInstanceUTC();
        Object objectArg = null;
        Period readableperiodArg = Period.ZERO;
        DurationFieldType durationfieldtypeArg = DurationFieldType.days();
        PeriodFormatter periodformatterArg = PeriodFormat.getDefault();
        ReadableInstant readableinstantArg = DateTime.now();


        Period toPeriod = testPeriod.toPeriod();
        int getYears = testPeriod.getYears();
        int getMonths = testPeriod.getMonths();
        int getWeeks = testPeriod.getWeeks();
        int getDays = testPeriod.getDays();
        int getHours = testPeriod.getHours();
        int getMinutes = testPeriod.getMinutes();
        int getMillis = testPeriod.getMillis();
        Period withPeriodType = testPeriod.withPeriodType(periodtypeArg);
        Period withFields = testPeriod.withFields(readableperiodArg);
        Period withField = testPeriod.withField(durationfieldtypeArg,intArg);
        Period withFieldAdded = testPeriod.withFieldAdded(durationfieldtypeArg,intArg);
        Period withYears = testPeriod.withYears(intArg);
        Period withMonths = testPeriod.withMonths(intArg);
        Period withWeeks = testPeriod.withWeeks(intArg);
        Period withDays = testPeriod.withDays(intArg);
        Period withHours = testPeriod.withHours(intArg);
        Period withMinutes = testPeriod.withMinutes(intArg);
        Period withSeconds = testPeriod.withSeconds(intArg);
        Period withMillis = testPeriod.withMillis(intArg);
        Period plus = testPeriod.plus(readableperiodArg);
        Period plusYears = testPeriod.plusYears(intArg);
        Period plusMonths = testPeriod.plusMonths(intArg);
        Period plusWeeks = testPeriod.plusWeeks(intArg);
        Period plusDays = testPeriod.plusDays(intArg);
        Period plusHours = testPeriod.plusHours(intArg);
        Period plusMinutes = testPeriod.plusMinutes(intArg);
        Period plusSeconds = testPeriod.plusSeconds(intArg);
        Period plusMillis = testPeriod.plusMillis(intArg);
        Period minus = testPeriod.minus(readableperiodArg);
        Period minusYears = testPeriod.minusYears(intArg);
        Period minusMonths = testPeriod.minusMonths(intArg);
        Period minusWeeks = testPeriod.minusWeeks(intArg);
        Period minusDays = testPeriod.minusDays(intArg);
        Period minusHours = testPeriod.minusHours(intArg);
        Period minusMinutes = testPeriod.minusMinutes(intArg);
        Period minusSeconds = testPeriod.minusSeconds(intArg);
        Period minusMillis = testPeriod.minusMillis(intArg);
        Period multipliedBy = testPeriod.multipliedBy(intArg);
        Period negated = testPeriod.negated();
        Weeks toStandardWeeks = testPeriod.toStandardWeeks();
        Days toStandardDays = testPeriod.toStandardDays();
        Hours toStandardHours = testPeriod.toStandardHours();
        Minutes toStandardMinutes = testPeriod.toStandardMinutes();
        Seconds toStandardSeconds = testPeriod.toStandardSeconds();
        Duration toStandardDuration = testPeriod.toStandardDuration();
        Period normalizedStandard = testPeriod.normalizedStandard();
        Period normalizedStandard1 = testPeriod.normalizedStandard(periodtypeArg);
        int getSeconds = testPeriod.getSeconds();
        PeriodType getPeriodType = testPeriod.getPeriodType();
        Duration toDurationFrom = testPeriod.toDurationFrom(readableinstantArg);
        Duration toDurationTo = testPeriod.toDurationTo(readableinstantArg);
        int getValue = testPeriod.getValue(intArg);
        int[] getValues = testPeriod.getValues();
        org.joda.time.MutablePeriod toMutablePeriod = testPeriod.toMutablePeriod();
        DurationFieldType[] getFieldTypes = testPeriod.getFieldTypes();
        int get = testPeriod.get(durationfieldtypeArg);
        boolean equals = testPeriod.equals(objectArg);
        String toString = testPeriod.toString();
        String toString1 = testPeriod.toString(periodformatterArg);
        int hashCode = testPeriod.hashCode();
        int indexOf = testPeriod.indexOf(durationfieldtypeArg);
        int size = testPeriod.size();
        org.joda.time.DurationFieldType getFieldType = testPeriod.getFieldType(intArg);
        boolean isSupported = testPeriod.isSupported(durationfieldtypeArg);

        return testPeriod;

    }

    public void instanceFields() {

    }

}
