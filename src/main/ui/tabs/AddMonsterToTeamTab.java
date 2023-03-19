package ui.tabs;

import model.Monster;
import model.Team;
import ui.*;
import ui.components.FancyBox;
import ui.components.FancyLabel;

import javax.swing.*;
import java.util.List;
import java.awt.*;

public class AddMonsterToTeamTab extends Tab {

    private JTextField nameField;
    JButton submitButton;
    private JComboBox<String> monsterList;

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public AddMonsterToTeamTab(MonstermonUI controller) {
        super(controller);

        setLayout(new GridLayout(5, 1));
        setBackground(new Color(24, 24, 24)); // background of top and bottom 1/3rd
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        addHeader();
        initializeLabels();
        actionListener();
    }

    private void addHeader() {
        JLabel header = new FancyLabel("Select a monster to add", JLabel.CENTER);
        add(header);
    }

    public void initializeLabels() {

        monsterList = new FancyBox();
        add(monsterList);
        List<String> monsters = monstermon.getAllMonstersAsStrings();
        for (String name : monsters) {
            monsterList.addItem(name);
        }

        nameField = new JTextField();
        add(nameField);

        submitButton = new JButton("Create Team");
        add(new JLabel());
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
