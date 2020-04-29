package com.lember.primememorycache;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utils {

    static <T> T log(T objectToLog, String logMessage) {
        log.info("{} {}", logMessage, objectToLog);
        return objectToLog;
    }

    public static String composeId(String id, String login) {
        return id + "-" + login;
    }

}
