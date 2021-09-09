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
        char symbol = 'c';
        byte type = 1;
        short number = 2;
        int age = 31;
        long key = 1L;
        double id = 1.0;
        float score = 2.0f;
        boolean bl = true;

        LOG.debug("User info name : {}, age : {}, symbol : {}, type : {}, number : {}, key : {}, id : {}, "
                        + "userScore : {}, admin : {}", name, age, symbol, type, number, key, id, score, bl);
    }
}
