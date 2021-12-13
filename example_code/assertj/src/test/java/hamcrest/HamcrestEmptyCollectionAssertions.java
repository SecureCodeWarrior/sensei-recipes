package hamcrest;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class HamcrestEmptyCollectionAssertions {
    @Nested
    class EmptyCollection {
        private final Collection<String> emptyCollection = List.of();

        @Test
        void test_empty() {
            assertThat(emptyCollection, org.hamcrest.Matchers.empty());
            assertThat(emptyCollection, org.hamcrest.Matchers.emptyCollectionOf(String.class));
            assertThat(emptyCollection, org.hamcrest.collection.IsEmptyCollection.empty());
            assertThat(emptyCollection, org.hamcrest.collection.IsEmptyCollection.emptyCollectionOf(String.class));
        }

        @Test
        void test_empty_with_reason() {
            assertThat("reason", emptyCollection, org.hamcrest.Matchers.empty());
            assertThat("reason", emptyCollection, org.hamcrest.Matchers.emptyCollectionOf(String.class));
            assertThat("reason", emptyCollection, org.hamcrest.collection.IsEmptyCollection.empty());
            assertThat("reason", emptyCollection, org.hamcrest.collection.IsEmptyCollection.emptyCollectionOf(String.class));
        }

        @Test
        void test_is_empty() {
            assertThat(emptyCollection, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.empty()));
            assertThat(emptyCollection, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.emptyCollectionOf(String.class)));
            assertThat(emptyCollection, org.hamcrest.CoreMatchers.is(org.hamcrest.collection.IsEmptyCollection.empty()));
            assertThat(emptyCollection, org.hamcrest.CoreMatchers.is(org.hamcrest.collection.IsEmptyCollection.emptyCollectionOf(String.class)));

            assertThat(emptyCollection, org.hamcrest.core.Is.is(org.hamcrest.Matchers.empty()));
            assertThat(emptyCollection, org.hamcrest.core.Is.is(org.hamcrest.Matchers.emptyCollectionOf(String.class)));
            assertThat(emptyCollection, org.hamcrest.core.Is.is(org.hamcrest.collection.IsEmptyCollection.empty()));
            assertThat(emptyCollection, org.hamcrest.core.Is.is(org.hamcrest.collection.IsEmptyCollection.emptyCollectionOf(String.class)));

            assertThat(emptyCollection, org.hamcrest.Matchers.is(org.hamcrest.Matchers.empty()));
            assertThat(emptyCollection, org.hamcrest.Matchers.is(org.hamcrest.Matchers.emptyCollectionOf(String.class)));
            assertThat(emptyCollection, org.hamcrest.Matchers.is(org.hamcrest.collection.IsEmptyCollection.empty()));
            assertThat(emptyCollection, org.hamcrest.Matchers.is(org.hamcrest.collection.IsEmptyCollection.emptyCollectionOf(String.class)));
        }

        @Test
        void test_is_empty_with_reason() {
            assertThat("reason", emptyCollection, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.empty()));
            assertThat("reason", emptyCollection, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.emptyCollectionOf(String.class)));
            assertThat("reason", emptyCollection, org.hamcrest.CoreMatchers.is(org.hamcrest.collection.IsEmptyCollection.empty()));
            assertThat("reason", emptyCollection, org.hamcrest.CoreMatchers.is(org.hamcrest.collection.IsEmptyCollection.emptyCollectionOf(String.class)));

            assertThat("reason", emptyCollection, org.hamcrest.core.Is.is(org.hamcrest.Matchers.empty()));
            assertThat("reason", emptyCollection, org.hamcrest.core.Is.is(org.hamcrest.Matchers.emptyCollectionOf(String.class)));
            assertThat("reason", emptyCollection, org.hamcrest.core.Is.is(org.hamcrest.collection.IsEmptyCollection.empty()));
            assertThat("reason", emptyCollection, org.hamcrest.core.Is.is(org.hamcrest.collection.IsEmptyCollection.emptyCollectionOf(String.class)));

            assertThat("reason", emptyCollection, org.hamcrest.Matchers.is(org.hamcrest.Matchers.empty()));
            assertThat("reason", emptyCollection, org.hamcrest.Matchers.is(org.hamcrest.Matchers.emptyCollectionOf(String.class)));
            assertThat("reason", emptyCollection, org.hamcrest.Matchers.is(org.hamcrest.collection.IsEmptyCollection.empty()));
            assertThat("reason", emptyCollection, org.hamcrest.Matchers.is(org.hamcrest.collection.IsEmptyCollection.emptyCollectionOf(String.class)));
        }
    }

    @Nested
    class EmptyIterable {
        private final Iterable<String> emptyIterable = List.of();

        @Test
        void test_empty() {
            assertThat(emptyIterable, org.hamcrest.Matchers.emptyIterable());
            assertThat(emptyIterable, org.hamcrest.Matchers.emptyIterableOf(String.class));
            assertThat(emptyIterable, org.hamcrest.collection.IsEmptyIterable.emptyIterable());
            assertThat(emptyIterable, org.hamcrest.collection.IsEmptyIterable.emptyIterableOf(String.class));
        }

        @Test
        void test_empty_with_reason() {
            assertThat("reason", emptyIterable, org.hamcrest.Matchers.emptyIterable());
            assertThat("reason", emptyIterable, org.hamcrest.Matchers.emptyIterableOf(String.class));
            assertThat("reason", emptyIterable, org.hamcrest.collection.IsEmptyIterable.emptyIterable());
            assertThat("reason", emptyIterable, org.hamcrest.collection.IsEmptyIterable.emptyIterableOf(String.class));
        }

        @Test
        void test_is_empty() {
            assertThat(emptyIterable, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.emptyIterable()));
            assertThat(emptyIterable, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.emptyIterableOf(String.class)));
            assertThat(emptyIterable, org.hamcrest.CoreMatchers.is(org.hamcrest.collection.IsEmptyIterable.emptyIterable()));
            assertThat(emptyIterable, org.hamcrest.CoreMatchers.is(org.hamcrest.collection.IsEmptyIterable.emptyIterableOf(String.class)));

            assertThat(emptyIterable, org.hamcrest.core.Is.is(org.hamcrest.Matchers.emptyIterable()));
            assertThat(emptyIterable, org.hamcrest.core.Is.is(org.hamcrest.Matchers.emptyIterableOf(String.class)));
            assertThat(emptyIterable, org.hamcrest.core.Is.is(org.hamcrest.collection.IsEmptyIterable.emptyIterable()));
            assertThat(emptyIterable, org.hamcrest.core.Is.is(org.hamcrest.collection.IsEmptyIterable.emptyIterableOf(String.class)));

            assertThat(emptyIterable, org.hamcrest.Matchers.is(org.hamcrest.Matchers.emptyIterable()));
            assertThat(emptyIterable, org.hamcrest.Matchers.is(org.hamcrest.Matchers.emptyIterableOf(String.class)));
            assertThat(emptyIterable, org.hamcrest.Matchers.is(org.hamcrest.collection.IsEmptyIterable.emptyIterable()));
            assertThat(emptyIterable, org.hamcrest.Matchers.is(org.hamcrest.collection.IsEmptyIterable.emptyIterableOf(String.class)));
        }

        @Test
        void test_is_empty_with_reason() {
            assertThat("reason", emptyIterable, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.emptyIterable()));
            assertThat("reason", emptyIterable, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.emptyIterableOf(String.class)));
            assertThat("reason", emptyIterable, org.hamcrest.CoreMatchers.is(org.hamcrest.collection.IsEmptyIterable.emptyIterable()));
            assertThat("reason", emptyIterable, org.hamcrest.CoreMatchers.is(org.hamcrest.collection.IsEmptyIterable.emptyIterableOf(String.class)));

            assertThat("reason", emptyIterable, org.hamcrest.core.Is.is(org.hamcrest.Matchers.emptyIterable()));
            assertThat("reason", emptyIterable, org.hamcrest.core.Is.is(org.hamcrest.Matchers.emptyIterableOf(String.class)));
            assertThat("reason", emptyIterable, org.hamcrest.core.Is.is(org.hamcrest.collection.IsEmptyIterable.emptyIterable()));
            assertThat("reason", emptyIterable, org.hamcrest.core.Is.is(org.hamcrest.collection.IsEmptyIterable.emptyIterableOf(String.class)));

            assertThat("reason", emptyIterable, org.hamcrest.Matchers.is(org.hamcrest.Matchers.emptyIterable()));
            assertThat("reason", emptyIterable, org.hamcrest.Matchers.is(org.hamcrest.Matchers.emptyIterableOf(String.class)));
            assertThat("reason", emptyIterable, org.hamcrest.Matchers.is(org.hamcrest.collection.IsEmptyIterable.emptyIterable()));
            assertThat("reason", emptyIterable, org.hamcrest.Matchers.is(org.hamcrest.collection.IsEmptyIterable.emptyIterableOf(String.class)));
        }
    }

    @Nested
    class EmptyArray {
        private final String[] emptyArray = new String[]{};

        @Test
        void test_empty() {
            assertThat(emptyArray, org.hamcrest.Matchers.emptyArray());
        }

        @Test
        void test_empty_with_reason() {
            assertThat("reason", emptyArray, org.hamcrest.Matchers.emptyArray());
        }

        @Test
        void test_is_empty() {
            assertThat(emptyArray, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.emptyArray()));
            assertThat(emptyArray, org.hamcrest.core.Is.is(org.hamcrest.Matchers.emptyArray()));
            assertThat(emptyArray, org.hamcrest.Matchers.is(org.hamcrest.Matchers.emptyArray()));
        }

        @Test
        void test_is_empty_with_reason() {
            assertThat("reason", emptyArray, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.emptyArray()));
            assertThat("reason", emptyArray, org.hamcrest.core.Is.is(org.hamcrest.Matchers.emptyArray()));
            assertThat("reason", emptyArray, org.hamcrest.Matchers.is(org.hamcrest.Matchers.emptyArray()));
        }
    }
}
