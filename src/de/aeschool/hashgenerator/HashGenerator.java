package de.aeschool.hashgenerator;

import javax.swing.*;
import java.awt.*;

public class HashGenerator {
    public static void main(String[] args) {
        Log.registerLogger(new ConsoleLogger());

        Log.d("Starting application");

        try {
            Log.d("Setting system default look and feel...");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            Log.e("Setting look and feel failed... Continuing with default");
        }

        EventQueue.invokeLater(() -> {
            MainWindow window = new MainWindow("HashGenerator");
            window.setVisible(true);
        });
    }
}
