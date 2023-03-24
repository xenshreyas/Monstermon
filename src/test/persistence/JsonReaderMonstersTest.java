package persistence;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import model.*;

import static model.MonsterType.*;
import static org.junit.jupiter.api.Assertions.*;

// Testing class to test whether monsters are being read correctly
class JsonReaderMonstersTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReaderMonsters reader = new JsonReaderMonsters("./data/nonExistentFile.json");
        try {
            Monsters monsters = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyMonsters() {
        JsonReaderMonsters reader = new JsonReaderMonsters("./data/testReaderEmptyMonsters.json");
        try {
            Monsters monsters = reader.read();
            assertEquals(0, monsters.getMonsters().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralMonsters() {
        JsonReaderMonsters reader = new JsonReaderMonsters("./data/testReaderGeneralMonsters.json");
        try {
            Monsters monsters = reader.read();
            List<Monster> allMonsters = monsters.getMonsters();
            assertEquals(4, allMonsters.size());
            checkMonster("Bulbasaur", GRASS, 45, allMonsters.get(0));
            checkMonster("Charmander", FIRE, 50, allMonsters.get(1));
            checkMonster("Squirtle", WATER, 30, allMonsters.get(2));
            checkMonster("Mew", PSYCH, 999, allMonsters.get(3));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}