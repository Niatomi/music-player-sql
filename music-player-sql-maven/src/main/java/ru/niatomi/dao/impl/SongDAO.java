package ru.niatomi.dao.impl;

import java.sql.*;
import java.util.List;

import ru.niatomi.dao.GenericDAO;
import ru.niatomi.models.impl.Song;

/**
 * @author Niatomi
 */
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
    
    public SongDAO(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
    }

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

//    public void play(Integer key) {
//        System.out.println("Playing...");
//        PreparedStatement statement = null;
//        Connection connection = null;
//        ResultSet result = null;
//        int auditions = 0;
//        try {
//            connection = getConnection();
//            statement = connection.prepareStatement(SELECT_PLAY);
//            statement.setInt(1, key);
//            result = statement.executeQuery();
//            while (result.next()) auditions = result.getInt(1);
//            auditions++;
//            statement = connection.prepareStatement(PLAY);
//            statement.setInt(1, auditions);
//            statement.setInt(2, key);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        } finally {
//            try {
//                if(statement !=null){
//                    statement.close();
//                }
//                if(result !=null){
//                    result.close();
//                }
//                if(connection!=null){
//                    connection.close();
//                }
//            } catch (SQLException ex) {}
//        }
//    }
//
//    private Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(url, login, password);
//    }
//
//    private Song parseSong(ResultSet result) throws SQLException {
//        Song Song = new Song();
//        Song.setId(result.getInt(1));
//        Song.setName(result.getString(2));
//        Song.setArtistID(result.getInt(3));
//        Song.setGenreID(result.getInt(4));
//        Song.setAuditions(result.getInt(5));
//        return Song;
//    }
//
//    private List<Song> parseList(ResultSet result) throws SQLException {
//        List<Song> Song = new ArrayList<>();
//        while (result.next()) {
//            Song.add(parseSong(result));
//        }
//        return Song;
//    }
//
//    @Override
//    public void create() {
//        System.out.println("Creating new ru.niatomi.Substanses.impl.Song table...");
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
//            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
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
//
//
//    @Override
//    public List<Song> select() {
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
//    public List<Song> select(int offset, int limit) {
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
//    public Song findByKey(Integer key) {
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
//            return parseSong(result);
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
//    public boolean removeByKey(Integer key) {
//        System.out.println("Removing by key...");
//        PreparedStatement statement = null;
//        Connection connection = null;
//        try {
//            connection = getConnection();
//            statement = connection.prepareStatement("DELETE FROM PLAYLIST_SONGS WHERE SONG_ID = ?");
//            statement.setInt(1, key);
//            statement.executeUpdate();
//
//            statement = connection.prepareStatement(DELETE_BY_KEY);
//            statement.setInt(1, key);
//            return 0 != statement.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
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
//    public boolean insert(Song item) {
//        System.out.println("Inserting element...");
//        PreparedStatement statement = null;
//        Connection connection = null;
//        try {
//            connection = getConnection();
//            statement = connection.prepareStatement(INSERT);
//            statement.setString(1, item.getName());
//            statement.setInt(2, item.getArtistID());
//            statement.setInt(3, item.getGenreID());
//            statement.setInt(4, item.getAuditions());
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
//    public boolean update(Integer key, Song item) {
//        System.out.println("Updating element...");
//        PreparedStatement statement = null;
//        Connection connection = null;
//        try {
//            connection = getConnection();
//            statement = connection.prepareStatement(UPDATE_QUERY_SONG_ID);
//            statement.setString(1, item.getName());
//            statement.setInt(2, item.getArtistID());
//            statement.setInt(3, item.getGenreID());
//            statement.setInt(4, item.getAuditions());
//            statement.setInt(5, key);
//
//            return 0 != statement.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
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
//                System.err.println(e.getMessage());
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
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
//    public boolean updateSongName(Integer songID, String songName) {
//        System.out.println("Updating song name...");
//        Connection connection = null;
//        PreparedStatement statement = null;
//        try {
//            try {
//            connection = getConnection();
//            statement = connection.prepareStatement(UPDATE_QUERY_NAME_ID);
//            statement.setString(1, songName);
//            statement.setInt(2, songID);
//            statement.executeUpdate();
//            return 0 != statement.executeUpdate();
//            } catch (SQLSyntaxErrorException e) {
//                System.err.println(e.getMessage());
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
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
//    public boolean updateSongArtist(Integer songID, Artist artist) {
//        System.out.println("Updating song artist...");
//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet result = null;
//        try {
//            try {
//
//            connection = getConnection();
//
//            statement = connection.prepareStatement("SELECT ID FROM ARTIST WHERE NAME = ?");
//            statement.setString(1, artist.getName());
//            result = statement.executeQuery();
//
//            statement = connection.prepareStatement(UPDATE_QUERY_ARTIST_ID);
//            result.next();
//            statement.setInt(1, result.getInt(1));
//            statement.setInt(2, songID);
//            statement.executeUpdate();
//
//            return 0 != statement.executeUpdate();
//            } catch (SQLSyntaxErrorException e) {
//                System.err.println(e.getMessage());
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                if(statement !=null){
//                    statement.close();
//                }
//                if(connection!=null){
//                    connection.close();
//                }
//                if(result!=null){
//                    result.close();
//                }
//            } catch (SQLException ex) {}
//        }
//        return false;
//    }
//
//    public boolean updateSongGenre(Integer songID, Genre genre) {
//        System.out.println("Updating genre artist...");
//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet result = null;
//        try {
//            try {
//            connection = getConnection();
//
//            statement = connection.prepareStatement("SELECT ID FROM GENRE WHERE NAME = ?");
//            statement.setString(1, genre.getName());
//            result = statement.executeQuery();
//
//            statement = connection.prepareStatement(UPDATE_QUERY_GENRE_ID);
//            result.next();
//            statement.setInt(1, result.getInt(1));
//            statement.setInt(2, songID);
//            statement.executeUpdate();
//
//            return 0 != statement.executeUpdate();
//            } catch (SQLSyntaxErrorException e) {
//                System.err.println(e.getMessage());
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                if(statement !=null){
//                    statement.close();
//                }
//                if(connection!=null){
//                    connection.close();
//                }
//                if(result!=null){
//                    result.close();
//                }
//            } catch (SQLException ex) {}
//        }
//        return false;
//    }
//
//    public List<Song> findSongsByArtist(Integer artistID) {
//        System.out.println("Finding songs by artist...");
//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet result = null;
//        try {
//            try {
//            connection = getConnection();
//
//            statement = connection.prepareStatement("SELECT ID, NAME, ARTIST_ID, GENRE_ID, "
//                    + "AUDITIONS FROM SONG WHERE ARTIST_ID = ?");
//            statement.setInt(1, artistID);
//            result = statement.executeQuery();
//            return parseList(result);
//            } catch (SQLSyntaxErrorException e) {
//                System.err.println(e.getMessage());
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                if(statement !=null){
//                    statement.close();
//                }
//                if(connection!=null){
//                    connection.close();
//                }
//                if(result!=null){
//                    result.close();
//                }
//            } catch (SQLException ex) {}
//        }
//        return null;
//    }
//
//    public List<Song> findSongsByGenre(Integer genreID) {
//        System.out.println("Finding songs by genre...");
//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet result = null;
//        try {
//            try {
//            connection = getConnection();
//
//            statement = connection.prepareStatement("SELECT ID, NAME, ARTIST_ID, GENRE_ID, "
//                    + "AUDITIONS FROM SONG WHERE GENRE_ID = ?");
//            statement.setInt(1, genreID);
//            result = statement.executeQuery();
//            return parseList(result);
//            } catch (SQLSyntaxErrorException e) {
//                System.err.println(e.getMessage());
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                if(statement !=null){
//                    statement.close();
//                }
//                if(connection!=null){
//                    connection.close();
//                }
//                if(result!=null){
//                    result.close();
//                }
//            } catch (SQLException ex) {}
//        }
//        return null;
//    }
    
}
