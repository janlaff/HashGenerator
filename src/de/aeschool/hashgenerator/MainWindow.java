package de.aeschool.hashgenerator;

import javax.swing.*;

public class MainWindow extends JFrame {
    private JButton fileButton;
    private JTextField stringTextField;

    public MainWindow() {
        super("MainWindow");

        initializeGui();
    }

    private void initializeGui() {
        fileButton = new JButton("Select File");
        stringTextField = new JTextField();

        add(fileButton);
        add(stringTextField);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
