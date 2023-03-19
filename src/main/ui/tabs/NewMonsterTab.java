package ui.tabs;

import model.Monster;
import ui.*;
import ui.components.FancyField;
import ui.components.FancyLabel;
import ui.components.SubmitButton;

import javax.swing.*;
import java.awt.*;

import static model.MonsterType.*;

public class NewMonsterTab extends Tab {

    private JTextField nameField;
    private JTextField typeField;
    private JTextField healthField;
    JButton submitButton;

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public NewMonsterTab(MonstermonUI controller) {
        super(controller);

        setLayout(new GridLayout(4, 1));
        setBackground(new Color(24, 24, 24)); // background of top and bottom 1/3rd
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        initializeLabels();
        actionListener();
    }

    public void initializeLabels() {
        JLabel nameLabel = new FancyLabel("Name:");
        JLabel typeLabel = new FancyLabel("Type:");
        JLabel healthLabel = new FancyLabel("Health Points:");

        nameField = new FancyField();
        typeField = new FancyField();
        healthField = new FancyField();

        add(nameLabel);
        add(nameField);
        add(typeLabel);
        add(typeField);
        add(healthLabel);
        add(healthField);

        submitButton = new SubmitButton("Create Monster");
        add(new JLabel());
        add(submitButton);
    }

    public String getName() {
        return nameField.getText();
    }

    public String getType() {
        return typeField.getText();
    }

    public int getHealthPoints() {
        String healthStr = healthField.getText();
        try {
            return Integer.parseInt(healthStr);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void actionListener() {
        JTabbedPane pane = getController().getTabbedPane();
        submitButton.addActionListener(e -> {
            makeMonster(getName(), getType(), getHealthPoints());
            nameField.setText("");
            typeField.setText("");
            healthField.setText("");

            pane.setSelectedIndex(MonstermonUI.HOME_TAB_INDEX);
        });
    }

    private void makeMonster(String name, String mtype, int hp) {
        if (name.equals("") || hp == 0 || hp > 400) {
            return;
        }
        Monster m;
        String type = mtype.toLowerCase();
        if (type.equals("fire")) {
            m = new Monster(name, FIRE, hp);
        } else if (type.equals("water")) {
            m = new Monster(name, WATER, hp);
        } else if (type.equals("grass")) {
            m = new Monster(name, GRASS, hp);
        } else {
            return;
        }
        monstermon.addMonster(m);
    }

}
