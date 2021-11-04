import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.util.Calendar;

public class CalendarTest {

    @Test
    void calendarChangeGetMonthValue() {
        var calendar = Calendar.getInstance();
        var localDate = LocalDateTime.now();

        Assertions.assertEquals(10, calendar.get(Calendar.MONTH));
        Assertions.assertEquals(11, localDate.getMonthValue());
    }

    @Test
    void calendarChangeSetMonth() {
        var calendar = Calendar.getInstance();
        var localDate = LocalDateTime.now();

        calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        localDate = localDate.withMonth(Month.DECEMBER.getValue());

        Assertions.assertEquals(11, calendar.get(Calendar.MONTH));
        Assertions.assertEquals(12, localDate.getMonthValue());
    }

    @Test
    void calendarDayOfWeek() {
        LocalDateTime calendar = LocalDateTime.now();
        var localDate = LocalDate.now();

        Assertions.assertEquals(4, calendar.get(ChronoField.DAY_OF_WEEK) + 1);
        Assertions.assertEquals(3, localDate.getDayOfWeek().getValue());
    }

}
