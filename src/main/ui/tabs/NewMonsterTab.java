package ui.tabs;

import model.Monster;
import ui.MewUI;
import ui.MonstermonUI;
import ui.components.FancyField;
import ui.components.FancyLabel;
import ui.components.RoundedButton;

import javax.swing.*;
import java.awt.*;

import static model.MonsterType.*;

// adapted from: https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html

// Represents the New Monster Tab that allows the user to create a monster
public class NewMonsterTab extends Tab {

    private JTextField nameField;
    private JTextField typeField;
    private JTextField healthField;
    private JButton submitButton;
    private JLabel message;
    private MonstermonUI controller;
    private GridBagConstraints gbc;

    // MODIFIES: this
    // EFFECTS: initializes the NewMonsterTab
    public NewMonsterTab(MonstermonUI controller) {
        super(controller);
        this.controller = controller;
        setLayout(new GridBagLayout());
        setBackground(new Color(24, 24, 24));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        initializeLabels();
        initializeFields();
        initializeSubmitButton();
        addMessageLabel();
        actionListener();
    }

    // MODIFIES: this
    // EFFECTS: initializes the name, type, and health points labels
    public void initializeLabels() {
        JLabel nameLabel = new FancyLabel("Name:");
        JLabel typeLabel = new FancyLabel("Type:");
        JLabel healthLabel = new FancyLabel("Health Points:");
        nameLabel.setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 15));
        typeLabel.setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 15));
        healthLabel.setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 15));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(nameLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(typeLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(healthLabel, gbc);
    }

    // MODIFIES: this
    // EFFECTS: initializes the name, type, and health points fields
    public void initializeFields() {
        nameField = new FancyField(20);
        typeField = new FancyField(20);
        healthField = new FancyField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(nameField, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(typeField, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(healthField, gbc);
    }

    // MODIFIES: this
    // EFFECTS: initializes the create monster button
    public void initializeSubmitButton() {
        submitButton = new RoundedButton("Create Monster");
        submitButton.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        add(submitButton, gbc);
    }

    // MODIFIES: this
    // EFFECTS: adds the message label to the NewMonsterTab
    public void addMessageLabel() {
        message = new FancyLabel("");
        message.setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 15));
        message.setForeground(new Color(30, 61, 52, 255));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        add(message, gbc);
    }

    // EFFECTS: returns the name
    public String getName() {
        return nameField.getText();
    }

    // EFFECTS: returns the type
    public String getType() {
        return typeField.getText();
    }

    // EFFECTS: returns the health points or -1 if the entered value is not a valid integer
    public int getHealthPoints() {
        String healthStr = healthField.getText();
        try {
            return Integer.parseInt(healthStr);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // MODIFIES: this
    // EFFECTS: sets action listener for the submit button
    public void actionListener() {
        JTabbedPane pane = getController().getTabbedPane();
        submitButton.addActionListener(e -> {
            Monster m = makeMonster(getName(), getType(), getHealthPoints());
            nameField.setText("");
            typeField.setText("");
            healthField.setText("");

            if (m != null) {
                message.setForeground(new Color(30, 61, 52, 255));
                message.setText("Monster created successfully!");
                Timer timer = new Timer(1000, ev -> {
                    pane.setSelectedIndex(MonstermonUI.HOME_TAB_INDEX);
                    message.setText("");
                    controller.getAddMonsterToTeamTab().updateMonsterList();
                });
                timer.setRepeats(false);
                timer.start();
            } else {
                message.setForeground(new Color(148, 47, 47));
                message.setText("Invalid input. Please try again.");
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: creates and returns a new monster with the given name, type, and health points, or null
    //          if the input is invalid
    public Monster makeMonster(String name, String mtype, int hp) {
        if (name.equals("%20%Mew%20%")) {
            Monster mew = new Monster("Mew", PSYCH, 999);
            new MewUI();
            monstermon.addMonster(mew);
            return mew;
        }
        if (name.equals("") || hp <= 0 || hp > 400) {
            return null;
        }
        Monster m;
        String type = mtype.toLowerCase();
        if (type.equals("fire")) {
            m = new Monster(name, FIRE, hp);
        } else if (type.equals("water")) {
            m = new Monster(name, WATER, hp);
        } else if (type.equals("grass")) {
            m = new Monster(name, GRASS, hp);
        } else {
            return null;
        }
        monstermon.addMonster(m);
        return m;
        //
        //
    }

}
