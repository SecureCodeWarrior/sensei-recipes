package logging;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingAllTheThings {

    private Logger defaultLogger = Logger.getLogger("a logger");

    private final static org.slf4j.Logger loggerDink = org.slf4j.LoggerFactory.getLogger(LoggingAllTheThings.class);

    //private String logger = "logger";

    public static void main(String[] untrusted) {

        System.out.println("Just print it on std out!");
        System.err.println("Or perhaps on std err?");
        System.out.print("Just print it on std out!");
        System.err.print("Or perhaps on std err?");
        System.console().printf("Format it like: %s", "What I actually want to print");

        loggerDink.debug(untrusted[0], untrusted[1]);
        loggerDink.info(untrusted[0], untrusted[1]);
        loggerDink.trace(untrusted[0], untrusted[1]);
        loggerDink.warn(untrusted[0], untrusted[1]);
        loggerDink.error(untrusted[0], untrusted[1]);

        loggerDink.debug(untrusted[0], URLEncoder.encode(untrusted[1], StandardCharsets.UTF_8));
        loggerDink.info(untrusted[0], URLEncoder.encode(untrusted[1], StandardCharsets.UTF_8));
        loggerDink.trace(untrusted[0], URLEncoder.encode(untrusted[1], StandardCharsets.UTF_8));
        loggerDink.warn(untrusted[0], URLEncoder.encode(untrusted[1], StandardCharsets.UTF_8));
        loggerDink.error(untrusted[0], URLEncoder.encode(untrusted[1], StandardCharsets.UTF_8));
    }

    public void imTrying() {
        try {
            throw new Exception("Some message");
        } catch (Exception e) {
            System.out.println(e);

            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            e.printStackTrace();
            e.printStackTrace(System.err);
            e.printStackTrace(System.out);

            loggerDink.error("", e);
            loggerDink.info("", e);
            loggerDink.debug("", e);
            loggerDink.trace("", e);
            loggerDink.warn("", e);

            loggerDink.trace(String.valueOf(e));
            loggerDink.info(e.toString());
            loggerDink.warn(e.toString());
            loggerDink.error(String.valueOf(e));
            loggerDink.debug(e.toString());

            defaultLogger.fine(e.toString());
            defaultLogger.finer(e.toString());
            defaultLogger.finest(e.toString());
            defaultLogger.info(e.toString());
            defaultLogger.warning(e.toString());
            defaultLogger.severe(e.toString());

            defaultLogger.log(Level.SEVERE, String.valueOf(e));
            defaultLogger.log(Level.WARNING, String.valueOf(e));
            defaultLogger.log(Level.INFO, String.valueOf(e));
            defaultLogger.log(Level.FINEST, String.valueOf(e));
            defaultLogger.log(Level.FINER, String.valueOf(e));
            defaultLogger.log(Level.FINE, String.valueOf(e));
            defaultLogger.log(Level.CONFIG, String.valueOf(e));

            defaultLogger.log(Level.CONFIG, e, null);
            defaultLogger.log(Level.FINE, e, null);
            defaultLogger.log(Level.FINER, e, null);
            defaultLogger.log(Level.FINEST, e, null);
            defaultLogger.log(Level.INFO, e, null);
            defaultLogger.log(Level.WARNING, e, null);
            defaultLogger.log(Level.SEVERE, e, null);

            defaultLogger.log(Level.CONFIG, "message", e);
            defaultLogger.log(Level.CONFIG,"", new Object());
            defaultLogger.log(Level.FINE, "message", e);
            defaultLogger.log(Level.FINE,"", new Object());
            defaultLogger.log(Level.FINER, "message", e);
            defaultLogger.log(Level.FINER,"", new Object());
            defaultLogger.log(Level.FINEST, "message", e);
            defaultLogger.log(Level.FINEST,"", new Object());
            defaultLogger.log(Level.INFO, "message", e);
            defaultLogger.log(Level.INFO,"", new Object());
            defaultLogger.log(Level.WARNING, "message", e);
            defaultLogger.log(Level.WARNING,"", new Object());
            defaultLogger.log(Level.SEVERE, "message", e);
            defaultLogger.log(Level.SEVERE,"", new Object());

            //logger.error()

            //defaultLogger.log(Level.OFF, String.valueOf(e));
            defaultLogger.logp(Level.ALL, "", "", e.getStackTrace().toString());
            //defaultLogger.logrb(Level.ALL, ResourceBundle.getBundle(""), e.toString(), "");
        }
    }

    public void printMessages(Throwable e) {
        System.out.println(e.getMessage());
        System.out.print(e.getMessage());
        System.err.println(e.getMessage());
        System.err.print(e.getMessage());
    }
}
