package fest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.util.Closeables.closeQuietly;
import static org.fest.assertions.data.Index.atIndex;
import static org.fest.assertions.api.Fail.fail;

/* This class only imports FEST statically (no "references" or normal imports), but still must be handled by the FEST recipes */
class StaticImportsOnly {
    @Test
    public void shouldBeEqual() {
        assertThat(5 + 10).isEqualTo(15);

        var conditionJ = new org.fest.assertions.core.Condition<String>() {
            @Override
            public boolean matches(String s) {
                return s.equals("J");
            }
        };
        closeQuietly();
        atIndex(1).notify();

        fail("failure");

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
