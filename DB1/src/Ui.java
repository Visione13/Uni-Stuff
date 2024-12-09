import java.sql.*;
import java.util.Scanner;

public class Ui {

    public static void menu(Connection connection) {
        Scanner sc = new Scanner(System.in);
        int auswahl;
        int user, user2, creator, albumId;
        String first, last;
        DataQueries dq = new DataQueries();
        System.out.println("1. Follower von User anzeigen");
        System.out.println("2. User Daten Abfragen");
        System.out.println("3. Abfrage2");
        System.out.println("4. Songs in Playlist anzeigen von User");
        System.out.println("5. User Namen nach Alphabet sortiert");
        System.out.println("6. Alle Songs eines Album ausgeben");
        System.out.println("7. Follower hinzufügen");
        System.out.println("8. Tiefensuche");
        System.out.println("9. Beenden");
        System.out.print("Ihre Auswahl: ");
        do {
            auswahl = sc.nextInt();
            switch (auswahl) {
                case 1:
                    System.out.print("Vorname: ");
                    first = sc.next();
                    System.out.print("Nachname: ");
                    last = sc.next();
                    try {
                        dq.followerAnzeigen(connection, first, last);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    System.out.print("User ID eingeben: ");
                    user = sc.nextInt();
                    dq.userData(connection, user);
                    break;
                case 3:
                    //abfrage2(connection);
                    break;
                case 4:
                    System.out.print("Creator ID eingeben: ");
                    creator = sc.nextInt();
                    dq.songPlaylistUser(connection, creator);
                    break;
                case 5:
                    dq.userAlphabetic(connection);
                    break;
                case 6:
                    System.out.print("Album ID eingeben: ");
                    albumId = sc.nextInt();
                    dq.songAlbum(connection, albumId);
                    break;
                case 7:
                    System.out.print("Welcher Nutzer folgt?: ");
                    user = sc.nextInt();
                    System.out.print("Wem?: ");
                    user2 = sc.nextInt();
                    dq.addFollower(connection, user, user2);
                    break;
                case 8:
                    //deepSearch(connection);
                    break;
                case 9:
                    System.out.println("Programm wird beendet!");
                    break;
                default:
                    System.out.println("Ungültige Eingabe!");
            }
        } while (auswahl != 8);
    }
}