package org.example;
import java.util.*;

public class EventManage {
    private Map<Integer, Eventss> events = new HashMap<>();
    private static int eventCount = 1;

    public void addEvent(String eventName, String eventDescribe, Date eventDate, int attractionId) {
        Eventss event = new Eventss(eventCount++, eventName, eventDescribe, eventDate, attractionId);
        events.put(event.getEventId(), event);
    }

    public void viewEvent() {
        for (Eventss event : events.values()) {
            System.out.println("Event ID: " + event.getEventId() +
                    ", Name: " + event.getEventName() +
                    ", Describe: " + event.getEventDescribe() +
                    ", Date: " + event.getEventDate() +
                    ", Attraction ID: " + event.getAttractionId());
        }
    }
    public boolean modifyEvent(int eventId, String newEventName, String newEventDescribe, Date newEventDate, int newAttractionId) {
        if (events.containsKey(eventId)) {
            Eventss event = events.get(eventId);
            event.setEventName(newEventName);
            event.setEventDescribe(newEventDescribe);
            event.setEventDate(newEventDate);
            event.setAttractionId(newAttractionId);
            return true;
        }
        return false;
    }

    public boolean removeEvent(int eventId) {
        if (events.containsKey(eventId)) {
            events.remove(eventId);
            return true;
        }
        return false;
    }
}