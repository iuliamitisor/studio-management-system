import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainerTest {

    @Test
    public void testGettersAndSetters() {
        Trainer trainer = new Trainer("John", "Doe", "john.doe@example.com", "1234567890", "123 Main St", "Fitness", null, 4.5);

        assertEquals("John", trainer.getFirstName());
        assertEquals("Doe", trainer.getLastName());
        assertEquals("john.doe@example.com", trainer.getEmail());
        assertEquals("1234567890", trainer.getPhone());
        assertEquals("123 Main St", trainer.getAddress());

        trainer.setFirstName("Jane");
        trainer.setLastName("Smith");
        trainer.setEmail("jane.smith@example.com");
        trainer.setPhone("0987654321");
        trainer.setAddress("456 Elm St");

        assertEquals("Jane", trainer.getFirstName());
        assertEquals("Smith", trainer.getLastName());
        assertEquals("jane.smith@example.com", trainer.getEmail());
        assertEquals("0987654321", trainer.getPhone());
        assertEquals("456 Elm St", trainer.getAddress());
    }
}