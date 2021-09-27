package other;

import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.IslamicChronology;

public class ChronologyExamples {


    // https://www.joda.org/joda-time/key_chronology.html

    public void factoryMethods() {

        DateTimeZone dtz = DateTimeZone.UTC;

        //Buddhist to Thai Buddhist
        // https://www.joda.org/joda-time/cal_buddhist.html
        Chronology bc1 = BuddhistChronology.getInstance();
        Chronology bc2 = BuddhistChronology.getInstance(dtz);
        Chronology bc3 = BuddhistChronology.getInstanceUTC();
        //Coptic
        //Ethiopic
        //Gregorian-Julian cutover
        //Gregorian

        //Islamic to Hijrah
        Chronology ic1 = IslamicChronology.getInstance();
        Chronology ic2 = IslamicChronology.getInstance(dtz);
        Chronology ic3 = IslamicChronology.getInstance(dtz,IslamicChronology.LEAP_YEAR_15_BASED);
        Chronology ic4 = IslamicChronology.getInstanceUTC();

        //ISO
        Chronology c = ISOChronology.getInstance();
        Chronology c2 = ISOChronology.getInstanceUTC();
        Chronology c3 = ISOChronology.getInstance(dtz);

        //Julian

    }

}
