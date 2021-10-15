import org.junit.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class JUnitFour {
    String x = null;

    @Before
    private String setupBefore(){
        return subject;
    }

    @Before
    public String setupBefore2(){
        return subject;
    }

    @Before
    private void setupBefore3(){
        // Nothing to return here
    }

    @Before
    public static void setupBefore4(){
        // Nothing to return here
    }

    @Before
    public void setupBefore5(){
        // Nothing to return here
    }

    @After
    private String setupAfter(){
        return subject;
    }

    @After
    public String setupAfter2(){
        return subject;
    }

    @After
    private void setupAfter3(){
        // Nothing to return here
    }

    @After
    public static void setupAfter4(){
        // Nothing to return here
    }

    @After
    public void setupAfter5(){
        // Nothing to return here
    }

    @BeforeClass
    private String setupBeforeClass(){
        return subject;
    }

    @BeforeClass
    public String setupBeforeClass2(){
        return subject;
    }

    @BeforeClass
    private void setupBeforeClass3(){
        // Nothing to return here
    }

    @BeforeClass
    public static void setupBeforeClass4(){
        // Nothing to return here
    }
    
    @BeforeClass
    public static void setupBeforeClass14(String test){
        // Nothing to return here
    }

    @BeforeClass
    public void setupBeforeClass24(String test){
        // Nothing to return here
    }

    @BeforeClass
    public void setupBeforeClass5(){
        // Nothing to return here
    }

    @AfterClass
    private String setupAfterClass(){
        return subject;
    }

    @AfterClass
    public String setupAfterClass2(){
        return subject;
    }
    
    @AfterClass
    public static String setupAfterClass12(){
        return "";
    }

    @AfterClass
    private void setupAfterClass3(){
        // Nothing to return here
    }

    @AfterClass
    public static void setupAfterClass4(){
        // Nothing to return here
    }

    @AfterClass
    public void setupAfterClass5(){
        // Nothing to return here
    }


    public static class One extends CommonBehavior {
        @Test
        public void x() {
            assertEquals("x", "x");
            assertEquals("message", "x", "x");
        }
    }

    @Ignore
    public static class CommonBehavior {
    }

    String subject = "the quick brown fox jumps over the lazy dog";

    @Test
    public void shouldEqual() {
        assertEquals(subject, "this is a test string");
    }

    @Ignore
    public void shouldEqualToo() {
        assertEquals(subject, "this is a test string");
    }

    public class Replace {
        String replaced = subject.replace("fox", "pig");

        public void shouldHaveReplaced() {
            assertEquals(replaced,"the quick brown pig jumps over the lazy dog");
            assertEquals("message", replaced,"the quick brown pig jumps over the lazy dog");
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
}
