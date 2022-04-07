package ru.niatomi.dao.impl;

import ru.niatomi.dao.GenericDAO;
import ru.niatomi.models.impl.Genre;

import java.sql.*;
import java.util.List;

/**
 * @author Niatomi
 */
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
    
    public GenreDAO(String url, String login, String password) {
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

//    private Genre parseGenre(ResultSet result) throws SQLException {
//        Genre genre = new Genre();
//        genre.setId(result.getInt(1));
//        genre.setName(result.getString(2));
//        return genre;
//    }
//
//    private List<Genre> parseList(ResultSet result) throws SQLException {
//        List<Genre> genre = new ArrayList<>();
//        while (result.next()) {
//            genre.add(parseGenre(result));
//        }
//        return genre;
//    }
//
//    @Override
//    public void create() {
//        System.out.println("Creating new genre table...");
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
//            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
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
//    public List<Genre> select() {
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
//    public List<Genre> select(int offset, int limit) {
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
//    public Genre findByKey(Short key) {
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
//            return parseGenre(result);
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
//    public boolean insert(Genre item) {
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
//    public boolean update(Integer key, Genre item) {
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
//            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
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
