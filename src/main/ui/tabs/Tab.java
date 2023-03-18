package ui.tabs;

import ui.MonstermonUI;

import javax.swing.*;
import java.awt.*;

// adapted from: https://github.students.cs.ubc.ca/CPSC210/LongFormProblemStarters.git

// Represents a tab
public abstract class Tab extends JPanel {

    private final MonstermonUI controller;

    //REQUIRES: MonstermonUI controller that holds this tab
    public Tab(MonstermonUI controller) {
        this.controller = controller;
    }

    //EFFECTS: returns the MonstermonUI controller for this tab
    public MonstermonUI getController() {
        return controller;
    }

}
