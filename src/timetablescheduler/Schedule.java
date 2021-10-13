package timetablescheduler;

import java.util.ArrayList;
import timetablescheduler.domain.Department;
import timetablescheduler.domain.Class;

public class Schedule {
    private ArrayList<Class> classes;
    private boolean isFitnessChanged = true;
    private double fitness = -1;
    private int classNumb = 0;
    private int numbOfConflicts = 0;
    private Data data;
    public Data getData(){
        return data;
    }
    public Schedule(Data data){
        this.data = data;
        classes = new ArrayList<Class>(data.getNumberOfClasses());
    }
    public Schedule initialize(){
        
        //using the data class to pick up all the departments
        new ArrayList<Department>(data.getDepts()).forEach(dept ->{
            //picking up all the courses in each departmenr
           dept.getCourses().forEach(course -> {
               //for each ... we instantiate a new class using classNumb counter
               Class newClass = new Class(classNumb++, dept, course);
               //we randomly set the meeting time to one of the meeting times in the data given same is done to rooms and Instructors
               newClass.setMeetingTime(data.getMeetingTimes().get((int) (data.getMeetingTimes().size() * Math.random())));
               newClass.setRoom(data.getRooms().get((int) (data.getRooms().size() * Math.random())));
               newClass.setInstructor(course.getInstructors().get((int) (course.getInstructors().size() * Math.random())));
               //adding the new class instance to the array list of the class
               classes.add(newClass);
           }); 
        });
        return this;
    }

    public int getNumbOfConflicts() {
        return numbOfConflicts;
    }
    
    public ArrayList<Class> getClasses(){
        isFitnessChanged = true;
        return classes;
    }
    
    public double getFitness(){
        if(isFitnessChanged == true){
            fitness = calculateFitness();
            isFitnessChanged = false;
        }
        return fitness;
    }
    
    public double calculateFitness(){
        numbOfConflicts = 0;
        classes.forEach(x -> {
            if(x.getRoom().getSeatingCapacity() < x.getCourse().getMaxNumberOfStudents())numbOfConflicts++;
            classes.stream().filter(y -> classes.indexOf(y) >= classes.indexOf(x)).forEach(y -> {
                if(x.getMeetingTime() == y.getMeetingTime() && x.getId() != y.getId()){
                    if(x.getRoom() == y.getRoom()) numbOfConflicts++;
                    if(x.getInstructor() == y.getInstructor()) numbOfConflicts++;
                }
            });
        });
        return 1/(double)(numbOfConflicts + 1);
    }
    
    public String toString(){
        String returnValue = new String();
        for(int x = 0; x < classes.size()-1; x++) returnValue += classes.get(x) + ",";
        returnValue += classes.get(classes.size()-1);
        return returnValue;
    }
}
