package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import javax.swing.*;
import java.awt.*;

public class ThemeSelector extends JFrame {

    private JButton select;
    private JButton theme1Button;
    private JButton theme2Button;
    private JButton theme3Button;
    private JButton theme4Button;
    private JButton theme5Button;
    private JButton backButton;

    private MapSelector mapSelector;



    private static int theme_;


    public static int getTheme_() {
        return theme_;
    }
    private void openMap() {
        mapSelector = new MapSelector();
        mapSelector.setVisible(true);
    }
    public static void setTheme_(int theme_) {
        ThemeSelector.theme_ = theme_;
    }

    public ThemeSelector(){
        setTitle("JPacman");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon backgroundImage = new ImageIcon("src/main/resources/bg/theme_bg.png");
        Image image = backgroundImage.getImage().getScaledInstance(600, 770, Image.SCALE_SMOOTH);

        ImageIcon map1Icon = new ImageIcon("src/main/resources/theme/theme_1.png");
        Image map1Img = map1Icon.getImage().getScaledInstance(370, 227, Image.SCALE_SMOOTH);
        ImageIcon theme1Btn = new ImageIcon(map1Img);

        ImageIcon map2Icon = new ImageIcon("src/main/resources/theme/theme_2.png");
        Image map2Img = map2Icon.getImage().getScaledInstance(370, 227, Image.SCALE_SMOOTH);
        ImageIcon theme2Btn = new ImageIcon(map2Img);

        ImageIcon map3Icon = new ImageIcon("src/main/resources/theme/theme_3.png");
        Image map3Img = map3Icon.getImage().getScaledInstance(370, 227, Image.SCALE_SMOOTH);
        ImageIcon theme3Btn = new ImageIcon(map3Img);

        ImageIcon map4Icon = new ImageIcon("src/main/resources/theme/theme_4.png");
        Image map4Img = map4Icon.getImage().getScaledInstance(370, 227, Image.SCALE_SMOOTH);
        ImageIcon theme4Btn = new ImageIcon(map4Img);

        ImageIcon map5Icon = new ImageIcon("src/main/resources/theme/theme_5.png");
        Image map5Img = map5Icon.getImage().getScaledInstance(370, 227, Image.SCALE_SMOOTH);
        ImageIcon theme5Btn = new ImageIcon(map5Img);

        ImageIcon realImg = new ImageIcon(image);
        JLabel backgroundLabel = new JLabel(realImg);

        ImageIcon backIcon = new ImageIcon("src/main/resources/button/back_btn.png");
        Image backImg = backIcon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon backBtn = new ImageIcon(backImg);



        theme1Button = new JButton("");
        theme1Button.setIcon(theme1Btn);
        theme1Button.setOpaque(false);
        theme1Button.setContentAreaFilled(false);
        theme1Button.setBorderPainted(false);
        theme1Button.setBorder(null);

        theme1Button.addActionListener(e -> {
            setTheme_(1);
            this.setVisible(false);
            openMap();
        });

        theme2Button = new JButton("");
        theme2Button.setIcon(theme2Btn);
        theme2Button.setOpaque(false);
        theme2Button.setContentAreaFilled(false);
        theme2Button.setBorderPainted(false);
        theme2Button.setBorder(null);

        theme2Button.addActionListener(e -> {
            setTheme_(2);
            this.setVisible(false);
            openMap();
        });

        theme3Button = new JButton("");
        theme3Button.setIcon(theme3Btn);
        theme3Button.setOpaque(false);
        theme3Button.setContentAreaFilled(false);
        theme3Button.setBorderPainted(false);
        theme3Button.setBorder(null);

        theme3Button.addActionListener(e -> {
            setTheme_(3);
            this.setVisible(false);
            openMap();

        });

        theme4Button = new JButton("");
        theme4Button.setIcon(theme4Btn);
        theme4Button.setOpaque(false);
        theme4Button.setContentAreaFilled(false);
        theme4Button.setBorderPainted(false);
        theme4Button.setBorder(null);

        theme4Button.addActionListener(e -> {
            setTheme_(4);
            this.setVisible(false);
            openMap();
        });

        theme5Button = new JButton("");
        theme5Button.setIcon(theme5Btn);
        theme5Button.setOpaque(false);
        theme5Button.setContentAreaFilled(false);
        theme5Button.setBorderPainted(false);
        theme5Button.setBorder(null);

        theme5Button.addActionListener(e -> {
            setTheme_(5);
            this.setVisible(false);
            openMap();
        });

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

        backgroundLabel.add(theme1Button, BorderLayout.CENTER);
        backgroundLabel.add(theme2Button, BorderLayout.CENTER);
        backgroundLabel.add(theme3Button, BorderLayout.CENTER);
        backgroundLabel.add(theme4Button, BorderLayout.CENTER);
        backgroundLabel.add(theme5Button, BorderLayout.CENTER);
        backgroundLabel.add(backButton, BorderLayout.CENTER);

        theme1Button.setBounds(82, 180, 130, 205);
        theme2Button.setBounds(236, 180, 130, 205);
        theme3Button.setBounds(390, 180, 130, 205);
        theme4Button.setBounds(160, 404, 130, 205);
        theme5Button.setBounds(315, 404, 130, 205);
        backButton.setBounds(200, 650, 200, 50);


        add(backgroundLabel, BorderLayout.CENTER);
    }



    public static void main(String[] args) {

    }
}

