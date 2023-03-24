package persistence;

import org.json.JSONObject;

// Represents the Writable Interface
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
