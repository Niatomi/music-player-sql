/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayersql.Classes.Substanses;

import java.util.List;

/**
 *
 * @author Niatomi
 */
public class Playlist implements Playable {
    private int id;
    private String name;
    private List<Integer> songs;
    private int auditions;
    
    public boolean play() {
        this.auditions = auditions + 1;
        return true;
    }

    public Playlist() {
    }
    
    public Playlist(String name, List<Integer> songs, int auditions) {
        this.name = name;
        this.songs = songs;
        this.auditions = auditions;
    }
    
    public List<Integer> getSongs() {
        return songs;
    }

    public void setSongs(List<Integer> songs) {
        this.songs = songs;
    }

    public int getId() {
        return id;
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
        return "Playlist{" + "id=" + id + ", name=" + name + ", songs=" + songs + ", auditions=" + auditions + '}';
    }
    
}
