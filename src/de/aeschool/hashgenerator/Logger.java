package de.aeschool.hashgenerator;

public abstract class Logger {
    public abstract void e(String text);
    public abstract void e(Exception exception);
    public abstract void w(String text);
    public abstract void d(String text);
    public abstract void i(String text);
}
