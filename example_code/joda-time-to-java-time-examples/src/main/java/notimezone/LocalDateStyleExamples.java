package notimezone;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.TemporalAdjusters.*;

public class LocalDateStyleExamples {

    public void stuff() {

        LocalDate ld = LocalDate.now().with(firstDayOfNextMonth()).minusDays(1);
        LocalDate ld2 = LocalDate.now().with(lastDayOfMonth());

        LocalDate ld4 = LocalDate.now().with(firstDayOfNextMonth());
        LocalDate ld3 = LocalDate.now().with(firstDayOfNextMonth());

        LocalDate ld34 = LocalDate.now().plusMonths(1).plusYears(3).withDayOfMonth(1);
        LocalDate ld43 = LocalDate.now().with(firstDayOfNextMonth());

        // Use Month.MAY enum instead of 5
        LocalDate monthInt = LocalDate.of(2020, 5, 31);
        LocalDate monthEnum = LocalDate.of(2020, Month.MAY, 31);

        // Use minus<Unit> instead of minus(long, ChronoUnit.<UNIT>)
        LocalDate minusDays = LocalDate.now().minus(65, ChronoUnit.DAYS);
        LocalDate minusWeeks = LocalDate.now().minus(65, ChronoUnit.WEEKS);
        LocalDate minusMonths = LocalDate.now().minus(65, ChronoUnit.MONTHS);
        LocalDate minusYears = LocalDate.now().minus(65, ChronoUnit.YEARS);

        // Use plus<Unit> instead of plus(long, ChronoUnit.<UNIT>)
        LocalDate plusDays = LocalDate.now().plus(65, ChronoUnit.DAYS);
        LocalDate plusWeeks = LocalDate.now().plus(65, ChronoUnit.WEEKS);
        LocalDate plusMonths = LocalDate.now().plus(65, ChronoUnit.MONTHS);
        LocalDate plusYears = LocalDate.now().plus(65, ChronoUnit.YEARS);

        // Use with<Unit> instead of with(ChronoField.UNIT, long) (Warning do this for int only - long may be converted)
        LocalDate withDayOfMonth = LocalDate.now().with(ChronoField.DAY_OF_MONTH, 5);
        LocalDate withDayOfYear = LocalDate.now().with(ChronoField.DAY_OF_YEAR, 56);
        LocalDate withMonthOfYear = LocalDate.now().with(ChronoField.MONTH_OF_YEAR, 3);
        LocalDate withYear = LocalDate.now().with(ChronoField.YEAR, 3030);

    }

}
