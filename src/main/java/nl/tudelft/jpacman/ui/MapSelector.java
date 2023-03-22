package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import javax.swing.*;
import java.awt.*;

public class MapSelector extends JFrame {
    private JButton select;
    private JButton mapBasicButton;
    private JButton map1Button;
    private JButton map2Button;
    private JButton map3Button;
    private JButton map4Button;
    private JButton map5Button;
    private JButton backButton;


    public MapSelector(){
        setTitle("JPacman");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon backgroundImage = new ImageIcon("src/main/resources/map/bg_select_map.jpg");
        Image image = backgroundImage.getImage().getScaledInstance(600, 770, Image.SCALE_SMOOTH);

        ImageIcon mapbasicIcon = new ImageIcon("src/main/resources/map/basic.png");
        Image mapbasicImg = mapbasicIcon.getImage().getScaledInstance(130, 200, Image.SCALE_SMOOTH);
        ImageIcon mapbasicBtn = new ImageIcon(mapbasicImg);

        ImageIcon map1Icon = new ImageIcon("src/main/resources/map/1.png");
        Image map1Img = map1Icon.getImage().getScaledInstance(130, 200, Image.SCALE_SMOOTH);
        ImageIcon map1Btn = new ImageIcon(map1Img);

        ImageIcon map2Icon = new ImageIcon("src/main/resources/map/2.png");
        Image map2Img = map2Icon.getImage().getScaledInstance(130, 200, Image.SCALE_SMOOTH);
        ImageIcon map2Btn = new ImageIcon(map2Img);

        ImageIcon map3Icon = new ImageIcon("src/main/resources/map/3.png");
        Image map3Img = map3Icon.getImage().getScaledInstance(130, 200, Image.SCALE_SMOOTH);
        ImageIcon mapBtn = new ImageIcon(map3Img);

        ImageIcon map4Icon = new ImageIcon("src/main/resources/map/4.png");
        Image map4Img = map4Icon.getImage().getScaledInstance(130, 200, Image.SCALE_SMOOTH);
        ImageIcon map4Btn = new ImageIcon(map4Img);

        ImageIcon map5Icon = new ImageIcon("src/main/resources/map/5.png");
        Image map5Img = map5Icon.getImage().getScaledInstance(130, 200, Image.SCALE_SMOOTH);
        ImageIcon map5Btn = new ImageIcon(map5Img);

        ImageIcon realImg = new ImageIcon(image);
        JLabel backgroundLabel = new JLabel(realImg);

        ImageIcon backIcon = new ImageIcon("src/main/resources/button/back_btn.png");
        Image backImg = backIcon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon backBtn = new ImageIcon(backImg);


        mapBasicButton = new JButton("");
        mapBasicButton.setIcon(mapbasicBtn);
        mapBasicButton.setOpaque(false);
        mapBasicButton.setContentAreaFilled(false);
        mapBasicButton.setBorderPainted(false);
        mapBasicButton.setBorder(null);

        mapBasicButton.addActionListener(e -> {
            this.setVisible(false);
            new Launcher().launch_map0();
        });
        map1Button = new JButton("");
        map1Button.setIcon(map1Btn);
        map1Button.setOpaque(false);
        map1Button.setContentAreaFilled(false);
        map1Button.setBorderPainted(false);
        map1Button.setBorder(null);

        map1Button.addActionListener(e -> {
            this.setVisible(false);
            new Launcher().launch_map1();
        });
        map2Button = new JButton("");
        map2Button.setIcon(map2Btn);
        map2Button.setOpaque(false);
        map2Button.setContentAreaFilled(false);
        map2Button.setBorderPainted(false);
        map2Button.setBorder(null);

        map2Button.addActionListener(e -> {
            this.setVisible(false);
            new Launcher().launch_map2();
        });
        map3Button = new JButton("");
        map3Button.setIcon(mapBtn);
        map3Button.setOpaque(false);
        map3Button.setContentAreaFilled(false);
        map3Button.setBorderPainted(false);
        map3Button.setBorder(null);

        map3Button.addActionListener(e -> {
            this.setVisible(false);
            new Launcher().launch_map3();
        });
        map4Button = new JButton("");
        map4Button.setIcon(map4Btn);
        map4Button.setOpaque(false);
        map4Button.setContentAreaFilled(false);
        map4Button.setBorderPainted(false);
        map4Button.setBorder(null);

        map4Button.addActionListener(e -> {
            this.setVisible(false);
            new Launcher().launch_map4();
        });
        map5Button = new JButton("");
        map5Button.setIcon(map5Btn);
        map5Button.setOpaque(false);
        map5Button.setContentAreaFilled(false);
        map5Button.setBorderPainted(false);
        map5Button.setBorder(null);

        map5Button.addActionListener(e -> {
            this.setVisible(false);
            new Launcher().launch_map5();
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

        backgroundLabel.add(mapBasicButton, BorderLayout.CENTER);
        backgroundLabel.add(map1Button, BorderLayout.CENTER);
        backgroundLabel.add(map2Button, BorderLayout.CENTER);
        backgroundLabel.add(map3Button, BorderLayout.CENTER);
        backgroundLabel.add(map4Button, BorderLayout.CENTER);
        backgroundLabel.add(map5Button, BorderLayout.CENTER);
        backgroundLabel.add(backButton, BorderLayout.CENTER);

        mapBasicButton.setBounds(82, 180, 130, 205);
        map1Button.setBounds(236, 180, 130, 205);
        map2Button.setBounds(390, 180, 130, 205);
        map3Button.setBounds(82, 404, 130, 205);
        map4Button.setBounds(236, 404, 130, 205);
        map5Button.setBounds(390, 404, 130, 205);

        backButton.setBounds(200, 650, 200, 50);

        add(backgroundLabel, BorderLayout.CENTER);
    }
}
