package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GameOver extends JFrame {
    private static final int MENU_WIDTH = 800;
    private static final int MENU_HEIGHT = 600;
    private static final Color BACKGROUND_COLOR = new Color(0, 0, 0);
    private static final Font TITLE_FONT = new Font("Press Start 2P", Font.BOLD, 30);
    private static final Font BUTTON_FONT = new Font("Press Start 2P", Font.BOLD, 20);

    public GameOver() {
        // Set the title and size of the frame
        setTitle("Game Over");
        setSize(MENU_WIDTH, MENU_HEIGHT);
        setResizable(false);

        // Set the bounds of the frame
        setBounds(100, 100, MENU_WIDTH, MENU_HEIGHT);

        // Set the background color
        getContentPane().setBackground(BACKGROUND_COLOR);

        // Add Pacman Game Over image
        ImageIcon gameOverIcon = new ImageIcon("src/main/resources/bg/Gameover.png");
        JLabel gameOverImage = new JLabel(gameOverIcon);
        gameOverImage.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().add(gameOverImage, BorderLayout.CENTER);

        // Add "Restart" and "Exit" buttons panel
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 30, 0));
        buttonsPanel.setOpaque(false);
        getContentPane().add(buttonsPanel, BorderLayout.SOUTH);

        // Add "Restart" button
        JButton restartButton = new JButton(new ImageIcon("src/main/resources/button/restart_btn.png"));
        restartButton.setBorderPainted(false);
        restartButton.setContentAreaFilled(false);
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code for restart button
                dispose();
                new MapSelector().setVisible(true);

            }
        });
        buttonsPanel.add(restartButton);

        // Add "Exit" button
        JButton  exitButton = new JButton(new ImageIcon("src/main/resources/button/exit_btn.png"));
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code for exit button
                System.exit(0);
            }
        });
        buttonsPanel.add(exitButton);

        // Add message
        JLabel messageLabel = new JLabel("You have died.");
        messageLabel.setFont(TITLE_FONT);
        messageLabel.setForeground(Color.YELLOW);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().add(messageLabel, BorderLayout.NORTH);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Make the frame visible
        setVisible(true);
    }



}
