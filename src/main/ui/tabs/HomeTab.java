package ui.tabs;

import ui.*;
import ui.BetterComponents.RoundedButton;

import javax.swing.*;
import java.awt.*;

public class HomeTab extends Tab {

    private static final String INIT_GREETING = "Monstermon Adventures";
    private JLabel greeting;
    JButton createMonsterButton;
    JButton createTeamButton;
    JButton viewMonstersButton;
    JButton viewTeamsButton;
    JButton saveButton;
    JButton loadButton;
    JButton addMonsterButton;

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public HomeTab(MonstermonUI controller) {
        super(controller);

        setLayout(new GridLayout(8, 1));
        setBackground(new Color(24,24,24)); // background of top and bottom 1/3rd

        JPanel temp1 = new JPanel();
        temp1.setBackground(new Color(24,24,24));
        add(temp1);

        placeGreeting();

        JPanel temp = new JPanel();
        temp.setBackground(new Color(24,24,24));
        add(temp);

        placeHomeButtons();
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
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void placeHomeButtons() {
        createMonsterButton = new RoundedButton(ButtonNames.CREATEMONSTER.getValue());
        createTeamButton = new RoundedButton(ButtonNames.CREATETEAM.getValue());
        viewMonstersButton = new RoundedButton(ButtonNames.VIEWMONSTERS.getValue());
        viewTeamsButton = new RoundedButton(ButtonNames.VIEWTEAMS.getValue());
        saveButton = new RoundedButton(ButtonNames.SAVE.getValue());
        loadButton = new RoundedButton(ButtonNames.LOAD.getValue());
        addMonsterButton = new RoundedButton(ButtonNames.ADDMONSTER.getValue());

        JPanel buttonPanelAbove = new JPanel();
        JPanel buttonPanelMiddle = new JPanel();
        JPanel buttonPanelBelow = new JPanel();

        buttonPanelAbove.setBackground(new Color(24,24,24));
        buttonPanelMiddle.setBackground(new Color(24,24,24));
        buttonPanelBelow.setBackground(new Color(24,24,24));

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
        actionListener();
    }

    private void actionListener() {
        JTabbedPane pane = getController().getTabbedPane();
        createMonsterButton.addActionListener(e -> pane.setSelectedIndex(MonstermonUI.CREATE_MONSTER_TAB));
        createTeamButton.addActionListener(e -> pane.setSelectedIndex(MonstermonUI.CREATE_TEAM_TAB));
        addMonsterButton.addActionListener(e -> pane.setSelectedIndex(MonstermonUI.ADD_MONSTER_TO_TEAM_TAB));
        viewMonstersButton.addActionListener(e -> pane.setSelectedIndex(MonstermonUI.VIEW_MONSTERS_TAB));
        viewTeamsButton.addActionListener(e -> pane.setSelectedIndex(MonstermonUI.VIEW_TEAMS_TAB));
//        saveButton.addActionListener(e -> saveState());
//        loadButton.addActionListener(e -> loadState());
    }

}
