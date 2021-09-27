package amountsoftime;

import org.joda.time.Hours;
import org.joda.time.LocalDate;

public class HoursExamples {

    public void examples() {

        LocalDate start = LocalDate.now();
        LocalDate finish = LocalDate.now().plusYears(3);

        Hours h1 = Hours.hours(5);
        Hours h2 = Hours.hoursBetween(start, finish);
        Hours h3 = Hours.parseHours("");

    }

}
