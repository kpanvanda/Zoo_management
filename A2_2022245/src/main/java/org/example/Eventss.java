package org.example;

import java.util.ArrayList;
import java.util.*;

public class Eventss {
    private static int eventCount = 1;
    private int eventId;
    private String eventName;
    private String eventDescribe;
    private Date eventDate;
    private int attractionId;

    public Eventss(int eventId, String eventName, String eventDescribe, Date eventDate, int attractionId) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDescribe = eventDescribe;
        this.eventDate = eventDate;
        this.attractionId = attractionId;
    }

    // Getter and setter methods for event properties

    public int getEventId() {
        return eventId;
    }

    public static int getEventCount() {
        return eventCount;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescribe() {
        return eventDescribe;
    }

    public void setEventDescribe(String eventDescribe) {
        this.eventDescribe = eventDescribe;
    }

    public static void setEventCount(int eventCount) {
        Eventss.eventCount = eventCount;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public int getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(int attractionId) {
        this.attractionId = attractionId;
    }
}