import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.NotSerializableException;
import java.security.SecureRandom;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

// Please don't add more static imports to this file. It exists so that we
// can verify recipes add their own static imports when required.
@SuppressWarnings("ConstantConditions")
class UnidiomaticNonStaticAssertJ {
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

        Assertions.assertThat(collection1.size()).isEqualTo(collection2.size()); // to assertThat(collection1).hasSameSizeAs(collection2)
        Assertions.assertThat(collection1.size()).as("hasSameSizeAs").isEqualTo(collection2.size()); // to assertThat(collection1).as("hasSameSizeAs").hasSameSizeAs(collection2)
        Assertions.assertThat(collection1.size()).describedAs("hasSameSizeAs").isEqualTo(collection2.size()); // to assertThat(collection1).as("hasSameSizeAs").hasSameSizeAs(collection2)

        Assertions.assertThat(collection.size()).isEqualTo(0); // to assertThat(collection).isEmpty()
        Assertions.assertThat(collection.size()).as("isEmpty").isEqualTo(0); // to assertThat(collection).as("isEmpty").isEmpty()
        Assertions.assertThat(collection.size()).describedAs("isEmpty").isEqualTo(0); // to assertThat(collection).describedAs("isEmpty").isEmpty()

        Assertions.assertThat(collection.size()).isNotEqualTo(0); // to assertThat(collection).isNotEmpty()
        Assertions.assertThat(collection.size()).as("collectionSize").isNotEqualTo(0); // to assertThat(collection).as("collectionSize").isNotEmpty()
        Assertions.assertThat(collection.size()).describedAs("collectionSize").isNotEqualTo(0); // to assertThat(collection).describedAs("collectionSize").isNotEmpty()

        Assertions.assertThat(collection.size()).isEqualTo(1); // to assertThat(collection).hasSize(1)
        Assertions.assertThat(collection.size()).as("hasSize 1").isEqualTo(1); // to assertThat(collection).as("hasSize 1").hasSize(1)
        Assertions.assertThat(collection.size()).describedAs("hasSize 1").isEqualTo(1); // to assertThat(collection).describedAs("hasSize 1").hasSize(1)

        Assertions.assertThat(collection1).hasSize(collection2.size()); // to assertThat(collection1).hasSameSizeAs(collection2)
        Assertions.assertThat(collection1).as("hasSameSizeAs").hasSize(collection2.size()); // to assertThat(collection1).as("hasSameSizeAs").hasSameSizeAs(collection2)
        Assertions.assertThat(collection1).describedAs("hasSameSizeAs").hasSize(collection2.size()); // to assertThat(collection1).as("hasSameSizeAs").hasSameSizeAs(collection2)

        Assertions.assertThat(collection).hasSize(0); // to assertThat(collection).isEmpty()
        Assertions.assertThat(collection).as("isEmpty").hasSize(0); // to assertThat(collection).as("isEmpty").isEmpty()
        Assertions.assertThat(collection).describedAs("isEmpty").hasSize(0); // to assertThat(collection).describedAs("isEmpty").isEmpty()

        Assertions.assertThat(collection.isEmpty()).isTrue(); // to assertThat(collection).isEmpty()
        Assertions.assertThat(collection.isEmpty()).as("isEmpty-true").isTrue(); // to assertThat(collection).as("isEmpty-true").isEmpty()
        Assertions.assertThat(collection.isEmpty()).describedAs("isEmpty-true").isTrue(); // to assertThat(collection).describedAs("isEmpty-true").isEmpty()

        Assertions.assertThat(collection.isEmpty()).isFalse(); // to assertThat(collection).isNotEmpty()
        Assertions.assertThat(collection.isEmpty()).as("isEmpty-false").isFalse(); // to assertThat(collection).as("isEmpty-false").isNotEmpty()
        Assertions.assertThat(collection.isEmpty()).describedAs("isEmpty-false").isFalse(); // to assertThat(collection).as("isEmpty-false").isNotEmpty()

        Assertions.assertThat(collection.size() > 7).isTrue(); // to assertThat(collection).hasSizeGreaterThan(7)
        Assertions.assertThat(collection.size() > 7).as("collectionSize > 7").isTrue(); // to assertThat(collection).as("collectionSize > 7").hasSizeGreaterThan(7)
        Assertions.assertThat(collection.size() > 7).describedAs("collectionSize > 7").isTrue(); // to assertThat(collection).describedAs("collectionSize > 7").hasSizeGreaterThan(7)

        Assertions.assertThat(collection.size() < 7).isTrue(); // to assertThat(collection).hasSizeLessThan(7)
        Assertions.assertThat(collection.size() < 7).as("collectionSize < 7").isTrue(); // to assertThat(collection).as("collectionSize > 7").hasSizeLessThan(7)
        Assertions.assertThat(collection.size() < 7).describedAs("collectionSize < 7").isTrue(); // to assertThat(collection).describedAs("collectionSize > 7").hasSizeLessThan(7)

        Assertions.assertThat(collection.size() <= 7).isTrue(); // to assertThat(collection).hasSizeLessThanOrEqualTo(7)
        Assertions.assertThat(collection.size() <= 7).as("collectionSize > 7").isTrue(); // to assertThat(collection).as("collectionSize > 7").hasSizeLessThanOrEqualTo(7)
        Assertions.assertThat(collection.size() <= 7).describedAs("collectionSize > 7").isTrue(); // to assertThat(collection).describedAs("collectionSize > 7").hasSizeLessThanOrEqualTo(7)

        Assertions.assertThat(collection.size() >= 7).isTrue(); // to assertThat(collection).hasSizeGreaterThanOrEqualTo(7)
        Assertions.assertThat(collection.size() >= 7).as("collectionSize > 7").isTrue(); // to assertThat(collection).as("collectionSize > 7").hasSizeGreaterThanOrEqualTo(7)
        Assertions.assertThat(collection.size() >= 7).describedAs("collectionSize > 7").isTrue(); // to assertThat(collection).describedAs("collectionSize > 7").hasSizeGreaterThanOrEqualTo(7)

        Assertions.assertThat(collection.size()).isGreaterThan(7); // to assertThat(collection).hasSizeGreaterThan(7)
        Assertions.assertThat(collection.size()).as("message").isGreaterThan(7); // to assertThat(collection).as("message").hasSizeGreaterThan(7)
        Assertions.assertThat(collection.size()).describedAs("message").isGreaterThan(7); // to assertThat(collection).describedAs("message").hasSizeGreaterThan(7)

        Assertions.assertThat(collection.size()).isGreaterThanOrEqualTo(7); // to assertThat(collection).hasSizeGreaterThanOrEqualTo(7)
        Assertions.assertThat(collection.size()).as("message").isGreaterThanOrEqualTo(7); // to assertThat(collection).as("message").hasSizeGreaterThanOrEqualTo(7)
        Assertions.assertThat(collection.size()).describedAs("message").isGreaterThanOrEqualTo(7); // to assertThat(collection).describedAs("message").hasSizeGreaterThanOrEqualTo(7)

        Assertions.assertThat(collection.size()).isLessThan(7); // to assertThat(collection).hasSizeLessThan(7)
        Assertions.assertThat(collection.size()).as("message").isLessThan(7); // to assertThat(collection).as("message").hasSizeLessThan(7)
        Assertions.assertThat(collection.size()).describedAs("message").isLessThan(7); // to assertThat(collection).describedAs("message").hasSizeLessThan(7)

        Assertions.assertThat(collection.size()).isLessThanOrEqualTo(7); // to assertThat(collection).hasSizeLessThanOrEqualTo(7)
        Assertions.assertThat(collection.size()).as("message").isLessThanOrEqualTo(7); // to assertThat(collection).as("message").hasSizeLessThanOrEqualTo(7)
        Assertions.assertThat(collection.size()).describedAs("message").isLessThanOrEqualTo(7); // to assertThat(collection).describedAs("message").hasSizeLessThanOrEqualTo(7)

        Assertions.assertThat(collection).hasSizeGreaterThan(0); // to assertThat(collection).isNotEmpty()
        Assertions.assertThat(collection).as("message").hasSizeGreaterThan(0); // to assertThat(collection).as("message").isNotEmpty()
        Assertions.assertThat(collection).describedAs("message").hasSizeGreaterThan(0); // to assertThat(collection).described("message").isNotEmpty()

        Assertions.assertThat(collection).hasSizeGreaterThanOrEqualTo(1); // to assertThat(collection).isNotEmpty()
        Assertions.assertThat(collection).as("message").hasSizeGreaterThanOrEqualTo(1); // to assertThat(collection).as("message").isNotEmpty()
        Assertions.assertThat(collection).describedAs("message").hasSizeGreaterThanOrEqualTo(1); // to assertThat(collection).describedAs("message").isNotEmpty()

        Assertions.assertThat(collection).hasSizeLessThan(1); // to assertThat(collection).isEmpty()
        Assertions.assertThat(collection).as("message").hasSizeLessThan(1); // to assertThat(collection).as("message").isEmpty()
        Assertions.assertThat(collection).describedAs("message").hasSizeLessThan(1); // to assertThat(collection).describedAs("message").isEmpty()

        Assertions.assertThat(collection).hasSizeLessThanOrEqualTo(0); // to assertThat(collection).isEmpty()
        Assertions.assertThat(collection).as("message").hasSizeLessThanOrEqualTo(0); // to assertThat(collection).as("message").isEmpty()
        Assertions.assertThat(collection).describedAs("message").hasSizeLessThanOrEqualTo(0); // to assertThat(collection).describedAs("message").isEmpty()

        Assertions.assertThat(variable).as("").isEqualTo("something"); // to assertThat(variable).isEqualTo(something)
        Assertions.assertThat(variable).describedAs("").isEqualTo("something"); // to assertThat(variable).isEqualTo(something)

        Assertions.assertThat(variable).isEqualTo(null); // to assertThat(variable).isNull()
        Assertions.assertThat(variable).as("description").isEqualTo(null); // to assertThat(variable).as("description").isNull()
        Assertions.assertThat(variable).describedAs("description").isEqualTo(null); // to assertThat(variable).describedAs("description").isNull()

        Assertions.assertThat(variable).isNotEqualTo(null); // to assertThat(collection).isNotNull()
        Assertions.assertThat(variable).as("description").isNotEqualTo(null); // to assertThat(collection).as("description").isNotNull()
        Assertions.assertThat(variable).describedAs("description").isNotEqualTo(null); // to assertThat(collection).describedAs("description").isNotNull()

        Assertions.assertThat(a).isEqualTo(true); // to assertThat(a).isTrue()
        Assertions.assertThat(a).isEqualTo(TRUE); // to assertThat(a).isTrue()
        Assertions.assertThat(a).isEqualTo(Boolean.TRUE); // to assertThat(a).isTrue()
        Assertions.assertThat(a).as("description").isEqualTo(true); // to assertThat(a).as("message").isTrue()
        Assertions.assertThat(a).describedAs("description").isEqualTo(true); // to assertThat(a).describedAs("message").isTrue()

        Assertions.assertThat(a).isEqualTo(false); // to assertThat(a).isFalse()
        Assertions.assertThat(a).isEqualTo(FALSE); // to assertThat(a).isFalse()
        Assertions.assertThat(a).isEqualTo(Boolean.FALSE); // to assertThat(a).isFalse()
        Assertions.assertThat(a).as("description").isEqualTo(false); // to assertThat(a).as("description").isFalse()
        Assertions.assertThat(a).describedAs("description").isEqualTo(false); // to assertThat(a).describedAs("description").isFalse()

        Assertions.assertThat(x == y).isTrue(); // to assertThat(x).isEqualTo(y) ?
        Assertions.assertThat(x == y).as("description").isTrue(); // to assertThat(x).as("description").isEqualTo(y) ?
        Assertions.assertThat(x == y).describedAs("description").isTrue(); // to assertThat(x).describedAs("description").isEqualTo(y) ?
        Assertions.assertThat(x.equals(y)).isTrue(); // to assertThat(x).isEqualTo(y) ?
        Assertions.assertThat(x.equals(y)).as("description").isTrue(); // to assertThat(x).as("description").isEqualTo(y) ?
        Assertions.assertThat(x.equals(y)).describedAs("description").isTrue(); // to assertThat(x).describedAs("description").isEqualTo(y) ?

        Assertions.assertThat(x == y).isFalse(); // to assertThat(x).isNotEqualTo(y) ?
        Assertions.assertThat(x == y).as("description").isFalse(); // to assertThat(x).as("description").isNotEqualTo(y) ?
        Assertions.assertThat(x == y).describedAs("description").isFalse(); // to assertThat(x).describedAs("description").isNotEqualTo(y) ?
        Assertions.assertThat(x.equals(y)).isFalse(); // to assertThat(x).isNotEqualTo(y) ?
        Assertions.assertThat(x.equals(y)).as("description").isFalse(); // to assertThat(x).as("description").isNotEqualTo(y) ?
        Assertions.assertThat(x.equals(y)).describedAs("description").isFalse(); // to assertThat(x).describedAs("description").isNotEqualTo(y) ?

        Assertions.assertThat(x != y).isTrue(); // to assertThat(x).isNotEqualTo(y) ?
        Assertions.assertThat(x != y).as("description").isTrue(); // to assertThat(x).as("description").isNotEqualTo(y) ?
        Assertions.assertThat(x != y).describedAs("description").isTrue(); // to assertThat(x).describedAs("description").isNotEqualTo(y) ?
        Assertions.assertThat(!x.equals(y)).isTrue(); // to assertThat(x).isNotEqualTo(y) ?
        Assertions.assertThat(!x.equals(y)).as("description").isTrue(); // to assertThat(x).as("description").isNotEqualTo(y) ?
        Assertions.assertThat(!x.equals(y)).describedAs("description").isTrue(); // to assertThat(x).describedAs("description").isNotEqualTo(y) ?

        // I think these are a bit too convoluted to worry about for now:
//        assertThat(x != y).isFalse(); // to assertThat(x).isEqualTo(y) ?
//        assertThat(x != y).as("description").isFalse(); // to assertThat(x).as("description").isEqualTo(y) ?
//        assertThat(x != y).describedAs("description").isFalse(); // to assertThat(x).describedAs("description").isEqualTo(y) ?
//        assertThat(!x.equals(y)).isFalse(); // to assertThat(x).isEqualTo(y) ?
//        assertThat(!x.equals(y)).as("description").isFalse(); // to assertThat(x).as("description").isEqualTo(y) ?
//        assertThat(!x.equals(y)).describedAs("description").isFalse(); // to assertThat(x).describedAs("description").isEqualTo(y) ?

        Assertions.assertThat(string.contains("abc")).isTrue(); // to assertThat(string).contains("abc")
        Assertions.assertThat(string.contains("abc")).as("description").isTrue(); // to assertThat(string).as("description").contains("abc")
        Assertions.assertThat(string.contains("abc")).describedAs("description").isTrue(); // to assertThat(string).describedAs("description").contains("abc")

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(this::getInteger);
        Assertions.assertThatExceptionOfType(IllegalStateException.class).isThrownBy(this::getInteger);
        Assertions.assertThatExceptionOfType(IOException.class).isThrownBy(this::getInteger);
        Assertions.assertThatExceptionOfType(NullPointerException.class).isThrownBy(this::getInteger);
        Assertions.assertThatExceptionOfType(NotSerializableException.class).isThrownBy(this::getInteger);

        // should offer migrations to these:
        Assertions.assertThatIllegalArgumentException().isThrownBy(this::getInteger);
        Assertions.assertThatIllegalStateException().isThrownBy(this::getInteger);
        Assertions.assertThatIOException().isThrownBy(this::getInteger);
        Assertions.assertThatNullPointerException().isThrownBy(this::getInteger);
        // no migration for subclass of IOException
        Assertions.assertThatExceptionOfType(NotSerializableException.class).isThrownBy(this::getInteger);

    }

    @Test
    public void migrateToAssertThatCode() {
        var myDescription = "";

        Assertions.assertThatThrownBy(this::getInteger).as(myDescription).isInstanceOf(RuntimeException.class);


        // should migrate to:
        Assertions.assertThatCode(this::getInteger).as(myDescription).isInstanceOf(RuntimeException.class);
    }

    private Integer getInteger() {
        return new SecureRandom().nextInt();
    }
    private String getString() {
        return new SecureRandom().nextInt() + "";
    }
}
