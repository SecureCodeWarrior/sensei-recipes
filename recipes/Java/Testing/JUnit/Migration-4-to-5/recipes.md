JUnit5 requires Java 8+

@Test(expected =  Exception.class) --> method throws Exception + Assertions.assertThrows(Exception.class, () -> {//...});
@Test(timeout = 1) --> Assertions.assertTimeout(Duration.ofMillis(1), () -> Thread.sleep(10));
@Before --> @BeforeEach
@After --> @AfterEach
@BeforeClass --> @BeforeAll
@AfterClass --> @AfterAll
@Ignore --> @Disabled
@Category --> @Tag
@RunWith(SpringJUnit4ClassRunner.class) --> @ExtendWith(SpringExtension.class) NOT ALWAYS!

Assert -> Assertions

// 4
public class TraceUnitTestRule implements TestRule {
    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                // Before and after an evaluation tracing here 
                ...
            }
        };
    }
}

// 5
public class TraceUnitExtension implements AfterEachCallback, BeforeEachCallback {
    @Override
    public void beforeEach(TestExtensionContext context) throws Exception {
        // ...
    }
    @Override
    public void afterEach(TestExtensionContext context) throws Exception {
        // ...
    }
}

IntelliJ has tools to do this, no need for Sensei cookbook?
https://blog.jetbrains.com/idea/2020/08/migrating-from-junit-4-to-junit-5/
--> Uses vintage engine
--> Hamcrest specific things not solved, but simple to do manually?


https://www.baeldung.com/junit-5-migration
https://blogs.oracle.com/javamagazine/post/migrating-from-junit-4-to-junit-5-important-differences-and-benefits
