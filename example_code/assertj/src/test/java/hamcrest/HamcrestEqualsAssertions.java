package hamcrest;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

class HamcrestEqualsAssertions {

    private final String actual = "hello" + " world";
    private final String expected = "hello world";

    @Test
    void test_equalTo() {
        assertThat(actual, org.hamcrest.CoreMatchers.equalTo(expected));
        assertThat(actual, org.hamcrest.core.IsEqual.equalTo(expected));
        assertThat(actual, org.hamcrest.Matchers.equalTo(expected));
    }

    @Test
    void test_equalTo_with_reason() {
        assertThat("reason", actual, org.hamcrest.CoreMatchers.equalTo(expected));
        assertThat("reason", actual, org.hamcrest.core.IsEqual.equalTo(expected));
        assertThat("reason", actual, org.hamcrest.Matchers.equalTo(expected));
    }

    @Test
    void test_is() {
        assertThat(actual, org.hamcrest.CoreMatchers.is(expected));
        assertThat(actual, org.hamcrest.core.Is.is(expected));
        assertThat(actual, org.hamcrest.Matchers.is(expected));
    }

    @Test
    void test_is_with_reason() {
        assertThat("reason", actual, org.hamcrest.CoreMatchers.is(expected));
        assertThat("reason", actual, org.hamcrest.core.Is.is(expected));
        assertThat("reason", actual, org.hamcrest.Matchers.is(expected));
    }

    @Test
    void test_isEqualTo() {
        assertThat(actual, org.hamcrest.CoreMatchers.is(org.hamcrest.CoreMatchers.equalTo(expected)));
        assertThat(actual, org.hamcrest.CoreMatchers.is(org.hamcrest.core.IsEqual.equalTo(expected)));
        assertThat(actual, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.equalTo(expected)));

        assertThat(actual, org.hamcrest.core.Is.is(org.hamcrest.CoreMatchers.equalTo(expected)));
        assertThat(actual, org.hamcrest.core.Is.is(org.hamcrest.core.IsEqual.equalTo(expected)));
        assertThat(actual, org.hamcrest.core.Is.is(org.hamcrest.Matchers.equalTo(expected)));

        assertThat(actual, org.hamcrest.Matchers.is(org.hamcrest.CoreMatchers.equalTo(expected)));
        assertThat(actual, org.hamcrest.Matchers.is(org.hamcrest.core.IsEqual.equalTo(expected)));
        assertThat(actual, org.hamcrest.Matchers.is(org.hamcrest.Matchers.equalTo(expected)));
    }

    @Test
    void test_isEqualTo_with_reason() {
        assertThat("reason", actual, org.hamcrest.CoreMatchers.is(org.hamcrest.CoreMatchers.equalTo(expected)));
        assertThat("reason", actual, org.hamcrest.CoreMatchers.is(org.hamcrest.core.IsEqual.equalTo(expected)));
        assertThat("reason", actual, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.equalTo(expected)));

        assertThat("reason", actual, org.hamcrest.core.Is.is(org.hamcrest.CoreMatchers.equalTo(expected)));
        assertThat("reason", actual, org.hamcrest.core.Is.is(org.hamcrest.core.IsEqual.equalTo(expected)));
        assertThat("reason", actual, org.hamcrest.core.Is.is(org.hamcrest.Matchers.equalTo(expected)));

        assertThat("reason", actual, org.hamcrest.Matchers.is(org.hamcrest.CoreMatchers.equalTo(expected)));
        assertThat("reason", actual, org.hamcrest.Matchers.is(org.hamcrest.core.IsEqual.equalTo(expected)));
        assertThat("reason", actual, org.hamcrest.Matchers.is(org.hamcrest.Matchers.equalTo(expected)));
    }
}
