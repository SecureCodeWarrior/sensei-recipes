package notimezone;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalDateTimeExamplesTest {

    @Test
    public void test_month_of_year_equals_monthvalue() {

        org.joda.time.LocalDateTime jodaLDT = org.joda.time.LocalDateTime.now();
        java.time.LocalDateTime javaLDT = java.time.LocalDateTime.now();

        int jodaMonth = jodaLDT.getMonthOfYear();
        int javaMonth = javaLDT.getMonthValue();

        assertEquals(jodaMonth, javaMonth);

    }
}
