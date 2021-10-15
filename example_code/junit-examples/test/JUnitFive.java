import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitFive {
    String subject = "the quick brown fox jumps over the lazy dog";

    @BeforeEach
    private String setupBeforeEach(){
        return subject;
    }

    @BeforeEach
    public String setupBeforeEach2(){
        return subject;
    }

    @BeforeEach
    private void setupBeforeEach3(){
        // Nothing to return here
    }

    @BeforeEach
    public static void setupBeforeEach4(){
        // Nothing to return here
    }

    @BeforeEach
    public void setupBeforeEach5(){
        // Nothing to return here
    }

    @AfterEach
    private String setupAfterEach(){
        return subject;
    }

    @AfterEach
    public String setupAfterEach2(){
        return subject;
    }

    @AfterEach
    private void setupAfterEach3(){
        // Nothing to return here
    }

    @AfterEach
    public static void setupAfterEach4(){
        // Nothing to return here
    }

    @AfterEach
    public void setupAfterEach5(){
        // Nothing to return here
    }

    @BeforeAll
    private String setupBeforeAll(){
        return subject;
    }

    @BeforeAll
    public String setupBeforeAll2(){
        return subject;
    }

    @BeforeAll
    private void setupBeforeAll3(){
        // Nothing to return here
    }

    @BeforeAll
    public static void setupBeforeAll4(){
        // Nothing to return here
    }

    @BeforeAll
    public void setupBeforeAll5(){
        // Nothing to return here
    }

    @AfterAll
    private String setupAfterAll(){
        return subject;
    }

    @AfterAll
    public String setupAfterAll2(){
        return subject;
    }

    @AfterAll
    private void setupAfterAll3(){
        // Nothing to return here
    }

    @AfterAll
    public static void setupAfterAll4(){
        // Nothing to return here
    }

    @AfterAll
    public void setupAfterAll5(){
        // Nothing to return here
    }

    @Test
    public void shouldEqual() {
        assertEquals(subject, "this is a test string");
    }

    @Disabled
    public void shouldEqualToo() {
        assertEquals(subject, "this is a test string");
    }

    @Nested
    public class Replace {
        String replaced = subject.replace("fox", "pig");

        public void shouldHaveReplaced() {
            assertEquals(replaced,"the quick brown pig jumps over the lazy dog");
            assertEquals(replaced,"the quick brown pig jumps over the lazy dog", "message");
            assertEquals(replaced,"the quick brown pig jumps over the lazy dog");
            assertEquals(replaced,"the quick brown pig jumps over the lazy dog");
        }

        private void shouldNotBeAnnotatedOrShouldBePublic() {
            assertEquals("the quick brown pig jumps over the lazy dog", replaced);
        }

        private void shouldBeIgnored() {
            // Some stuff that does not use JUnit
        }
    }

    public class ToUpperCase {
        String upper = subject.toUpperCase();

        @Test
        public void shouldNowBeUppercased() {
            assertEquals("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG", upper);
        }
    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
          Arguments.of(null, true),
          Arguments.of("", true),
          Arguments.of("  ", true),
          Arguments.of("not blank", false)
        );
    }
}
