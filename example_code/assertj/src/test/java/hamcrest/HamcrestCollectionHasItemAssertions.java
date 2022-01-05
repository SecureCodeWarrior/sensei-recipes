package hamcrest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class HamcrestCollectionHasItemAssertions {
    private final Collection<String> sevenDwarfs = List.of("Doc", "Grumpy", "Happy", "Sleepy", "Bashful", "Sneezy", "Dopey");

    @Test
    void theseAreTooComplexToBeMatched() {
        assertThat(List.of("  "), org.hamcrest.Matchers.hasItem(org.hamcrest.Matchers.blankString()));
        assertThat("reason", List.of("  "), org.hamcrest.Matchers.hasItem(org.hamcrest.Matchers.blankString()));
    }

    @Nested
    class HasItem {
        // should convert to assertThat(sevenDwarfs).contains("Sleepy")

        @Test
        void test_has_item() {
            assertThat(sevenDwarfs, org.hamcrest.Matchers.hasItem("Sleepy"));
            assertThat(sevenDwarfs, org.hamcrest.CoreMatchers.hasItem("Sleepy"));
            assertThat(sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem("Sleepy"));
        }

        @Test
        void test_has_item_with_reason() {
            assertThat("reason", sevenDwarfs, org.hamcrest.Matchers.hasItem("Sleepy"));
            assertThat("reason", sevenDwarfs, org.hamcrest.CoreMatchers.hasItem("Sleepy"));
            assertThat("reason", sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem("Sleepy"));
        }

        @Test
        void test_has_item_equal_to() {
            assertThat(sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.Matchers.equalTo("Sleepy")));
            assertThat(sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.CoreMatchers.equalTo("Sleepy")));
            assertThat(sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.core.IsEqual.equalTo("Sleepy")));

            assertThat(sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.Matchers.equalTo("Sleepy")));
            assertThat(sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.CoreMatchers.equalTo("Sleepy")));
            assertThat(sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.core.IsEqual.equalTo("Sleepy")));

            assertThat(sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.Matchers.equalTo("Sleepy")));
            assertThat(sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.CoreMatchers.equalTo("Sleepy")));
            assertThat(sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.core.IsEqual.equalTo("Sleepy")));
        }

        @Test
        void test_has_item_equal_to_with_reason() {
            assertThat("reason", sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.Matchers.equalTo("Sleepy")));
            assertThat("reason", sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.CoreMatchers.equalTo("Sleepy")));
            assertThat("reason", sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.core.IsEqual.equalTo("Sleepy")));

            assertThat("reason", sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.Matchers.equalTo("Sleepy")));
            assertThat("reason", sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.CoreMatchers.equalTo("Sleepy")));
            assertThat("reason", sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.core.IsEqual.equalTo("Sleepy")));

            assertThat("reason", sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.Matchers.equalTo("Sleepy")));
            assertThat("reason", sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.CoreMatchers.equalTo("Sleepy")));
            assertThat("reason", sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.core.IsEqual.equalTo("Sleepy")));
        }

        @Test
        void test_has_item_is() {
            assertThat(sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.Matchers.is("Sleepy")));
            assertThat(sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.CoreMatchers.is("Sleepy")));
            assertThat(sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.core.Is.is("Sleepy")));

            // ----
            assertThat(sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.Matchers.is("Sleepy")));
            assertThat(sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.CoreMatchers.is("Sleepy")));
            assertThat(sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.core.Is.is("Sleepy")));

            // ----
            assertThat(sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.Matchers.is("Sleepy")));
            assertThat(sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.CoreMatchers.is("Sleepy")));
            assertThat(sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.core.Is.is("Sleepy")));
        }

        @Test
        void test_has_item_is_with_reason() {
            assertThat("reason", sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.Matchers.is("Sleepy")));
            assertThat("reason", sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.CoreMatchers.is("Sleepy")));
            assertThat("reason", sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.core.Is.is("Sleepy")));

            assertThat("reason", sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.Matchers.is("Sleepy")));
            assertThat("reason", sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.CoreMatchers.is("Sleepy")));
            assertThat("reason", sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.core.Is.is("Sleepy")));

            assertThat("reason", sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.Matchers.is("Sleepy")));
            assertThat("reason", sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.CoreMatchers.is("Sleepy")));
            assertThat("reason", sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.core.Is.is("Sleepy")));
        }

        @Disabled("Too complex to worry about")
        @Test
        void test_has_item_is_equal_to() {
            assertThat(sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.Matchers.is(org.hamcrest.Matchers.equalTo("Sleepy"))));
            assertThat(sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.equalTo("Sleepy"))));
            assertThat(sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.core.Is.is(org.hamcrest.Matchers.equalTo("Sleepy"))));

            assertThat(sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.Matchers.is(org.hamcrest.CoreMatchers.equalTo("Sleepy"))));
            assertThat(sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.CoreMatchers.is(org.hamcrest.CoreMatchers.equalTo("Sleepy"))));
            assertThat(sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.core.Is.is(org.hamcrest.CoreMatchers.equalTo("Sleepy"))));

            assertThat(sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.Matchers.is(org.hamcrest.core.IsEqual.equalTo("Sleepy"))));
            assertThat(sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.CoreMatchers.is(org.hamcrest.core.IsEqual.equalTo("Sleepy"))));
            assertThat(sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.core.Is.is(org.hamcrest.core.IsEqual.equalTo("Sleepy"))));

            // ----
            assertThat(sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.Matchers.is(org.hamcrest.Matchers.equalTo("Sleepy"))));
            assertThat(sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.equalTo("Sleepy"))));
            assertThat(sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.core.Is.is(org.hamcrest.Matchers.equalTo("Sleepy"))));

            assertThat(sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.Matchers.is(org.hamcrest.CoreMatchers.equalTo("Sleepy"))));
            assertThat(sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.CoreMatchers.is(org.hamcrest.CoreMatchers.equalTo("Sleepy"))));
            assertThat(sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.core.Is.is(org.hamcrest.CoreMatchers.equalTo("Sleepy"))));

            assertThat(sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.Matchers.is(org.hamcrest.core.IsEqual.equalTo("Sleepy"))));
            assertThat(sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.CoreMatchers.is(org.hamcrest.core.IsEqual.equalTo("Sleepy"))));
            assertThat(sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.core.Is.is(org.hamcrest.core.IsEqual.equalTo("Sleepy"))));

            // ----
            assertThat(sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.Matchers.is(org.hamcrest.Matchers.equalTo("Sleepy"))));
            assertThat(sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.equalTo("Sleepy"))));
            assertThat(sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.core.Is.is(org.hamcrest.Matchers.equalTo("Sleepy"))));

            assertThat(sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.Matchers.is(org.hamcrest.CoreMatchers.equalTo("Sleepy"))));
            assertThat(sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.CoreMatchers.is(org.hamcrest.CoreMatchers.equalTo("Sleepy"))));
            assertThat(sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.core.Is.is(org.hamcrest.CoreMatchers.equalTo("Sleepy"))));

            assertThat(sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.Matchers.is(org.hamcrest.core.IsEqual.equalTo("Sleepy"))));
            assertThat(sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.CoreMatchers.is(org.hamcrest.core.IsEqual.equalTo("Sleepy"))));
            assertThat(sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.core.Is.is(org.hamcrest.core.IsEqual.equalTo("Sleepy"))));
        }

        @Disabled("Too complex to worry about")
        @Test
        void test_has_item_is_equal_to_with_reason() {
            assertThat("reason", sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.Matchers.is(org.hamcrest.Matchers.equalTo("Sleepy"))));
            assertThat("reason", sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.equalTo("Sleepy"))));
            assertThat("reason", sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.core.Is.is(org.hamcrest.Matchers.equalTo("Sleepy"))));

            assertThat("reason", sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.Matchers.is(org.hamcrest.CoreMatchers.equalTo("Sleepy"))));
            assertThat("reason", sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.CoreMatchers.is(org.hamcrest.CoreMatchers.equalTo("Sleepy"))));
            assertThat("reason", sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.core.Is.is(org.hamcrest.CoreMatchers.equalTo("Sleepy"))));

            assertThat("reason", sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.Matchers.is(org.hamcrest.core.IsEqual.equalTo("Sleepy"))));
            assertThat("reason", sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.CoreMatchers.is(org.hamcrest.core.IsEqual.equalTo("Sleepy"))));
            assertThat("reason", sevenDwarfs, org.hamcrest.Matchers.hasItem(org.hamcrest.core.Is.is(org.hamcrest.core.IsEqual.equalTo("Sleepy"))));

            // ----
            assertThat("reason", sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.Matchers.is(org.hamcrest.Matchers.equalTo("Sleepy"))));
            assertThat("reason", sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.equalTo("Sleepy"))));
            assertThat("reason", sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.core.Is.is(org.hamcrest.Matchers.equalTo("Sleepy"))));

            assertThat("reason", sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.Matchers.is(org.hamcrest.CoreMatchers.equalTo("Sleepy"))));
            assertThat("reason", sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.CoreMatchers.is(org.hamcrest.CoreMatchers.equalTo("Sleepy"))));
            assertThat("reason", sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.core.Is.is(org.hamcrest.CoreMatchers.equalTo("Sleepy"))));

            assertThat("reason", sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.Matchers.is(org.hamcrest.core.IsEqual.equalTo("Sleepy"))));
            assertThat("reason", sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.CoreMatchers.is(org.hamcrest.core.IsEqual.equalTo("Sleepy"))));
            assertThat("reason", sevenDwarfs, org.hamcrest.CoreMatchers.hasItem(org.hamcrest.core.Is.is(org.hamcrest.core.IsEqual.equalTo("Sleepy"))));

            // ----
            assertThat("reason", sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.Matchers.is(org.hamcrest.Matchers.equalTo("Sleepy"))));
            assertThat("reason", sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.equalTo("Sleepy"))));
            assertThat("reason", sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.core.Is.is(org.hamcrest.Matchers.equalTo("Sleepy"))));

            assertThat("reason", sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.Matchers.is(org.hamcrest.CoreMatchers.equalTo("Sleepy"))));
            assertThat("reason", sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.CoreMatchers.is(org.hamcrest.CoreMatchers.equalTo("Sleepy"))));
            assertThat("reason", sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.core.Is.is(org.hamcrest.CoreMatchers.equalTo("Sleepy"))));

            assertThat("reason", sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.Matchers.is(org.hamcrest.core.IsEqual.equalTo("Sleepy"))));
            assertThat("reason", sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.CoreMatchers.is(org.hamcrest.core.IsEqual.equalTo("Sleepy"))));
            assertThat("reason", sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItem(org.hamcrest.core.Is.is(org.hamcrest.core.IsEqual.equalTo("Sleepy"))));
        }
    }

    @Nested
    class HasItems {
        // should convert to assertThat(sevenDwarfs).contains("Bashful", "Happy")

        @Test
        void test_has_items() {
            assertThat(sevenDwarfs, org.hamcrest.Matchers.hasItems("Bashful", "Happy"));
            assertThat(sevenDwarfs, org.hamcrest.CoreMatchers.hasItems("Bashful", "Happy"));
            assertThat(sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItems("Bashful", "Happy"));
        }

        @Test
        void test_has_items_with_reason() {
            assertThat("reason", sevenDwarfs, org.hamcrest.Matchers.hasItems("Bashful", "Happy"));
            assertThat("reason", sevenDwarfs, org.hamcrest.CoreMatchers.hasItems("Bashful", "Happy"));
            assertThat("reason", sevenDwarfs, org.hamcrest.core.IsIterableContaining.hasItems("Bashful", "Happy"));
        }
    }

    @Nested
    class Contains {
        // should convert to assertThat(sevenDwarfs).containsExactly("Doc", "Grumpy", "Happy", "Sleepy", "Bashful", "Sneezy", "Dopey");

        @Test
        void test_contains_in_order() {
            assertThat(sevenDwarfs, org.hamcrest.Matchers.contains("Doc", "Grumpy", "Happy", "Sleepy", "Bashful", "Sneezy", "Dopey"));
            assertThat(sevenDwarfs, org.hamcrest.collection.IsIterableContainingInOrder.contains("Doc", "Grumpy", "Happy", "Sleepy", "Bashful", "Sneezy", "Dopey"));
        }

        @Test
        void test_contains_in_order_with_reason() {
            assertThat("reason", sevenDwarfs, org.hamcrest.Matchers.contains("Doc", "Grumpy", "Happy", "Sleepy", "Bashful", "Sneezy", "Dopey"));
            assertThat("reason", sevenDwarfs, org.hamcrest.collection.IsIterableContainingInOrder.contains("Doc", "Grumpy", "Happy", "Sleepy", "Bashful", "Sneezy", "Dopey"));
        }
    }

    @Nested
    class ContainsInAnyOrder {
        // should convert to assertThat(sevenDwarfs).containsExactlyInAnyOrder("Dopey", "Sneezy", "Bashful", "Sleepy", "Happy", "Grumpy", "Doc");

        @Test
        void test_contains_in_any_order() {
            assertThat(sevenDwarfs, org.hamcrest.Matchers.containsInAnyOrder("Dopey", "Sneezy", "Bashful", "Sleepy", "Happy", "Grumpy", "Doc"));
            assertThat(sevenDwarfs, org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder("Dopey", "Sneezy", "Bashful", "Sleepy", "Happy", "Grumpy", "Doc"));
        }

        @Test
        void test_contains_in_any_order_with_reason() {
            assertThat("reason", sevenDwarfs, org.hamcrest.Matchers.containsInAnyOrder("Dopey", "Sneezy", "Bashful", "Sleepy", "Happy", "Grumpy", "Doc"));
            assertThat("reason", sevenDwarfs, org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder("Dopey", "Sneezy", "Bashful", "Sleepy", "Happy", "Grumpy", "Doc"));
        }
    }

    @Nested
    class ContainsInRelativeOrder {
        // should convert to assertThat(sevenDwarfs).contains("Grumpy", "Sneezy");
        // N.b. the AssertJ assertions is a bit less strict than the Hamcrest assertion.

        @Test
        void test_contains_in_relative_order() {
            assertThat(sevenDwarfs, org.hamcrest.Matchers.containsInRelativeOrder("Grumpy", "Sneezy"));
            assertThat(sevenDwarfs, org.hamcrest.collection.IsIterableContainingInRelativeOrder.containsInRelativeOrder("Grumpy", "Sneezy"));
        }

        @Test
        void test_contains_in_relative_order_with_reason() {
            assertThat("reason", sevenDwarfs, org.hamcrest.Matchers.containsInRelativeOrder("Grumpy", "Sneezy"));
            assertThat("reason", sevenDwarfs, org.hamcrest.collection.IsIterableContainingInRelativeOrder.containsInRelativeOrder("Grumpy", "Sneezy"));
        }
    }
}
