package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Represents a team of monsters, with a name and a List of monsters
public class Team implements Writable {

    private String name;
    private final List<Monster> monsters;

    public Team(String name) {
        this.name = name;
        monsters = new ArrayList<>();
    }

    //getters

    // EFFECTS: gets the name of this team
    public String getName() {
        return this.name;
    }

    // EFFECTS: gets the list of all monsters on this team
    public List<Monster> getAllMonsters() {
        return this.monsters;
    }

    // MODIFIES: this
    // EFFECTS: adds the monster to this team
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

    // EFFECTS: returns true if two teams are the same, else false
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Team team = (Team) o;
        return name.equals(team.name) && monsters.equals(team.monsters);
    }

    // EFFECTS: generates hashCode for the team
    @Override
    public int hashCode() {
        return Objects.hash(name, monsters);
    }

    // MODIFIES: this
    // EFFECTS: removes the monster from this team
    public boolean removeMonsterFromTeam(Monster monster) {
        if (monsters.size() > 0) {
            if (monsters.contains(monster)) {
                this.monsters.remove(monster);
                return true;
            }
        }
        return false;
    }

    // MODIFIES: this
    // EFFECTS: renames this team to given name
    public void renameTeam(String name) {
        this.name = name;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("monsters", monsters);
        return json;
    }

}
