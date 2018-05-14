package de.aeschool.hashgenerator.log;

import javax.swing.*;

public class UILogger extends Logger {
    @Override
    public void e(String text) {
        JOptionPane.showMessageDialog(null, text, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void e(Exception exception) {
        JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void w(String text) {
        JOptionPane.showMessageDialog(null, text, "Error", JOptionPane.CANCEL_OPTION);
    }

    @Override
    public void d(String text) {
        JOptionPane.showMessageDialog(null, text, "Error", JOptionPane.QUESTION_MESSAGE);
    }

    @Override
    public void i(String text) {
        JOptionPane.showMessageDialog(null, text, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
