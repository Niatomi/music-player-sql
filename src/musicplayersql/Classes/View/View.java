/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayersql.Classes.View;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import musicplayersql.Classes.Generics.ArtistDAO;
import musicplayersql.Classes.Generics.GenreDAO;
import musicplayersql.Classes.Generics.SongDAO;
import musicplayersql.Classes.Substanses.Artist;
import musicplayersql.Classes.Substanses.Genre;
import musicplayersql.Classes.Substanses.Song;
import musicplayersql.Classes.VIEW.Viewable;
/**
 *
 * @author Niatomi
 */
public class View implements Viewable{
//    NAME, ARTIST, GENRE, AUDIT
    private static final String SONG_VIEW = "SELECT \n" +
        "    S.ID, \n" +
        "    S.NAME, \n" +
        "    A.NAME,\n" +
        "    G.NAME,\n" +
        "    S.AUDITIONS \n" +
        "    FROM SONG AS S \n" +
        "    INNER JOIN ARTIST AS A ON S.Artist_ID = A.ID \n" +
        "    INNER JOIN GENRE AS G ON S.Genre_ID = G.ID ";
    
    private static final String PLAYLSIT_SONG_VIEW = "SELECT  \n" +
        "    P.ID,\n" +
        "    S.ID,\n" +
        "    S.NAME,\n" +
        "    A.NAME,\n" +
        "    G.NAME,\n" +
        "    S.AUDITIONS,\n" +
        "    P.AUDITIONS\n" +
        "    FROM PLAYLIST_SONGS AS PS  \n" +
        "    INNER JOIN PLAYLIST AS P ON PS.Playlist_ID = P.ID    \n" +
        "    INNER JOIN SONG AS S ON PS.Song_ID = S.ID    \n" +
        "    INNER JOIN ARTIST AS A ON S.Artist_ID = A.ID\n" +
        "    INNER JOIN GENRE AS G ON S.GENRE_ID = G.ID\n" +
        "    ";
    
    private String url;
    private String login;
    private String password;

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, login, password);
    }
    
    public View(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
    }
    
    @Override
    public void song_view() {
        System.out.println("Song view...");
        PreparedStatement statement = null;
        ResultSet result = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(SONG_VIEW);
            result = statement.executeQuery();
            while (result.next()) {
                System.out.println("/==========/");
                System.out.println("ID = " + result.getInt(1));
                System.out.println("Name = "  + result.getString(2));
                System.out.println("Genre = " + result.getString(3));
                System.out.println("Artist = " + result.getString(4));
                System.out.println("Auditions = " + result.getInt(5));
                System.out.println("/==========/\n");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if(statement !=null){
                    statement.close();
                }
                if(statement !=null){
                    result.close();
                }
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException ex) {}
        }
    }

    @Override
    public void playlist_song_view() {
        System.out.println("Playlist view...");
        PreparedStatement statement = null;
        ResultSet result = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(PLAYLSIT_SONG_VIEW);
            result = statement.executeQuery();
            while (result.next()) {
                System.out.println("/==========/");
                System.out.println("Playlist ID = " + result.getInt(1));
                System.out.println("Song ID = " + result.getInt(2));
                System.out.println("Name = " + result.getString(3));
                System.out.println("Artist = " + result.getString(4));
                System.out.println("Genre = " + result.getString(5));
                System.out.println("Auditions = " + result.getInt(6));
                System.out.println("Auditions of playlist = " + result.getInt(7));
                System.out.println("/==========/\n");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if(statement !=null){
                    statement.close();
                }
                if(statement !=null){
                    result.close();
                }
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException ex) {}
        }
    }
    
}
