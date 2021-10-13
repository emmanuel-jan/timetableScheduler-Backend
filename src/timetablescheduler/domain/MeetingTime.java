package timetablescheduler.domain;

public class MeetingTime {
    private String id;
    private String name;

    public MeetingTime(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
}
