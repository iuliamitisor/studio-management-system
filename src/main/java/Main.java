import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main extends JPanel {
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI();
        });
    }
}

