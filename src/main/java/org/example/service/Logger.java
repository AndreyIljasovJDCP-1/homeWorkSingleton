package org.example.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Logger {

    private int num = 1;

    private static Logger logger;

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String msg) {
        String dateAndTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
                .format(Calendar.getInstance().getTime());
        System.out.println("[" + dateAndTime + " " + num++ + "] " + msg);
    }
}
