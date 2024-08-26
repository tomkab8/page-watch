package com.bc.pagewatch.logging;

import lombok.experimental.UtilityClass;

import static org.apache.logging.log4j.util.Strings.EMPTY;

@UtilityClass
public class LogBuilder {

    public static String configure(Object properties) {
        return LogActions.CONFIGURE.name() + " " + properties.toString();
    }

    public static String start() {

        // TODO

        return EMPTY;
    }

    public static String success() {

        // TODO

        return EMPTY;
    }

    public static String failure() {

        // TODO

        return EMPTY;
    }
}
