public interface Reviewable {

    public void addFeedback(Feedback feedback);
    public void removeFeedback(Feedback feedback);
    public void removeAllFeedback();
    Double calculateAverageRating();
    public void printAllFeedbackReceived();
}
