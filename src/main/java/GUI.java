import javax.swing.*;
import java.awt.*;

public class GUI {
    public GUI() {
        buildGUI();
    }

    private void buildGUI() {
        // Create the application window
        JFrame frame = new JFrame("Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 350);

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Create a welcome panel with a background image and add it to the layout
        cardPanel.add(createImagePanel("C:\\Users\\iulia\\Documents\\.UTCN\\OOP\\ArtStudioProject\\art supplies.png", cardPanel), "Menu");

        // Create a main menu panel with text
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS)); // Vertical alignment
        menu.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(Box.createVerticalGlue());

        JLabel textLabel = new JLabel("Choose a category: ");
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textLabel.setVerticalAlignment(SwingConstants.TOP);
        textLabel.setForeground(Color.magenta);
        textLabel.setFont(new Font("Outfit", Font.BOLD, 34));
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(textLabel);
        menu.add(Box.createVerticalStrut(30));

        // Add buttons to navigate to different sections
        JButton goToParticipants = new JButton("Participants");
        JButton goToWorkshops = new JButton("Our Workshops");
        JButton goToTrainers = new JButton("Our Trainers");
        JButton goToLocations = new JButton("Our Locations");
        goToParticipants.setAlignmentX(Component.CENTER_ALIGNMENT);
        goToWorkshops.setAlignmentX(Component.CENTER_ALIGNMENT);
        goToTrainers.setAlignmentX(Component.CENTER_ALIGNMENT);
        goToLocations.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(goToParticipants);
        menu.add(Box.createVerticalStrut(10));
        menu.add(goToWorkshops);
        menu.add(Box.createVerticalStrut(10));
        menu.add(goToTrainers);
        menu.add(Box.createVerticalStrut(10));
        menu.add(goToLocations);
        menu.add(Box.createVerticalGlue());

        // Build participants panel
        DatabaseConnection participants = new DatabaseConnection();
        participants.displayRegistrationForm();
        JButton goToMenu = new JButton("Back to Menu");
        participants.add(goToMenu);

        // Build trainers panel
        DatabaseConnection trainers = new DatabaseConnection();
        trainers.displayTrainerData();
        JButton goToMenu2 = new JButton("Back to Menu");
        trainers.add(goToMenu2, BorderLayout.SOUTH);

        // Build workshops panel
        DatabaseConnection workshops = new DatabaseConnection();
        workshops.searchWorkshop();
        JButton goToMenu1 = new JButton("Back to Menu");
        workshops.add(goToMenu1, BorderLayout.SOUTH);

        // Build locations panel
        DatabaseConnection locations = new DatabaseConnection();
        locations.displayStudioLocations();
        JButton goToMenu3 = new JButton("Back to Menu");
        locations.add(goToMenu3, BorderLayout.SOUTH);


        // Add action listeners to switch cards
        goToParticipants.addActionListener(e -> cardLayout.show(cardPanel, "Participants"));
        goToWorkshops.addActionListener(e -> cardLayout.show(cardPanel, "Workshops"));
        goToTrainers.addActionListener(e -> cardLayout.show(cardPanel, "Trainers"));
        goToLocations.addActionListener(e -> cardLayout.show(cardPanel, "Locations"));
        goToMenu.addActionListener(e -> cardLayout.show(cardPanel, "Menu"));
        goToMenu1.addActionListener(e -> cardLayout.show(cardPanel, "Menu"));
        goToMenu2.addActionListener(e -> cardLayout.show(cardPanel, "Menu"));
        goToMenu3.addActionListener(e -> cardLayout.show(cardPanel, "Menu"));

        // Add all panels to the cardPanel
        cardPanel.add(menu, "Menu");
        cardPanel.add(participants, "Participants");
        cardPanel.add(workshops, "Workshops");
        cardPanel.add(trainers, "Trainers");
        cardPanel.add(locations, "Locations");

        // Add cardPanel to frame and display
        frame.add(cardPanel);
        frame.setVisible(true);
    }

    private static JPanel createImagePanel(String imagePath, JPanel cardPanel) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        JLabel backgroundLabel = new JLabel(imageIcon);
        backgroundLabel.setLayout(new BorderLayout());

        JLabel overlayLabel = new JLabel("Welcome to our Art Studio Workshops!");
        overlayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        overlayLabel.setVerticalAlignment(SwingConstants.CENTER);
        overlayLabel.setForeground(Color.WHITE);
        overlayLabel.setFont(new Font("Outfit", Font.BOLD, 24));
        backgroundLabel.add(overlayLabel);

        // Create a button to go to the main menu
        JButton goToMenuButton = new JButton("Start >");
        goToMenuButton.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
            cardLayout.show(cardPanel, "Menu");
        });

        // Add the button to the background label
        backgroundLabel.add(goToMenuButton, BorderLayout.SOUTH);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(backgroundLabel, BorderLayout.CENTER);
        return panel;
    }
}
