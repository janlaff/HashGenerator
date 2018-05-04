package de.aeschool.hashgenerator.log;

import java.util.Date;

public class ConsoleLogger extends Logger {
    public void e(String text) {
        System.err.println(getDateTimeString() + " [ERROR]: " + text);
    }

    public void e(Exception exception) {
        System.err.println(getDateTimeString() + " [ERROR]: " + exception.getStackTrace());
    }

    public void w(String text) {
        System.out.println(getDateTimeString() + " [WARNING]: " + text);
    }

    public void d(String text) {
        System.out.println(getDateTimeString() + " [DEBUG]: " + text);
    }

    public void i(String text) {
        System.out.println(getDateTimeString() + " [INFO]: " + text);
    }

    private String getDateTimeString() {
        return new Date().toString();
    }
}
