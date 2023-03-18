package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.MonsterType.*;
import static org.junit.jupiter.api.Assertions.*;

// Testing class for methods in the Monster Class
class MonsterTest {
    private Monster testMonster;
    private String testName;
    private MonsterType testMonsterType;
    private int testHealthPoints;

    @BeforeEach
    public void setup() {
        testName = "Bulbasaur";
        testMonsterType = GRASS;
        testHealthPoints = 45;
        testMonster = new Monster(testName, testMonsterType, testHealthPoints);
    }

    @Test
    public void testGetName() {
        assertEquals(testName, testMonster.getName());
    }

    @Test
    public void testGetType() {
        assertEquals(testMonsterType, testMonster.getType());
    }

    @Test
    public void testGetHealthPoints() {
        assertEquals(testHealthPoints, testMonster.getHealthPoints());
    }

    @Test
    public void testRenameMonster() {
        assertEquals(testName, testMonster.getName());
        testMonster.renameMonster("Squirtle");
        assertEquals("Squirtle", testMonster.getName());
    }

    @Test
    public void testSetType() {
        assertEquals(testMonsterType, testMonster.getType());
        testMonster.setType(FIRE);
        assertEquals(FIRE, testMonster.getType());
    }

    @Test
    public void testSetHealthPoints() {
        assertEquals(testHealthPoints, testMonster.getHealthPoints());
        testMonster.setHealthPoints(200);
        assertEquals(200, testMonster.getHealthPoints());
    }

    @Test
    public void testEquals() {
        Monster m = new Monster ("Bulbasaur", GRASS, 45);
        assertEquals(m, new Monster("Bulbasaur", GRASS, 45));
        assertFalse(m.equals(new Monster("Charmander", FIRE, 45)));
        assertFalse(m.equals(new Monster("Snivy", GRASS, 45)));
        assertFalse(m.equals(new Monster("Bulbasaur", GRASS, 60)));
        assertFalse(m.equals(null));
        assertFalse(m.equals(new Team("Team 1")));

        Monster m2 = new Monster("Charmander", GRASS, 45);
        Monster m3 = new Monster("Bulbasaur", FIRE, 45);
        Monster m4 = new Monster("Bulbasaur", GRASS, 100);

        assertFalse(m.equals(m2));
        assertFalse(m.equals(m3));
        assertFalse(m.equals(m4));
    }

    @Test
    public void testHashCode() {
        Monster m = new Monster ("Bulbasaur", GRASS, 45);
        assertEquals(m.hashCode(), new Monster("Bulbasaur", GRASS, 45).hashCode());
    }
}