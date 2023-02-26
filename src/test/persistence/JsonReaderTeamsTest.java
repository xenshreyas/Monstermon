package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Testing class to test whether teams are being read correctly
class JsonReaderTeamsTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReaderTeams reader = new JsonReaderTeams("./data/noSuchFile.json");
        try {
            Teams teams = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyTeams() {
        JsonReaderTeams reader = new JsonReaderTeams("./data/testReaderEmptyTeams.json");
        try {
            Teams teams = reader.read();
            assertEquals(0, teams.getTeams().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralTeams() {
        JsonReaderTeams reader = new JsonReaderTeams("./data/testReaderGeneralTeams.json");
        try {
            Teams teams = reader.read();
            List<Team> allTeams = teams.getTeams();
            assertEquals(2, allTeams.size());
            List<Monster> monstersTeam1 = allTeams.get(0).getAllMonsters();
            List<Monster> monstersTeam2 = allTeams.get(1).getAllMonsters();
            checkTeam("Team 1", monstersTeam1, allTeams.get(0));
            checkTeam("Team 2", monstersTeam2, allTeams.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}