/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayersql.Classes.Substanses;

/**
 *
 * @author Niatomi
 */
public class Song implements Playable {
    
    private int id;
    private String name;
    private int auditions;
    private String artist;
    private String genre;
    private int artistID;
    private int genreID;
    
    public boolean play() {
       this.auditions = auditions + 1;
       return true;
    }

    public Song() {
    }
    
    
    
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public Song(String name, int artistID, int genreID, int auditions) {
        this.name = name;
        this.genreID = genreID;
        this.artistID = artistID;
        this.auditions = auditions;
    }
    
    public Song(int id, String name,  int artistID, int genreID, int auditions) {
        this.id = id;
        this.name = name;
        this.genreID = genreID;
        this.artistID = artistID;
        this.auditions = auditions;
    }
    
    public int getId() {
        return id;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    public Song(int id, String name,  String artist, String genreID, int auditions) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.artist = artist;
        this.auditions = auditions;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getAuditions() {
        return auditions;
    }

    public void setAuditions(int auditions) {
        this.auditions = auditions;
    }

    @Override
    public String toString() {
        return "Song{" + "id=" + id + ", name=" + name + ", auditions=" + auditions + ", artistID=" + artistID + ", genreID=" + genreID + '}';
    }

    
    
}
