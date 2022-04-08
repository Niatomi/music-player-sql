package ru.niatomi.dao.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class GenreDAO implements GenericDAO<Integer, Genre> {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

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


    @Override
    public List<Genre> select() {
        return null;
    }

    @Override
    public List<Genre> select(int offset, int limit) {
        return null;
    }

    @Override
    public Genre findByKey(Integer key) {
        return null;
    }

    @Override
    public void removeByKey(Integer key) {

    }

    @Override
    public void insert(Genre genre) {

    }

    @Override
    public void update(Integer key, Genre genre) {

    }

    @Override
    public void create(Genre genre) {

    }
}
