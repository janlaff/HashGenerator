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
    private JButton md5CopyBtn;
    private JButton sha1CopyBtn;
    private JButton sha256CopyBtn;
    private JLabel md5Label;
    private JLabel sha1Label;
    private JLabel sha256Label;
    private JLabel md2Label;
    private JLabel sha384Label;
    private JLabel sha512Label;
    private JButton md2CopyBtn;
    private JButton sha384CopyBtn;
    private JButton sha512CopyBtn;

    public MainWindow(String text) {
        setTitle(text);
        setVisible(true);
        add(panel1);
        setSize(1280, 600);
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


        md2CopyBtn.addActionListener(actionEvent -> {
            Log.d("MD2 Copy to Clipboard button was clicked");
            copyToClipboard(md2Label.getText());
        });

        md5CopyBtn.addActionListener(actionEvent -> {
            Log.d("MD5 Copy to Clipboard button was clicked");
            copyToClipboard(md5Label.getText());
        });

        sha1CopyBtn.addActionListener(actionEvent -> {
            Log.d("SHA-1 Copy to Clipboard button was clicked");
            copyToClipboard(sha1Label.getText());
        });

        sha256CopyBtn.addActionListener(actionEvent -> {
            Log.d("SHA-256 Copy to Clipboard button was clicked");
            copyToClipboard(sha256Label.getText());
        });

        sha384CopyBtn.addActionListener(actionEvent -> {
            Log.d("SHA-384 Copy to Clipboard button was clicked");
            copyToClipboard(sha384Label.getText());
        });

        sha512CopyBtn.addActionListener(actionEvent -> {
            Log.d("SHA-512 Copy to Clipboard button was clicked");
            copyToClipboard(sha512Label.getText());
        });
    }

    private void updateUI(byte[] data) {
        md2Label.setText(Hash.md2(data));
        md5Label.setText(Hash.md5(data));
        sha1Label.setText(Hash.sha1(data));
        sha256Label.setText(Hash.sha256(data));
        sha384Label.setText(Hash.sha384(data));
        sha512Label.setText(Hash.sha512(data));
    }

    private void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }
}
