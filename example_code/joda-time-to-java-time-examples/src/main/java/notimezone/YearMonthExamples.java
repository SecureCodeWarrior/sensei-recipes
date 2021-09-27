package notimezone;

import org.joda.time.YearMonth;

public class YearMonthExamples {

    public void examples() {

        YearMonth ymnow = YearMonth.now();
        YearMonth ymnowplus = YearMonth.now().minusMonths(5);

    }
}
