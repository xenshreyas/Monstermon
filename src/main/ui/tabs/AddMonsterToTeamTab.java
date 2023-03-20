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

public class AddMonsterToTeamTab extends Tab {

    private JButton submitButton;
    private JComboBox<String> monsterList;
    private JComboBox<String> teamList;
    private JLabel message;
    private GridBagConstraints gbc;
    private List<Monster> monsters = monstermon.getAllMonsters();
    private List<Team> teams = monstermon.getAllTeams();

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public AddMonsterToTeamTab(MonstermonUI controller) {
        super(controller);

        setLayout(new GridBagLayout());
        setBackground(new Color(24, 24, 24));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        gbc = new GridBagConstraints();

        addHeader();
        initializeMonsterBox();
        initializeTeamBox();
        initializeSubmitButton();
        addMessageLabel();
        actionListener();
    }

    private void addHeader() {
        JLabel header = new FancyLabel("Select a monster from the list below, and then choose a team to add it to",
                JLabel.CENTER);

        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 10, 0);
        add(header, gbc);
    }

    private void initializeMonsterBox() {
        monsterList = new FancyBox();
        monsterList.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

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

    private void initializeTeamBox() {
        teamList = new FancyBox();
        teamList.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

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

    public void initializeSubmitButton() {
        submitButton = new RoundedButton("Add Monster to Team");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        add(submitButton, gbc);
    }

    public void actionListener() {
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

    public void addMonsterToTeam(String monsterName, String teamName) {
        JTabbedPane pane = getController().getTabbedPane();
        if (monstermon.teamAlreadyHasMonster(monsterName, teamName)) {
            message.setForeground(new Color(148, 47, 47));
            message.setText(monsterName + " is already in " + teamName + ".");
        } else if (monsterName != "" && teamName != "") {
            message.setForeground(new Color(30, 61, 52, 255));
            monstermon.addMonsterToTeam(monsterName, teamName);
            monstermon.printEverything();
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

    public void updateMonsterList() {
        monsterList.removeAllItems();

        List<String> monsters = monstermon.getAllMonstersAsStrings();
        for (String name : monsters) {
            monsterList.addItem(name);
        }

        monsterList.revalidate();
        monsterList.repaint();
    }

    public void updateTeamList() {
        teamList.removeAllItems();

        List<String> teams = monstermon.getAllTeamsAsStrings();
        for (String name : teams) {
            teamList.addItem(name);
        }

        teamList.revalidate();
        teamList.repaint();
    }

    public void addMessageLabel() {
        message = new FancyLabel("");
        message.setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 15));
        message.setForeground(new Color(30, 61, 52, 255));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        add(message, gbc);
    }

}
