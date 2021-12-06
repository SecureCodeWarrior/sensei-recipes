import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.NotSerializableException;
import java.security.SecureRandom;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
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

        assertThat(collection.size()).isEqualTo(1); // to assertThat(collection).hasSize(1)
        assertThat(collection.size()).as("hasSize 1").isEqualTo(1); // to assertThat(collection).as("hasSize 1").hasSize(1)
        assertThat(collection.size()).describedAs("hasSize 1").isEqualTo(1); // to assertThat(collection).describedAs("hasSize 1").hasSize(1)

        assertThat(collection1).hasSize(collection2.size()); // to assertThat(collection1).hasSameSizeAs(collection2)
        assertThat(collection1).as("hasSameSizeAs").hasSize(collection2.size()); // to assertThat(collection1).as("hasSameSizeAs").hasSameSizeAs(collection2)
        assertThat(collection1).describedAs("hasSameSizeAs").hasSize(collection2.size()); // to assertThat(collection1).as("hasSameSizeAs").hasSameSizeAs(collection2)

        assertThat(collection).hasSize(0); // to assertThat(collection).isEmpty()
        assertThat(collection).as("isEmpty").hasSize(0); // to assertThat(collection).as("isEmpty").isEmpty()
        assertThat(collection).describedAs("isEmpty").hasSize(0); // to assertThat(collection).describedAs("isEmpty").isEmpty()

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
