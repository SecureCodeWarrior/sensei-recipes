package includetimezone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.tz.NameProvider;
import org.joda.time.tz.Provider;

import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateTimeZoneExamples {

    // https://www.joda.org/joda-time/timezones.html
    public void constructors() {
        // No Constructors
    }

    public void staticMethods() {

        String zoneId = "";
        TimeZone timeZone = TimeZone.getDefault();
        int offsetHours = 5;
        int offsetMinutes = 30;
        int offsetMillis = 1234455;

        DateTimeZone forID = DateTimeZone.forID(zoneId);
        DateTimeZone forOffsetHours = DateTimeZone.forOffsetHours(offsetHours);
        DateTimeZone forOffsetHoursMinutes = DateTimeZone.forOffsetHoursMinutes(offsetHours, offsetMinutes);
        DateTimeZone forOffsetMillis = DateTimeZone.forOffsetMillis(offsetMillis);
        DateTimeZone forTimeZone = DateTimeZone.forTimeZone(timeZone);
        java.util.Set<String> getAvailableIDs = DateTimeZone.getAvailableIDs();

        // Not sure if these have equivalents
        NameProvider nameProvider = DateTimeZone.getNameProvider();
        DateTimeZone.setNameProvider(nameProvider);
        Provider provider = DateTimeZone.getProvider();
        DateTimeZone.setProvider(provider);

        org.joda.time.DateTimeZone getDefault = DateTimeZone.getDefault();
        DateTimeZone.setDefault(getDefault);

    }

    public void staticFields() {

        org.joda.time.DateTimeZone myUTC = DateTimeZone.UTC;
        // Use without assignment
        DateTimeZone.UTC.equals(DateTimeZone.UTC);

        java.lang.String myDEFAULT_TZ_DATA_PATH = DateTimeZone.DEFAULT_TZ_DATA_PATH;

    }

    public void instanceMethods(DateTimeZone testDateTimeZone) {

        long longArg = 0L;
        Locale localeArg = Locale.getDefault();
        boolean booleanArg = false;
        DateTimeZone datetimezoneArg = DateTimeZone.getDefault();
        LocalDateTime localdatetimeArg = LocalDateTime.now();
        ReadableInstant readableinstantArg = DateTime.now();

        java.util.TimeZone toTimeZone = testDateTimeZone.toTimeZone();
        java.lang.String getID = testDateTimeZone.getID();
        java.lang.String getName = testDateTimeZone.getName(longArg, localeArg);
        java.lang.String getName2 = testDateTimeZone.getName(longArg);
        java.lang.String getShortName = testDateTimeZone.getShortName(longArg, localeArg);
        java.lang.String getShortName2 = testDateTimeZone.getShortName(longArg);

        // No recipes for these yet. Further investigation needed
        java.lang.String getNameKey = testDateTimeZone.getNameKey(longArg);
        int getStandardOffset = testDateTimeZone.getStandardOffset(longArg);
        boolean isStandardOffset = testDateTimeZone.isStandardOffset(longArg);
        int getOffsetFromLocal = testDateTimeZone.getOffsetFromLocal(longArg);
        long convertUTCToLocal = testDateTimeZone.convertUTCToLocal(longArg);
        long convertLocalToUTC = testDateTimeZone.convertLocalToUTC(longArg, booleanArg);
        long convertLocalToUTC2 = testDateTimeZone.convertLocalToUTC(longArg, booleanArg, longArg);
        long getMillisKeepLocal = testDateTimeZone.getMillisKeepLocal(datetimezoneArg, longArg);
        boolean isLocalDateTimeGap = testDateTimeZone.isLocalDateTimeGap(localdatetimeArg);
        long adjustOffset = testDateTimeZone.adjustOffset(longArg, booleanArg);
        boolean isFixed = testDateTimeZone.isFixed();
        long nextTransition = testDateTimeZone.nextTransition(longArg);
        long previousTransition = testDateTimeZone.previousTransition(longArg);
        int getOffset = testDateTimeZone.getOffset(readableinstantArg);
        int getOffset2 = testDateTimeZone.getOffset(longArg);


    }

    public void instanceFields() {

    }


}
