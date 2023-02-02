package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.MonsterType.*;
import static org.junit.jupiter.api.Assertions.*;

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
}