import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FeedbackTest {

    @Test
    public void testFeedbackDetails() {
        Feedback feedback = new Feedback(5, "Great workshop!");
        assertEquals(5, feedback.getRating());
        assertEquals("Great workshop!", feedback.getComment());
    }

    @Test
    public void testSetters() {
        Feedback feedback = new Feedback(3, "Good workshop.");
        feedback.setRating(4);
        feedback.setComment("Very good workshop.");
        assertEquals(4, feedback.getRating());
        assertEquals("Very good workshop.", feedback.getComment());
    }
}