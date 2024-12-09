import java.sql.*;

public class DataQueries {

    public static void followerAnzeigen(Connection connection, String first, String last) throws SQLException {
        String query = "SELECT B.FIRSTNAME, B.SURNAME FROM CUSTOMER A JOIN FOLLOWERRELATION FW ON A.USERID = FW.FOLLOWEDUSERID JOIN CUSTOMER B ON B.USERID = FW.USERID WHERE A.FIRSTNAME = ? AND A.SURNAME = ?";
        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, first);
            ps.setString(2, last);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String firstname = rs.getString("FIRSTNAME");
                String lastname = rs.getString("SURNAME");
                System.out.println(firstname + " " + lastname);
            }
        } catch (SQLException e){
            System.err.println("Fehler: " + e.getMessage());
        }

    }

    public static void songPlaylistUser(Connection connection, int creatorID) {
        String query = "SELECT s.SongID, s.SONGNAME FROM Song s " +
                       "JOIN SongPlaylistRelation spr ON s.SongID = spr.SongID " +
                       "JOIN Playlist p ON spr.PlaylistID = p.PlaylistID " +
                       "WHERE p.CreatorID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, creatorID);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Songs in playlists created by user " + creatorID + ":");
            while (rs.next()) {
                int songID = rs.getInt("SongID");
                String songName = rs.getString("SongName");
                System.out.println("Song ID: " + songID + ", SongName: " + songName);
            }
        } catch (SQLException e) {
            System.err.println("Fehler: " + e.getMessage());
        }
    }

    public static void userAlphabetic(Connection connection){
        String query = "SELECT * from Customer ORDER BY FirstName";
        try(Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                String firstName = rs.getString("FirstName");
                String surName = rs.getString("SurName");
                System.out.print("Vorname: ");
                System.out.print(firstName+" ");
                System.out.print("Nachname: ");
                System.out.println(surName);
            }
        } catch (SQLException e){
            System.err.println("Fehler: " + e.getMessage());
        }
    }

    public static void songAlbum(Connection connection, int albumID){
        String query = "SELECT Album.AlbumName AS AlbumName, Song.SongName AS SongName " +
                       "FROM Album " +
                       "JOIN Song ON Album.AlbumID = Song.AlbumID " +
                       "WHERE Album.AlbumID = " + albumID +
                       "ORDER BY SongName";
        try(Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Songs in Album " + albumID + ":");
            while (rs.next()){
                String songName = rs.getString("SongName");
                System.out.println(songName);
            }
        } catch (SQLException e){
            System.err.println("Fehler: " + e.getMessage());
        }
    }

    public static void userData(Connection connection, int user) {
        String query = "SELECT * from Customer WHERE UserID = "+ user;
        try(Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                String firstName = rs.getString("FirstName");
                String surName = rs.getString("SurName");
                Date dateOfBirth = rs.getDate("DateOfBirth");
                String gender = rs.getString("Gender");
                String email = rs.getString("Email");
                String subId= rs.getString("SubscriptionID");
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
        } catch (SQLException e){
            System.err.println("Fehler: " + e.getMessage());
        }

    }

    public static void addFollower(Connection connection, int userID, int followedUser) {
        String query = "INSERT INTO FollowerRelation VALUES ("+userID+","+followedUser+",CURRENT_DATE)";
        try(Statement stmt = connection.createStatement()){
            stmt.executeQuery(query);
            System.out.println("Erfolgreich hinzugefügt!");
        } catch (SQLException e){
            System.err.println("Fehler: " + e.getErrorCode());
            if(e.getErrorCode()==1){
                System.out.println("Relation Bereits vorhanden!");
            }
            if(e.getErrorCode()==2291){
                System.out.println("User nicht vorhanden!");
            }
        }

    }

    public static void deepSearch(Connection connection){
        String query = "SELECT * from Customer";
        try(Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                String firstName = rs.getString("FirstName");
                String surName = rs.getString("SurName");
                System.out.print("Vorname: ");
                System.out.print(firstName+" ");
                System.out.print("Nachname: ");
                System.out.println(surName);
            }
        } catch (SQLException e){
            System.err.println("Fehler: " + e.getMessage());
        }
    }

}