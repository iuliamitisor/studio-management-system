import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParticipantTest {

    @Test
    public void testGettersAndSetters() {
        Participant participant = new Participant("Alice", "Johnson", "alice.johnson@example.com", "1122334455", "789 Pine St", "Registered");

        assertEquals("Alice", participant.getFirstName());
        assertEquals("Johnson", participant.getLastName());
        assertEquals("alice.johnson@example.com", participant.getEmail());
        assertEquals("1122334455", participant.getPhone());
        assertEquals("789 Pine St", participant.getAddress());
        assertEquals("Registered", participant.getStatus());

        participant.setFirstName("Bob");
        participant.setLastName("Brown");
        participant.setEmail("bob.brown@example.com");
        participant.setPhone("9988776655");
        participant.setAddress("321 Oak St");
        participant.setStatus("Confirmed");

        assertEquals("Bob", participant.getFirstName());
        assertEquals("Brown", participant.getLastName());
        assertEquals("bob.brown@example.com", participant.getEmail());
        assertEquals("9988776655", participant.getPhone());
        assertEquals("321 Oak St", participant.getAddress());
        assertEquals("Confirmed", participant.getStatus());
    }
}