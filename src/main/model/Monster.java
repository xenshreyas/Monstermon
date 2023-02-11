package model;

public class Monster {

    private String name;
    private MonsterType type;
    private int healthPoints;

    private final int baseDamage = 50;

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
}
