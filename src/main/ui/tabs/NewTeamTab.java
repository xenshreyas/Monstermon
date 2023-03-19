package ui.tabs;

import model.Team;
import ui.*;
import ui.BetterComponents.FancyField;
import ui.BetterComponents.FancyLabel;
import ui.BetterComponents.SubmitButton;

import javax.swing.*;
import java.awt.*;

public class NewTeamTab extends Tab {

    private JTextField nameField;
    private JTextField typeField;
    private JTextField healthField;
    JButton submitButton;

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public NewTeamTab(MonstermonUI controller) {
        super(controller);

        setLayout(new GridLayout(3, 2));
        setBackground(new Color(24, 24, 24)); // background of top and bottom 1/3rd
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        initializeLabels();
        actionListener();
    }

    public void initializeLabels() {
        JLabel nameLabel = new FancyLabel("Name:");

        nameField = new FancyField();

        add(nameLabel);
        add(nameField);

        submitButton = new SubmitButton("Create Team");
        add(submitButton);
    }

    public String getName() {
        return nameField.getText();
    }

    private void actionListener() {
        JTabbedPane pane = getController().getTabbedPane();
        submitButton.addActionListener(e -> {
            makeTeam(getName());
            nameField.setText("");
            pane.setSelectedIndex(MonstermonUI.HOME_TAB_INDEX);
        });
    }

    private void makeTeam(String name) {
        if (name.equals("")) {
            return;
        }
        Team t = new Team(name);
        monstermon.addTeam(t);
    }

}
