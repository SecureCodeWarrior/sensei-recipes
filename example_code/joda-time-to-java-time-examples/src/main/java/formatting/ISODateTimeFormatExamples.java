package formatting;

import org.joda.time.DateTimeFieldType;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.util.Collection;

public class ISODateTimeFormatExamples {

    public void constructors() {

    }

    public void staticMethods() {

        Collection<DateTimeFieldType> collectionArg = null;
        boolean booleanArg = false;

        DateTimeFormatter forFields = ISODateTimeFormat.forFields(collectionArg,booleanArg,booleanArg);

        // Parsers
        DateTimeFormatter dateParser = ISODateTimeFormat.dateParser();
        DateTimeFormatter localDateParser = ISODateTimeFormat.localDateParser();
        DateTimeFormatter dateElementParser = ISODateTimeFormat.dateElementParser();
        DateTimeFormatter timeParser = ISODateTimeFormat.timeParser();
        DateTimeFormatter localTimeParser = ISODateTimeFormat.localTimeParser();
        DateTimeFormatter timeElementParser = ISODateTimeFormat.timeElementParser();
        DateTimeFormatter dateTimeParser = ISODateTimeFormat.dateTimeParser();
        DateTimeFormatter dateOptionalTimeParser = ISODateTimeFormat.dateOptionalTimeParser();
        DateTimeFormatter localDateOptionalTimeParser = ISODateTimeFormat.localDateOptionalTimeParser();

        // date()
        // Returns a formatter for a full date as four digit year, two digit month of year, and two digit day of month (yyyy-MM-dd).
        DateTimeFormatter date = ISODateTimeFormat.date();

        // timeNoMillis()
        // Returns a formatter for a two digit hour of day, two digit minute of hour, two digit second of minute, and time zone offset (HH:mm:ssZZ).
        DateTimeFormatter timeNoMillis = ISODateTimeFormat.timeNoMillis();

        // tTime()
        // Returns a formatter for a two digit hour of day, two digit minute of hour, two digit second of minute, three digit fraction of second, and time zone offset prefixed by 'T' ('T'HH:mm:ss.SSSZZ).
        DateTimeFormatter tTime = ISODateTimeFormat.tTime();

        // tTimeNoMillis()
        // Returns a formatter for a two digit hour of day, two digit minute of hour, two digit second of minute, and time zone offset prefixed by 'T' ('T'HH:mm:ssZZ).
        DateTimeFormatter tTimeNoMillis = ISODateTimeFormat.tTimeNoMillis();

        // dateHour()
        // Returns a formatter that combines a full date and two digit hour of day.
        DateTimeFormatter dateHour = ISODateTimeFormat.dateHour();

        // dateHourMinute()
        // Returns a formatter that combines a full date, two digit hour of day, and two digit minute of hour.
        DateTimeFormatter dateHourMinute = ISODateTimeFormat.dateHourMinute();

        // dateHourMinuteSecond()
        // Returns a formatter that combines a full date, two digit hour of day, two digit minute of hour, and two digit second of minute.
        DateTimeFormatter dateHourMinuteSecond = ISODateTimeFormat.dateHourMinuteSecond();

        // dateHourMinuteSecondMillis()
        // Returns a formatter that combines a full date, two digit hour of day, two digit minute of hour, two digit second of minute, and three digit fraction of second (yyyy-MM-dd'T'HH:mm:ss.SSS).
        DateTimeFormatter dateHourMinuteSecondMillis = ISODateTimeFormat.dateHourMinuteSecondMillis();

        // dateHourMinuteSecondFraction()
        // Returns a formatter that combines a full date, two digit hour of day, two digit minute of hour, two digit second of minute, and three digit fraction of second (yyyy-MM-dd'T'HH:mm:ss.SSS).
        DateTimeFormatter dateHourMinuteSecondFraction = ISODateTimeFormat.dateHourMinuteSecondFraction();

        // dateTime()
        // Returns a formatter that combines a full date and time, separated by a 'T' (yyyy-MM-dd'T'HH:mm:ss.SSSZZ).
        DateTimeFormatter dateTime = ISODateTimeFormat.dateTime();

        // dateTimeNoMillis()
        // Returns a formatter that combines a full date and time without millis, separated by a 'T' (yyyy-MM-dd'T'HH:mm:ssZZ).
        DateTimeFormatter dateTimeNoMillis = ISODateTimeFormat.dateTimeNoMillis();

        // hour()
        // Returns a formatter for a two digit hour of day.
        DateTimeFormatter hour = ISODateTimeFormat.hour();

        // hourMinute()
        // Returns a formatter for a two digit hour of day and two digit minute of hour.
        DateTimeFormatter hourMinute = ISODateTimeFormat.hourMinute();

        // hourMinuteSecond()
        // Returns a formatter for a two digit hour of day, two digit minute of hour, and two digit second of minute.
        DateTimeFormatter hourMinuteSecond = ISODateTimeFormat.hourMinuteSecond();

        // hourMinuteSecondMillis()
        // Returns a formatter for a two digit hour of day, two digit minute of hour, two digit second of minute, and three digit fraction of second (HH:mm:ss.SSS).
        DateTimeFormatter hourMinuteSecondMillis = ISODateTimeFormat.hourMinuteSecondMillis();

        // hourMinuteSecondFraction()
        // Returns a formatter for a two digit hour of day, two digit minute of hour, two digit second of minute, and three digit fraction of second (HH:mm:ss.SSS).
        DateTimeFormatter hourMinuteSecondFraction = ISODateTimeFormat.hourMinuteSecondFraction();

        // ordinalDate()
        // Returns a formatter for a full ordinal date, using a four digit year and three digit dayOfYear (yyyy-DDD).
        DateTimeFormatter ordinalDate = ISODateTimeFormat.ordinalDate();

        // ordinalDateTime()
        // Returns a formatter for a full ordinal date and time, using a four digit year and three digit dayOfYear (yyyy-DDD'T'HH:mm:ss.SSSZZ).
        DateTimeFormatter ordinalDateTime = ISODateTimeFormat.ordinalDateTime();

        // ordinalDateTimeNoMillis()
        // Returns a formatter for a full ordinal date and time without millis, using a four digit year and three digit dayOfYear (yyyy-DDD'T'HH:mm:ssZZ).
        DateTimeFormatter ordinalDateTimeNoMillis = ISODateTimeFormat.ordinalDateTimeNoMillis();

        // time()
        // Returns a formatter for a two digit hour of day, two digit minute of hour, two digit second of minute, three digit fraction of second, and time zone offset (HH:mm:ss.SSSZZ).
        DateTimeFormatter time = ISODateTimeFormat.time();

        // weekDate()
        // Returns a formatter for a full date as four digit weekyear, two digit week of weekyear, and one digit day of week (xxxx-'W'ww-e).
        DateTimeFormatter weekDate = ISODateTimeFormat.weekDate();

        // weekDateTime()
        // Returns a formatter that combines a full weekyear date and time, separated by a 'T' (xxxx-'W'ww-e'T'HH:mm:ss.SSSZZ).
        DateTimeFormatter weekDateTime = ISODateTimeFormat.weekDateTime();

        // weekDateTimeNoMillis()
        // Returns a formatter that combines a full weekyear date and time without millis, separated by a 'T' (xxxx-'W'ww-e'T'HH:mm:ssZZ).
        DateTimeFormatter weekDateTimeNoMillis = ISODateTimeFormat.weekDateTimeNoMillis();

        // weekyear()
        // Returns a formatter for a four digit weekyear.
        DateTimeFormatter weekyear = ISODateTimeFormat.weekyear();

        // weekyearWeek()
        // Returns a formatter for a four digit weekyear and two digit week of weekyear.
        DateTimeFormatter weekyearWeek = ISODateTimeFormat.weekyearWeek();

        // weekyearWeekDay()
        // Returns a formatter for a four digit weekyear, two digit week of weekyear, and one digit day of week.
        DateTimeFormatter weekyearWeekDay = ISODateTimeFormat.weekyearWeekDay();

        // yearMonth()
        // Returns a formatter for a four digit year and two digit month of year.
        DateTimeFormatter yearMonth = ISODateTimeFormat.yearMonth();

        // yearMonthDay()
        // Returns a formatter for a four digit year, two digit month of year, and two digit day of month.
        DateTimeFormatter yearMonthDay = ISODateTimeFormat.yearMonthDay();

        // year()
        // Returns a formatter for a four digit year.
        DateTimeFormatter year = ISODateTimeFormat.year();


        // basicDate()
        // Returns a basic formatter for a full date as four digit year, two digit month of year, and two digit day of month (yyyyMMdd).
        DateTimeFormatter basicDate = ISODateTimeFormat.basicDate();

        // basicTime()
        // Returns a basic formatter for a two digit hour of day, two digit minute of hour, two digit second of minute, three digit millis, and time zone offset (HHmmss.SSSZ).
        DateTimeFormatter basicTime = ISODateTimeFormat.basicTime();

        // basicTimeNoMillis()
        // Returns a basic formatter for a two digit hour of day, two digit minute of hour, two digit second of minute, and time zone offset (HHmmssZ).
        DateTimeFormatter basicTimeNoMillis = ISODateTimeFormat.basicTimeNoMillis();

        // basicTTime()
        // Returns a basic formatter for a two digit hour of day, two digit minute of hour, two digit second of minute, three digit millis, and time zone offset prefixed by 'T' ('T'HHmmss.SSSZ).
        DateTimeFormatter basicTTime = ISODateTimeFormat.basicTTime();

        // basicTTimeNoMillis()
        // Returns a basic formatter for a two digit hour of day, two digit minute of hour, two digit second of minute, and time zone offset prefixed by 'T' ('T'HHmmssZ).
        DateTimeFormatter basicTTimeNoMillis = ISODateTimeFormat.basicTTimeNoMillis();

        // basicDateTime()
        // Returns a basic formatter that combines a basic date and time, separated by a 'T' (yyyyMMdd'T'HHmmss.SSSZ).
        DateTimeFormatter basicDateTime = ISODateTimeFormat.basicDateTime();

        // basicDateTimeNoMillis()
        // Returns a basic formatter that combines a basic date and time without millis, separated by a 'T' (yyyyMMdd'T'HHmmssZ).
        DateTimeFormatter basicDateTimeNoMillis = ISODateTimeFormat.basicDateTimeNoMillis();

        // basicOrdinalDate()
        // Returns a formatter for a full ordinal date, using a four digit year and three digit dayOfYear (yyyyDDD).
        DateTimeFormatter basicOrdinalDate = ISODateTimeFormat.basicOrdinalDate();

        // basicOrdinalDateTime()
        // Returns a formatter for a full ordinal date and time, using a four digit year and three digit dayOfYear (yyyyDDD'T'HHmmss.SSSZ).
        DateTimeFormatter basicOrdinalDateTime = ISODateTimeFormat.basicOrdinalDateTime();

        // basicOrdinalDateTimeNoMillis()
        // Returns a formatter for a full ordinal date and time without millis, using a four digit year and three digit dayOfYear (yyyyDDD'T'HHmmssZ).
        DateTimeFormatter basicOrdinalDateTimeNoMillis = ISODateTimeFormat.basicOrdinalDateTimeNoMillis();

        // basicWeekDate()
        // Returns a basic formatter for a full date as four digit weekyear, two digit week of weekyear, and one digit day of week (xxxx'W'wwe).
        DateTimeFormatter basicWeekDate = ISODateTimeFormat.basicWeekDate();

        // basicWeekDateTime()
        // Returns a basic formatter that combines a basic weekyear date and time, separated by a 'T' (xxxx'W'wwe'T'HHmmss.SSSZ).
        DateTimeFormatter basicWeekDateTime = ISODateTimeFormat.basicWeekDateTime();

        // basicWeekDateTimeNoMillis()
        // Returns a basic formatter that combines a basic weekyear date and time without millis, separated by a 'T' (xxxx'W'wwe'T'HHmmssZ).
        DateTimeFormatter basicWeekDateTimeNoMillis = ISODateTimeFormat.basicWeekDateTimeNoMillis();



    }

    public void staticFields() {

    }

    public void instanceMethods() {

    }

    public void instanceFields() {

    }
}
