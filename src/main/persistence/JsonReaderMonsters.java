package persistence;

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// adapted from: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// Represents a reader that reads monsters from JSON data stored in file
public class JsonReaderMonsters {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReaderMonsters(String source) {
        this.source = source;
    }

    // EFFECTS: reads monsters from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Monsters read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseMonsters(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses monsters from JSON object and returns it
    private Monsters parseMonsters(JSONObject jsonObject) {
        Monsters monsters = new Monsters();
        addMonsters(monsters, jsonObject);
        return monsters;
    }

    // MODIFIES: monsters
    // EFFECTS: parses monster from JSON object and adds them to monsters
    private void addMonsters(Monsters monsters, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Monsters");
        for (Object json : jsonArray) {
            JSONObject nextMonster = (JSONObject) json;
            addMonster(monsters, nextMonster);
        }
    }

    // MODIFIES: monsters
    // EFFECTS: parses monster from JSON object and adds it to monsters
    private void addMonster(Monsters monsters, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String type = jsonObject.getString("type");
        int healthPoints = jsonObject.getInt("healthPoints");

        Monster m;
        if (type.equals("GRASS")) {
            m = new Monster(name, MonsterType.GRASS, healthPoints);
        } else if (type.equals("WATER")) {
            m = new Monster(name, MonsterType.WATER, healthPoints);
        } else {
            m = new Monster(name, MonsterType.FIRE, healthPoints);
        }

        monsters.addMonster(m);
    }

}
