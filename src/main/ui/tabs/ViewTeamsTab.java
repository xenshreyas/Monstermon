package ui.tabs;

import ui.*;

import javax.swing.*;
import java.awt.*;

// adapted from: https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html

// Represents the View Teams tab, allowing the user to view their teams
public class ViewTeamsTab extends Tab {

    private GridBagConstraints gbc;

    // MODIFIES: this
    // EFFECTS: initializes the NewMonsterTab
    public ViewTeamsTab(MonstermonUI controller) {
        super(controller);
        setLayout(new GridBagLayout());
        setBackground(new Color(24, 24, 24));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        initialize();
    }

    // MODIFIES: this
    // EFFECTS: initializes the View Teams Tab
    public void initialize() {

    }

}
