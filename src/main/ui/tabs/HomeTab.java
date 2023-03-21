package ui.tabs;

import model.Monster;
import model.Monsters;
import model.Team;
import model.Teams;
import persistence.JsonReaderMonsters;
import persistence.JsonReaderTeams;
import persistence.JsonWriterMonsters;
import persistence.JsonWriterTeams;
import ui.*;
import ui.components.FancyLabel;
import ui.components.RoundedButton;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class HomeTab extends Tab {

    private static final String INIT_GREETING = "Monstermon Adventures";
    private JLabel greeting;

    private static final String JSON_STORE_MONSTERS = "./data/monsters.json";
    private static final String JSON_STORE_TEAMS = "./data/teams.json";
    private Monsters monsters;
    private Teams teams;
    private JsonWriterMonsters jsonWriterMonsters;
    private JsonReaderMonsters jsonReaderMonsters;
    private JsonWriterTeams jsonWriterTeams;
    private JsonReaderTeams jsonReaderTeams;

    JButton createMonsterButton;
    JButton createTeamButton;
    JButton viewMonstersButton;
    JButton viewTeamsButton;
    JButton saveButton;
    JButton loadButton;
    JButton addMonsterButton;

    JPanel buttonPanelAbove;
    JPanel buttonPanelMiddle;
    JPanel buttonPanelBelow;

    private JLabel message;

    MonstermonUI controller;

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public HomeTab(MonstermonUI controller) {
        super(controller);
        this.controller = controller;

        jsonWriterMonsters = new JsonWriterMonsters(JSON_STORE_MONSTERS);
        jsonReaderMonsters = new JsonReaderMonsters(JSON_STORE_MONSTERS);
        jsonWriterTeams = new JsonWriterTeams(JSON_STORE_TEAMS);
        jsonReaderTeams = new JsonReaderTeams(JSON_STORE_TEAMS);

        setLayout(new GridLayout(8, 1));
        setBackground(new Color(24,24,24)); // background of top and bottom 1/3rd

        JPanel temp1 = new JPanel();
        temp1.setBackground(new Color(24,24,24));
        add(temp1);

        placeGreeting();

        JPanel temp = new JPanel();
        temp.setBackground(new Color(24,24,24));
        add(temp);

        initializePanels();
        placeHomeButtons();
    }

    private void initializePanels() {
        buttonPanelAbove = new JPanel();
        buttonPanelMiddle = new JPanel();
        buttonPanelBelow = new JPanel();

        buttonPanelAbove.setBackground(new Color(24,24,24));
        buttonPanelMiddle.setBackground(new Color(24,24,24));
        buttonPanelBelow.setBackground(new Color(24,24,24));
    }

    //EFFECTS: creates greeting at top of console
    private void placeGreeting() {
        greeting = new JLabel(INIT_GREETING, JLabel.CENTER);
        greeting.setSize(WIDTH, HEIGHT / 3);
        greeting.setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 30));
        greeting.setBackground(new Color(40,40,40));
        greeting.setForeground(new Color(200, 200, 200));
        this.add(greeting);
    }

    //EFFECTS: creates Arrive and Leave buttons that change greeting message when clicked
    private void placeHomeButtons() {
        createMonsterButton = new RoundedButton(ButtonNames.CREATEMONSTER.getValue());
        createTeamButton = new RoundedButton(ButtonNames.CREATETEAM.getValue());
        viewMonstersButton = new RoundedButton(ButtonNames.VIEWMONSTERS.getValue());
        viewTeamsButton = new RoundedButton(ButtonNames.VIEWTEAMS.getValue());
        saveButton = new RoundedButton(ButtonNames.SAVE.getValue());
        loadButton = new RoundedButton(ButtonNames.LOAD.getValue());
        addMonsterButton = new RoundedButton(ButtonNames.ADDMONSTER.getValue());

        buttonPanelAbove.add(createMonsterButton);
        buttonPanelAbove.add(addMonsterButton);
        buttonPanelAbove.add(createTeamButton);

        buttonPanelMiddle.add(viewMonstersButton);
        buttonPanelMiddle.add(viewTeamsButton);

        buttonPanelBelow.add(saveButton);
        buttonPanelBelow.add(loadButton);

        add(buttonPanelAbove);
        add(buttonPanelMiddle);
        add(buttonPanelBelow);

        message = new FancyLabel("");
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 15));
        add(message);

        actionListener();
    }

    private void actionListener() {
        JTabbedPane pane = getController().getTabbedPane();
        createMonsterButton.addActionListener(e -> pane.setSelectedIndex(MonstermonUI.CREATE_MONSTER_TAB));
        createTeamButton.addActionListener(e -> pane.setSelectedIndex(MonstermonUI.CREATE_TEAM_TAB));
        addMonsterButton.addActionListener(e -> pane.setSelectedIndex(MonstermonUI.ADD_MONSTER_TO_TEAM_TAB));
        viewMonstersButton.addActionListener(e -> pane.setSelectedIndex(MonstermonUI.VIEW_MONSTERS_TAB));
        viewTeamsButton.addActionListener(e -> pane.setSelectedIndex(MonstermonUI.VIEW_TEAMS_TAB));
        saveButton.addActionListener(e -> {
            if (monstermon.getMonsters() != null && monstermon.getTeams() != null) {
                saveState();
                message.setForeground(new Color(30, 61, 52, 255));
                message.setText("Data saved successfully");
            } else {
                message.setForeground(new Color(148, 47, 47));
                message.setText("Please make a monster and team first");
            }
        });
        loadButton.addActionListener(e -> {
            loadState();
            message.setForeground(new Color(30, 61, 52, 255));
            message.setText("Data loaded successfully");
        });
    }

    private void saveState() {
        try {
            jsonWriterMonsters.open();
            jsonWriterMonsters.write(monstermon.getMonsters());
            jsonWriterMonsters.close();
            jsonWriterTeams.open();
            jsonWriterTeams.write(monstermon.getTeams());
            jsonWriterTeams.close();
        } catch (FileNotFoundException e) {
            message.setForeground(new Color(148, 47, 47));
            message.setText("The file was not found");
        }
    }

    // MODIFIES: this
    // EFFECTS: loads monsters and teams from file
    private void loadState() {
        try {
            monsters = jsonReaderMonsters.read();
            monstermon.loadMonsters(monsters.getMonsters());
            teams = jsonReaderTeams.read();
            monstermon.loadTeams(teams.getTeams());
            controller.getAddMonsterToTeamTab().updateTeamList();
            controller.getAddMonsterToTeamTab().updateMonsterList();
        } catch (IOException e) {
            message.setForeground(new Color(148, 47, 47));
            message.setText("The file was not found");
        }
    }

}
