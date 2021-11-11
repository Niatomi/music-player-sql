/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayersql.Classes.Generics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.SQLTransactionRollbackException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import musicplayersql.Classes.Substanses.Playlist;
import musicplayersql.Classes.Substanses.Song;

/**
 *
 * @author Niatomi
 */
public class PlaylistDAO implements GenericDAO<Integer, Playlist>{
    
    private static final String CREATE_1 ="CREATE TABLE PLAYLIST (" +
            " ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1000, INCREMENT BY 1)," +
            " NAME VARCHAR(30) NOT NULL," +
            " AUDITIONS INTEGER," +
            " PRIMARY KEY (ID)," +
            " UNIQUE(NAME)," +
            " CONSTRAINT CK_PLAYLIST_AUDITIONS CHECK(AUDITIONS>=0)" +
            " )";
    
    private static final String CREATE_2 ="CREATE TABLE PLAYLIST_SONGS (" +
            " ID INT GENERATED ALWAYS AS IDENTITY," +
            " PLAYLIST_ID INTEGER," +
            " SONG_ID INTEGER," + 
            " CONSTRAINT UQ_SONG_ID UNIQUE(SONG_ID)," +
            " CONSTRAINT FK_PLAYLIST_ID FOREIGN KEY(PLAYLIST_ID) REFERENCES PLAYLIST(ID)," +
            " CONSTRAINT FK_SONG_ID FOREIGN KEY(SONG_ID) REFERENCES SONG(ID)," +
            " PRIMARY KEY (ID)" +
            " )";
    
    private static final String DROP_1 = "DROP TABLE PLAYLIST";
    
    private static final String DROP_2 = "DROP TABLE PLAYLIST_SONGS";
    
    private static final String SELECT = "SELECT " +
            "P.ID, " + 
            "P.NAME, " +
            "P.AUDITIONS " +
            "FROM PLAYLIST AS P ";
    
    private static final String SELECT_OFFSET_LIMIT = "SELECT " +
            "P.ID, " + 
            "P.NAME, " +
            "P.AUDITIONS " +
            "FROM PLAYLIST AS P " +
            "OFFSET ? ROWS " + 
            "FETCH FIRST ? ROWS ONLY ";
    
    private static final String SELECT_SONGS = "SELECT " +
            "S.ID " +
            "FROM PLAYLIST_SONGS AS PS " +
            "INNER JOIN SONG AS S ON PS.Song_ID = S.ID " +
            "WHERE PS.PLAYLIST_ID = ?";
    
    private static final String SELECT_BY_KEY = "SELECT " +
            "P.ID, " + 
            "P.NAME, " +
            "P.AUDITIONS " +
            "FROM PLAYLIST AS P " +
            "WHERE ID = ? ";
    
    private static final String DELETE_PLAYLIST_BY_KEY = "DELETE FROM PLAYLIST "
            + "WHERE ID = ?";
    
    private static final String DELETE_SONGS_OF_PLAYLIST_BY_KEY = "DELETE FROM PLAYLIST_SONGS "
            + "WHERE PLAYLIST_ID = ?";
    
    private static final String INSERT_PLAYLIST = "INSERT INTO PLAYLIST (NAME, AUDITIONS)" +
                                         " VALUES (?, ?)";
    
    private static final String INSERT_SONG_INTO_PLAYLIST = "INSERT "
            + "INTO PLAYLIST_SONGS (PLAYLIST_ID, SONG_ID)" +
                                         " VALUES (?, ?)";
    
    private static final String GET_LAST_INDEX = "SELECT " +
            "ID " +
            "FROM PLAYLIST " +
            "WHERE ID = (SELECT MAX(ID) FROM PLAYLIST)";
    
    private static final String UPDATE_QUERY = "UPDATE PLAYLIST SET "
            + "NAME = ? ,"
            + "AUDITIONS = ? "
            + "WHERE ID = ?";
    
    private String url;
    private String login;
    private String password;
    
    public PlaylistDAO(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
    }
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, login, password);
    }
    
    @Override
    public void create() {
        System.out.println("Creating new Playlist table...");
        Connection connection = null;
        Statement statement = null;
        try {
            try {
                connection = getConnection();
                statement = connection.createStatement();
                statement.executeUpdate(CREATE_1);
                System.out.println("Table PLAYLIST created...");
                statement.executeUpdate(CREATE_2);
                System.out.println("Table PLAYLIST_SONGS created...");
            } catch (SQLTransactionRollbackException e) {
                System.err.println("Table already exist...");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(statement !=null){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException ex) {}
        }
    }

    @Override
    public void drop() {
        System.out.println("Deleting playlist table...");
        Connection connection = null;
        Statement statement = null;
        try {
            try {
                connection = getConnection();
                statement = connection.createStatement();
                statement.executeUpdate(DROP_2);
                System.out.println("Table PLAYLIST_SONGS deleted...");
                statement.executeUpdate(DROP_1);
                System.out.println("Table PLAYLIST deleted...");
            } catch (SQLTransactionRollbackException e) {
                System.err.println(e.getMessage());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(statement !=null){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException ex) {}
        }
    }
    
    private List<Integer> parseSong(ResultSet result) throws SQLException {
    List<Integer> songs = new ArrayList<>();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
        connection = getConnection();
        statement = connection.prepareStatement(SELECT_SONGS);
        statement.setInt(1, result.getInt(1));
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            songs.add(resultSet.getInt(1));
        }
        return songs;
    } catch (SQLTransactionRollbackException e) {
        System.err.println(e.getMessage());
    } finally {
            try {
            if(statement !=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException ex) {}
    }
        return null;
    }
    
    private Playlist parsePlaylist(ResultSet result) throws SQLException {
        Playlist playlist = new Playlist();
        List<Integer> songs = new ArrayList<>();
        songs = parseSong(result);
        playlist.setId(result.getInt(1));
        playlist.setName(result.getString(2));
        playlist.setSongs(songs);
        playlist.setAuditions(result.getInt(3));
        return playlist;
    }
    
    private List<Playlist> parseList(ResultSet result) throws SQLException {
        List<Playlist> Playlist = new ArrayList<>();
        while (result.next()) {
            Playlist.add(parsePlaylist(result));
        }
        return Playlist;
    }
    
    @Override
    public List<Playlist> select() {
        System.out.println("Selecting playlist table with offset...");
        Connection connection = null;
        ResultSet result = null;
        Statement statement = null;
        try {
            try {
                connection = getConnection();
                statement = connection.createStatement();
                result = statement.executeQuery(SELECT);
                return parseList(result);
            } catch (SQLTransactionRollbackException e) {
                System.err.println(e.getSQLState());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(statement !=null){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
                if(result!=null){
                    result.close();
                }
            } catch (SQLException ex) {}
        }
        return new ArrayList<>();
    }

    @Override
    public List<Playlist> select(int offset, int limit) {
        System.out.println("Selecting playlist table...");
        Connection connection = null;
        ResultSet result = null;
        PreparedStatement statement = null;
        try {
            try {
                connection = getConnection();
                statement = connection.prepareStatement(SELECT_OFFSET_LIMIT);
                statement.setInt(1, offset);
                statement.setInt(2, limit);
                result = statement.executeQuery();
                return parseList(result);
            } catch (SQLTransactionRollbackException e) {
                System.err.println(e.getSQLState());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(statement !=null){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
                if(result!=null){
                    result.close();
                }
            } catch (SQLException ex) {}
        }
        return new ArrayList<>();
    }

    @Override
    public Playlist findByKey(Integer key) {
        System.out.println("Find playlist table...");
        Connection connection = null;
        ResultSet result = null;
        PreparedStatement statement = null;
        List<Integer> songs = new ArrayList<>();
        Playlist playlist = new Playlist();
        try {
            try {
                connection = getConnection();
                statement = connection.prepareStatement(SELECT_BY_KEY);
                statement.setInt(1, key);
                result = statement.executeQuery();
                result.next();
                songs = parseSong(result);
                playlist.setId(result.getInt(1));
                playlist.setName(result.getString(2));
                playlist.setSongs(songs);
                playlist.setAuditions(result.getInt(3));
                return playlist;
            } catch (SQLTransactionRollbackException e) {
                System.err.println(e.getSQLState());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(statement !=null){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
                if(result!=null){
                    result.close();
                }
            } catch (SQLException ex) {}
        }
        return null;
    }

    @Override
    public boolean removeByKey(Integer key) {
        System.out.println("Remove playlist table...");
        Connection connection = null;
        ResultSet result = null;
        PreparedStatement statement = null;
        try {
            try {
                connection = getConnection();
                statement = connection.prepareStatement(DELETE_SONGS_OF_PLAYLIST_BY_KEY);
                statement.setInt(1, key);
                statement.executeUpdate();
                statement = connection.prepareStatement(DELETE_PLAYLIST_BY_KEY);
                statement.setInt(1, key);
                return 0 != statement.executeUpdate();
            } catch (SQLTransactionRollbackException e) {
                System.err.println(e.getSQLState());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(statement !=null){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
                if(result!=null){
                    result.close();
                }
            } catch (SQLException ex) {}
        }
        return false;
    }

    @Override
    public boolean insert(Playlist item) {
        System.out.println("Insert into playlist table...");
        Connection connection = null;
        List<Integer> songs = item.getSongs();
        ResultSet result = null;
        PreparedStatement statement = null;
        try {
            try {
                connection = getConnection();
                statement = connection.prepareStatement(INSERT_PLAYLIST);
                statement.setString(1, item.getName());
                statement.setInt(2, item.getAuditions());
                statement.executeUpdate();
                statement = connection.prepareStatement(GET_LAST_INDEX);
                result = statement.executeQuery();
                statement = connection.prepareStatement(INSERT_SONG_INTO_PLAYLIST);
                result.next();
                for (Integer s : songs) {
                    statement.setInt(1, result.getInt(1));
                    statement.setInt(2, s);
                    statement.executeUpdate();
                }
                return true;
            } catch (SQLTransactionRollbackException e) {
                System.err.println(e.getSQLState());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(statement !=null){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
                if(result!=null){
                    result.close();
                }
            } catch (SQLException ex) {}
        }
        return false;
    }

    @Override
    public boolean update(Integer key, Playlist item) {
        System.out.println("Insert into playlist table...");
        Connection connection = null;
        List<Integer> songs = item.getSongs();
        ResultSet result = null;
        PreparedStatement statement = null;
        try {
            try {
                connection = getConnection();
                
                statement = connection.prepareStatement("SELECT ID FROM PLAYLIST WHERE NAME = ?");
                statement.setString(1, item.getName());
                result = statement.executeQuery();
                result.next();
                int index = result.getInt(1);
                
                statement = connection.prepareStatement(DELETE_SONGS_OF_PLAYLIST_BY_KEY);
                statement.setInt(1, index);
                statement.executeUpdate();
                
                result.next();
                statement = connection.prepareStatement(UPDATE_QUERY);
                statement.setString(1, item.getName());
                statement.setInt(2, item.getAuditions());
                statement.setInt(3, index);
                statement.executeUpdate();
                
                
                statement = connection.prepareStatement(INSERT_SONG_INTO_PLAYLIST);
                result.next();
                for (Integer s : songs) {
                    statement.setInt(1, index);
                    statement.setInt(2, s);
                    statement.executeUpdate();
                }
                return true;
            } catch (SQLTransactionRollbackException e) {
                System.err.println(e.getSQLState());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(statement !=null){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
                if(result!=null){
                    result.close();
                }
            } catch (SQLException ex) {}
        }
        return false;
    }
    
    public void play(Integer key) {
        System.out.println("Playing playlist table...");
        Connection connection = null;
        ResultSet result = null;
        PreparedStatement statement = null;
        try {
            try {
                connection = getConnection();
                
                statement = connection.prepareStatement("SELECT AUDITIONS FROM PLAYLIST WHERE ID = ?");
                statement.setInt(1, key);
                result = statement.executeQuery();
                result.next();
                int auditions = result.getInt(1);
                auditions++;
                
                statement = connection.prepareStatement("UPDATE PLAYLIST SET AUDITIONS = ?"
                        + "WHERE ID = ?");
                statement.setInt(1, auditions);
                statement.setInt(2, key);
                statement.executeUpdate();
                
            } catch (SQLTransactionRollbackException e) {
                System.err.println(e.getSQLState());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(statement !=null){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
                if(result!=null){
                    result.close();
                }
            } catch (SQLException ex) {}
        }
    }
    
    
    
}
