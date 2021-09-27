package notimezone;

import notimezone.LocalDateExamples;
import org.junit.jupiter.api.Test;

public class LocalDateExamplesTest {


    @Test
    public void localdate_created_with_constructors_should_match_target_date() {


        LocalDateExamples examples = new LocalDateExamples();

        /*
            Idea here is to make all the LocalDate examples return a date, and assert they are the same
            then the tests can be run before and after applying the recipes to make sure they all still
            return the same date
         */

    }


}
