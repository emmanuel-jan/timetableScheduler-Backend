package timetablescheduler;

import java.util.ArrayList;
import timetablescheduler.domain.Class;

public class TimetableScheduler {
    
    public static final int POPULATION_SIZE = 9;
    public static final double MUTATION_RATE = 0.1;
    public static final double CROSSOVER_RATE = 0.9;
    public static final int TOURNAMENT_SELECTION_SIZE = 3;
    public static final int NUMB_OF_ELITE_SCHEDULES = 1;
    private int scheduleNumb = 0;
    private int classNumb = 1;
    private Data data;
    
    public static void main(String[] args) {
        TimetableScheduler timetableScheduler = new TimetableScheduler();
        timetableScheduler.data = new Data();
        int generationNumber = 0;
        timetableScheduler.printAvailableData();
        
//        System.out.println("> Generation #" +generationNumber);
//        System.out.print(" Schedule #                                       ");
//        System.out.print("Classes [dept,class,room,instructor,meeting-time] ");
//        System.out.println("                                    | Fitness | Conflicts");
//        System.out.print("-------------------------------------------------------------");
//        System.out.println("-------------------------------------------------------------");
//        
//        //instantiate the genetic algorithm
//        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(timetableScheduler.data);
//        Population population = new Population(TimetableScheduler.POPULATION_SIZE, timetableScheduler.data).sortByFitness();
//        population.getSchedules().forEach(schedule -> System.out.println("        " +timetableScheduler.scheduleNumb++ +"     | "+ schedule +"  | " + String.format("%.5f",schedule.getFitness()) + "  |  " + schedule.getNumbOfConflicts()));
//        timetableScheduler.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
    }
    
    private void printScheduleAsTable(Schedule schedule, int generation){
        ArrayList<Class> classes = schedule.getClasses();
        System.out.print("\n                        ");
        System.out.println("Class # | Dept | Course (number, max # of students) | Room (Capacity) | Instructor (Id) | Meeting Time (Id)");
        System.out.print("                                                                                                            ");
        System.out.print("------------------------------------------------------------------------");
        System.out.print("---------------------------------------------------------------------------------------------");
        classes.forEach(x -> {
            int majorIndex = data.getDepts().indexOf(x.getDept());
            int coursesIndex = data.getCourses().indexOf(x.getCourse());
            int roomsIndex = data.getRooms().indexOf(x.getRoom());
            int instructorsIndex = data.getInstructors().indexOf(x.getInstructor());
            int meetingTimeIndex = data.getMeetingTimes().indexOf(x.getMeetingTime());
            System.out.print("                                    ");
            System.out.print(String.format("%1$02d", classNumb) + " | ");
            System.out.print(String.format("%1$4s", data.getDepts().get(majorIndex).getName()) + " | ");
            System.out.print(String.format("%1$21s", data.getCourses().get(coursesIndex).getName() + " ("+data.getCourses().get(coursesIndex).getNumber() + ", " + x.getCourse().getMaxNumberOfStudents()) +")      | ");
            System.out.print(String.format("%1$10s", data.getRooms().get(roomsIndex).getNumber() + " (" + x.getRoom().getSeatingCapacity()) + ")     | ");
            System.out.print(String.format("%1$15s", data.getInstructors().get(instructorsIndex).getName() + " ("+data.getInstructors().get(instructorsIndex).getId()+")") + " | ");
            System.out.println(data.getMeetingTimes().get(meetingTimeIndex).getName()+ " ("+data.getMeetingTimes().get(meetingTimeIndex).getId() + ") ");
            classNumb++;
        });
        if (schedule.getFitness() == 1)System.out.println("> Solution found in "+ (generation + 1) + " generations");
        System.out.print("--------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------");
    }
    
    private void printAvailableData(){
        System.out.println("Available Departments ==>");
        data.getDepts().forEach(x->System.out.println("name: "+x.getName()+", courses: "+x.getCourses()));
        System.out.println("\n Available Courses ==> ");
        data.getCourses().forEach(x -> System.out.println("course #: "+x.getNumber()+", name: "+x.getName()+", max # of students: "+ x.getMaxNumberOfStudents()+", instructors: "+x.getInstructors()));
        System.out.println("\n Available Rooms ==> ");
        data.getRooms().forEach(x -> System.out.println("room #: "+x.getNumber()+", max seating capacity: "+x.getSeatingCapacity()));
        System.out.println("\n Available Instructors ==> ");
        data.getInstructors().forEach(x -> System.out.println("id: "+x.getId()+", name: "+x.getName()));
        System.out.println("\n Available Meeting Times ==> ");
        data.getMeetingTimes().forEach(x -> System.out.println("id: "+x.getId()+" ,Meeting Time: "+x.getName()));
        System.out.print("--------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------");
        
    }
    
}
