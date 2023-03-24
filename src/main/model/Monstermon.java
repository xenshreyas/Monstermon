package model;

import java.util.ArrayList;
import java.util.List;

public class Monstermon {

    private List<Monster> monsterList;
    private List<Team> teamList;

    private Monsters monsters;
    private Teams teams;

    public Monstermon() {
        monsterList = new ArrayList<>();
        teamList = new ArrayList<>();
        monsters = new Monsters();
        teams = new Teams();
    }

    public List<Monster> getAllMonsters() {
        return monsterList;
    }

    public List<String> getAllMonstersAsStrings() {
        List<String> monsterNames = new ArrayList<>();
        for (Monster m : monsterList) {
            monsterNames.add(m.getName());
        }
        return monsterNames;
    }

    public List<String> getAllTeamsAsStrings() {
        List<String> teamNames = new ArrayList<>();
        for (Team t : teamList) {
            teamNames.add(t.getName());
        }
        return teamNames;
    }

    public List<Team> getAllTeams() {
        return teamList;
    }

    //MODIFIES: this
    //EFFECTS: adds an appliance to SmartHome
    public void addMonster(Monster m) {
        monsterList.add(m);
        monsters.addMonster(m);
    }

    //MODIFIES: this
    //EFFECTS: adds an appliance to SmartHome
    public void addTeam(Team t) {
        teamList.add(t);
        teams.addTeam(t);
    }

    public void addMonsterToTeam(String monsterName, String teamName) {
        for (Monster m : monsterList) {
            for (Team t : teamList) {
                if (m.getName().equals(monsterName) && t.getName().equals(teamName)) {
                    t.addMonsterToTeam(m);
                }
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
        } else {
            return false;
        }
    }

    public Monster findMonster(String monsterName) {
        for (Monster m : monsterList) {
            if (m.getName().equals(monsterName)) {
                return m;
            }
        }
        return null;
    }

    public Team findTeam(String teamName) {
        for (Team t : teamList) {
            if (t.getName().equals(teamName)) {
                return t;
            }
        }
        return null;
    }

    public void loadMonsters(List<Monster> monsterList) {
        for (Monster m : monsterList) {
            this.monsterList.add(m);
            this.monsters.addMonster(m);
        }
    }

    public void loadTeams(List<Team> teamList) {
        for (Team t : teamList) {
            this.teamList.add(t);
            this.teams.addTeam(t);
        }
    }

    public Monsters getMonsters() {
        return this.monsters;
    }

    public Teams getTeams() {
        return this.teams;
    }
}
