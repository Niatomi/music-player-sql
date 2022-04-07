package ru.niatomi.dao.impl;


import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.niatomi.dao.GenericDAO;
import ru.niatomi.models.impl.Artist;

import java.sql.*;
import java.util.List;

/**
 * @author Niatomi
 */
@Component
@AllArgsConstructor
public class ArtistDAO implements GenericDAO<Short, Artist> {
    private static final String UPDATE_QUERY = "UPDATE ARTIST SET "
            + "NAME = ? "
            + "WHERE ID = ?";
    private static final String SELECT = "SELECT * FROM ARTIST";
    private static final String SELECT_OFFSET_LIMIT = "SELECT "
            + "ID, "
            + "NAME "
            + "FROM ARTIST "
            + "OFFSET ? ROWS "
            + "FETCH FIRST ? ROWS ONLY";
    private static final String FIND_BY_KEY = "SELECT "
            + "ID, "
            + "NAME "
            + "FROM ARTIST "
            + "WHERE ID = ?";
    private static final String DELETE_BY_KEY = "DELETE FROM ARTIST "
            + "WHERE ID = ?";
    private static final String INSERT = "INSERT INTO ARTIST (NAME)" +
                                         " VALUES (?)";
    private static final String CREATE ="CREATE TABLE ARTIST (" +
            " ID INT GENERATED ALWAYS AS IDENTITY," +
            " NAME VARCHAR(30) NOT NULL," +
            " PRIMARY KEY (ID)," +
            " UNIQUE(NAME)" +
            " )";
    private static final String DROP = "DROP TABLE ARTIST";
    
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
    public List<Artist> select() {
        return null;
    }

    @Override
    public List<Artist> select(int offset, int limit) {
        return null;
    }

    @Override
    public Artist findByKey(Short aShort) {
        return null;
    }

    @Override
    public boolean removeByKey(Short aShort) {
        return false;
    }

    @Override
    public boolean insert(Artist artist) {
        return false;
    }

    @Override
    public boolean update(Integer key, Artist artist) {
        return false;
    }
    
}
