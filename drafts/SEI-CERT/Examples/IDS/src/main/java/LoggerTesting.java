import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class LoggerTesting {
    private static final Logger logger = Logger.getLogger("some logger");
    private static final Logger logger2 = Logger.getLogger("LoggerTesting");
    private static final Logger logger3 = Logger.getLogger(LoggerTesting.class.getName());
    private static final Logger logger4 = Logger.getLogger(LoggerTesting);
    private static final Logger logger5 = Logger.getLogger(LoggerTesting.class);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String untrusted = sc.nextLine();
        String str = "Testing the logger recipes";

        logger.log(Level.INFO, "Testing the logger recipes");
        logger.log(Level.INFO, "This contains untrusted input:" + untrusted);
        logger.log(Level.INFO, sc.nextLine());
        logger.log(Level.INFO, str);
    }
}
