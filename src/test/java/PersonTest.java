import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testGettersAndSetters() {
        Person person = new Person("Jane", "Doe", "jane.doe@example.com", "0987654321", "456 Elm St");
        assertEquals("Jane", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals("jane.doe@example.com", person.getEmail());
        assertEquals("0987654321", person.getPhone());
        assertEquals("456 Elm St", person.getAddress());
    }
}