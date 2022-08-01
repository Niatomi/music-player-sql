package ru.niatomi.dao.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

    @Override
    public List<Genre> select() {
        return jdbcTemplate.query(SELECT, new BeanPropertyRowMapper<>(Genre.class));
    }

    @Override
    public List<Genre> selectWithOffset(int offset, int limit) {
        return jdbcTemplate.query(SELECT_OFFSET_LIMIT, new Object[]{offset, limit}, new BeanPropertyRowMapper<>(Genre.class));
    }

    @Override
    public Genre findByKey(Integer key) {
        return jdbcTemplate.query(FIND_BY_KEY, new Object[]{key}, new BeanPropertyRowMapper<>(Genre.class))
                .stream()
                .findAny()
                .orElse(null);
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
