package ui;

import ui.BetterComponents.FancyLabel;
import ui.BetterComponents.RoundedButton;

import javax.swing.*;
import java.awt.*;

// Represents the GUI for Monstermon Adventures
public class WelcomeUI extends JFrame {

    public static final int WIDTH = 650;
    public static final int HEIGHT = 450;

    JButton enter;

    //MODIFIES: this
    //EFFECTS: creates MonstermonUI, displays sidebar and tabs
    private WelcomeUI() {
        super("Monstermon Adventures");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        JLabel title = new FancyLabel("Monstermon Adventures");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setBackground(new Color(24,24,24));
        title.setOpaque(true);
        add(title, BorderLayout.NORTH);

        initialize();
        actionListener();
    }

    public void initialize() {

        JLabel intro = new FancyLabel("Monstermon Adventures");
        setBackground(new Color(24,24,24));
        JPanel panel = new JPanel(new GridBagLayout());

        add(intro);

        ImageIcon imageIcon = new ImageIcon("data/welcome.gif");

        JLabel imageLabel = new JLabel(imageIcon);

        GridBagConstraints imageConstraints = new GridBagConstraints();
        imageConstraints.gridx = 0;
        imageConstraints.gridy = 0;
        imageConstraints.insets = new Insets(0, 0, 20, 0);
        imageConstraints.anchor = GridBagConstraints.CENTER;
        panel.add(imageLabel, imageConstraints);

        enter = new RoundedButton("Start");

        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 1;
        buttonConstraints.anchor = GridBagConstraints.CENTER;
        panel.add(enter, buttonConstraints);

        add(panel);
        panel.setBackground(new Color(24,24,24));

        setVisible(true);
    }

    private void actionListener() {
        enter.addActionListener(e -> {
            new MonstermonUI();
            dispose();
        });
    }

    public static void main(String[] args) {
        new WelcomeUI();
    }

}