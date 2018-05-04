package de.aeschool.hashgenerator;

import java.util.ArrayList;
import java.util.List;

public class Log {
    private static List<Logger> loggers = new ArrayList<>();
    private static boolean debugging = false;

    public static void registerLogger(Logger logger) {
        synchronized (loggers) {
            loggers.add(logger);
        }
    }

    public static void enableDebugging() {
        debugging = true;
    }

    public static void e(String text) {
        synchronized (loggers) {
            for (Logger logger : loggers) {
                logger.e(text);
            }
        }
    }

    public static void e(Exception exception) {
        synchronized (loggers) {
            for (Logger logger : loggers) {
                logger.e(exception);
            }
        }
    }

    public static void w(String text) {
        synchronized (loggers) {
            for (Logger logger : loggers) {
                logger.w(text);
            }
        }
    }

    public static void d(String text) {
        if (debugging) {
            synchronized (loggers) {
                for (Logger logger : loggers) {
                    logger.d(text);
                }
            }
        }
    }

    public static void i(String text) {
        synchronized (loggers) {
            for (Logger logger : loggers) {
                logger.i(text);
            }
        }
    }
}
