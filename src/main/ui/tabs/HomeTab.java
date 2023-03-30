package ui.tabs;

import model.*;
import persistence.*;
import ui.*;
import ui.components.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

// Represents the HomeTab that the user is normally at
public class HomeTab extends Tab {

    private static final String INIT_GREETING = "Monstermon Adventures";
    private JLabel title;

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

    //EFFECTS: constructs a home tab for console with buttons and the title
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

        placeTitle();

        JPanel temp = new JPanel();
        temp.setBackground(new Color(24,24,24));
        add(temp);

        initializePanels();
        placeButtons();
        actionListener();
    }

    // MODIFIES: this
    // EFFECTS: adds the different panels to the console for alignment of different buttons
    private void initializePanels() {
        buttonPanelAbove = new JPanel();
        buttonPanelMiddle = new JPanel();
        buttonPanelBelow = new JPanel();

        buttonPanelAbove.setBackground(new Color(24,24,24));
        buttonPanelMiddle.setBackground(new Color(24,24,24));
        buttonPanelBelow.setBackground(new Color(24,24,24));
    }

    // MODIFIES: this
    // EFFECTS: creates the title at top of console
    private void placeTitle() {
        title = new JLabel(INIT_GREETING, JLabel.CENTER);
        title.setSize(WIDTH, HEIGHT / 3);
        title.setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 30));
        title.setBackground(new Color(40,40,40));
        title.setForeground(new Color(200, 200, 200));
        this.add(title);
    }

    // MODIFIES: this
    // EFFECTS: places the buttons for each of the tabs onto the console, as well as the message that is to be
    //          displayed to the user
    private void placeButtons() {
        createMonsterButton = new RoundedButton(ButtonNames.CREATEMONSTER.getValue());
        createTeamButton = new RoundedButton(ButtonNames.CREATETEAM.getValue());
        viewTeamsButton = new RoundedButton(ButtonNames.VIEWTEAMS.getValue());
        saveButton = new RoundedButton(ButtonNames.SAVE.getValue());
        loadButton = new RoundedButton(ButtonNames.LOAD.getValue());
        addMonsterButton = new RoundedButton(ButtonNames.ADDMONSTER.getValue());

        buttonPanelAbove.add(createMonsterButton);
        buttonPanelAbove.add(addMonsterButton);
        buttonPanelAbove.add(createTeamButton);

        buttonPanelBelow.add(viewTeamsButton);

        buttonPanelMiddle.add(saveButton);
        buttonPanelMiddle.add(loadButton);

        add(buttonPanelAbove);
        add(buttonPanelMiddle);
        add(buttonPanelBelow);

        message = new FancyLabel("");
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 15));
        add(message);
    }

    // MODIFIES: this
    // EFFECTS: redirects user to the chosen page. If save button is clicked, makes sure that the monsters
    //          and teams are not null, and saves the data. If not, prompts the user to first make a monster
    //          and a team. If load button is clicked, loads the state of the application
    private void actionListener() {
        JTabbedPane pane = getController().getTabbedPane();
        createMonsterButton.addActionListener(e -> pane.setSelectedIndex(MonstermonUI.CREATE_MONSTER_TAB));
        createTeamButton.addActionListener(e -> pane.setSelectedIndex(MonstermonUI.CREATE_TEAM_TAB));
        addMonsterButton.addActionListener(e -> pane.setSelectedIndex(MonstermonUI.ADD_MONSTER_TO_TEAM_TAB));
//        viewMonstersButton.addActionListener(e -> pane.setSelectedIndex(MonstermonUI.VIEW_MONSTERS_TAB));
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

    // MODIFIES: this
    // EFFECTS: saves the current state of the application, and displays to the user if the file was not found
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
    // EFFECTS: loads the current state of the application, and displays to the user if the file was not found
    private void loadState() {
        try {
            monsters = jsonReaderMonsters.read();
            monstermon.loadMonsters(monsters.getMonsters());
            teams = jsonReaderTeams.read();
            monstermon.loadTeams(teams.getTeams());
            controller.getAddMonsterToTeamTab().updateTeamList();
            controller.getAddMonsterToTeamTab().updateMonsterList();
            controller.getViewTeamsTab().updateTeamList();
        } catch (IOException e) {
            message.setForeground(new Color(148, 47, 47));
            message.setText("The file was not found");
        }
    }

}
