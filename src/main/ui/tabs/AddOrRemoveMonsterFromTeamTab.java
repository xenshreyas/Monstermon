package ui.tabs;

import model.Monster;
import model.Team;
import ui.*;
import ui.components.FancyBox;
import ui.components.FancyLabel;
import ui.components.RoundedButton;

import javax.swing.*;
import java.util.List;
import java.awt.*;

// adapted from: https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html

// Represents the Add or Remove Monster to or from Team tab
public class AddOrRemoveMonsterFromTeamTab extends Tab {

    private JButton submitButton;
    private JButton removeButton;
    private JComboBox<String> monsterList;
    private JComboBox<String> teamList;
    private JLabel message;
    private GridBagConstraints gbc;
    private List<Monster> monsters = monstermon.getAllMonsters();
    private List<Team> teams = monstermon.getAllTeams();

    // MODIFIES: this
    // EFFECTS: constructs the AddMonsterToTeam tab for with drop-down lists, a submit button and a message
    public AddOrRemoveMonsterFromTeamTab(MonstermonUI controller) {
        super(controller);

        setLayout(new GridBagLayout());
        setBackground(new Color(24, 24, 24));

        gbc = new GridBagConstraints();

        addHeader();
        initializeMonsterBox();
        initializeTeamBox();
        initializeSubmitButton();
        initializeRemoveButton();
        addMessageLabel();
        actionListenerForSubmitButton();
        actionListenerForRemoveButton();
    }

    // MODIFIES: this
    // EFFECTS: adds the header to tell user to choose a monster to add to a team
    private void addHeader() {
        JLabel header = new FancyLabel("Select a monster from the list below, and then choose a team to add it to",
                JLabel.CENTER);

        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 10, 0);
        add(header, gbc);
    }

    // MODIFIES: this
    // EFFECTS: adds the drop-down box for selecting a monster
    private void initializeMonsterBox() {
        monsterList = new FancyBox();

        List<String> monsters = monstermon.getAllMonstersAsStrings();

        for (String name : monsters) {
            monsterList.addItem(name);
        }

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 10, 0);
        add(monsterList, gbc);
    }

    // MODIFIES: this
    // EFFECTS: adds the drop-down box for selecting a team
    private void initializeTeamBox() {
        teamList = new FancyBox();

        List<String> teams = monstermon.getAllTeamsAsStrings();

        for (String name : teams) {
            teamList.addItem(name);
        }

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 10, 0);
        add(teamList, gbc);
    }

    // MODIFIES: this
    // EFFECTS: adds the submit button allowing the user to add a monster to the team
    public void initializeSubmitButton() {
        submitButton = new RoundedButton("Add Monster to Team");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 280, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        add(submitButton, gbc);
    }

    // MODIFIES: this
    // EFFECTS: adds the remove button allowing the user to remove a monster from the team
    public void initializeRemoveButton() {
        removeButton = new RoundedButton("Remove Monster from Team");
        gbc.insets = new Insets(0, 0, 10, 240);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        add(removeButton, gbc);
    }

    // MODIFIES: this
    // EFFECTS: adds the selected monster to the selected team if possible and redirects user back to home page
    //          otherwise sets the message to output red and invalid choice.
    public void actionListenerForSubmitButton() {
        submitButton.addActionListener(e -> {
            String monsterName = "";
            String teamName = "";
            try {
                monsterName = monsterList.getSelectedItem().toString();
                teamName = teamList.getSelectedItem().toString();
            } catch (NullPointerException ex) {
                message.setForeground(new Color(148, 47, 47));
                message.setText("Invalid input. Please try again.");
            }

            addMonsterToTeam(monsterName, teamName);
        });
    }

    // MODIFIES: this
    // EFFECTS: removes the selected monster from the selected team if possible and redirects user back to home page
    //          otherwise sets the message to output red and invalid choice.
    public void actionListenerForRemoveButton() {
        removeButton.addActionListener(e -> {
            String monsterName = "";
            String teamName = "";
            try {
                monsterName = monsterList.getSelectedItem().toString();
                teamName = teamList.getSelectedItem().toString();
            } catch (NullPointerException ex) {
                message.setForeground(new Color(148, 47, 47));
                message.setText("Invalid input. Please try again.");
            }

            removeMonsterFromTeam(monsterName, teamName);
        });
    }

    // MODIFIES: this
    // EFFECTS: adds the selected monster to the selected team
    public void addMonsterToTeam(String monsterName, String teamName) {
        JTabbedPane pane = getController().getTabbedPane();
        if (monstermon.teamAlreadyHasMonster(monsterName, teamName)) {
            message.setForeground(new Color(148, 47, 47));
            message.setText(monsterName + " is already in " + teamName + ".");
        } else if (monsterName != "" && teamName != "") {
            message.setForeground(new Color(30, 61, 52, 255));
            monstermon.addMonsterToTeam(monsterName, teamName);
            message.setText(monsterName + " was added to " + teamName + " successfully.");
            Timer timer = new Timer(1000, ev -> {
                pane.setSelectedIndex(MonstermonUI.HOME_TAB_INDEX);
                message.setText("");
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            message.setForeground(new Color(148, 47, 47));
            message.setText("Invalid input. Please try again.");
        }
    }

    // MODIFIES: this
    // EFFECTS: removes the selected monster from the selected team
    public void removeMonsterFromTeam(String monsterName, String teamName) {
        JTabbedPane pane = getController().getTabbedPane();
        if (!monstermon.teamAlreadyHasMonster(monsterName, teamName)) {
            message.setForeground(new Color(148, 47, 47));
            message.setText(monsterName + " is not in " + teamName + ".");
        } else if (monsterName != "" && teamName != "") {
            message.setForeground(new Color(30, 61, 52, 255));
            monstermon.removeMonsterFromTeam(monsterName, teamName);
            message.setText(monsterName + " was removed from " + teamName + " successfully.");
            Timer timer = new Timer(1000, ev -> {
                pane.setSelectedIndex(MonstermonUI.HOME_TAB_INDEX);
                message.setText("");
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            message.setForeground(new Color(148, 47, 47));
            message.setText("Invalid input. Please try again.");
        }
    }

    // MODIFIES: this
    // EFFECTS: updates the monsters list within this class each time a new monster is created
    //          or the state of the application is loaded
    public void updateMonsterList() {
        monsterList.removeAllItems();

        List<String> monsters = monstermon.getAllMonstersAsStrings();
        for (String name : monsters) {
            monsterList.addItem(name);
        }

        monsterList.revalidate();
        monsterList.repaint();
    }

    // MODIFIES: this
    // EFFECTS: updates the teams list within this class each time a new team is created
    //          or the state of the application is loaded
    public void updateTeamList() {
        teamList.removeAllItems();

        List<String> teams = monstermon.getAllTeamsAsStrings();
        for (String name : teams) {
            teamList.addItem(name);
        }

        teamList.revalidate();
        teamList.repaint();
    }

    // MODIFIES: this
    // EFFECTS: adds the message label that allows user to get some feedback about their monster/team selection
    public void addMessageLabel() {
        message = new FancyLabel("");
        message.setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 15));
        message.setForeground(new Color(30, 61, 52, 255));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        add(message, gbc);
    }

}
