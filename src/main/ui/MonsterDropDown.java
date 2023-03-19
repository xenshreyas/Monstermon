package ui;

import model.Monster;
import model.MonsterType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MonsterDropDown extends JFrame {

    private JComboBox<String> monsterList;

    public MonsterDropDown(List<String> monsters) {
        super("Monster DropDown");

        monsterList = new JComboBox<>();
        // Create the monster list
        for (String name : monsters) {
            monsterList.addItem(name);
        }

        // Add the list to the content pane
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(monsterList, BorderLayout.CENTER);

        // Set the size and show the frame
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create a list of monsters
        List<Monster> monsters = List.of(new Monster("Monster1", MonsterType.GRASS, 10),
                new Monster("Monster2", MonsterType.FIRE, 20),
                new Monster("Monster3", MonsterType.WATER, 30));
        List<String> names = new ArrayList<>();
        for (Monster m : monsters) {
            names.add(m.getName());
        }
        // Create the drop-down frame and pass in the monster list
        new MonsterDropDown(names);
    }
}
