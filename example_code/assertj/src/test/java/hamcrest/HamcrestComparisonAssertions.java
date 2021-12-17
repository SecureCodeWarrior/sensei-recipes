package hamcrest;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

class HamcrestComparisonAssertions {
    @Nested
    class GreaterThan {
        @Test
        void test_greaterThan() {
            assertThat(2, org.hamcrest.Matchers.greaterThan(1));
            assertThat(2, org.hamcrest.number.OrderingComparison.greaterThan(1));
        }

        @Test
        void test_greaterThan_with_reason() {
            assertThat("reason", 2, org.hamcrest.Matchers.greaterThan(1));
            assertThat("reason", 2, org.hamcrest.number.OrderingComparison.greaterThan(1));
        }

        @Test
        void test_isGreaterThan() {
            assertThat(2, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.greaterThan(1)));
            assertThat(2, org.hamcrest.CoreMatchers.is(org.hamcrest.number.OrderingComparison.greaterThan(1)));

            assertThat(2, org.hamcrest.core.Is.is(org.hamcrest.Matchers.greaterThan(1)));
            assertThat(2, org.hamcrest.core.Is.is(org.hamcrest.number.OrderingComparison.greaterThan(1)));

            assertThat(2, org.hamcrest.Matchers.is(org.hamcrest.Matchers.greaterThan(1)));
            assertThat(2, org.hamcrest.Matchers.is(org.hamcrest.number.OrderingComparison.greaterThan(1)));
        }

        @Test
        void test_isGreaterThan_with_reason() {
            assertThat("reason", 2, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.greaterThan(1)));
            assertThat("reason", 2, org.hamcrest.CoreMatchers.is(org.hamcrest.number.OrderingComparison.greaterThan(1)));

            assertThat("reason", 2, org.hamcrest.core.Is.is(org.hamcrest.Matchers.greaterThan(1)));
            assertThat("reason", 2, org.hamcrest.core.Is.is(org.hamcrest.number.OrderingComparison.greaterThan(1)));

            assertThat("reason", 2, org.hamcrest.Matchers.is(org.hamcrest.Matchers.greaterThan(1)));
            assertThat("reason", 2, org.hamcrest.Matchers.is(org.hamcrest.number.OrderingComparison.greaterThan(1)));
        }
    }

    @Nested
    class GreaterThanOrEqualTo {
        private final int actual = 1;
        private final int expected = 1;

        @Test
        void test_greaterThanOrEqualTo() {
            assertThat(actual, org.hamcrest.Matchers.greaterThanOrEqualTo(1));
            assertThat(actual, org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo(1));
        }

        @Test
        void test_greaterThanOrEqualTo_with_reason() {
            assertThat("reason", actual, org.hamcrest.Matchers.greaterThanOrEqualTo(expected));
            assertThat("reason", actual, org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo(expected));
        }

        @Test
        void test_isGreaterThanOrEqualTo() {
            assertThat(actual, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.greaterThanOrEqualTo(expected)));
            assertThat(actual, org.hamcrest.CoreMatchers.is(org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo(expected)));

            assertThat(actual, org.hamcrest.core.Is.is(org.hamcrest.Matchers.greaterThanOrEqualTo(expected)));
            assertThat(actual, org.hamcrest.core.Is.is(org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo(expected)));

            assertThat(actual, org.hamcrest.Matchers.is(org.hamcrest.Matchers.greaterThanOrEqualTo(expected)));
            assertThat(actual, org.hamcrest.Matchers.is(org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo(expected)));
        }

        @Test
        void test_isGreaterThanOrEqualTo_with_reason() {
            assertThat("reason", actual, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.greaterThanOrEqualTo(expected)));
            assertThat("reason", actual, org.hamcrest.CoreMatchers.is(org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo(expected)));

            assertThat("reason", actual, org.hamcrest.core.Is.is(org.hamcrest.Matchers.greaterThanOrEqualTo(expected)));
            assertThat("reason", actual, org.hamcrest.core.Is.is(org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo(expected)));

            assertThat("reason", actual, org.hamcrest.Matchers.is(org.hamcrest.Matchers.greaterThanOrEqualTo(expected)));
            assertThat("reason", actual, org.hamcrest.Matchers.is(org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo(expected)));
        }
    }

    @Nested
    class LessThan {
        @Test
        void test_lessThan() {
            assertThat(1, org.hamcrest.Matchers.lessThan(2));
            assertThat(1, org.hamcrest.number.OrderingComparison.lessThan(2));
        }

        @Test
        void test_lessThan_with_reason() {
            assertThat("reason", 1, org.hamcrest.Matchers.lessThan(2));
            assertThat("reason", 1, org.hamcrest.number.OrderingComparison.lessThan(2));
        }

        @Test
        void test_isLessThan() {
            assertThat(1, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.lessThan(2)));
            assertThat(1, org.hamcrest.CoreMatchers.is(org.hamcrest.number.OrderingComparison.lessThan(2)));

            assertThat(1, org.hamcrest.core.Is.is(org.hamcrest.Matchers.lessThan(2)));
            assertThat(1, org.hamcrest.core.Is.is(org.hamcrest.number.OrderingComparison.lessThan(2)));

            assertThat(1, org.hamcrest.Matchers.is(org.hamcrest.Matchers.lessThan(2)));
            assertThat(1, org.hamcrest.Matchers.is(org.hamcrest.number.OrderingComparison.lessThan(2)));
        }

        @Test
        void test_isLessThan_with_reason() {
            assertThat("reason", 1, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.lessThan(2)));
            assertThat("reason", 1, org.hamcrest.CoreMatchers.is(org.hamcrest.number.OrderingComparison.lessThan(2)));

            assertThat("reason", 1, org.hamcrest.core.Is.is(org.hamcrest.Matchers.lessThan(2)));
            assertThat("reason", 1, org.hamcrest.core.Is.is(org.hamcrest.number.OrderingComparison.lessThan(2)));

            assertThat("reason", 1, org.hamcrest.Matchers.is(org.hamcrest.Matchers.lessThan(2)));
            assertThat("reason", 1, org.hamcrest.Matchers.is(org.hamcrest.number.OrderingComparison.lessThan(2)));
        }
    }

    @Nested
    class LessThanOrEqualTo {
        private final int actual = 1;
        private final int expected = 1;

        @Test
        void test_lessThanOrEqualTo() {
            assertThat(actual, org.hamcrest.Matchers.lessThanOrEqualTo(expected));
            assertThat(actual, org.hamcrest.number.OrderingComparison.lessThanOrEqualTo(expected));
        }

        @Test
        void test_lessThanOrEqualTo_with_reason() {
            assertThat("reason", actual, org.hamcrest.Matchers.lessThanOrEqualTo(expected));
            assertThat("reason", actual, org.hamcrest.number.OrderingComparison.lessThanOrEqualTo(expected));
        }

        @Test
        void test_isLessThanOrEqualTo() {
            assertThat(actual, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.lessThanOrEqualTo(expected)));
            assertThat(actual, org.hamcrest.CoreMatchers.is(org.hamcrest.number.OrderingComparison.lessThanOrEqualTo(expected)));

            assertThat(actual, org.hamcrest.core.Is.is(org.hamcrest.Matchers.lessThanOrEqualTo(expected)));
            assertThat(actual, org.hamcrest.core.Is.is(org.hamcrest.number.OrderingComparison.lessThanOrEqualTo(expected)));

            assertThat(actual, org.hamcrest.Matchers.is(org.hamcrest.Matchers.lessThanOrEqualTo(expected)));
            assertThat(actual, org.hamcrest.Matchers.is(org.hamcrest.number.OrderingComparison.lessThanOrEqualTo(expected)));
        }

        @Test
        void test_isLessThanOrEqualTo_with_reason() {
            assertThat("reason", actual, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.lessThanOrEqualTo(expected)));
            assertThat("reason", actual, org.hamcrest.CoreMatchers.is(org.hamcrest.number.OrderingComparison.lessThanOrEqualTo(expected)));

            assertThat("reason", actual, org.hamcrest.core.Is.is(org.hamcrest.Matchers.lessThanOrEqualTo(expected)));
            assertThat("reason", actual, org.hamcrest.core.Is.is(org.hamcrest.number.OrderingComparison.lessThanOrEqualTo(expected)));

            assertThat("reason", actual, org.hamcrest.Matchers.is(org.hamcrest.Matchers.lessThanOrEqualTo(expected)));
            assertThat("reason", actual, org.hamcrest.Matchers.is(org.hamcrest.number.OrderingComparison.lessThanOrEqualTo(expected)));
        }
    }

    @Nested
    class ComparesEqualTo {
        private final int actual = 1;
        private final int expected = 1;

        @Test
        void test_comparesEqualTo() {
            assertThat(actual, org.hamcrest.Matchers.comparesEqualTo(expected));
            assertThat(actual, org.hamcrest.number.OrderingComparison.comparesEqualTo(expected));
        }

        @Test
        void test_comparesEqualTo_with_reason() {
            assertThat("reason", actual, org.hamcrest.Matchers.comparesEqualTo(expected));
            assertThat("reason", actual, org.hamcrest.number.OrderingComparison.comparesEqualTo(expected));
        }

        @Test
        void test_isLessThanOrEqualTo() {
            assertThat(actual, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.comparesEqualTo(expected)));
            assertThat(actual, org.hamcrest.CoreMatchers.is(org.hamcrest.number.OrderingComparison.comparesEqualTo(expected)));

            assertThat(actual, org.hamcrest.core.Is.is(org.hamcrest.Matchers.comparesEqualTo(expected)));
            assertThat(actual, org.hamcrest.core.Is.is(org.hamcrest.number.OrderingComparison.comparesEqualTo(expected)));

            assertThat(actual, org.hamcrest.Matchers.is(org.hamcrest.Matchers.comparesEqualTo(expected)));
            assertThat(actual, org.hamcrest.Matchers.is(org.hamcrest.number.OrderingComparison.comparesEqualTo(expected)));
        }

        @Test
        void test_isComparesEqualTo_with_reason() {
            assertThat("reason", actual, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.comparesEqualTo(expected)));
            assertThat("reason", actual, org.hamcrest.CoreMatchers.is(org.hamcrest.number.OrderingComparison.comparesEqualTo(expected)));

            assertThat("reason", actual, org.hamcrest.core.Is.is(org.hamcrest.Matchers.comparesEqualTo(expected)));
            assertThat("reason", actual, org.hamcrest.core.Is.is(org.hamcrest.number.OrderingComparison.comparesEqualTo(expected)));

            assertThat("reason", actual, org.hamcrest.Matchers.is(org.hamcrest.Matchers.comparesEqualTo(expected)));
            assertThat("reason", actual, org.hamcrest.Matchers.is(org.hamcrest.number.OrderingComparison.comparesEqualTo(expected)));
        }
    }
}
