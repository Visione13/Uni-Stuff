import java.sql.*;
import java.sql.Date;
import java.util.*;

public class DataQueries {

    public void followerAnzeigen(Connection connection, String first, String last) throws SQLException {
        String query = "SELECT B.FIRSTNAME, B.SURNAME FROM CUSTOMER A JOIN FOLLOWERRELATION FW ON A.USERID = FW.FOLLOWEDUSERID JOIN CUSTOMER B ON B.USERID = FW.USERID WHERE A.FIRSTNAME = ? AND A.SURNAME = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, first);
            ps.setString(2, last);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String firstname = rs.getString("FIRSTNAME");
                String lastname = rs.getString("SURNAME");
                System.out.println(firstname + " " + lastname);
            }
        } catch (SQLException e) {
            System.err.println("Fehler: " + e.getMessage());
        }

    }

    public void sumUser(Connection connection, String song, String album, String interpret) {
        String query = "SELECT COUNT(DISTINCT sp.UserID) AS UserCount " +
                "FROM Song s " +
                "JOIN Album a ON s.AlbumID = a.AlbumID " +
                "JOIN Interpret i ON s.InterpretID = i.InterpretID " +
                "JOIN SongPlaylistRelation spr ON s.SongID = spr.SongID " +
                "JOIN PlaylistFollowerRelation sp ON spr.PlaylistID = sp.PlaylistID " +
                "WHERE s.SongName = ? AND a.AlbumName = ? AND i.ArtistName = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, song);
            pstmt.setString(2, album);
            pstmt.setString(3, interpret);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int userCount = rs.getInt("UserCount");
                System.out.println("Die Anzahl der Nutzer, die den Song '" + song +
                        "' aus dem Album '" + album +
                        "' von '" + interpret +
                        "' gespeichert haben: " + userCount);
            } else {
                System.out.println("Keine Daten gefunden.");
            }
        } catch (SQLException e) {
            System.err.println("Fehler bei der Abfrage: " + e.getMessage());
        }
    }


    public void songPlaylistUser(Connection connection, String first, String last) {
        String query = "SELECT s.SongID, s.SONGNAME " +
                "FROM Song s " +
                "JOIN SongPlaylistRelation spr ON s.SongID = spr.SongID " +
                "JOIN Playlist p ON spr.PlaylistID = p.PlaylistID " +
                "JOIN CUSTOMER c ON c.UserID = p.CreatorID " +
                "WHERE c.FIRSTNAME = ? AND c.SURNAME = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, first);
            pstmt.setString(2, last);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Songs in playlists created by user " + first + ":");
            while (rs.next()) {
                int songID = rs.getInt("SongID");
                String songName = rs.getString("SongName");
                System.out.println("Song ID: " + songID + ", SongName: " + songName);
            }
        } catch (SQLException e) {
            System.err.println("Fehler: " + e.getMessage());
        }
    }

    public void userAlphabetic(Connection connection) {
        String query = "SELECT * from Customer ORDER BY FirstName";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String firstName = rs.getString("FirstName");
                String surName = rs.getString("SurName");
                System.out.print("Vorname: ");
                System.out.print(firstName + " ");
                System.out.print("Nachname: ");
                System.out.println(surName);
            }
        } catch (SQLException e) {
            System.err.println("Fehler: " + e.getMessage());
        }
    }

    public void songAlbum(Connection connection, String album) {
        String query = "SELECT Album.ALBUMNAME AS AlbumName, Song.SongName AS SongName " +
                "FROM Album " +
                "JOIN Song ON Album.AlbumID = Song.AlbumID " +
                "WHERE Album.ALBUMNAME = ?" +
                "ORDER BY SongName";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, album);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Songs in Album " + album + ":");
            while (rs.next()) {
                String songName = rs.getString("SongName");
                System.out.println(songName);
            }
        } catch (SQLException e) {
            System.err.println("Fehler: " + e.getMessage());
        }
    }

    public void userData(Connection connection, int user) {
        String query = "SELECT * from Customer WHERE UserID = " + user;
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String firstName = rs.getString("FirstName");
                String surName = rs.getString("SurName");
                Date dateOfBirth = rs.getDate("DateOfBirth");
                String gender = rs.getString("Gender");
                String email = rs.getString("Email");
                String subId = rs.getString("SubscriptionID");
                Date subDate = rs.getDate("SubscriptionDate");
                System.out.print("Vorname: ");
                System.out.println(firstName);
                System.out.print("Nachname: ");
                System.out.println(surName);
                System.out.print("Geburtstag: ");
                System.out.println(dateOfBirth);
                System.out.print("Geschlecht: ");
                System.out.println(gender);
                System.out.print("Email: ");
                System.out.println(email);
                System.out.print("Abo ID: ");
                System.out.println(subId);
                System.out.print("Abonniert seit: ");
                System.out.println(subDate);
            }
        } catch (SQLException e) {
            System.err.println("Fehler: " + e.getMessage());
        }

    }

    public void addFollower(Connection connection, String followFirst, String followLast, String followedFirst, String followedLast) {
        String queryFollow = "SELECT USERID FROM CUSTOMER WHERE FirstName = ? AND SurName = ?";
        String queryFollowed = "SELECT USERID FROM CUSTOMER WHERE FirstName = ? AND SurName = ?";
        int UserIDFollow = 99;
        int UserIDFollowed = 98;
        try (PreparedStatement ps = connection.prepareStatement(queryFollow)) {
            ps.setString(1, followFirst);
            ps.setString(2, followLast);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserIDFollow = rs.getInt("UserID");
            }
        } catch (SQLException e) {
            System.err.println("Fehler: " + e.getMessage());
        }
        try (PreparedStatement ps = connection.prepareStatement(queryFollowed)) {
            ps.setString(1, followedFirst);
            ps.setString(2, followedLast);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserIDFollowed = rs.getInt("UserID");
            }
        } catch (SQLException e) {
            System.err.println("Fehler: " + e.getMessage());
        }

        String queryRelation = "INSERT INTO FollowerRelation VALUES (?,?,CURRENT_DATE)";

        try (PreparedStatement ps = connection.prepareStatement(queryRelation)) {
            ps.setInt(1, UserIDFollow);
            ps.setInt(2, UserIDFollowed);
            ps.executeQuery();
            System.out.println("Erfolgreich Hinzugefügt!");
        } catch (SQLException e) {
            if (e.getErrorCode() == 2290) {
                System.out.print("Nutzer können sich selber nicht folgen");
            }
            if (e.getErrorCode() == 1) {
                System.out.print("Nutzer folgt dem Nutzer bereits");
            }
            if (e.getErrorCode() == 2291) {
                System.out.print("Nutzer nicht gefunden");
            }
        }

    }

    public void deepSearch(Connection connection, String first, String last) {
        String getUserIdQuery = "SELECT UserID FROM Customer WHERE FirstName = ? AND Surname = ?";
        String needQuery = "SELECT FollowedUserID FROM FollowerRelation WHERE UserID= ?";

        // Listen für Follower-Relationen
        int targetUserId;

        try (PreparedStatement ps = connection.prepareStatement(getUserIdQuery);
             Statement getFollowersStmt = connection.createStatement()) {

            // Hole die UserID des angegebenen Users
            ps.setString(1, first);
            ps.setString(2, last);
            ResultSet userIdResult = ps.executeQuery();

            if (!userIdResult.next()) {
                System.out.println("Kein Nutzer mit diesem Namen gefunden.");
                return;
            }

            targetUserId = userIdResult.getInt("UserID");

        } catch (SQLException e) {
            System.err.println("Fehler beim Laden der Daten: " + e.getMessage());
            return;
        }

        //TODO: Tiefensuche starten am besten mit Stack?
        Stack<Integer> need = new Stack<>();
        List<Integer> done = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        need.push(targetUserId);

        boolean firstCheck = true;
        while (!need.isEmpty()) {
            int current = need.pop();

            if (!done.contains(current)) {
                done.add(current);

                try (PreparedStatement ps = connection.prepareStatement(needQuery);
                     Statement stmt = connection.createStatement()) {

                    ps.setInt(1, current);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        need.push(rs.getInt("FollowedUserID"));
                        result.add(rs.getInt("FollowedUserID"));
                    }

                } catch (SQLException e) {
                    System.err.println("Fehler beim Laden der Daten: " + e.getMessage());
                    return;
                }
            }

        }
        System.out.println("Tiefensuche von " + first + " " + last);
        for (int userId : result) {

            System.out.println("UserID: " + userId + (userId == targetUserId ? " (Zielnutzer)" : ""));
        }
    }


}