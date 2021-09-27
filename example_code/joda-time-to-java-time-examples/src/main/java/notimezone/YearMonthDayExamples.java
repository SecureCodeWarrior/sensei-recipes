package notimezone;

import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.YearMonthDay;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.ISOChronology;

import java.util.Calendar;
import java.util.Date;

public class YearMonthDayExamples {

    @SuppressWarnings("unused")
    public void constructorsNoDependencies() {

        //YearMonthDay unassignedYearMonthDay;
        //YearMonthDay nullYearMonthDay = null;

        YearMonthDay noargs = new YearMonthDay();

        YearMonthDay fromParts = new YearMonthDay(2021, 1, 15);

        long instant = System.currentTimeMillis();
        YearMonthDay fromInstant = new YearMonthDay(instant);

        Object instantObject = new Date();
        YearMonthDay fromObject = new YearMonthDay(instantObject);

        Date javaDate = new Date();
        YearMonthDay fromJavaDate = new YearMonthDay(javaDate);

    }

    public void constructorsWithDependencies() {

        Chronology chronology = BuddhistChronology.getInstance();

        // These will only show after you have converted chronology
        YearMonthDay fromChronology = new YearMonthDay(chronology);
        YearMonthDay fromChronologyInline = new YearMonthDay(ISOChronology.getInstance());

        YearMonthDay fromPartsWithChronology = new YearMonthDay(2021, 1, 15, chronology);

        YearMonthDay fromDateTimeZone = new YearMonthDay(DateTimeZone.UTC);

        long instant = System.currentTimeMillis();

        YearMonthDay fromInstantWithChronology = new YearMonthDay(instant, chronology);

        Object instantObject = new Date();

        YearMonthDay fromObjectWithChronology = new YearMonthDay(instantObject, chronology);


    }

    public void staticMethods() {

        // Setup some preassigned variables
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();

        // using variables
        YearMonthDay fromCalendarFields = YearMonthDay.fromCalendarFields(calendar);
        YearMonthDay fromDateFields = YearMonthDay.fromDateFields(date);

        // Inline
        YearMonthDay fromCalendarFieldsInline = YearMonthDay.fromCalendarFields(Calendar.getInstance());
        YearMonthDay fromDateFieldsInline = YearMonthDay.fromDateFields(new Date());

    }

}
