package ui;

import model.*;
import model.Event;
import ui.tabs.*;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

// adapted from: https://github.students.cs.ubc.ca/CPSC210/LongFormProblemStarters.git

// Represents the GUI for Monstermon Adventures
public class MonstermonUI extends JFrame {

    public static final int HOME_TAB_INDEX = 0;
    public static final int CREATE_MONSTER_TAB = 1;
    public static final int CREATE_TEAM_TAB = 2;
    public static final int ADD_MONSTER_TO_TEAM_TAB = 3;
//    public static final int VIEW_MONSTERS_TAB = 4;
    public static final int VIEW_TEAMS_TAB = 4;

    private static final int WIDTH = 650;
    private static final int HEIGHT = 400;
    private JTabbedPane sidebar;
    private Monstermon monstermon;

    private ManipulateMonstersTab manipulateMonstersTab;
    private ViewTeamsTab viewTeamsTab;

    // EFFECTS: runs the MonstermonUI
    public static void main(String[] args) {
        new MonstermonUI();
    }

    //MODIFIES: this
    //EFFECTS: creates MonstermonUI, displays sidebar and tabs
    public MonstermonUI() {
        super("Monstermon Adventures");
        setSize(WIDTH, HEIGHT);
        addCloseEvent();
        setResizable(false);
        monstermon = new Monstermon();
        setBackground(new Color(0, 0, 0));

        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.TOP);
        sidebar.setBackground(new Color(24, 24, 24));
        sidebar.setForeground(new Color(153, 119, 227));
        sidebar.setOpaque(true);

        loadTabs();
        add(sidebar);

        setVisible(true);
    }

    //EFFECTS: returns Monstermon object controlled by this UI
    public Monstermon getMonstermon() {
        return monstermon;
    }

    //MODIFIES: this
    //EFFECTS: adds home tab, newMonsterTab, newTeamTab, viewMonstersTab and viewTeamsTab to this UI
    public void loadTabs() {
        JPanel homeTab = new HomeTab(this);
        JPanel newMonsterTab = new NewMonsterTab(this);
        JPanel newTeamTab = new NewTeamTab(this);
        manipulateMonstersTab = new ManipulateMonstersTab(this);
        JPanel viewMonstersTab = new ViewMonstersTab(this);
        viewTeamsTab = new ViewTeamsTab(this);

        sidebar.add(homeTab, HOME_TAB_INDEX);
        sidebar.setTitleAt(HOME_TAB_INDEX, "Home");
        sidebar.add(newMonsterTab, CREATE_MONSTER_TAB);
        sidebar.setTitleAt(CREATE_MONSTER_TAB, "New Monster");
        sidebar.add(newTeamTab, CREATE_TEAM_TAB);
        sidebar.setTitleAt(CREATE_TEAM_TAB, "New Team");
        sidebar.add(manipulateMonstersTab, ADD_MONSTER_TO_TEAM_TAB);
        sidebar.setTitleAt(ADD_MONSTER_TO_TEAM_TAB, "Monsters");
//        sidebar.add(viewMonstersTab, VIEW_MONSTERS_TAB);
//        sidebar.setTitleAt(VIEW_MONSTERS_TAB, "View Monsters");
        sidebar.add(viewTeamsTab, VIEW_TEAMS_TAB);
        sidebar.setTitleAt(VIEW_TEAMS_TAB, "Teams");
    }

    //EFFECTS: returns sidebar of this UI
    public JTabbedPane getTabbedPane() {
        return sidebar;
    }

    // EFFECTS: returns the AddMonsterToTeamTab associated with this UI
    public ManipulateMonstersTab getAddMonsterToTeamTab() {
        return manipulateMonstersTab;
    }

    public ViewTeamsTab getViewTeamsTab() {
        return viewTeamsTab;
    }

    public void addCloseEvent() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                Iterator eventIterator = EventLog.getInstance().iterator();
                while (eventIterator.hasNext()) {
                    Event event = (Event) eventIterator.next();
                    System.out.println(event.getDescription());
                }
                dispose();
            }
        });
    }

}