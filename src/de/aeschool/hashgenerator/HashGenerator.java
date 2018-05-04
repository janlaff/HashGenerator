package de.aeschool.hashgenerator;

import javax.swing.*;
import java.awt.*;

public class HashGenerator {
    public static void main(String[] args) {
        System.out.println("Starting application");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Error setting look and feel");
            return;
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow window = new MainWindow();
                window.setVisible(true);
            }
        });
    }
}
