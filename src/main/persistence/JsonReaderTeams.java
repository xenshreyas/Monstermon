package persistence;

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// adapted from: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// Represents a reader that reads teams from JSON data stored in file
public class JsonReaderTeams {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReaderTeams(String source) {
        this.source = source;
    }

    // EFFECTS: reads teams from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Teams read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseTeams(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses teams from JSON object and returns it
    private Teams parseTeams(JSONObject jsonObject) {
        Teams teams = new Teams();
        addTeams(teams, jsonObject);
        return teams;
    }

    // MODIFIES: teams
    // EFFECTS: parses monster from JSON object and adds them to monsters
    private void addTeams(Teams teams, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Teams");
        for (Object json : jsonArray) {
            JSONObject nextTeam = (JSONObject) json;
            addTeam(teams, nextTeam);
        }
    }

    // MODIFIES: teams
    // EFFECTS: parses team from JSON object and adds it to teams
    private void addTeam(Teams teams, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("monsters");
        String name = jsonObject.getString("name");
        Team t = new Team(name);
        for (Object json : jsonArray) {
            JSONObject nextMonster = (JSONObject) json;
            addMonster(t, nextMonster);
        }
        teams.addTeam(t);
    }

    // MODIFIES: team
    // EFFECTS: parses monster from JSON object and adds it to monsters
    private void addMonster(Team team, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String type = jsonObject.getString("type");
        int healthPoints = jsonObject.getInt("healthPoints");

        Monster m;
        if (type.equals("GRASS")) {
            m = new Monster(name, MonsterType.GRASS, healthPoints);
        } else if (type.equals("WATER")) {
            m = new Monster(name, MonsterType.WATER, healthPoints);
        } else if (type.equals("FIRE")) {
            m = new Monster(name, MonsterType.FIRE, healthPoints);
        } else {
            m = new Monster(name, MonsterType.PSYCH, healthPoints);
        }

        team.addMonsterToTeam(m);
    }

}
