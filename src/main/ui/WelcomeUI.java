package ui;

import ui.components.FancyLabel;
import ui.components.RoundedButton;

import javax.swing.*;
import java.awt.*;

// Represents the GUI for Monstermon Adventures (intro page)
public class WelcomeUI extends JFrame {
    // Singleton Design Pattern

    private static final int WIDTH = 650;
    private static final int HEIGHT = 450;

    private JButton enter;

    private GridBagConstraints gbc;

    private static WelcomeUI instance;

    //MODIFIES: this
    //EFFECTS: creates WelcomeUI, with a gif from https://www.pokemon.com/us/pokemon-episodes/23_01-enter-pikachu/
    private WelcomeUI() {
        super("Monstermon Adventures");

        gbc = new GridBagConstraints();

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        initialize();
        actionListener();
    }

    // EFFECTS: Returns the instance of WelcomeUI
    public static WelcomeUI getInstance() {
        if (instance == null) {
            instance = new WelcomeUI();
        }
        return instance;
    }

    // MODIFIES: this
    // EFFECTS: initializes the welcome page of Monstermon Adventures
    public void initialize() {
        JLabel intro = new FancyLabel("Monstermon Adventures");
        intro.setBackground(new Color(40, 40, 40));
        intro.setForeground(new Color(200, 200, 200));
        setBackground(new Color(24,24,24));

        JPanel panel = new JPanel(new GridBagLayout());
        gbc.anchor = GridBagConstraints.CENTER;

        panel.add(new FancyLabel("Monstermon Adventures"), gbc);

        ImageIcon imageIcon = new ImageIcon("data/welcome.gif");
        JLabel imageLabel = new JLabel(imageIcon);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 20, 0);
        panel.add(imageLabel, gbc);

        enter = new RoundedButton("Start");
        gbc.gridy = 2;
        panel.add(enter, gbc);

        panel.setBackground(new Color(24,24,24));
        add(panel);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: sets the action listener to redirect user to the main application and dispose the current page
    public void actionListener() {
        enter.addActionListener(e -> {
            new MonstermonUI();
            dispose();
        });
    }

    // EFFECTS: runs the application
    public static void main(String[] args) {
        new WelcomeUI();
    }


}