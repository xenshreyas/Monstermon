package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Testing class to test the Monstermon class
public class MonstermonTest {

    private Monstermon monstermon;
    private Monsters monsters;
    private Teams teams;
    private List<Monster> monsterList;
    private List<Team> teamList;

    @BeforeEach
    public void setup() {
        monstermon = new Monstermon();
        monsterList = new ArrayList<>();
        teamList = new ArrayList<>();
        monsters = new Monsters();
        teams = new Teams();
    }

    @Test
    public void testGetAllMonsters() {
        assertEquals(monsterList, monstermon.getAllMonsters());
    }

    @Test
    public void testGetAllTeams() {
        assertEquals(teamList, monstermon.getAllTeams());
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

    @Test
    public void testGetAllTeamsAsStrings() {
        List<String> teamNames = new ArrayList<>();
        teamNames.add("Team 1");
        teamNames.add("Team 2");

        monstermon.addTeam(new Team("Team 1"));
        monstermon.addTeam(new Team("Team 2"));

        assertEquals(teamNames, monstermon.getAllTeamsAsStrings());
    }

    @Test
    public void testAddMonsterToTeam() {
        String monsterName = "Bulbasaur";
        String teamName = "Team 1";

        Monster bulbasaur = new Monster("Bulbasaur", MonsterType.GRASS, 45);
        Team team1 = new Team("Team 1");

        monsterList.add(bulbasaur);
        teamList.add(team1);

        monstermon.addMonster(bulbasaur);
        monstermon.addTeam(team1);
        monstermon.addMonsterToTeam(monsterName, teamName);
    }

    @Test
    public void testTeamAlreadyHasMonster() {
        Monster m = new Monster("Bulbasaur", MonsterType.GRASS, 45);
        Monster m2 = new Monster("Charmander", MonsterType.FIRE, 45);
        monstermon.addMonster(m2);
        Team t = new Team("Team 1");

        assertFalse(monstermon.teamAlreadyHasMonster(null, "Team 1"));
        assertFalse(monstermon.teamAlreadyHasMonster("Bulbasaur", null));

        monstermon.addMonster(m);
        monstermon.addTeam(t);
        monstermon.addMonsterToTeam("Bulbasaur", "Team 1");

        assertTrue(monstermon.teamAlreadyHasMonster("Bulbasaur", "Team 1"));
        assertFalse(monstermon.teamAlreadyHasMonster("Charmander", "Team 1"));

        Team team2 = new Team("Team 2");
        Monster monster = new Monster("Bulbasaur");
        team2.addMonsterToTeam(monster);
        assertFalse(monstermon.teamAlreadyHasMonster("Monster B", "Team 2"));

    }

    @Test
    public void testFindMonster() {
        Monster m = new Monster("Bulbasaur", MonsterType.GRASS, 45);
        monstermon.addMonster(m);
        assertEquals(m, monstermon.findMonster("Bulbasaur"));
        assertEquals(null, monstermon.findMonster("Charmander"));
    }

    @Test
    public void testFindTeam() {
        Team t = new Team("Team 1");
        monstermon.addTeam(t);
        assertEquals(t, monstermon.findTeam("Team 1"));
        assertEquals(null, monstermon.findTeam("Team 2"));
    }

    @Test
    public void testLoadMonsters() {
        List<Monster> testMonsterList = new ArrayList<>();
        Monster bulbasuar = new Monster("Bulbasaur", MonsterType.GRASS, 45);
        Monster charmander = new Monster("Charmander", MonsterType.FIRE, 45);
        testMonsterList.add(bulbasuar);
        testMonsterList.add(charmander);
        monstermon.loadMonsters(testMonsterList);
        assertEquals(testMonsterList, monstermon.getAllMonsters());
    }

    @Test
    public void testLoadTeams() {
        List<Team> testTeamList = new ArrayList<>();
        Team testTeam1 = new Team("Team 1");
        Team testTeam2 = new Team("Team 2");
        testTeamList.add(testTeam1);
        testTeamList.add(testTeam2);
        monstermon.loadTeams(testTeamList);
        assertEquals(testTeamList, monstermon.getAllTeams());
    }

    @Test
    public void testGetMonsters() {
        assertEquals(this.monsters.getMonsters(), monstermon.getMonsters().getMonsters());
    }

    @Test
    public void testGetTeams() {
        assertEquals(this.teams.getTeams(), monstermon.getTeams().getTeams());
    }

}
