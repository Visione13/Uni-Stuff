import java.sql.*;

public class Main {
    private static String url = "jdbc:oracle:thin:@//localhost:1521/FREE";
    private static String user = "system";
    private static String password = "oracle";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Ui ui = new Ui();
            ui.menu(connection);

        } catch (SQLException e) {
            System.err.println("Fehler bei der Verbindung: " + e.getMessage());
        }
    }
}