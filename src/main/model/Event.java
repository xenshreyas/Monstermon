package model;

import java.util.Calendar;
import java.util.Date;

// Represents an Event
public class Event {
    private static final int HASH_CONSTANT = 13;
    private Date dateLogged;
    private String description;

    // MODIFIES: this
    // EFFECTS: creates an event with given description
    public Event(String description) {
        dateLogged = Calendar.getInstance().getTime();
        this.description = description;
    }

    // EFFECTS: returns the date logged
    public Date getDate() {
        return dateLogged;
    }

    // EFFECTS: returns the description of the event
    public String getDescription() {
        return description;
    }

    // EFFECTS: returns true if two Events are equal
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (other.getClass() != this.getClass()) {
            return false;
        }

        Event otherEvent = (Event) other;

        return (this.dateLogged.equals(otherEvent.dateLogged) && this.description.equals(otherEvent.description));
    }

    // EFFECTS: returns the hashCode based on dateLogged and Description
    @Override
    public int hashCode() {
        return (HASH_CONSTANT * dateLogged.hashCode() + description.hashCode());
    }

    // EFFECTS: returns the string representation of the event
    @Override
    public String toString() {
        return dateLogged.toString() + "\n" + description;
    }
}
