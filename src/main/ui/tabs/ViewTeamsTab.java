package ui.tabs;

import model.Monster;
import model.Team;
import ui.*;
import ui.components.FancyBox;
import ui.components.FancyLabel;
import ui.components.RoundedButton;

import javax.swing.*;
import java.util.List;
import java.awt.*;

// adapted from: https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html

// Represents the View Teams Tab
public class ViewTeamsTab extends Tab {

    private JButton submitButton;
    private JComboBox<String> teamList;
    private GridBagConstraints gbc;
    private List<Monster> monsters = monstermon.getAllMonsters();
    private List<Team> teams = monstermon.getAllTeams();
    private JLabel message;

    // MODIFIES: this
    // EFFECTS: constructs the ViewTeamTab tab for with a drop-down list, a submit button and a message
    public ViewTeamsTab(MonstermonUI controller) {
        super(controller);

        setLayout(new GridBagLayout());
        setBackground(new Color(24, 24, 24));

        gbc = new GridBagConstraints();

        addHeader();
        initializeTeamBox();
        initializeSubmitButton();
        addMessageLabel();
        actionListener();
    }

    // MODIFIES: this
    // EFFECTS: adds the header to tell user to choose a team whose monsters the user would like to view
    private void addHeader() {
        JLabel header = new FancyLabel("Select the Team whose Monsters would you like to view",
                JLabel.CENTER);

        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 10, 0);
        add(header, gbc);
    }

    // MODIFIES: this
    // EFFECTS: adds the drop-down box for selecting a team
    private void initializeTeamBox() {
        teamList = new FancyBox();

        List<String> teams = monstermon.getAllTeamsAsStrings();

        for (String name : teams) {
            teamList.addItem(name);
        }

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 10, 0);
        add(teamList, gbc);
    }

    // MODIFIES: this
    // EFFECTS: adds the submit button allowing the user to view monsters in chosen team
    public void initializeSubmitButton() {
        submitButton = new RoundedButton("View Monsters");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        add(submitButton, gbc);
    }

    // MODIFIES: this
    // EFFECTS: sets the message to be the names of monsters in the given team
    public void setMessage(List<Monster> monstersInThisTeam) {
        String string = "[";
        for (Monster m : monstersInThisTeam) {
            if (monstersInThisTeam.indexOf(m) == monstersInThisTeam.size() - 1) {
                string = string + m.getName();
            } else {
                string = string + m.getName() + ", ";
            }
        }
        string = string + "]";
        message.setForeground(new Color(30, 61, 52, 255));
        message.setText(string);
    }

    // MODIFIES: this
    // EFFECTS: displays all the monsters within the chosen team. if chosen team is empty, displays error message
    public void actionListener() {
        submitButton.addActionListener(e -> {
            String teamName;
            try {
                teamName = teamList.getSelectedItem().toString();
                List<Monster> monstersInThisTeam = monstermon.findTeam(teamName).getAllMonsters();
                if (monstersInThisTeam.size() == 0) {
                    message.setForeground(new Color(148, 47, 47));
                    message.setText("There are no monsters in this team.");
                } else {
                    setMessage(monstersInThisTeam);
                }
            } catch (NullPointerException ex) {
                message.setForeground(new Color(148, 47, 47));
                message.setText("Please create a team first.");
            }

        });
    }

    // MODIFIES: this
    // EFFECTS: updates the teams list within this class each time a new team is created
    //          or the state of the application is loaded
    public void updateTeamList() {
        teamList.removeAllItems();

        List<String> teams = monstermon.getAllTeamsAsStrings();
        for (String name : teams) {
            teamList.addItem(name);
        }

        teamList.revalidate();
        teamList.repaint();
    }

    // MODIFIES: this
    // EFFECTS: adds the message label that displays monsters within current team
    public void addMessageLabel() {
        message = new FancyLabel("");
        message.setFont(new Font("Nanum Myeongjo", Font.CENTER_BASELINE, 15));
        message.setForeground(new Color(30, 61, 52, 255));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        add(message, gbc);
    }

}
