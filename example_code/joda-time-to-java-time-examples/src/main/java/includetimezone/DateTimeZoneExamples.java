package includetimezone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.ReadableInstant;
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

        org.joda.time.DateTimeZone forID = DateTimeZone.forID(zoneId);
        org.joda.time.DateTimeZone forOffsetHours = DateTimeZone.forOffsetHours(offsetHours);
        org.joda.time.DateTimeZone forOffsetHoursMinutes = DateTimeZone.forOffsetHoursMinutes(offsetHours,offsetMinutes);
        org.joda.time.DateTimeZone forOffsetMillis = DateTimeZone.forOffsetMillis(offsetMillis);
        org.joda.time.DateTimeZone forTimeZone = DateTimeZone.forTimeZone(timeZone);
        java.util.Set<String> getAvailableIDs = DateTimeZone.getAvailableIDs();
        org.joda.time.tz.NameProvider nameProvider = DateTimeZone.getNameProvider();
        DateTimeZone.setNameProvider(nameProvider);
        org.joda.time.tz.Provider provider = DateTimeZone.getProvider();
        DateTimeZone.setProvider(provider);

        org.joda.time.DateTimeZone getDefault = DateTimeZone.getDefault();
        DateTimeZone.setDefault(getDefault);

    }

    public void staticFields() {

        org.joda.time.DateTimeZone myUTC = DateTimeZone.UTC;
        java.lang.String myDEFAULT_TZ_DATA_PATH = DateTimeZone.DEFAULT_TZ_DATA_PATH;

    }

    public void instanceMethods(DateTimeZone testDateTimeZone) {
        
        long longArg = 0L;
        Locale localeArg = Locale.getDefault();
        boolean booleanArg = false;
        DateTimeZone datetimezoneArg = DateTimeZone.getDefault();
        LocalDateTime localdatetimeArg = LocalDateTime.now();
        ReadableInstant readableinstantArg = DateTime.now();

        java.lang.String getNameKey = testDateTimeZone.getNameKey(longArg);
        java.lang.String getShortName = testDateTimeZone.getShortName(longArg,localeArg);
        java.lang.String getShortName2 = testDateTimeZone.getShortName(longArg);
        int getStandardOffset = testDateTimeZone.getStandardOffset(longArg);
        boolean isStandardOffset = testDateTimeZone.isStandardOffset(longArg);
        int getOffsetFromLocal = testDateTimeZone.getOffsetFromLocal(longArg);
        long convertUTCToLocal = testDateTimeZone.convertUTCToLocal(longArg);
        long convertLocalToUTC = testDateTimeZone.convertLocalToUTC(longArg,booleanArg);
        long convertLocalToUTC2 = testDateTimeZone.convertLocalToUTC(longArg,booleanArg,longArg);
        long getMillisKeepLocal = testDateTimeZone.getMillisKeepLocal(datetimezoneArg,longArg);
        boolean isLocalDateTimeGap = testDateTimeZone.isLocalDateTimeGap(localdatetimeArg);
        long adjustOffset = testDateTimeZone.adjustOffset(longArg,booleanArg);
        boolean isFixed = testDateTimeZone.isFixed();
        long nextTransition = testDateTimeZone.nextTransition(longArg);
        long previousTransition = testDateTimeZone.previousTransition(longArg);
        java.util.TimeZone toTimeZone = testDateTimeZone.toTimeZone();
        java.lang.String getID = testDateTimeZone.getID();
        java.lang.String getName = testDateTimeZone.getName(longArg,localeArg);
        java.lang.String getName2 = testDateTimeZone.getName(longArg);
        int getOffset = testDateTimeZone.getOffset(readableinstantArg);
        int getOffset2 = testDateTimeZone.getOffset(longArg);

    }

    public void instanceFields() {

    }


}
