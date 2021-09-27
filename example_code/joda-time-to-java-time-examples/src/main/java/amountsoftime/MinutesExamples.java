package amountsoftime;

import org.joda.time.LocalDate;
import org.joda.time.Minutes;

public class MinutesExamples {

    public void examples() {

        LocalDate start = LocalDate.now();
        LocalDate finish = LocalDate.now().plusYears(3);

        Minutes m1 = Minutes.minutes(6);
        Minutes m2 = Minutes.minutesBetween(start, finish);
        Minutes m3 = Minutes.parseMinutes("");

    }

}
