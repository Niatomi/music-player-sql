package ru.niatomi.dao.impl;

import java.sql.*;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.niatomi.dao.GenericDAO;
import ru.niatomi.models.impl.Playlist;

/**
 * @author Niatomi
 */
@Component
@AllArgsConstructor
public class PlaylistDAO implements GenericDAO<Integer, Playlist> {
    
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
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, login, password);
    }

    @Override
    public void create() {

    }

    @Override
    public void drop() {

    }

    @Override
    public List<Playlist> select() {
        return null;
    }

    @Override
    public List<Playlist> select(int offset, int limit) {
        return null;
    }

    @Override
    public Playlist findByKey(Integer integer) {
        return null;
    }

    @Override
    public boolean removeByKey(Integer integer) {
        return false;
    }

    @Override
    public boolean insert(Playlist playlist) {
        return false;
    }

    @Override
    public boolean update(Integer key, Playlist playlist) {
        return false;
    }

}
