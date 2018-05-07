package de.aeschool.hashgenerator.ui;

import de.aeschool.hashgenerator.log.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JPanel panel1;
    private JButton selectFileButton;
    private JTextArea textArea1;
    private JButton convertStringButton;
    private JTabbedPane tabbedPane1;
    private JButton copyToClipboardButton;
    private JButton copyToClipboardButton1;
    private JButton copyToClipboardButton2;

    public MainWindow(String text) {
        setTitle(text);
        setVisible(true);
        add(panel1);
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        selectFileButton.addActionListener(actionEvent -> {
            Log.i("Select File button was clicked");
        });

        convertStringButton.addActionListener(actionEvent -> {
            Log.i("Convert String button was clicked");
        });


        copyToClipboardButton.addActionListener(actionEvent -> {
            Log.i("MD5 Copy to Clipboard button was clicked");
        });

        copyToClipboardButton1.addActionListener(actionEvent -> {
            Log.i("SHA-1 Copy to Clipboard button was clicked");
        });

        copyToClipboardButton2.addActionListener(actionEvent -> {
            Log.i("SHA-256 Copy to Clipboard button was clicked");
        });
    }
}
