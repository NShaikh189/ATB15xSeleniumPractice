package org.thetestingacademy.logger;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    private static final Logger logger = LogManager.getLogger(Log.class);

    public static void  info(String message)
    {
        logger.info(message);
    }

    public static void warning(String message)
    {
        logger.warn(message);
    }

    public static void error(String message)
    {
        logger.error(message);
    }


    public static void error(String message, Exception e)
    {
        logger.error(message, e);
    }

    public static void debug(String message)
    {
        logger.debug(message);
    }
}

/*
String path = System.getProperty("./snaps/app_"+System.currentTimeMillis()+".png");
TakesScreenshot sc = (TakesScreenshot)driver;
File scCapture = sc.getScreenshotAs(OutputType.File);
File saveCapture = new File(path);
//commons.io dependency
FileUtils.copy(scCapture, saveCapture);
 */