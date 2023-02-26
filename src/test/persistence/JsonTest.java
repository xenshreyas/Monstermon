package persistence;

import model.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Testing class containing helper methods to check monsters and teams
public class JsonTest {
    protected void checkMonster(String name, MonsterType type, int hp, Monster monster) {
        assertEquals(name, monster.getName());
        assertEquals(type, monster.getType());
        assertEquals(hp, monster.getHealthPoints());
    }

    protected void checkTeam(String name, List<Monster> monsters, Team team) {
        assertEquals(name, team.getName());
        int i = 0;
        for (Monster m : monsters) {
            assertEquals(m.getName(), team.getAllMonsters().get(i).getName());
            assertEquals(m.getType(), team.getAllMonsters().get(i).getType());
            assertEquals(m.getHealthPoints(), team.getAllMonsters().get(i).getHealthPoints());
            i++;
        }
    }
}
