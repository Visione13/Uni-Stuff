import java.sql.*;
import java.util.Scanner;

public class Ui {

    public static void menu(Connection connection) {
        Scanner sc = new Scanner(System.in);
        int auswahl;
        int user;
        String first, last, song, album, interpret;
        DataQueries dq = new DataQueries();
        do {
            System.out.println("1. Zeige mir alle Follower eines bestimmten Users an.");
            System.out.println("2. Gebe mir die Daten eines bestimmten Users aus.");
            System.out.println("3. Gebe mir die Summe aller User an, die einen bestimmten Song aus einen bestimmten Album von einen bestimmten Interpreten, in ihrer Playlist gespeichert haben.");
            System.out.println("4. Zeige mir alle Songs an, die ein bestimmter User in seiner Playlist gespeichert hat.");
            System.out.println("5. Gebe mir alle User nach den Alphabet sortiert aus.");
            System.out.println("6. Gebe mir alle Songs eines bestimmten Albums aus.");
            System.out.println("7. Füge einen bestimmten User bestimmte Follower hinzu.");
            System.out.println("8. Zeige mir alle direkten und indirekten Follower von einen bestimmten User an. (Tiefensuche)");
            System.out.println("9. Beenden");
            System.out.print("Ihre Auswahl: ");
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
                    sc.nextLine();
                    System.out.print("Bitte geben Sie den Namen des Songs an:");
                    song = sc.nextLine();
                    System.out.print("Bitte geben Sie nun das zugehörige Album des Songs an:");
                    album = sc.nextLine();
                    System.out.print("Bitte geben Sie nun den zugehörigen Interpreten an:");
                    interpret = sc.nextLine();
                    dq.sumUser(connection, song, album, interpret);
                    break;
                case 4:
                    System.out.print("Vorname: ");
                    first = sc.next();
                    System.out.print("Nachname: ");
                    last = sc.next();
                    dq.songPlaylistUser(connection, first, last);
                    break;
                case 5:
                    dq.userAlphabetic(connection);
                    break;
                case 6:
                    System.out.print("Albumname eingeben: ");
                    album = sc.next();
                    dq.songAlbum(connection, album);
                    break;
                case 7:
                    System.out.println("Welcher Nutzer folgt?: ");
                    System.out.print("Vorname: ");
                    String followFirst = sc.next();
                    System.out.print("Nachname: ");
                    String followLast = sc.next();
                    System.out.println("Wem?: ");
                    System.out.print("Vorname: ");
                    String followedFirst = sc.next();
                    System.out.print("Nachname: ");
                    String followedLast = sc.next();
                    dq.addFollower(connection, followFirst, followLast, followedFirst, followedLast);
                    break;
                case 8:
                    System.out.print("Gebe den Vornamen des Users an:");
                    first = sc.next();
                    System.out.print("Gebe den Nachnamen des Users an:");
                    last = sc.next();
                    dq.deepSearch(connection, first, last);
                    break;
                case 9:
                    System.out.println("Programm wird beendet!");
                    break;
                default:
                    System.out.println("Ungültige Eingabe!");
            }
        } while (auswahl != 9);
    }
}