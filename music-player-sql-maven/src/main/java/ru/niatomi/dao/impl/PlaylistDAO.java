package ru.niatomi.dao.impl;

import java.sql.*;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.niatomi.dao.GenericDAO;
import ru.niatomi.models.impl.Playlist;

/**
 * @author Niatomi
 */
@Component
@AllArgsConstructor
public class PlaylistDAO implements GenericDAO<Integer, Playlist> {

    @Autowired
    private final JdbcTemplate jdbcTemplate;
    
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

    @Override
    public List<Playlist> select() {
        return null;
    }

    @Override
    public List<Playlist> selectWithOffset(int offset, int limit) {
        return null;
    }

    @Override
    public Playlist findByKey(Integer key) {
        return null;
    }

    @Override
    public void removeByKey(Integer key) {

    }

    @Override
    public void insert(Playlist playlist) {

    }

    @Override
    public void update(Integer key, Playlist playlist) {

    }

    @Override
    public void create(Playlist playlist) {

    }
}
