package other;

import org.joda.time.DateTimeFieldType;

public class DateTimeFieldTypeExamples {

    public void examples() {

        // Not Supported
        DateTimeFieldType era = DateTimeFieldType.centuryOfEra();

        // Supported
        DateTimeFieldType sometype1 = DateTimeFieldType.clockhourOfDay();
        DateTimeFieldType sometype2 = DateTimeFieldType.clockhourOfHalfday();
        DateTimeFieldType sometype3 = DateTimeFieldType.dayOfMonth();
        DateTimeFieldType sometype4 = DateTimeFieldType.dayOfWeek();
        DateTimeFieldType sometype5 = DateTimeFieldType.dayOfYear();
        DateTimeFieldType sometype6 = DateTimeFieldType.era();
        DateTimeFieldType sometype7 = DateTimeFieldType.halfdayOfDay();
        DateTimeFieldType sometype8 = DateTimeFieldType.hourOfDay();
        DateTimeFieldType sometype9 = DateTimeFieldType.hourOfHalfday();
        DateTimeFieldType sometype10 = DateTimeFieldType.millisOfDay();
        DateTimeFieldType sometype11 = DateTimeFieldType.millisOfSecond();
        DateTimeFieldType sometype12 = DateTimeFieldType.minuteOfDay();
        DateTimeFieldType sometype13 = DateTimeFieldType.minuteOfHour();
        DateTimeFieldType sometype14 = DateTimeFieldType.monthOfYear();
        DateTimeFieldType sometype15 = DateTimeFieldType.secondOfDay();
        DateTimeFieldType sometype16 = DateTimeFieldType.secondOfMinute();

        // Not Sure
        DateTimeFieldType dtft1 = DateTimeFieldType.weekOfWeekyear();
        DateTimeFieldType dtft2 = DateTimeFieldType.weekyear();
        DateTimeFieldType dtft3 = DateTimeFieldType.weekyearOfCentury();

        // Supported
        DateTimeFieldType dtft4 = DateTimeFieldType.year();

        // Not Supported
        DateTimeFieldType dtft5 = DateTimeFieldType.yearOfCentury();

        // Supported
        DateTimeFieldType dtft6 = DateTimeFieldType.yearOfEra();
    }

}
