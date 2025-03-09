import java.util.List;

/*
    METHODS
    - Show all registered workshops
    - Add a new workshop to the schedule
    - Cancel a workshop from the schedule
 */

public class Schedule {
    private List<Workshop> registeredWorkshops;
    int day, month, year;

    Schedule(List<Workshop> registeredWorkshops, int day, int month, int year){
        this.registeredWorkshops = registeredWorkshops;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void printAllWorkshopsDetails() {
        for (Workshop workshop : registeredWorkshops) {
            System.out.println("Name: " + workshop.getName());
            System.out.println("Description: " + workshop.getDescription());
            System.out.println("Category: " + workshop.getCategory());
            System.out.println("Start Time: " + workshop.getStartTime());
            System.out.println("End Time: " + workshop.getEndTime());
            System.out.println("Studio: " + workshop.getStudio().getName());
        }
    }
    public void addWorkshop(Workshop workshop) {
        registeredWorkshops.add(workshop);
    }
    public void cancelWorkshop(Workshop workshop) {
        registeredWorkshops.remove(workshop);
        workshop.getTrainer().removeWorkshop(workshop);
        for (Participant participant : workshop.getRegisteredParticipants()) {
            participant.removeWorkshop(workshop);
        }
    }
    public void cancelAllWorkshops() {
        registeredWorkshops.clear();
    }
    public void showWorkshops(int day, int month, int year){
        for (Workshop workshop : registeredWorkshops) {
            if (this.getDay() == day && this.getMonth() == month && this.getYear() == year) {
                System.out.println("Name: " + workshop.getName());
                System.out.println("Description: " + workshop.getDescription());
                System.out.println("Category: " + workshop.getCategory());
                System.out.println("Start Time: " + workshop.getStartTime());
                System.out.println("End Time: " + workshop.getEndTime());
            }
        }
    }

    // GETTERS AND SETTERS
    public List<Workshop> getRegisteredWorkshops() {
        return registeredWorkshops;
    }
    public void setRegisteredWorkshops(List<Workshop> registeredWorkshops) {
        this.registeredWorkshops = registeredWorkshops;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
}
