package ui;

// Represents the different button names that are present in the sidebar
public enum ButtonNames {
    ADDMONSTER("Monsters"),
    CREATEMONSTER("Create Monster"),
    CREATETEAM("Create Team"),
    VIEWMONSTERS("View Monsters"),
    VIEWTEAMS("Teams"),
    SAVE("Save"),
    LOAD("Load");

    private final String name;

    // MODIFIES: this
    // EFFECTS: sets the button name to the given name
    private ButtonNames(String name) {
        this.name = name;
    }

    //EFFECTS: returns name value of this button
    public String getValue() {
        return name;
    }
}
