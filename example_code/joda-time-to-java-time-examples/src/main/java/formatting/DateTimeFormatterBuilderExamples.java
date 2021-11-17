package formatting;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.format.*;

import java.util.Map;

public class DateTimeFormatterBuilderExamples {

    public void constructors() {

        DateTimeFormatterBuilder DateTimeFormatterBuilder1 = new DateTimeFormatterBuilder();

    }

    public void staticMethods() {
        // None
    }

    public void staticFields() {
        // None
    }

    public void instanceMethods() {

        DateTimeFormatterBuilder dtfb = new DateTimeFormatterBuilder();

        // Arguments
        DateTimeParser datetimeparserArg = null;
        String stringArg = null;
        Character charArg = null;
        DateTimeFieldType datetimefieldtypeArg = null;
        DateTimePrinter datetimeprinterArg = null;
        DateTimeFormatter datetimeformatterArg = DateTimeFormat.fullDateTime();
        DateTimeParser[] dateTimeParsers = null;
        int intArg = 0;
        boolean booleanArg = false;
        Map<String, DateTimeZone> mapArg = null;

        DateTimeFormatter toFormatter = dtfb.toFormatter();
        DateTimePrinter toPrinter = dtfb.toPrinter();
        DateTimeParser toParser = dtfb.toParser();
        boolean canBuildFormatter = dtfb.canBuildFormatter();
        boolean canBuildPrinter = dtfb.canBuildPrinter();
        boolean canBuildParser = dtfb.canBuildParser();

        // look in Joda Source Code to help understand the mappings used
        // https://github.com/JodaOrg/joda-time/blob/master/src/main/java/org/joda/time/format/DateTimeFormatterBuilder.java

        DateTimeFormatterBuilder appendOptional = dtfb.appendOptional(datetimeparserArg);
        DateTimeFormatterBuilder appendLiteral = dtfb.appendLiteral(stringArg);
        DateTimeFormatterBuilder appendLiteral1 = dtfb.appendLiteral(charArg);
        DateTimeFormatterBuilder appendDecimal = dtfb.appendDecimal(datetimefieldtypeArg,intArg,intArg);
        DateTimeFormatterBuilder appendFixedDecimal = dtfb.appendFixedDecimal(datetimefieldtypeArg,intArg);
        DateTimeFormatterBuilder appendSignedDecimal = dtfb.appendSignedDecimal(datetimefieldtypeArg,intArg,intArg);
        DateTimeFormatterBuilder appendFixedSignedDecimal = dtfb.appendFixedSignedDecimal(datetimefieldtypeArg,intArg);
        DateTimeFormatterBuilder appendText = dtfb.appendText(datetimefieldtypeArg);
        DateTimeFormatterBuilder appendShortText = dtfb.appendShortText(datetimefieldtypeArg);
        DateTimeFormatterBuilder appendFraction = dtfb.appendFraction(datetimefieldtypeArg,intArg,intArg);
        DateTimeFormatterBuilder appendFractionOfSecond = dtfb.appendFractionOfSecond(intArg,intArg);
        DateTimeFormatterBuilder appendFractionOfMinute = dtfb.appendFractionOfMinute(intArg,intArg);
        DateTimeFormatterBuilder appendFractionOfHour = dtfb.appendFractionOfHour(intArg,intArg);
        DateTimeFormatterBuilder appendFractionOfDay = dtfb.appendFractionOfDay(intArg,intArg);
        DateTimeFormatterBuilder appendMillisOfSecond = dtfb.appendMillisOfSecond(intArg);
        DateTimeFormatterBuilder appendMillisOfDay = dtfb.appendMillisOfDay(intArg);
        DateTimeFormatterBuilder appendSecondOfMinute = dtfb.appendSecondOfMinute(intArg);
        DateTimeFormatterBuilder appendSecondOfDay = dtfb.appendSecondOfDay(intArg);
        DateTimeFormatterBuilder appendMinuteOfHour = dtfb.appendMinuteOfHour(intArg);
        DateTimeFormatterBuilder appendMinuteOfDay = dtfb.appendMinuteOfDay(intArg);
        DateTimeFormatterBuilder appendHourOfDay = dtfb.appendHourOfDay(intArg);
        DateTimeFormatterBuilder appendClockhourOfDay = dtfb.appendClockhourOfDay(intArg);
        DateTimeFormatterBuilder appendHourOfHalfday = dtfb.appendHourOfHalfday(intArg);
        DateTimeFormatterBuilder appendClockhourOfHalfday = dtfb.appendClockhourOfHalfday(intArg);
        DateTimeFormatterBuilder appendDayOfWeek = dtfb.appendDayOfWeek(intArg);
        DateTimeFormatterBuilder appendDayOfMonth = dtfb.appendDayOfMonth(intArg);
        DateTimeFormatterBuilder appendDayOfYear = dtfb.appendDayOfYear(intArg);
        DateTimeFormatterBuilder appendWeekOfWeekyear = dtfb.appendWeekOfWeekyear(intArg);
        DateTimeFormatterBuilder appendWeekyear = dtfb.appendWeekyear(intArg,intArg);
        DateTimeFormatterBuilder appendMonthOfYear = dtfb.appendMonthOfYear(intArg);
        DateTimeFormatterBuilder appendYear = dtfb.appendYear(intArg,intArg);
        DateTimeFormatterBuilder appendTwoDigitYear = dtfb.appendTwoDigitYear(intArg,booleanArg);
        DateTimeFormatterBuilder appendTwoDigitYear1 = dtfb.appendTwoDigitYear(intArg);
        DateTimeFormatterBuilder appendTwoDigitWeekyear = dtfb.appendTwoDigitWeekyear(intArg,booleanArg);
        DateTimeFormatterBuilder appendTwoDigitWeekyear1 = dtfb.appendTwoDigitWeekyear(intArg);
        DateTimeFormatterBuilder appendYearOfEra = dtfb.appendYearOfEra(intArg,intArg);
        DateTimeFormatterBuilder appendYearOfCentury = dtfb.appendYearOfCentury(intArg,intArg);
        DateTimeFormatterBuilder appendCenturyOfEra = dtfb.appendCenturyOfEra(intArg,intArg);
        DateTimeFormatterBuilder appendHalfdayOfDayText = dtfb.appendHalfdayOfDayText();
        DateTimeFormatterBuilder appendDayOfWeekText = dtfb.appendDayOfWeekText();
        DateTimeFormatterBuilder appendDayOfWeekShortText = dtfb.appendDayOfWeekShortText();
        DateTimeFormatterBuilder appendMonthOfYearText = dtfb.appendMonthOfYearText();
        DateTimeFormatterBuilder appendMonthOfYearShortText = dtfb.appendMonthOfYearShortText();
        DateTimeFormatterBuilder appendEraText = dtfb.appendEraText();
        DateTimeFormatterBuilder appendTimeZoneName = dtfb.appendTimeZoneName(mapArg);
        DateTimeFormatterBuilder appendTimeZoneName1 = dtfb.appendTimeZoneName();
        DateTimeFormatterBuilder appendTimeZoneShortName = dtfb.appendTimeZoneShortName();
        DateTimeFormatterBuilder appendTimeZoneShortName1 = dtfb.appendTimeZoneShortName(mapArg);
        DateTimeFormatterBuilder appendTimeZoneId = dtfb.appendTimeZoneId();
        DateTimeFormatterBuilder appendTimeZoneOffset = dtfb.appendTimeZoneOffset(stringArg,booleanArg,intArg,intArg);
        DateTimeFormatterBuilder appendTimeZoneOffset1 = dtfb.appendTimeZoneOffset(stringArg,stringArg,booleanArg,intArg,intArg);
        DateTimeFormatterBuilder appendPattern = dtfb.appendPattern(stringArg);
        DateTimeFormatterBuilder append = dtfb.append(datetimeprinterArg);
        DateTimeFormatterBuilder append1 = dtfb.append(datetimeformatterArg);
        DateTimeFormatterBuilder append2 = dtfb.append(datetimeprinterArg,dateTimeParsers);
        DateTimeFormatterBuilder append3 = dtfb.append(datetimeparserArg);
        DateTimeFormatterBuilder append4 = dtfb.append(datetimeprinterArg,datetimeparserArg);
        dtfb.clear();



    }

    public void instanceFields() {

    }
}
