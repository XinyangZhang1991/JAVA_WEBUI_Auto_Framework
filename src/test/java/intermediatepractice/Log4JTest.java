package intermediatepractice;
import org.apache.log4j.Logger;
/*private static Logger logger = Logger.getLogger(LogTest.class);
public static void main(String[] args) {
    logger.debug("debug级别的日志");
    logger.info("info级别的日志");
    logger.warn("warn级别的日志");
    logger.error("error级别的日志");}*/


public class Log4JTest {

    private static Logger logger = Logger.getLogger(Log4JTest.class);
    public static void main(String[] args) {
        logger.debug("debug级别的日志");
        logger.info("info级别的日志");
        logger.warn("warn级别的日志");
        logger.error("error级别的日志");
    }



}
