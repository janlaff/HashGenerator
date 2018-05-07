package de.aeschool.hashgenerator.ui;

import javax.swing.*;

public class MainWindow extends JFrame {
    private JPanel panel1;
    private JButton selectFileButton;
    private JTextArea textArea1;
    private JButton convertStringButton;
    private JTabbedPane tabbedPane1;
    private JButton copyToClipboardButton;

    public MainWindow(String text) {
        setTitle(text);
        setVisible(true);

        add(panel1);

        setSize(800, 600);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
