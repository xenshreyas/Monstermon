package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static model.MonsterType.*;
import static org.junit.jupiter.api.Assertions.*;

// Testing class for methods in the Team Class
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
        assertEquals(testName, testTeam.getName());
    }

    @Test
    public void testRenameTeam() {
        assertEquals(testName, testTeam.getName());
        testTeam.renameTeam("Team 2");
        assertEquals("Team 2", testTeam.getName());
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

        testTeam.addMonsterToTeam(testMonster2);
        assertFalse(testTeam.removeMonsterFromTeam(testMonster1));
        assertTrue(testTeam.removeMonsterFromTeam(testMonster2));

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

    @Test
    public void testEquals() {
        List<Monster> monsters = new ArrayList<>();
        Team t1 = new Team("Team 1");
        t1.addMonsterToTeam(new Monster("Bulbasaur", GRASS, 45));
        t1.addMonsterToTeam(new Monster("Charmander", FIRE, 45));
        t1.addMonsterToTeam(new Monster("Squirtle", WATER, 45));
        Monster b = new Monster ("Bulbasaur", GRASS, 45);
        Monster c = new Monster ("Charmander", FIRE, 45);
        Monster s = new Monster ("Squirtle", WATER, 45);
        Team t2 = new Team("Team 1");
        t2.addMonsterToTeam(b);
        t2.addMonsterToTeam(c);
        t2.addMonsterToTeam(s);
        assertTrue(t1.equals(t2));
        assertTrue(t1.equals(t1));
        assertFalse(t1.equals(new Monster("Bulbasaur", GRASS, 45)));
        assertFalse(t1.equals(new Team("Team 3")));
        assertFalse(t1.equals(null));
    }

    @Test
    public void testEqualsMore() {
        Monster monster1 = new Monster("Bulbasaur", GRASS, 45);
        Monster monster2 = new Monster("Charmander", FIRE, 50);
        Team team1 = new Team("Team A");
        Team team2 = new Team("Team A");
        team1.addMonsterToTeam(monster1);
        team1.addMonsterToTeam(monster2);
        team2.addMonsterToTeam(monster1);
        team2.addMonsterToTeam(monster2);

        assertTrue(team1.equals(team1));
        assertFalse(team1.equals(null));

        assertFalse(team1.equals(""));

        Team team3 = new Team("Team B");
        team3.addMonsterToTeam(monster1);
        team3.addMonsterToTeam(monster2);
        assertFalse(team1.equals(team3));

        Team team4 = new Team("Team A");
        team4.addMonsterToTeam(monster1);
        assertFalse(team1.equals(team4));

        Monster monster3 = new Monster("Squirtle", WATER, 30);
        Team team5 = new Team("Team A");
        team5.addMonsterToTeam(monster3);
        team5.addMonsterToTeam(monster2);

        assertFalse(team1.equals(team5));

        assertTrue(team1.equals(team2));

    }

    @Test
    public void testHashCode() {
        Team t = new Team ("Team");
        assertEquals(t.hashCode(), new Team("Team").hashCode());
    }

}
