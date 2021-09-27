package amountsoftime;

import org.joda.time.*;

public class MonthsExamples {

    public void examples() {

        LocalDate start = LocalDate.now();
        LocalDate finish = LocalDate.now().plusYears(3);

        Months m1 = Months.months(3);
        Months m2 = Months.monthsBetween(start, finish);
        Months m3 = Months.parseMonths("");

    }

}
