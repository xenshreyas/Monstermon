package ui;

public enum ButtonNames {
    CREATEMONSTER("Create Monster!"),
    CREATETEAM("Create Team!"),
    GO_TO_REPORT("Current Report");

    private final String name;

    ButtonNames(String name) {
        this.name = name;
    }

    //EFFECTS: returns name value of this button
    public String getValue() {
        return name;
    }
}
