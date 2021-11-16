package formatting;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Locale;

public class DateTimeFormatExamples {

    public void constructors() {

    }

    public void staticMethods() {

        // It would be good to include some sort of warning that you will need to double check
        // Your date pattern as the formatting rules are different for joda and java
        DateTimeFormatter forPattern = DateTimeFormat.forPattern("somepattern");

        /*
            Complex set of 25 recipes could deal with this
            Formatters are built use a 2 letter combo of S,M,L,F,-
            First letter is date
            e.g. SS, MM, SL, -F
        */
        DateTimeFormatter forStyle = DateTimeFormat.forStyle("SS");
        String patternForStyle = DateTimeFormat.patternForStyle("SS", Locale.getDefault());

        DateTimeFormatter shortDate = DateTimeFormat.shortDate();
        DateTimeFormatter shortTime = DateTimeFormat.shortTime();
        DateTimeFormatter shortDateTime = DateTimeFormat.shortDateTime();
        DateTimeFormatter mediumDate = DateTimeFormat.mediumDate();
        DateTimeFormatter mediumTime = DateTimeFormat.mediumTime();
        DateTimeFormatter mediumDateTime = DateTimeFormat.mediumDateTime();
        DateTimeFormatter longDate = DateTimeFormat.longDate();
        DateTimeFormatter longTime = DateTimeFormat.longTime();
        DateTimeFormatter longDateTime = DateTimeFormat.longDateTime();
        DateTimeFormatter fullDate = DateTimeFormat.fullDate();
        DateTimeFormatter fullTime = DateTimeFormat.fullTime();
        DateTimeFormatter fullDateTime = DateTimeFormat.fullDateTime();

    }

    public void staticFields() {

    }

    public void instanceMethods() {
        
    }

    public void instanceFields() {

    }
}
