package nl.tudelft.jpacman.ui;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import nl.tudelft.jpacman.Launcher;

public class Tutorial extends JFrame {
    private JButton select;
    private JButton continueButton;
    private JButton backButton;

    public Tutorial() {
        setTitle("JPacman");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon backgroundImage = new ImageIcon("src/main/resources/button/tutorial_ep_bg.png");
        Image image = backgroundImage.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH);
        ImageIcon realImg = new ImageIcon(image);
        JLabel backgroundLabel = new JLabel(realImg);

        ImageIcon continueIcon = new ImageIcon("src/main/resources/button/continue_btn.png");
        Image continueImg = continueIcon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon continueBtn = new ImageIcon(continueImg);

        ImageIcon backIcon = new ImageIcon("src/main/resources/button/back_btn.png");
        Image backImg = backIcon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon backBtn = new ImageIcon(backImg);

        continueButton = new JButton("");
        continueButton.setIcon(continueBtn);
        continueButton.setOpaque(false);
        continueButton.setContentAreaFilled(false);
        continueButton.setBorderPainted(false);
        continueButton.setBorder(null);

        backButton = new JButton("");
        backButton.setIcon(backBtn);
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setBorder(null);

        backButton.addActionListener(e -> {
            this.setVisible(false);
            new HomePage();
        });

        backgroundLabel.add(continueButton, BorderLayout.CENTER);
        backgroundLabel.add(backButton, BorderLayout.CENTER);
        backButton.setBounds(175, 670, 200, 50);

        add(backgroundLabel, BorderLayout.CENTER);

    }

    public static void main(String[] args) {

    }
}
