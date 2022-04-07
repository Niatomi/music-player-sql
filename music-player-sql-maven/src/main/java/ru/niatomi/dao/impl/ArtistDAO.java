package ru.niatomi.dao.impl;


import ru.niatomi.dao.GenericDAO;
import ru.niatomi.models.impl.Artist;

import java.sql.*;
import java.util.List;

/**
 * @author Niatomi
 */
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
    
    public ArtistDAO(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
    }
    
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

//    private Artist parseArtist(ResultSet result) throws SQLException {
//        Artist artist = new Artist();
//        artist.setId(result.getInt(1));
//        artist.setName(result.getString(2));
//        return artist;
//    }
//
//    private List<Artist> parseList(ResultSet result) throws SQLException {
//        List<Artist> artist = new ArrayList<>();
//        while (result.next()) {
//            artist.add(parseArtist(result));
//        }
//        return artist;
//    }
//
//    @Override
//    public void create() {
//        System.out.println("Creating new Artist table...");
//        Connection connection = null;
//        Statement statement = null;
//        try {
//            try {
//                connection = getConnection();
//                statement = connection.createStatement();
//                statement.executeUpdate(CREATE);
//                System.out.println("New table created...");
//            } catch (SQLTransactionRollbackException e) {
//                System.err.println("Table already exist...");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ArtistDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                if(statement !=null){
//                    statement.close();
//                }
//                if(connection!=null){
//                    connection.close();
//                }
//            } catch (SQLException ex) {}
//        }
//    }
//
//    @Override
//    public List<Artist> select() {
//        System.out.println("Selecting table elements...");
//        PreparedStatement statement = null;
//        ResultSet result = null;
//        Connection connection = null;
//        try {
//            connection = getConnection();
//            statement = connection.prepareStatement(SELECT);
//            result = statement.executeQuery();
//            return parseList(result);
//        } catch (SQLException e) {
//        } finally {
//            try {
//                if(statement !=null){
//                    statement.close();
//                }
//                if(statement !=null){
//                    result.close();
//                }
//                if(connection!=null){
//                    connection.close();
//                }
//            } catch (SQLException ex) {}
//        }
//        return new ArrayList<>();
//    }
//
//    @Override
//    public List<Artist> select(int offset, int limit) {
//        System.out.println("Selecting table elements by offset...");
//        PreparedStatement statement = null;
//        ResultSet result = null;
//        Connection connection = null;
//        try {
//            connection = getConnection();
//            statement = connection.prepareStatement(SELECT_OFFSET_LIMIT);
//            statement.setInt(1, offset);
//            statement.setInt(2, limit);
//            result = statement.executeQuery();
//            return parseList(result);
//        } catch (SQLException e) {
//        } finally {
//            try {
//                if(statement !=null){
//                    statement.close();
//                }
//                if(statement !=null){
//                    result.close();
//                }
//                if(connection!=null){
//                    connection.close();
//                }
//            } catch (SQLException ex) {}
//        }
//        return new ArrayList<>();
//    }
//
//    @Override
//    public Artist findByKey(Short key) {
//        System.out.println("Finding by key...");
//        PreparedStatement statement = null;
//        ResultSet result = null;
//        Connection connection = null;
//        try {
//            connection = getConnection();
//            statement = connection.prepareStatement(FIND_BY_KEY);
//            statement.setInt(1, key);
//            result = statement.executeQuery();
//            result.next();
//            return parseArtist(result);
//        } catch (SQLException e) {
//        } finally {
//            try {
//                if(statement !=null){
//                    statement.close();
//                }
//                if(statement !=null){
//                    result.close();
//                }
//                if(connection!=null){
//                    connection.close();
//                }
//            } catch (SQLException ex) {}
//        }
//        return null;
//    }
//
//    @Override
//    public boolean removeByKey(Short key) {
//        System.out.println("Removing by key...");
//        PreparedStatement statement = null;
//        Connection connection = null;
//        try {
//            connection = getConnection();
//            statement = connection.prepareStatement(DELETE_BY_KEY);
//            statement.setInt(1, key);
//            return 0 != statement.executeUpdate();
//        } catch (SQLException e) {
//        } finally {
//            try {
//                if(statement !=null){
//                    statement.close();
//                }
//                if(connection!=null){
//                    connection.close();
//                }
//            } catch (SQLException ex) {}
//        }
//        return false;
//    }
//
//    @Override
//    public boolean insert(Artist item) {
//        System.out.println("Inserting element...");
//        PreparedStatement statement = null;
//        Connection connection = null;
//        try {
//            connection = getConnection();
//            statement = connection.prepareStatement(INSERT);
//            statement.setString(1, item.getName());
//            return 0 != statement.executeUpdate();
//        } catch (SQLException e) {
//        } finally {
//            try {
//                if(statement !=null){
//                    statement.close();
//                }
//                if(connection!=null){
//                    connection.close();
//                }
//            } catch (SQLException ex) {}
//        }
//        return false;
//    }
//
//    @Override
//    public boolean update(Integer key, Artist item) {
//        System.out.println("Updating element...");
//        PreparedStatement statement = null;
//        Connection connection = null;
//        try {
//            connection = getConnection();
//            statement = connection.prepareStatement(UPDATE_QUERY);
//            statement.setString(1, item.getName());
//            statement.setInt(2, key);
//            statement.executeUpdate();
//            return 0 != statement.executeUpdate();
//        } catch (SQLException e) {
//        } finally {
//            try {
//                if(statement !=null){
//                    statement.close();
//                }
//                if(connection!=null){
//                    connection.close();
//                }
//            } catch (SQLException ex) {}
//        }
//        return false;
//    }
//
//    @Override
//    public void drop() {
//        System.out.println("Deleting table...");
//        Connection connection = null;
//        Statement statement = null;
//        try {
//            try {
//                connection = getConnection();
//                statement = connection.createStatement();
//                statement.executeUpdate(DROP);
//                System.out.println("Table deleted...");
//            } catch (SQLSyntaxErrorException e) {
//                System.err.println("No table to delete...");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ArtistDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                if(statement !=null){
//                    statement.close();
//                }
//                if(connection!=null){
//                    connection.close();
//                }
//            } catch (SQLException ex) {}
//        }
//    }
    
}
