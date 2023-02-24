package persistence;

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads monsters from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
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
        Monsters ml = new Monsters();
        addMonsters(ml, jsonObject);
        return ml;
    }

    // MODIFIES: ml
    // EFFECTS: parses monster from JSON object and adds them to monsters
    private void addMonsters(Monsters ml, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Monsters");
        for (Object json : jsonArray) {
            JSONObject nextMonster = (JSONObject) json;
            addMonster(ml, nextMonster);
        }
    }

    // MODIFIES: ml
    // EFFECTS: parses monster from JSON object and adds it to monsters
    private void addMonster(Monsters ml, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String type = jsonObject.getString("type");
        int healthPoints = jsonObject.getInt("healthPoints");

        Monster m;
        if (type.equals("grass")) {
            m = new Monster(name, MonsterType.GRASS, healthPoints);
        } else if (type.equals("water")) {
            m = new Monster(name, MonsterType.WATER, healthPoints);
        } else if (type.equals("fire")) {
            m = new Monster(name, MonsterType.FIRE, healthPoints);
        } else {
            m = new Monster(name, MonsterType.PSYCH, healthPoints);
        }

        ml.addMonster(m);
    }
}
