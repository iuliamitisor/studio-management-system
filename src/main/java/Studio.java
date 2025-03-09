/*
    METHODS
    - Show all workshops from a specific day
    - Show all workshops from a specific month
    - Show all workshops from a specific year
    - Show all details of the location
 */

public class Studio {
    private String name;
    private String location;
    private int capacity;
    private Schedule schedule;

    Studio(String name, String location, int capacity, Schedule schedule){
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    public void printAllWorkshopsByDay(int day, int month, int year) {
        for (Workshop workshop = schedule.getRegisteredWorkshops().get(0); workshop != null && schedule.getDay() == day
                && schedule.getMonth() == month && schedule.getYear() == year; workshop = schedule.getRegisteredWorkshops().get(schedule.getRegisteredWorkshops().indexOf(workshop) + 1)) {
            System.out.println("Name: " + workshop.getName());
            System.out.println("Description: " + workshop.getDescription());
            System.out.println("Category: " + workshop.getCategory());
            System.out.println("Start Time: " + workshop.getStartTime());
            System.out.println("End Time: " + workshop.getEndTime());
            System.out.println("Trainer: " + workshop.getTrainer().getName());
        }
    }
    public void printAllWorkshopsByMonth(int month, int year) {
        for (Workshop workshop = schedule.getRegisteredWorkshops().get(0); workshop != null && schedule.getMonth() == month
                && schedule.getYear() == year; workshop = schedule.getRegisteredWorkshops().get(schedule.getRegisteredWorkshops().indexOf(workshop) + 1)) {
            System.out.println("Name: " + workshop.getName());
            System.out.println("Description: " + workshop.getDescription());
            System.out.println("Category: " + workshop.getCategory());
            System.out.println("Start Time: " + workshop.getStartTime());
            System.out.println("End Time: " + workshop.getEndTime());
            System.out.println("Trainer: " + workshop.getTrainer().getName());
        }
    }
    public void printAllWorkshopsByYear(int year) {
        for (Workshop workshop = schedule.getRegisteredWorkshops().get(0); workshop != null && schedule.getYear() == year; workshop = schedule.getRegisteredWorkshops().get(schedule.getRegisteredWorkshops().indexOf(workshop) + 1)) {
            System.out.println("Name: " + workshop.getName());
            System.out.println("Description: " + workshop.getDescription());
            System.out.println("Category: " + workshop.getCategory());
            System.out.println("Start Time: " + workshop.getStartTime());
            System.out.println("End Time: " + workshop.getEndTime());
            System.out.println("Trainer: " + workshop.getTrainer().getName());
        }
    }
    public void printAllLocationDetails() {
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Capacity: " + capacity);
        System.out.println("Schedule: ");
        schedule.printAllWorkshopsDetails();
    }

    // GETTERS AND SETTERS
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public Schedule getSchedule() {
        return schedule;
    }
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
