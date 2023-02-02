package model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private final List<Monster> monsters;

    public Team(String name) {
        this.name = name;
        monsters = new ArrayList<>();
    }

    //getters
    public String getTeamName() {
        return this.name;
    }

    public List<Monster> getAllMonsters() {
        return this.monsters;
    }

    //MODIFIES: this
    //EFFECTS: adds the monster to this team
    public boolean addMonsterToTeam(Monster monster) {
        if (monsters.size() <= 4) {
            if (monsters.contains(monster)) {
                return false;
            }

            this.monsters.add(monster);
            //NO MORE MONSTERS CAN BE ADDED
            return true;
        }
        return false;
    }

    //MODIFIES: this
    //EFFECTS: removes the monster from this team
    public boolean removeMonsterFromTeam(Monster monster) {
        if (monsters.size() > 0) {
            if (monsters.contains(monster)) {
                this.monsters.remove(monster);
                return true;
            }
        }
        return false;
    }

    //MODIFIES: this
    //EFFECTS: renames this team to given name
    public void renameTeam(String name) {
        this.name = name;
    }
}
