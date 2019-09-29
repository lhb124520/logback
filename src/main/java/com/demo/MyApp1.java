package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyApp1 {
    private final static Logger logger = LoggerFactory.getLogger(MyApp1.class);

    public static void main(String[] args) {
        logger.trace("Entering application.");
        logger.debug("Entering application.");
        logger.info("Entering application.");
        logger.warn("Entering application.");
        logger.error("Entering application.");

    }
}
