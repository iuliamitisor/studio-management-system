import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;
import java.sql.Connection;

public class DatabaseConnectionTest {

    @Test
    public void testPerformSearch() {
        DatabaseConnection dbConnection = new DatabaseConnection();
        JTextField searchField = new JTextField("Painting");
        JLabel resultLabel = new JLabel();

        dbConnection.performSearch(searchField, resultLabel);
        assertNotNull(resultLabel.getText());
    }

    @Test
    public void testDisplayTrainerData() {
        DatabaseConnection dbConnection = new DatabaseConnection();
        dbConnection.displayTrainerData();
        assertNotNull(dbConnection.getComponent(0));
    }

    @Test
    public void testDisplayRegistrationForm() {
        DatabaseConnection dbConnection = new DatabaseConnection();
        dbConnection.displayRegistrationForm();
        assertNotNull(dbConnection.getComponent(0));
    }
}