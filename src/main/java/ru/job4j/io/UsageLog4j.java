package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte one = 127;
        short two = 32767;
        char three = 'c';
        int four = 2147483647;
        long five = 2147483648L;
        float six = 1.0f;
        double seven = 2.0;
        boolean eight = true;
        String sls = System.lineSeparator();
        LOG.debug("{}byte one     : {}{}"
                + "short two    : {}{}"
                + "char three   : {}{}"
                + "int four     : {}{}"
                + "long five    : {}{}"
                + "float six    : {}{}"
                + "double seven : {}{}"
                + "double seven : {}",
                sls, one, sls, two, sls, three, sls, four, sls, five, sls, six, sls, seven, sls, eight);

    }
}