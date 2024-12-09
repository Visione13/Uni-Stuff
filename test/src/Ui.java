import java.sql.*;
import java.util.Scanner;

public class Ui {
    public static void followerAnzeigen(Connection connection, int user) {
        String query = "SELECT UserID from FollowerRelation WHERE FollowedUserID = "+ user;
        try(Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Folgende Nutzer folgen "+user+ ":");
            while (rs.next()){
                int userID = rs.getInt("UserID");
                System.out.println(userID);
            }
        } catch (SQLException e){
            System.err.println("Fehler: " + e.getMessage());
        }

    }
    public static void abfrage2(Connection connection) {
        System.out.println("Abfrage2" );
    }
    public static void songsAnzeigenPlaylist(Connection connection) {
        System.out.println("Songs in Playlist anzeigen von User" );
    }
    public static void namenAlphabet(Connection connection) {
        System.out.println("User Namen nach Alphabet sortiert" );
    }
    public static void songsAnzeigenAlbum(Connection connection) {
        System.out.println("Alle Songs eines Album ausgeben" );
    }
    public static void addFollower(Connection connection) {
        System.out.println("Follower hinzufügen" );
    }
    public static void deepSearch(Connection connection) {
        System.out.println("Tiefensuche" );
    }

    public static void menu(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        int auswahl;
        do {
            System.out.println("1. Follower von User anzeigen");
            System.out.println("2. Abfrage2");
            System.out.println("3. Songs in Playlist anzeigen von User");
            System.out.println("4. User Namen nach Alphabet sortiert");
            System.out.println("5. Alle Songs eines Album ausgeben");
            System.out.println("6. Follower hinzufügen");
            System.out.println("7. Tiefensuche");
            System.out.println("8. Beenden");
            System.out.print("Ihre Auswahl: ");
            auswahl = scanner.nextInt();
            switch (auswahl) {
                case 1:
                    System.out.println("User ID eingeben: ");
                    int user = scanner.nextInt();
                    followerAnzeigen(connection, user);
                    break;
                case 2:
                    abfrage2(connection);
                    break;
                case 3:
                    songsAnzeigenPlaylist(connection);
                    break;
                case 4:
                    namenAlphabet(connection);
                    break;
                case 5:
                    songsAnzeigenAlbum(connection);
                    break;
                case 6:
                    addFollower(connection);
                    break;
                case 7:
                    deepSearch(connection);
                    break;
                case 8:
                    System.out.println("Programm wird beendet!");
                    break;
                default:
                    System.out.println("Ungültige Eingabe!");
            }
        } while (auswahl != 8);
    }
}