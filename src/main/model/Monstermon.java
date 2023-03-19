package model;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class Monstermon {

    private List<Monster> monsters;
    private List<Team> teams;

    public Monstermon() {
        monsters = new ArrayList<>();
        teams = new ArrayList<>();
    }

    public List<Monster> getAllMonsters() {
        return monsters;
    }

    public List<String> getAllMonstersAsStrings() {
        List<String> monsterNames = new ArrayList<>();
        for (Monster m : monsters) {
            monsterNames.add(m.getName());
        }
        return monsterNames;
    }

    public List<Team> getAllTeams() {
        return teams;
    }

    //MODIFIES: this
    //EFFECTS: adds an appliance to SmartHome
    public void addMonster(Monster m) {
        monsters.add(m);
    }

    //MODIFIES: this
    //EFFECTS: adds an appliance to SmartHome
    public void addTeam(Team t) {
        teams.add(t);
    }

}
