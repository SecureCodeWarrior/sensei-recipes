package fest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/* This class doesn't have any FEST imports (just references), but still must be handled by the FEST recipes */
class DirectFestWithoutImports {
    @Test
    public void shouldBeEqual() {
        org.fest.assertions.api.Assertions.assertThat(5 + 10).isEqualTo(15);

        var conditionJ = new org.fest.assertions.core.Condition<String>() {
            @Override
            public boolean matches(String s) {
                return s.equals("J");
            }
        };
        org.fest.util.Closeables.closeQuietly();
        org.fest.assertions.data.Index.atIndex(1).notify();

        org.fest.assertions.api.Fail.fail("failure");

        // These methods were renamed in AssertJ:
        org.fest.assertions.api.Assertions.assertThat(new Object()).isLenientEqualsToByIgnoringFields(new Object());
        org.fest.assertions.api.Assertions.assertThat(new Object()).isLenientEqualsToByAcceptingFields(new Object());
        org.fest.assertions.api.Assertions.assertThat(new Object()).isLenientEqualsToByIgnoringNullFields(new Object());
        org.fest.assertions.api.Assertions.assertThat(new Object()).isEqualsToByComparingFields(new Object());

        // These methods are not available in AssertJ:
        org.fest.assertions.api.Assertions.assertThat(new ArrayList<String>()).areNotAtLeast(5, conditionJ);
        org.fest.assertions.api.Assertions.assertThat(new ArrayList<String>()).areNotAtMost(5, conditionJ);
        org.fest.assertions.api.Assertions.assertThat(new ArrayList<String>()).areNotExactly(5, conditionJ);
        // There is no evidence in the FEST source code that these names ever existed:
//        org.fest.assertions.api.Assertions.assertThat(new ArrayList<String>()).haveNotAtLeast(5, conditionJ);
//        org.fest.assertions.api.Assertions.assertThat(new ArrayList<String>()).haveNotAtMost(5, conditionJ);
//        org.fest.assertions.api.Assertions.assertThat(new ArrayList<String>()).haveNotExactly(5, conditionJ);
        // But these names did exist in FEST:
        org.fest.assertions.api.Assertions.assertThat(new ArrayList<String>()).doNotHaveAtLeast(5, conditionJ);
        org.fest.assertions.api.Assertions.assertThat(new ArrayList<String>()).doNotHaveAtMost(5, conditionJ);
        org.fest.assertions.api.Assertions.assertThat(new ArrayList<String>()).doNotHaveExactly(5, conditionJ);

    }
}
