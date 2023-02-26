package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static model.MonsterType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Testing class to test whether teams are being written correctly
class JsonWriterTeamsTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Teams teams = new Teams();
            JsonWriterTeams writer = new JsonWriterTeams("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyTeams() {
        try {
            Teams teams = new Teams();
            JsonWriterTeams writer = new JsonWriterTeams("./data/testWriterEmptyTeams.json");
            writer.open();
            writer.write(teams);
            writer.close();

            JsonReaderTeams reader = new JsonReaderTeams("./data/testWriterEmptyTeams.json");
            teams = reader.read();
            assertEquals(0, teams.getTeams().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralTeams() {
        try {
            Teams teams = new Teams();
            List<Monster> monsters = new ArrayList<>();
            monsters.add(new Monster("Bulbasaur", GRASS, 45));
            monsters.add(new Monster("Charmander", FIRE, 50));

            Team team1 = new Team("Team 1");
            Team team2 = new Team("Team 2");
            for (Monster m : monsters) {
                team1.addMonsterToTeam(m);
                team2.addMonsterToTeam(m);
            }
            team2.addMonsterToTeam((new Monster("Squirtle", WATER, 30)));
            team1.addMonsterToTeam((new Monster("yruhere", PSYCH, 70)));
            teams.addTeam(team1);
            teams.addTeam(team2);
            JsonWriterTeams writer = new JsonWriterTeams("./data/testWriterGeneralTeams.json");
            writer.open();
            writer.write(teams);
            writer.close();

            JsonReaderTeams reader = new JsonReaderTeams("./data/testWriterGeneralTeams.json");
            teams = reader.read();
            List<Team> allTeams = teams.getTeams();
            assertEquals(2, allTeams.size());
            checkTeam("Team 1", team1.getAllMonsters(), allTeams.get(0));
            checkTeam("Team 2", team2.getAllMonsters(), allTeams.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}