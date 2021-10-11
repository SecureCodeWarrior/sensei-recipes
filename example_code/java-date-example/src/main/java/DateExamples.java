import java.time.Instant;
import java.util.Date;

public class DateExamples {

    private Date date;

    public void constructors() {
        Date date1 = new Date();
    }

    public void staticMethods() {
        Instant instant = Instant.now();
        Date date1 = Date.from(instant);
    }

    public void instanceMethods() {
        Date date1 = new Date();
        Date date2 = new Date();

        Date dateFromLong = new Date(123456L);
        Date dateFromString  = new Date("somedate");
        
        boolean a = date1.after(date2);
        boolean b = date2.before(date1);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
