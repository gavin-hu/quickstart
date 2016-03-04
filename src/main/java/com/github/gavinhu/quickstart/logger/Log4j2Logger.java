package com.github.gavinhu.quickstart.logger;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author gavin
 * @create 16/2/17
 */
public class Log4j2Logger {

    private static final Logger logger = LogManager.getLogger(Log4j2Logger.class);

    public static void main(String[] args) {
        logger.trace("Entering Log4j2.");
        logger.info("test message");
        logger.trace("Exiting Log4j2.");
    }

}
