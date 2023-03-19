package ui.tabs;

import model.Team;
import ui.*;
import ui.components.FancyLabel;
import ui.components.RoundedButton;

import javax.swing.*;
import java.awt.*;

// Represents the New Team Tab that allows the user to create a team
public class NewTeamTab extends Tab {

    private JTextField nameField;
    private JButton submitButton;
    private GridBagConstraints gbc;
    private JLabel message;

    // MODIFIES: this
    // EFFECTS: initializes the NewMonsterTab
    public NewTeamTab(MonstermonUI controller) {
        super(controller);
        setLayout(new GridBagLayout());
        setBackground(new Color(24, 24, 24));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        initialize();
        actionListener();
        addMessageLabel();
    }

    // MODIFIES: this
    // EFFECTS: initializes the NewTeamTab
    public void initialize() {
        JLabel nameLabel = new FancyLabel("Name:");
        nameLabel.setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 15));
        nameField = new JTextField(20);
        nameField.setOpaque(true);
        nameField.setBackground(new Color(40,40,40));
        nameField.setForeground(new Color(179,179,179));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(nameLabel, gbc);
        gbc.gridx = 1;
        add(nameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        submitButton = new RoundedButton("Create Team");
        submitButton.setBackground(new Color(40, 40, 40));
        submitButton.setPreferredSize(new Dimension(150, 30));
        submitButton.setToolTipText("Create Team");
        add(submitButton, gbc);
    }

    // MODIFIES: this
    // EFFECTS: initializes the message
    public void addMessageLabel() {
        message = new FancyLabel("");
        message.setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 15));
        message.setForeground(new Color(30, 61, 52, 255));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        add(message, gbc);
    }

    // EFFECTS: returns the name from the nameField
    public String getName() {
        return nameField.getText();
    }

    // MODIFIES: this
    // EFFECTS: sets action listener for the submit button
    public void actionListener() {
        JTabbedPane pane = getController().getTabbedPane();
        submitButton.addActionListener(e -> {
            makeTeam(getName());
            nameField.setText("");

            message.setText("Team created successfully!");
            Timer timer = new Timer(1000, ev -> pane.setSelectedIndex(MonstermonUI.HOME_TAB_INDEX));
            timer.setRepeats(false);
            timer.start();
        });
    }

    // MODIFIES: this
    // EFFECTS: makes a new team and adds it to monstermon
    public void makeTeam(String name) {
        if (name.equals("")) {
            return;
        }
        Team t = new Team(name);
        monstermon.addTeam(t);
    }

}
