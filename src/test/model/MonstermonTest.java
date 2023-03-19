package model;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MonstermonTest {

    private Monstermon monstermon;
    private List<Monster> monsters;
    private List<Team> teams;

    @BeforeEach
    public void setup() {
        monstermon = new Monstermon();
        monsters = new ArrayList<>();
        teams = new ArrayList<>();
    }

    @Test
    public void testGetAllMonsters() {
        assertEquals(monsters, monstermon.getAllMonsters());
    }

    @Test
    public void testGetAllTeams() {
        assertEquals(teams, monstermon.getAllTeams());
    }

    @Test
    public void testAddMonster() {
        Monster bulbasaur = new Monster("Bulbasaur", MonsterType.GRASS, 45);
        monstermon.addMonster(bulbasaur);
        assertTrue(monstermon.getAllMonsters().contains(bulbasaur));
        assertEquals(1, monstermon.getAllMonsters().size());
    }

    @Test
    public void testAddTeam() {
        Team team = new Team("Team 1");
        monstermon.addTeam(team);
        assertTrue(monstermon.getAllTeams().contains(team));
        assertEquals(1, monstermon.getAllTeams().size());
    }

    @Test
    public void testGetAllMonstersAsStrings() {
        List<String> monsterNames = new ArrayList<>();
        monsterNames.add("Bulbasaur");
        monsterNames.add("Charmander");
        monsterNames.add("Squirtle");

        monstermon.addMonster(new Monster("Bulbasaur", MonsterType.GRASS, 45));
        monstermon.addMonster(new Monster("Charmander", MonsterType.FIRE, 45));
        monstermon.addMonster(new Monster("Squirtle", MonsterType.WATER, 45));

        assertEquals(monsterNames, monstermon.getAllMonstersAsStrings());

    }
}
