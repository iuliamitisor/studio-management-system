import java.util.List;
/*
    METHODS
    - Add feedback
    - Delete one specific feedback
    - Delete all feedback
    - Show all received feedback
    - Calculate the average rating
    - Add a workshop held by the trainer
    - Remove a workshop held by the trainer
    - Print all workshops held by the trainer
    - Print all their details
 */
public class Trainer extends Person implements Reviewable {
    private String speciality;
    private List<Feedback> feedbackReceived;
    private Double averageRating;

    Trainer(String firstName, String lastName, String email, String phone, String address, String speciality, List<Feedback> feedbackReceived, Double averageRating) {
        super(firstName, lastName, email, phone, address);
        this.speciality = speciality;
        this.feedbackReceived = feedbackReceived;
        this.averageRating = averageRating;
    }

    @Override
    public void addFeedback(Feedback feedback) {
        feedbackReceived.add(feedback);
    }

    @Override
    public void removeFeedback(Feedback feedback) {
        feedbackReceived.remove(feedback);
    }

    @Override
    public void removeAllFeedback() {
        feedbackReceived.clear();
    }

    @Override
    public void printAllFeedbackReceived() {
        System.out.println("Feedback received for trainer: " + getName());
        System.out.println();
        for (Feedback feedback : feedbackReceived) {
            feedback.displayFeedback();
        }
    }

    @Override
    public Double calculateAverageRating() {
        int sum = 0;
        for (Feedback feedback : feedbackReceived) {
            sum += feedback.getRating();
        }
        this.averageRating = (double) sum / feedbackReceived.size();
        return averageRating;
    }

    public void addWorkshop(Workshop workshop){
        this.getWorkshops().add(workshop);
        workshop.setTrainer(this);
    }

    public void printAllWorkshopsDetails() {
        for (Workshop workshop : this.getWorkshops()) {
            System.out.println("Name: " + workshop.getName());
            System.out.println("Description: " + workshop.getDescription());
            System.out.println("Category: " + workshop.getCategory());
            System.out.println("Studio: " + workshop.getStudio().getName());
        }
    }
    public void showDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone: " + getPhone());
        System.out.println("Address: " + getAddress());
        System.out.println("Speciality: " + speciality);
        setAverageRating(calculateAverageRating());
        System.out.println("Average Rating: " + averageRating);
        System.out.println("All feedback received by this trainer: ");
        printAllFeedbackReceived();
        System.out.println("All workshops held by this trainer: ");
        printAllWorkshopsDetails();
    }

    // GETTERS AND SETTERS
    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    public List<Feedback> getFeedbackReceived() {
        return feedbackReceived;
    }
    public void setFeedbackReceived(List<Feedback> feedbackReceived) {
        this.feedbackReceived = feedbackReceived;
    }
    public Double getAverageRating() {
        return averageRating;
    }
    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
}
