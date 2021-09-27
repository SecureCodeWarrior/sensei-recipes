package amountsoftime;

import org.joda.time.LocalDate;
import org.joda.time.Seconds;

public class SecondsExamples {

    public void examples() {

        LocalDate start = LocalDate.now();
        LocalDate finish = LocalDate.now().plusYears(3);

        Seconds s1 = Seconds.seconds(50);
        Seconds s2 = Seconds.secondsBetween(start, finish);
        Seconds s3 = Seconds.parseSeconds("");

    }

}
