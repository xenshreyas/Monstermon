package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.Objects;

// Represents a monster having a name, type and health points
public class Monster implements Writable {

    private String name;
    private MonsterType type;
    private int healthPoints;

    // EFFECTS: returns true if two monsters are the same, else false
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Monster monster = (Monster) o;
        return healthPoints == monster.healthPoints && name.equals(monster.name) && type == monster.type;
    }

    // EFFECTS: generates hashCode for the monster
    @Override
    public int hashCode() {
        return Objects.hash(name, type, healthPoints);
    }

    public Monster(String name) {
        this.name = name;
    }

    // REQUIRES: healthPoints > 0
    public Monster(String name, MonsterType type, int healthPoints) {
        this.name = name;
        this.type = type;
        this.healthPoints = healthPoints;
    }

    //getters

    // EFFECTS: gets the name of this monster
    public String getName() {
        return this.name;
    }

    // EFFECTS: gets the type of this monster
    public MonsterType getType() {
        return this.type;
    }

    // EFFECTS: gets the health points of this monster
    public int getHealthPoints() {
        return this.healthPoints;
    }

    //setters

    // MODIFIES: this
    // EFFECTS: renames this monster to given name
    public void renameMonster(String name) {
        this.name = name;
    }

    // MODIFIES: this
    // EFFECTS: sets the monster's type to the given type
    public void setType(MonsterType type) {
        this.type = type;
    }

    // REQUIRES: healthPoints > 0
    // MODIFIES: this
    // EFFECTS: sets the monster's health points to the given health points
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("type", type);
        json.put("healthPoints", healthPoints);
        return json;
    }

}
