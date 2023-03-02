package persistence;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import model.*;

import static model.MonsterType.*;
import static org.junit.jupiter.api.Assertions.*;

// Testing class to test whether monsters are being written correctly
class JsonWriterMonstersTest extends JsonTest {
    // to design tests for JsonWriter, write data to a file and then use the reader to read it back in and
    // check that we read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            Monsters monsters = new Monsters();
            JsonWriterMonsters writer = new JsonWriterMonsters("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyMonsters() {
        try {
            Monsters monsters = new Monsters();
            JsonWriterMonsters writer = new JsonWriterMonsters("./data/testWriterEmptyMonsters.json");
            writer.open();
            writer.write(monsters);
            writer.close();

            JsonReaderMonsters reader = new JsonReaderMonsters("./data/testWriterEmptyMonsters.json");
            monsters = reader.read();
            assertEquals(0, monsters.getMonsters().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralMonsters() {
        try {
            Monsters monsters = new Monsters();
            monsters.addMonster(new Monster("Bulbasaur", GRASS, 45));
            monsters.addMonster(new Monster("Charmander", FIRE, 50));
            monsters.addMonster(new Monster("Squirtle", WATER, 30));
            JsonWriterMonsters writer = new JsonWriterMonsters("./data/testWriterGeneralMonsters.json");
            writer.open();
            writer.write(monsters);
            writer.close();

            JsonReaderMonsters reader = new JsonReaderMonsters("./data/testWriterGeneralMonsters.json");
            monsters = reader.read();
            List<Monster> allMonsters = monsters.getMonsters();
            assertEquals(3, allMonsters.size());
            checkMonster("Bulbasaur", GRASS, 45, allMonsters.get(0));
            checkMonster("Charmander", FIRE, 50, allMonsters.get(1));
            checkMonster("Squirtle", WATER, 30, allMonsters.get(2));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}