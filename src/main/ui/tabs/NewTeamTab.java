package ui.tabs;

import model.Team;
import ui.*;
import ui.components.FancyField;
import ui.components.FancyLabel;
import ui.components.RoundedButton;
import ui.components.SubmitButton;

import javax.swing.*;
import java.awt.*;

public class NewTeamTab extends Tab {

    private JTextField nameField;
    JButton submitButton;
    GridBagConstraints gbc;

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public NewTeamTab(MonstermonUI controller) {
        super(controller);

        setLayout(new GridBagLayout());
        setBackground(new Color(24, 24, 24)); // background of top and bottom 1/3rd
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5); // add spacing between components
        initialize();
    }

    public void initialize() {
        JLabel nameLabel = new FancyLabel("Name:");
        nameLabel.setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 15));

        nameField = new JTextField(20);
        nameField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5), // add padding to text fields
                BorderFactory.createLineBorder(new Color(40,40,40))));
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
