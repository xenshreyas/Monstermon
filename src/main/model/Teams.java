package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents the Teams class that contains a list of teams
public class Teams implements Writable {
    private List<Team> teams;

    public Teams() {
        teams = new ArrayList<>();
    }

    public void addTeam(Team t) {
        this.teams.add(t);
    }

    public List<Team> getTeams() {
        return this.teams;
    }

    @Override
    public JSONObject toJson() {
        EventLog.getInstance().logEvent(new Event("Teams saved to JSON"));
        JSONObject json = new JSONObject();
        json.put("name", "Teams");
        json.put("Teams", monstersToJson());
        return json;
    }

    // EFFECTS: returns all monsters as a JSON array
    private JSONArray monstersToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Team t : teams) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }

}
