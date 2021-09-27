package amountsoftime;

import org.joda.time.*;

public class YearsExamples {

    public void examples() {

        LocalDate start = LocalDate.now();
        LocalDate finish = LocalDate.now().plusYears(3);

        Years y1 = Years.years(5);
        Years y2 = Years.yearsBetween(start, finish);
        Years y3 = Years.parseYears("");


        // Recipes for these not created yet
        Years yy0 = Years.ZERO;
        Years yy1 = Years.ONE;
        Years yy2 = Years.TWO;
        Years yy3 = Years.THREE;

        // not sure if these have an equivalent
        Years yyMAX = Years.MAX_VALUE;
        Years yyMIN = Years.MIN_VALUE;

    }

}
