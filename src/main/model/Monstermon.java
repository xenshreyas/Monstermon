package model;

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

    public List<String> getAllTeamsAsStrings() {
        List<String> teamNames = new ArrayList<>();
        for (Team t : teams) {
            teamNames.add(t.getName());
        }
        return teamNames;
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

    public void addMonsterToTeam(String monsterName, String teamName) {
        for (Monster m : monsters) {
            for (Team t : teams) {
                if (m.getName().equals(monsterName) && t.getName().equals(teamName)) {
                    t.addMonsterToTeam(m);
                }
            }
        }
    }

    public void printEverything() {
        for (Team t : teams) {
            for (Monster m : t.getAllMonsters()) {
                System.out.println(m.getName());
            }
        }
    }

    public boolean teamAlreadyHasMonster(String monsterName, String teamName) {
        Monster m = findMonster(monsterName);
        Team t = findTeam(teamName);

        if (m == null || t == null) {
            return false;
        }

        if (t.getAllMonsters().contains(m)) {
            return true;
        }
        return false;
    }

    public Monster findMonster(String monsterName) {
        for (Monster m : monsters) {
            if (m.getName().equals(monsterName)) {
                return m;
            }
        }
        return null;
    }

    public Team findTeam(String teamName) {
        for (Team t : teams) {
            if (t.getName().equals(teamName)) {
                return t;
            }
        }
        return null;
    }
}
