package timetablescheduler;

import java.util.ArrayList;
import java.util.Arrays;
import timetablescheduler.domain.Course;
import timetablescheduler.domain.Department;
import timetablescheduler.domain.Instructor;
import timetablescheduler.domain.MeetingTime;
import timetablescheduler.domain.Room;

public class Data {
    private ArrayList<Room> rooms;
    private ArrayList<Instructor> instructors;
    private ArrayList<Course> courses;
    private ArrayList<Department> depts;
    private ArrayList<MeetingTime> meetingTimes;
    private int numberOfClasses = 0;
    
    public Data(){
        initialize();
    }
    
    //NB: This data should be coming from a database.
    
    private Data initialize(){
        
        Room room1 = new Room("TB1", 35);
        Room room2 = new Room("TB2", 45);
        Room room3 = new Room("TB3", 55);
        rooms = new ArrayList<Room>(Arrays.asList(room1,room2,room3));
        
        MeetingTime meetingTime1 = new MeetingTime("MT1", "MWF 07:00 - 09:00");
        MeetingTime meetingTime2 = new MeetingTime("MT2", "MWF 09:00 - 11:00");
        MeetingTime meetingTime3 = new MeetingTime("MT3", "TTH 09:00 - 11:00");
        MeetingTime meetingTime4 = new MeetingTime("MT4", "TTH 11:00 - 01:00");
        meetingTimes = new ArrayList<MeetingTime>(Arrays.asList(meetingTime1,meetingTime2,meetingTime3,meetingTime4));
        
        Instructor instructor1 = new Instructor("11","Dr McOyowo");
        Instructor instructor2 = new Instructor("12", "Mr Calvins");
        Instructor instructor3 = new Instructor("13", "Mr Kinya");
        Instructor instructor4 = new Instructor("14", "Mr Nyabundi");
        instructors = new ArrayList<Instructor>(Arrays.asList(instructor1,instructor2,instructor3,instructor4));
        
        Course course1 = new Course("CCS-302", "Human Computer Interaction", new ArrayList<Instructor>(Arrays.asList(instructor1,instructor2)), 25);
        Course course2 = new Course("CCS-304", "Project II", new ArrayList<Instructor>(Arrays.asList(instructor1,instructor2,instructor3)), 35);
        Course course3 = new Course("CCS-306", "Software Engineering", new ArrayList<Instructor>(Arrays.asList(instructor1,instructor2)), 25);
        Course course4 = new Course("CCS-308", "Research Methods and Technical Writing", new ArrayList<Instructor>(Arrays.asList(instructor3,instructor4)), 30);
        Course course5 = new Course("CCS-312", "Mobile Computing", new ArrayList<Instructor>(Arrays.asList(instructor4)), 35);
        Course course6 = new Course("CCS-314", "Cisco II", new ArrayList<Instructor>(Arrays.asList(instructor1,instructor3)), 45);
        Course course7 = new Course("CCS-318", "Introduction to Expert Systems", new ArrayList<Instructor>(Arrays.asList(instructor2,instructor4)), 45);
        courses = new ArrayList<Course>(Arrays.asList(course1,course2,course3,course4,course5,course6,course7));
        
        Department dept1 = new Department("Computer Science", new ArrayList<Course>(Arrays.asList(course1,course3)));
        Department dept2 = new Department("Computer technology", new ArrayList<Course>(Arrays.asList(course2,course4,course5)));
        Department dept3 = new Department("Information Technology", new ArrayList<Course>(Arrays.asList(course6,course7)));
        depts = new ArrayList(Arrays.asList(dept1,dept2,dept3));
        //Calculates the total number of classes
        depts.forEach(x -> numberOfClasses += x.getCourses().size());
        
        return this;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Department> getDepts() {
        return depts;
    }

    public ArrayList<MeetingTime> getMeetingTimes() {
        return meetingTimes;
    }

    public int getNumberOfClasses() {
        return numberOfClasses;
    }
    
    
}
