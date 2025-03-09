import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class DatabaseConnection extends JPanel {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/artstudios";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "???";

    // Empty constructor

    // Function to search for a workshop by name

    public void searchWorkshop() {
        JTextField searchField;
        JLabel resultLabel;
        setLayout(new BorderLayout());

        // Create a panel for searching workshops
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Add a label, a search field and a search button
        searchPanel.add(new JLabel("Search Workshop:"));
        searchField = new JTextField(20);
        searchPanel.add(searchField);
        JButton searchButton = new JButton("Search");
        searchPanel.add(searchButton);

        // Add searchPanel to the main panel
        add(searchPanel, BorderLayout.NORTH);

        // Add a label for displaying results
        resultLabel = new JLabel("");
        add(resultLabel, BorderLayout.CENTER);
        searchButton.addActionListener(e -> performSearch(searchField, resultLabel));
    }

    public void performSearch(JTextField searchField, JLabel resultLabel) {
        String workshopName = searchField.getText();
        String query = "SELECT w.name, w.description, c.name AS category_name " +
                "FROM workshop w " +
                "JOIN category c ON w.category_id = c.category_id " +
                "WHERE w.name LIKE ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, "%" + workshopName + "%");

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String categoryName = resultSet.getString("category_name");
                resultLabel.setText("<html><strong>Name:</strong> " + name + "<br><strong>Description:</strong> " + description + "<br><strong>Category:</strong> " + categoryName + "</html>");
            } else {
                resultLabel.setText("No workshop found with the name: " + workshopName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching workshop data.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void displayTrainerData() {

        setLayout(new BorderLayout());

        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            String query = "SELECT first_name, last_name, speciality, average_rating FROM trainer";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            DefaultTableModel tableModel = new DefaultTableModel();

            // Add columns to the table model
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }
            // Add rows from the result set
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(row);
            }

            table.setModel(tableModel);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data from database", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void displayRegistrationForm(){
         JTextField firstNameField;
         JTextField lastNameField;
         JTextField emailField;
         JTextField phoneField;
         JTextField addressField;
         JComboBox<String> statusComboBox;

        setLayout(new GridLayout(8, 2, 5, 5));

        // Add labels and text fields
        add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        add(firstNameField);

        add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        add(lastNameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Phone:"));
        phoneField = new JTextField();
        add(phoneField);

        add(new JLabel("Address:"));
        addressField = new JTextField();
        add(addressField);

        add(new JLabel("Status:"));
        // Create a dropdown menu to choose status
        String[] statusOptions = {"Registered", "Not registered", "In progress"};
        statusComboBox = new JComboBox<>(statusOptions);
        add(statusComboBox);

        // Add a button to register the participant
        JButton registerButton = new JButton("Register");
        add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerParticipant(firstNameField, lastNameField, emailField, phoneField, addressField, statusComboBox);
            }
        });
        add(new JLabel());
    }

    private void registerParticipant(JTextField firstNameField, JTextField lastNameField, JTextField emailField, JTextField phoneField, JTextField addressField, JComboBox<String> statusComboBox) {
        // Get user input from text fields and dropdown
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        String status = (String) statusComboBox.getSelectedItem(); // Get selected status

        // Insert the participant into the database
        String insertQuery = "INSERT INTO participant (first_name, last_name, email, phone, address, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            // Set the parameters for the query
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setString(4, phone);
            statement.setString(5, address);
            statement.setString(6, status);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Participant inserted successfully.");
                // Show a detailed confirmation message
                JOptionPane.showMessageDialog(this,
                        "Participant " + firstName + " " + lastName + " with email " + email +
                                " was registered successfully.\n\nDetails:\n" +
                                "- Phone: " + phone + "\n" +
                                "- Address: " + address + "\n" +
                                "- Status: " + status,
                        "Registration Successful",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to insert participant.");
                // Show an error message
                JOptionPane.showMessageDialog(this,
                        "Error registering participant. Please try again.",
                        "Registration Error",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error inserting participant into database.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }



        // Clear all fields
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
        phoneField.setText("");
        addressField.setText("");
        statusComboBox.setSelectedIndex(0); // Reset dropdown to the first option
    }

    public void displayStudioLocations() {
        setLayout(new BorderLayout());

        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            String query = "SELECT s.name, l.city, l.address, s.capacity " +
                    "FROM studio s, location l " +
                    "WHERE s.location_id = l.location_id";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            DefaultTableModel tableModel = new DefaultTableModel();

            // Add columns to the table model
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }
            // Add rows from the result set
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(row);
            }

            table.setModel(tableModel);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data from database", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
