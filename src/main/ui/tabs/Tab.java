package ui.tabs;

import model.Monstermon;
import ui.MonstermonUI;

import javax.swing.*;

// Represents a tab
public abstract class Tab extends JPanel {

    private final MonstermonUI controller;
    protected Monstermon monstermon;

    //REQUIRES: MonstermonUI controller that holds this tab
    public Tab(MonstermonUI controller) {
        this.controller = controller;
        monstermon = controller.getMonstermon();
    }

    //EFFECTS: returns the MonstermonUI controller for this tab
    public MonstermonUI getController() {
        return controller;
    }

}
