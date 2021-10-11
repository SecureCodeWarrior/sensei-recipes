import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarExamples {
    public void constructors() {
        Locale locale = Locale.US;
        TimeZone timezone = TimeZone.getDefault();

        Calendar gregorianCalendar1 = new GregorianCalendar();
        Calendar gregorianCalendar2 = new GregorianCalendar(2020, 05, 10);
        Calendar gregorianCalendar3 = new GregorianCalendar(2020, 05, 10, 10, 30);
        Calendar gregorianCalendar4 = new GregorianCalendar(2020, 05, 10, 10, 30, 30);
        Calendar gregorianCalendar5 = new GregorianCalendar(locale);
        Calendar gregorianCalendar6 = new GregorianCalendar(timezone);
        Calendar gregorianCalendar7 = new GregorianCalendar(timezone, locale);
    }

    public void staticMethods() {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance(TimeZone.getDefault());
    }
    
    public void instanceMethods() {
        Calendar calendar = new GregorianCalendar();
        Calendar calendar2 = new GregorianCalendar();
        calendar.add(Calendar.YEAR, 1);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.MINUTE, 1);
        calendar.add(Calendar.MILLISECOND, 1);
        calendar.add(Calendar.HOUR, 1);
        calendar.add(Calendar.SECOND, 1);
        calendar.add(Calendar.WEEK_OF_YEAR, 1);
        calendar.after(calendar2);

        calendar2.before(calendar);

        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        int clockHour = calendar.get(Calendar.HOUR);
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int month = calendar.get(Calendar.MONTH);
        int second = calendar.get(Calendar.SECOND);
        int year = calendar.get(Calendar.YEAR);

        long millis = calendar.getTimeInMillis();
        Date timeToEpochMilli = calendar.getTime();
        
        // Set using long
        calendar.setTimeInMillis(1234L);
        // Set using int 
        calendar.setTimeInMillis(123);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 1);
        calendar.set(Calendar.MILLISECOND, 1);
        calendar.set(Calendar.MINUTE, 1);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.SECOND, 1);
        calendar.set(Calendar.YEAR, 1);
        
    }
}
