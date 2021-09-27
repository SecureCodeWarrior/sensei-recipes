package notimezone;

import org.joda.time.MonthDay;

public class MonthDayExamples {

    public void examples() {

        MonthDay mdnow = MonthDay.now();
        MonthDay mdnowplus = MonthDay.now().plusDays(50);
        MonthDay mdnowminus = MonthDay.now().minusDays(5);

    }
}
