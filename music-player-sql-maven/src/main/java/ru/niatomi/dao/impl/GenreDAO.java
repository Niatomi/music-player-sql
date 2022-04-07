package ru.niatomi.dao.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.niatomi.dao.GenericDAO;
import ru.niatomi.models.impl.Genre;

import java.sql.*;
import java.util.List;

/**
 * @author Niatomi
 */
@Component
@AllArgsConstructor
public class GenreDAO implements GenericDAO<Short, Genre> {
    
    private static final String UPDATE_QUERY = "UPDATE GENRE SET "
            + "NAME = ? "
            + "WHERE ID = ?";
    private static final String SELECT = "SELECT * FROM GENRE";
    private static final String SELECT_OFFSET_LIMIT = "SELECT "
            + "ID, "
            + "NAME "
            + "FROM GENRE "
            + "OFFSET ? ROWS "
            + "FETCH FIRST ? ROWS ONLY";
    private static final String FIND_BY_KEY = "SELECT "
            + "ID, "
            + "NAME "
            + "FROM GENRE "
            + "WHERE ID = ?";
    private static final String DELETE_BY_KEY = "DELETE FROM GENRE "
            + "WHERE ID = ?";
    private static final String INSERT = "INSERT INTO GENRE (NAME)" +
                                         " VALUES (?)";
    private static final String CREATE ="CREATE TABLE GENRE (" +
            " ID INT GENERATED ALWAYS AS IDENTITY," +
            " NAME VARCHAR(15) NOT NULL," +
            " PRIMARY KEY (ID)," +
            " UNIQUE(NAME)" +
            " )";
    private static final String DROP = "DROP TABLE GENRE";
    
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
    public List<Genre> select() {
        return null;
    }

    @Override
    public List<Genre> select(int offset, int limit) {
        return null;
    }

    @Override
    public Genre findByKey(Short aShort) {
        return null;
    }

    @Override
    public boolean removeByKey(Short aShort) {
        return false;
    }

    @Override
    public boolean insert(Genre genre) {
        return false;
    }

    @Override
    public boolean update(Integer key, Genre genre) {
        return false;
    }
    
}
