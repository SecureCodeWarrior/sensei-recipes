package staticimportfest;

import org.junit.jupiter.api.Test;
import org.fest.assertions.api.Assertions;
import org.fest.assertions.api.Fail;
import org.fest.assertions.core.Condition;
import org.fest.util.*;
import org.fest.assertions.data.*;

import java.util.ArrayList;

import static org.fest.assertions.api.Assertions.*;
import static org.fest.util.Closeables.closeQuietly;


class X {
    @Test
    public void shouldBeEqual() {
        assertThat(5 + 10).isEqualTo(15);
        Assertions.assertThat(5 + 10).isEqualTo(15);

        var conditionJ = new Condition<String>() {
            @Override
            public boolean matches(String s) {
                return s.equals("J");
            }
        };
        Closeables.closeQuietly();
        closeQuietly();
        Index.atIndex(1).notify();

        Fail.fail("failure");

        // These methods were renamed in AssertJ:
        assertThat(new Object()).isLenientEqualsToByIgnoringFields(new Object());
        assertThat(new Object()).isLenientEqualsToByAcceptingFields(new Object());
        assertThat(new Object()).isLenientEqualsToByIgnoringNullFields(new Object());
        assertThat(new Object()).isEqualsToByComparingFields(new Object());

        // These methods are not available in AssertJ:
        assertThat(new ArrayList<String>()).areNotAtLeast(5, conditionJ);
        assertThat(new ArrayList<String>()).areNotAtMost(5, conditionJ);
        assertThat(new ArrayList<String>()).areNotExactly(5, conditionJ);
        // There is no evidence in the FEST source code that these names ever existed:
//        assertThat(new ArrayList<String>()).haveNotAtLeast(5, conditionJ);
//        assertThat(new ArrayList<String>()).haveNotAtMost(5, conditionJ);
//        assertThat(new ArrayList<String>()).haveNotExactly(5, conditionJ);
        // But these names did exist in FEST:
        assertThat(new ArrayList<String>()).doNotHaveAtLeast(5, conditionJ);
        assertThat(new ArrayList<String>()).doNotHaveAtMost(5, conditionJ);
        assertThat(new ArrayList<String>()).doNotHaveExactly(5, conditionJ);

    }
}
