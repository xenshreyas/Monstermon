package ui;

import model.*;
import ui.tabs.*;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

import static javax.swing.UIManager.put;

// Represents the GUI for Monstermon Adventures
public class MonstermonUI extends JFrame {

    public static final int HOME_TAB_INDEX = 0;
    public static final int CREATE_MONSTER_TAB = 1;
    public static final int CREATE_TEAM_TAB = 2;
    public static final int ADD_MONSTER_TO_TEAM_TAB = 3;
    public static final int VIEW_MONSTERS_TAB = 4;
    public static final int VIEW_TEAMS_TAB = 5;

    private static final int WIDTH = 650;
    private static final int HEIGHT = 400;
    private JTabbedPane sidebar;
    private Monstermon monstermon;

    public static void main(String[] args) {
        new MonstermonUI();
    }

    //MODIFIES: this
    //EFFECTS: creates MonstermonUI, displays sidebar and tabs
    public MonstermonUI() {
        super("Monstermon Adventures");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        monstermon = new Monstermon();
        // loadMonstersAndTeams();
        setBackground(new Color(0, 0, 0));

        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.TOP);
        sidebar.setBackground(new Color(0, 0, 0));

        loadTabs();
        add(sidebar);

        setVisible(true);
    }

    //EFFECTS: returns SmartHome object controlled by this UI
    public Monstermon getMonstermon() {
        return monstermon;
    }

    //MODIFIES: this
    //EFFECTS: adds home tab, settings tab and report tab to this UI
    public void loadTabs() {
        JPanel homeTab = new HomeTab(this);
        JPanel newMonsterTab = new NewMonsterTab(this);
        JPanel newTeamTab = new NewTeamTab(this);
        JPanel addMonsterToTeamTab = new AddMonsterToTeamTab(this);
        JPanel viewMonstersTab = new ViewMonstersTab(this);
        JPanel viewTeamsTab = new ViewTeamsTab(this);

        sidebar.add(homeTab, HOME_TAB_INDEX);
        sidebar.setTitleAt(HOME_TAB_INDEX, "Home");
        sidebar.add(newMonsterTab, CREATE_MONSTER_TAB);
        sidebar.setTitleAt(CREATE_MONSTER_TAB, "New Monster");
        sidebar.add(newTeamTab, CREATE_TEAM_TAB);
        sidebar.setTitleAt(CREATE_TEAM_TAB, "New Team");
        sidebar.add(addMonsterToTeamTab, ADD_MONSTER_TO_TEAM_TAB);
        sidebar.setTitleAt(ADD_MONSTER_TO_TEAM_TAB, "Add Monster");
        sidebar.add(viewMonstersTab, VIEW_MONSTERS_TAB);
        sidebar.setTitleAt(VIEW_MONSTERS_TAB, "View Monsters");
        sidebar.add(viewTeamsTab, VIEW_TEAMS_TAB);
        sidebar.setTitleAt(VIEW_TEAMS_TAB, "View Teams");
    }

    //EFFECTS: returns sidebar of this UI
    public JTabbedPane getTabbedPane() {
        return sidebar;
    }

}