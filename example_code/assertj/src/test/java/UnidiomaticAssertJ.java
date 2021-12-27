import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.NotSerializableException;
import java.security.SecureRandom;
import java.util.List;
import java.util.regex.Pattern;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.regex.Pattern.compile;
import static org.assertj.core.api.Assertions.*;

@SuppressWarnings("ConstantConditions")
class UnidiomaticAssertJ {
    @Test
    public void shouldBeEqual() {
        var collection = List.of("");
        var collection1 = List.of("");
        var collection2 = List.of("");
        var variable = "";
        var a = true;
        Object x = getInteger();
        Object y = getInteger();
        var string = getString();

        assertThat(collection1.size()).isEqualTo(collection2.size()); // to assertThat(collection1).hasSameSizeAs(collection2)
        assertThat(collection1.size()).as("hasSameSizeAs").isEqualTo(collection2.size()); // to assertThat(collection1).as("hasSameSizeAs").hasSameSizeAs(collection2)
        assertThat(collection1.size()).describedAs("hasSameSizeAs").isEqualTo(collection2.size()); // to assertThat(collection1).as("hasSameSizeAs").hasSameSizeAs(collection2)

        assertThat(collection.size()).isEqualTo(0); // to assertThat(collection).isEmpty()
        assertThat(collection.size()).as("isEmpty").isEqualTo(0); // to assertThat(collection).as("isEmpty").isEmpty()
        assertThat(collection.size()).describedAs("isEmpty").isEqualTo(0); // to assertThat(collection).describedAs("isEmpty").isEmpty()

        assertThat(collection.size()).isNotEqualTo(0); // to assertThat(collection).isNotEmpty()
        assertThat(collection.size()).as("collectionSize").isNotEqualTo(0); // to assertThat(collection).as("collectionSize").isNotEmpty()
        assertThat(collection.size()).describedAs("collectionSize").isNotEqualTo(0); // to assertThat(collection).describedAs("collectionSize").isNotEmpty()

        assertThat(collection.size()).isEqualTo(1); // to assertThat(collection).hasSize(1)
        assertThat(collection.size()).as("hasSize 1").isEqualTo(1); // to assertThat(collection).as("hasSize 1").hasSize(1)
        assertThat(collection.size()).describedAs("hasSize 1").isEqualTo(1); // to assertThat(collection).describedAs("hasSize 1").hasSize(1)

        assertThat(collection1).hasSize(collection2.size()); // to assertThat(collection1).hasSameSizeAs(collection2)
        assertThat(collection1).as("hasSameSizeAs").hasSize(collection2.size()); // to assertThat(collection1).as("hasSameSizeAs").hasSameSizeAs(collection2)
        assertThat(collection1).describedAs("hasSameSizeAs").hasSize(collection2.size()); // to assertThat(collection1).as("hasSameSizeAs").hasSameSizeAs(collection2)

        assertThat(collection).hasSize(0); // to assertThat(collection).isEmpty()
        assertThat(collection).as("isEmpty").hasSize(0); // to assertThat(collection).as("isEmpty").isEmpty()
        assertThat(collection).describedAs("isEmpty").hasSize(0); // to assertThat(collection).describedAs("isEmpty").isEmpty()

        assertThat(collection.isEmpty()).isTrue(); // to assertThat(collection).isEmpty()
        assertThat(collection.isEmpty()).as("isEmpty-true").isTrue(); // to assertThat(collection).as("isEmpty-true").isEmpty()
        assertThat(collection.isEmpty()).describedAs("isEmpty-true").isTrue(); // to assertThat(collection).describedAs("isEmpty-true").isEmpty()

        assertThat(collection.isEmpty()).isFalse(); // to assertThat(collection).isNotEmpty()
        assertThat(collection.isEmpty()).as("isEmpty-false").isFalse(); // to assertThat(collection).as("isEmpty-false").isNotEmpty()
        assertThat(collection.isEmpty()).describedAs("isEmpty-false").isFalse(); // to assertThat(collection).as("isEmpty-false").isNotEmpty()

        assertThat(collection.size() > 7).isTrue(); // to assertThat(collection).hasSizeGreaterThan(7)
        assertThat(collection.size() > 7).as("collectionSize > 7").isTrue(); // to assertThat(collection).as("collectionSize > 7").hasSizeGreaterThan(7)
        assertThat(collection.size() > 7).describedAs("collectionSize > 7").isTrue(); // to assertThat(collection).describedAs("collectionSize > 7").hasSizeGreaterThan(7)

        assertThat(collection.size() < 7).isTrue(); // to assertThat(collection).hasSizeLessThan(7)
        assertThat(collection.size() < 7).as("collectionSize < 7").isTrue(); // to assertThat(collection).as("collectionSize > 7").hasSizeLessThan(7)
        assertThat(collection.size() < 7).describedAs("collectionSize < 7").isTrue(); // to assertThat(collection).describedAs("collectionSize > 7").hasSizeLessThan(7)

        assertThat(collection.size() <= 7).isTrue(); // to assertThat(collection).hasSizeLessThanOrEqualTo(7)
        assertThat(collection.size() <= 7).as("collectionSize > 7").isTrue(); // to assertThat(collection).as("collectionSize > 7").hasSizeLessThanOrEqualTo(7)
        assertThat(collection.size() <= 7).describedAs("collectionSize > 7").isTrue(); // to assertThat(collection).describedAs("collectionSize > 7").hasSizeLessThanOrEqualTo(7)

        assertThat(collection.size() >= 7).isTrue(); // to assertThat(collection).hasSizeGreaterThanOrEqualTo(7)
        assertThat(collection.size() >= 7).as("collectionSize > 7").isTrue(); // to assertThat(collection).as("collectionSize > 7").hasSizeGreaterThanOrEqualTo(7)
        assertThat(collection.size() >= 7).describedAs("collectionSize > 7").isTrue(); // to assertThat(collection).describedAs("collectionSize > 7").hasSizeGreaterThanOrEqualTo(7)

        assertThat(collection.size()).isGreaterThan(7); // to assertThat(collection).hasSizeGreaterThan(7)
        assertThat(collection.size()).as("message").isGreaterThan(7); // to assertThat(collection).as("message").hasSizeGreaterThan(7)
        assertThat(collection.size()).describedAs("message").isGreaterThan(7); // to assertThat(collection).describedAs("message").hasSizeGreaterThan(7)

        assertThat(collection.size()).isGreaterThanOrEqualTo(7); // to assertThat(collection).hasSizeGreaterThanOrEqualTo(7)
        assertThat(collection.size()).as("message").isGreaterThanOrEqualTo(7); // to assertThat(collection).as("message").hasSizeGreaterThanOrEqualTo(7)
        assertThat(collection.size()).describedAs("message").isGreaterThanOrEqualTo(7); // to assertThat(collection).describedAs("message").hasSizeGreaterThanOrEqualTo(7)

        assertThat(collection.size()).isLessThan(7); // to assertThat(collection).hasSizeLessThan(7)
        assertThat(collection.size()).as("message").isLessThan(7); // to assertThat(collection).as("message").hasSizeLessThan(7)
        assertThat(collection.size()).describedAs("message").isLessThan(7); // to assertThat(collection).describedAs("message").hasSizeLessThan(7)

        assertThat(collection.size()).isLessThanOrEqualTo(7); // to assertThat(collection).hasSizeLessThanOrEqualTo(7)
        assertThat(collection.size()).as("message").isLessThanOrEqualTo(7); // to assertThat(collection).as("message").hasSizeLessThanOrEqualTo(7)
        assertThat(collection.size()).describedAs("message").isLessThanOrEqualTo(7); // to assertThat(collection).describedAs("message").hasSizeLessThanOrEqualTo(7)

        assertThat(collection).hasSizeGreaterThan(0); // to assertThat(collection).isNotEmpty()
        assertThat(collection).as("message").hasSizeGreaterThan(0); // to assertThat(collection).as("message").isNotEmpty()
        assertThat(collection).describedAs("message").hasSizeGreaterThan(0); // to assertThat(collection).described("message").isNotEmpty()

        assertThat(collection).hasSizeGreaterThanOrEqualTo(1); // to assertThat(collection).isNotEmpty()
        assertThat(collection).as("message").hasSizeGreaterThanOrEqualTo(1); // to assertThat(collection).as("message").isNotEmpty()
        assertThat(collection).describedAs("message").hasSizeGreaterThanOrEqualTo(1); // to assertThat(collection).describedAs("message").isNotEmpty()

        assertThat(collection).hasSizeLessThan(1); // to assertThat(collection).isEmpty()
        assertThat(collection).as("message").hasSizeLessThan(1); // to assertThat(collection).as("message").isEmpty()
        assertThat(collection).describedAs("message").hasSizeLessThan(1); // to assertThat(collection).describedAs("message").isEmpty()

        assertThat(collection).hasSizeLessThanOrEqualTo(0); // to assertThat(collection).isEmpty()
        assertThat(collection).as("message").hasSizeLessThanOrEqualTo(0); // to assertThat(collection).as("message").isEmpty()
        assertThat(collection).describedAs("message").hasSizeLessThanOrEqualTo(0); // to assertThat(collection).describedAs("message").isEmpty()

        assertThat(variable).as("").isEqualTo("something"); // to assertThat(variable).isEqualTo(something)
        assertThat(variable).describedAs("").isEqualTo("something"); // to assertThat(variable).isEqualTo(something)

        assertThat(variable).isEqualTo(null); // to assertThat(variable).isNull()
        assertThat(variable).as("description").isEqualTo(null); // to assertThat(variable).as("description").isNull()
        assertThat(variable).describedAs("description").isEqualTo(null); // to assertThat(variable).describedAs("description").isNull()

        assertThat(variable).isNotEqualTo(null); // to assertThat(collection).isNotNull()
        assertThat(variable).as("description").isNotEqualTo(null); // to assertThat(collection).as("description").isNotNull()
        assertThat(variable).describedAs("description").isNotEqualTo(null); // to assertThat(collection).describedAs("description").isNotNull()

        assertThat(a).isEqualTo(true); // to assertThat(a).isTrue()
        assertThat(a).isEqualTo(TRUE); // to assertThat(a).isTrue()
        assertThat(a).isEqualTo(Boolean.TRUE); // to assertThat(a).isTrue()
        assertThat(a).as("description").isEqualTo(true); // to assertThat(a).as("message").isTrue()
        assertThat(a).describedAs("description").isEqualTo(true); // to assertThat(a).describedAs("message").isTrue()

        assertThat(a).isEqualTo(false); // to assertThat(a).isFalse()
        assertThat(a).isEqualTo(FALSE); // to assertThat(a).isFalse()
        assertThat(a).isEqualTo(Boolean.FALSE); // to assertThat(a).isFalse()
        assertThat(a).as("description").isEqualTo(false); // to assertThat(a).as("description").isFalse()
        assertThat(a).describedAs("description").isEqualTo(false); // to assertThat(a).describedAs("description").isFalse()

        assertThat(x == y).isTrue(); // to assertThat(x).isEqualTo(y) ?
        assertThat(x == y).as("description").isTrue(); // to assertThat(x).as("description").isEqualTo(y) ?
        assertThat(x == y).describedAs("description").isTrue(); // to assertThat(x).describedAs("description").isEqualTo(y) ?
        assertThat(x.equals(y)).isTrue(); // to assertThat(x).isEqualTo(y) ?
        assertThat(x.equals(y)).as("description").isTrue(); // to assertThat(x).as("description").isEqualTo(y) ?
        assertThat(x.equals(y)).describedAs("description").isTrue(); // to assertThat(x).describedAs("description").isEqualTo(y) ?

        assertThat(x == y).isFalse(); // to assertThat(x).isNotEqualTo(y) ?
        assertThat(x == y).as("description").isFalse(); // to assertThat(x).as("description").isNotEqualTo(y) ?
        assertThat(x == y).describedAs("description").isFalse(); // to assertThat(x).describedAs("description").isNotEqualTo(y) ?
        assertThat(x.equals(y)).isFalse(); // to assertThat(x).isNotEqualTo(y) ?
        assertThat(x.equals(y)).as("description").isFalse(); // to assertThat(x).as("description").isNotEqualTo(y) ?
        assertThat(x.equals(y)).describedAs("description").isFalse(); // to assertThat(x).describedAs("description").isNotEqualTo(y) ?

        assertThat(x != y).isTrue(); // to assertThat(x).isNotEqualTo(y) ?
        assertThat(x != y).as("description").isTrue(); // to assertThat(x).as("description").isNotEqualTo(y) ?
        assertThat(x != y).describedAs("description").isTrue(); // to assertThat(x).describedAs("description").isNotEqualTo(y) ?
        assertThat(!x.equals(y)).isTrue(); // to assertThat(x).isNotEqualTo(y) ?
        assertThat(!x.equals(y)).as("description").isTrue(); // to assertThat(x).as("description").isNotEqualTo(y) ?
        assertThat(!x.equals(y)).describedAs("description").isTrue(); // to assertThat(x).describedAs("description").isNotEqualTo(y) ?

        // I think these are a bit too convoluted to worry about for now:
//        assertThat(x != y).isFalse(); // to assertThat(x).isEqualTo(y) ?
//        assertThat(x != y).as("description").isFalse(); // to assertThat(x).as("description").isEqualTo(y) ?
//        assertThat(x != y).describedAs("description").isFalse(); // to assertThat(x).describedAs("description").isEqualTo(y) ?
//        assertThat(!x.equals(y)).isFalse(); // to assertThat(x).isEqualTo(y) ?
//        assertThat(!x.equals(y)).as("description").isFalse(); // to assertThat(x).as("description").isEqualTo(y) ?
//        assertThat(!x.equals(y)).describedAs("description").isFalse(); // to assertThat(x).describedAs("description").isEqualTo(y) ?

        assertThat(string.contains("abc")).isTrue(); // to assertThat(string).contains("abc")
        assertThat(string.contains("abc")).as("description").isTrue(); // to assertThat(string).as("description").contains("abc")
        assertThat(string.contains("abc")).describedAs("description").isTrue(); // to assertThat(string).describedAs("description").contains("abc")

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(this::getInteger);
        assertThatExceptionOfType(IllegalStateException.class).isThrownBy(this::getInteger);
        assertThatExceptionOfType(IOException.class).isThrownBy(this::getInteger);
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(this::getInteger);
        assertThatExceptionOfType(NotSerializableException.class).isThrownBy(this::getInteger);

        // should offer migrations to these:
        assertThatIllegalArgumentException().isThrownBy(this::getInteger);
        assertThatIllegalStateException().isThrownBy(this::getInteger);
        assertThatIOException().isThrownBy(this::getInteger);
        assertThatNullPointerException().isThrownBy(this::getInteger);
        // no migration for subclass of IOException
        assertThatExceptionOfType(NotSerializableException.class).isThrownBy(this::getInteger);

    }

    @Test
    void idiomaticPatternAssertions() {
        // should match those:
        assertThat("Hello World!").matches(Pattern.compile("([A-Za-z]+ ([A-Za-z]+!))")); // to assertThat("Hello World!").matches("([A-Za-z]+ ([A-Za-z]+!))")
        assertThat("Hello World!").matches(compile("([A-Za-z]+ ([A-Za-z]+!))")); // to assertThat("Hello World!").matches("([A-Za-z]+ ([A-Za-z]+!))")
        assertThat("Hello World!").as("reason").matches(compile("([A-Za-z]+ ([A-Za-z]+!))")); // to assertThat("Hello World!").as("reason").matches("([A-Za-z]+ ([A-Za-z]+!))")
        assertThat("Hello World!").describedAs("reason").matches(compile("([A-Za-z]+ ([A-Za-z]+!))")); // to assertThat("Hello World!").describedAs("reason").matches("([A-Za-z]+ ([A-Za-z]+!))")

        // should not match those:
        assertThat("Hello World!").matches("([A-Za-z]+ ([A-Za-z]+!))");
        assertThat("Hello World!").as("reason").matches("([A-Za-z]+ ([A-Za-z]+!))");
    }

    @Test
    public void migrateToAssertThatCode() {
        var myDescription = "";

        assertThatThrownBy(this::getInteger).as(myDescription).isInstanceOf(RuntimeException.class);


        // should migrate to:
        assertThatCode(this::getInteger).as(myDescription).isInstanceOf(RuntimeException.class);
    }

    private Integer getInteger() {
        return new SecureRandom().nextInt();
    }
    private String getString() {
        return new SecureRandom().nextInt() + "";
    }
}
