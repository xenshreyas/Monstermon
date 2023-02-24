package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

public class Monsters implements Writable {
    private List<Monster> monsters;

    public Monsters() {
        monsters = new ArrayList<>();
    }

    public void addMonster(Monster m) {
        this.monsters.add(m);
    }

    public List<Monster> getMonsters() {
        return this.monsters;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", "Monsters");
        json.put("Monsters", monstersToJson());
        return json;
    }

    // EFFECTS: returns all monsters as a JSON array
    private JSONArray monstersToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Monster m : monsters) {
            jsonArray.put(m.toJson());
        }

        return jsonArray;
    }

}
