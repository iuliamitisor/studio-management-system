/*
    METHODS
    - Print feedback details
 */
public class Feedback {
    private int rating;
    private String comment;

    Feedback(int rating, String comment){
        this.rating = rating;
        this.comment = comment;
    }

    public void displayFeedback(){
        System.out.println("Rating: " + rating);
        System.out.println("Comment: " + comment);
    }

    // GETTERS AND SETTERS
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}
