import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/*
    METHODS
    - Insert all participant data into connected database
    - Delete a participant from the database
    - Modify participant data and update the database
    - Register a participant for a specific workshop
    - Unregister a participant from a specific workshop
 */
public class Participant extends Person {
    private String status;

    // Database credentials
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/artstudios";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "???";

    public Participant(String firstName, String lastName, String email, String phone, String address, String status) {
        super(firstName, lastName, email, phone, address);
        this.status = status;
    }

    public void saveToDatabase() {
        String sql = "INSERT INTO Participant (first_name, last_name, email, phone, address, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set the parameters for the statement
            statement.setString(1, this.getFirstName());
            statement.setString(2, this.getLastName());
            statement.setString(3, this.getEmail());
            statement.setString(4, this.getPhone());
            statement.setString(5, this.getAddress());
            statement.setString(6, this.getStatus());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new participant was inserted successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Database insertion failed: " + e.getMessage());
        }
    }
    public void dropFromDatabase() {
        // Change the SQL statement to DELETE
        String sql = "DELETE FROM Participant WHERE email = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set the parameter for the statement
            statement.setString(1, this.getEmail());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("The participant was deleted successfully!");
            } else {
                System.out.println("No participant found with the given email.");
            }
        } catch (SQLException e) {
            System.err.println("Database deletion failed: " + e.getMessage());
        }
    }
    public void updateInDatabase() {
        // SQL query to update the participant's details
        String sql = "UPDATE Participant SET first_name = ?, last_name = ?, phone = ?, address = ?, status = ? WHERE email = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set the parameters for the statement
            statement.setString(1, this.getFirstName());
            statement.setString(2, this.getLastName());
            statement.setString(3, this.getPhone());
            statement.setString(4, this.getAddress());
            statement.setString(5, this.getStatus());
            statement.setString(6, this.getEmail()); // Email as the identifier

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("The participant's details were updated successfully!");
            } else {
                System.out.println("No participant found with the given email.");
            }
        } catch (SQLException e) {
            System.err.println("Database update failed: " + e.getMessage());
        }
    }

    public void registerForWorkshop(Workshop workshop){
        this.getWorkshops().add(workshop);
        workshop.getRegisteredParticipants().add(this);
    }

    // GETTERS AND SETTERS
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}