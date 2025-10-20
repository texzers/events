package com.event.EventsPojo;

import jakarta.validation.constraints.*;

public class Events {

    @Positive(message = "Id is invalid")
    private int eventId;
    @NotBlank(message = "Name is required")
    private String eventName;
    @NotBlank(message = "Date is required")
    private String date;
    private String location;
    private String organizer;

    public Events() {

    }

    public Events(int eventId, String eventName, String date, String location, String organizer) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.date = date;
        this.location = location;
        this.organizer = organizer;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

}
