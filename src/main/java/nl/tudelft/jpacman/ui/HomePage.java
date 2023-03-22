package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {
    private JButton startButton;

    private JButton themeButton;
    private JButton exitButton;
    private ThemeSelector themeSelector;
    private MapSelector mapSelector;

    public void openTheme() {
        themeSelector = new ThemeSelector();
        themeSelector.setVisible(true);
    }
    private void openMap() {
        mapSelector = new MapSelector();
        mapSelector.setVisible(true);
    }



    public JButton getStartButton() {
        return startButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public ThemeSelector getThemeSelector() {
        return themeSelector;
    }


    public HomePage(){

        setTitle("JPacman");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon backgroundImage = new ImageIcon("src/main/resources/bg/pac_bg.png");
        Image image = backgroundImage.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH);
        ImageIcon realImg = new ImageIcon(image);
        JLabel backgroundLabel = new JLabel(realImg);

        ImageIcon startIcon = new ImageIcon("src/main/resources/button/start_btn.png");
        Image startImg = startIcon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon startBtn = new ImageIcon(startImg);

        ImageIcon themeIcon = new ImageIcon("src/main/resources/button/theme_btn.png");
        Image themeImg = themeIcon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon themeBtn = new ImageIcon(themeImg);

        ImageIcon exitIcon = new ImageIcon("src/main/resources/button/exit_btn.png");
        Image exitImg = exitIcon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon exitBtn = new ImageIcon(exitImg);

        ImageIcon icon = new ImageIcon("src/main/resources/icon.png");
        Image iconImg = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        setIconImage(iconImg);

        // Set up the button
        startButton = new JButton("");
        startButton.setIcon(startBtn);
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        startButton.setBorder(null);

        startButton.addActionListener(e -> {
            this.setVisible(false);
            openMap();
        });

        themeButton = new JButton("");
        themeButton.setIcon(themeBtn);
        themeButton.setOpaque(false);
        themeButton.setContentAreaFilled(false);
        themeButton.setBorderPainted(false);
        themeButton.setBorder(null);

        themeButton.addActionListener(e -> {
            this.setVisible(false);
            openTheme();
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

        backgroundLabel.add(startButton, BorderLayout.CENTER);
        backgroundLabel.add(themeButton, BorderLayout.CENTER);
        backgroundLabel.add(exitButton, BorderLayout.CENTER);
        startButton.setBounds(200, 250, 200, 50);
        themeButton.setBounds(200, 350, 200, 50);
        exitButton.setBounds(200, 450, 200, 50);
        backgroundLabel.setLayout(null);
        add(backgroundLabel, BorderLayout.CENTER);

        setVisible(true);
    }



    public static void main(String[] args) {
        new HomePage();
    }

}
