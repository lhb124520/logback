/**
 * Logback: the reliable, generic, fast and flexible logging framework.
 * Copyright (C) 1999-2015, QOS.ch. All rights reserved.
 *
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 *
 *   or (per the licensee's choosing)
 *
 * under the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation.
 */
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