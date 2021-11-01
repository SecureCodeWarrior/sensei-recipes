package junit;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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
}
