package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 06.09.2021
 */
public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Alex";
        int age = 31;
        LOG.debug("User info name : {}, age : {}", name, age);
    }
}
