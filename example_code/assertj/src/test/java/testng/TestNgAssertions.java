package testng;

import org.testng.annotations.Test;

import java.util.List;

public class TestNgAssertions {

    private final Object notNull = new Object();
    private final Object nullObject = null;
    private final Object a = new Object();
    private final Object actualA = a;
    private final Object b = new Object();
    private final Object[] actual = List.of().toArray();
    private final Object[] expected = List.of().toArray();

    @Test
    void ng_assertArrayEquals() {
        // Should change to: assertThat(actual).isEqualTo(expected);
        org.testng.Assert.assertEquals(actual, expected);

        // Should change to: assertThat(actual).as("message").isEqualTo(expected);
        org.testng.Assert.assertEquals(actual, expected, "message");
    }

    @Test
    void ng_assertEquals() {
        // Should change to: assertThat(2 + 1).isEqualTo(3);
        org.testng.Assert.assertEquals(2 + 1, 3);

        // Should change to: assertThat(2 + 1).as("message").isEqualTo(3);
        org.testng.Assert.assertEquals(2 + 1, 3, "message");
    }

    @Test
    void ng_assertNotEquals() {
        // Should change to: assertThat(3).isNotEqualTo(4);
        org.testng.Assert.assertNotEquals(3, 4);

        // Should change to: assertThat(3).as("message").isNotEqualTo(4);
        org.testng.Assert.assertNotEquals(3, 4, "message");
    }

    @Test
    void ng_assertFalse() {
        // Should change to: assertThat(false).isFalse();
        org.testng.Assert.assertFalse(false);

        // Should change to: assertThat(false).as("message").isFalse();
        org.testng.Assert.assertFalse(false, "message");
    }

    @Test
    void ng_assertTrue() {
        // Should change to: assertThat(true).isTrue();
        org.testng.Assert.assertTrue(true);

        // Should change to: assertThat(true).as("message").isTrue();
        org.testng.Assert.assertTrue(true, "message");
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void ng_assertNull() {
        // Should change to: assertThat(nullObject).isNull();
        org.testng.Assert.assertNull(nullObject);

        // Should change to: assertThat(nullObject).as("message").isNull();
        org.testng.Assert.assertNull(nullObject, "message");
    }

    @Test
    void ng_assertNotNull() {
        // Should change to: assertThat(notNull).isNotNull();
        org.testng.Assert.assertNotNull(notNull);

        // Should change to: assertThat(notNull).as("message").isNotNull();
        org.testng.Assert.assertNotNull(notNull, "message");
    }

    @Test
    void ng_assertSame() {
        // Should change to: assertThat(actualA).isSameAs(a);
        org.testng.Assert.assertSame(actualA, a);

        // Should change to: assertThat(actualA).as("message").isSameAs(a);
        org.testng.Assert.assertSame(actualA, a, "message");
    }

    @Test
    void ng_assertNotSame() {
        // Should change to: assertThat(b).isNotSameAs(a);
        org.testng.Assert.assertNotSame(b, a);

        // Should change to: assertThat(b).as("message").isNotSameAs(a);
        org.testng.Assert.assertNotSame(b, a, "message");
    }

    @Test
    void ng_assertThrows() {
        // TestNg assertions like these:
        org.testng.Assert.assertThrows(Exception.class, () -> {
            throw new Exception();
        });

        // should change to either this:
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> {
            throw new Exception();
        }).isInstanceOf(Exception.class);

        // or this:
        org.assertj.core.api.Assertions.assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> {
                    throw new Exception();
                });

        // or this:
        org.assertj.core.api.Assertions.assertThatCode(() -> {
            throw new Exception();
        }).isInstanceOf(Exception.class);
    }

    @Test
    void ng_testFail() {
        // should change to org.assertj.core.api.Assertions.fail("");
        org.testng.Assert.fail();

        // should change to org.assertj.core.api.Assertions.fail("message");
        org.testng.Assert.fail("message");
    }
}
