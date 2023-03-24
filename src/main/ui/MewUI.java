package ui;

import ui.components.FancyLabel;
import ui.components.RoundedButton;

import javax.swing.*;
import java.awt.*;

// Represents the Mew UI, that the user is taken to when they interact with Mew
public class MewUI extends JFrame {

    private static final int WIDTH = 650;
    private static final int HEIGHT = 800;

    private JPanel panel;

    private JButton yes;
    private JButton no;

    private JLabel intro;
    private JLabel question;

    private final String colorReset = "\u001b[0m";
    private final String colorRed = "\033[0;31m";

    private GridBagConstraints gbc;

    //MODIFIES: this
    //EFFECTS: creates MewUI, with a gif from https://pokemongifs.tumblr.com/post/90757099804/x-shiny-mew
    public MewUI() {
        super("???");

        gbc = new GridBagConstraints();

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(1,1,1));
        setResizable(false);

        initialize();
        initializePanel();
        initializeButtons();
        actionListener();
    }

    // MODIFIES: this
    // EFFECTS: initializes the MewUI page
    public void initialize() {
        intro = new FancyLabel("You've been teleported to the land of Pokémon");
        question = new FancyLabel("Mew: \"Tell me child, are you the one who solved CPSC-110's PSet 9?\"");
        intro.setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 24));
        question.setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 16));
        intro.setBackground(new Color(40, 40, 40));
        intro.setForeground(new Color(200, 200, 200));
        question.setBackground(new Color(40, 40, 40));
        question.setForeground(new Color(208, 160, 220));
        setBackground(new Color(24, 24, 24));
    }

    // MODIFIES: this
    // EFFECTS: adds the text, image to the panel
    public void initializePanel() {
        panel = new JPanel(new GridBagLayout());
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 20, 0);
        panel.add(intro, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 20, 0);
        panel.add(question, gbc);

        ImageIcon imageIcon = new ImageIcon("data/mew.gif");
        JLabel imageLabel = new JLabel(imageIcon);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 20, 0);
        panel.add(imageLabel, gbc);
    }

    // MODIFIES: this
    // EFFECTS: adds the yes and no buttons to the panel
    private void initializeButtons() {
        yes = new RoundedButton("Yes");
        gbc.insets = new Insets(0, 0, 20, 100);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(yes, gbc);

        no = new RoundedButton("No");
        gbc.insets = new Insets(0, 100, 20, 0);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(no, gbc);

        panel.setBackground(new Color(24,24,24));
        add(panel);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: sets the action listener to redirect user to the main application and dispose the current page
    public void actionListener() {
        yes.addActionListener(e -> dispose());
        no.addActionListener(e -> {
            System.out.println(colorRed + "Bruh you crashed the game... The devs are kinda pissed... "
                    + "And so is the literal GOD of Pokémon. What a disgrace..." + colorReset);
            System.exit(0);
            dispose();
        });
    }

    // EFFECTS: runs the application
    public static void main(String[] args) {
        new MewUI();
    }

}