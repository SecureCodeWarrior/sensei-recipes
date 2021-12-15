package hamcrest;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

class HamcrestNullAssertions {
    @Nested
    class Null {
        private final Object nullValue = null;

        @Test
        void test_nullValue() {
            assertThat(nullValue, org.hamcrest.CoreMatchers.nullValue());
            assertThat(nullValue, org.hamcrest.CoreMatchers.nullValue(Object.class));
            assertThat(nullValue, org.hamcrest.core.IsNull.nullValue());
            assertThat(nullValue, org.hamcrest.core.IsNull.nullValue(Object.class));
            assertThat(nullValue, org.hamcrest.Matchers.nullValue());
            assertThat(nullValue, org.hamcrest.Matchers.nullValue(Object.class));
        }

        @Test
        void test_nullValue_with_reason() {
            assertThat("reason", nullValue, org.hamcrest.CoreMatchers.nullValue());
            assertThat("reason", nullValue, org.hamcrest.CoreMatchers.nullValue(Object.class));
            assertThat("reason", nullValue, org.hamcrest.core.IsNull.nullValue());
            assertThat("reason", nullValue, org.hamcrest.core.IsNull.nullValue(Object.class));
            assertThat("reason", nullValue, org.hamcrest.Matchers.nullValue());
            assertThat("reason", nullValue, org.hamcrest.Matchers.nullValue(Object.class));
        }

        @Test
        void test_isNullValue() {
            assertThat(nullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.CoreMatchers.nullValue()));
            assertThat(nullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.CoreMatchers.nullValue(Object.class)));
            assertThat(nullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.core.IsNull.nullValue()));
            assertThat(nullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.core.IsNull.nullValue(Object.class)));
            assertThat(nullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.nullValue()));
            assertThat(nullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.nullValue(Object.class)));

            assertThat(nullValue, org.hamcrest.core.Is.is(org.hamcrest.CoreMatchers.nullValue()));
            assertThat(nullValue, org.hamcrest.core.Is.is(org.hamcrest.CoreMatchers.nullValue(Object.class)));
            assertThat(nullValue, org.hamcrest.core.Is.is(org.hamcrest.core.IsNull.nullValue()));
            assertThat(nullValue, org.hamcrest.core.Is.is(org.hamcrest.core.IsNull.nullValue(Object.class)));
            assertThat(nullValue, org.hamcrest.core.Is.is(org.hamcrest.Matchers.nullValue()));
            assertThat(nullValue, org.hamcrest.core.Is.is(org.hamcrest.Matchers.nullValue(Object.class)));

            assertThat(nullValue, org.hamcrest.Matchers.is(org.hamcrest.CoreMatchers.nullValue()));
            assertThat(nullValue, org.hamcrest.Matchers.is(org.hamcrest.CoreMatchers.nullValue(Object.class)));
            assertThat(nullValue, org.hamcrest.Matchers.is(org.hamcrest.core.IsNull.nullValue()));
            assertThat(nullValue, org.hamcrest.Matchers.is(org.hamcrest.core.IsNull.nullValue(Object.class)));
            assertThat(nullValue, org.hamcrest.Matchers.is(org.hamcrest.Matchers.nullValue()));
            assertThat(nullValue, org.hamcrest.Matchers.is(org.hamcrest.Matchers.nullValue(Object.class)));
        }

        @Test
        void test_isNullValue_with_reason() {
            assertThat("reason", nullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.CoreMatchers.nullValue()));
            assertThat("reason", nullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.CoreMatchers.nullValue(Object.class)));
            assertThat("reason", nullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.core.IsNull.nullValue()));
            assertThat("reason", nullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.core.IsNull.nullValue(Object.class)));
            assertThat("reason", nullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.nullValue()));
            assertThat("reason", nullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.nullValue(Object.class)));

            assertThat("reason", nullValue, org.hamcrest.core.Is.is(org.hamcrest.CoreMatchers.nullValue()));
            assertThat("reason", nullValue, org.hamcrest.core.Is.is(org.hamcrest.CoreMatchers.nullValue(Object.class)));
            assertThat("reason", nullValue, org.hamcrest.core.Is.is(org.hamcrest.core.IsNull.nullValue()));
            assertThat("reason", nullValue, org.hamcrest.core.Is.is(org.hamcrest.core.IsNull.nullValue(Object.class)));
            assertThat("reason", nullValue, org.hamcrest.core.Is.is(org.hamcrest.Matchers.nullValue()));
            assertThat("reason", nullValue, org.hamcrest.core.Is.is(org.hamcrest.Matchers.nullValue(Object.class)));

            assertThat("reason", nullValue, org.hamcrest.Matchers.is(org.hamcrest.CoreMatchers.nullValue()));
            assertThat("reason", nullValue, org.hamcrest.Matchers.is(org.hamcrest.CoreMatchers.nullValue(Object.class)));
            assertThat("reason", nullValue, org.hamcrest.Matchers.is(org.hamcrest.core.IsNull.nullValue()));
            assertThat("reason", nullValue, org.hamcrest.Matchers.is(org.hamcrest.core.IsNull.nullValue(Object.class)));
            assertThat("reason", nullValue, org.hamcrest.Matchers.is(org.hamcrest.Matchers.nullValue()));
            assertThat("reason", nullValue, org.hamcrest.Matchers.is(org.hamcrest.Matchers.nullValue(Object.class)));
        }
    }

    @Nested
    class NotNull {
        private final Object notNullValue = new Object();

        @Test
        void test_notNullValue() {
            assertThat(notNullValue, org.hamcrest.CoreMatchers.notNullValue());
            assertThat(notNullValue, org.hamcrest.CoreMatchers.notNullValue(Object.class));
            assertThat(notNullValue, org.hamcrest.core.IsNull.notNullValue());
            assertThat(notNullValue, org.hamcrest.core.IsNull.notNullValue(Object.class));
            assertThat(notNullValue, org.hamcrest.Matchers.notNullValue());
            assertThat(notNullValue, org.hamcrest.Matchers.notNullValue(Object.class));
        }

        @Test
        void test_notNullValue_with_reason() {
            assertThat("reason", notNullValue, org.hamcrest.CoreMatchers.notNullValue());
            assertThat("reason", notNullValue, org.hamcrest.CoreMatchers.notNullValue(Object.class));
            assertThat("reason", notNullValue, org.hamcrest.core.IsNull.notNullValue());
            assertThat("reason", notNullValue, org.hamcrest.core.IsNull.notNullValue(Object.class));
            assertThat("reason", notNullValue, org.hamcrest.Matchers.notNullValue());
            assertThat("reason", notNullValue, org.hamcrest.Matchers.notNullValue(Object.class));
        }

        @Test
        void test_isNotNullValue() {
            assertThat(notNullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.CoreMatchers.notNullValue()));
            assertThat(notNullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.CoreMatchers.notNullValue(Object.class)));
            assertThat(notNullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.core.IsNull.notNullValue()));
            assertThat(notNullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.core.IsNull.notNullValue(Object.class)));
            assertThat(notNullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.notNullValue()));
            assertThat(notNullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.notNullValue(Object.class)));

            assertThat(notNullValue, org.hamcrest.core.Is.is(org.hamcrest.CoreMatchers.notNullValue()));
            assertThat(notNullValue, org.hamcrest.core.Is.is(org.hamcrest.CoreMatchers.notNullValue(Object.class)));
            assertThat(notNullValue, org.hamcrest.core.Is.is(org.hamcrest.core.IsNull.notNullValue()));
            assertThat(notNullValue, org.hamcrest.core.Is.is(org.hamcrest.core.IsNull.notNullValue(Object.class)));
            assertThat(notNullValue, org.hamcrest.core.Is.is(org.hamcrest.Matchers.notNullValue()));
            assertThat(notNullValue, org.hamcrest.core.Is.is(org.hamcrest.Matchers.notNullValue(Object.class)));

            assertThat(notNullValue, org.hamcrest.Matchers.is(org.hamcrest.CoreMatchers.notNullValue()));
            assertThat(notNullValue, org.hamcrest.Matchers.is(org.hamcrest.CoreMatchers.notNullValue(Object.class)));
            assertThat(notNullValue, org.hamcrest.Matchers.is(org.hamcrest.core.IsNull.notNullValue()));
            assertThat(notNullValue, org.hamcrest.Matchers.is(org.hamcrest.core.IsNull.notNullValue(Object.class)));
            assertThat(notNullValue, org.hamcrest.Matchers.is(org.hamcrest.Matchers.notNullValue()));
            assertThat(notNullValue, org.hamcrest.Matchers.is(org.hamcrest.Matchers.notNullValue(Object.class)));
        }

        @Test
        void test_isNotNullValue_with_reason() {
            assertThat("reason", notNullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.CoreMatchers.notNullValue()));
            assertThat("reason", notNullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.CoreMatchers.notNullValue(Object.class)));
            assertThat("reason", notNullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.core.IsNull.notNullValue()));
            assertThat("reason", notNullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.core.IsNull.notNullValue(Object.class)));
            assertThat("reason", notNullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.notNullValue()));
            assertThat("reason", notNullValue, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.notNullValue(Object.class)));

            assertThat("reason", notNullValue, org.hamcrest.core.Is.is(org.hamcrest.CoreMatchers.notNullValue()));
            assertThat("reason", notNullValue, org.hamcrest.core.Is.is(org.hamcrest.CoreMatchers.notNullValue(Object.class)));
            assertThat("reason", notNullValue, org.hamcrest.core.Is.is(org.hamcrest.core.IsNull.notNullValue()));
            assertThat("reason", notNullValue, org.hamcrest.core.Is.is(org.hamcrest.core.IsNull.notNullValue(Object.class)));
            assertThat("reason", notNullValue, org.hamcrest.core.Is.is(org.hamcrest.Matchers.notNullValue()));
            assertThat("reason", notNullValue, org.hamcrest.core.Is.is(org.hamcrest.Matchers.notNullValue(Object.class)));

            assertThat("reason", notNullValue, org.hamcrest.Matchers.is(org.hamcrest.CoreMatchers.notNullValue()));
            assertThat("reason", notNullValue, org.hamcrest.Matchers.is(org.hamcrest.CoreMatchers.notNullValue(Object.class)));
            assertThat("reason", notNullValue, org.hamcrest.Matchers.is(org.hamcrest.core.IsNull.notNullValue()));
            assertThat("reason", notNullValue, org.hamcrest.Matchers.is(org.hamcrest.core.IsNull.notNullValue(Object.class)));
            assertThat("reason", notNullValue, org.hamcrest.Matchers.is(org.hamcrest.Matchers.notNullValue()));
            assertThat("reason", notNullValue, org.hamcrest.Matchers.is(org.hamcrest.Matchers.notNullValue(Object.class)));
        }
    }
}
