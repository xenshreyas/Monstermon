package ui.tabs;

import ui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeTab extends Tab {

    private static final String INIT_GREETING = "Welcome to Monstermon Adventures!";
    private JLabel greeting;

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public HomeTab(MonstermonUI controller) {
        super(controller);

        setLayout(new GridLayout(3, 1));
        setBackground(new Color(155, 92, 197)); // background of top and bottom 1/3rd

        placeGreeting();
        placeHomeButtons();
    }

    //EFFECTS: creates greeting at top of console
    private void placeGreeting() {
        greeting = new JLabel(INIT_GREETING, JLabel.CENTER);
        greeting.setSize(WIDTH, HEIGHT / 3);
        this.add(greeting);
    }

    //EFFECTS: creates Arrive and Leave buttons that change greeting message when clicked
    private void placeHomeButtons() {
        JButton b1 = new JButton(ButtonNames.CREATEMONSTER.getValue());
        JButton b2 = new JButton(ButtonNames.CREATETEAM.getValue());

        JPanel buttonRow = formatButtonRow(b1);
        buttonRow.add(b2);
        buttonRow.setSize(WIDTH, HEIGHT / 6);

        b1.addActionListener(e -> getController().getTabbedPane().setSelectedIndex(MonstermonUI.CREATE_MONSTER_TAB));

        b2.addActionListener(e -> getController().getTabbedPane().setSelectedIndex(MonstermonUI.CREATE_TEAM_TAB));

        this.add(buttonRow);
    }

}
