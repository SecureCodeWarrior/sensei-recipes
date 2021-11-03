package common;

import org.assertj.core.api.Assertions;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetCenturyFieldsTest {

    /*
        Test the algorithm used by the getCenturyOfEra recipe over a 10,000 year period
     */
    @Test
    public void testCenturyOfEra() {

        IntStream.range(-5000, 5000).forEach(i -> test_centuryOfEra_algorithm(i));

    }

    /*
        Test the algorithm used by the getYearOfCentury recipe over a 10,000 year period
     */
    @Test
    public void testYearOfCentury() {

        IntStream.range(-5000, 5000).forEach(i -> test_yearOfCentury_algorithm(i));

    }

    /*
    * For a given year, tests that the Joda-Time method getCenturyOfEra() is equivalent to the algorithm used by
    * the Common/get/getCenturyOfEra.yaml migration recipe
    */
    private void test_centuryOfEra_algorithm(int year) {

        DateTime dt = DateTime.now().withYear(year);
        ZonedDateTime zdt = ZonedDateTime.now().withYear(year);

        int centuryOfEra = dt.getCenturyOfEra();
        int zdtCenturyOfEra = Math.abs(zdt.getYear() / 100);

        assertThat(centuryOfEra).isEqualTo(zdtCenturyOfEra);

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
