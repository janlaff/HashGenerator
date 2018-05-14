package de.aeschool.hashgenerator.ui;

import de.aeschool.hashgenerator.crypto.Hash;
import de.aeschool.hashgenerator.log.*;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MainWindow extends JFrame {
    private JPanel panel1;
    private JButton selectFileButton;
    private JTextArea textArea1;
    private JButton convertStringButton;
    private JTabbedPane tabbedPane1;
    private JButton copyToClipboardButton;
    private JButton copyToClipboardButton1;
    private JButton copyToClipboardButton2;
    private JLabel md5Label;
    private JLabel sha1Label;
    private JLabel sha256Label;

    public MainWindow(String text) {
        setTitle(text);
        setVisible(true);
        add(panel1);
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        updateUI("".getBytes());

        selectFileButton.addActionListener(actionEvent -> {
            Log.d("Select File button was clicked");

            JFileChooser fileChooser = new JFileChooser();

            int ret = fileChooser.showOpenDialog(this);

            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                Log.d("Opening: " + file.getName());

                try {
                    updateUI(Files.readAllBytes(file.toPath()));
                } catch (IOException e) {
                    Log.e(e);
                }
            }
        });

        convertStringButton.addActionListener(actionEvent -> {
            Log.d("Convert String button was clicked");
            updateUI(textArea1.getText().getBytes());
        });


        copyToClipboardButton.addActionListener(actionEvent -> {
            Log.d("MD5 Copy to Clipboard button was clicked");
            copyToClipboard(md5Label.getText());
        });

        copyToClipboardButton1.addActionListener(actionEvent -> {
            Log.d("SHA-1 Copy to Clipboard button was clicked");
            copyToClipboard(sha1Label.getText());
        });

        copyToClipboardButton2.addActionListener(actionEvent -> {
            Log.d("SHA-256 Copy to Clipboard button was clicked");
            copyToClipboard(sha256Label.getText());
        });
    }

    private void updateUI(byte[] data) {
        md5Label.setText(Hash.md5(data));
        sha1Label.setText(Hash.sha1(data));
        sha256Label.setText(Hash.sha256(data));
    }

    private void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }
}
