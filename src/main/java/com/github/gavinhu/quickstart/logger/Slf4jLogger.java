package com.github.gavinhu.quickstart.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gavin
 * @create 16/2/17
 */
public class Slf4jLogger {

    private static final Logger logger = LoggerFactory.getLogger(Slf4jLogger.class);

    public static void main(String[] args) {
        logger.trace("Entering Slf4j.");
        logger.info("test message");
        logger.trace("Exiting Slf4j.");
    }

}
