package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import nl.tudelft.jpacman.Launcher;
import javax.swing.*;
import java.awt.*;

public class GameWin extends JFrame {
    private JButton restartButton;
    private JButton exitButton;

    public GameWin() {

        // Set the title and size of the frame
        setTitle("Pacman");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon backgroundImage = new ImageIcon("src/main/resources/bg/win.png");
        Image image = backgroundImage.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH);
        ImageIcon realImg = new ImageIcon(image);
        JLabel backgroundLabel = new JLabel(realImg);

        ImageIcon exitIcon = new ImageIcon("src/main/resources/button/exit_btn.png");
        Image exitImg = exitIcon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon exitBtn = new ImageIcon(exitImg);

        ImageIcon restartIcon = new ImageIcon("src/main/resources/button/restart_btn.png");
        Image restartImg = restartIcon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon restartBtn = new ImageIcon(restartImg);

        restartButton = new JButton("");
        restartButton.setIcon(restartBtn);
        restartButton.setOpaque(false);
        restartButton.setContentAreaFilled(false);
        restartButton.setBorderPainted(false);
        restartButton.setBorder(null);

        restartButton.addActionListener(e -> {
            this.setVisible(false);
            Launcher.dispose();
            new MapSelector().setVisible(true);
        });

        exitButton = new JButton("");
        exitButton.setIcon(exitBtn);
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);
        exitButton.setBorder(null);
        exitButton.addActionListener(e -> {
            this.dispose();
        });

        backgroundLabel.add(restartButton, BorderLayout.CENTER);
        backgroundLabel.add(exitButton, BorderLayout.CENTER);
        restartButton.setBounds(50, 700, 200, 50);
        exitButton.setBounds(350, 700, 200, 50);
        backgroundLabel.setLayout(null);
        add(backgroundLabel, BorderLayout.CENTER);

        setVisible(true);

    }



}
