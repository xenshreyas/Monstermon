package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeamTest {
    private Monster testMonster1;
    private Monster testMonster2;
    private Monster testMonster3;
    private Monster testMonster4;
    private Monster testMonster5;
    private Monster testMonster6;
    private Team testTeam;
    private String testName;

    @BeforeEach
    public void setup() {
        testName = "Team 1";
        testMonster1 = new Monster("Bulbasaur");
        testMonster2 = new Monster("Ivysaur");
        testMonster3 = new Monster("Venusaur");
        testMonster4 = new Monster("Charmander");
        testMonster5 = new Monster("Charmeleon");
        testMonster6 = new Monster("Charizard");
        testTeam = new Team(testName);
    }

    @Test
    public void testGetTeamName() {
        assertEquals(testName, testTeam.getTeamName());
    }

    @Test
    public void testRenameTeam() {
        assertEquals(testName, testTeam.getTeamName());
        testTeam.renameTeam("Team 2");
        assertEquals("Team 2", testTeam.getTeamName());
    }

    @Test
    public void testAddMonsterToTeam() {
        assertEquals(0, testTeam.getAllMonsters().size());

        assertTrue(testTeam.addMonsterToTeam(testMonster1));
        assertEquals(1, testTeam.getAllMonsters().size());
        assertEquals(testMonster1, testTeam.getAllMonsters().get(0));

        assertTrue(testTeam.addMonsterToTeam(testMonster2));
        assertEquals(2, testTeam.getAllMonsters().size());
        assertEquals(testMonster1, testTeam.getAllMonsters().get(0));
        assertEquals(testMonster2, testTeam.getAllMonsters().get(1));

        assertFalse(testTeam.addMonsterToTeam(testMonster2));

        assertTrue(testTeam.addMonsterToTeam(testMonster3));
        assertTrue(testTeam.addMonsterToTeam(testMonster4));
        assertTrue(testTeam.addMonsterToTeam(testMonster5));
        assertFalse(testTeam.addMonsterToTeam(testMonster6));
        assertFalse(testTeam.addMonsterToTeam(testMonster2));
    }

    @Test
    public void testRemoveMonsterFromTeam() {
        assertFalse(testTeam.removeMonsterFromTeam(testMonster1));

        assertTrue(testTeam.addMonsterToTeam(testMonster3));
        assertTrue(testTeam.removeMonsterFromTeam(testMonster3));
        assertEquals(0, testTeam.getAllMonsters().size());

        assertFalse(testTeam.removeMonsterFromTeam(testMonster1));
        assertEquals(0, testTeam.getAllMonsters().size());
    }

    @Test
    public void testGetAllMonsters() {
        assertEquals(0, testTeam.getAllMonsters().size());

        testTeam.addMonsterToTeam(testMonster1);

    }

}
