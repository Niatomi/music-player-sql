package ru.niatomi.dao.impl;

import java.sql.*;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.niatomi.dao.GenericDAO;
import ru.niatomi.models.impl.Song;

/**
 * @author Niatomi
 */
@Component
@AllArgsConstructor
public class SongDAO implements GenericDAO<Integer, Song> {
    
    private static final String UPDATE_QUERY_SONG_ID = "UPDATE SONG SET "
            + "SONG.NAME = ? , "
            + "ARTIST_ID = ?, "
            + "GENRE_ID = ?, "
            + "AUDITIONS = ? "
            + "WHERE ID = ?";
    
    private static final String UPDATE_QUERY_NAME_ID = "UPDATE SONG SET "
            + "NAME = ? "
            + "WHERE ID = ?";
    
    private static final String UPDATE_QUERY_ARTIST_ID = "UPDATE SONG SET "
            + "ARTIST_ID = ? "
            + "WHERE GENRE_ID = ?";
    
    private static final String UPDATE_QUERY_GENRE_ID = "UPDATE SONG SET "
            + "GENRE_ID = ? "
            + "WHERE ID = ?";
    
    private static final String SELECT = "SELECT * FROM SONG";
    
    private static final String SELECT_PLAY = "SELECT AUDITIONS FROM SONG WHERE ID = ?";
    
    private static final String SELECT_OFFSET_LIMIT = "SELECT "
            + "ID, "
            + "NAME, "
            + "ARTIST_ID, "
            + "GENRE_ID, "
            + "AUDITIONS "            
            + "FROM SONG "
            + "OFFSET ? ROWS "
            + "FETCH FIRST ? ROWS ONLY";
    
    private static final String FIND_BY_KEY = "SELECT "
            + "ID, "
            + "NAME, "
            + "ARTIST_ID, "
            + "GENRE_ID, "
            + "AUDITIONS "  
            + "FROM SONG "
            + "WHERE ID = ?";
    
    private static final String DELETE_BY_KEY = "DELETE FROM SONG "
            + "WHERE ID = ?";
    
    private static final String PLAY = "UPDATE SONG SET AUDITIONS = ? WHERE ID = ? ";
    
    private static final String INSERT = "INSERT INTO STUD.SONG (NAME, ARTIST_ID, GENRE_ID, AUDITIONS)" +
                                         " VALUES (?, ?, ?, ?)";
    
    private static final String CREATE ="CREATE TABLE SONG(" +
        " ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH" +
        " 10000000, INCREMENT BY 1)," +
        " NAME VARCHAR(30) NOT NULL," +
        " ARTIST_ID INTEGER NOT NULL," +
        " GENRE_ID INTEGER NOT NULL," +
        " AUDITIONS INTEGER DEFAULT 0," +
        " CONSTRAINT PK_SONG_ID PRIMARY KEY(ID)," +
        " CONSTRAINT FK_SONG_ARTIST_ID FOREIGN KEY(ARTIST_ID) REFERENCES" +
        " ARTIST(ID)," +
        " CONSTRAINT FK_SONG_GENRE_ID FOREIGN KEY(GENRE_ID) REFERENCES" +
        " GENRE(ID)," +
        " CONSTRAINT CK_SONG_AUDITIONS CHECK(AUDITIONS >= 0)" +
        ")";
    
    private static final String DROP = "DROP TABLE SONG";
    
    private String url;
    private String login;
    private String password;

    @Override
    public void create() {

    }

    @Override
    public void drop() {

    }

    @Override
    public List<Song> select() {
        return null;
    }

    @Override
    public List<Song> select(int offset, int limit) {
        return null;
    }

    @Override
    public Song findByKey(Integer integer) {
        return null;
    }

    @Override
    public boolean removeByKey(Integer integer) {
        return false;
    }

    @Override
    public boolean insert(Song song) {
        return false;
    }

    @Override
    public boolean update(Integer key, Song song) {
        return false;
    }
    
}
