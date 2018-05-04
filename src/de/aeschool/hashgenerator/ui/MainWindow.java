package de.aeschool.hashgenerator.ui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JButton fileButton;
    private JTextField stringTextField;
    private GridLayout gridLayout;

    public MainWindow(String title) {
        super(title);

        initializeGui();
    }

    private void initializeGui() {
        gridLayout = new GridLayout(2, 0);
        fileButton = new JButton("Select File");
        stringTextField = new JTextField();

        setLayout(gridLayout);

        add(fileButton);
        add(stringTextField);

        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
