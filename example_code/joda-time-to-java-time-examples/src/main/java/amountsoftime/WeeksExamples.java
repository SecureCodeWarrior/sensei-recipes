package amountsoftime;

import org.joda.time.*;

public class WeeksExamples {

    public void examples() {

        LocalDate start = LocalDate.now();
        LocalDate finish = LocalDate.now().plusYears(3);

        Weeks w1 = Weeks.weeks(5);
        Weeks w2 = Weeks.weeksBetween(start, finish);
        Weeks w3 = Weeks.parseWeeks("");

    }

}
