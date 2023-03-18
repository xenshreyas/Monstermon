package ui;

public enum ButtonNames {
    ADDMONSTER("Add Monster"),
    CREATEMONSTER("Create Monster"),
    CREATETEAM("Create Team"),
    VIEWMONSTERS("View Monsters"),
    VIEWTEAMS("View Teams"),
    SAVE("Save"),
    LOAD("Load");

    private final String name;

    ButtonNames(String name) {
        this.name = name;
    }

    //EFFECTS: returns name value of this button
    public String getValue() {
        return name;
    }
}
