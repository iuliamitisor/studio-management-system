import java.util.List;
/*
    METHODS
    - Add feedback - add the feedback to the workshop trainer's feedback collection too
    - Delete one specific feedback
    - Delete all feedback
    - Show all received feedback
    - Calculate the average rating
 */
public class Workshop implements Reviewable {
    private int startTime, endTime;
    private Studio studio;
    private String name;
    private String description;
    private String category;
    private Trainer trainer;
    private List<Feedback> feedbackReceived;
    private Double averageRating;
    private List<Participant> registeredParticipants;

    Workshop(int startTime, int endTime, Studio studio, String name, String description, String category, Trainer trainer, List<Feedback> feedbackReceived
            , Double averageRating, List<Participant> registeredParticipants){
        this.startTime = startTime;
        this.endTime = endTime;
        this.studio = studio;
        this.name = name;
        this.description = description;
        this.category = category;
        this.trainer = trainer;
        this.feedbackReceived = feedbackReceived;
        this.averageRating = averageRating;
        this.registeredParticipants = registeredParticipants;
    }

    @Override
    public void addFeedback(Feedback feedback) {
        feedbackReceived.add(feedback);
        this.getTrainer().addFeedback(feedback);
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
        System.out.println("Feedback received for workshop: " + name);
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
        return (double) sum / feedbackReceived.size();
    }

    // GETTERS AND SETTERS
    public int getStartTime() {
        return startTime;
    }
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
    public int getEndTime() {
        return endTime;
    }
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
    public Studio getStudio() {
        return studio;
    }
    public void setStudio(Studio studio) {
        this.studio = studio;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Trainer getTrainer() {
        return trainer;
    }
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
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
    public List<Participant> getRegisteredParticipants() {
        return registeredParticipants;
    }
    public void setRegisteredParticipants(List<Participant> registeredParticipants) {
        this.registeredParticipants = registeredParticipants;
    }
}
