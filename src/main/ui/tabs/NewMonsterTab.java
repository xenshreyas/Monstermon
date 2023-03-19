package ui.tabs;

import model.Monster;
import model.Monstermon;
import ui.*;
import ui.components.FancyField;
import ui.components.FancyLabel;
import ui.components.RoundedButton;
import ui.components.SubmitButton;

import javax.swing.*;
import java.awt.*;

import static model.MonsterType.*;

public class NewMonsterTab extends Tab {

    private JTextField nameField;
    private JTextField typeField;
    private JTextField healthField;
    JButton submitButton;
    GridBagConstraints gbc;

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public NewMonsterTab(MonstermonUI controller) {
        super(controller);

        setLayout(new GridBagLayout());
        setBackground(new Color(24, 24, 24)); // background of top and bottom 1/3rd
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5); // add spacing between components

        initialize();
        initializeButton();
    }

    public void initialize() {

        JLabel nameLabel = new FancyLabel("Name:");
        JLabel typeLabel = new FancyLabel("Type:");
        JLabel healthLabel = new FancyLabel("Health Points:");

        nameLabel.setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 15));
        typeLabel.setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 15));
        healthLabel.setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 15));

        nameField = new FancyField(20);
        typeField = new FancyField(20);
        healthField = new FancyField(20);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(nameLabel, gbc);
        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(typeLabel, gbc);
        gbc.gridx = 1;
        add(typeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(healthLabel, gbc);
        gbc.gridx = 1;
        add(healthField, gbc);
    }

    public void initializeButton() {
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        submitButton = new RoundedButton("Create Monster");
        submitButton.setPreferredSize(new Dimension(150, 30));
        add(submitButton, gbc);
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
            Monster m = makeMonster(getName(), getType(), getHealthPoints());
            nameField.setText("");
            typeField.setText("");
            healthField.setText("");

            pane.setSelectedIndex(MonstermonUI.HOME_TAB_INDEX);
            if (!(m == null)) {
                // add monster to entries
            }
        });
    }

    private Monster makeMonster(String name, String mtype, int hp) {
        if (name.equals("") || hp == 0 || hp > 400) {
            return null;
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
            return null;
        }
        monstermon.addMonster(m);
        return m;
    }

}
