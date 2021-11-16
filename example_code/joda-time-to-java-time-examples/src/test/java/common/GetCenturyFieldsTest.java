package common;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.MutableDateTime;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class GetCenturyFieldsTest {

    /*
        This method is used to assert that the fix provided in getCenturyOfEra.yaml
        will correctly determine the expected century of era
     */
    private void test_centuryOfEra_algorithm(int expectedCenturyOfEra, int javaYear) {

        int centuryOfEra = Math.abs(javaYear / 100);
        assertThat(centuryOfEra).isEqualTo(expectedCenturyOfEra);

    }

    /*
        Test the algorithm used by the getCenturyOfEra recipe over a 10,000 year period
     */
    @Test
    public void testCenturyOfEra() {

        IntStream.range(-11000, 11000).forEach(i -> test_centuryOfEra_algorithm(i));

    }

    /*
        Test the algorithm used by the getYearOfCentury recipe over a 10,000 year period
     */
    @Test
    public void testYearOfCentury() {

        IntStream.range(-11000, 11000).forEach(i -> test_yearOfCentury_algorithm(i));

    }

    /*
    * For a given year, tests that the Joda-Time method getCenturyOfEra() is equivalent to the algorithm used by
    * the Common/get/getCenturyOfEra.yaml migration recipe
    */
    private void test_centuryOfEra_algorithm(int year) {

        // DateTime
        DateTime dt = DateTime.now().withYear(year);
        DateMidnight dm = DateMidnight.now().withYear(year);
        MutableDateTime mdt = MutableDateTime.now();
        mdt.setYear(year);
        ZonedDateTime zdt = ZonedDateTime.now().withYear(year);
        test_centuryOfEra_algorithm(dt.getCenturyOfEra(), zdt.getYear());
        test_centuryOfEra_algorithm(mdt.getCenturyOfEra(), zdt.getYear());
        test_centuryOfEra_algorithm(dm.getCenturyOfEra(), zdt.getYear());

        // Local Date
        org.joda.time.LocalDate jodaLocalDate = org.joda.time.LocalDate.now().withYear(year);
        java.time.LocalDate javaLocalDate = java.time.LocalDate.now().withYear(year);
        test_centuryOfEra_algorithm(jodaLocalDate.getCenturyOfEra(), javaLocalDate.getYear());

        // Local Date Time
        org.joda.time.LocalDateTime jodaLocalDateTime = org.joda.time.LocalDateTime.now().withYear(year);
        java.time.LocalDateTime javaLocalDateTime = java.time.LocalDateTime.now().withYear(year);
        test_centuryOfEra_algorithm(jodaLocalDate.getCenturyOfEra(), javaLocalDate.getYear());


    }


    /*
     * For a given year, tests that the Joda-Time method getYearOfCentury() is equivalent to the algorithm used by
     * the Common/get/getYearOfCentury.yaml migration recipe
     */
    private void test_yearOfCentury_algorithm(int year) {

        DateTime dt = DateTime.now().withYear(year);
        ZonedDateTime zdt = ZonedDateTime.now().withYear(year);

        int yearOfCentury = dt.getYearOfCentury();
        int zdtYearOfCentury = Math.abs(zdt.getYear() % 100);

        assertThat(zdtYearOfCentury).isEqualTo(yearOfCentury);

    }

}
