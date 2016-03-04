package com.github.gavinhu.quickstart.logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author gavin
 * @create 16/2/17
 */
public class JclLogger {

    private static final Log log = LogFactory.getLog(JclLogger.class);

    public static void main(String[] args) {
        log.trace("Entering Jcl.");
        log.info("test message");
        log.trace("Exiting Jcl.");
    }

}
