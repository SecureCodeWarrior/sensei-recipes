package junit;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SuppressWarnings("JUnit5AssertionsConverter")
public class JUnit5Assertions {

    private final Object notNull = new Object();
    private final Object nullObject = null;
    private final Object a = new Object();
    private final Object actualA = a;
    private final Object b = new Object();
    private final Object[] actual = List.of().toArray();
    private final Object[] expected = List.of().toArray();

    @Test
    void assertArrayEquals() {
        // Should change to: assertThat(actual).isEqualTo(expected);
        Assert.assertArrayEquals(expected, actual);
        Assertions.assertArrayEquals(expected, actual);

        // Should change to: assertThat(actual).as("message").isEqualTo(expected);
        Assert.assertArrayEquals("message", expected, actual);
        Assertions.assertArrayEquals(expected, actual, "message");
    }

    @Test
    void assertEquals() {
        // Should change to: assertThat(3).isEqualTo(3);
        TestCase.assertEquals(3, 3);
        Assert.assertEquals(3, 3);
        Assertions.assertEquals(3, 3);

        // Should change to: assertThat(3).as("message").isEqualTo(3);
        TestCase.assertEquals("message", 3, 3);
        Assert.assertEquals("message", 3, 3);
        Assertions.assertEquals(3, 3, "message");
    }

    @Test
    void assertFalse() {
        // Should change to: assertThat(false).isFalse();
        TestCase.assertFalse(false);
        Assert.assertFalse(false);
        Assertions.assertFalse(false);

        // Should change to: assertThat(false).as("message").isFalse();
        TestCase.assertFalse("message", false);
        Assert.assertFalse("message", false);
        Assertions.assertFalse(false, "message");
    }

    @Test
    void assertTrue() {
        // Should change to: assertThat(true).isTrue();
        TestCase.assertTrue(true);
        Assert.assertTrue(true);
        Assertions.assertTrue(true);

        // Should change to: assertThat(true).as("message").isTrue();
        TestCase.assertTrue("message", true);
        Assert.assertTrue("message", true);
        Assertions.assertTrue(true, "message");
    }

    @Test
    void assertNull() {
        // Should change to: assertThat(nullObject).isNull();
        TestCase.assertNull(nullObject);
        Assert.assertNull(nullObject);
        Assertions.assertNull(nullObject);

        // Should change to: assertThat(nullObject).as("message").isNull();
        TestCase.assertNull("message", nullObject);
        Assert.assertNull("message", nullObject);
        Assertions.assertNull(nullObject, "message");
    }

    @Test
    void assertNotNull() {
        // Should change to: assertThat(notNull).isNotNull();
        TestCase.assertNotNull(notNull);
        Assert.assertNotNull(notNull);
        Assertions.assertNotNull(notNull);

        // Should change to: assertThat(notNull).as("message").isNotNull();
        TestCase.assertNotNull("message", notNull);
        Assert.assertNotNull("message", notNull);
        Assertions.assertNotNull(notNull, "message");
    }

    @Test
    void assertSame() {
        // Should change to: assertThat(actualA).isSameAs(a);
        TestCase.assertSame(a, actualA);
        Assert.assertSame(a, actualA);
        Assertions.assertSame(a, actualA);

        // Should change to: assertThat(actualA).as("message").isSameAs(a);
        TestCase.assertSame("message", a, actualA);
        Assert.assertSame("message", a, actualA);
        Assertions.assertSame(a, actualA, "message");
    }

    @Test
    void assertNotSame() {
        // Should change to: assertThat(b).isNotSameAs(a);
        TestCase.assertNotSame(a, b);
        Assert.assertNotSame(a, b);
        Assertions.assertNotSame(a, b);

        // Should change to: assertThat(b).as("message").isNotSameAs(a);
        TestCase.assertNotSame("message", a, b);
        Assert.assertNotSame("message", a, b);
        Assertions.assertNotSame(a, b, "message");
    }

    @Test
    void assertThrows() {
        // Note: each of the JUnit methods has overloads to support fail messages, either as String or as Supplier<String>.
        // Our migrations should handle both cases, even if they aren't listed here.

        // JUnit assertions like these:
        Assert.assertThrows(Exception.class, () -> {
            throw new Exception();
        });
        Assertions.assertThrows(Exception.class, () -> {
            throw new Exception();
        });

        // should change to either this:
        assertThatThrownBy(() -> {
            throw new Exception();
        }).isInstanceOf(Exception.class);

        // or this:
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> {
                    throw new Exception();
                });

        // or this:
        assertThatCode(() -> {
            throw new Exception();
        }).isInstanceOf(Exception.class);


        // JUnit 4 assertions like these:
        Assert.assertThrows("message", Exception.class, () -> {
            throw new Exception();
        });
        // Or JUnit 5 assertions like these:
        Assertions.assertThrows(Exception.class, () -> {
            throw new Exception();
        }, "message");

        // should change to either this:
        assertThatCode(() -> {
            throw new Exception();
        })
                .as("message")
                .isInstanceOf(Exception.class);

        // or this:
        assertThatExceptionOfType(Exception.class)
                .as("message")
                .isThrownBy(() -> {
                    throw new Exception();
                });

        // But this is slightly wrong: message is not used if nothing is thrown
        assertThatThrownBy(() -> {
            throw new Exception();
        })
                .as("message")
                .isInstanceOf(Exception.class);


        // JUnit assertions like this:
        Assertions.assertThrows(Exception.class, () -> {
            throw new Exception();
        }, () -> "message");

        // should change to either this:
        assertThatCode(() -> {
            throw new Exception();
        })
                .as(() -> "message")
                .isInstanceOf(Exception.class);

        // or this:
        assertThatExceptionOfType(Exception.class)
                .as(() -> "message")
                .isThrownBy(() -> {
                    throw new Exception();
                });
        // But this is slightly wrong: message is not used if nothing is thrown
        assertThatThrownBy(() -> {
            throw new Exception();
        })
                .as(() -> "message")
                .isInstanceOf(Exception.class);

    }

}
