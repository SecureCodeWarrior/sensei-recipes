import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.List;

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

        assertThat(collection.size()).isEqualTo(1); // to assertThat(collection).hasSize(1)
        assertThat(collection.size()).as("hasSize 1").isEqualTo(1); // to assertThat(collection).as("hasSize 1").hasSize(1)
        assertThat(collection.size()).describedAs("hasSize 1").isEqualTo(1); // to assertThat(collection).as("hasSize 1").hasSize(1)

        assertThat(collection.size()).isEqualTo(0); // to assertThat(collection).isEmpty()
        assertThat(collection.size()).as("isEmpty").isEqualTo(0); // to assertThat(collection).as("isEmpty").isEmpty()

        assertThat(collection1.size()).isEqualTo(collection2.size()); // to assertThat(collection1).hasSameSizeAs(collection2)
        assertThat(collection1.size()).as("hasSameSizeAs").isEqualTo(collection2.size()); // to assertThat(collection1).as("hasSameSizeAs").hasSameSizeAs(collection2)

        // assertThat(variable).as("").isEqualTo("something"); // to assertThat(variable).isEqualTo(something)
        // Maybe: having a quickfix that drops assertion description (not just because the message is empty)


        assertThat(variable).isEqualTo(null); // to assertThat(variable).isNull()

        assertThat(variable).isNotEqualTo(null); // to assertThat(collection).isNotNull()

        assertThat(a).isEqualTo(true); // to assertThat(x).isTrue()

        assertThat(a).isEqualTo(false); // to assertThat(x).isFalse()

        assertThat(x == y).isTrue(); // to assertThat(x).isEqualTo(y) ?

        assertThat(x == y).isFalse(); // to assertThat(x).isNotEqualTo(y) ?

        assertThat(x != y).isTrue(); // to assertThat(x).isNotEqualTo(y) ?

        assertThat(x != y).isFalse(); // to assertThat(x).isEqualTo(y) ?

        assertThat(x.equals(y)).isTrue(); // to assertThat(x).isEqualTo(y) ?

        assertThat(x.equals(y)).isFalse(); // to assertThat(x).isNotEqualTo(y) ?

        assertThat(string.contains("abc")).isTrue(); // to assertThat(string).contains("abc")

    }

    private Integer getInteger() {
        return new SecureRandom().nextInt();
    }
    private String getString() {
        return new SecureRandom().nextInt() + "";
    }
}
