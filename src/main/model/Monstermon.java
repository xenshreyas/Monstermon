package model;

import java.util.ArrayList;
import java.util.List;

// Represents the Monstermon class, which has a monsterList, teamList, monsters and teams
public class Monstermon {

    private List<Monster> monsterList;
    private List<Team> teamList;

    private Monsters monsters;
    private Teams teams;

    // MODIFIES: this
    // EFFECTS: creates a new Monstermon object
    public Monstermon() {
        monsterList = new ArrayList<>();
        teamList = new ArrayList<>();
        monsters = new Monsters();
        teams = new Teams();
    }

    // EFFECTS: returns the list of monsters
    public List<Monster> getAllMonsters() {
        return monsterList;
    }

    // EFFECTS: returns the list of all monster names
    public List<String> getAllMonstersAsStrings() {
        List<String> monsterNames = new ArrayList<>();
        for (Monster m : monsterList) {
            monsterNames.add(m.getName());
        }
        return monsterNames;
    }

    // EFFECTS: returns the list of all team names
    public List<String> getAllTeamsAsStrings() {
        List<String> teamNames = new ArrayList<>();
        for (Team t : teamList) {
            teamNames.add(t.getName());
        }
        return teamNames;
    }

    // EFFECTS: returns the list of all teams
    public List<Team> getAllTeams() {
        return teamList;
    }

    // MODIFIES: this
    // EFFECTS: adds a monster to the monsterList, and to monsters
    public void addMonster(Monster m) {
        monsterList.add(m);
        monsters.addMonster(m);
    }

    // MODIFIES: this
    // EFFECTS: adds a team to the teamList, and to teams
    public void addTeam(Team t) {
        teamList.add(t);
        teams.addTeam(t);
    }

    // MODIFIES: this
    // EFFECTS: finds the given monster by name, and team by name, and then adds that monster to the team
    public void addMonsterToTeam(String monsterName, String teamName) {
        for (Monster m : monsterList) {
            for (Team t : teamList) {
                if (m.getName().equals(monsterName) && t.getName().equals(teamName)) {
                    t.addMonsterToTeam(m);
                }
            }
        }
    }

    // EFFECTS: returns true if the given team has the given monster (specified by their names)
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

    // EFFECTS: returns the monster that has the same name as monsterName
    public Monster findMonster(String monsterName) {
        for (Monster m : monsterList) {
            if (m.getName().equals(monsterName)) {
                return m;
            }
        }
        return null;
    }

    // EFFECTS: returns the team that has the same name as teamName
    public Team findTeam(String teamName) {
        for (Team t : teamList) {
            if (t.getName().equals(teamName)) {
                return t;
            }
        }
        return null;
    }

    // MODIFIES: this
    // EFFECTS: for every monster in the parameter monsterList, adds that monster to monsterList and also to monsters
    public void loadMonsters(List<Monster> monsterList) {
        for (Monster m : monsterList) {
            this.monsterList.add(m);
            this.monsters.addMonster(m);
        }
    }

    // MODIFIES: this
    // EFFECTS: for every team in the parameter teamList, adds that team to teamList and also to teams
    public void loadTeams(List<Team> teamList) {
        for (Team t : teamList) {
            this.teamList.add(t);
            this.teams.addTeam(t);
        }
    }

    // EFFECTS: returns monsters
    public Monsters getMonsters() {
        return this.monsters;
    }

    // EFFECTS: returns teams
    public Teams getTeams() {
        return this.teams;
    }
}
