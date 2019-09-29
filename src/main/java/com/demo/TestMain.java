package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @BelongsProject: logbackDemo
 * @BelongsPackage: com.demo
 * @Author: lhb
 * @CreateTime: 2019-09-29 11:58
 * @Description:
 */
public class TestMain {
    private final static Logger logger = LoggerFactory.getLogger(TestMain.class);

    public static void main(String[] args) {
        logger.trace("Entering application.");
        logger.debug("Entering application.");
        logger.info("Entering application.");
        logger.warn("Entering application.");
        logger.error("Entering application.");

    }
}
