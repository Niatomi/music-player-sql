package ru.niatomi.dao.impl;

import java.sql.*;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.niatomi.dao.GenericDAO;
import ru.niatomi.models.impl.Song;

/**
 * @author Niatomi
 */
@Component
@AllArgsConstructor
public class SongDAO implements GenericDAO<Integer, Song> {

    @Autowired
    private final JdbcTemplate jdbcTemplate;
    
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

    @Override
    public List<Song> select() {
        return null;
    }

    @Override
    public List<Song> selectWithOffset(int offset, int limit) {
        return null;
    }

    @Override
    public Song findByKey(Integer key) {
        return null;
    }

    @Override
    public void removeByKey(Integer key) {

    }

    @Override
    public void insert(Song song) {

    }

    @Override
    public void update(Integer key, Song song) {

    }

    @Override
    public void create(Song song) {

    }
}
