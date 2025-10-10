package com.event.EventsPojo;

public class Events {
    private int EventID;
    private String EventName;
    private String Date;
    private String Location;
    private String organizer;

    public Events() {

    }

    public Events(int eventID, String eventName, String date, String location, String organizer) {
        EventID = eventID;
        EventName = eventName;
        Date = date;
        Location = location;
        this.organizer = organizer;
    }

    public int getEventID() {
        return EventID;
    }

    public void setEventID(int eventID) {
        EventID = eventID;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }
}
