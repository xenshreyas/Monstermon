package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// adapted from https://github.students.cs.ubc.ca/CPSC210/AlarmSystem.git

// Represents the EventLog
public class EventLog implements Iterable<Event> {
    // Singleton Design Pattern
    private static EventLog theLog;
    private Collection<Event> events;

    // EFFECTS: creates an empty event log
    private EventLog() {
        events = new ArrayList<Event>();
    }

    // EFFECTS: returns the singleton instance of the event log
    public static EventLog getInstance() {
        if (theLog == null) {
            theLog = new EventLog();
        }

        return theLog;
    }

    // MODIFIES: this
    // EFFECTS: adds the given event to the log
    public void logEvent(Event e) {
        events.add(e);
    }

    // MODIFIES: this
    // EFFECTS: clears the log and adds an event to the log indicating that the log was cleared
    public void clear() {
        events.clear();
        logEvent(new Event("Event log cleared."));
    }

    // EFFECTS: returns an iterator for the events in the log
    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }
}
