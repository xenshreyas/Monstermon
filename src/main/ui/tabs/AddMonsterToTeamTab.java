package ui.tabs;

import ui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMonsterToTeamTab extends Tab {

    private JLabel greeting;

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public AddMonsterToTeamTab(MonstermonUI controller) {
        super(controller);

        setLayout(new GridLayout(3, 1));

        placeGreeting();
    }

    //EFFECTS: creates greeting at top of console
    private void placeGreeting() {
        Icon image = new ImageIcon("/data/ProfessorBackground.png");
        greeting = new JLabel((Icon) image, JLabel.CENTER);
        greeting.setSize(WIDTH, HEIGHT);
        this.add(greeting);
    }

}
