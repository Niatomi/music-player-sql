package ru.niatomi.dao.impl;


import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class ArtistDAO implements GenericDAO<Integer, Artist> {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

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
    private static final String REMOVE_BY_KEY = "DELETE FROM ARTIST "
            + "WHERE ID = ?";
    private static final String INSERT = "INSERT INTO ARTIST (NAME)" +
                                         " VALUES (?)";


    @Override
    public List<Artist> select() {
        return jdbcTemplate.query(SELECT, new BeanPropertyRowMapper<>(Artist.class));
    }

    @Override
    public List<Artist> selectWithOffset(int offset, int limit) {
        return jdbcTemplate.query(SELECT_OFFSET_LIMIT, new Object[]{offset, limit}, new BeanPropertyRowMapper<>(Artist.class));
    }

    @Override
    public Artist findByKey(Integer key) {
        return jdbcTemplate.query(FIND_BY_KEY, new Object[]{key}, new BeanPropertyRowMapper<>(Artist.class))
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public void removeByKey(Integer key) {
        jdbcTemplate.update(REMOVE_BY_KEY, key);
    }

    @Override
    public void insert(Artist artist) {
        jdbcTemplate.update(INSERT, artist.getName());
    }

    @Override
    public void update(Integer key, Artist artist) {
        jdbcTemplate.update(UPDATE_QUERY, artist.getName(), key);
    }

    @Override
    public void create(Artist artist) {

    }


}
