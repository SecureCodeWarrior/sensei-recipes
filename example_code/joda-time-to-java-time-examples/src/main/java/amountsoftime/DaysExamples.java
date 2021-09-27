package amountsoftime;

import org.joda.time.*;

public class DaysExamples {

    public void examples() {

        LocalDate start = LocalDate.now();
        LocalDate finish = LocalDate.now().plusYears(3);

        Days d1 = Days.days(5);
        Days d2 = Days.daysBetween(start, finish);
        Days d3 = Days.parseDays("");

    }

}
