package hamcrest;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class HamcrestCollectionSizeAssertions {
    @Nested
    class CollectionSize {
        private final Collection<String> collection = List.of("Hello", "World");

        @Test
        void test_hasSize() {
            assertThat(collection, org.hamcrest.Matchers.hasSize(2));
            assertThat(collection, org.hamcrest.collection.IsCollectionWithSize.hasSize(2));
        }

        @Test
        void test_has_size_with_reason() {
            assertThat("reason", collection, org.hamcrest.Matchers.hasSize(2));
            assertThat("reason", collection, org.hamcrest.collection.IsCollectionWithSize.hasSize(2));
        }

        @Test
        void test_is_has_size() {
            assertThat(collection, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.hasSize(2)));
            assertThat(collection, org.hamcrest.CoreMatchers.is(org.hamcrest.collection.IsCollectionWithSize.hasSize(2)));

            assertThat(collection, org.hamcrest.core.Is.is(org.hamcrest.Matchers.hasSize(2)));
            assertThat(collection, org.hamcrest.core.Is.is(org.hamcrest.collection.IsCollectionWithSize.hasSize(2)));

            assertThat(collection, org.hamcrest.Matchers.is(org.hamcrest.Matchers.hasSize(2)));
            assertThat(collection, org.hamcrest.Matchers.is(org.hamcrest.collection.IsCollectionWithSize.hasSize(2)));
        }

        @Test
        void test_is_has_size_with_reason() {
            assertThat("reason", collection, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.hasSize(2)));
            assertThat("reason", collection, org.hamcrest.CoreMatchers.is(org.hamcrest.collection.IsCollectionWithSize.hasSize(2)));

            assertThat("reason", collection, org.hamcrest.core.Is.is(org.hamcrest.Matchers.hasSize(2)));
            assertThat("reason", collection, org.hamcrest.core.Is.is(org.hamcrest.collection.IsCollectionWithSize.hasSize(2)));

            assertThat("reason", collection, org.hamcrest.Matchers.is(org.hamcrest.Matchers.hasSize(2)));
            assertThat("reason", collection, org.hamcrest.Matchers.is(org.hamcrest.collection.IsCollectionWithSize.hasSize(2)));
        }
    }

    @Nested
    class IterableSize {
        private final Iterable<String> iterable = List.of("Hello", "World");

        @Test
        void test_with_size() {
            assertThat(iterable, org.hamcrest.Matchers.iterableWithSize(2));
            assertThat(iterable, org.hamcrest.collection.IsIterableWithSize.iterableWithSize(2));
        }

        @Test
        void test_with_size_with_reason() {
            assertThat("reason", iterable, org.hamcrest.Matchers.iterableWithSize(2));
            assertThat("reason", iterable, org.hamcrest.collection.IsIterableWithSize.iterableWithSize(2));
        }

        @Test
        void test_is_with_size() {
            assertThat(iterable, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.iterableWithSize(2)));
            assertThat(iterable, org.hamcrest.CoreMatchers.is(org.hamcrest.collection.IsIterableWithSize.iterableWithSize(2)));

            assertThat(iterable, org.hamcrest.core.Is.is(org.hamcrest.Matchers.iterableWithSize(2)));
            assertThat(iterable, org.hamcrest.core.Is.is(org.hamcrest.collection.IsIterableWithSize.iterableWithSize(2)));

            assertThat(iterable, org.hamcrest.Matchers.is(org.hamcrest.Matchers.iterableWithSize(2)));
            assertThat(iterable, org.hamcrest.Matchers.is(org.hamcrest.collection.IsIterableWithSize.iterableWithSize(2)));
        }

        @Test
        void test_is_with_size_with_reason() {
            assertThat("reason", iterable, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.iterableWithSize(2)));
            assertThat("reason", iterable, org.hamcrest.CoreMatchers.is(org.hamcrest.collection.IsIterableWithSize.iterableWithSize(2)));

            assertThat("reason", iterable, org.hamcrest.core.Is.is(org.hamcrest.Matchers.iterableWithSize(2)));
            assertThat("reason", iterable, org.hamcrest.core.Is.is(org.hamcrest.collection.IsIterableWithSize.iterableWithSize(2)));

            assertThat("reason", iterable, org.hamcrest.Matchers.is(org.hamcrest.Matchers.iterableWithSize(2)));
            assertThat("reason", iterable, org.hamcrest.Matchers.is(org.hamcrest.collection.IsIterableWithSize.iterableWithSize(2)));
        }
    }

    @Nested
    class ArraySize {
        private final String[] array = new String[]{"Hello", "World"};

        @Test
        void test_with_size() {
            assertThat(array, org.hamcrest.Matchers.arrayWithSize(2));
            assertThat(array, org.hamcrest.collection.IsArrayWithSize.arrayWithSize(2));
        }

        @Test
        void test_with_size_with_reason() {
            assertThat("reason", array, org.hamcrest.Matchers.arrayWithSize(2));
            assertThat("reason", array, org.hamcrest.collection.IsArrayWithSize.arrayWithSize(2));
        }

        @Test
        void test_is_with_size() {
            assertThat(array, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.arrayWithSize(2)));
            assertThat(array, org.hamcrest.CoreMatchers.is(org.hamcrest.collection.IsArrayWithSize.arrayWithSize(2)));

            assertThat(array, org.hamcrest.core.Is.is(org.hamcrest.Matchers.arrayWithSize(2)));
            assertThat(array, org.hamcrest.core.Is.is(org.hamcrest.collection.IsArrayWithSize.arrayWithSize(2)));

            assertThat(array, org.hamcrest.Matchers.is(org.hamcrest.Matchers.arrayWithSize(2)));
            assertThat(array, org.hamcrest.Matchers.is(org.hamcrest.collection.IsArrayWithSize.arrayWithSize(2)));
        }

        @Test
        void test_is_with_size_with_reason() {
            assertThat("reason", array, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.arrayWithSize(2)));
            assertThat("reason", array, org.hamcrest.CoreMatchers.is(org.hamcrest.collection.IsArrayWithSize.arrayWithSize(2)));

            assertThat("reason", array, org.hamcrest.core.Is.is(org.hamcrest.Matchers.arrayWithSize(2)));
            assertThat("reason", array, org.hamcrest.core.Is.is(org.hamcrest.collection.IsArrayWithSize.arrayWithSize(2)));

            assertThat("reason", array, org.hamcrest.Matchers.is(org.hamcrest.Matchers.arrayWithSize(2)));
            assertThat("reason", array, org.hamcrest.Matchers.is(org.hamcrest.collection.IsArrayWithSize.arrayWithSize(2)));
        }
    }

    @Nested
    class MapSize {
        Map<String, Object> map = Map.of("Hello", "World");

        @Test
        void test_a_map_with_size() {
            assertThat(map, org.hamcrest.Matchers.aMapWithSize(1));
            assertThat(map, org.hamcrest.collection.IsMapWithSize.aMapWithSize(1));
        }

        @Test
        void test_a_map_with_size_with_reason() {
            assertThat("reason", map, org.hamcrest.Matchers.aMapWithSize(1));
            assertThat("reason", map, org.hamcrest.collection.IsMapWithSize.aMapWithSize(1));
        }

        @Test
        void test_is_a_map_with_size() {
            assertThat(map, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.aMapWithSize(1)));
            assertThat(map, org.hamcrest.CoreMatchers.is(org.hamcrest.collection.IsMapWithSize.aMapWithSize(1)));

            assertThat(map, org.hamcrest.core.Is.is(org.hamcrest.Matchers.aMapWithSize(1)));
            assertThat(map, org.hamcrest.core.Is.is(org.hamcrest.collection.IsMapWithSize.aMapWithSize(1)));

            assertThat(map, org.hamcrest.Matchers.is(org.hamcrest.Matchers.aMapWithSize(1)));
            assertThat(map, org.hamcrest.Matchers.is(org.hamcrest.collection.IsMapWithSize.aMapWithSize(1)));
        }

        @Test
        void test_is_a_map_with_size_with_reason() {
            assertThat("reason", map, org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.aMapWithSize(1)));
            assertThat("reason", map, org.hamcrest.CoreMatchers.is(org.hamcrest.collection.IsMapWithSize.aMapWithSize(1)));

            assertThat("reason", map, org.hamcrest.core.Is.is(org.hamcrest.Matchers.aMapWithSize(1)));
            assertThat("reason", map, org.hamcrest.core.Is.is(org.hamcrest.collection.IsMapWithSize.aMapWithSize(1)));

            assertThat("reason", map, org.hamcrest.Matchers.is(org.hamcrest.Matchers.aMapWithSize(1)));
            assertThat("reason", map, org.hamcrest.Matchers.is(org.hamcrest.collection.IsMapWithSize.aMapWithSize(1)));
        }
    }
}
